package org.example.lessons.lesson30.homeworks

import kotlin.test.*

class InventoryManagerTest {

    /* -------- getItemCount -------- */

    @Test
    fun getItemCount_unknown_returns0() {
        val inv = InventoryManager(capacity = 10)
        assertEquals(0, inv.getItemCount("rope"))
    }

    @Test
    fun getItemCount_afterAdd_returnsQuantity() {
        val inv = InventoryManager(10)
        inv.addItem("rope", 3)
        assertEquals(3, inv.getItemCount("rope"))
    }

    /* -------- addItem -------- */

    @Test
    fun addItem_newItem_addsQuantity() {
        val inv = InventoryManager(10)
        inv.addItem("rope", 3)
        assertEquals(3, inv.getItemCount("rope"))
    }

    @Test
    fun addItem_existingItem_accumulates() {
        val inv = InventoryManager(10)
        inv.addItem("rope", 2)
        inv.addItem("rope", 4)
        assertEquals(6, inv.getItemCount("rope"))
    }

    @Test
    fun addItem_exceedCapacity_throws() {
        val inv = InventoryManager(5)
        inv.addItem("rope", 4)
        val ex = assertFailsWith<IllegalStateException> {
            inv.addItem("hook", 2) // 4 + 2 > 5
        }
        assertTrue(ex.message!!.contains("не должно превышать"))
    }

    @Test
    fun addItem_zeroQuantity_throws() {
        val inv = InventoryManager(10)
        assertFailsWith<IllegalArgumentException> { inv.addItem("rope", 0) }
    }

    @Test
    fun addItem_negativeQuantity_throws() {
        val inv = InventoryManager(10)
        assertFailsWith<IllegalArgumentException> { inv.addItem("rope", -1) }
    }

    @Test
    fun addItem_blankName_throws() {
        val inv = InventoryManager(10)
        assertFailsWith<IllegalArgumentException> { inv.addItem("   ", 1) }
    }

    /* -------- removeItem -------- */

    @Test
    fun removeItem_nonexistent_returnsFalse() {
        val inv = InventoryManager(10)
        assertFalse(inv.removeItem("rope", 1))
    }

    @Test
    fun removeItem_insufficient_returnsFalse_andDoesNotChange() {
        val inv = InventoryManager(10)
        inv.addItem("rope", 2)
        assertFalse(inv.removeItem("rope", 3))
        assertEquals(2, inv.getItemCount("rope"))
    }

    @Test
    fun removeItem_exact_removesKey_returnsTrue() {
        val inv = InventoryManager(10)
        inv.addItem("rope", 3)
        assertTrue(inv.removeItem("rope", 3))
        assertEquals(0, inv.getItemCount("rope"))
    }

    @Test
    fun removeItem_partial_subtracts_returnsTrue() {
        val inv = InventoryManager(10)
        inv.addItem("rope", 5)
        assertTrue(inv.removeItem("rope", 2))
        assertEquals(3, inv.getItemCount("rope"))
    }

    @Test
    fun removeItem_nonPositiveQuantity_throws() {
        val inv = InventoryManager(10)
        inv.addItem("rope", 2)
        assertFailsWith<IllegalArgumentException> { inv.removeItem("rope", 0) }
        assertFailsWith<IllegalArgumentException> { inv.removeItem("rope", -1) }
    }

    /* -------- интеграционный сценарий: вместимость освобождается после удаления -------- */

    @Test
    fun capacity_frees_afterRemove_allowsFurtherAdds() {
        val inv = InventoryManager(5)
        inv.addItem("a", 3)
        inv.addItem("b", 2)
        assertTrue(inv.removeItem("a", 2))        // стало 1 + 2 = 3 занято
        // теперь можно докинуть ещё 2
        inv.addItem("c", 2)
        assertEquals(1, inv.getItemCount("a"))
        assertEquals(2, inv.getItemCount("b"))
        assertEquals(2, inv.getItemCount("c"))
    }
}
