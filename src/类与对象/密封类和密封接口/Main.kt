package 类与对象.密封类和密封接口

fun main() {
    handleMainIntent(MainIntent.Login("李四", "123"))
}

//密封类,其实和抽象类+枚举差不多
sealed class A {
    abstract fun test()
}

class AChild : A() {
    override fun test() {
        TODO("Not yet implemented")
    }

}

//封装类的基本用法
sealed class MainIntent {
    data class Login(val act: String, val pwd: String) : MainIntent()
    object Logout : MainIntent()
}

fun handleMainIntent(intent: MainIntent) {
    when (intent) {
        is MainIntent.Login -> println("act: ${intent.act}, pwd: ${intent.pwd}")
        MainIntent.Logout -> println("登出")
    }
}

//密封接口就是接口+枚举
sealed interface Health {}

