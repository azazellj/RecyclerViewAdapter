package com.azazellj.recyclerview.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.azazellj.recyclerview.adapter.common.AdapterViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by azazellj on 9/22/16.
 * <p>
 * Base adapter to other adapters.
 * This adapter has basic operations with notifying.
 *
 * @param <E>  entity
 * @param <VH> holder
 */
public abstract class BaseAdapter<E, VH extends AdapterViewHolder>
        extends RecyclerView.Adapter<VH> {

    public static final int NO_POSITION = RecyclerView.NO_POSITION;
    /**
     * Base container.
     */
    @NonNull
    private List<E> mList = new ArrayList<>();

    /**
     * Default constructor.
     */
    public BaseAdapter() {
    }

    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(VH holder, int position);

    /**
     * Get items count
     *
     * @return number of items.
     */
    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * Get all items list.
     *
     * @return items
     */
    public List<E> getItems() {
        return mList;
    }

    /**
     * Add new item
     *
     * @param item item to add
     */
    public void add(final E item) {
        add(item, getItemCount());
    }

    /**
     * Add new item at index.
     *
     * @param item  item to add
     * @param index insert index
     */
    public void add(final E item, final int index) {
        mList.add(index, item);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Add collection of items
     *
     * @param items collection
     */
    public void addAll(final List<? extends E> items) {
        addAll(items, getItemCount());
    }

    /**
     * Add collection of items at index.
     *
     * @param items collection
     * @param index start index
     */
    public void addAll(final List<? extends E> items, final int index) {
        int startIndex = index;

        if (index < 0 || index >= getItemCount()) {
            startIndex = getItemCount();
        }

        mList.addAll(startIndex, items);
        notifyItemRangeInserted(startIndex, items.size());
    }

    /**
     * Remove all items.
     */
    public void clear() {
        mList.clear();
        notifyDataSetChanged();
    }

    /**
     * Remove item at some position.
     *
     * @param position remove index
     */
    public void deleteItemAt(final int position) {
        if (position < 0 || position >= getItemCount()) {
            return;
        }

        mList.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * Get item at some position.
     *
     * @param position index
     * @return null or item
     */
    @Nullable
    public E getItem(final int position) {
        if (position < 0 || position >= getItemCount()) {
            return null;
        }

        return mList.get(position);
    }

    /**
     * Update item at some position.
     *
     * @param item     item to update
     * @param position update index
     */
    public void setItemAt(E item, final int position) {
        if (position < 0 || position >= getItemCount()) {
            return;
        }

        mList.set(position, item);
    }

    /**
     * Rewrite collection.
     *
     * @param items new collection
     */
    public void setItems(@Nullable List<E> items) {
        if (items == null) {
            items = Collections.emptyList();
        }

        this.mList = items;
        notifyDataSetChanged();
    }

    /**
     * Check if is collection empty.
     *
     * @return true if empty
     */
    public boolean isEmpty() {
        return mList.isEmpty();
    }
}
