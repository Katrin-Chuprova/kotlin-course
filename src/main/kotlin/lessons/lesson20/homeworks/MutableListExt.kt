package org.example.lessons.lesson20.homeworks

/**
 * 2) Для изменяемого списка Comparable-элементов:
 *    сортирует исходный список (true — по возрастанию, false — по убыванию)
 *    и возвращает неизменяемую копию.
 */

// Сортирует ИЗМЕНЯЕМЫЙ список на месте и возвращает его как read-only List
fun <T : Comparable<T>> MutableList<T>.sortAndFreeze(ascending: Boolean): List<T> {
    if (ascending) sort() else sortDescending()
    // Возвращаем "тот же" список, но через неизменяемый интерфейс
    return this as List<T>
}
