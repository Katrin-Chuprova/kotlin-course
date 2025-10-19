package org.example.lessons.lesson11.homeworks

//Задачи на сигнатуру метода

//Напишите сигнатуру метода в которую входит модификатор доступа, название функции,
// список аргументов с типами и возвращаемое значение. В теле метода можешь сделать возврат объекта
// нужного типа если это требуется для устранения ошибок.

//1. Не принимает аргументов и не возвращает значения.
public fun ping(): Unit {}

//2. Принимает два целых числа и возвращает их сумму.
public fun sum(a: Int, b: Int): Int = a + b

//3. Принимает строку и ничего не возвращает.
public fun str(s: String): Unit {}

//4. Принимает список целых чисел и возвращает среднее значение типа Double.
public fun averageOf(numbers: List<Int>): Double {
    var sum = 0
    for (n in numbers) sum += n
    return sum.toDouble()/numbers.size
}

//5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только
// в текущем файле.
private fun nullableLength(s: String?): Int? = s?.length

//6. Не принимает аргументов и возвращает nullable вещественное число.
public fun getMaybeDouble(): Double? = null

//7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun nullableList(numbers: List<Int>?): Unit {}

//8. Принимает целое число и возвращает nullable строку.
public fun intOrNull(n: Int): String? = n.toString()

//9. Не принимает аргументов и возвращает список nullable строк.
public fun provideStrings(): List<String?> = listOf("one", null, "three")

//10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
public fun hasLengthEqual(s: String?, n: Int?): Boolean? =
    if (s != null && n != null) (s.length == n) else null

//Задачи на написание кода
//Напишите валидную сигнатуру метода, а так же рабочий код для задач.

//11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(x: Int): Int = x * 2

//12. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное,
// и false в противном случае.
fun isEven(n: Int): Boolean = (n % 2 == 0)

//13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int): Unit {
    if (n < 1) return
    for (i in 1..n) {
        println(i)
    }
}

//14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое
// отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(nums: List<Int>): Int? {
    for (x in nums) {
        if (x < 0) return x
    }
    return null
}

//15. Напишите функцию processList, которая принимает список строк.
// Функция должна проходить по списку и выводить каждую строку.
// Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(items: List<String?>): Unit {
    for (item in items) {
        if (item == null) return
        println(item)
    }
}