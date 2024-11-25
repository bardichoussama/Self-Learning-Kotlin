fun main(){

    //-----------------------//

    println(1 == 1) // true
    println(1 < 1) // false

    //------------if-else-----------//

    val trafficLightColor = "Black"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else if (trafficLightColor == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }

    //------------when-----------//

    val trafficLightColor2 = "Yellow"
    when (trafficLightColor2) {
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }

    //------------if-else-as expressions----------//


    val trafficLightColor3 = "Black"

    val message =
        if (trafficLightColor3 == "Red") "Stop"
        else if (trafficLightColor3 == "Yellow") "Slow"
        else if (trafficLightColor3 == "Green") "Go"
        else "Invalid traffic-light color"

    println(message)

    //------------when-as expressions----------//

    val trafficLightColor4 = "Amber"

    val message2 = when(trafficLightColor4) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Proceed with caution."
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(message2)

}








