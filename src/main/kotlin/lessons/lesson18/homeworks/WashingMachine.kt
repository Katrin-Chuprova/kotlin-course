package lessons.lesson18.homeworks

class WashingMachine :
    TempOpenableProgrammableDevice(),
    WaterConnection, Drainable, Timable, Cleanable {

    override val maxTemperature: Int = 90
    override val minTemperature: Int = 20

    override fun connectToWaterSupply() {
        println("[WM] Подключена к водопроводу")
    }

    override fun getWater(amount: Int) {
        println("[WM] Набор воды: $amount л")
    }

    override fun connectToDrain() {
        println("[WM] Подключена к сливу")
    }

    override fun drain() {
        println("[WM] Слив воды выполнен")
    }

    override fun setTimer(time: Int) {
        println("[WM] Таймер установлен на $time мин.")
    }

    override fun clean() {
        println("[WM] Очистка барабана выполнена")
    }
}
