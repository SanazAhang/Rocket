package com.example.racket.ui.rocketList

import android.util.Log
import androidx.lifecycle.*
import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData
import com.example.racket.domain.usecase.rocket.GetRocketUseCase
import com.example.racket.ui.rocketList.ConsumableValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RocketViewModel @Inject constructor(private val getRocketUseCase: GetRocketUseCase) :
    ViewModel(),
    LifecycleObserver {

    private val _rocket: MutableLiveData<ConsumableValue<List<Model.Rocket>>> = MutableLiveData()
    val rocket: LiveData<ConsumableValue<List<Model.Rocket>>> = _rocket


    private val _loading: MutableLiveData<ConsumableValue<Boolean>> = MutableLiveData()
    val loading: LiveData<ConsumableValue<Boolean>> = _loading

    private val _failure: MutableLiveData<ConsumableValue<String>> = MutableLiveData()
    val failure: LiveData<ConsumableValue<String>> = _failure

    private var _error: MutableLiveData<ConsumableValue<Throwable>> = MutableLiveData()
    val error: LiveData<ConsumableValue<Throwable>> = _error


    init {
        get()
    }

    private fun get() {
        viewModelScope.launch {
            Log.d("Viewmodel", "Call View Model Get***")
            _loading.value = ConsumableValue(true)
            when (val result = getRocketUseCase.execute(Unit)) {
                is ResultData.Success -> {
                    _rocket.value = ConsumableValue(result.value)
                    _loading.value = ConsumableValue(false)

                }
                is ResultData.Failure -> {
                    _failure.value = ConsumableValue(result.message)
                    _loading.value = ConsumableValue(false)

                }
                is ResultData.Error -> {
                    _error.value = ConsumableValue(result.throwable)
                    _loading.value = ConsumableValue(false)
                }
            }
        }
    }
}