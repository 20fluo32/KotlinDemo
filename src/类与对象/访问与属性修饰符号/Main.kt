package 类与对象.访问与属性修饰符号

/*
* Kotln中的修饰符
* public(默认都是)
* private
* protected
* internal(不同模块下的类不能相互访问)
* Kotln的类默认是被public final给修饰的，因此是不能被继承的。
* 如果想要其能够被继承那就需要添加修饰符open
* 而且Kotln中创建注解是有类的性质，而不是java中基于切面的原理
* */
fun main() {
    var b: B = B()


}

public final class A {}
private class B {}
open class C {
    protected fun getSound(): String {
        return "animal sound"
    }
}