package com.azazellj.recyclerview.adapter.binding.kt

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by azazellj on 3/7/18.
 */
class BindingViewHolder
/**
 * Default constructor.
 *
 * @param itemView view
 */(itemView: View) : com.azazellj.recyclerview.adapter.kt.common.AdapterViewHolder(itemView) {

    constructor(parent: ViewGroup, layoutId: Int) : this(getView(parent, layoutId))

    /**
     * Get holder binding.
     *
     * @param <T> holder binding class
     * @return binding
     */
    fun <T : ViewDataBinding> getView(): T {
        return DataBindingUtil.getBinding(itemView)
    }

    companion object {
        fun getView(parent: ViewGroup, layoutId: Int): View {
            return getView(parent, layoutId, false)
        }

        fun getView(parent: ViewGroup, layoutId: Int, attachToParent: Boolean): View {
            return getView(LayoutInflater.from(parent.context), layoutId, parent, attachToParent)
        }

        fun getView(inflater: LayoutInflater, layoutId: Int, parent: ViewGroup, attachToParent: Boolean): View {
            return DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutId, parent, false).root
        }
    }
}