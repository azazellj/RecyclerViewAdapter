package com.azazellj.baservadapter.ui.main;

import android.view.ViewGroup;

import com.azazellj.baservadapter.BR;
import com.azazellj.baservadapter.R;
import com.azazellj.baservadapter.model.Animal;
import com.azazellj.recyclerview.adapter.BaseAdapter;
import com.azazellj.recyclerview.adapter.binding.BindingViewHolder;

/**
 * Created by azazellj on 10/2/17.
 */

public class AnimalsAdapter
        extends BaseAdapter<Animal, BindingViewHolder> {

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingViewHolder(parent, R.layout.item_animal);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.getView().setVariable(BR.animal, getItem(holder.getAdapterPosition()));
    }
}
