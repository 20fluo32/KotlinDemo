package 类与对象

import Kotlin入门.数据类伴生类密封类.C.AChild.a
import Kotlin入门.数据类伴生类密封类.C.AChild.b

// Kotln中和java一样存在着自动装箱和拆箱的一个机制
// Kotln中的基本数据类型在编译过程中会有限选择java的原生数据类型，而不是包装类型，除非加一些断言?
// Kotln中对空值的限制比java中严格，一般情况下是不能直接将null赋值给变量，除非有?断言
/*
* 访问权限控制
*
* */
fun main() {
    val a = A(1)
    a.print()
    val B = A(1, 0)
    println(" ")
    B.print()
    val C = B(10, 20)
    println(C.toString())
    val student1 = Student("张三", 10)
    println(student1.definition)
    var mutableListOf = mutableListOf<Range>()
    mutableListOf.add(Range(0, 0))
    mutableListOf.add(Range(2, 0))
    mutableListOf.add(Range(4, 0))
    mutableListOf.add(Range(1, 0))
    var range = Range(0, 0)
    var range1 = Range(0, 1)
    //运算符重载的使用
    println(range.compareTo(range1))
    //从小到达进行排序
    mutableListOf.sortBy {
        it.l
    }
    mutableListOf.forEach(::println)
    println(range in range1)
    range1 = !range1
    println(range1)

    //中缀函数的调用可以省略.,中缀运算符其实也可以看作是一个操作运算符，但是优先级低于算数运算符
    // util,shl这种就是比较经典的中缀运算符号
    1 until 3 * 2
    var student = Student("小明")
    println(student test ("你好"))

    var students: Student? = null
    //对于有?修饰的对象需要先判断后才能正常使用
    //students = Student("小李")
    if (students != null) {
        println(students.name + " " + students.age)
    }
    // Elvis运算符，可以较为安全的返回一个默认值
    val len = student?.name?.length ?: 0 //这样就能方便处理空对象问题

    //解构声明(前提是对应的类需要加上约定的解构函数)
    //下面这种写法就类似于js中的一些写法es6
    var func: (Student) -> Unit = { (a, b) ->
        println("a: $a, b: $b")
    }
    func(student)
    //如果不想要第一个参数可以用_来省略
    val (_, c) = student

    var student2 = Student("小兰")
    var student3 = Student("小明")
    //双等号的底层其实就是Any类中的equals方法
    println(student2 == student3)
    //判断两个对象是否是同一个对象
    println(student2 === student3)
}

//函数式的类声明，带参数的类就在括号里加上(constructor可以省略)
class A constructor(age: Int) {
    val b: Int

    //初始化函数(主构造函数)
    init {
        b = age
    }

    //次构造函数（代理构造函数）
    constructor(a: Int, b: Int) : this(b)

    var a: Int = 1
    //这里的filed就相当于this
//        get() = field - 2
//        set(value) {
//            field = value + 1
//        }

    fun print() {
        println(b)
    }
}

//如果类上没()，里面的constructor会被识别为主构造函数
class B {
    constructor(a: Int, b: Int)
    constructor(a: Int)

    override fun toString(): String {
        return "B(a=$a, b=$b)"
    }
}