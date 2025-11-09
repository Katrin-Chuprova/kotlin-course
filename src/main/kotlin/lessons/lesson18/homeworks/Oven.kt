package lessons.lesson18.homeworks

class Oven : TempOpenableProgrammableDevice(), Cleanable {
    override val maxTemperature: Int = 250
    override val minTemperature: Int = 30

    override fun clean() {
        println("[OVEN] Проведена очистка духовки (пароочистка)")
    }
}
