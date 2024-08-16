package com.xianban.pr

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


class HorizontalProgressBar(context: Context, attrs: AttributeSet) : View(context, attrs) {

	private val backgroundPaint = Paint()
	private val progressPaint = Paint()
	private var progress: Progress? = null
	private val borderRadius = 360f

	init {
		backgroundPaint.color = Color.parseColor("#f3f3f3")
	}

	fun setProgress(progress: Progress) {
		this.progress = progress
		backgroundPaint.color = Color.parseColor(progress.bgColor)
		invalidate()
	}

	@SuppressLint("DrawAllocation")
	override fun onDraw(canvas: Canvas) {
		super.onDraw(canvas)

		val width = width.toFloat()
		val height = height.toFloat()

		canvas.drawRoundRect(RectF(0f, 0f, width, height), borderRadius, borderRadius, backgroundPaint)

		progress?.let {
			val progressWidth = width * (it.value.toFloat() / 100)
			progressPaint.color = Color.parseColor(it.color)
			canvas.drawRoundRect(
				RectF(0f, 0f, progressWidth, height),
				borderRadius,
				borderRadius,
				progressPaint
			)
		}
	}
}
