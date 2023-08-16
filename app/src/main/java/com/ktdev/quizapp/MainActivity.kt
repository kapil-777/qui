package com.ktdev.quizapp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ktdev.quizapp.R.color.txt_color
import com.ktdev.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val questions = arrayOf("What is the built in database in Android Studio",
        "Who was the Founder of the Android",
        "In which year , First android was released by Google"
    )

    private val options = arrayOf(
        arrayOf("MySql" , "SQLite","Firebase"),
        arrayOf("AndiRubik" , "James Gosling","Larry Page"),
        arrayOf("2010" , "2006","2008")
    )
    private  var quesIndex = 0
    private  var score = 0
    private  val answersIndex  = arrayOf(1,0,2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()

        binding.opt1.setOnClickListener {
            checkAnswer(0)
        }
        binding.opt2.setOnClickListener {
            checkAnswer(1)
        }
        binding.opt3.setOnClickListener {
            checkAnswer(2)
        }
        binding.restartBtn.setOnClickListener {
            restartQuiz()
        }


    }


    private fun correctColor(selectedIndex : Int){
        when(selectedIndex){
            0 -> binding.opt1.setBackgroundColor(Color.GREEN)
            1 -> binding.opt2.setBackgroundColor(Color.GREEN)
            2 -> binding.opt3.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongColor(selectedIndex : Int){
        when(selectedIndex){
            0 -> binding.opt1.setBackgroundColor(Color.RED)
            1 -> binding.opt2.setBackgroundColor(Color.RED)
            2 -> binding.opt3.setBackgroundColor(Color.RED)
        }
    }


   private fun resetButtonColor(){
        binding.opt1.setBackgroundColor(resources.getColor(R.color.txt_color))
        binding.opt2.setBackgroundColor(resources.getColor(R.color.txt_color))
        binding.opt3.setBackgroundColor(resources.getColor(R.color.txt_color))
    }

    private fun showResult(){
        Toast.makeText(this, " $score out of ${questions.size}",Toast.LENGTH_LONG).show()
        binding.restartBtn.isEnabled = true
    }

    private fun setData(){
        binding.questionTxt.text = questions[quesIndex]
        binding.opt1.text = options[quesIndex][0]
        binding.opt2.text = options[quesIndex][1]
        binding.opt3.text = options[quesIndex][2]
        resetButtonColor()
    }


    private fun checkAnswer(selectedBtnIndex: Int){
        var correctAns = answersIndex[quesIndex]
        if (correctAns == selectedBtnIndex){
            score++
            correctColor(selectedBtnIndex)

        }
        else{
            wrongColor(selectedBtnIndex)
            correctColor(correctAns)
        }

        if (quesIndex < questions.size -1){
            quesIndex++
            binding.questionTxt.postDelayed({setData()},1200)
        }
        else{
            showResult()
        }
    }

    private fun restartQuiz(){
        quesIndex = 0
        score = 0
        setData()
        binding.restartBtn.isEnabled = false
    }

}