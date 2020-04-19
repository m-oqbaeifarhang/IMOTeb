package com.example.imoteb

import android.app.Activity
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
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import java.time.temporal.ValueRange


class QuestionsAdapter(var context: Context?) :

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
        val v = LayoutInflater.from(context).inflate(R.layout.questions_model, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int
    {
        return Model.QuestionTitle.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val wordtoSpan = SpannableString(Model.QuestionTitle[position])
        if(wordtoSpan[0].toString() == "*") wordtoSpan.setSpan(ForegroundColorSpan(Color.RED),
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.questionTitle.setText(wordtoSpan)

        when(Model.Answers?.get(position))
        {
            0 -> holder.itemView.findViewById<RadioButton>(R.id.rb_0).isChecked = true
            1 -> holder.itemView.findViewById<RadioButton>(R.id.rb_1).isChecked = true
            2 -> holder.itemView.findViewById<RadioButton>(R.id.rb_2).isChecked = true
            3 -> holder.itemView.findViewById<RadioButton>(R.id.rb_3).isChecked = true
        }
        //در اینجا سوالاتی که جوابش بله خیر است مشخص شده و جواب تبدیل به بله خیر میشود
        when(position)
        {
            0, 31, 40 ->
            {
                holder.itemView.findViewById<RadioButton>(R.id.rb_0).text = "بله"
                holder.itemView.findViewById<RadioButton>(R.id.rb_1).text = "خیر"
                holder.itemView.findViewById<RadioButton>(R.id.rb_2).visibility = View.INVISIBLE
                holder.itemView.findViewById<RadioButton>(R.id.rb_3).visibility = View.INVISIBLE
            }
        }
        holder.radiogroup.setOnCheckedChangeListener { group, checkedId ->
            Model.QuestionTitle[position] = Model.QuestionTitle[position].replace("*", "")
            val rdb = holder.radiogroup.findViewById<RadioButton>(group.checkedRadioButtonId)
            val idx = holder.radiogroup.indexOfChild(rdb)
            Model.Answers?.set(position, idx)
            notifyItemChanged(position, group)
        }
    }
}

