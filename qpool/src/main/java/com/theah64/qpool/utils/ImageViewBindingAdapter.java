package com.theah64.qpool.utils;

/*
package com.theah64.qpool.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String) {

    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}*/


import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;

public class ImageViewBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView view, String url) {
        Glide.with(view)
                .load(url)
                .into(view);
    }
}