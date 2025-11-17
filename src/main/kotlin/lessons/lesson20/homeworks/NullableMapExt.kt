package org.example.lessons.lesson20.homeworks

// Nullable словарь: берём из каждого списка элемент по индексу, ключи -> toString()
fun <K, V> Map<K, List<V>>?.pickAt(index: Int): Map<String, V?>? =
    this?.mapValues { (_, list) -> list.getOrNull(index) }
        ?.mapKeys  { (k, _) -> k.toString() }
