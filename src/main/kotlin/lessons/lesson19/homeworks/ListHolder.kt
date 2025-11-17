package org.example.lessons.lesson19.homeworks

class ListHolder<T>(
    private val storage: MutableList<T> = mutableListOf()
) {
    fun add(item: T) { storage.add(item) }
    /** Возвращаем **неизменяемую** копию, чтобы снаружи список нельзя было портить. */
    fun getAll(): List<T> = storage.toList()
}
