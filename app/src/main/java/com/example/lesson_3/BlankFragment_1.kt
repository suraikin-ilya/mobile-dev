package com.example.lesson_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson_3.databinding.FragmentBlank1Binding


class BlankFragment_1 : Fragment() {

    lateinit var binding: FragmentBlank1Binding

    private var uuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank1Binding.inflate(inflater, container, false)
        nextButtonClick()
        return binding.root
    }

    private fun nextButtonClick(){
        binding.nextButton.setOnClickListener {
            val activityFunctions = requireActivity() as ActivityFunctions
            try {
                Calculate.first_field = binding.firstTextView.text.toString().toInt()
            }
            catch (e: Exception){
                Calculate.first_field = null
            }
            activityFunctions.showNextFragment(uuid)
        }
    }


}