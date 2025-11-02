package lessons.lesson16.homeworks.printers
import lessons.lesson16.homeworks.Ansi

/** Лазерный: слова по одному, чёрным на белом */
class LaserPrinter : Printer() {
    override fun print(text: String) {
        val words = text.split(Regex("\\s+")).filter { it.isNotBlank() }
        for (w in words) {
            println(Ansi.color(w, Ansi.FG_BLACK, Ansi.BG_WHITE))
        }
    }
}