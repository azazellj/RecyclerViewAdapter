package com.azazellj.recyclerview.adapter.butterknife.kt

import android.view.View
import butterknife.ButterKnife

/**
 * Created by azazellj on 3/7/18.
 */
class ButterKnifeViewHolder
/**
 * Default constructor.
 *
 * @param itemView view
 */(iteView: View) : com.azazellj.recyclerview.adapter.kt.common.AdapterViewHolder(iteView) {

    init {
        bindView(this, iteView)
    }

    companion object {
        fun bindView(target: Any, source: View) {
            ButterKnife.bind(target, source)
        }
    }
}