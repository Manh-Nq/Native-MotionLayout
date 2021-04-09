package com.tapi.animationtranslate

import android.animation.*
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.tapi.animationtranslate.databinding.FragmentFrgAnimBinding
import kotlinx.coroutines.delay

class FrgAnim : Fragment() {


    private var set: AnimatorSet? = null
    private var _binding: FragmentFrgAnimBinding? = null
    private val binding: FragmentFrgAnimBinding get() = _binding!!

    var animator: ObjectAnimator? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFrgAnimBinding.inflate(inflater, container, false)
        initViews()

        return binding.root
    }

    private fun initViews(){
        binding.bt1.setOnClickListener {
            set?.cancel()
            animator = ObjectAnimator.ofFloat(binding.ivStar, View.ROTATION, -360f, 0f)
            animator?.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator?) {
                    binding.bt1.isEnabled = false
                }

                override fun onAnimationEnd(animation: Animator?) {
                    binding.bt1.isEnabled = true
                }
            })
            animator?.repeatCount = 1
            animator?.repeatMode = ObjectAnimator.REVERSE
            animator?.start()

        }
        binding.bt2.setOnClickListener {
            set?.cancel()
            if (animator != null) {
                animator = null
            }
            animator = ObjectAnimator.ofFloat(binding.ivStar, View.TRANSLATION_X, 100f)
            animator?.let { animator ->
                animator.repeatCount = 1
                animator.repeatMode = ObjectAnimator.REVERSE
                animator.start()
            }

        }
        binding.bt3.setOnClickListener {
            set?.cancel()
            animator?.cancel()
            val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
            val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
            animator = ObjectAnimator.ofPropertyValuesHolder(binding.ivStar, scaleX, scaleY)

            animator?.let { animator ->
                animator.repeatCount = 1
                animator.repeatMode = ObjectAnimator.REVERSE
                animator.start()
            }

        }
        binding.bt4.setOnClickListener {
            set?.cancel()
            if (animator != null) {
                animator?.cancel()
                animator = null
            }
            animator = ObjectAnimator.ofFloat(binding.ivStar, View.ALPHA, 0f)
            animator?.let { animator ->
                animator.repeatCount = 1
                animator.repeatMode = ObjectAnimator.REVERSE
                animator.start()
            }
        }
        binding.bt5.setOnClickListener {
            set?.cancel()
            lifecycleScope.launchWhenResumed {
                while (true) {
                    delay(100)
                    val container = binding.ivStar.parent as ViewGroup
                    val containerW = container.width
                    val containerH = container.height
                    var starW: Float = binding.ivStar.width.toFloat()
                    var starH: Float = binding.ivStar.height.toFloat()
                    val newStar = AppCompatImageView(requireContext())
                    newStar.setImageResource(R.drawable.ic_baseline_star_24)
                    newStar.layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT
                    )
                    container.addView(newStar)

                    newStar.scaleX = Math.random().toFloat() * 1.5f + .1f
                    newStar.scaleY = newStar.scaleX
                    starW *= newStar.scaleX
                    starH *= newStar.scaleY
                    newStar.translationX = Math.random().toFloat() *
                            containerW - starW / 2


                    val mover = ObjectAnimator.ofFloat(
                        newStar, View.TRANSLATION_Y,
                        -starH, containerH + starH
                    )

                    mover.interpolator = AccelerateInterpolator(1f)
                    val rotator = ObjectAnimator.ofFloat(
                        newStar, View.ROTATION,
                        (Math.random() * 1080).toFloat()
                    )
                    rotator.interpolator = LinearInterpolator()

                    set = AnimatorSet()
                    set?.let { set ->
                        set.playTogether(mover, rotator)
                        set.duration = (Math.random() * 1500 + 500).toLong()

                        set.addListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator?) {
                                container.removeView(newStar)
                            }
                        })
                        set.start()
                    }
                }
            }


        }
    }

}