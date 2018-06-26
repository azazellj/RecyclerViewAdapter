package com.azazellj.recyclerview.adapter.kt

import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
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
     * Get items count
     *
     * @return number of items.
     */
    override fun getItemCount(): Int {
        return mList.size
    }

    /**
     * Get all items list.
     *
     * @return items
     */
    fun getItems(): List<E> {
        return mList
    }

    /**
     * Add new item
     *
     * @param item item to add
     */
    fun add(item: E) {
        add(item, itemCount)
    }

    /**
     * Add new item at index.
     *
     * @param item  item to add
     * @param index insert index
     */
    fun add(item: E, index: Int) {
        mList.add(index, item)
        notifyItemInserted(itemCount - 1)
    }

    /**
     * Add collection of items
     *
     * @param items collection
     */
    fun addAll(items: MutableList<E>) {
        addAll(items, itemCount)
    }

    /**
     * Add collection of items at index.
     *
     * @param items collection
     * @param index start index
     */
    fun addAll(items: MutableList<E>, index: Int) {
        var startIndex = index
        if (index < 0 || index >= itemCount) {
            startIndex = itemCount
        }

        mList.addAll(startIndex, items)
        notifyItemRangeInserted(startIndex, items.size)
    }

    /**
     * Remove all items.
     */
    fun clear() {
        notifyItemRangeChanged(0, itemCount)
        mList.clear()
    }

    /**
     * Remove item at some position.
     *
     * @param position remove index
     */
    fun deleteItemAt(position: Int) {
        if (position < 0 || position >= itemCount) {
            return
        }

        mList.removeAt(position)
        notifyItemRemoved(position)
    }

    /**
     * Get item at some position.
     *
     * @param position index
     * @return null or item
     */
    @Nullable
    fun getItem(position: Int): E? {
        return if (position < 0 || position >= itemCount) {
            null
        } else {
            mList[position]
        }
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
    fun isEmpty(): Boolean {
        return mList.isEmpty()
    }
}