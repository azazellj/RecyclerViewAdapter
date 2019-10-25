package com.azazellj.recyclerview.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azazellj.recyclerview.adapter.common.BaseAdapterTests
import com.azazellj.recyclerview.adapter.kt.BaseAdapter
import com.azazellj.recyclerview.adapter.kt.common.AdapterViewHolder

/**
 * Created by azazellj on 10/24/19.
 */
class KotlinAdapterTest : BaseAdapterTests() {
    override fun create() = object : BaseAdapter<Any, RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AdapterViewHolder(View(parent.context))

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
    }
}