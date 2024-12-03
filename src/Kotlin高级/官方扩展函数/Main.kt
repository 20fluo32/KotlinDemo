package Kotlin高级.官方扩展函数

/*
* 常用的官方扩展函数
*   1、let：用于执行一个lamda表达式并将得到的结果作为返回值返回
*   2、also：用于执行一个lamda表达式并返回对象本身，跟apply功能一致，但是采用的是it参数形式传递给lamda当前对象
*   3、run：用于执行一个lamda表达式并将得到的结果作为返回值返回，它跟let的一样，使用this传递当前对象，可以从源码中看到
* 用于接受的函数参数是一个扩展函数。
*   4、takeIf：对象满足某些对象进行处理，返回值是一个Boolean类型
*   5、with：对目标对象进行二次处理，返回对象的某些值
* */
fun main() {
    var a = Any()
    var b = a.apply {
        a.toString()
    }
    //这里面是不能调用this的，因为内部的函数不是一个扩展函数
    var let: String = a.let {
        println(it)
        "Hello"
    }
    var run = a.run {
        println(this)
        "Hello"
    }
    //takeIf的使用
    var str = "hello"
    // 代码解释，takeIf的返回值有本身和null两种，后续的是Elvis表达式
    var myStr = str.takeIf { it.length > 3 }?.let { it + it } ?: str
    println(myStr)

    //with的使用
    var len = with(str) {
        this.length
    }

}

class Student(var name: String, var age: Int) {

}

//apply的作用就是对某个对象做一些中间操作然后再返回该对象
fun test(student: Student?): Student? = student?.apply {
    this.name = "小明"
    this.age = 18
}