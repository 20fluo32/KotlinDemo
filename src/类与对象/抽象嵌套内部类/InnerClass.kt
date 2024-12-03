package 类与对象.抽象嵌套内部类

// 内部类以及嵌套类
fun main() {
    var parent = Parent()
    parent.Child().test()
}

//这种在java属于内部类，但是在Kotln属于嵌套类(本质上就是静态内部类)的定义
class Parent {
    val a = 1

    inner class Child {
        fun test() {
            //这种时候就不能像JAVA一样访问外部类的属性除非加上inner
            println(this@Parent.a)
            //直接访问也可以
            println(a)
        }
    }
}