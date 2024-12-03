package Kotlin高级.委托模式

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// 委托模式是一种设计模式,其实跟java中的代理模式差不多
// Kotlin不仅方法实现可以委托，成员变量的getter和setter实现也可以委托给其他类
fun main() {
    var base: Base = Derived(BaseImpl())
    base.print()
    var example = Example("luofan")
    println(example.p)

    val map: MutableMap<String, Any> = mutableMapOf(
        "name" to "John Doe",
        "age" to 20
    )
    // user会和map绑定在一块
    val user = User(map)
    println(user)
    map["age"] = 10
    println(user)
}

interface Base {
    fun print()
}

class BaseImpl : Base {
    override fun print() {
        println("BaseImpl")
    }
}

// Kotlin中原生支持的一种委托写法
class Derived(b: Base) : Base by b

//委托给观察者也可以
class Example(var a: String) {
    var p: String by Delegate()

    //lazy也会生成一个委托对象，但只实现的get
    val name: String by lazy { "luofan" }

    //委托给其他属性
    var base: String by ::a

    //委托观察者
    var age: Int by Delegates.observable(10) { property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
}

class Delegate {
    //重载getter和setter
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

//属性委托给外部的实例
class User(map: MutableMap<String, Any>) {
    var name: String by map
    var age: Int by map
    override fun toString(): String = "name: $name, age: $age"
}