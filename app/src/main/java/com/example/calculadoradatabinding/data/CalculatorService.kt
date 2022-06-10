package com.example.calculadoradatabinding.data
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorService: ICalculatorService {
    override fun calculaExpressao(value: String): String {
        val eval = ExpressionBuilder(value).build()
        try {eval.evaluate()} catch (erro : ArithmeticException){
            return "Inválido"
        }
        return "%,.2f".format(eval.evaluate())
    }

    override fun undoExpressao(value: String): String {
        return if(value.last().isLetter()){
            value.dropLast(value.length)
        }else value.dropLast(1)
    }

    override fun limparCalculadora(value: String): String {
        return " "
    }

    override fun computaExpressao(value: String, valor: Char): String {
        if(value == "Inválido"){
           return valor.toString()
        }
        return value.plus(valor)
    }
}
