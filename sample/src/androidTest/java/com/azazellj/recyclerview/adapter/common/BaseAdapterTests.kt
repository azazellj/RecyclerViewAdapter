package com.azazellj.recyclerview.adapter.common

import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by azazellj on 9/4/19.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
abstract class BaseAdapterTests {
    lateinit var adapter: IBaseAdapter<Any, RecyclerView.ViewHolder>
    abstract fun create(): IBaseAdapter<Any, RecyclerView.ViewHolder>

    @Before
    fun clean() {
        adapter = create()
    }

    @Test
    fun itemCount() {
        for (index in 0 until 10) {
            adapter.add(index)
        }

        assertEquals(10, adapter.itemCount)
    }

    @Test
    fun itemCountZero() {
        assertEquals(0, adapter.itemCount)
    }

    @Test
    fun itemCountAfterAdd() {
        assertEquals(0, adapter.itemCount)
        adapter.add(0)
        assertEquals(1, adapter.itemCount)
    }

    @Test
    fun itemCountAfterRemove() {
        adapter.add(0)
        assertEquals(1, adapter.itemCount)
        adapter.deleteItemAt(0)
        assertEquals(0, adapter.itemCount)
    }

    @Test
    fun itemsAddingCorrect() {
        for (index in 0 until 10) {
            adapter.add(index)
        }

        for (index in 0 until 10) {
            assertEquals(index, adapter.getItem(index))
        }
    }

    @Test
    fun addIndexedCorrect() {
        for (index in 0 until 10) {
            adapter.add(index, index)

            assertEquals(index, adapter.getItem(index))
        }
    }

    @Test
    fun itemsAddingAllCorrect() {
        val items = (0 until 10).toList()
        val items2 = (10 until 20).toList()

        adapter.addAll(items)
        adapter.addAll(items2)

        for (index in 0 until 20) {
            assertEquals(index, adapter.getItem(index))
        }
    }

    @Test
    fun addAllIndexedCorrect() {
        val items = (0 until 10).toList()
        val items2 = (10 until 20).toList()

        adapter.addAll(items, 0)
        adapter.addAll(items2, items.count())

        for (index in 0 until 20) {
            assertEquals(index, adapter.getItem(index))
        }
    }

    @Test
    fun clearItems() {
        for (index in 0 until 10) {
            adapter.add(index)
        }

        adapter.clear()

        assertEquals(0, adapter.itemCount)
    }

    @Test
    fun deleteItemAtWrongPosition() {
        for (index in 0 until 10) {
            adapter.add(index)
        }

        assertEquals(10, adapter.itemCount)

        adapter.deleteItemAt(-999)

        assertEquals(10, adapter.itemCount)
    }

    @Test
    fun deleteItemAtSomePosition() {
        for (index in 0 until 10) {
            adapter.add(index)
        }

        val position = 5

        assertEquals(10, adapter.itemCount)
        assertEquals(5, adapter.getItem(position))

        adapter.deleteItemAt(position)

        assertEquals(6, adapter.getItem(position))
        assertEquals(9, adapter.itemCount)
    }

    @Test
    fun getItemAtWrongPosition() {
        for (index in 0 until 10) {
            adapter.add(index)
        }

        assertEquals(null, adapter.getItem(-999))
    }

    @Test
    fun getItemAtSomePosition() {
        for (index in 0 until 10) {
            adapter.add(index)
        }

        assertEquals(9, adapter.getItem(9))
    }

    @Test
    fun setItemAtWrongPosition() {
        for (index in 0 until 10) {
            adapter.add(index)
        }

        assertEquals(10, adapter.itemCount)

        adapter.setItemAt(999, -999)

        assertEquals(10, adapter.itemCount)
    }

    @Test
    fun setItemAtSomePosition() {
        for (index in 0 until 10) {
            adapter.add(index)
        }
        assertEquals(10, adapter.itemCount)

        adapter.setItemAt(999, 5)

        assertEquals(10, adapter.itemCount)
        assertEquals(999, adapter.getItem(5))
    }

    @Test
    fun setItems() {
        fun check(items: List<Int>) {
            for (index in items.indices) {
                assertEquals(items[index], adapter.getItem(index))
            }
        }

        val items = (0 until 10).toList()
        val items2 = (10 until 20).toList()

        adapter.items = items
        check(items)

        adapter.items = items2
        check(items2)
    }

    @Test
    fun setItemsNull() {
        val items = (0 until 10).toList()
        val items2 = null

        adapter.items = items
        assertEquals(10, adapter.itemCount)

        adapter.items = items2
        assertEquals(0, adapter.itemCount)
    }

    @Test
    fun isEmpty() {
        val items = (0 until 10).toList()
        val items2 = null

        adapter.items = items
        assertEquals(false, adapter.isEmpty)

        adapter.items = items2
        assertEquals(true, adapter.isEmpty)
    }
}
