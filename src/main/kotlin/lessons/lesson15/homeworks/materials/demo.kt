package org.example.lessons.lesson15.homeworks.materials

// 1) Вставка строки на дно (в начало, индекс 0)
class BottomMaterials : Materials() {
    fun addAtBottom(material: String) {
        val old = extractMaterials()
        addMaterial(material)      // станет элементом с индексом 0
        for (x in old) addMaterial(x)
    }
}

// 2) Получает список строк и вставляет их в начало, чередуя с уже имеющимися (0,2,4,...)
class InterleavingFrontMaterials : Materials() {
    fun addInterleavingFront(newItems: List<String>) {
        val old = extractMaterials()
        val merged = mutableListOf<String>()
        val max = maxOf(newItems.size, old.size)
        for (i in 0 until max) {
            if (i < newItems.size) merged.add(newItems[i]) // новые на чётные позиции
            if (i < old.size) merged.add(old[i])           // старые между ними
        }
        for (x in merged) addMaterial(x)
    }
}

// 3) При добавлении строки — отсортировать всё по алфавиту (включая новую)
class SortedMaterials : Materials() {
    fun addSorted(material: String) {
        val all = extractMaterials().toMutableList()
        all.add(material)
        all.sort() // лексикографически
        for (x in all) addMaterial(x)
    }
}

// 4) Принимает словарь: ключи в НАЧАЛО (в обратном порядке), затем старые, затем значения в КОНЕЦ
class KeyFrontValueBackMaterials : Materials() {
    fun addPairs(map: Map<String, String>) {
        val old = extractMaterials()
        val keys = map.keys.toList().asReversed()
        val values = map.values.toList()
        for (k in keys) addMaterial(k)
        for (o in old)  addMaterial(o)
        for (v in values) addMaterial(v)
    }
}

// Прогон
fun main() {
    println("== BottomMaterials ==")
    val b = BottomMaterials()
    b.addAtBottom("стекло")
    b.addAtBottom("металл")
    b.addAtBottom("дерево")
    b.printContainer() // [0]=дерево, [1]=металл, [2]=стекло

    println("\n== InterleavingFrontMaterials ==")
    val i = InterleavingFrontMaterials()
    i.addInterleavingFront(listOf("a","b","c"))
    i.addInterleavingFront(listOf("X","Y"))
    i.printContainer() // позиции: X, a, Y, b, c

    println("\n== SortedMaterials ==")
    val s = SortedMaterials()
    s.addSorted("вишня")
    s.addSorted("яблоко")
    s.addSorted("абрикос")
    s.printContainer() // абрикос, вишня, яблоко

    println("\n== KeyFrontValueBackMaterials ==")
    val k = KeyFrontValueBackMaterials()
    k.addPairs(linkedMapOf("k1" to "v1", "k2" to "v2")) // linked для стабильного порядка
    k.addPairs(linkedMapOf("A" to "Z"))
    k.printContainer()
    // Ожидаемо: [0]=A, [1]=k2, [2]=k1, [3]=k1, [4]=v1, [5]=k2, [6]=v2, [7]=Z
    // (после первого вызова: k2, k1, v1, v2; потом добавили A в начало и Z в конец)
}
