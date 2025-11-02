package lessons.lesson16.homeworks.printers

fun demoPrinters() {
    val phrase = "Kotlin makes concise, expressive, and safe code across platforms."
    println("-- Laser --")
    LaserPrinter().print(phrase)
    println("-- Inkjet --")
    InkjetPrinter().print(phrase)
}

fun main() {
    val laser = LaserPrinter()
    val inkjet = InkjetPrinter()

    val shortText = "Привет это тестовая фраза для принтера"
    val longText = "Струйный принтер должен разбивать фразу на слова и выводить их разноцветно " +
            "проверим как выглядит длинный текст в консоли в разных цветах"

    println("=== LaserPrinter ===")
    laser.print(shortText)
    println()
    laser.print("Ещё одна строка для проверки работы лазерного принтера")

    println("\n=== InkjetPrinter ===")
    inkjet.print(shortText)
    println()
    inkjet.print(longText)
}
