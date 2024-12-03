package Kotln入门.条件控制语句

//if大部分和java差不多，但是kotln的if是可以有返回值的
fun main() {
    val b: Any = 1
    //Unit对应java的void
    val res: Unit = if (b == 1) {

    } else {

    }
    val result: Int = if (b == 1) {
        3
    } else {
        4
    }
    //kotln中没有switch只有when,when的每个分支自带一个break
    val a: Unit = when (b) {
        //这里相当于1或者2
        1, 2 -> {
            println("是1")
        }
        //使用区间
        in 3..4 -> {
            println("yes")
        }
        //判断类型
        is Int -> {
            println("是Int")
        }

        is String -> {
            println("是String")
        }

        else -> {

        }
    }

    //类似与三元表达式? :
    val ress: Boolean = if (b == 1) true else false

}
