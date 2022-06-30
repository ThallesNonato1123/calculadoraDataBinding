package com.example.calculadoradatabinding.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private val viewModel = CalculatorViewModel(mockk<CalculatorService>(relaxed = true))


    @Test fun testaChamaComputaExpressao() {
        viewModel.computaExpressao('1')
        verify{ viewModel.calculator.computaExpressao(any(),any())}
    }

    @Test fun testaNaoChamaComputaExpressao(){
        viewModel.liveData.value = null
        viewModel.computaExpressao('1')
        verify (exactly = 0 ){ viewModel.calculator.computaExpressao(any(),any())}
    }

    @Test fun testaChamaCalculaExpressao(){
        viewModel.liveData.value = "2+3"
        viewModel.calculaExpressao()
        verify {viewModel.calculator.calculaExpressao(any())}
    }

    @Test fun testaChamaUndo(){
        viewModel.liveData.value = "1+3"
        viewModel.undoExpressao()
        verify { viewModel.calculator.undoExpressao(any()) }

    }

    @Test fun testaNaoChamaUndo(){
        viewModel.liveData.value = null
        viewModel.computaExpressao('1')
        verify (exactly = 0 ){ viewModel.calculator.undoExpressao(any())}
    }

    @Test fun testaChamaLimparCalculadora(){
        viewModel.liveData.value = "2+1"
        viewModel.limpaCalculadora()
        verify { viewModel.calculator.limparCalculadora(any()) }
    }

    @Test fun testaNaoLimpaCalculadora(){
        viewModel.liveData.value = null
        viewModel.limpaCalculadora()
        verify (exactly = 0 ){ viewModel.calculator.limparCalculadora(any())}
    }
}