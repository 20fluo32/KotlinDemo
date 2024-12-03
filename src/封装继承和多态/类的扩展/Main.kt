package 封装继承和多态.类的扩展

//类中已定义的函数优先级高于同名的扩展函数，即扩展函数会被覆盖
//类的扩展也可以扩展成员变量
//扩展函数同样会受权限控制符的限制，不能够使用类中被private修饰的变量
//扩展函数的定义也可以写在同个文件下的其他类中(此时扩展函数的作用域将会被限制在类里面)
//当扩展函数中调用其他函数，会有限匹配被扩展类中已有的函数，如果真的不想用被扩展类中的函数那就用标签说明
//扩展函数在哪定义那么它的作用域就会在哪
fun main() {
    var person = Person()
    person.test()
    //这里依然使用的Shape的扩展方法(同名函数那就以定义的类型为准,跟对象向上转型有点区别)
    //从这就可以看出扩展函数没办法很好的利用多态的性质
    printClassName(Rectangle())
    //定义类的扩展函数
    var func: String.() -> String = {
        this.reversed()
    }
    println("12345".func())
}


class Person() {
    fun hello() = println("Hello World")
}

//类的扩展函数，是Kotlin中独有的一种写法
fun Person.test() = println("我是测试函数")
var Person.name: String
    get() = ""
    set(value) {
        value
    }

class Man(private val person: Person) {
    private fun Person.test() {
        hello()//有限匹配被扩展类中的函数
        this.hello()//跟上面一致
        this@Man.hello()//调用自身
    }

    fun hello() = println("hello")
}

open class Shape
class Rectangle : Shape()

fun Shape.getName() = "Shape"
fun Rectangle.getName() = "Rectangle"
fun printClassName(s: Shape) {
    println(s.getName())
}