fun main() {
    // Creating Question instances using `apply`
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    // Using `apply` to set properties for StudentProgress
    StudentProgress.apply {
        total = 10
        answered = 3
    }

    // Using `run` to print the question details
    question3.run {
        println("$questionText $difficulty $answer")
    }

    // Using the printProgressBar extension function for StudentProgress
    StudentProgress.printProgressBar()

    // Print question1 details
    println(question1.toString())
}

enum class Difficulty {
    EASY, MEDIUM, HARD
}

// Question class with generic type T
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

// Interface for classes that need to print progress
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

// StudentProgress implementing the ProgressPrintable interface
object StudentProgress : ProgressPrintable {
    var total: Int = 10
    var answered: Int = 3

    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }
}
