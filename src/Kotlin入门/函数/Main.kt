package Kotlin入门.函数

fun main() {
    println(sum(1, 3))
    println(1.sum3(10))
    println(1 sum3 10)
    println(3.0F sum3 10)
    println(10L.sum0(20))
    sum5(1, {
        println(it)
    }, 5)
    //指向性赋值
    sum5(a = 1, b = 6, c = {
        println(it)
    })
    sum6(1, 7) {
        println(it)
    }
    //无参数可以省略()
    sum7<Int> {
        println(it)
        it
    }
    val arr = arrayOf("1", "2", "3")
    //可以用这种方式展开数组
    sum8(*arr)
    //利用指定性赋值避免参数混乱
    sum9(test = "11", list = arr)
    var length: Int = "patient".mLet {
        it.length
    }
    println("patient's length is $length")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

// 单输出类型函数
fun sum2(a: Int, b: Int) = a + b

//带对象接收者的lamda表达式写法,infix的使用前提是单带参函数(中缀函数+扩展函数)
infix fun Int.sum3(a: Int) = this + a

//跟java一样具有多态的性质
infix fun Float.sum3(a: Int) = this + a

//可以设置默认值
fun sum4(a: Int, b: Int = 2) = a + b

//函数的参数也可以有函数类型
fun sum5(a: Int, c: (Int) -> Unit, b: Int) {
    c(a + b)
}

//当函数的最后一个参数是lamda表达式的时候
fun sum6(a: Int, b: Int, c: (Int) -> Unit) {
    c(a + b)
}

//只有lamda与带泛型参数，泛型返回值
fun <R> sum7(c: (Int) -> R): R {
    return c(3);
}

//多参数
fun sum8(vararg list: String) {
    list.forEach {
        println(it)
    }
}

//单参，多参混用
fun sum9(test: String, vararg list: String) {
    list.forEach {
        println(it)
    }
}

fun Long.sum0(a: Int) = this + a

//inline 我们的函数是高阶函数，所有用到内联，做lambda的优化，性能提高
//fun<T,O> 在函数中申明两个泛型，函数泛型，T输入，O输出
//T.mlet 对T类型进行函数扩展，扩展的函数名称是mLet,所有的类型都可以是同mLet函数
//lambda:(T) -> O  匿名函数，T输入，O输出
//:O O类型会根据用户的最后一行返回类型而定
//lambda(this) T进行函数扩展，在整个扩展函数里面，this==T本身

private inline fun <T, O> T.mLet(lambda: (T) -> O): O {
    return lambda(this)
}