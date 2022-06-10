package com.example.calculadoradatabinding.data
import android.widget.TextView
interface ICalculatorService {
    fun calculaExpressao(value: String):String
    fun undoExpressao(value: String):String
    fun limparCalculadora(value: String):String
    fun computaExpressao(value: String, valor:Char):String
}