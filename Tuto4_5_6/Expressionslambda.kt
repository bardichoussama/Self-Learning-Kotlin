//Basic Lambda Declaration and Use

fun main() {
    val multiply: (Int, Int) -> Int = { x, y -> x * y }
    println(multiply(4, 5))  // Output: 20

    val concatenate: (String, String) -> String = { first, second -> first + second }
    println(concatenate("Hello, ", "world!"))  // Output: Hello, world!
    fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
}
    val result = performOperation(4, 2) { x, y -> x + y }
    println(result)  // Output: 6

    val welcome: () -> Unit = { println("Welcome to Kotlin Lambdas!") }
    welcome()

}
