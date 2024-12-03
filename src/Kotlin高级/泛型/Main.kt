package Kotlin高级.泛型

// Kotlin中out T等价于java中的? extends T(类型上界)，in T等价于? super T(类型下界)
// 定义上界其实就是代表协变，定义下界代表的就是逆变（向上转型）,抗变就是两种类型无关系
// out只允许读出，生产者(属性setter被限制)，in只允许写入，消费者(使用in的时候，属性的getter会被限制)
fun main() {
    var score: Score<Int> = Score("LUOFAN", "123", 20)
    score.print<Int>(10)
    //上界
    var mutableListOf: MutableList<out Number> = mutableListOf<Int>()
    var list: MutableList<in Int> = mutableListOf<Number>()
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
