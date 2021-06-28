package converter

import java.math.BigDecimal
import java.math.BigInteger
import kotlin.math.pow

fun getString(vText: String): String {
    print(vText)
    return readLine()!!
}

class NumberConverter() {
    private val abc = ('A'..'Z').toList().joinToString("")

    private fun toStr(numb: Int, sys: Int) = if (sys <= 10 || numb < 10) numb.toString()
    else abc[numb - 10].toString()

    private fun toNumb(str: String, sys: Int) = if (sys <= 10 || str !in abc) str.toInt()
    else 10 + abc.indexOf(str)

    fun convertDect(strFr: String, fromBase: Int): BigDecimal {
        var ret = BigDecimal(0.0)
        strFr.forEachIndexed { index, c ->
            ret += toNumb(c.toString(), fromBase).toBigDecimal().setScale(6) / fromBase.toBigDecimal().pow(index + 1).setScale(6)
        }
        return ret
    }

    fun convertInt(strBi: String, fromBase: Int, toBase: Int) = BigInteger(strBi, fromBase).toString(toBase).toUpperCase()

    fun convertFract(strFr: String, fromBase: Int, toBase: Int): String {
        var res =  if (fromBase != 10) convertDect(strFr, fromBase)
            else ("0." + strFr).toBigDecimal()

        var proc = true
        var ret = ""
        while (proc) {
            res *= toBase.toBigDecimal()
            val oper = res.toString()
            val intPart = oper.substringBefore('.')
            val fractPart = oper.substringAfter('.')
            ret += toStr(intPart.toInt(), toBase)
            proc = ((fractPart != "0") && (ret.length < 5))
            res = ("0." + fractPart).toBigDecimal()
        }
        return ".${ret}"
    }

    fun getMenuSecond(numbers: String) {
        while(true) {
            val (fromBase, toBase) = numbers.split(' ')
            val inputStr = getString("Enter number in base $fromBase to convert to base $toBase (To go back type /back) ")
            var intPart = ""
            var fractPart = ""
            if (inputStr != "/back") {
                if (inputStr.lastIndexOf('.') > 0) {
                    intPart = inputStr.substringBefore('.')
                    fractPart = inputStr.substringAfter('.')
                    fractPart = convertFract(fractPart.toUpperCase(), fromBase.toInt(), toBase.toInt())
                } else {
                    intPart = inputStr
                    fractPart = ""
                }
                println("Conversion result: ${convertInt(intPart, fromBase.toInt(), toBase.toInt())}$fractPart")
            } else return
        }
    }

    fun getMenu() {
        while (true) {
            val inputStr = getString("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
            if (inputStr == "/exit") return
            getMenuSecond(inputStr)
            println("")
        }
    }
}

fun main() {
    val mc = NumberConverter()
    mc.getMenu()
}
