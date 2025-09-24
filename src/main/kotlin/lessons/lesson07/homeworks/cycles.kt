package org.example.lessons.lesson07.homeworks

fun main() {

    // Задания для цикла for

    println("=== Задача 1 ===")
    // Прямой диапазон: числа от 1 до 5
    for (i in 1..5) {
        println(i)
    }

    println("=== Задача 2 ===")
    // Четные числа от 1 до 10
    for (i in 1..10) {
        if (i % 2 == 0) {
            println(i)
        }
    }

    println("=== Задача 3 ===")
    // Обратный диапазон: числа от 5 до 1
    for (i in 5 downTo 1) {
        println(i)
    }

    println("=== Задача 4 ===")
    // Числа от 10 до 1, уменьшая на 2
    for (i in 10 downTo 1 step 2) {
        println(i)
    }

    println("=== Задача 5 ===")
    // С шагом: числа от 1 до 9 с шагом 2
    for (i in 1 .. 9 step 2) {
        println (i)
    }

    println("=== Задача 6 ===")
    // С шагом: выводит каждое третье число в диапазоне от 1 до 20
    for (i in 1 .. 20 step 3) {
        println (i)
    }

    println("=== Задача 7 ===")
    // Until: Создайте числовую переменную 'size'.
    // Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size: Int = 48
    for (i in 3 until size step 2) {
        println (i)
    }

    // Задания для цикла while

    //Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    println("=== Задача 8 ===")
    var counter1 = 1
    while (counter1 <=5) {
        println (counter1*counter1)
        counter1++
    }

    //Напишите цикл while, который уменьшает число от 10 до 5
    println("=== Задача 9 ===")
    var counter2 = 10
    while (counter2 >=5) {
        println (counter2)
        counter2--
    }

    //цикл do while, чтобы вывести числа от 5 до 1
    println("=== Задача 10 ===")
    var counter3 = 5
    do {
        println(counter3)
        counter3--
    }  while (counter3 >=1)

    //цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5
    println("=== Задача 11 ===")
    var counter4 = 5
    do {
        println(counter4)
        counter4++
    }  while (counter4 < 10)

    //Задания для прерывания и пропуска итерации
    //цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6
    println("=== Задача 12 ===")
    for (i in 1..10) {
        if (i == 6) break
        println(i)
        }

    //цикл while, который бесконечно выводит числа, начиная с 1,
    // но прерывается при достижении 10
    println("=== Задача 13 ===")
    var counter5: Int = 1
    while (true) {
        println (counter5)
        counter5++
        if (counter5 == 10) break
    }

    //В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа
    println("=== Задача 14 ===")
    for (i in 1..10) {
        if (i %2 == 0) continue
        println(i)
    }

    //цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3
    println("=== Задача 15 ===")
    var counter6 = 1
    while (counter6 <= 10) {
        if (counter6 % 3 == 0) {
            counter6++
            continue
        }
        println(counter6)
        counter6++
    }


}

