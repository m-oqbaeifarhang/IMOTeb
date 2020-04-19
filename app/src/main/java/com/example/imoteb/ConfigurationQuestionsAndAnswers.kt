package com.example.imoteb

import android.content.res.Configuration
import java.time.temporal.ValueRange

class ConfigurationQuestionsAndAnswers
{
    companion object
    {
        //در این تابع سن گرفته میشود و مطابق با سن فرد برخی سوالات از لیست عنوان سوالات حذف میشود
        fun ConfigurationQuestion(list: MutableList<String>, age: Int): MutableList<String>
        {
            if(age > 35)
            {
                list.removeAt(3)
            }
            if(age < 55)
            {
                list.removeAt(44 - 1)
            }
            MakeAndConfigurationAnswer(age)
            return list
        }

        // این تابع بر اساس سن فرد طول آرایه جواب ها را مشخص میکند و همچنین تعداد سوالات هر مزاج را مشخص میکند.
        private fun MakeAndConfigurationAnswer(age: Int): Unit
        {
            if(age > 35)
            {
                Model.DefultAnswerArraysize -= 1
                Model.DamQuestionCount -= 1
                Model.MaxOfDamAnswerSize -= 3
            }
            if(age < 55)
            {
                Model.DefultAnswerArraysize -= 1
                Model.BalghamQuestionCount -= 1
                Model.MaxOfBalghamAnswerSize -= 3
            }
            if(Model.Answers == null)
            {
                val Answers: IntArray = IntArray(Model.DefultAnswerArraysize) { -1 }
                Model.Answers = Answers
            }
        }

    }

}