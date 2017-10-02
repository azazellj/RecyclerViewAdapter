package com.azazellj.baservadapter.databinding;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.azazellj.baservadapter.BuildConfig;
import com.bumptech.glide.Glide;

/**
 * Created by azazellj on 8/8/16.
 */

public class BindingAdapters {
    /**
     * Default constructor.
     */
    private BindingAdapters() {
    }

    /**
     * Load any image
     *
     * @param imageView any image view
     * @param imageUrl  image url
     */
    @BindingAdapter("imageUrl")
    public static void loadImage(final ImageView imageView, String imageUrl) {
        if (BuildConfig.DEBUG) Log.d("loadImage", imageUrl != null ? imageUrl : "");
        //show no image
        if (imageUrl != null && imageUrl.isEmpty()) {
            imageUrl = null;
        }

        String finalImageUrl = imageUrl;

        Glide.with(imageView.getContext())
                .load(finalImageUrl)
                .placeholder(android.R.drawable.gallery_thumb)
                .error(android.R.drawable.stat_notify_error)
                .dontTransform()
                .crossFade()
                .dontAnimate()
                .into(imageView);
    }
}
