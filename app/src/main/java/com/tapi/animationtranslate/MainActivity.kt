package com.tapi.animationtranslate

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

fun View.runAnimationTop() {
    val anim = AnimationUtils.loadAnimation(this.context, R.anim.slide_from_top_to_axis)
    this.startAnimation(anim)
}

fun View.runAnimationBottom() {
    val anim = AnimationUtils.loadAnimation(this.context, R.anim.slide_from_bottom_to_top)
    this.startAnimation(anim)
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymain)

    }
}