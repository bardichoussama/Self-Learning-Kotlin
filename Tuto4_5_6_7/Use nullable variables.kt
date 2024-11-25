fun main() {

    //------------ With-Null -------------//
    val favoriteActor = null
    println(favoriteActor) // Output: null

    //------------ With-String ------------//
    var favoriteActor2: String? = "Sandra Oh"
    println(favoriteActor2) // Output: Sandra Oh

    favoriteActor2 = null
    println(favoriteActor2) // Output: null

    //------------ With-Int --------------//
    var number: Int? = 10
    println(number) // Output: 10

    number = null
    println(number) // Output: null

    //------ Handling Nullable Variables ------//
    var favoriteActor3: String = "Sandra Oh"
    println(favoriteActor3.length) // Output: 9 (length of "Sandra Oh")

    // Safe call (?.) for nullable variable
    var favoriteActor4: String? = null
    println(favoriteActor4?.length) // Output: null (safe call to handle nullable)

    //------ Safe Use of !! ------//
    var favoriteActor5: String? = "Sandra Oh"
    println(favoriteActor5!!.length) // Output: 9 (the length of "Sandra Oh")

    //------ Unsafe Use of !! ------//
    var favoriteActor6: String? = null
    // This will throw NullPointerException
    // println(favoriteActor6!!.length) // Uncommenting this will cause a crash!

    //------ Using an if Condition to Check for null ------//
    var favoriteActor7: String? = "Sandra Oh"

    if (favoriteActor7 != null) {
        println("The number of characters in your favorite actor's name is ${favoriteActor7.length}.")
    } else {
        println("You didn't input a name.")
    } // Output: The number of characters in your favorite actor's name is 9.

    //------ Using an if Expression to Return a Value ------//
    var favoriteActor8: String? = "Sandra Oh"

    val lengthOfName = if (favoriteActor8 != null) {
        favoriteActor8.length
    } else {
        0
    }

    println("The number of characters in your favorite actor's name is $lengthOfName.")
    // Output: The number of characters in your favorite actor's name is 9.

    //------ Using the Elvis Operator (?:) ------//
    var favoriteActor9: String? = null

    val lengthOfNameWithElvis = favoriteActor9?.length ?: 10

    println("The number of characters in your favorite actor's name is $lengthOfNameWithElvis.")
    // Output: The number of characters in your favorite actor's name is 9.
}
