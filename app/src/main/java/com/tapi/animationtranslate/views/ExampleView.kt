package com.tapi.animationtranslate.views

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView

class ExampleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ImageView(context, attrs, defStyleAttr) {

    public fun show() {
        Log.d("phi.hd", "ExampleView show()")
        visibility = VISIBLE
    }

    public fun hide() {
        Log.d("phi.hd", "ExampleView hide()")
        visibility = GONE
    }

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        Log.d("phi.hd", "setVisibility $visibility")
        Throwable().printStackTrace()
    }
}