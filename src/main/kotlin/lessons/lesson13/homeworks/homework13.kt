package org.example.lessons.lesson13.homeworks

fun main() {

// 1. Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах.
// Определите среднее время выполнения теста.
    val testTimes = mapOf("login" to 1.8, "search" to 2.2, "checkout" to 3.0)
    val avgTime = testTimes.values.average()
    println("1) average = $avgTime")

// 2. Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов,
// а значения - строка с метаданными. Выведите список всех тестовых методов.
    val meta = mapOf("testLogin" to "owner=qa", "testSearch" to "smoke")
    val methods: List<String> = meta.keys.toList()
    println("2) methods = $methods")

// 3. В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val results = mutableMapOf("A" to "passed", "B" to "failed")
    results.put("C", "skipped")                           // put
    println("3) results = $results")

// 4. Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат
// из passed, failed, skipped).
    val passedCount = results.count { it.value == "passed" }
    println("4) passedCount = $passedCount")

// 5. Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен
// (ключ - название, значение - статус исправления).
    val bugs = mutableMapOf("BUG-1" to "fixed", "BUG-2" to "open")
    bugs.remove("BUG-1")                                   // remove
    println("5) bugs = $bugs")

// 6. Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа),
// выведите сообщение о странице и статусе её проверки.
    val pages = mapOf("/" to 200, "/about" to 404)
    pages.forEach { (url, status) ->
        println("6) $url -> $status")
    }

// 7.  Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val services = mapOf("auth" to 120, "billing" to 950, "feed" to 420)
    val slow = services.filterValues { it > 500 }
    println("7) slow = $slow")

// 8. В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
// Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val api = mapOf("/v1/users" to "200 OK", "/v1/pay" to "500 ERR")
    val ep = "/v1/profile"
    val status = api.getOrDefault(ep, "не протестирован")  // getOrDefault
    println("8) $ep -> $status")

// 9. Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации,
// значение - сама конфигурация), получите значение для "browserType". Ответ не может быть null.
    val cfg = mapOf("browserType" to "chrome", "headless" to "true")
    val browser = cfg.getValue("browserType")              // getValue (бросит, если ключа нет)
    println("9) browserType = $browser")

// 10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val versions = mapOf("1.0" to "stable", "1.1" to "beta")
    val versionsPlus = versions + ("1.2" to "rc")          // plus
    println("10) versionsPlus = $versionsPlus")

// 11. Используя словарь с настройками тестирования для различных мобильных устройств
// (ключ — модель устройства, значение - строка с настройками), получите настройки для конкретной модели
// или верните настройки по умолчанию.
    val deviceSettings = mapOf("Pixel 7" to "api33,arm64", "iPhone 13" to "iOS 17")
    val model = "Galaxy S22"
    val settingsForModel = deviceSettings.getOrElse(model) { "default-settings" }  // getOrElse
    println("11) $model -> $settingsForModel")

// 12. Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки)
// определенный код ошибки.
    val errs = mapOf(1001 to "NPE", 1002 to "Timeout")
    println("12) has 1002? ${errs.containsKey(1002)}")

// 13. Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
// а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь, оставив
// только те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в ключе
// содержится требуемая версия.
    val byVersion = mapOf("T1_v1" to "Passed", "T2_v2" to "Failed", "T3_v1" to "Skipped")
    val onlyV1 = byVersion.filterKeys { it.contains("v1") }// filterKeys
    println("13) onlyV1 = $onlyV1")

// 14. У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения —
// результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val modules = mapOf("auth" to "ok", "feed" to "fail", "chat" to "ok")
    val hasFailedModule = modules.values.any { it == "fail" } // any по values
    println("14) hasFailedModule = $hasFailedModule")

// 15. Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val envA = mutableMapOf("threads" to "4", "retries" to "1")
    val envB = mapOf("retries" to "2", "locale" to "ru")
    envA.putAll(envB)                                      // putAll
    println("15) merged env = $envA")

// 16. Объедините два неизменяемых словаря с данными о багах.
    val bugsA = mapOf("B1" to "open", "B2" to "closed")
    val bugsB = mapOf("B2" to "reopened", "B3" to "open")
    val mergedBugs = bugsA + bugsB                         // plus (правый перезапишет левый)
    println("16) mergedBugs = $mergedBugs")

// 17. Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val temp = mutableMapOf("runId" to "42", "ts" to "10:15")
    temp.clear()                                           // clear
    println("17) temp size = ${temp.size}")

// 18. Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены
// (имеют статус “skipped”). Ключи - название теста, значения - статус.
    val report = mapOf("login" to "passed", "ab" to "skipped", "pay" to "failed")
    val noSkipped = report.filterValues { it != "skipped" } // filterValues
    println("18) noSkipped = $noSkipped")

// 19. Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
    val cfgAll = mapOf("browser" to "chrome", "lang" to "ru", "proxy" to "off")
    val cfgWithout = cfgAll - listOf("proxy", "lang")      // minus со списком ключей
    println("19) cfgWithout = $cfgWithout")

// 20. Создайте отчет о тестировании, преобразовав словарь с результатами тестирования
// (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".
    val idRes = mapOf("T-1" to "OK", "T-2" to "FAIL")
    val lines: List<String> = idRes.map { (id, res) -> "Test $id: $res" } // map по entries
    println("20) lines = $lines")

// 21. Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val lastRunMutable = mutableMapOf("A" to "passed", "B" to "failed")
    val archived: Map<String, String> = lastRunMutable.toMap() // toMap
    println("21) archived immutable = $archived")

// 22. Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов,
// заменив идентификаторы тестов на их строковый аналог (например через toString()).
    val perfIds = mapOf(101 to 250, 202 to 400)
    val perfIdsStr = perfIds.mapKeys { (k, _) -> k.toString() }  // mapKeys
    println("22) perfIdsStr = $perfIdsStr")

// 23. Для словаря с оценками производительности различных версий приложения
// (ключи - строковая версия, значения - дробное число времени ответа сервера) увеличьте каждую оценку на 10%,
// чтобы учесть новые условия тестирования.
    val perf = mapOf("1.0" to 1200.0, "1.1" to 1000.0)
    val perfUp = perf.mapValues { (_, v) -> v * 1.10 }      // mapValues
    println("23) perfUp = $perfUp")

// 24. Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val compileErrs = emptyMap<Int, String>()
    println("24) compileErrs.isEmpty = ${compileErrs.isEmpty()}")

// 25. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    val loadRes = mapOf("100rps" to "ok")
    println("25) loadRes.isNotEmpty = ${loadRes.isNotEmpty()}")

// 26. Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
    val resAll = mapOf("A" to "passed", "B" to "passed")
    val allPassed = resAll.all { it.value == "passed" }     // all
    println("26) all passed? $allPassed")

// 27. Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    val hasFailed = resAll.containsValue("failed")          // containsValue
    println("27) has failed? $hasFailed")

// 28. Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты,
// которые не прошли успешно и содержат в названии “optional”.
    val svcRes = mapOf("optional-sync" to "failed", "core" to "passed", "optional-clean" to "skipped")
    val optionalBad = svcRes
        .filterKeys { it.contains("optional") }             // filterKeys
        .filterValues { it != "passed" }                    // и не прошли
    println("28) optionalBad = $optionalBad")
}