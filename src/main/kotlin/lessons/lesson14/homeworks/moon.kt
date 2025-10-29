package org.example.lessons.lesson14.homeworks

// Singleton-объект Moon (создаётся один раз и доступен везде как Moon)
object Moon {
    var isVisible: Boolean = false
    var phase: String = "New Moon"

    fun showPhase() {
        println("Текущая фаза Луны: $phase")
    }
}

fun main() {
    // пример использования
    Moon.isVisible = true
    Moon.phase = "Full Moon"
    Moon.showPhase() // выведет: Текущая фаза Луны: Full Moon
}
