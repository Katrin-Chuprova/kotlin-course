package lessons.lesson18.homeworks

// ===== ЗАДАНИЕ 3. Базовый абстрактный класс программируемого оборудования =====
abstract class ProgrammablePoweredDevice : PoweredDevice(), Programmable {
    private var currentProgram: String? = null

    override fun programAction(action: String) {
        if (!isPowered) {
            println("[PROGRAM] Нельзя программировать — питание выключено")
            return
        }
        currentProgram = action
        println("[PROGRAM] Запрограммировано действие: \"$action\"")
    }

    override fun execute() {
        if (!isPowered) {
            println("[PROGRAM] Нельзя выполнить — питание выключено")
            return
        }
        val act = currentProgram ?: run {
            println("[PROGRAM] Нет заданного действия")
            return
        }
        println("[PROGRAM] Выполняю: \"$act\"")
    }
}
