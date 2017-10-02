package com.azazellj.baservadapter.ui.main;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.azazellj.adapter.binding.BindingViewHolder;
import com.azazellj.baservadapter.BR;
import com.azazellj.baservadapter.R;
import com.azazellj.baservadapter.model.Animal;
import com.azazellj.rv.adapter.BaseAdapter;

/**
 * Created by azazellj on 10/2/17.
 */

public class AnimalsAdapter
        extends BaseAdapter<Animal, BindingViewHolder> {

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ViewDataBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.item_animal, parent, false);

        return new BindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.getView().setVariable(BR.animal, getItem(holder.getAdapterPosition()));
    }
}
