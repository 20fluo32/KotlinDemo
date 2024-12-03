package Kotlin入门.数据类型

/*
* Kotln的基本数据类型
*   Any(类似Object)
*
*
* */
fun main() {
//    变量的创建,这里跟ts的一样，?相当于assert（断言符号）!!双感叹代表强制使用
    var t: Int? = null //空指针
    var st: Int = 10
    var toString: String = st.toString()
    //常量创建
    val b = 10
    var s: String = "abc"
    var plus = s.plus(3)
    //文本块
    var a = """
        abc
        abc
        abc
    """.trimIndent()
    //就是正常的占位符号${}
    println("Str${a}ing")

    //数组的定义(本质上是一个带返回值的函数，返回的是Array类型)
    var arrayOf: Array<Int> = arrayOf<Int>(1, 2, 3, 4)
    //另外一种创建方式
    var array: IntArray = intArrayOf(1, 2, 3, 4)
    //指定大小创建
    var array1: IntArray = IntArray(2)
    //创建空数组
    val array2: Array<Int> = emptyArray<Int>()
    println(arrayOf[0])

    //list集合的创建,这种list是不可变的
    var listOf = listOf<Int>()
    //mutableList就可变
    var mutableListOf: MutableList<Int> = mutableListOf<Int>()
    //赋予初始值
    var mutableListOf1 = mutableListOf(1, 2, 3, 4)
    mutableListOf.add(4)

    //set的创建（不可变）
    var of = setOf<Int>()
    //set的创建(可变)set自动去重
    var mutableSetOf = mutableSetOf(1, 2, 3, 3)
    mutableSetOf.add(4)
    //利用这种方式循环打印
    mutableSetOf.forEach {
        println(it)
    }

    //Map的创建,利用to关键字来定义映射关系,但本质上to其实是一个函数,返回值类型是一个Pair
    var mapOf = mapOf("1" to 1, "2" to 2, "3" to 3)
    //可变
    var mutableMapOf: MutableMap<String, Int> = mutableMapOf("1" to 1, "2" to 2, "3" to 3)
    mutableMapOf.entries.forEach {
        println("${it.key}:${it.value}")
    }

    //Pair的创建(元组)
    var pair: Pair<Int, Int> = Pair(1, 2)
    println(pair.first)
    println(pair.second)

    //三元组的创建
    var triple: Triple<Int, Int, Int> = Triple(1, 2, 3)
    triple.third


}

class A {
    //对于一些变量的初始化，假设实在没有处置可以用以下这种定义方式
    //慢初始化
    lateinit var first: String
    fun sout() {
        println(first)
    }
}