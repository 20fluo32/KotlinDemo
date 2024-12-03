package 封装继承和多态.类的继承与重写

// 类方法的重写
fun main() {
    var cChild: CChild = CChild()
    cChild.print1()
    cChild.print2()
}

// 对于函数也是一样前面默认有final，因此可以添加open让其可以被重写
open class CParent {
    open val count1 = 1
    open var count2 = 2
    open fun print1() {
        println("APrint 1")
    }

    fun print2() {
        println("APrint 2")
    }
}

class CChild : CParent() {
    //属性重写
    override val count1: Int
        get() = super.count1

    override var count2: Int
        get() = super.count2
        set(value) {
            super.count2 = value
        }
    override fun print1() {
        println("AChild 1")
    }
}