package com.example.calculadoradatabinding.data
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel:  ViewModel() {
    private val calculator: ICalculatorService = CalculatorService()
    private val _value = MutableLiveData("")
    val value: LiveData<String> = _value

    fun computaExpressao(valor: Char){
        _value.value = _value.value?.let { calculator.computaExpressao(it,valor) }
    }

    fun calculaExpressao() {
        _value.value = _value.value?.let { calculator.calculaExpressao(it) }
    }

    fun undoExpressao(){
        _value.value = _value.value?.let { calculator.undoExpressao(it)}
    }

    fun limpaCalculadora() {
        _value.value = _value.value?.let { calculator.limparCalculadora(it)}
    }
}