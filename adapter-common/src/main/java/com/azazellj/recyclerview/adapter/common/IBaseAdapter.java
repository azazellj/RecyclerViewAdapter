package com.azazellj.recyclerview.adapter.common;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * Created by azazellj on 10/13/19.
 * <p>
 * Base adapter to other adapters.
 * This adapter has basic operations with notifying.
 *
 * @param <E>  entity
 * @param <VH> holder
 */
public interface IBaseAdapter<E, VH> {

    int NO_POSITION = -1;
    long NO_ID = -1;
    int INVALID_TYPE = -1;

    @NonNull
    VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    void onBindViewHolder(@NonNull VH holder, int position);

    /**
     * Get items count
     *
     * @return number of items.
     */
    int getItemCount();

    /**
     * Get all items list.
     *
     * @return items
     */
    List<E> getItems();

    /**
     * Add new item
     *
     * @param item item to add
     */
    void add(final E item);

    /**
     * Add new item at index.
     *
     * @param item  item to add
     * @param index insert index
     */
    void add(final E item, final int index);

    /**
     * Add collection of items
     *
     * @param items collection
     */
    void addAll(final List<? extends E> items);

    /**
     * Add collection of items at index.
     *
     * @param items collection
     * @param index start index
     */
    public void addAll(final List<? extends E> items, final int index);

    /**
     * Remove all items.
     */
    public void clear();

    /**
     * Remove item at some position.
     *
     * @param position remove index
     */
    void deleteItemAt(final int position);

    /**
     * Get item at some position.
     *
     * @param position index
     * @return null or item
     */
    @Nullable
    E getItem(final int position);

    /**
     * Update item at some position.
     *
     * @param item     item to update
     * @param position update index
     */
    void setItemAt(E item, final int position);

    /**
     * Rewrite collection.
     *
     * @param items new collection
     */
    void setItems(@Nullable List<E> items);

    /**
     * Check if is collection empty.
     *
     * @return true if empty
     */
    boolean isEmpty();

    /**
     * Check if range is invalid
     *
     * @return true, if invalid index
     */
    default boolean isInvalid(int index) {
        return index < 0 || index >= getItemCount();
    }
}
