package org.example.lessons.lesson25.homeworks

/* ---------- Задание 1. Функция высшего порядка: timeTracker ---------- */

// Возвращаем пару: (время выполнения, результат блока)
inline fun <T> timeTracker(block: () -> T): Pair<Long, T> {
    val start = System.currentTimeMillis()
    val result = block()
    val elapsed = System.currentTimeMillis() - start
    return elapsed to result
}

/* ---------- Классы для заданий 2–6 ---------- */

class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}

/* ---------- Задание 2: apply для инициализации Employee ---------- */

fun createEmployeeWithApply(): Employee {
    return Employee(name = "Alice", age = 28, position = "QA")
        .apply {
            email = "alice@company.com"
            department = "Testing"
        }
}

/* ---------- Задание 3: also + with для логирования Person ---------- */

// красивая печать данных Person; внутри используем with, чтобы обращаться к полям напрямую
fun printPersonPretty(p: Person) {
    with(p) {
        println(
            """
            ── Person ──
            Name : $name
            Age  : $age
            Email: ${if (email.isBlank()) "(none)" else email}
            """.trimIndent()
        )
    }
}

// пример: создаём Person, добавляем почту через also и печатаем через нашу функцию
fun demoAlsoWith() {
    val p = Person("Bob", 32)
        .also { it.email = "bob@example.com" }
        .also { printPersonPretty(it) }
}

/* ---------- Задание 4: with для преобразования Person → Employee ---------- */

fun toEmployeeWith(person: Person, position: String): Employee {
    // with возвращает значение последней строки — новый Employee
    return with(person) {
        Employee(name, age, position).also { it.email = email }
    }
}

/* ---------- Задание 5: run для преобразования Person → Employee ---------- */

fun Person.toEmployeeRun(position: String): Employee {
    // run вызываем на Person, внутри контекст — это Person
    return this.run {
        Employee(name, age, position).also { it.email = email }
    }
}

/* ---------- Задание 6: let для безопасного преобразования Person? → Employee? ---------- */

fun Person?.toEmployee(position: String): Employee? =
    this?.let { p ->
        Employee(p.name, p.age, position).also { it.email = p.email }
    }

/* ---------- Небольшое демо всего выше ---------- */

fun main() {
    // Задание 1: timeTracker (вариант B: получаем и время, и результат)
    val (ms, sorted) = timeTracker {
        // при желании можно увеличить до 10_000_000, но это может занять время
        val list = List(1_000_000) { (0..10_000).random() }
        list.sorted()
    }
    println("timeTracker: блок выполнился за ${ms} мс, first=${sorted.firstOrNull()}")

    // Задание 2: apply
    val e1 = createEmployeeWithApply()
    println("apply -> ${e1.name}, ${e1.age}, ${e1.position}, ${e1.email}, dept=${e1.department}")

    // Задание 3: also + with (логирование)
    demoAlsoWith()

    // Задание 4: with преобразование
    val p = Person("Carol", 25).also { it.email = "carol@example.com" }
    val e2 = toEmployeeWith(p, "Designer")
    println("with -> ${e2.name}, ${e2.age}, ${e2.position}, ${e2.email}, dept=${e2.department}")

    // Задание 5: run преобразование
    val e3 = p.toEmployeeRun("Engineer")
    println("run -> ${e3.name}, ${e3.age}, ${e3.position}, ${e3.email}, dept=${e3.department}")

    // Задание 6: let на nullable Person
    val maybePerson: Person? = Person("Dima", 19).also { it.email = "dima@example.com" }
    val e4 = maybePerson.toEmployee("Intern")
    println("let (nullable) -> ${e4?.name}, ${e4?.age}, ${e4?.position}, ${e4?.email}")

    val none: Person? = null
    val e5 = none.toEmployee("Ghost")
    println("let (null input) -> $e5") // null
}
