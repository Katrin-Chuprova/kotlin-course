package org.example.lessons.lesson29.homeworks

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

// ---------- Задание 1: модель ----------

enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM,           // Customer Relationship Manager
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    QA
}

data class Employee(
    val name: String,
    val employed: Boolean,
    val birthDate: String,          // упрощённо как строка (YYYY-MM-DD или любой формат)
    val role: CharacterTypes,
    val subordinates: List<Employee> = emptyList()
)

// ---------- Задание 2: собираем оргструктуру ----------

fun buildCompany(): Employee {
    // FE команда под тимлидом фронта
    val feTeamLead = Employee(
        name = "Lena TL (FE)",
        employed = true,
        birthDate = "1990-02-11",
        role = CharacterTypes.TEAM_LEAD,
        subordinates = listOf(
            Employee("Katya FE1", true, "1996-05-23", CharacterTypes.FRONTEND_DEV),
            Employee("Dmitry FE2", true, "1995-08-10", CharacterTypes.FRONTEND_DEV),
            Employee("Ira UX", true, "1994-01-30", CharacterTypes.UX_UI)
        )
    )

    // BE команда под тимлидом бэка
    val beTeamLead = Employee(
        name = "Sergey TL (BE)",
        employed = true,
        birthDate = "1989-10-01",
        role = CharacterTypes.TEAM_LEAD,
        subordinates = listOf(
            Employee("Pavel BE1", true, "1992-03-14", CharacterTypes.BACKEND_DEV),
            Employee("Olga BE2", true, "1993-07-07", CharacterTypes.BACKEND_DEV),
            Employee("Vlad SysAdmin", true, "1988-11-18", CharacterTypes.SYSADMIN)
        )
    )

    // PM ведёт обе команды
    val pm = Employee(
        name = "Anna PM",
        employed = true,
        birthDate = "1987-04-12",
        role = CharacterTypes.PM,
        subordinates = listOf(feTeamLead, beTeamLead, Employee("Nina QA", true, "1997-09-02", CharacterTypes.QA))
    )

    // CRM отдельной веткой от CTO
    val crm = Employee(
        name = "Ivan CRM",
        employed = true,
        birthDate = "1991-06-20",
        role = CharacterTypes.CRM
    )

    // CTO — корень
    val cto = Employee(
        name = "Alex CTO",
        employed = true,
        birthDate = "1983-12-05",
        role = CharacterTypes.CTO,
        subordinates = listOf(pm, crm)
    )

    return cto
}

// ---------- Задание 3: сериализация в файл (pretty printing) ----------

fun serializeCtoToFile(cto: Employee, file: File = File("employees.json"), gson: Gson = GsonBuilder().setPrettyPrinting().create()) {
    val json = gson.toJson(cto)
    file.writeText(json)
    println("JSON записан в: ${file.absolutePath}")
}

// ---------- Задание 4: чтение из файла и десериализация ----------

fun deserializeCtoFromFile(file: File = File("employees.json"), gson: Gson = GsonBuilder().setPrettyPrinting().create()): Employee {
    val text = file.readText()
    val obj = gson.fromJson(text, Employee::class.java)
    println("Прочитали из файла и восстановили объект CTO:\n$obj")
    return obj
}

// ---------- Задание 5 (необязательное): сгруппировать всех сотрудников по роли ----------

/** Рекурсивно разворачивает иерархию в плоский список (включая корень). */
fun flattenEmployees(root: Employee): List<Employee> {
    return listOf(root) + root.subordinates.flatMap { flattenEmployees(it) }
}

fun printGroupedByRole(cto: Employee) {
    val flat = flattenEmployees(cto)
    val grouped = flat.groupBy { it.role }
    println("\n=== Группировка по ролям ===")
    grouped.forEach { (role, employees) ->
        val names = employees.joinToString(", ") { it.name }
        println("$role: $names")
    }
}

// ---------- Демонстрация ----------

fun main() {
    val cto = buildCompany()

    // 3) сериализация
    serializeCtoToFile(cto)

    // 4) десериализация
    val restored = deserializeCtoFromFile()

    // 5) группировка (алгоритмическое)
    printGroupedByRole(restored)
}
