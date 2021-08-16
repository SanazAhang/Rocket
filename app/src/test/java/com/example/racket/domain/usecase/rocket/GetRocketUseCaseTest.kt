package com.example.racket.domain.usecase.rocket

import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before

class GetRocketUseCaseTest{

    private val rockets = listOf<Model.Rocket>()
    private val result = ResultData.Success(rockets)
    private lateinit var repository: FakeRepository

    @Before
    fun createRepository(){
        repository = FakeRepository(rockets)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getRocket_execute()= runBlockingTest{
        val value = repository.get()
        assertThat(value, `is`(result))
    }
}