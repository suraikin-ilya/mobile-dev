package com.example.lesson_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson_3.databinding.FragmentBlank1Binding
import com.example.lesson_3.databinding.FragmentBlank2Binding
import java.lang.Exception


class BlankFragment_2 : Fragment() {

    lateinit var binding: FragmentBlank2Binding

    private var uuid = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater, container, false)

        nextButtonClick()
        prevButtonClick()

        return binding.root
    }

    private fun nextButtonClick(){
        binding.next.setOnClickListener {
            val activityFunctions = requireActivity() as ActivityFunctions
            try{
                Calculate.second_field = binding.secondTextView.text.toString().toInt()
            }
            catch (e: Exception){
                Calculate.second_field = null
            }
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