package com.example.imoteb.MezajsTest


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
            val map = hashMapOf<MezajsEnum, Float>()
            map[MezajsEnum.dam] = dam
            map[MezajsEnum.safra] = safra
            map[MezajsEnum.soda] = soda
            map[MezajsEnum.balgham] = balgham
            val result = map.toList().sortedByDescending { (_, value) -> value }.toMap()
            val mezajGhalebEnum = result.keys.first()
            val mezajGhalebAdad = result.values.first()
            var mizanGhalabe = 0f
            val isEtedal=mezajGhalebAdad-result.values.last()<=1f
            if(isEtedal)
            {
                return MezajehGhalebehEnum.Etedal
            }
            when(mezajGhalebEnum)
            {
                MezajsEnum.dam ->
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
                MezajsEnum.safra ->
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
                MezajsEnum.soda ->
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
                MezajsEnum.balgham ->
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

        public fun convertMezajGhalebToPersianText(mezajehGhalebehEnum: MezajehGhalebehEnum): String
        {
            val result: String
            when(mezajehGhalebehEnum)
            {
                MezajehGhalebehEnum.NaMotabar ->
                {
                    result = "نتیحه تست: نا معتبر. پاسخ ها را به درستی جواب دهید."
                }
                //---------------------------------------------
                MezajehGhalebehEnum.GhalabehKamDam ->
                {
                    result = "غلبه کم دم"
                }
                MezajehGhalebehEnum.GhalabehMotavasetDam ->
                {
                    result = "غلبه متوسط دم"
                }
                MezajehGhalebehEnum.GhalabehShadidDam ->
                {
                    result = "غلبه شدید دم"
                }
                //----------------------------------------------
                MezajehGhalebehEnum.GhalabehKamsafra ->
                {
                    result = "غلبه کم صفرا"
                }
                MezajehGhalebehEnum.GhalabehMotavasetsafra ->
                {
                    result = "غلبه متوسط صفرا"
                }
                MezajehGhalebehEnum.GhalabehShadidsafra ->
                {
                    result = "غلبه شدید صفرا"
                }
                //-----------------------------------------------
                MezajehGhalebehEnum.GhalabehKamsoda ->
                {
                    result = "غلبه کم سودا"
                }
                MezajehGhalebehEnum.GhalabehMotavasetsoda ->
                {
                    result = "غلبه متوسط سودا"
                }
                MezajehGhalebehEnum.GhalabehShadidsoda ->
                {
                    result = "غلبه شدید سودا"
                }
                //-----------------------------------------------
                MezajehGhalebehEnum.GhalabehKambalgham ->
                {
                    result = "غلبه کم بلغم"
                }
                MezajehGhalebehEnum.GhalabehMotavasetbalgham ->
                {
                    result = "غلبه متوسط بلغم"
                }
                MezajehGhalebehEnum.GhalabehShadidbalgham ->
                {
                    result = "غلبه شدید بلغم"
                }
                //-------------------------------------------------
                MezajehGhalebehEnum.Rih ->
                {
                    result = "غلبه ریح"
                }
                //-------------------------------------------------
                MezajehGhalebehEnum.Etedal ->
                {
                    result = "در اعتدال"
                }
            }
            return result
        }
    }
}