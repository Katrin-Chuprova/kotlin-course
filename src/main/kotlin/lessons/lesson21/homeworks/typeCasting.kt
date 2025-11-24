package org.example.lessons.lesson21.homeworks

//Задача 1
//Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и
// вывести соответствующее сообщение:
//Для строки: "Это строка: [значение]".
//Для любого числа: "Это число: [значение]".
//Для списка: "Это список, количество элементов: [количество]".
//Для словаря: "Это словарь, количество пар: [количество]".
//Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.

fun analyzeDataType(value: Any) {
    when (value) {
        is String      -> println("Это строка: $value")
        is Number      -> println("Это число: $value") // покрывает Int, Long, Double, Float и т.д.
        is List<*>     -> println("Это список, количество элементов: ${value.size}")
        is Map<*, *>   -> println("Это словарь, количество пар: ${value.size}")
        else           -> println("Неизвестный тип данных")
    }
}


//Задача 2
//Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка,
// если аргумент можно безопасно привести к типу List. В случае неудачного приведения функция должна
// возвращать -1. Используйте as? для безопасного приведения типа.

fun safeCastToList(value: Any): Int {
    val list = value as? List<*> ?: return -1
    return list.size
}

//Задача 3
//Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки,
// если аргумент можно привести к типу String. В случае, если аргумент равен null или не является строкой,
// функция должна возвращать 0.

fun getStringLengthOrZero(value: Any?): Int =
    (value as? String)?.length ?: 0

//Задача 4
//Создайте функцию-расширение класса Any toSquare. Функция гарантированно вызывается у числа
// (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа.
// Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать в число
// через функцию toDouble() и возвести в квадрат.

fun Any.toSquare(): Double = when (this) {
    is Number -> {
        val x = this.toDouble()
        x * x
    }
    is String -> {
        val x = this.toDouble()    // "4.2" -> 4.2
        x * x
    }
    else -> error("toSquare() должен вызываться на Number или числовой String.")
}

//Задача 5
//Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех
//целочисленных (Int) и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.

fun sumIntOrDoubleValues(items: List<Any>): Double {
    var sum = 0.0
    for (e in items) {
        when (e) {
            is Int    -> sum += e
            is Double -> sum += e
            // Остальные типы игнорируем
        }
    }
    return sum
}

//Задача 6
//Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его
//к типу List<*>. Если приведение успешно, функция должна напечатать все строки из списка, если элемент
// не является строкой то вывести предупреждение об этом. Если приведение неудачно, должно быть выведено
// сообщение об ошибке, не прерывая выполнение программы.

fun tryCastToListAndPrint(value: Any) {
    val list = value as? List<*>
    if (list == null) {
        println("Не список — приведение не удалось")
        return
    }

    for ((index, element) in list.withIndex()) {
        if (element is String) {
            println(element)
        } else {
            println("Элемент $index не строка: $element")
        }
    }
}

fun main() {
    println("=== Задача 1: analyzeDataType ===")
    analyzeDataType("привет")
    analyzeDataType(42)
    analyzeDataType(3.14)
    analyzeDataType(listOf(1, 2, 3))
    analyzeDataType(mapOf("a" to 1, "b" to 2))
    analyzeDataType(Any())

    println("\n=== Задача 2: safeCastToList ===")
    println(safeCastToList(listOf("a", "b", "c"))) // 3
    println(safeCastToList(12345))                 // -1

    println("\n=== Задача 3: getStringLengthOrZero ===")
    println(getStringLengthOrZero("Котлин")) // 6
    println(getStringLengthOrZero(null))     // 0
    println(getStringLengthOrZero(123))      // 0

    println("\n=== Задача 4: Any.toSquare ===")
    println(4.toSquare())         // 16.0
    println(4.2.toSquare())       // 17.64
    println("4.2".toSquare())     // 17.64
    // println(Any().toSquare())  // ошибка по условию, не вызываем

    println("\n=== Задача 5: sumIntOrDoubleValues ===")
    val mixed: List<Any> = listOf(1, 2.5, "x", 3L, 4, 1.5f, 10.0)
    println(sumIntOrDoubleValues(mixed)) // учитываются только Int и Double: 1 + 2.5 + 4 + 10.0 = 17.5

    println("\n=== Задача 6: tryCastToListAndPrint ===")
    tryCastToListAndPrint(listOf("мама", 123, "мыла", true, "раму"))
    tryCastToListAndPrint(999)
}