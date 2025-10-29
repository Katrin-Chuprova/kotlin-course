package org.example.lessons.lesson14.homeworks

// Класс «Концерт»: инкапсулируем проданные билеты и проверяем инварианты
class Concert(
    val band: String,      // группа
    val venue: String,     // место проведения
    val price: Double,     // стоимость
    val capacity: Int      // вместимость зала
) {
    private var soldTickets: Int = 0  // приватное поле «проданные билеты»

    init {
        require(price >= 0) { "Цена не может быть отрицательной" }
        require(capacity >= 0) { "Вместимость не может быть отрицательной" }
    }

    fun info() {
        val left = capacity - soldTickets
        println(
            "Концерт: $band | Место: $venue | Цена: $price | " +
                    "Вместимость: $capacity | Продано: $soldTickets | Осталось: $left"
        )
    }

    /** Покупка билета: true — успешно, false — sold out */
    fun buyTicket(): Boolean {
        return if (soldTickets < capacity) {
            soldTickets++
            true
        } else {
            println("Билеты раскуплены — SOLD OUT")
            false
        }
    }
}

// Быстрый прогон
fun main() {
    val gig = Concert(
        band = "Искры Ночного Города",
        venue = "A2 Green Concert",
        price = 2500.0,
        capacity = 3
    )
    gig.info()                 // стартовое состояние
    gig.buyTicket()            // 1
    gig.buyTicket()            // 2
    gig.buyTicket()            // 3 — ещё есть место
    gig.buyTicket()            // 4 — SOLD OUT
    gig.info()                 // проверим, что продано = 3
}
