package Kotlin高级.操作符重载
// 相当于重写了扩展函数
data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

val point = Point(10, 20)

fun main() {
    println(-point)  // 输出“Point(x=-10, y=-20)”
}

// 第二种重写方式
data class Count(var dayIndex:Int){
    operator fun plus(index:Int): Count {
        return Count(dayIndex + index)
    }
}

