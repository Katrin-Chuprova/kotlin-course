package lessons.lesson18.homeworks

// ===== ЗАДАНИЕ 4. База с температурой и открывающимися дверцами =====
abstract class TempOpenableProgrammableDevice :
    ProgrammablePoweredDevice(), TemperatureRegulatable, Openable {

    protected open val minTemperature: Int = 0
    abstract override val maxTemperature: Int

    private var doorOpened: Boolean = false
    protected var currentTemperature: Int? = null
        private set

    override fun open() {
        if (!doorOpened) {
            doorOpened = true
            println("[DOOR] Открыто")
        } else {
            println("[DOOR] Уже открыто")
        }
    }

    override fun close() {
        if (doorOpened) {
            doorOpened = false
            println("[DOOR] Закрыто")
        } else {
            println("[DOOR] Уже закрыто")
        }
    }

    override fun setTemperature(temp: Int) {
        if (!isPowered) {
            println("[TEMP] Нельзя установить температуру — питание выключено")
            return
        }
        if (temp !in minTemperature..maxTemperature) {
            println("[TEMP] Значение $temp вне допустимого диапазона [$minTemperature..$maxTemperature]")
            return
        }
        currentTemperature = temp
        println("[TEMP] Температура установлена: $temp°С")
    }
}
