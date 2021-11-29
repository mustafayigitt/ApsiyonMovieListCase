package com.mustafayigit.apsiyonmovielistcase.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy


fun ImageView.setImageWithGlide(
    source: Any,
) {
    Glide.with(context)
        .load(source)
        .format(DecodeFormat.PREFER_ARGB_8888)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}