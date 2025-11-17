package org.example.lessons.lesson19.homeworks

interface Mapper<FROM, TO> {
    fun map(item: FROM): TO
    fun mapList(items: List<FROM>): List<TO>
}
