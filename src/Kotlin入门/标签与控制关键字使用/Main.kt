package Kotlin入门.标签与控制关键字使用

fun main() {
    for (i in 1..3) {
        //标签
        a@ for (j in 1..3) {
            if (i == 2 && j == 2) {
                //这里按照java的逻辑只能break内部的循环，但是用上标签后
                //break
                //可以直接停止整个标签对应的for
                //break@a
                continue@a
            }
            println("i:$i , j:$j")
        }

        //使用
        (1..10).forEach a@{
            if (it == 2) {
                //return@forEach,可以直接@forEach或者取个别名
                return@a
                //但这种只能解决一次，不能完全停止循环
            }
            println("it:$it")
        }

        run {
            (1..10).forEach{
                if (it == 2) {
                    //return@forEach,可以直接@forEach或者取个别名
                    return@run
                    //但这种只能解决一次，不能完全停止循环
                }
                println("it:$it")
            }
        }
    }
}