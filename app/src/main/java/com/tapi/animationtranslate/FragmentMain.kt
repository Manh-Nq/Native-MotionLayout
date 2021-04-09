package com.tapi.animationtranslate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tapi.animationtranslate.databinding.FragmentMotionMainBinding


class FragmentMain : Fragment() {
    private var _binding: FragmentMotionMainBinding? = null
    val binding: FragmentMotionMainBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMotionMainBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {

        binding.bt1.setOnClickListener { findNavController().navigate(R.id.action_fragment_motion_main_to_fragment_motion1) }
        binding.bt2.setOnClickListener { findNavController().navigate(R.id.action_fragment_motion_main_to_fragment_motion2) }
        binding.bt3.setOnClickListener { findNavController().navigate(R.id.action_fragment_motion_main_to_fragment_motion3) }
        binding.bt4.setOnClickListener { findNavController().navigate(R.id.action_fragment_motion_main_to_fragment_motion4) }
        binding.bt5.setOnClickListener { findNavController().navigate(R.id.action_fragment_motion_main_to_fragment_motion5) }
        binding.bt6.setOnClickListener { findNavController().navigate(R.id.action_fragment_motion_main_to_fragment_6) }
        binding.bt7.setOnClickListener { findNavController().navigate(R.id.action_fragment_motion_main_to_fragmentAnimator) }
        binding.bt8.setOnClickListener { findNavController().navigate(R.id.action_fragment_motion_main_to_frgAnim) }
        binding.bt9.setOnClickListener { findNavController().navigate(R.id.action_fragment_motion_main_to_demoFragmentMotion) }
    }

}