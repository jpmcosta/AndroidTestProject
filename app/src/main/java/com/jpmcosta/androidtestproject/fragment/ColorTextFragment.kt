package com.jpmcosta.androidtestproject.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jpmcosta.androidtestproject.databinding.FragmentColorTextBinding

class ColorTextFragment : Fragment() {

    companion object {

        private const val ARG_COLOR = "color"

        private const val ARG_TEXT = "text"


        fun newInstance(color: Int, text: String): ColorTextFragment =
                ColorTextFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLOR, color)
                        putString(ARG_TEXT, text)
                    }
                }
    }

    private lateinit var binding: FragmentColorTextBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentColorTextBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupColor()

        setupText()
    }

    private fun setupColor() {
        val defaultColor = Color.RED
        binding.root.setBackgroundColor(arguments?.getInt(ARG_COLOR, defaultColor) ?: defaultColor)
    }

    private fun setupText() {
        binding.text1.text = arguments?.getString(ARG_TEXT)
    }
}