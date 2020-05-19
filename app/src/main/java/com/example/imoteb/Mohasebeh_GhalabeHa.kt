package com.example.imoteb

import com.example.imoteb.Globals.Companion.MezajhaEnum

import kotlinx.coroutines.GlobalScope
import kotlin.contracts.ReturnsNotNull

enum class MezajehGhalebehEnum
{
    GhalabehKamDam, GhalabehKamsafra, GhalabehKamsoda, GhalabehKambalgham, GhalabehMotavasetDam, GhalabehMotavasetsafra, GhalabehMotavasetsoda, GhalabehMotavasetbalgham, GhalabehShadidDam, GhalabehShadidsafra, GhalabehShadidsoda, GhalabehShadidbalgham, Etedal, Rih, NaMotabar

}


class Mohasebeh_GhalabeHa
{
    companion object
    {


        fun Mohasebe(dam: Float, safra: Float, soda: Float, balgham: Float): MezajehGhalebehEnum
        {
            val map = hashMapOf<MezajhaEnum, Float>()
            map[MezajhaEnum.dam] = dam
            map[MezajhaEnum.safra] = safra
            map[MezajhaEnum.soda] = soda
            map[MezajhaEnum.balgham] = balgham
            val result = map.toList().sortedByDescending { (_, value) -> value }.toMap()
            val mezajGhalebEnum = result.keys.first()
            val mezajGhalebAdad = result.values.first()
            var mizanGhalabe = 0f
            val isEtedal=mezajGhalebAdad-result.values.last()<=1f
            if(isEtedal)
            {
                return  MezajehGhalebehEnum.Etedal
            }
            when(mezajGhalebEnum)
            {
                MezajhaEnum.dam ->
                {
                    mizanGhalabe = dam - soda
                    when
                    {
                        mizanGhalabe <= 1 ->
                        {
                            return MezajehGhalebehEnum.NaMotabar
                        }
                        mizanGhalabe <= 2 ->
                        {
                            return MezajehGhalebehEnum.GhalabehKamDam

                        }
                        mizanGhalabe <= 4 ->
                        {
                            return MezajehGhalebehEnum.GhalabehMotavasetDam
                        }
                        else ->
                        {
                            return MezajehGhalebehEnum.GhalabehShadidDam
                        }
                    }

                }
                MezajhaEnum.safra ->
                {
                    mizanGhalabe = safra - balgham
                    val rih = mezajGhalebAdad - soda
                    if(rih <= 1)
                    {
                        return MezajehGhalebehEnum.Rih
                    }
                    when
                    {
                        mizanGhalabe <= 1 ->
                        {
                            return MezajehGhalebehEnum.NaMotabar
                        }
                        mizanGhalabe <= 2 ->
                        {
                            return MezajehGhalebehEnum.GhalabehKamsafra

                        }
                        mizanGhalabe <= 4 ->
                        {
                            return MezajehGhalebehEnum.GhalabehMotavasetsafra
                        }
                        else ->
                        {
                            return MezajehGhalebehEnum.GhalabehShadidsafra
                        }
                    }
                }
                MezajhaEnum.soda ->
                {
                    mizanGhalabe = soda - dam
                    val rih = soda - safra
                    if(rih <= 1)
                    {
                        return MezajehGhalebehEnum.Rih
                    }
                    when
                    {
                        mizanGhalabe <= 1 ->
                        {
                            return MezajehGhalebehEnum.NaMotabar
                        }
                        mizanGhalabe <= 2 ->
                        {
                            return MezajehGhalebehEnum.GhalabehKamsoda

                        }
                        mizanGhalabe <= 4 ->
                        {
                            return MezajehGhalebehEnum.GhalabehMotavasetsoda
                        }
                        else ->
                        {
                            return MezajehGhalebehEnum.GhalabehShadidsoda
                        }
                    }
                }
                MezajhaEnum.balgham ->
                {
                    mizanGhalabe = balgham - safra
                    when
                    {
                        mizanGhalabe <= 1 ->
                        {
                            return MezajehGhalebehEnum.NaMotabar
                        }
                        mizanGhalabe <= 2 ->
                        {
                            return MezajehGhalebehEnum.GhalabehKambalgham

                        }
                        mizanGhalabe <= 4 ->
                        {
                            return MezajehGhalebehEnum.GhalabehMotavasetbalgham
                        }
                        else ->
                        {
                            return MezajehGhalebehEnum.GhalabehShadidbalgham
                        }
                    }
                }
            }

        }
    }
}