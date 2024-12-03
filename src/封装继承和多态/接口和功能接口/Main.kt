package 封装继承和多态.接口和功能接口
// is关键字用于判断是否为接口的实现
// as关键字是强制转换成对应的接口
fun main() {

}

//接口的实现和java中是一样的，类单继承，接口可以多继承，
class Parent : A, B {
    //接口的属性重写，跟java不同的地方
    //可变的属性重写会覆盖相同的不可变属性
    override var A: Int
        get() = 1
        set(value) {
            value + 1
        }

    override fun test() {
        super<A>.test()
    }

}

interface A {
    val A: Int

    //默认实现
    fun test() {}
}

interface B {
    var A: Int

    //默认实现
    fun test() {}
}