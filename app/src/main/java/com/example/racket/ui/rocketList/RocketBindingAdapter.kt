package com.example.racket.ui.rocketList

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, posterUrl: String) {

    Glide.with(view.context)
        .load(posterUrl)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(RequestOptions().override(600, 200))
        .into(view)
}