package com.example.imoteb

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.annotation.UiThread
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.thread


class QuestionsAdapter(var context: Context?) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>()
{
    private val onBind = false
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
        return Model.questionTableList.size
    }
    fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean)
    {
        if(!onBind)
        {
            // your process when checkBox changed
            // ...
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {

        val wordtoSpan = SpannableString(Model.questionTableList[position].questionTitle)
        if(wordtoSpan[0].toString() == "*") wordtoSpan.setSpan(ForegroundColorSpan(Color.RED),
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.questionTitle.setText(wordtoSpan)
        var scoree = Model.questionTableList[position].score
        when(Model.questionTableList[position].score)
        {
            0.0 -> holder.itemView.findViewById<RadioButton>(R.id.rb_0).isChecked = true
            1.0 -> holder.itemView.findViewById<RadioButton>(R.id.rb_1).isChecked = true
            2.0 -> holder.itemView.findViewById<RadioButton>(R.id.rb_2).isChecked = true
        }

        holder.radiogroup.setOnCheckedChangeListener { group, checkedId ->
            Model.questionTableList[position].questionTitle =
                Model.questionTableList[position].questionTitle.replace("*", "")
            val rdb = holder.radiogroup.findViewById<RadioButton>(group.checkedRadioButtonId)
            val score = rdb.contentDescription[0].toString()
            Model.questionTableList[position].score = score.toDouble()


              notifyItemChanged(position,group)
          

        }

    }


}

