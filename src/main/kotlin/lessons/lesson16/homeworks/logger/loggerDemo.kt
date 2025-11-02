package lessons.lesson16.homeworks.logger

fun demoLogger() {
    val L = Logger()
    L.log("System started")
    L.log(Level.DEBUG, "Debugging on")
    L.log(Level.WARNING, "Low disk space")
    L.log(Level.ERROR, "Connection lost")
    L.log(listOf("step 1", "step 2", "step 3"))
    L.log(RuntimeException("Boom!"))
}

fun main() {
    val logger = Logger()

    // Базовый INFO
    logger.log("Старт сценария")

    // Явные уровни
    logger.log(Level.DEBUG,   "Подготавливаем тестовые данные")
    logger.log(Level.WARNING, "Сервис ответил медленно")
    logger.log(Level.ERROR,   "База данных недоступна")

    // Список сообщений (все как INFO)
    logger.log(listOf("Первое сообщение", "Второе сообщение", "Третье"))

    // Исключение
    try {
        check(value = false) { "Искусственная ошибка для демонстрации" }
    } catch (e: IllegalStateException) {
        logger.log(e) // перегрузка для Exception
    }

    logger.log(Level.INFO, "Завершение сценария")
}
