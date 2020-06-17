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
            Model.MakeEmtiyazSolatMutableList()
            if(age > 40)
            {
                Model.questionTableList[0].active = false
                Model.questionTableList[1].active = false
                Model.questionTableList[11].active = false
                if(age > 50)
                {
                    Model.questionTableList[9].active = false
                }
            }
            if(age < 50)
            {
                Model.questionTableList[26].active = false
            }
            if(Model.Tahol == false)
            {
                Model.questionTableList[12].active = false
            }
            if(Model.Sex == false)
            {
                Model.questionTableList[24].active = false
            }
            return list
        }

    }

}