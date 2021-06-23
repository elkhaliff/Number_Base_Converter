class Point3D {
    var x: Int = 0
    var y: Int = 0
    var z: Int = 0
}
fun createPoint(x: Int, y: Int, z: Int): Point3D {
    // provide implementation here
    val ret = Point3D()
    ret.x = x
    ret.y = y
    ret.z = z

    return ret
}


fun main() {
    // write your code here
    var allMoney = readLine()!!.toInt()
    val arrPurchases = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    arrPurchases.forEach {
        if (allMoney - it < 0) {
            println("Error, insufficient funds for the purchase. You have $allMoney, but you need $it.")
            return
        } else allMoney -= it
    }
    println("Thank you for choosing us to manage your account! You have $allMoney money.")
}