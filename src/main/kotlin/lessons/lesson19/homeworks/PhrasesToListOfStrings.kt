package org.example.lessons.lesson19.homeworks

/** Разбивает фразу по пробелам в список слов. */
class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun map(item: String): List<String> =
        item.trim().split(" ").filter { it.isNotBlank() }

    /** Для списка фраз возвращаем список списков слов. */
    override fun mapList(items: List<String>): List<List<String>> =
        items.map { map(it) }
}
