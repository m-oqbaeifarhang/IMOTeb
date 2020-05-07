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

                Model.EmtiyazSoalat[0] = -2f
                Model.EmtiyazSoalat[1] = -2f
                Model.EmtiyazSoalat[11] = -2f

                Model.DamQuestionCount -= 2
                Model.SafraQuestionCount -= 1

                Model.MaxOfDamAnswerSize -= 3.5f //این عدد همان ضریب سوال است که از جمع امتیاز پاسخ ها کم میشه در پایینی ها هم همین معنی رو داره
                Model.MaxOfSafraAnswerSize -= 1.5f
                if(age > 50)
                {
                    list[9] = "-"
                    Model.Answers[9] = -2

                    Model.EmtiyazSoalat[9] = -2f

                    Model.SafraQuestionCount -= 1

                    Model.MaxOfSafraAnswerSize -= 1.5f
                }

            }
            if(age < 50)
            {
                list[26] = "-"

                Model.Answers[26] = -2

                Model.EmtiyazSoalat[26] = -2f

                Model.BalghamQuestionCount -= 1

                Model.MaxOfBalghamAnswerSize -= 1
            }
            if(Model.Tahol==false)
            {
                list[12] = "-"
                Model.Answers[12] = -2

                Model.EmtiyazSoalat[12] = -2f

                Model.SafraQuestionCount-=1

                Model.MaxOfSafraAnswerSize-=1
            }
            if(Model.Sex==false)
            {
                list[24] = "-"
                Model.Answers[24] = -2

                Model.EmtiyazSoalat[24] = -2f

                Model.SodaQuestionCount -= 1

                Model.MaxOfSodaAnswerSize -= 2f
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