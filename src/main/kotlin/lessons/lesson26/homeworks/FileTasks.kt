package org.example.lessons.lesson26.homeworks

import java.io.File

fun main() {
    task1()
    task2()
    task3()
    task4()
    task5()
    task6()
    task7()
    task8()
}

/* Задача 1
Создать файл, записать строку, проверить существование — без промежуточной переменной. */
fun task1() {
    println("=== Task 1 ===")
    println(
        File("workspace/task1/example.txt")
            .apply {
                parentFile.mkdirs()
                writeText("Hello, Kotlin!")
            }
            .exists()
    )
}

/* Задача 2
Создать директорию, проверить, что это директория, вывести абсолютный путь. */
fun task2() {
    println("=== Task 2 ===")
    File("workspace/task2/testDir")
        .apply { mkdirs() }
        .let { dir ->
            println("isDirectory=${dir.isDirectory}")
            println("absPath=${dir.absolutePath}")
        }
}

/* Задача 3
Создать structure/myDir/subDir1 и subDir2 через resolve; проверить, что myDir содержит обе поддиректории. */
fun task3() {
    println("=== Task 3 ===")
    File("workspace/task3/structure").apply {
        mkdirs()
        val myDir = resolve("myDir").apply {
            mkdirs()
            resolve("subDir1").mkdirs()
            resolve("subDir2").mkdirs()
        }
        val names = myDir.listFiles()
            ?.filter { it.isDirectory }
            ?.map { it.name }
            ?.toSet()
            ?: emptySet()
        println("myDir contains subDir1&subDir2: ${setOf("subDir1", "subDir2").all { it in names }}")
    }
}

/* Задача 4
Создать несколько вложенных файлов/директорий и удалить workspace/task4 целиком. */
fun task4() {
    println("=== Task 4 ===")
    File("workspace/task4/temp").apply {
        // структура
        resolve("dirA").mkdirs()
        resolve("dirA/file.txt").apply { parentFile.mkdirs(); writeText("A") }
        resolve("dirB/inner").mkdirs()
        resolve("dirB/inner/data.txt").apply { parentFile.mkdirs(); writeText("B") }
        resolve("dirC/inner/deeper").mkdirs()
        resolve("dirC/inner/deeper/info.log").apply { parentFile.mkdirs(); writeText("C") }
    }
    val deleted = File("workspace/task4").deleteRecursively()
    println("Deleted workspace/task4 recursively: $deleted")
}

/* Задача 5
Создать config.txt (key=value построчно), прочитать и вывести только значения. */
fun task5() {
    println("=== Task 5 ===")
    File("workspace/task5/config/config.txt")
        .apply {
            parentFile.mkdirs()
            writeText(
                """
                host=localhost
                port=8080
                mode=prod
                retries=3
                """.trimIndent()
            )
        }
        .readLines()
        .map { it.substringAfter('=', missingDelimiterValue = "") }
        .forEach { println(it) }
}

/* Задача 6
Обойти все вложенные директории workspace: сначала директории, затем файлы. */
fun task6() {
    println("=== Task 6 ===")
    File("workspace").let { base ->
        if (!base.exists()) return
        base.walkTopDown().filter { it.isDirectory }.forEach { println("DIR : ${it.path}") }
        base.walkTopDown().filter { it.isFile }.forEach { println("FILE: ${it.path}") }
    }
}

/* Задача 7
docs + readme.md: если нет — создать и записать текст; затем проверить текст. */
fun task7() {
    println("=== Task 7 ===")
    File("workspace/task7/docs").apply {
        mkdirs()
        resolve("readme.md").let { f ->
            if (!f.exists()) f.writeText("This is a README file.")
            val content = f.readText()
            println("readme exists=${f.exists()}, okText=${content == "This is a README file."}")
        }
    }
}


/* Задача 8
Создать файлы в data/* и скопировать в backup, сохранив структуру с помощью relativeTo + resolve + copyTo. */

 */
fun task8() {
    println("=== Task 8 ===")

    val dataRoot = File("workspace/task8/data").apply { mkdirs() }
    val paths = listOf(
        "1/4/prod/data14.mysql",
        "2/3/prod/data23.mysql",
        "5/2/prod/data52.mysql"
    )

    // создаём файлы с контентом
    paths.forEach { rel ->
        dataRoot.resolve(rel).apply {
            parentFile.mkdirs()
            writeText("payload for $name")
        }
    }

    val backupRoot = File("workspace/task8/backup").apply { mkdirs() }

    // копируем все файлы из data, сохраняя относительные пути
    dataRoot.walkTopDown()
        .filter { it.isFile }
        .forEach { src ->
            val rel = src.relativeTo(dataRoot)   // относительный путь от data
            val dst = backupRoot.resolve(rel)    // путь назначения внутри backup
            dst.parentFile.mkdirs()
            src.copyTo(dst, overwrite = true)
            println("Copied: ${src.path}  ->  ${dst.path}")
        }
}
