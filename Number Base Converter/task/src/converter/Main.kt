package converter

import java.math.BigInteger

fun getString(vText: String): String {
    print(vText)
    return readLine()!!
}

class NumberConverter() {
    fun convert(strBi: String, fromBase: Int, toBase: Int) = BigInteger(strBi, fromBase).toString(toBase)

    fun getMenuSecond(numbers: String) {
        while(true) {
            val (fromBase, toBase) = numbers.split(' ')
            val inputStr = getString("Enter number in base $fromBase to convert to base $toBase (To go back type /back) ")
            if (inputStr != "/back") {
                println("Conversion result: ${convert(inputStr, fromBase.toInt(), toBase.toInt())}")
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