package com.azazellj.recyclerview.adapter.butterknife;

import android.support.annotation.NonNull;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by azazellj on 3/7/18.
 */
public class ButterKnifeViewHolder extends com.azazellj.recyclerview.adapter.common.AdapterViewHolder {
    public ButterKnifeViewHolder(View itemView) {
        super(itemView);

        bindView(this, itemView);
    }

    public static void bindView(@NonNull Object target, @NonNull View source) {
        ButterKnife.bind(target, source);
    }
}
