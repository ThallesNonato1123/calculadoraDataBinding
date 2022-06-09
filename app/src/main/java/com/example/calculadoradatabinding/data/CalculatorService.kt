package com.example.calculadoradatabinding.data
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.pow
import kotlin.math.round

class CalculatorService: ICalculatorService {
    override fun calculaExpressao(value: String): String {
        val eval = ExpressionBuilder(value).build()
        val res = eval.evaluate()
        return "%,.2f".format(res)
    }

    override fun limparCalculadora(value: String): String {
        return " "
    }
}
