package org.example.lessons.lesson28.homeworks

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal
import java.util.Locale

/* =========================
   ВСПОМОГАТЕЛЬНЫЕ ФУНКЦИИ
   ========================= */

// Кастомное форматирование Temporal в зависимости от типа
fun formatTemporalCustom(t: Temporal): String = when (t) {
    is ZonedDateTime  -> t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z", Locale("ru")))
    is OffsetDateTime -> t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss XXX", Locale("ru")))
    is LocalDateTime  -> t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale("ru")))
    is OffsetTime     -> t.format(DateTimeFormatter.ofPattern("HH:mm:ss XXX", Locale("ru")))
    is LocalTime      -> t.format(DateTimeFormatter.ofPattern("HH:mm:ss", Locale("ru")))
    is LocalDate      -> t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale("ru")))
    is Instant        -> t.atZone(ZoneOffset.UTC)
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'", Locale("ru")))
    else              -> t.toString()
}

// ISO-форматирование Temporal
fun formatTemporalIso(t: Temporal): String = when (t) {
    is ZonedDateTime  -> t.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
    is OffsetDateTime -> t.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    is LocalDateTime  -> t.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    is OffsetTime     -> t.format(DateTimeFormatter.ISO_OFFSET_TIME)
    is LocalTime      -> t.format(DateTimeFormatter.ISO_LOCAL_TIME)
    is LocalDate      -> t.format(DateTimeFormatter.ISO_LOCAL_DATE)
    is Instant        -> DateTimeFormatter.ISO_INSTANT.format(t)
    else              -> t.toString()
}

/* =========================
   identifyGeneration()
   ========================= */

// Эталонные границы поколений
private val BOOMER_START = LocalDate.of(1946, 1, 1)
private val BOOMER_END   = LocalDate.of(1964, 12, 31)
private val ZOOMER_START = LocalDate.of(1997, 1, 1)
private val ZOOMER_END   = LocalDate.of(2012, 12, 31)

// Расширение для LocalDate: печатает, к какому поколению относится дата рождения
fun LocalDate.identifyGeneration() {
    val label = when {
        this in BOOMER_START..BOOMER_END -> "Бумер"
        this in ZOOMER_START..ZOOMER_END -> "Зумер"
        else -> "Не определено"
    }
    println("$this → $label")
}

/* =====
   main
   ===== */

fun main() {
    println("=== 1) Текущая метка времени (Instant.now) ===")
    val nowInstant: Instant = Instant.now()
    println(nowInstant)

    println("\n=== 2) Дата дня рождения ===")
    // ЗАМЕНИ на свою дату рождения:
    val myBirthday: LocalDate = LocalDate.of(1990, 5, 20)
    println(myBirthday)

    println("\n=== 3) Период от рождения до сегодня (годы) ===")
    val age: Period = Period.between(myBirthday, LocalDate.now())
    println("Лет: ${age.years}")

    println("\n=== 4) Форматирование Temporal (custom и ISO) ===")
    // 5) Разные объекты даты/времени БЕЗ now()
    val d: LocalDate            = LocalDate.of(2025, 1, 1)
    val lt: LocalTime           = LocalTime.of(14, 5, 30)
    val ldt: LocalDateTime      = LocalDateTime.of(2024, 2, 29, 13, 45, 10)
    val zdt: ZonedDateTime      = ZonedDateTime.of(2023, 6, 1, 9, 30, 0, 0, ZoneId.of("Europe/Berlin"))
    val odt: OffsetDateTime     = OffsetDateTime.of(2022, 3, 15, 8, 0, 0, 0, ZoneOffset.ofHours(3))
    val ot: OffsetTime          = OffsetTime.of(21, 10, 5, 0, ZoneOffset.ofHours(-5))
    val inst: Instant           = Instant.parse("2025-01-05T10:15:30Z")

    val temporals: List<Temporal> = listOf(d, lt, ldt, zdt, odt, ot, inst)
    temporals.forEach { t ->
        val custom = formatTemporalCustom(t)
        val iso    = formatTemporalIso(t)
        println("${t::class.simpleName} -> custom: $custom | iso: $iso")
    }

    println("\n=== 6) Определение поколения ===")
    LocalDate.of(1955, 2, 14).identifyGeneration() // Бумер
    LocalDate.of(2003, 9, 1).identifyGeneration()  // Зумер
    LocalDate.of(1988, 7, 7).identifyGeneration()  // Не определено

    println("\n=== 7–9) Форматер «день месяц» и влияние високосного года ===")
    val d2023 = LocalDate.of(2023, 2, 25)
    val d2024 = LocalDate.of(2024, 2, 25) // 2024 — високосный год
    val md: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM", Locale("ru"))

    val plus10_2023 = d2023.plusDays(10)
    val plus10_2024 = d2024.plusDays(10)

    println("2023-02-25 + 10 дней = ${plus10_2023.format(md)}")
    println("2024-02-25 + 10 дней = ${plus10_2024.format(md)}")
    // В 2023 получится 7 марта, в 2024 — 6 марта (из-за 29 февраля).
}
