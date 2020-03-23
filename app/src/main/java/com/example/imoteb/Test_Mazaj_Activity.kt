package com.example.imoteb

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_test_mazaj.*
import kotlinx.android.synthetic.main.questions_model.*
import org.w3c.dom.Text


class Test_Mazaj_Activity : AppCompatActivity()
{
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_mazaj)


        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val titleQuestions = resources.getStringArray(R.array.QuestionArrayy)
        rv_questions.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_questions.setItemViewCacheSize(titleQuestions.size)
        var model = Model(titleQuestions)
        model.titleQuestionsList = titleQuestions
        val questionAapter = QuestionsAdapter(this, model)
        rv_questions.adapter = questionAapter

        btn_result.setOnClickListener {
            val list = mutableListOf<Int>()
            var counter = 0
            if(model.Answers.contains(-1))
            {

                (model.Answers).forEach {
                    if(it == -1)
                    {
                        val text = model.titleQuestionsList[counter].replace("* ","")
                        model.titleQuestionsList[counter]="* "+text
                        rv_questions.adapter =questionAapter
                    }
                    counter++
                }

            } else
            {

            }


            // val viewHolder  = (rv_questions.layoutManager as LinearLayoutManager).findViewByPosition(i)
            //                var viewHolder = rv_questions.findViewHolderForAdapterPosition(i)
            //                if(viewHolder != null)
            //                {
            //                    val radioGroup = viewHolder.itemView.findViewById<RadioGroup>(R.id.radioGroup)
            //                    val txt_question = viewHolder.itemView.findViewById<TextView>(R.id.txt_question)
            //                    val cheakedid = radioGroup.checkedRadioButtonId
            //                    if(cheakedid == -1)
            //                    {
            //                        list.add(i, -1)
            //                        val spannable =
            //                            SpannableString("* " + txt_question.text.toString().replace("* ", ""))
            //                        spannable.setSpan(ForegroundColorSpan(Color.RED),
            //                            0,
            //                            1,
            //                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            //                        txt_question.setText(spannable, TextView.BufferType.SPANNABLE)
            //                        Log.i("MyLog", "-" + counter.toString())
            //                        //   Toast.makeText(this,"سوالات علامت دار را تکمیل کنید.", Toast.LENGTH_LONG).show()
            //                    } else
            //                    {
            //                        txt_question.setText(txt_question.text.toString().replace("* ", ""))
            //                        val radioBtn = findViewById<RadioButton>(cheakedid)
            //                        val radiobtnId = radioBtn.text.toString().convertRadioBtnTextToNum()
            //                        list.add(i, radiobtnId)
            //                        Log.i("MyLog", counter.toString())
            //                        //  Toast.makeText(this, list.get(i).toString(), Toast.LENGTH_LONG).show()
            //                    }
            //                }
            // Log.i("MyLog",counter.toString())

            //            }
        }

    }

    fun String.convertRadioBtnTextToNum(): Int
    {
        when(this)
        {
            "هرگز" -> return 0
            "گاهی اوقات" -> return 1
            "همیشه" -> return 2
        }
        return -1
    }
}

