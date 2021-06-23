fun main() {
    val (a, b) = Array(2) { readLine()!!.toBigInteger() }
    println(a * b / a.gcd(b))
}
