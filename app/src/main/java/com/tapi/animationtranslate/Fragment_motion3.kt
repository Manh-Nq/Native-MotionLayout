package com.tapi.animationtranslate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tapi.animationtranslate.databinding.FragmentMotion3Binding

class Fragment_motion3 : Fragment() {


    private var _binding: FragmentMotion3Binding? = null
    val binding: FragmentMotion3Binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentMotion3Binding.inflate(inflater, container, false)

        return binding.root
    }

}