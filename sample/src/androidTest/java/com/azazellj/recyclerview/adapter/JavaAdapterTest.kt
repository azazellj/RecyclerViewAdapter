package com.azazellj.recyclerview.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azazellj.recyclerview.adapter.common.AdapterViewHolder
import com.azazellj.recyclerview.adapter.common.BaseAdapterTests

/**
 * Created by azazellj on 10/24/19.
 */
class JavaAdapterTest : BaseAdapterTests() {
    override fun create() = object : BaseAdapter<Any, RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AdapterViewHolder(View(parent.context))

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
    }
}