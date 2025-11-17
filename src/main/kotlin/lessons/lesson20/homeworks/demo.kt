package org.example.lessons.lesson20.homeworks

fun main() {

    println("\n=== 3) pickAt(index) ===")
    val map: Map<Int, List<String>> = mapOf(
        10 to listOf("кофе", "чай"),
        20 to listOf("молоко")
    )
    println(map.pickAt(index = 0)) // {10=кофе, 20=молоко}
    println(map.pickAt(index = 1)) // {10=чай, 20=null}

    val nullMap: Map<Int, List<String>>? = null
    println(nullMap.pickAt(index = 0)) // null

    println("\n=== 4) Number.within ===")
    println(10.within(other = 12, deviation = 2))        // true
    println(10.0.within(other = 12.5, deviation = 2.4))  // false
    println(100L.within(other = 95, deviation = 5))      // true

    println("\n=== 5) encrypt/decrypt ===")
    val src = "Котлин ♥"
    val enc = src.encrypt(base = 3)
    val dec = enc.decrypt(base = 3)
    println("src=$src")
    println("enc=$enc")
    println("dec=$dec")

    println("\n=== 6) tweetBy ===")
    "кот".tweetBy(users = listOf("masha", "pasha"))
}
