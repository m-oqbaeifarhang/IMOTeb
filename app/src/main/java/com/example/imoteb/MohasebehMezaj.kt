package com.example.imoteb

import android.view.Display

class MohasebehMezaj
{
    enum class Mezajha
    {
        dam, safra, soda, balgham
    }

    companion object
    {
        fun Calculate(answer: MutableList<Int>): ComputeMezajsResult
        {
            val CMR = ComputeMezajsResult()
            var MezajCounter = 1
            var counter = 0
            var mezaj: Mezajha = Mezajha.dam
            (answer).forEach {
                val value = it xor 1
                when(mezaj)
                {
                    Mezajha.dam ->
                    {
                        CMR.dam += value * Model.EmtiyazSoalat[counter]
                        if(MezajCounter == Model.DamQuestionCount)
                        {
                            mezaj = Mezajha.safra
                            MezajCounter = 0
                        }
                    }
                    Mezajha.safra ->
                    {
                        CMR.safra += value * Model.EmtiyazSoalat[counter]
                        if(MezajCounter == Model.SafraQuestionCount)
                        {
                            mezaj = Mezajha.soda
                            MezajCounter = 0
                        }
                    }
                    Mezajha.soda ->
                    {
                        CMR.soda += value * Model.EmtiyazSoalat[counter]
                        if(MezajCounter == Model.SodaQuestionCount)
                        {
                            mezaj = Mezajha.balgham
                            MezajCounter = 0
                        }
                    }
                    Mezajha.balgham ->
                    {
                        CMR.balgham += value * Model.EmtiyazSoalat[counter]
                        if(MezajCounter == Model.BalghamQuestionCount)
                        {
                            MezajCounter = 0
                        }
                    }
                }
                MezajCounter++
                counter++;
            }
            CMR.dam = (5.25f * CMR.dam) / Model.MaxOfDamAnswerSize
            CMR.safra = (5.25f * CMR.safra) / Model.MaxOfSafraAnswerSize
            CMR.soda = (5.25f * CMR.soda) / Model.MaxOfSodaAnswerSize
            CMR.balgham = (5.25f * CMR.balgham) / Model.MaxOfBalghamAnswerSize

            val age = Model.Age
            when(age)
            {
                in 0..16 ->
                {
                    CMR.dam += 1.75f
                }
                in 17..30 ->
                {
                    CMR.safra += 1.75f
                }
                in 31..45 ->
                {
                    val safra = 45 - age
                    val soda = 15 - safra
                    CMR.safra += (1.75f * safra) / 15
                    CMR.soda += (1.75f * soda) / 15
                }
                in 46..55 ->
                {
                    val soda = 55 - age
                    val balgham = 10 - soda
                    CMR.soda += (1.75f * soda) / 10
                    CMR.balgham += (1.75f * balgham) / 10
                }
                else ->
                {
                    CMR.balgham += 1.75f
                }

            }
            CMR.dam += 3f
            CMR.safra += 3f
            CMR.soda += 3f
            CMR.balgham += 3f
            return CMR
        }
    }

    class ComputeMezajsResult
    {
        var dam: Float = 0f
        var safra: Float = 0f
        var soda: Float = 0f
        var balgham: Float = 0f
    }
}

