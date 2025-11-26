package org.example.lessons.lesson23.homeworks

//1) Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел
// этого списка. С помощью require проверь, что список не пустой.
/** 1) Обычная функция */
fun averageOfEven(nums: List<Int>): Double {
    require(nums.isNotEmpty()) { "Список не должен быть пустым" }
    val evens = nums.filter { it % 2 == 0 }
    require(evens.isNotEmpty()) { "В списке нет чётных чисел" }
    return evens.average()
}

/** 1a) Анонимная функция */
val averageOfEvenAnon = fun(nums: List<Int>): Double {
    require(nums.isNotEmpty()) { "Список не должен быть пустым" }
    val evens = nums.filter { it % 2 == 0 }
    require(evens.isNotEmpty()) { "В списке нет чётных чисел" }
    return evens.average()
}

/** 1b) Лямбда с указанием типа переменной */
val averageOfEvenLambdaTyped: (List<Int>) -> Double = { nums ->
    require(nums.isNotEmpty()) { "Список не должен быть пустым" }
    val evens = nums.filter { it % 2 == 0 }
    require(evens.isNotEmpty()) { "В списке нет чётных чисел" }
    evens.average()
}

/** 1c) Лямбда без указания типа переменной (тип выведется по параметру) */
val averageOfEvenLambda = { nums: List<Int> ->
    require(nums.isNotEmpty()) { "Список не должен быть пустым" }
    val evens = nums.filter { it % 2 == 0 }
    require(evens.isNotEmpty()) { "В списке нет чётных чисел" }
    evens.average()
}

//2) Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа.
// Сделай проверку, что входящее число больше нуля. Подсказка: для парсинга символа в число можно
// использовать функцию digitToInt()

/** 2) Обычная функция */
fun sumDigits(n: Long): Int {
    require(n > 0) { "Число должно быть > 0" }
    return n.toString().sumOf { it.digitToInt() }
}

/** 2a) Анонимная функция */
val sumDigitsAnon = fun(n: Long): Int {
    require(n > 0) { "Число должно быть > 0" }
    return n.toString().sumOf { it.digitToInt() }
}

/** 2b) Лямбда с указанием типа переменной */
val sumDigitsLambdaTyped: (Long) -> Int = { n ->
    require(n > 0) { "Число должно быть > 0" }
    n.toString().sumOf { ch -> ch.digitToInt() }
}

/** 2c) Лямбда без указания типа переменной */
val sumDigitsLambda = { n: Long ->
    require(n > 0) { "Число должно быть > 0" }
    n.toString().sumOf { it.digitToInt() }
}

//3) Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел
// (встречающихся в списке более одного раза).
/** 3) Функция-расширение: множество дубликатов (те, что встречаются более одного раза) */
fun List<Int>.duplicates(): Set<Int> {
    val counts = mutableMapOf<Int, Int>()
    for (x in this) counts[x] = (counts[x] ?: 0) + 1
    return counts.filterValues { it > 1 }.keys
}

/** 3a) Анонимная функция-«аналог» (не расширение, а обычная) */
val duplicatesAnon = fun(nums: List<Int>): Set<Int> {
    val counts = mutableMapOf<Int, Int>()
    for (x in nums) counts[x] = (counts[x] ?: 0) + 1
    return counts.filterValues { it > 1 }.keys
}

/** 3b) Лямбда с указанием типа переменной */
val duplicatesLambdaTyped: (List<Int>) -> Set<Int> = { nums ->
    val counts = mutableMapOf<Int, Int>()
    for (x in nums) counts[x] = (counts[x] ?: 0) + 1
    counts.filterValues { it > 1 }.keys
}

fun main() {
    println("=== 1) Среднее чётных ===")
    val a = listOf(2, 5, 8, 11, 14)
    val b = listOf(1, 3, 5)
    val c = emptyList<Int>()

    println("func  : " + averageOfEven(a))
    println("anon  : " + averageOfEvenAnon(a))
    println("λ typ : " + averageOfEvenLambdaTyped(a))
    println("λ     : " + averageOfEvenLambda(a))

    // проверки и ошибок
    fun tryAvg(nums: List<Int>) {
        try { println("avg($nums) = ${averageOfEvenLambda(nums)}") }
        catch (e: IllegalArgumentException) { println("avg($nums) -> Ошибка: ${e.message}") }
    }
    tryAvg(a)  // норм
    tryAvg(b)  // нет чётных
    tryAvg(c)  // пустой

    println("\n=== 2) Сумма цифр ===")
    val n1 = 9876543210L
    val n2 = 101010L
    println("func  : " + sumDigits(n1))
    println("anon  : " + sumDigitsAnon(n1))
    println("λ typ : " + sumDigitsLambdaTyped(n2))
    println("λ     : " + sumDigitsLambda(99999))

    // проверки ошибок
    for (n in listOf(1L, 42L, 100000000000L, 0L, -5L)) {
        try { println("sumDigits($n) = ${sumDigitsLambda(n)}") }
        catch (e: IllegalArgumentException) { println("sumDigits($n) -> Ошибка: ${e.message}") }
    }

    println("\n=== 3) Дубликаты ===")
    val d1 = listOf(1,2,2,3,4,4,4,5)
    val d2 = listOf(7,7,7,7)
    val d3 = listOf(1,2,3,4)
    println("ext dups d1: " + d1.duplicates())
    println("ext dups d2: " + d2.duplicates())
    println("ext dups d3: " + d3.duplicates())
    println("anon dups  : " + duplicatesAnon(d1))
    println("λ typ dups : " + duplicatesLambdaTyped(d1))
}