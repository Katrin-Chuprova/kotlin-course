package lessons.lesson18.homeworks

// ===== ЗАДАНИЕ 2. Базовый абстрактный класс включаемого оборудования =====
abstract class PoweredDevice : Powerable {
    protected var isPowered: Boolean = false
        private set

    override fun powerOn() {
        if (!isPowered) {
            isPowered = true
            println("[POWER] Устройство включено")
        } else {
            println("[POWER] Уже включено")
        }
    }

    override fun powerOff() {
        if (isPowered) {
            isPowered = false
            println("[POWER] Устройство выключено")
        } else {
            println("[POWER] Уже выключено")
        }
    }
}
