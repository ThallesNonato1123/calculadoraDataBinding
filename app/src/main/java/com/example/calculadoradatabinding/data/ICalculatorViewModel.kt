package com.example.calculadoradatabinding.data

interface ICalculatorViewModel {
    fun computaExpressao(valor: Char)
    fun calculaExpressao()
    fun undoExpressao()
    fun limpaCalculadora()
}
