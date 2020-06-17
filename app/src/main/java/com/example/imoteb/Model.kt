package com.example.imoteb

import android.content.res.Resources
import android.provider.ContactsContract
import android.service.autofill.Dataset
import androidx.core.app.NotificationCompatSideChannelService
import com.github.mikephil.charting.data.DataSet
import java.security.KeyStore
import java.util.jar.Attributes

class Model()
{
    companion object
    {
        var EmtiyazSoalat = MutableList<Float>(32) { 1f }
        var questionTableList = mutableListOf<QuestionTable>()
        init
        {
            MakeEmtiyazSolatMutableList()
        }
        var Age: Int = 0
        var KamKhuni = false
        var Sex = false
        var Tahol = false
        lateinit var QuestionTitle: MutableList<String>
        var TheHighestScore:Int=2
        fun MeghadDehiMotaghayerHa(): Unit
        {
            Age = 0
            KamKhuni = false
            Sex = false
            Tahol = false
            MakeEmtiyazSolatMutableList()
        }
        fun MakeEmtiyazSolatMutableList(): Unit
        {
            var counter = 0
            for(i in 0..31)
            {
                when
                {
                    counter in 0..6 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.dam,
                            score = -1.0))
                    }
                    counter in 7..15 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.safra,
                            score = -1.0))
                    }
                    counter in 16..24 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.soda,
                            score = -1.0))
                    }
                    counter in 25..31 ->
                    {
                        questionTableList.add(QuestionTable(questionType = Globals.Companion.MezajhaEnum.balgham,
                            score = -1.0))
                    }
                }
                counter++
            }
            questionTableList[0].coefficient = 2.0
            questionTableList[1].coefficient = 1.5
            questionTableList[4].coefficient = 1.5
            questionTableList[6].coefficient = 1.5
            questionTableList[9].coefficient = 1.5
            questionTableList[10].coefficient = 1.5
            questionTableList[11].coefficient = 1.5
            questionTableList[13].coefficient = 2.0
            questionTableList[16].coefficient = 2.0
            questionTableList[18].coefficient = 1.5
            questionTableList[22].coefficient = 1.5
            questionTableList[24].coefficient = 2.0
            questionTableList[25].coefficient = 2.0
            questionTableList[30].coefficient = 2.0

        }
    }
}

data class QuestionTable(var questionType: Globals.Companion.MezajhaEnum,
    var answerType: Globals.Companion.AnswerType = Globals.Companion.AnswerType.YesSomeTimeNo,
    var score: Double,
    var coefficient: Double = 1.0,var active:Boolean=true)
{

}