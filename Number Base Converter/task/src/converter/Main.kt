package converter

import kotlin.math.pow

fun getInt(vText: String): Int {
    print(vText)
    return readLine()!!.toInt()
}

fun getString(vText: String): String {
    print(vText)
    return readLine()!!
}


class NumberConverter() {
    private val abc = "ABCDEF"

    private fun toStr(numb: Int, sys: Int) = if (sys <= 10 || numb < 10) numb.toString()
    else abc[numb - 10].toString()

    private fun toNumb(str: String, sys: Int) = if (sys <= 10 || str !in abc) str.toInt()
    else 10 + abc.indexOf(str)

    private fun convertFrom(numb: Int, sys: Int): String {
        var res = numb
        var out = ""
        while (res != 0) {
            out = toStr(res % sys, sys) + out
            res /= sys
        }
        return out
    }

    private fun convertTo(str: String, sys: Int): String {
        var res = 0
        for ((a, i) in (str.lastIndex downTo 0).withIndex()) {
            res += toNumb(str[i].toString(), sys) * sys.toDouble().pow(a).toInt()
        }
        return res.toString()
    }

    private fun getMenuConvertFrom(){
        val numb = getInt("Enter number in decimal system: ")
        val sys = getInt("Enter target base: ")

        val result = convertFrom(numb, sys)
        println("Conversion result: $result")
    }

    private fun getMenuConvertTo(){
        val str = getString("Enter source number: ")
        val sys = getInt("Enter source base: ")
        val result = convertTo(str.toUpperCase(), sys)
        println("Conversion to decimal result: $result")
    }

    fun getMenu() {
        while (true) {
            print("Do you want to convert /from decimal or /to decimal? (To quit type /exit): ")
            val action = readLine()!!
            when (action) {
                "/from" -> getMenuConvertFrom()
                "/to" -> getMenuConvertTo()
                "/exit" -> return
            }
            println("")
        }
    }
}

fun main() {
    val mc = NumberConverter()
    mc.getMenu()
}