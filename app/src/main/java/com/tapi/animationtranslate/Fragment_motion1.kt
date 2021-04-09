package com.tapi.animationtranslate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.tapi.animationtranslate.databinding.FragmentMotion1Binding


class Fragment_motion1 : Fragment() {
    private var _binding: FragmentMotion1Binding? = null
    val binding: FragmentMotion1Binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMotion1Binding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.motion1.addTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.d("manh.nq", "onTransitionStarted: ")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                Log.d("manh.nq", "onTransitionChange: ")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                Log.d("manh.nq", "onTransitionCompleted: ")
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.d("manh.nq", "onTransitionTrigger: ")
            }

        })
    }

}