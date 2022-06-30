package com.example.calculadoradatabinding.data
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorServiceTest{
    private val calculator = CalculatorService()

    @Test
    fun testaCalculaExpressao(){
        assertEquals("4,00",calculator.calculaExpressao("2+2"))
    }

    @Test
    fun testaComputaExpressao(){
        assertEquals("2", calculator.computaExpressao("",'2'))
        assertEquals("2+", calculator.computaExpressao("2",'+'))
        assertEquals("2+4", calculator.computaExpressao("2+",'4'))
        assertEquals("2+4*8",calculator.computaExpressao("2+4*",'8'))
    }

    @Test
    fun testaExpressaoDivisaoPorZero(){
        assertEquals("Inválido",calculator.calculaExpressao("2/0"))
    }

    @Test
    fun testaUndoExpressao(){
        assertEquals("2+",calculator.undoExpressao("2+2"))
    }

    @Test
    fun testaLimparCalculadora(){
        assertEquals(" ",calculator.limparCalculadora("2+2"))
    }
}
