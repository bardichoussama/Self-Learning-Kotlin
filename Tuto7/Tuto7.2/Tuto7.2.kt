fun main() {
    // -----------------------------
    // Arrays in Kotlin
    // -----------------------------
    // Arrays are fixed-size collections. Once created, their size cannot change.
    // Use Arrays when you know the size of your data in advance.
    val immutableArray = arrayOf("Mercury", "Venus", "Earth", "Mars")
    println("Array Example (Immutable):")
    println("Planets: ${immutableArray.joinToString()}")
    println("Access element by index (2): ${immutableArray[2]}") // Access elements by index
    println("Array size: ${immutableArray.size}")
    println()

    // Arrays are mutable by nature; their elements can be changed but not the size.
    val mutableArray = arrayOf("Mercury", "Venus", "Earth", "Mars")
    println("Array Example (Mutable Elements):")
    mutableArray[1] = "Changed Venus"
    println("After changing Venus: ${mutableArray.joinToString()}")
    println()

    // -----------------------------
    // Lists in Kotlin
    // -----------------------------
    // Immutable List: Cannot be modified after creation. Use when data doesn't change.
    val immutableList = listOf("Mercury", "Venus", "Earth", "Mars")
    println("List Example (Immutable):")
    println("Planets: $immutableList")
    println("First planet: ${immutableList[0]}")
    println("Size of list: ${immutableList.size}")
    println()

    // Mutable List: Can be modified after creation. Use when the collection needs to change.
    val mutableList = mutableListOf("Mercury", "Venus", "Earth", "Mars")
    println("List Example (Mutable):")
    mutableList.add("Jupiter") // Add new element
    println("After adding Jupiter: $mutableList")
    mutableList.remove("Venus") // Remove element
    println("After removing Venus: $mutableList")
    println("Contains Earth? ${"Earth" in mutableList}")
    println()

    // -----------------------------
    // Sets in Kotlin
    // -----------------------------
    // Immutable Set: Elements are unique and cannot be modified.
    val immutableSet = setOf("Mercury", "Venus", "Earth", "Mars")
    println("Set Example (Immutable):")
    println("Planets: $immutableSet")
    println("Contains Venus? ${"Venus" in immutableSet}")
    println()

    // Mutable Set: Elements are unique and can be modified.
    val mutableSet = mutableSetOf("Mercury", "Venus", "Earth", "Mars")
    println("Set Example (Mutable):")
    mutableSet.add("Jupiter") // Add a new element
    println("After adding Jupiter: $mutableSet")
    mutableSet.add("Earth") // Duplicates are ignored
    println("After trying to add duplicate Earth: $mutableSet")
    mutableSet.remove("Venus") // Remove an element
    println("After removing Venus: $mutableSet")
    println()

    // -----------------------------
    // Maps in Kotlin
    // -----------------------------
    // Immutable Map: Key-value pairs where keys are unique and cannot be modified.
    val immutableMap = mapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2
    )
    println("Map Example (Immutable):")
    println("Solar System: $immutableMap")
    println("Moons of Earth: ${immutableMap["Earth"]}") // Access value by key
    println()

    // Mutable Map: Key-value pairs where both keys and values can be modified.
    val mutableMap = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2
    )
    println("Map Example (Mutable):")
    mutableMap["Jupiter"] = 79 // Add a new key-value pair
    println("After adding Jupiter: $mutableMap")
    mutableMap["Mars"] = 3 // Modify an existing key's value
    println("After updating Mars: $mutableMap")
    mutableMap.remove("Venus") // Remove a key-value pair
    println("After removing Venus: $mutableMap")
    println()

    // -----------------------------
    // Summary of Use Cases
    // -----------------------------
    println("Use Cases Summary:")
    println("1. Arrays: Use when size is fixed, and elements may be updated.")
    println("2. Immutable List: Use for ordered, fixed data without modifications.")
    println("3. Mutable List: Use for ordered data where additions/removals are needed.")
    println("4. Immutable Set: Use for unique, unchanging data without duplicates.")
    println("5. Mutable Set: Use for unique data that may grow or shrink.")
    println("6. Immutable Map: Use for fixed associations between keys and values.")
    println("7. Mutable Map: Use for key-value pairs where updates are required.")
}
