package lessons.lesson18.homeworks

class Kettle : TempOpenableProgrammableDevice(), WaterContainer {

    override val maxTemperature: Int = 100
    override val minTemperature: Int = 0

    override val capacity: Int = 1500      // мл, условно
    private var currentWater: Int = 0

    override fun fillWater(amount: Int) {
        val newAmount = (currentWater + amount).coerceAtMost(capacity)
        println("[KETTLE] Наливаем воду: было $currentWater, добавляем $amount, стало $newAmount")
        currentWater = newAmount
    }

    override fun getWater(amount: Int) {
        val taken = amount.coerceAtMost(currentWater)
        println("[KETTLE] Наливаем из чайника $taken мл (запрашивали $amount)")
        currentWater -= taken
    }
}
