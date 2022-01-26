package com.example.lesson_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson_3.databinding.FragmentBlank1Binding
import com.example.lesson_3.databinding.FragmentBlank3Binding
import java.lang.Exception


class BlankFragment_3 : Fragment() {

    lateinit var binding: FragmentBlank3Binding

    private var uuid = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank3Binding.inflate(inflater, container, false)

        nextButtonClick()
        prevButtonClick()

        return binding.root
    }

    private fun nextButtonClick(){
        binding.next.setOnClickListener {
            val activityFunctions = requireActivity() as ActivityFunctions
            Calculate.operation = binding.operation.text.toString()
            activityFunctions.showNextFragment(uuid)
        }
    }

    private fun prevButtonClick(){
        binding.prev.setOnClickListener {
            val activityFunctions = requireActivity() as ActivityFunctions
            activityFunctions.showPreviousFragment(uuid)
        }
    }

}