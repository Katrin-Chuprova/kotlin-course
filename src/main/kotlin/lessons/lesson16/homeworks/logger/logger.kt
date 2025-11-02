package lessons.lesson16.homeworks.logger
import lessons.lesson16.homeworks.Ansi

class Logger {

    /** Базовый — INFO */
    fun log(message: String) {
        println("${Ansi.color("[INFO]", Ansi.FG_GREEN)} $message")
    }

    /** Явный уровень; WARNING жёлтым, ERROR — белым на красном фоне */
    fun log(level: Level, message: String) {
        val prefix = when (level) {
            Level.INFO    -> Ansi.color("[INFO]", Ansi.FG_GREEN)
            Level.WARNING -> Ansi.color("[WARNING]", Ansi.FG_YELLOW)
            Level.ERROR   -> Ansi.color("[ERROR]", Ansi.FG_WHITE, Ansi.BG_RED)
            Level.DEBUG   -> Ansi.color("[DEBUG]", Ansi.FG_CYAN)
        }
        println("$prefix $message")
    }

    /** Список сообщений — все как INFO */
    fun log(messages: List<String>) {
        for (m in messages) log(m)
    }

    /** Исключение — как ERROR с его message */
    fun log(e: Exception) {
        val msg = e.message ?: e.toString()
        log(Level.ERROR, msg)
    }
}
