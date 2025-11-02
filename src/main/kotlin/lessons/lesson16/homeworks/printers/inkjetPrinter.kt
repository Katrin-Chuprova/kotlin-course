package lessons.lesson16.homeworks.printers
import lessons.lesson16.homeworks.Ansi

/** Струйный: каждое слово — свой цвет текста и фона, циклически */
class InkjetPrinter : Printer() {

    private val styles: List<Pair<String, String>> = listOf(
        Ansi.FG_WHITE to Ansi.BG_BLUE,
        Ansi.FG_BLACK to Ansi.BG_YELLOW,
        Ansi.FG_WHITE to Ansi.BG_MAGENTA,
        Ansi.FG_BLACK to Ansi.BG_CYAN,
        Ansi.FG_WHITE to Ansi.BG_GREEN,
        Ansi.FG_WHITE to Ansi.BG_RED,
    )

    override fun print(text: String) {
        val words = text.split(Regex("\\s+")).filter { it.isNotBlank() }
        for ((i, w) in words.withIndex()) {
            val (fg, bg) = styles[i % styles.size]
            println(Ansi.color(w, fg, bg))
        }
    }
}