package org.example.lessons.lesson20.homeworks

// Универсальный вариант для Array<T : Number>
fun <T : Number> Array<T>.firstLastOrNull(): Pair<T?, T?> =
    if (isEmpty()) Pair(null, null) else Pair(first(), last())

// Перегрузки для примитивных массивов
fun IntArray.firstLastOrNull(): Pair<Int?, Int?> =
    if (isEmpty()) Pair(null, null) else Pair(first(), last())

fun LongArray.firstLastOrNull(): Pair<Long?, Long?> =
    if (isEmpty()) Pair(null, null) else Pair(first(), last())

fun DoubleArray.firstLastOrNull(): Pair<Double?, Double?> =
    if (isEmpty()) Pair(null, null) else Pair(first(), last())

fun FloatArray.firstLastOrNull(): Pair<Float?, Float?> =
    if (isEmpty()) Pair(null, null) else Pair(first(), last())

fun ShortArray.firstLastOrNull(): Pair<Short?, Short?> =
    if (isEmpty()) Pair(null, null) else Pair(first(), last())

fun ByteArray.firstLastOrNull(): Pair<Byte?, Byte?> =
    if (isEmpty()) Pair(null, null) else Pair(first(), last())

