package org.example.lessons.lesson09.homeworks

fun main() {

    // =====================================
    // 1. Работа с массивами Array
    // =====================================

    //1.1 Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val a1: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    println("=== Задача 1.1 ===")
    for (element in a1) {
        println(element)
    }

    //1.2 Создайте пустой массив строк размером 10 элементов.
    val a2 = Array(10) { "" }
    println("\n=== Задача 1.2 ===")
    for (element in a2) {
        println(element)
    }

    //1.3 Создайте массив из 5 элементов типа Double и заполните его значениями,
    // являющимися удвоенным индексом элемента.
    val a3: Array<Double> = Array(5) { index -> index * 2.0 }
    println("\n=== Задача 1.3 ===")
    for (element in a3) {
        println(element)
    }

    //1.4 Создайте массив из 5 элементов типа Int.
    // Используйте цикл, чтобы присвоить каждому элементу значение,
    // равное его индексу, умноженному на 3.
    val a4 = Array(5) { 0 }
    for (i in a4.indices) {
        a4[i] = i * 3
    }
    println("\n=== Задача 1.4 ===")
    for (element in a4) {
        println(element)
    }

    //1.5 Создайте массив из 3 nullable строк.
    // Инициализируйте его одним null значением и двумя строками.
    val a5: Array<String?> = arrayOf(null, "Привет", "Котлин")
    println("\n=== Задача 1.5 ===")
    for (element in a5) {
        println(element)
    }

    //1.6 Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val a6 = arrayOf(2, 4, 6, 8)
    val copyA6 = Array(a6.size) { 0 }
    for (i in a6.indices) {
        copyA6[i] = a6[i]
    }
    println("\n=== Задача 1.6 ===")
    for (element in copyA6) {
        println(element)
    }

    //1.7 Создайте два массива целых чисел одинаковой длины.
    // Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val a7_1 = arrayOf(10, 20, 30)
    val a7_2 = arrayOf(3, 7, 15)
    val resultA7 = Array(a7_1.size) { 0 }
    for (i in a7_1.indices) {
        resultA7[i] = a7_1[i] - a7_2[i]
    }
    println("\n=== Задача 1.7 ===")
    for (element in resultA7) {
        println(element)
    }

    //1.8 Создайте массив целых чисел.
    // Найдите индекс элемента со значением 5.
    // Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    val a8 = arrayOf(2, 4, 6, 8, 10)
    var index = 0
    var found = -1
    while (index < a8.size) {
        if (a8[index] == 5) {
            found = index
            break
        }
        index++
    }
    println("\n=== Задача 1.8 ===")
    println(found)

    //1.9 Создайте массив целых чисел.
    // Используйте цикл для перебора массива и вывода каждого элемента в консоль.
    // Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val a9 = arrayOf(1, 2, 3, 4, 5)
    println("\n=== Задача 1.9 ===")
    for (num in a9) {
        if (num % 2 == 0) {
            println("$num — чётное")
        } else {
            println("$num — нечётное")
        }
    }

    //1.10 Создай функцию, которая принимает массив строк и строку для поиска...
    println("\n=== Задача 1.10 ===")

    fun findSubstring(array: Array<String>, search: String) {
        for (element in array) {
            if (element.contains(search)) {
                println("Найден элемент: $element")
                return
            }
        }
        println("Совпадений не найдено")
    }

    val words = arrayOf("Котлин", "Язык программирования", "Сильная типизация", "Строки и массивы")
    findSubstring(words, "тип")


    // =====================================
    // 2. Работа со списками List
    // =====================================

    //2.1 Создайте пустой неизменяемый список целых чисел.
    println("\n=== Задача 2.1 ===")
    val b1: List<Int> = listOf()
    println(b1)

    //2.2 Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    println("\n=== Задача 2.2 ===")
    val b2: List<String> = listOf("Hello", "World", "Kotlin")
    for (word in b2) {
        println(word)
    }

    //2.3 Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    println("\n=== Задача 2.3 ===")
    val b3 = mutableListOf(1, 2, 3, 4, 5)
    for (num in b3) {
        println(num)
    }

    //2.4 Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    println("\n=== Задача 2.4 ===")
    b3.add(6)
    b3.add(7)
    b3.add(8)
    println("После добавления элементов:")
    for (num in b3) {
        println(num)
    }

    //2.5 Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    println("\n=== Задача 2.5 ===")
    val b5 = mutableListOf("Hello", "World", "Kotlin")
    b5.remove("World")
    println("После удаления элемента:")
    for (word in b5) {
        println(word)
    }

    //2.6 Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    println("\n=== Задача 2.6 ===")
    val b6 = listOf(10, 20, 30, 40)
    for (num in b6) {
        println(num)
    }

    //2.7 Создайте список строк и получите из него второй элемент, используя его индекс.
    println("\n=== Задача 2.7 ===")
    val b7 = listOf("Яблоко", "Груша", "Слива")
    println("Второй элемент: ${b7[1]}")

    //2.8 Имея изменяемый список чисел, измените значение элемента на определенной позиции
    // (например, замените элемент с индексом 2 на новое значение).
    println("\n=== Задача 2.8 ===")
    val b8 = mutableListOf(5, 10, 15, 20)
    b8[2] = 99
    println("После изменения элемента:")
    for (num in b8) {
        println(num)
    }

    //2.9 Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков.
    // Реши задачу с помощью циклов.
    println("\n=== Задача 2.9 ===")
    val list1 = mutableListOf("А", "Б", "В")
    val list2 = mutableListOf("Г", "Д", "Е")
    val allElements = mutableListOf<String>()
    for (item in list1) {
        allElements.add(item)
    }
    for (item in list2) {
        allElements.add(item)
    }
    println("Объединённый список:")
    for (item in allElements) {
        println(item)
    }

    //2.10 Создайте список целых чисел и найдите в нем минимальный и максимальный элементы, используя цикл.
    println("\n=== Задача 2.10 ===")
    val b10 = listOf(12, 7, 25, 3, 19)
    var min = b10[0]
    var max = b10[0]
    for (num in b10) {
        if (num < min) min = num
        if (num > max) max = num
    }
    println("Минимальный элемент: $min")
    println("Максимальный элемент: $max")

    //2.11 Имея список целых чисел, создайте новый список, содержащий только чётные числа
    // из исходного списка, используя цикл.
    println("\n=== Задача 2.11 ===")
    val b11 = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    val evenNumbers = mutableListOf<Int>()
    for (num in b11) {
        if (num % 2 == 0) {
            evenNumbers.add(num)
        }
    }
    println("Чётные числа из списка:")
    for (num in evenNumbers) {
        println(num)
    }

    // =====================================
    // 3. Работа с Множествами Set
    // =====================================

    //3.1 Создайте пустое неизменяемое множество целых чисел.
    println("\n=== Задача 3.1 ===")
    val c1 = emptySet<Int>()
    println(c1)

    //3.2 Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    println("\n=== Задача 3.2 ===")
    val c2 = setOf(1, 2, 3)
    println(c2)

    //3.3 Создайте изменяемое множество строк и инициализируйте его несколькими значениями
    // (например, "Kotlin", "Java", "Scala").
    println("\n=== Задача 3.3 ===")
    val c3 = mutableSetOf("Kotlin", "Java", "Scala")
    println("Начальное множество: $c3")

    //3.4 Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    println("\n=== Задача 3.4 ===")
    c3.add("Swift")
    c3.add("Go")
    println("После добавления элементов: $c3")

    //3.5 Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    println("\n=== Задача 3.5 ===")
    val c5 = mutableSetOf(1, 2, 3, 4, 5)
    c5.remove(2)
    println("После удаления элемента 2: $c5")

    //3.6 Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    println("\n=== Задача 3.6 ===")
    val c6 = setOf(10, 20, 30, 40)
    for (num in c6) {
        println(num)
    }

    //3.7 Создай функцию, которая принимает множество строк (set) и строку и проверяет,
    // есть ли в множестве указанная строка. Нужно вернуть булево значение true если строка есть.
    // Реши задачу через цикл.
    fun checkStringInSet(set: Set<String>, word: String): Boolean {
        for (element in set) {
            if (element == word) {
                return true
            }
        }
        return false
    }

    println("\n=== Задача 3.7 ===")
    val techSet = setOf("Kotlin", "Java", "Python")
    val searchWord = "Kotlin"
    println("Есть ли '$searchWord' в множестве? ${checkStringInSet(techSet, searchWord)}")


    //3.8 Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    println("\n=== Задача 3.8 ===")
    val c8 = setOf("Red", "Green", "Blue")
    val convertedList = mutableListOf<String>()
    for (color in c8) {
        convertedList.add(color)
    }
    println("Множество: $c8")
    println("Преобразованный список: $convertedList")
}
