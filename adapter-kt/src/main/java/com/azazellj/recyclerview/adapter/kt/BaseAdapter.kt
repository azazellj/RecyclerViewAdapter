package com.azazellj.recyclerview.adapter.kt

import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.azazellj.recyclerview.adapter.kt.common.AdapterViewHolder

/**
 * Created by azazellj on 3/7/18.
 * <p>
 * Base adapter to other adapters.
 * This adapter has basic operations with notifying.
 *
 * @param <E>  entity
 * @param <VH> holder
 */
abstract class BaseAdapter<E : Any, VH : AdapterViewHolder> : RecyclerView.Adapter<VH>() {
    companion object {
        const val NO_POSITION = RecyclerView.NO_POSITION
    }

    /**
     * Base container.
     */
    @NonNull
    private var mList: MutableList<E> = mutableListOf()

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH
    abstract override fun onBindViewHolder(holder: VH, position: Int)

    /**
     * Check if range is invalid
     * @return true, if invalid index
     */
    fun isInvalid(index: Int) = index < 0 || index >= itemCount

    /**
     * Get items count
     *
     * @return number of items.
     */
    override fun getItemCount() = mList.size

    /**
     * Get all items list.
     *
     * @return items
     */
    fun getItems(): MutableList<E> = mList

    /**
     * Add new item
     *
     * @param item item to add
     */
    fun add(item: E) = add(item, itemCount - 1)

    /**
     * Add new item at index.
     *
     * @param item  item to add
     * @param index insert index
     */
    fun add(item: E, index: Int) {
        mList.add(index, item)
        notifyItemInserted(index)
    }

    /**
     * Add collection of items
     *
     * @param items collection
     */
    fun addAll(items: MutableList<E>) = addAll(items, itemCount - 1)

    /**
     * Add collection of items at index.
     *
     * @param items collection
     * @param index start index
     */
    fun <T : E, L : List<T>> addAll(items: L, index: Int) {
        var startIndex = index
        if (isInvalid(index)) {
            startIndex = itemCount
        }

        mList.addAll(startIndex, items)
        notifyItemRangeInserted(startIndex, items.size)
    }

    /**
     * Remove all items.
     */
    fun clear() {
        mList.clear()
        notifyDataSetChanged()
    }

    /**
     * Remove item at some index.
     *
     * @param index remove index
     */
    fun deleteItemAt(index: Int) {
        if (isInvalid(index)) return

        mList.removeAt(index)
        notifyItemRemoved(index)
    }

    /**
     * Get item at some index.
     *
     * @param index index
     * @return null or item
     */
    @Nullable
    fun getItem(index: Int): E? = when {
        isInvalid(index) -> null
        else -> mList[index]
    }

    /**
     * Update item at some index.
     *
     * @param item item to update
     * @param index update index
     */
    fun setItemAt(@Nullable item: E, index: Int) {
        if (isInvalid(index)) return

        mList[index] = item
    }

    /**
     * Rewrite collection.
     *
     * @param items new collection
     */
    fun setItems(@Nullable items: MutableList<E>?) {
        mList = items ?: mutableListOf()
        notifyDataSetChanged()
    }

    /**
     * Check if is collection empty.
     *
     * @return true if empty
     */
    fun isEmpty(): Boolean = mList.isEmpty()
}