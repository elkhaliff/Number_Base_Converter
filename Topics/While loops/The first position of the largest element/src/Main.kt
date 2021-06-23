fun main() {
    // put your code here
    val scan = java.util.Scanner(System.`in`)
    var currN = 0
    var maxN = Int.MIN_VALUE
    var maxI = 0
    var i = 0
    while (scan.hasNext()) {
        i++
        currN = scan.nextInt()
        if (currN > maxN) {
            maxN = currN
            maxI = i
        }
    }
    println("$maxN $maxI")
}
