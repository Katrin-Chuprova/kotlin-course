package org.example.lessons.lesson12.homeworks

fun main() {

//Задачи на приведение коллекции к значению

    val ex = listOf(28, 46, 57, 74, 95, 104)

// 1. Проверить, что размер коллекции больше 5 элементов.
    val r1 = ex.size > 5
    println("1) size > 5? $r1")

// 2. Проверить, что коллекция пустая
    val r2 = ex.isEmpty()
    println("2) isEmpty? $r2")

// 3. Проверить, что коллекция не пустая
    val r3 = ex.isNotEmpty()
    println("3) isNotEmpty? $r3")

// 4. Взять элемент по индексу или создать значение если индекса не существует
    val index = 10
    val r4 = ex.getOrElse(index) { -1 }           //вернёт -1, если индекса нет
    println("4) getOrElse($index)=$r4")

// 5. Собрать коллекцию в строку
    val r5 = ex.joinToString(separator = " : ")
    println("5) joinToString -> $r5")

// 6. Посчитать сумму всех значений
    val r6 = ex.sum()
    println("6) sum -> $r6")

// 7. Посчитать среднее
    val r7 = ex.average()
    println("7) average -> $r7")

// 8. Взять максимальное число
    val r8 = ex.maxOrNull()
    println("8) maxOrNull -> $r8")

// 9. Взять минимальное число
    val r9 = ex.minOrNull()
    println("9) minOrNull -> $r9")

// 10. Взять первое число или null
    val r10 = ex.firstOrNull()
    println("10) firstOrNull -> $r10")

// 11. Проверить что коллекция содержит элемент
    val r11 = ex.contains(48)
    println("11) contains(48) -> $r11")


//Задачи на обработку коллекций
    val texts: List<String?> = listOf("кот", null, "крыса", "", "попугай", "пес")

// 12. Отфильтровать коллекцию по диапазону 18-30
    val r12 = ex.filter { it in 18..30 }
    println("12) $r12")

// 13. Выбрать числа, которые не делятся на 2 и 3 одновременно
    val r13 = ex.filter { it % 6 != 0 }
    println("13) $r13")

// 14. Очистить текстовую коллекцию от null элементов
    val r14 = texts.filterNotNull()
    println("14) $r14")

// 15. Преобразовать текстовую коллекцию в коллекцию длин слов
    val r15 = texts.filterNotNull().filter { it.isNotEmpty() }.map { it.length }
    println("15) $r15")

// 16. Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов
    val r16: Map<String, Int> =
        texts.filterNotNull().filter { it.isNotEmpty() }
            .associate { it.reversed() to it.length }
    println("16) $r16")

// 17. Отсортировать список в алфавитном порядке
    val r17 = texts.filterNotNull().sorted()
    println("17) $r17")

// 18. Взять первые 3 элемента списка
    val r18 = ex.take(3)
    println("18) $r18")

// 19. Распечатать квадраты элементов списка
    ex.forEach { println("19) ${it * it}") }

// 20. Группировать список по первой букве слов
    val r20: Map<Char, List<String>> =
        texts.filterNotNull().filter { it.isNotEmpty() }
            .groupBy { it.first() }
    println("20) $r20")

// 21. Очистить список от дублей
    val r21 = ex.distinct()
    println("21) $r21")

// 22. Отсортировать список по убыванию
    val r22 = ex.sortedDescending()
    println("22) $r22")

// 23. Взять последние 3 элемента списка
    val r23 = ex.takeLast(3)
    println("23) $r23")

    /* Задача 24. Характеристика числовой коллекции

Напиши функцию, которая принимает коллекцию чисел и возвращает строку с характеристикой коллекции
используя конструкцию when

Если коллекция пустая - “Пусто”
Если количество элементов меньше пяти - “Короткая”
Если коллекция начинается с 0 - “Стартовая”
Если сумма всех чисел больше 10000 - “Массивная”
Если среднее значение равно 10 - “Сбалансированная”
Если длина строки образованная склеиванием коллекции в строку равна 20 - “Клейкая”
Если максимальное число меньше -10 - “Отрицательная”
Если минимальное число больше 1000 - “Положительная”
Если содержит одновременно числа 3 и 14 - “Пи***тая”
Иначе - “Уникальная”
Вызвать метод с данными, подходящими под каждую из веток */

    fun collection(nums: List<Int>): String {
        if (nums.isEmpty()) return "Пусто"
        val size = nums.size
        val startsWithZero = nums.first() == 0
        val sum = nums.sum()
        val avg = nums.average()
        val joinedLen = nums.joinToString("").length
        val max = nums.maxOf { it }
        val min = nums.minOf { it }
        val hasPi = (3 in nums) && (14 in nums)

        return when {
            size < 5 -> "Короткая"
            startsWithZero -> "Стартовая"
            sum > 10_000 -> "Массивная"
            avg == 10.0 -> "Сбалансированная"  // при желании: abs(avg-10.0) < 1e-9
            joinedLen == 20 -> "Клейкая"
            max < -10 -> "Отрицательная"
            min > 1000 -> "Положительная"
            hasPi -> "Пи***тая"
            else -> "Уникальная"
        }
    }

    /* Задача 25. Анализ учебных оценок

Напиши функцию, которая принимает список чисел и возвращает список чисел.

Пример данных: val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)

Цель: Отфильтровать удовлетворительные оценки (>=60), отсортировать оставшиеся по возрастанию и взять
первые 3. Вызывай методы обработки и фильтрации последовательно один из другого, чтобы результат
предыдущего метода являлся основой для следующего. */

    fun analyzeGrades(grades: List<Int>): List<Int> {
        return grades
            .filter { it >= 60 }
            .sorted()
            .take(3)
    }

    /* Задача 26. Создание каталога по первой букве

Напиши функцию, которая принимает список строк и возвращает словарь с ключом - буквой и значением - строкой.

Начальные значения: val list = listOf(
"Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина",
"столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка",
"телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус",
"статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник",
"Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка")

Цель: Привести все слова в списке к нижнему регистру, сгруппировать в каталог по первой букве используя
метод groupBy */
    fun catalogByFirstLetter(items: List<String>): Map<Char, List<String>> {
        val normalized = items
            .filter { it.isNotBlank() }      // игнорируем пустые/пробельные
            .map { it.trim().lowercase() }   // обрезаем пробелы по краям и приводим к нижнему регистру
        return normalized.groupBy { it.first() } // ключ — первая буква, значение — список слов
    }


    /* Задание 27. Подсчёт средней длины слов в списке

Напиши функцию, которая принимает список строк и возвращает строку.

Начальные значения взять из предыдущей задачи.

Цель: Перевести все слова в количество букв, подсчитать среднее значение.
Вернуть форматированный текст с двумя знаками после запятой, используя функцию format и подходящий шаблон.
 */
    fun averageWordLengthText(items: List<String>): String {
        if (items.isEmpty()) return "Нет данных"

        val avg = items
            .map { it.trim() }
            .map { it.replace(" ", "") }   // считаем только буквы, без пробелов
            .map { it.length }
            .average()

        val formatted = String.format(java.util.Locale("ru", "RU"), "%.2f", avg)
        return "Средняя длина слов: $formatted"
    }

    /* Задание 28: Категоризация чисел

Напиши функцию, которая принимает список чисел и возвращает словарь с ключами - строками и значениями - числами.

Начальные значения: val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)

Цель: Отобрать уникальные числа, отсортировать по убыванию и сгруппировать по четности (“четные” и “нечетные”). */

    fun categorizeByParity(numbers: List<Int>): Map<String, List<Int>> {
        val normalized = numbers
            .distinct()            // 1) убираем дубликаты
            .sortedDescending()    // 2) сортируем по убыванию

        return normalized.groupBy { n ->  // 3) группируем по чётности
            if (n % 2 == 0) "четные" else "нечетные"
        }
    }

    /* Задание 29: Поиск первого подходящего элемента

Напиши функцию, которая принимает список чисел и число и возвращает nullable число.

Начальные значения: val ages = listOf(22, 18, 30, 45, 17, null, 60) и число для проверки возраста,
например 18.

Цель: Найти первый возраст в списке, который соответствует условию (больше второго аргумента) и вернуть его,
либо null если значения не нашлось.
*/
    fun findFirstOlderLoop(ages: List<Int?>, limit: Int): Int? {
        for (age in ages) {
            if (age != null && age > limit) return age
        }
        return null
    }

    println("\n=== 24 ===")
    println("Пусто -> " + collection(emptyList()))
    println("Короткая -> " + collection(listOf(1, 2, 3, 4)))
    println("Стартовая -> " + collection(listOf(0, 5, 6, 7, 8)))
    println("Массивная -> " + collection(listOf(2000, 2000, 2500, 2000, 1600)))
    println("Сбалансированная -> " + collection(listOf(9, 10, 11, 10, 10)))
    println("Клейкая -> " + collection(listOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 10)))
    println("Отрицательная -> " + collection(listOf(-11, -12, -13, -14, -15)))
    println("Положительная -> " + collection(listOf(1001, 1002, 1003, 1004, 1005)))
    println("Пи***тая -> " + collection(listOf(5, 3, 8, 14, 1)))
    println("Уникальная -> " + collection(listOf(1, 2, 4, 5, 7)))

    println("\n=== 25 ===")
    val grades1 = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    println("Базовый пример -> " + analyzeGrades(grades1))         // ожидаем [67, 74, 85]
    println("Меньше трёх проходных -> " + analyzeGrades(listOf(10, 60, 61))) // [60, 61]
    println("Пустой список -> " + analyzeGrades(emptyList()))       // []

    println("\n=== 26 ===")
    val sample26 = listOf("Стол", "табурет", "Вазон", "столик", "Часы", "лампа")
    val catalog = catalogByFirstLetter(sample26)
    println("Ключи каталога: " + catalog.keys.sorted())
    println("Группа на 'с': " + catalog['с'])  // слова на 'с' в нижнем регистре, если есть

    println("\n=== 27 ===")
    println(averageWordLengthText(sample26))
    println(averageWordLengthText(emptyList()))   // Нет данных

    println("\n=== 28 ===")
    val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    val categorized = categorizeByParity(numbers)
    println(categorized)

    println("\n=== 29 ===")
    val ages = listOf(22, 18, 30, 45, 17, null, 60)
    println("limit=18 -> " + findFirstOlderLoop(ages, 18))  // 22
    println("limit=60 -> " + findFirstOlderLoop(ages, 60))  // null
    println("limit=17 -> " + findFirstOlderLoop(ages, 17))  // 22

}