package org.example.lessons.lesson10.homeworks

fun main() {

//Задачи на работу со словарём

//1. Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    println("=== Map 1 ===")
    val m1: Map<Int, Int> = emptyMap()
    println(m1)

//2. Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float,
// а значения - double
    println("\n=== Map 2 ===")
    val m2: Map<Float, Double> = mapOf(
        1.0f to 2.5,
        2.5f to 6.25,
        3.0f to 9.0
    )
    println(m2)

//3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    println("\n=== Map 3 ===")
    val m3: MutableMap<Int, String> = mutableMapOf(
        1 to "one",
        2 to "two"
    )
    println(m3)

//4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    println("\n=== Map 4 ===")
    m3.put(3, "three")
    m3.put(4, "four")
    println(m3)

//5. Используя словарь из предыдущего задания, извлеките значение, используя ключ.
// Попробуй получить значение с ключом, которого в словаре нет.
    println("\n=== Map 5 ===")
    val has2 = m3.get(2)          // есть
    val has99 = m3.get(99)        // нет -> вернётся null
    println("Ключ 2 -> $has2")
    if (has99 == null) {
        println("Ключ 99 отсутствует")
    }
//6. Удалите определенный элемент из изменяемого словаря по его ключу.
    println("\n=== Map 6 ===")
    m3.remove(1)
    println("После remove(1): $m3")

//7. Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение.
// Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    println("\n=== Map 7 ===")
    val m7: Map<Double, Int> = mapOf(
        10.0 to 2,
        7.5 to 0,
        3.0 to 3
    )
    for ((key, value) in m7) {
        if (value == 0) {
            println("$key / $value = бесконечность")
        } else {
            val res = key / value
            println("$key / $value = $res")
        }
    }

//8. Измените значение для существующего ключа в изменяемом словаре.
    println("\n=== Map 8 ===")
    val m8: MutableMap<String, Int> = mutableMapOf(
        "likes" to 10,
        "views" to 200
    )
    m8["likes"] = 11
    println(m8)

//9. Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    println("\n=== Map 9 ===")
    val m9a: Map<Int, String> = mapOf(1 to "A", 2 to "B")
    val m9b: Map<Int, String> = mapOf(3 to "C", 2 to "B2") // если ключи совпадут — перезапишем
    val m9c: MutableMap<Int, String> = mutableMapOf()
    for ((k, v) in m9a) {
        m9c[k] = v
    }
    for ((k, v) in m9b) {
        m9c[k] = v   // здесь при совпадении ключа значение перезапишется
    }
    println("Итоговый словарь: $m9c")

//10. Создайте словарь, где ключами являются строки, а значениями - списки целых чисел.
// Добавьте несколько элементов в этот словарь.
    println("\n=== Map 10 ===")
    val m10: MutableMap<String, List<Int>> = mutableMapOf()
    m10["чётные"] = listOf(2, 4, 6)
    m10["нечётные"] = listOf(1, 3, 5)
    println(m10)

//11. Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк.
// Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и
// добавь в это множество ещё строку. Распечатай полученное множество.
    println("\n=== Map 11 ===")
    val m11: MutableMap<Int, MutableSet<String>> = mutableMapOf(
        1 to mutableSetOf("red", "green"),
        2 to mutableSetOf("cat", "dog")
    )
    val setByKey = m11[1]
    if (setByKey != null) {
        setByKey.add("blue")
        println("Множество по ключу 1: $setByKey")
    } else {
        println("Ключ 1 не найден")
    }

//12. Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет
// содержать цифру 5 в качестве первого или второго значения.
    println("\n=== Map 12 ===")
    val m12: Map<Pair<Int, Int>, String> = mapOf(
        (1 to 5) to "A",
        (5 to 2) to "B",
        (3 to 4) to "C",
        (7 to 8) to "D"
    )
    var foundAny = false
    for ((pairKey, value) in m12) {
        val first = pairKey.first
        val second = pairKey.second
        if (first == 5 || second == 5) {
            println("Пара $pairKey содержит 5 -> значение: $value")
            foundAny = true
        }
    }
    if (!foundAny) {
        println("Подходящих пар не найдено")
    }

//Задачи на подбор оптимального типа для словаря

//1. Словарь библиотека: Ключи - автор книги, значения - список книг

//   Тип: Map<String, List<String>>
//   val library: Map<String, List<String>>

//2. Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"),
// значения - списки названий растений

//   Тип: Map<String, List<String>>
//   val plants: Map<String, List<String>>

//3. Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды

//   Тип: Map<String, List<String>>
//   val quarterFinal: Map<String, List<String>>

//4. Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату

//   Тип: Map<String, List<String>>   (если нужна дата как тип — можно LocalDate)
//   val treatment: Map<String, List<String>>

//5. Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.

//   Тип: Map<String, Map<String, List<String>>>
//   val travel: Map<String, Map<String, List<String>>>

}