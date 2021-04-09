package com.tapi.animationtranslate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tapi.animationtranslate.youtube.PhotosAdapter
import com.tapi.animationtranslate.youtube.Cats


class Fragment_6 : Fragment() {
    private lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mView = LayoutInflater.from(requireContext())
            .inflate(R.layout.fragment_motion6, container, false)

        initViews()
        return mView
    }

    private fun initViews() {
        val recyclerView = mView.findViewById<RecyclerView>(R.id.recyclerview_front)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = PhotosAdapter(Cats.catImages)
        recyclerView.adapter = adapter

    }

}