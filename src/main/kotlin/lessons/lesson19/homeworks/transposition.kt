package org.example.lessons.lesson19.homeworks

/** Меняет местами ключ и значение (при коллизиях последних побеждает последний). */
fun <K, V> transposition(source: Map<K, V>): Map<V, K> {
    val result = LinkedHashMap<V, K>()
    for ((k, v) in source) result[v] = k
    return result
}
