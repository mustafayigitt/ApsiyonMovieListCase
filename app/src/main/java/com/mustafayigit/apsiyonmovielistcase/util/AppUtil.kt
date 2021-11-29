package com.mustafayigit.apsiyonmovielistcase.util

import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import android.widget.Toast
import androidx.annotation.Dimension
import androidx.recyclerview.widget.RecyclerView
import com.mustafayigit.apsiyonmovielistcase.BuildConfig


infix fun String.printToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun String.safeLog() {
    if (BuildConfig.BUILD_TYPE != "debug") return
    println("SafeLog: $this")
}

class CustomItemDecoration(
    private val spaceLeft: Int? = null,
    private val spaceTop: Int? = null,
    private val spaceRight: Int? = null,
    private val spaceBottom: Int? = null,
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        with(outRect) {
            spaceLeft?.let { left = spaceLeft }
            spaceTop?.let { top = spaceTop }
            spaceRight?.let { right = spaceRight }
            spaceBottom?.let { bottom = spaceBottom }
        }
    }
}

@JvmOverloads
@Dimension(unit = Dimension.PX)
fun Number.dpToPx(metrics: DisplayMetrics = Resources.getSystem().displayMetrics) =
    toFloat() * metrics.density

@JvmOverloads
@Dimension(unit = Dimension.DP)
fun Number.pxToDp(metrics: DisplayMetrics = Resources.getSystem().displayMetrics) =
    toFloat() / metrics.density


fun View.extShow() {
    visibility = View.VISIBLE
}

fun View.extHide() {
    visibility = View.INVISIBLE

}

fun View.extRemove() {
    visibility = View.GONE
}