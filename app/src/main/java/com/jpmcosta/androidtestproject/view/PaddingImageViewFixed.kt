package com.jpmcosta.androidtestproject.view

import android.content.Context
import android.util.AttributeSet

class PaddingImageViewFixed : PaddingImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    private var hasFrame: Boolean = false

    override fun setFrame(l: Int, t: Int, r: Int, b: Int): Boolean {
        hasFrame = true
        return super.setFrame(l, t, r, b)
    }

    override fun invalidateOutline() {
        super.invalidateOutline()

        if (drawable != null && hasFrame) { // Based on ImageView.configureBounds() condition.
            setFrame(left, top, right, bottom)
        }
    }
}