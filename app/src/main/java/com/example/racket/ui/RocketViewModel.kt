package com.example.racket.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData
import com.example.racket.domain.usecase.rocket.GetRocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RocketViewModel @Inject constructor(private val getRocketUseCase: GetRocketUseCase) : ViewModel() ,
    LifecycleObserver {

    private val _rocket: MutableLiveData<List<Model.Rocket>> = MutableLiveData()
    val rocket: LiveData<List<Model.Rocket>> = _rocket


    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    private val _failure: MutableLiveData<String> = MutableLiveData()
    val failure: LiveData<String> = _failure

    private var _error: MutableLiveData<Throwable> = MutableLiveData()
    val error: LiveData<Throwable> = _error


    init {
        get()
    }

    private fun get() {
        viewModelScope.launch {
            Log.d("Viewmodel","Call View Model Get***")
            _loading.postValue(true)
            when (val result = getRocketUseCase.execute(Unit)) {
                is ResultData.Success -> {
                    _rocket.value = result.value
                    _loading.postValue(true)

                }
                is ResultData.Failure -> {
                    _failure.postValue(result.message)
                    _loading.postValue(true)

                }
                is ResultData.Error -> {
                    _error.postValue(result.throwable)
                    _loading.postValue(true)
                }
            }
        }
    }
}