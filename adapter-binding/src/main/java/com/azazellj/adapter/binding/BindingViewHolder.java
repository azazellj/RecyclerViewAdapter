package com.azazellj.adapter.binding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

/**
 * Created by azazellj on 10/2/17.
 */

public class BindingViewHolder
        extends com.azazellj.rv.adapter.common.AdapterViewHolder {
    /**
     * Default constructor.
     *
     * @param itemView view
     */
    public BindingViewHolder(View itemView) {
        super(itemView);
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
}
