package com.example.imoteb

import android.content.res.Configuration
import android.view.Display
import android.widget.TabHost
import java.time.temporal.ValueRange

class ConfigurationQuestionsAndAnswers
{
    companion object
    {
        //در این تابع سن گرفته میشود و مطابق با سن فرد برخی سوالات از لیست عنوان سوالات حذف میشود
        fun ConfigurationQuestionAndAnswer(list: MutableList<String>, age: Int): MutableList<String>
        {
            Model.Answers = MutableList(32) { -1 }
            Model.MakeEmtiyazSolatMutableList()
            if(age > 40)
            {
                list[0] = "-"
                list[1] = "-"
                list[11] = "-"
                Model.Answers[0] = -2
                Model.Answers[1] = -2
                Model.Answers[11] = -2

                Model.DamQuestionCount -= 2
                Model.SafraQuestionCount -= 1

                Model.MaxOfDamAnswerSize -= (Model.EmtiyazSoalat[0] + Model.EmtiyazSoalat[1])*2 //این عدد همان ضریب سوال است که از جمع امتیاز پاسخ ها کم میشه در پایینی ها هم همین معنی رو داره
                Model.MaxOfSafraAnswerSize -= Model.EmtiyazSoalat[11]*2

                Model.EmtiyazSoalat[0] = -2f
                Model.EmtiyazSoalat[1] = -2f
                Model.EmtiyazSoalat[11] = -2f
                if(age > 50)
                {
                    list[9] = "-"
                    Model.Answers[9] = -2

                    Model.SafraQuestionCount -= 1

                    Model.MaxOfSafraAnswerSize -= Model.EmtiyazSoalat[9]*2

                    Model.EmtiyazSoalat[9] = -2f
                }

            }
            if(age < 50)
            {
                list[26] = "-"

                Model.Answers[26] = -2

                Model.BalghamQuestionCount -= 1

                Model.MaxOfBalghamAnswerSize -=  Model.EmtiyazSoalat[26]*2

                Model.EmtiyazSoalat[26] = -2f
            }
            if(Model.Tahol == false)
            {
                list[12] = "-"
                Model.Answers[12] = -2

                Model.SafraQuestionCount -= 1

                Model.MaxOfSafraAnswerSize -= Model.EmtiyazSoalat[12]*2

                Model.EmtiyazSoalat[12] = -2f
            }
            if(Model.Sex == false)
            {
                list[24] = "-"
                Model.Answers[24] = -2

                Model.SodaQuestionCount -= 1

                Model.MaxOfSodaAnswerSize -= Model.EmtiyazSoalat[24]*2

                Model.EmtiyazSoalat[24] = -2f
            }
            var size1 = Model.Answers.size
            Model.Answers.removeAll {
                it == -2
            }
            list.removeAll {
                it == "-"
            }
            Model.EmtiyazSoalat.removeAll {
                it == -2f
            }
            return list
        }

    }

}