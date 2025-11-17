package org.example.lessons.lesson20.homeworks

// Печатает строку по буквам: @user, затем буква (в верхнем регистре)
fun String.tweetBy(users: List<String>) {
    val up = this.uppercase()
    for (i in up.indices) {
        val who = users.getOrNull(i) ?: "user${i + 1}"
        println("@$who")
        println(up[i])
        println()
    }
}
