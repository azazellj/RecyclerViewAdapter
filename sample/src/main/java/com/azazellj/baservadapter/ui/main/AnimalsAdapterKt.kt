package com.azazellj.baservadapter.ui.main

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

import com.azazellj.baservadapter.BR
import com.azazellj.baservadapter.R
import com.azazellj.baservadapter.model.Animal
import com.azazellj.recyclerview.adapter.binding.kt.BindingViewHolder
import com.azazellj.recyclerview.adapter.kt.BaseAdapter

/**
 * Created by azazellj on 10/2/17.
 */

class AnimalsAdapterKt : BaseAdapter<Animal, BindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return BindingViewHolder(parent, R.layout.item_animal)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.getView<ViewDataBinding>()!!.setVariable(BR.animal, getItem(holder.adapterPosition))
    }

    companion object {
        fun getAdapter(){

            val adapter = AnimalsAdapterKt()
            val list:List<Animal> = emptyList()
            adapter.addAll(list)



        }
    }
}
