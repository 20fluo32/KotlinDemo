package 类与对象.抽象嵌套内部类
// 基本上与java是一致的，用abstract进行修饰，然后不能直接被实例化
//
fun main() {

}
//抽象类
abstract class AParent {
    abstract fun action()
}

class AChild : AParent() {
    override fun action() {
        println("hello world")
    }

}