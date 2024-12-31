package Kotlin高级.官方扩展函数

/*
* 常用的官方扩展函数
*   1、let：用于执行一个lamda表达式并将得到的结果作为返回值返回，可判空，用it传参
*   2、also：用于执行一个lamda表达式并返回对象本身，跟apply功能一致，但是采用的是it参数形式传递给lamda当前对象
*   3、run：用于执行一个lamda表达式并将得到的结果作为返回值返回，它跟let的一样，但使用this传递当前对象，可以从源码中看到
* 用于接受的函数参数是一个扩展函数。
*   4、takeIf：对象满足某些对象进行处理，返回值是一个Boolean类型
*   5、with：对目标对象进行二次处理，返回值为最后一行或者return后的表达式，不可判空
*   6、apply：与run的作用类似，但是apply返回的是对象本身
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
    var apply = str.apply {
        "$str world"
    }
    println(str)

    //with的使用
    var len = with(str) {
        this.length
    }

    //apply的常见应用是将对象进行初始化赋值，或者对对象进行一些中间化操作
    val student = Student("luofan", 12)
    println(student.toString())
    val student2 = student?.apply {
        name = "lisi"
        age = 90
    }

    //also的使用
    println(student2.toString())
    val student3 = student?.also {
        it.name = "wangwu"
        it.age = 80
    }?:Student("admin",0)

    val(name,age) = student3
    println("name:$name age:$age")
}

data class Student(var name: String, var age: Int) {
    //如果不是data需要手动实现component不然会影响解构
    //operator fun component1() = name
    //operator fun component2() = age
    override fun toString(): String {
        return "name: $name, age: $age"
    }
}

//apply的作用就是对某个对象做一些中间操作然后再返回该对象
fun test(student: Student?): Student? = student?.apply {
    this.name = "小明"
    this.age = 18
}