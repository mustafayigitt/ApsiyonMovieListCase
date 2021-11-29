package com.mustafayigit.apsiyonmovielistcase.util

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.annotation.Dimension
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mustafayigit.apsiyonmovielistcase.BuildConfig


infix fun String.printToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun String.safeLog() {
    if (BuildConfig.BUILD_TYPE != "debug") return
    println("SafeLog: $this")
}

@JvmOverloads
@Dimension(unit = Dimension.PX)
fun Number.dpToPx(metrics: DisplayMetrics = Resources.getSystem().displayMetrics) =
    toFloat() * metrics.density

fun <T : Any> RecyclerView.donOnScrolledToEnd(
    source: LiveData<ResponseWrapper<T>>,
    action: () -> Unit
) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        val layoutManager = this@donOnScrolledToEnd.layoutManager as LinearLayoutManager

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            with(layoutManager) {
                val visibleItemCount = childCount
                val totalItemCount = itemCount
                val firstVisibleItemPosition = findFirstVisibleItemPosition()
                val isLoading = source.value is ResponseWrapper.Loading

                if (isLoading) return

                if ((totalItemCount - visibleItemCount) <= (firstVisibleItemPosition + 20)) {
                    action.invoke()
                }

            }
        }
    })


}
