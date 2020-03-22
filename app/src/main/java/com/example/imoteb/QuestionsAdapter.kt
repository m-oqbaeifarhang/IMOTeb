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
        if(wordtoSpan[0].toString() == "*") wordtoSpan.setSpan(ForegroundColorSpan(Color.RED),
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.questionTitle.setText(wordtoSpan)
        when(model.Answers[position])
        {
            0 -> holder.itemView.findViewById<RadioButton>(R.id.rb_0).setChecked(true)
            1 -> holder.itemView.findViewById<RadioButton>(R.id.rb_1).setChecked(true)
            2 -> holder.itemView.findViewById<RadioButton>(R.id.rb_2).setChecked(true)
        }
        holder.radiogroup.setOnCheckedChangeListener { group, checkedId ->
            model.titleQuestionsList[position] = model.titleQuestionsList[position].replace("*", "")
            val rdb = holder.radiogroup.findViewById<RadioButton>(group.checkedRadioButtonId)
            val idx = holder.radiogroup.indexOfChild(rdb)
            model.Answers[position] = idx
            // Log.i("mi",model.Answers[position].toString())

               notifyItemChanged(position, group)
        }
    }
}

