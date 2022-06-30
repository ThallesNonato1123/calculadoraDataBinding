package com.example.calculadoradatabinding.data
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel(internal val calculator: ICalculatorService):  ViewModel(), ICalculatorViewModel {
    var liveData = MutableLiveData("")
        private set

    override fun computaExpressao(valor: Char){
        liveData.value = liveData.value?.let {
            calculator.computaExpressao("",valor)
        }
    }

    override fun calculaExpressao() {
        liveData.value = liveData.value?.let { calculator.calculaExpressao(it) }
    }

    override fun undoExpressao(){
        liveData.value = liveData.value?.let { calculator.undoExpressao(it)}
    }

    override fun limpaCalculadora() {
        liveData.value = liveData.value?.let { calculator.limparCalculadora(it)}
    }
}