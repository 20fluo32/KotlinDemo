package Kotlin高级.泛型

fun main() {
    var score: Score<Int> = Score("LUOFAN", "123", 20)
    score.print<Int>(10)
}

//泛型类,定义了泛型的上界,泛型的作用和java一样都是为了避免强制类型转换
class Score<T : Number>(var name: String, var id: String, var value: T) {
    //泛型方法
    fun <E> print(t: E): String {
        return t.toString()
    }
}

interface Test<T> {

}
