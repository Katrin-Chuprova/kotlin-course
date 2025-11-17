package org.example.lessons.lesson19.homeworks

/** Возвращает средний элемент, если размер списка нечётный, иначе null. */
fun <T> getMiddleElement(items: List<T>): T? =
    if (items.size % 2 == 1) items[items.size / 2] else null
