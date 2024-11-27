// Cookie class representing each item in the bakery's menu
data class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

fun main() {

    // A list of Cookie objects representing the bakery's menu
    val cookies = listOf(
        Cookie("Chocolate Chip", false, false, 1.69),
        Cookie("Banana Walnut", true, false, 1.49),
        Cookie("Vanilla Creme", false, true, 1.59),
        Cookie("Chocolate Peanut Butter", false, true, 1.49),
        Cookie("Snickerdoodle", true, false, 1.39),
        Cookie("Blueberry Tart", true, true, 1.79),
        Cookie("Sugar and Sprinkles", false, false, 1.39)
    )

    // 2. forEach() and string templates with lambdas
    // Using forEach to print each cookie's name and price
    println("Menu Items:")
    cookies.forEach {
        // String template for formatting
        println("${it.name} - $${it.price}")
    }

    // 3. map()
    // Using map to create a new list with formatted strings: "name - price"
    val fullMenu = cookies.map {
        // String template: Combines the name and price into a single string
        "${it.name} - $${it.price}"
    }

    // Print the full menu created by map()
    println("\nFull Menu:")
    fullMenu.forEach { println(it) }

    // 4. filter()
    // Filtering cookies to get only the soft-baked cookies
    val softBakedMenu = cookies.filter { it.softBaked }

    // Print the filtered list of soft-baked cookies
    println("\nSoft Cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    // 5. groupBy()
    // Group cookies based on whether they have a filling or not
    val groupedByFilling = cookies.groupBy { it.hasFilling }

    // Print the groups
    println("\nGrouped by Filling:")
    groupedByFilling.forEach { (hasFilling, cookieList) ->
        // Group header (either with or without filling)
        println(if (hasFilling) "With Filling:" else "Without Filling:")
        cookieList.forEach { println(it.name) }
    }

    // 6. fold()
    // Calculate the total price of all cookies using fold
    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }

    // Print the total price of all cookies
    println("\nTotal Price of All Cookies: $${totalPrice}")

    // 7. sortedBy()
    // Sort the cookies by price in ascending order
    val sortedCookies = cookies.sortedBy { it.price }

    // Print the sorted list by price
    println("\nCookies Sorted by Price:")
    sortedCookies.forEach {
        println("${it.name} - $${it.price}")
    }
}
