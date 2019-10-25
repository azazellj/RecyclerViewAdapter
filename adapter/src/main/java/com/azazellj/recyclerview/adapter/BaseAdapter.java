package com.azazellj.recyclerview.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.azazellj.recyclerview.adapter.common.Holder;
import com.azazellj.recyclerview.adapter.common.IBaseAdapter;

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
public abstract class BaseAdapter<E, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH>
        implements IBaseAdapter<E, VH> {

    @NonNull
    private List<E> mList = new ArrayList<>();

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public List<E> getItems() {
        return mList;
    }

    @Override
    public void add(final E item) {
        add(item, getItemCount());
    }

    @Override
    public void add(final E item, final int index) {
        mList.add(index, item);
        notifyItemInserted(getItemCount() - 1);
    }

    @Override
    public void addAll(final List<? extends E> items) {
        addAll(items, getItemCount());
    }

    @Override
    public void addAll(final List<? extends E> items, final int index) {
        int startIndex = index;

        if (index < 0 || index >= getItemCount()) {
            startIndex = getItemCount();
        }

        mList.addAll(startIndex, items);
        notifyItemRangeInserted(startIndex, items.size());
    }

    @Override
    public void clear() {
        mList.clear();
        notifyDataSetChanged();
    }

    @Override
    public void deleteItemAt(final int position) {
        if (position < 0 || position >= getItemCount()) {
            return;
        }

        mList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    @Nullable
    public E getItem(final int position) {
        if (position < 0 || position >= getItemCount()) {
            return null;
        }

        return mList.get(position);
    }

    @Override
    public void setItemAt(E item, final int position) {
        if (position < 0 || position >= getItemCount()) {
            return;
        }

        mList.set(position, item);
    }

    @Override
    public void setItems(@Nullable List<E> items) {
        if (items == null) {
            items = Collections.emptyList();
        }

        this.mList = items;
        notifyDataSetChanged();
    }

    @Override
    public boolean isEmpty() {
        return mList.isEmpty();
    }
}
