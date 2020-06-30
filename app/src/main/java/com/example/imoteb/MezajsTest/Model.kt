package com.example.imoteb.MezajsTest

class Model()
{
    companion object
    {
        //var EmtiyazSoalat = MutableList<Float>(32) { 1f }
        var questionTableList = mutableListOf<QuestionTable>()

        init
        {
            MakeQueastionTable()
        }

        var Age: Int = 0
        var KamKhuni = false
        var Gender:GenderEnum = GenderEnum.Male
        var MaritalStatus:MaritalStatusEnum = MaritalStatusEnum.Single

        //lateinit var QuestionTitle: MutableList<String>
        var TheHighestScore: Int = 2
        fun MeghadDehiMotaghayerHa(): Unit
        {
            Age = 0
            KamKhuni = false
            Gender= GenderEnum.Male
            MaritalStatus =MaritalStatusEnum.Single
            if(questionTableList.any()) questionTableList.removeAll { a -> !a.Deleted }
            MakeQueastionTable()
        }

        fun SetQuestionTitle(questionTitleList: List<String>): Unit
        {
            questionTitleList.forEachIndexed { index, s ->
                questionTableList[index].questionTitle = s
            }
        }

        fun MakeQueastionTable(): Unit
        {
            for(i in 0..31)
            {
                when(i)
                {

                    in 0..6 ->
                    {
                        questionTableList.add(QuestionTable(questionType = MezajsEnum.dam))
                    }
                    in 7..15 ->
                    {
                        questionTableList.add(QuestionTable(questionType = MezajsEnum.safra))
                    }
                    in 16..24 ->
                    {
                        questionTableList.add(QuestionTable(questionType = MezajsEnum.soda))
                    }
                    in 25..31 ->
                    {
                        questionTableList.add(QuestionTable(questionType = MezajsEnum.balgham))
                    }
                }
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

            questionTableList[1].answerType = AnswerTypeEnum.YesNo
            questionTableList[2].answerType = AnswerTypeEnum.YesNo
            questionTableList[4].answerType = AnswerTypeEnum.YesNo
            questionTableList[7].answerType = AnswerTypeEnum.YesNo
        }
    }
}
data class QuestionTable(var questionTitle: String = "",
    var questionType: MezajsEnum = MezajsEnum.dam,
    var answerType: AnswerTypeEnum = AnswerTypeEnum.YesSomeTimeNo,
    var score: Double = -1.0,
    var coefficient: Double = 1.0,var Deleted:Boolean=false,var Choosed:Boolean=false)



