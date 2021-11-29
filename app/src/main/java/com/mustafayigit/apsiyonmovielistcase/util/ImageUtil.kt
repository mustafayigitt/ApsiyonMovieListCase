package com.mustafayigit.apsiyonmovielistcase.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


fun ImageView.setImageWithGlide(
    source: Any,
    vararg transformation: BitmapTransformation
){
    Glide.with(context)
        .load(source)
        .transform(*transformation)
        .into(this)
}