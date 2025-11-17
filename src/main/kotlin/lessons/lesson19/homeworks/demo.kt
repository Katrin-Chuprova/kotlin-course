package org.example.lessons.lesson19.homeworks

fun main() {
    println("— getMiddleElement —")
    println(getMiddleElement(listOf(1, 2, 3)))        // 2
    println(getMiddleElement(listOf("a", "b")))       // null

    println("\n— ListHolder —")
    val holder = ListHolder<String>()
    holder.add("кот"); holder.add("свет"); println(holder.getAll())

    println("\n— Mapper —")
    val mapper = PhrasesToListOfStrings()
    println(mapper.map("Кофе без сахара"))
    println(mapper.mapList(listOf("Раз два  три", "четыре пять")))

    println("\n— transposition —")
    val m = mapOf(1 to "one", 2 to "two", 3 to "two")
    println(transposition(m)) // {one=1, two=3}

    println("\n— Validators —")
    println(StringValidator().isValid("   "))         // false
    println(StringValidator().isValid("ok"))          // true
    println(OddValidator().isValid(4))                // true (чётное)
    println(ListValidator<Int>().isValid(listOf(1, 2, 3)))     // true
    println(ListValidator<Double>().isValid(listOf(1.0, 0.0))) // false
}
