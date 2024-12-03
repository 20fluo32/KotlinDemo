package Kotlin入门.函数

fun main() {
    //表示一个接受String参数，返回值是Int类型的函数,lamda表达式的写法
    var func = { str: String ->
        str.length
    }
    //lamda写法,这种写法中不能直接使用return这样的语句,利用标签
    test { s: String ->
        s.length
    }
    //lamda写法利用标签去对返回流程进行控制
    val func2: (Int) -> String = test@{
        if (it > 10) return@test "我提前返回结果"
        println("我是正常情况")
        "收到的参数为${it}"
    }
}

fun test(func: (String) -> Int) {
    func(" ")
}