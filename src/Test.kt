fun main() {
    var test:String = "String"
    test?.let {
        test = test.lowercase()
    }
    println(test)
}