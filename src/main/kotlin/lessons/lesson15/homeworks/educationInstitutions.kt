package org.example.lessons.lesson15.homeworks

// Базовый класс
open class EducationalInstitution(val name: String, val city: String) {
    open fun info() = println("$name ($city)")
}

// Производные: Школа и Высшее учебное заведение
open class School(name: String, city: String, val grades: IntRange) : EducationalInstitution(name, city) {
    override fun info() = println("Школа: $name, классы: ${grades.first}-${grades.last}, город: $city")
}

open class HigherInstitution(name: String, city: String, val accreditation: String)
    : EducationalInstitution(name, city)

// Доп. разветвление для HigherInstitution: Университет и Колледж
class University(name: String, city: String, accreditation: String, val facultiesCount: Int)
    : HigherInstitution(name, city, accreditation)

class College(name: String, city: String, accreditation: String, val specialty: String)
    : HigherInstitution(name, city, accreditation)

// Прогон
fun main() {
    val s = School("Гимназия №1", "СПб", 1..11)
    val u = University("ИТМО", "СПб", "гос.", facultiesCount = 12)
    val c = College("Колледж связи", "СПб", "гос.", specialty = "Телеком")

    s.info()
    u.info()
    c.info()
}
