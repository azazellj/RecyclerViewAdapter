package com.azazellj.recyclerview.adapter.kt

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.azazellj.recyclerview.adapter.common.IBaseAdapter

/**
 * Created by azazellj on 3/7/18.
 * <p>
 * Base adapter to other adapters.
 * This adapter has basic operations with notifying.
 *
 * @param <E>  entity
 * @param <VH> holder
 */
abstract class BaseAdapter<E : Any, VH> : RecyclerView.Adapter<VH>(),
    IBaseAdapter<E, VH>
        where VH : RecyclerView.ViewHolder {

    @NonNull
    private var mList: MutableList<E> = mutableListOf()

    override fun getItemCount() = mList.size

    override fun getItems(): MutableList<E> = mList

    override fun add(item: E) = add(item, itemCount)

    override fun add(item: E, index: Int) {
        mList.add(index, item)
        notifyItemInserted(index)
    }

    override fun addAll(items: List<E>) = addAll(items, itemCount)

    override fun addAll(items: List<E>, index: Int) {
        var startIndex = index
        if (isInvalid(index)) {
            startIndex = itemCount
        }

        mList.addAll(startIndex, items)
        notifyItemRangeInserted(startIndex, items.size)
    }

    override fun clear() {
        mList.clear()
        notifyDataSetChanged()
    }

    override fun deleteItemAt(index: Int) {
        if (isInvalid(index)) return

        mList.removeAt(index)
        notifyItemRemoved(index)
    }

    @Nullable
    override fun getItem(index: Int): E? = when {
        isInvalid(index) -> null
        else -> mList[index]
    }

    override fun setItemAt(@Nullable item: E, index: Int) {
        if (isInvalid(index)) return

        mList[index] = item
    }

    override fun setItems(@Nullable items: List<E>?) {
        mList = items?.toMutableList() ?: mutableListOf()
        notifyDataSetChanged()
    }

    override fun isEmpty(): Boolean = mList.isEmpty()
}