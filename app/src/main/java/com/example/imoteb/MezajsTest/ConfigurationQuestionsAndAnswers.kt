package com.example.imoteb.MezajsTest

class ConfigurationQuestionsAndAnswers
{
    companion object
    {
        //در این تابع سن گرفته میشود و مطابق با سن فرد برخی سوالات از لیست عنوان سوالات حذف میشود
        fun ConfigurationQuestionByAge(age: Int): Unit
        {
            if(age > 40)
            {
                Model.questionTableList[0].Deleted = true
                Model.questionTableList[1].Deleted = true
                Model.questionTableList[11].Deleted = true
                if(age > 50)
                {
                    Model.questionTableList[9].Deleted = true
                }
            }
            if(age < 50)
            {
                Model.questionTableList[26].Deleted = true
            }
            if(Model.Tahol == false)
            {
                Model.questionTableList[12].Deleted = true
            }
            if(Model.Sex == false)
            {
                Model.questionTableList[24].Deleted = true
            }
            Model.questionTableList.removeAll { a->a.Deleted }
        }

    }

}