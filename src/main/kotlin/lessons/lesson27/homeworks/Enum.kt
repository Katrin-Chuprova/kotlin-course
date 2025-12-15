package org.example.lessons.lesson27.homeworks


//задание 1
enum class TestStatus {
    PASSED, BROKEN, FAILED
}

enum class RealEstateType(val title: String) {
    ROOM("Комната"),
    STUDIO("Студия"),
    APARTMENT("Квартира"),
    LOFT("Лофт"),
    DUPLEX("Дуплекс"),
    TOWNHOUSE("Таунхаус"),
    HOUSE("Дом"),
    COTTAGE("Коттедж"),
    VILLA("Вилла"),
    PENTHOUSE("Пентхаус");

    override fun toString(): String = title
}

enum class Planet(val distanceAu: Double, val massInEarths: Double) {
    MERCURY(0.39, 0.055),
    VENUS  (0.72, 0.815),
    EARTH  (1.00, 1.0),
    MARS   (1.52, 0.107),
    JUPITER(5.20, 317.8),
    SATURN (9.58, 95.2),
    URANUS (19.20, 14.5),
    NEPTUNE(30.05, 17.1);
}


// Задание 2
fun printRealEstateTypesByNameLengthAsc() {
    RealEstateType.values()
        .sortedBy { it.title.length }
        .forEachIndexed { i, t -> println("${i + 1}. ${t.title}") }
}

// Задание 3
fun evaluateTest(block: () -> Unit): TestStatus =
    try {
        block()
        TestStatus.PASSED
    } catch (e: AssertionError) {
        TestStatus.FAILED
    } catch (e: Throwable) {
        TestStatus.BROKEN
    }

// Задание 4
fun firstPlanetMatching(filter: (Planet) -> Boolean): Planet =
    Planet.values().firstOrNull(filter)
        ?: throw NoSuchElementException("Под условие не подошла ни одна планета")




fun main() {
    println("=== Задание 1: enum-и ===")
    println("Статусы: " + TestStatus.values().joinToString())
    println("Типы недвижимости по длине имени:")
    printRealEstateTypesByNameLengthAsc()

    println("\n=== Задание 3: evaluateTest ===")
    println("Без исключения: " + evaluateTest { /* ок */ })
    println("AssertionError -> " + evaluateTest { throw AssertionError("проверка не прошла") })
    println("Другое исключение -> " + evaluateTest { error("какая-то ошибка") })

    println("\n=== Задание 4: фильтр планет ===")
    val heavy = firstPlanetMatching { it.massInEarths > 300 } // ожидаем Jupiter
    println("Масса > 300: $heavy")

    val far = firstPlanetMatching { it.distanceAu > 10.0 }    // ожидаем Uranus
    println("Дальше 10 а.е.: $far")
}
