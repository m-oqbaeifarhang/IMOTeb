package com.example.imoteb.MezajsTest


class ConfigurationQuestions
{
    companion object
    {
        //در این تابع سن گرفته میشود و مطابق با سن فرد برخی سوالات از لیست عنوان سوالات حذف میشود

        fun ByAge(age: Int): Unit
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

            Model.questionTableList.removeAll { a -> a.Deleted }
        }

        fun ByGender(gender: Globals.Companion.Gender): Unit
        {
            if(gender == Globals.Companion.Gender.Male)
            {
                Model.questionTableList[24].Deleted = true
                Model.questionTableList.removeAll { a -> a.Deleted }
            }
        }

        fun ByMaritalStatus(MaritalStatus: Globals.Companion.MaritalStatus): Unit
        {
            if(MaritalStatus == Globals.Companion.MaritalStatus.Single)
            {
                Model.questionTableList[12].Deleted = true
                Model.questionTableList.removeAll { a -> a.Deleted }
            }
        }
    }

}