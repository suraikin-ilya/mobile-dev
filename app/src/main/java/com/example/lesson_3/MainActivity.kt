package com.example.lesson_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.lesson_3.databinding.ActivityMainBinding

interface ActivityFunctions{
    fun showNextFragment(uuid: Int)
    fun showPreviousFragment(uuid: Int)
}

class MainActivity : AppCompatActivity(), ActivityFunctions {

    private lateinit var binding: ActivityMainBinding

    private var fragmentList: List<Fragment> = listOf(BlankFragment_1(), BlankFragment_2(), BlankFragment_3(), BlankFragment_4())
    private var buttonList: MutableList<Button> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonList.add(0, binding.topButton1)
        buttonList.add(1, binding.topButton2)
        buttonList.add(2, binding.topButton3)
        buttonList.add(3, binding.topButton4)

        setOnClickEventListener()
    }

    private fun setOnClickEventListener(){
        if (fragmentList.size != buttonList.size) return
        for (i in fragmentList.indices){
            if ( i != 0 ) buttonList[i].setEnabled(false)
            buttonList[i].setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentList[i]).commit()
            }
        }
    }

    override fun showNextFragment(uuid: Int){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentList[uuid + 1]).commit()
        animateButtons(uuid + 1)
    }

    override fun showPreviousFragment(uuid: Int) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentList[uuid - 1]).commit()
    }

    fun animateButtons(uuid: Int){
        for (i in 0..uuid) {
            buttonList[i].setEnabled(true)
        }
    }


}