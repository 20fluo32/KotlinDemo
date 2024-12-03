package Kotlin入门.单例和对象表达式

fun main() {
    A.test()
    //对象表达式（有点类似匿名内部类的写法）
    //Kotln这里本质上还是在创建一个函数，但是对于Java来说则可以使用lamda进行简化
    request(object : B {
        override fun print() {
            TODO("Not yet implemented")
        }
    })
    // 实现java接口可以用这种方式实现，算是对java的一种语法糖
    request2{

    }
}

//单例(饿汉模式)
object A : B {
    fun test() {

    }

    override fun print() {
        TODO("Not yet implemented")
    }
}

interface B {
    fun print()
}

fun request(b: B) {
    b.print()
}

fun request2(jaa:JavaInterface){
    jaa.doing()
}

