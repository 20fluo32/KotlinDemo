package 封装继承和多态.类的继承与重写

fun main() {
    var bChild: BChild = BChild("梨花", 2)
    var aChild: AChild = AChild()
    println(bChild.name)
}

open class AParent {}

// 继承
// 需要注意的就是，如果子类有主构造函数那就必须要在初始化之前初始化父类的主构造函数
// 如果子类没有主构造函数那就在次构造函数使用super进行
class AChild : AParent {
    constructor() : super()
}

open class BParent(var name: String, var age: Int) {
    constructor(name: String) : this(name, 1)
}

//可以选择性的进行代理

//class BChild(name: String) : BParent(name) {
//
//}
// Ctrl+P可以显示父类的构造函数信息
class BChild(name: String, age: Int) : BParent(name, age) {

}

// 用次构造函数实现

//class BChild : BParent {
//    constructor(name: String) : super(name)
//    constructor(name: String, age: Int) : super(name, age)
//}