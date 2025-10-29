package org.example.lessons.lesson14.homeworks

// Событие: вечеринка. Создайте класс Party, который описывает вечеринку.
// У него должны быть свойства location (String) и attendees (Int). Добавьте метод details(),
// который выводит информацию о месте проведения и количестве гостей.

class Party(
    val location: String,
    val attendees: Int
) {
    fun details() {
        println("Вечеринка проходит в \"$location\". Гостей: $attendees.")
    }
}

// создаём объект и вызываем метод
fun main() {
    val party = Party(location = "Лофт на Невском", attendees = 25)
    party.details()
}
