package Kotlin高级.官方扩展函数

fun main() {
    var a = Any()
    var b = a.apply {
        a.toString()
    }
}

class Student(var name: String, var age: Int) {

}

//apply的作用就是对某个对象做一些中间操作然后再返回该对象
fun test(student: Student?): Student? = student?.apply {
    this.name = "小明"
    this.age = 18
}