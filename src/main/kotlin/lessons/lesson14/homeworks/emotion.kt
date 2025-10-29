package org.example.lessons.lesson14.homeworks

// Класс Emotion: тип эмоции и интенсивность 0..10
class Emotion(
    val type: String,
    val intensity: Int
) {
    fun express() {
        // нормализуем интенсивность на всякий случай в диапазон 0..10
        val level = intensity.coerceIn(0, 10)

        // словесное описание силы эмоции
        val tone = when (level) {
            in 0..3  -> "лёгкая"
            in 4..7  -> "средняя"
            else     -> "сильная"
        }

        // реакция зависит от типа эмоции
        when (type.lowercase()) {
            "радость" -> println("Радость $tone: улыбаюсь и хочется обнять мир.")
            "грусть"  -> println("Грусть $tone: хочется побыть одной.")
            "злость"  -> println("Злость $tone: сжимаю кулаки и считаю до десяти.")
            "страх"   -> println("Страх $tone: сердце бьётся чаще.")
            "удивление"-> println("Удивление $tone: глаза широко открыты.")
            else      -> println("Эмоция $tone: $type.")
        }
    }
}

fun main() {
    val e1 = Emotion("Радость", 2)
    val e2 = Emotion("злость", 8)
    val e3 = Emotion("ностальгия", 5)

    e1.express()
    e2.express()
    e3.express()
}
