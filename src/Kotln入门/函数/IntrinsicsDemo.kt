package Kotln入门.函数

//内联函数
fun main() {
    //内联函数与其他函数的区别在于在编译过程中不会涉及到函数的跳转，而是会直接将函数内容原封不动地搬到main函数中。
    //对于内敛函数来说就不需要加标签return了,但还是最好用标签，不然会导致非局部返回
    tested {
        if (it == "test") return@tested 1
        10
    }
}


//内联函数对高阶函数的作用更大(如果参数中也有函数那么也会加入到内联中，并且该函数不能再赋给其他变量)
inline fun tested(noinline func: (String) -> Int) {
    //该变量能够赋值（前提是不参与内联）
    var func1: (String) -> Int = func
//    var func21 = func2
    println("test")
    println(func("test"))
//    println(func2("use"))
}

