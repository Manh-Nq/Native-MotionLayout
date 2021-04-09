package com.tapi.animationtranslate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.tapi.animationtranslate.databinding.FragmentMotion5Binding
import com.tapi.animationtranslate.viewpagers.ViewPagerAdapter


class FragmentViewPager : Fragment() {

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
        adapter.addPage("Page 1", R.layout.motion_16_viewpager_page1)
        adapter.addPage("Page 2", R.layout.motion_16_viewpager_page2)
        adapter.addPage("Page 3", R.layout.motion_16_viewpager_page3)
        adapter.addPage("Page 4", R.layout.motion_16_viewpager_page4)
        adapter.addPage("Page 5", R.layout.motion_16_viewpager_page5)
        binding.pager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.pager)

        binding.pager.addOnPageChangeListener(binding.motionLayout as ViewPager.OnPageChangeListener)
    }

}