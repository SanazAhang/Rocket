package com.example.racket.ui.rocketList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.racket.domain.model.Model
import com.example.racket.domain.model.ResultData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class RocketViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()


    lateinit var useCase: FakeUseCase

    @Before
    fun createUseCase() {
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getRocket_shouldSuccess() = runBlockingTest {
        useCase = FakeUseCase("Success")
        val data = ResultData.Success(listOf<Model.Rocket>())
        val result = useCase.execute(Unit)
        assertThat(data, `is`(result))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getRocket_shouldFail() = runBlockingTest {
        useCase = FakeUseCase("Failure")
        val failureMessage = useCase.execute(Unit)
        val value = ResultData.Failure<String>("Failure")
        assertThat(failureMessage,`is` (value))
    }
}