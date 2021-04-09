package com.tapi.animationtranslate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.tapi.animationtranslate.databinding.FragmentMotion5Binding
import com.tapi.animationtranslate.viewpagers.ViewPagerAdapter


class Fragment_motion5 : Fragment() {

    private var _binding: FragmentMotion5Binding? = null
    private val binding: FragmentMotion5Binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMotion5Binding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addPage("1", R.layout.motion_16_viewpager_page1)
        adapter.addPage("2", R.layout.motion_16_viewpager_page2)
        adapter.addPage("3", R.layout.motion_16_viewpager_page3)
        binding.pager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.pager)

        binding.pager.addOnPageChangeListener(binding.motionLayout as ViewPager.OnPageChangeListener)
    }

}