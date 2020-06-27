package com.example.imoteb

import android.content.Context
import android.os.Build
import android.text.SpannableString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class QuestionsAdapter(var context: Context?) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var questionTitle = itemView.findViewById<TextView>(R.id.txt_question)
        var radiogroup = itemView.findViewById<RadioGroup>(R.id.radioGroup)
        var RadioGroupYesNo = itemView.findViewById<RadioGroup>(R.id.radioGroup_two)
        var linearLayout = itemView.findViewById<LinearLayout>(R.id.linearLayout)
        var cardView = itemView.findViewById<CardView>(R.id.cardView)
var rv=itemView.findViewById<RecyclerView>(R.id.rv_questions)
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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        if(Model.questionTableList.any { a -> a.Choosed })
        {
            if(!Model.questionTableList[position].Choosed)
            {
                holder.linearLayout.setBackgroundColor(context!!.resources.getColor(R.color.red_light))
              // holder.linearLayout.scrollTo (5,6)

            }
        }
        holder.questionTitle.text =(position+1).toString()+"- "+ Model.questionTableList[position].questionTitle
        val answerType = Model.questionTableList[position].answerType
        if(answerType == Globals.Companion.AnswerType.YesSomeTimeNo)
        {
            holder.radiogroup.visibility = View.VISIBLE
            when(Model.questionTableList[position].score)
            {
                0.0 -> holder.itemView.findViewById<RadioButton>(R.id.rb_2).isChecked =
                    true //contentDescription=0
                1.0 -> holder.itemView.findViewById<RadioButton>(R.id.rb_1).isChecked =
                    true //contentDescription=1
                2.0 -> holder.itemView.findViewById<RadioButton>(R.id.rb_0).isChecked =
                    true //contentDescription=2
            }
        } else if(answerType == Globals.Companion.AnswerType.YesNo)
        {
            holder.RadioGroupYesNo.visibility = View.VISIBLE
            when(Model.questionTableList[position].score)
            {
                0.0 -> holder.itemView.findViewById<RadioButton>(R.id.rg2_rb_1).isChecked =
                    true //contentDescription=0

                2.0 -> holder.itemView.findViewById<RadioButton>(R.id.rg2_rb_0).isChecked =
                    true //contentDescription=2
            }
        }
        holder.RadioGroupYesNo.setOnCheckedChangeListener { group, checkedId ->
            holder.rv.scrollToPosition(20)
            val rdb = holder.RadioGroupYesNo.findViewById<RadioButton>(group.checkedRadioButtonId)
            SetScoreAndQuestionTitle(position, group, holder, rdb)
        }
        holder.radiogroup.setOnCheckedChangeListener { group, checkedId ->
            val rdb = holder.radiogroup.findViewById<RadioButton>(group.checkedRadioButtonId)
            SetScoreAndQuestionTitle(position, group, holder, rdb)
            var radio = holder.radiogroup
        }
    }


    private fun SetScoreAndQuestionTitle(position: Int,
        group: RadioGroup,
        holder: ViewHolder,
        rdb: RadioButton): Unit
    {
        holder.linearLayout.setBackgroundColor(context!!.resources.getColor(R.color.white))
        Model.questionTableList[position].Choosed = true
        val score = rdb.contentDescription[0].toString()
        Model.questionTableList[position].score = score.toDouble()
        holder.questionTitle.text =(position+1).toString()+"- "+ Model.questionTableList[position].questionTitle
    }
}





