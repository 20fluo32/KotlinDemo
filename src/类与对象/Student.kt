package 类与对象

//但此时的属性只是构造函数的参数，并不属于类，还需要加上var或者val来定义成类的属性
open class Student(var name: String, var age: Int) {
    //    var name: String
//    var age: Int
//init初始化代码块可以执行对象初始化的其他操作,有多个初始化函数的话就按顺序意思执行,有点类似于static代码块
//    init {
//        this.name = name
//        this.age = age
//    }
    val definition: String
        get() = "name: $name, age: $age"

    //类的成员函数(存在歧义的情况下会采取就近的原则,有限选择形参列表的值)
    open fun print(name: String) {
        //跟java一样用this来指代类的属性值
        println("name: ${this.name}")
        println(definition)
    }

    //次要构造函数(不能使用var这种),次要构造函数不是必须要去调用主构造函数,可以委托其他已有的构造函数,委托构造
    constructor(name: String) : this(name, 18)
    constructor(name: String, age: Int, id: Int) : this(name)

    // 中缀函数
    infix fun test(string: String):String {
        return name + string
    }
    //解构函数
    operator fun component1() = name
    operator fun component2() = age
}