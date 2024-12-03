package Kotlin入门.In和区间

fun main() {
    //双闭区间
    1..10
    //左闭右开区间
    1 until 10
    //与上面一样，但是建议用符号
    (1..<10).forEach(::println)
    //倒序区间
    10 downTo 1
    //调整步数
    1..10 step 2
    //浮点型不能for循环
    (1..10 step 2).forEach(::println)
    (1..10 step 2).forEach {
        println(it)
    }

    println(1.2f in 1f ..< 10f)
    //字符区间(根据unicode编码步进输出)
    for (c:Char in 'a'..'z' step 2) {
        println(c)
    }


}