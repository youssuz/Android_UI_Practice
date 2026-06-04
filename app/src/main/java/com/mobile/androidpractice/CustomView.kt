package com.mobile.androidpractice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.View

class CustomView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    val paint = Paint()
    var posX = 200.0f
    var posY = 200.0f
    var radius = 100.0f
    var color = Color.RED
    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.LTGRAY)
        paint.color = color
        canvas.drawCircle(posX, posY, radius, paint)
        super.onDraw(canvas)
    }
}