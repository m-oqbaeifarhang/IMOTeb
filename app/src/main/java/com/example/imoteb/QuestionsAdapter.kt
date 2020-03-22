package com.example.imoteb

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class QuestionsAdapter(var context: Context, var model: Model) :

    RecyclerView.Adapter<QuestionsAdapter.ViewHolder>()
{
    private val lastCheckedPosition = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        var questionTitle = itemView.findViewById<TextView>(R.id.txt_question)
        var radiogroup = itemView.findViewById<RadioGroup>(R.id.radioGroup)
        var radioButton1 = itemView.findViewById<RadioButton>(R.id.rb_0)
        var radioButton2 = itemView.findViewById<RadioButton>(R.id.rb_1)
        var radioButton3 = itemView.findViewById<RadioButton>(R.id.rb_2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        var v = LayoutInflater.from(context).inflate(R.layout.questions_model, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int
    {
        return model.titleQuestionsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val wordtoSpan = SpannableString(model.titleQuestionsList[position])
        if(wordtoSpan[0].toString()=="*")
            wordtoSpan.setSpan(ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.questionTitle.setText(wordtoSpan)
        when(model.Answers[position])
        {
            1 -> holder.radioButton1.setChecked(true)
            2 -> holder.radioButton2.setChecked(true)
            3 -> holder.radioButton3.setChecked(true)
        }
        holder.radiogroup.setOnCheckedChangeListener { group, checkedId ->
            model.titleQuestionsList[position] = model.titleQuestionsList[position].replace("*", "")
            model.Answers[position] = group.checkedRadioButtonId.checkedRadioIndex()
            notifyItemChanged(position, group)
        }
    }
}

fun Int.checkedRadioIndex(): Int
{
    when(this)
    {
        2131296423 -> return 1
        2131296424 -> return 2
        2131296425 -> return 3
    }
    return 0
}