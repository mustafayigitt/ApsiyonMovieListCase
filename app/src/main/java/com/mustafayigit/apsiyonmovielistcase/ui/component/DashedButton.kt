package com.mustafayigit.apsiyonmovielistcase.ui.component

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.mustafayigit.apsiyonmovielistcase.R
import com.mustafayigit.apsiyonmovielistcase.util.dpToPx
import kotlin.math.roundToInt


class DashedButton @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : androidx.appcompat.widget.AppCompatButton(context, attributes, defStyleAttr) {

    private val buttonText = "Add"
    private val buttonTextBounds = Rect()

    private val icon = ContextCompat.getDrawable(context, R.drawable.ic_plus)?.apply {
        setTint(Color.parseColor("#4caf50"))
    }

    private var dGap = 10.dpToPx()
    private var dWidth = 5.dpToPx()
    private var dColor = Color.parseColor("#4caf50")
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mPaintText = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mPath = Path()

    init {
        mPaint.apply {
            color = dColor
            style = Paint.Style.STROKE
            pathEffect = DashPathEffect(floatArrayOf(dWidth, dGap), 0f)
            strokeWidth = dWidth

        }

        mPaintText.apply {
            color = dColor
            style = Paint.Style.FILL
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            textSize = 36f
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        with(mPath) {
            moveTo(0f, 0f)

            addRoundRect(
                0f,
                0f,
                measuredWidth.toFloat(),
                measuredHeight.toFloat(),
                30f,
                30f,
                Path.Direction.CCW
            )
        }

        canvas?.let {

            // Draw Dash
            it.drawPath(mPath, mPaint)

            // Draw Icon
            icon?.let {
                canvas.drawBitmap(
                    icon.toBitmap(24.dpToPx().roundToInt(), 24.dpToPx().roundToInt()),
                    measuredWidth / 2f - icon.intrinsicWidth,
                    measuredHeight / 2f - icon.intrinsicHeight / 2f,
                    mPaintText
                )
            }

            // Draw Text
            mPaintText.getTextBounds(buttonText, 0, buttonText.length, buttonTextBounds)
            it.drawText(buttonText, measuredWidth / 2f, measuredHeight / 2f + buttonTextBounds.height() / 2f, mPaintText)


        }


    }

}