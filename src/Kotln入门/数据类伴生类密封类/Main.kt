package Kotln入门.数据类伴生类密封类

fun main() {
    var a = A("张三", 10)
    var copy = a.copy("李四")
    println(copy.name)
    println(a.name)
    var b = B("王五", 12)
    println(b)
    println(D.TEST3.key)
}

//数据类(会自带实现的toString)
data class A(
    val name: String,
    val age: Int
)

class B(
    val name: String,
    val age: Int
) {
    override fun toString(): String {
        return "B(name='$name', age=$age)"
    }
}

//伴生类
class C {
    //这个就是伴生类，在Kotln中其实没有static这个概念，本质上都是通过伴生类直接调用test方法
    //伴生类也可以设置类型，默认直接就通过companion调用
    //伴生类也是支持接口实现
    companion object AChild {
        //这个注解会将a转变成public，也就是将该变量设置为公开，而不是选择用生成get set的方式
        @JvmField
        val a = 1

        //静态常量,const只能用与基本数据类型，并且也只能在伴生类,单例或者类外面进行使用,也不能加在可变的
        const val b = 2

        //这个注解是为了方便与java互通,其实就是对static的适配
        @JvmStatic
        fun test() {
            println("test")
        }
    }
}

//枚举类(枚举类可以有方法)
enum class D(val key: String = "123") : r {
    //这一个个枚举可以理解为一个个次构造函数(也可以说是静态内部类)
    TEST1("Test1") {
        override fun test() {
            TODO("Not yet implemented")
        }

        override fun run() {
            TODO("Not yet implemented")
        }
    },
    TEST2("Test2") {
        override fun test() {
            TODO("Not yet implemented")
        }

        override fun run() {
            TODO("Not yet implemented")
        }
    },
    TEST3() {
        override fun test() {
            TODO("Not yet implemented")
        }

        override fun run() {

        }
    };

    abstract fun test()
}

interface r {
    fun run()
}

