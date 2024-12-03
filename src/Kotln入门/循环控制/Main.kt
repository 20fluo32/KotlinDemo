package Kotln入门.循环控制

fun main() {
    //底层是使用对象的迭代器进行for循环，如果没有就循环不了
    var toList: List<Int> = (1..20).toList()
    println(toList.listIterator().next())
    println(toList.listIterator().hasNext())
    //第一种方式
    for (i in toList) {
        println(i)
    }
    // 把下标和值都拿出来
    for (i: IndexedValue<Int> in toList.withIndex()) {
        println("${i.index} - ${i.value}")
    }
    for ((index: Int, i: Int) in toList.withIndex()) {
        println(i)
    }
    //高级写法
    toList.forEach(::println)

    //指定名称
    toList.forEach { value ->
        println(value)
    }

    toList.forEachIndexed { index, value ->
        println("$index - $value")
    }


    // while循环
    var i = 0
    do {
        i++
        println(i)
    } while (i <= 5)

    while (i == 5) {
        println(i)
    }
}