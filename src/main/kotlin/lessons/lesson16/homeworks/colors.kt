package lessons.lesson16.homeworks

/** ANSI-цвета для консоли */
object Ansi {
    const val RESET = "\u001B[0m"

    const val FG_BLACK = "\u001B[30m"
    const val FG_RED   = "\u001B[31m"
    const val FG_GREEN = "\u001B[32m"
    const val FG_YELLOW= "\u001B[33m"
    const val FG_BLUE  = "\u001B[34m"
    const val FG_MAGENTA="\u001B[35m"
    const val FG_CYAN  = "\u001B[36m"
    const val FG_WHITE = "\u001B[37m"

    const val BG_BLACK = "\u001B[40m"
    const val BG_RED   = "\u001B[41m"
    const val BG_GREEN = "\u001B[42m"
    const val BG_YELLOW= "\u001B[43m"
    const val BG_BLUE  = "\u001B[44m"
    const val BG_MAGENTA="\u001B[45m"
    const val BG_CYAN  = "\u001B[46m"
    const val BG_WHITE = "\u001B[47m"

    fun color(text: String, fg: String? = null, bg: String? = null): String =
        buildString {
            if (bg != null) append(bg)
            if (fg != null) append(fg)
            append(text)
            append(RESET)
        }
}
