import java.math.BigInteger

fun main() {
    val bi: BigInteger = readLine()!!.toBigInteger() * BigInteger.TWO.pow(63)
    println(bi)
}