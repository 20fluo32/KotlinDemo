package Kotln入门.函数

import kotlin.math.*

typealias Test = String//起别名

fun main() {
    //输入流函数(跟Scanner差不多)
    var readln: String = readln()
    println("readln = $readln")
    1.0.pow(4.0)//计算a的b次方
    abs(-1)
    max(19, 20)
    println(Math.PI)//圆周率Π
    println(sin(Math.PI / 2))
    var c: Test = "String"
    println(c)
    //对函数型变量进行赋值
    var func2: (String) -> Int = ::test
    println(func2("string"))
    //匿名函数的编写(类似java的写法)
    var func3 = { s: String -> s.length }
    var func4 = fun(str: String): Int {
        return str.length
    }
    println(func3("ssss"))
    println(func4("ssss"))
}

fun test(str: String): Int {
    println(str)
    return 1
}