fun collatz(n: Int): Int {
    if (n % 2 == 0) {
        return n / 2
    } else {
        return n * 3 + 1
    }
    return 1
}

fun main() {
    // put your code here
    var n = readLine()!!.toInt()
    print("$n ")

    while (n != 1) {
        n = collatz(n)
        print("$n ")
    }
}