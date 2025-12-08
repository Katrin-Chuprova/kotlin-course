package org.example.lessons.lesson24.homeworks

//1) Создай функцию, которая:
//a) принимает булево значение
//b) принимает функцию, принимающую строку и ничего не возвращающую
//c) возвращает целое число

fun doWithFlag(flag: Boolean, consumer: (String) -> Unit): Int {
    consumer("flag=$flag")
    return if (flag) 1 else 0
}

//2) Создай функцию расширения целого числа, которая:
//a) принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//b) возвращает список строк

fun Int.applyWith(f: Int.(String) -> List<String>): List<String> =
    this.f(this.toString())

//3) Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//a) принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//b) возвращает второй дженерик

fun <T, R> T.runWith(block: T.() -> R): R = this.block()


//4) Создай функцию, которая:
//a) принимает строку
//b) возвращает функцию, которая ничего не принимает и возвращает строку

fun makeSupplier(text: String): () -> String = { text }

//5) Создай функцию расширяющую дженерик, которая:
//a) ничего не принимает
//b) возвращает функцию, принимающую строку и возвращающую дженерик

fun <T> T.produce(): (String) -> T = { _ -> this }

// Задание 6.
//Скопируй набор кодов цвета и функцию окрашивания строки в переданный в неё цвет из набора.
//object Colors {
//   const val RESET = "\u001B[0m"
//   const val RED = "\u001B[31m"
//   const val GREEN = "\u001B[32m"
//   const val YELLOW = "\u001B[33m"
//   const val BLUE = "\u001B[34m"
//   const val PURPLE = "\u001B[35m"
//   const val CYAN = "\u001B[36m"
//   const val WHITE = "\u001B[37m"
//}
//fun String.colorize(color: String): String {
//   return "$color$this${Colors.RESET}"
//}
//Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу
// разным цветом. Правило подбора цвета для каждого слова нужно передавать в виде функции, которая
// принимает слово и возвращает это же слово но уже "в цвете" через функцию colorize.
//Функция colorizeWords должна расширять строку и эту же строку и обрабатывать.
//
//Напиши несколько функций обработки слов:
//цвет слова зависит от его характеристик (для каждой характеристики отдельный цвет):
//начинается с большой буквы
//длина меньше трёх символов
//длина больше 6 символов
//длина кратна двум
//для всех прочих отдельный цвет.
//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик. Когда счётчик доходит до края списка слов - он обнуляется и начинается заново.
//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик. Счётчиком управляет функция, находящаяся в изменяемой переменной. Сначала это функция с инкрементом счётчика. Когда счётчик доходит до края списка цветов, нужно заменить функцию счётчика на функцию с декрементом. Когда счётчик доходит до нуля - заменить функцию счётчика на функцию с инкрементом и так далее.
//Создай переменную с длинным текстом (например из этого урока) и вызови у этой переменной функцию colorizeWords и передай в неё по очереди каждую из функций, проверь результат в консоли.

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

fun String.colorize(color: String): String = "$color$this${Colors.RESET}"

fun String.colorizeWords(pick: (String) -> String) {
    val colored = this
        .trim()
        .split(Regex("\\s+"))
        .filter { it.isNotEmpty() }
        .map(pick)
        .joinToString(" ")
    println(colored)
}

fun pickByFeatures(word: String): String {
    val color = when {
        word.firstOrNull()?.isUpperCase() == true -> Colors.CYAN
        word.length < 3                            -> Colors.YELLOW
        word.length > 6                            -> Colors.PURPLE
        word.length % 2 == 0                       -> Colors.GREEN
        else                                       -> Colors.WHITE
    }
    return word.colorize(color)
}

fun roundRobinColorizer(colors: List<String>): (String) -> String {
    val palette = if (colors.isEmpty()) listOf(Colors.WHITE) else colors
    var i = 0
    return { w ->
        val c = palette[i]
        i = (i + 1) % palette.size
        w.colorize(c)
    }
}

fun pingPongColorizer(colors: List<String>): (String) -> String {
    val palette = if (colors.isEmpty()) listOf(Colors.WHITE) else colors
    if (palette.size == 1) return { w -> w.colorize(palette[0]) }

    var idx = 0
    var inc: () -> Unit = { idx++ }
    var dec: () -> Unit = { idx-- }
    var stepper: () -> Unit = inc

    return { w ->
        val colored = w.colorize(palette[idx])

        // шаг
        stepper()

        // смена направления на краях
        if (idx >= palette.size - 1) stepper = dec
        if (idx <= 0)                stepper = inc

        colored
    }
}

fun main() {
    val text = "Объектно ориентированное программирование это про людей и связи"

    println("— По характеристикам —")
    text.colorizeWords(::pickByFeatures)

    println("\n— Round-robin —")
    val rr = roundRobinColorizer(listOf(Colors.RED, Colors.GREEN, Colors.BLUE, Colors.PURPLE))
    text.colorizeWords(rr)

    println("\n— Пинг-понг —")
    val pp = pingPongColorizer(listOf(Colors.CYAN, Colors.YELLOW, Colors.WHITE, Colors.RED))
    text.colorizeWords(pp)
}
