package org.example.lessons.lesson08.homeworks

fun main() {

    println("=== Задача 1 ===")
    val phrases = listOf(
        "Это невозможно выполнить за один день",
        "Я не уверен в успехе этого проекта",
        "Произошла катастрофа на сервере",
        "Этот код работает без проблем",
        "Удача"
    )
    for (text in phrases) {
        println(transformPhrase(text))
    }

    println("\n=== Задача 2 ===")
    extractDateTime("Пользователь вошел в систему -> 2021-12-01 09:48:23")

    println("\n=== Задача 3 ===")
    maskCardNumber("4539 1488 0343 6467")

    println("\n=== Задача 4 ===")
    formatEmail("username@example.com")

    println("\n=== Задача 5 ===")
    extractFileName("C:/Пользователи/Документы/report.txt")
    extractFileName("D:/good.themes/dracula.theme")

    println("\n=== Задача 6 ===")
    createAbbreviation("Котлин лучший язык программирования")
}


/* 1. Преобразование строк
    Создайте функцию, которая будет анализировать входящие фразы и применять к ним различные преобразования,
    делая текст более ироничным или забавным. Функция должна уметь распознавать ключевые слова или условия и
    соответственно изменять фразу.*/
fun transformPhrase(phrase: String): String {
    val cleaned = phrase.trim()
    val words = cleaned.split(" ")

    return when {
        cleaned.contains("невозможно") ->
            cleaned.replace("невозможно", "совершенно точно возможно, просто требует времени")

        cleaned.startsWith("Я не уверен") ->
            "$cleaned, но моя интуиция говорит об обратном"

        cleaned.contains("катастрофа") ->
            cleaned.replace("катастрофа", "интересное событие")

        cleaned.endsWith("без проблем") ->
            cleaned.replace("без проблем", "с парой интересных вызовов на пути")

        words.size == 1 ->
            "Иногда, $cleaned, но не всегда"

        else -> cleaned
    }
}

/* 2. Извлечение даты из строки лога
    У вас есть строка лога, например "Пользователь вошел в систему -> 2021-12-01 09:48:23"
    (данные могут быть любыми, но формат всегда такой).
    Извлеките отдельно дату и время из этой строки и сразу распечатай их по очереди.
    Используй indexOf или split для получения правой части сообщения.
    */
fun extractDateTime(log: String) {
    val parts = log.split("->")
    val dateTime = parts[1].trim()
    val date = dateTime.substring(0, 10)
    val time = dateTime.substring(11)
    println("Дата: $date")
    println("Время: $time")
}

/* 3. Маскирование личных данных
    Дана строка с номером кредитной карты, например "4539 1488 0343 6467".
    Замаскируйте все цифры, кроме последних четырех, символами "*".
    */
fun maskCardNumber(card: String) {
    val digits = card.replace(" ", "")
    val masked = "*".repeat(digits.length - 4) + digits.takeLast(4)
    println(masked)
}

/* 4. Форматирование адреса электронной почты.
    У вас есть электронный адрес, например "username@example.com".
    Преобразуйте его в строку "username [at] example [dot] com", используя функцию replace().
     */
fun formatEmail(email: String) {
    val formatted = email.replace("@", " [at] ").replace(".", " [dot] ")
    println(formatted)
}

/* 5. Извлечение имени файла из пути.
    Дан путь к файлу, например "C:/Пользователи/Документы/report.txt" или
    "D:/good.themes/dracula.theme" (может быть любым). Извлеките название файла с расширением.
     */
fun extractFileName(path: String) {
    val parts = path.split("/")
    val fileName = parts.last()
    println(fileName)
}

/* 6. Создание аббревиатуры из фразы.
    У вас есть фраза, например "Котлин лучший язык программирования"
    (может быть любой с разделителями слов - пробел). Создайте аббревиатуру из начальных букв слов (например, "ООП").
    Используйте split. Используйте for для перебора слов. Используйте var переменную для накопления первых букв.
     */
fun createAbbreviation(phrase: String) {
    val words = phrase.split(" ")
    var abbreviation = ""
    for (word in words) {
        if (word.isNotEmpty()) {
            abbreviation += word[0].uppercaseChar()
        }
    }
    println(abbreviation)
}
