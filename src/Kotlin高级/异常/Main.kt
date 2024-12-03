package Kotlin高级.异常

// 异常基本和java一样，都是继承顶层的Throwable（顶层类型）
fun main() {
    // 异常的捕获处理
    try {
        throw Exception("出错了")
        println(1 / 0)
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("异常解决")
    }

}

//重写属性
class MyException(override var message: String) : Exception(message)