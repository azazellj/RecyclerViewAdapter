package com.azazellj.recyclerview.adapter.binding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by azazellj on 10/2/17.
 */

public class BindingViewHolder
        extends com.azazellj.recyclerview.adapter.common.AdapterViewHolder {
    /**
     * Default constructor.
     *
     * @param itemView view
     */
    public BindingViewHolder(View itemView) {
        super(itemView);
    }

    public BindingViewHolder(ViewGroup parent, int layoutId) {
        super(getView(parent, layoutId));
    }

    /**
     * Get holder binding.
     *
     * @param <T> holder binding class
     * @return binding
     */
    public <T extends ViewDataBinding> T getView() {
        return DataBindingUtil.getBinding(itemView);
    }

    public static View getView(ViewGroup parent, int layoutId) {
        return getView(parent, layoutId, false);
    }

    public static View getView(ViewGroup parent, int layoutId, boolean attachToParent) {
        return getView(LayoutInflater.from(parent.getContext()), layoutId, parent, attachToParent);
    }

    public static View getView(LayoutInflater inflater, int layoutId, ViewGroup parent,
                               boolean attachToParent) {
        return DataBindingUtil.inflate(inflater, layoutId, parent, false).getRoot();
    }
}
