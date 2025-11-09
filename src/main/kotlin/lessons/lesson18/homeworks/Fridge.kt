package lessons.lesson18.homeworks

// ===== ЗАДАНИЕ 5. Конкретные устройства =====

class Fridge : TempOpenableProgrammableDevice(), Cleanable, LightEmitting {
    override val maxTemperature: Int = 10
    override val minTemperature: Int = -24

    override fun clean() {
        println("[FRIDGE] Проведена уборка холодильника")
    }

    override fun emitLight() {
        println("[FRIDGE] Включён внутренний свет")
    }

    override fun completeLiteEmission() {
        println("[FRIDGE] Свет выключен")
    }
}
