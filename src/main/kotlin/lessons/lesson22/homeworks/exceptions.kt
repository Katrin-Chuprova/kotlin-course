package org.example.lessons.lesson22.homeworks

// Задание 1–8: короткие фрагменты кода, которые приводят к выбросу исключений/ошибок.

fun causeNullPointerException() {
    val s: String? = null
    println(s!!.length)           // NPE
}

fun causeIndexOutOfBoundsException() {
    val list = listOf(1)
    println(list[2])              // IndexOutOfBoundsException
}

fun causeClassCastException() {
    val any: Any = 123
    val s = any as String         // ClassCastException
    println(s.length)
}

fun causeIllegalArgumentException() {
    require(false) { "Плохой аргумент" }    // IllegalArgumentException
}

fun causeNumberFormatException() {
    "12x".toInt()                 // NumberFormatException
}

fun causeIllegalStateException() {
    check(false) { "Плохое состояние" }     // IllegalStateException
}

/**
 * OutOfMemoryError — опасно реально вызывать. Для демонстрации безопаснее
 * использовать параметр simulate=true (просто бросаем ошибку).
 * Если simulate=false — пытаемся аллоцировать память до OOME (не рекомендуется).
 */
fun causeOutOfMemoryError(simulate: Boolean = true) {
    if (simulate) throw OutOfMemoryError("simulated OOME")
    val junk = mutableListOf<ByteArray>()
    while (true) junk += ByteArray(50_000_000) // может уронить процесс
}

/**
 * StackOverflowError — тоже опасно. По умолчанию симулируем.
 */
fun causeStackOverflowError(simulate: Boolean = true) {
    if (simulate) throw StackOverflowError("simulated SOE")
    fun rec(): Unit = rec()
    rec()
}

// Задание 9: "оберни вызовы в try-catch и сделай отдельные catch"
inline fun runWithAllCatches(title: String, block: () -> Unit) {
    println("\n— $title —")
    try {
        block()
        println("✓ без исключений")
    } catch (e: NullPointerException) {
        println("catch: NullPointerException — ${e.message}")
    } catch (e: IndexOutOfBoundsException) {
        println("catch: IndexOutOfBoundsException — ${e.message}")
    } catch (e: ClassCastException) {
        println("catch: ClassCastException — ${e.message}")
    } catch (e: IllegalArgumentException) {
        println("catch: IllegalArgumentException — ${e.message}")
    } catch (e: NumberFormatException) {
        println("catch: NumberFormatException — ${e.message}")
    } catch (e: IllegalStateException) {
        println("catch: IllegalStateException — ${e.message}")
    } catch (e: OutOfMemoryError) {
        println("catch: OutOfMemoryError — ${e.message}")
    } catch (e: StackOverflowError) {
        println("catch: StackOverflowError — ${e.message}")
    } catch (e: Throwable) {
        println("catch: ${e::class.simpleName} — ${e.message}")
    }
}

// Задание 10
fun processAny(value: Any?) {
    try {
        // 1) NullPointerException
        val asString = value!!.toString()

        // 2) IndexOutOfBoundsException (список из одного элемента, берём второй)
        val oob = listOf(asString)[1]
        println(oob) // не дойдём, если выбросится исключение выше

        // 3) ClassCastException
        val forced: MutableList<String> = value as MutableList<String>
        println(forced)

        // 4) IllegalArgumentException
        require(false) { "Недопустимый аргумент" }

        // 5) NumberFormatException
        "abc".toInt()

        // 6) IllegalStateException
        check(false) { "Недопустимое состояние" }

        println("Фантастически хорош: $value")
    } catch (t: Throwable) {
        when (t) {
            is NullPointerException       -> println("Поймано: NullPointerException")
            is IndexOutOfBoundsException  -> println("Поймано: IndexOutOfBoundsException")
            is ClassCastException         -> println("Поймано: ClassCastException")
            is IllegalArgumentException   -> println("Поймано: IllegalArgumentException")
            is NumberFormatException      -> println("Поймано: NumberFormatException")
            is IllegalStateException      -> println("Поймано: IllegalStateException")
            else                          -> println("Поймано: ${t::class.simpleName}")
        }
        // Сразу прекращаем работу вызывающего потока, как требует задание:
        throw t
    }
}

// Задание 11
class MyAssertionException(message: String) : AssertionError(message)

// Задание 12
class WrappedIndexOutOfBoundsException(
    val original: IndexOutOfBoundsException
) : RuntimeException(original)

fun main() {

    // === Задания 1–8: вызовы + Задание 9: общий обработчик ===
    runWithAllCatches("1) NullPointerException") { causeNullPointerException() }
    runWithAllCatches("2) IndexOutOfBoundsException") { causeIndexOutOfBoundsException() }
    runWithAllCatches("3) ClassCastException") { causeClassCastException() }
    runWithAllCatches("4) IllegalArgumentException") { causeIllegalArgumentException() }
    runWithAllCatches("5) NumberFormatException") { causeNumberFormatException() }
    runWithAllCatches("6) IllegalStateException") { causeIllegalStateException() }
    runWithAllCatches("7) OutOfMemoryError (simulated)") { causeOutOfMemoryError(simulate = true) }
    runWithAllCatches("8) StackOverflowError (simulated)") { causeStackOverflowError(simulate = true) }

    // === Задание 10: processAny ===
    println("\n— 10) processAny(null) —")
    try {
        processAny(null)
    } catch (_: Throwable) { /* глушим, чтобы продолжить демо */ }

    println("\n— 10) processAny(\"ok\") —")
    try {
        processAny("ok")  // упрётся в IndexOutOfBounds
    } catch (_: Throwable) { }

    // === Задание 11: собственное исключение AssertionError-наследник ===
    println("\n— 11) MyAssertionException —")
    try {
        throw MyAssertionException("Моя проверка не прошла")
    } catch (e: MyAssertionException) {
        println("Поймано MyAssertionException: ${e.message}")
    }

    // === Задание 12: обёртка над IndexOutOfBoundsException ===
    println("\n— 12) WrappedIndexOutOfBoundsException —")
    try {
        try {
            val xs = listOf(1, 2, 3)
            println(xs[10])                 // провоцируем IndexOutOfBoundsException
        } catch (ioob: IndexOutOfBoundsException) {
            println("Перехватили исходный IOOBE: ${ioob.message}")
            throw WrappedIndexOutOfBoundsException(ioob)
        }
    } catch (w: WrappedIndexOutOfBoundsException) {
        println("Поймали WrappedIndexOutOfBoundsException, причина: ${w.cause?.javaClass?.simpleName}")
    }

    println("\n— DEMO завершено —")
}
