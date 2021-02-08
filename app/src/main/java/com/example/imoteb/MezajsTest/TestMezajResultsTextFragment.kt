package com.example.imoteb.MezajsTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imoteb.R
import kotlinx.android.synthetic.main.fragment_test_mezaj_results_text.*

class TestMezajResultsTextFragment : Fragment()
{
    var tapPosition: Int = 0

    companion object
    {
        fun newInstance(TabPosition: Int): TestMezajResultsTextFragment
        {
            val args = Bundle()
            args.putInt("TabPosition", TabPosition)
            val fragment = TestMezajResultsTextFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        tapPosition = requireArguments().getInt("TabPosition")
    }

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_mezaj_results_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val mg = Mohasebeh_GhalabeHa.Mohasebe(Model.Dam, Model.Safra, Model.Soda, Model.Balgham)
        var avarez_Ghalabeh: String = ""
        var avamel_Ghalabeh = ""
        var tusiyehhaye_Darmani = ""
        var khususiyat_Akhlaghi = ""
        when(mg)
        {
            MezajehGhalebehEnum.Etedal ->
            {
                avarez_Ghalabeh = "شما در اعتدال هستید."
                avamel_Ghalabeh = "شما در اعتدال هستید."
                tusiyehhaye_Darmani = "شما در اعتدال هستید."
                khususiyat_Akhlaghi = "شما در اعتدال هستید."
            }
            MezajehGhalebehEnum.GhalabehShadidDam, MezajehGhalebehEnum.GhalabehMotavasetDam, MezajehGhalebehEnum.GhalabehKamDam ->
            {
                avarez_Ghalabeh = getString(R.string.avarez_ghalabeh_dam)
                avamel_Ghalabeh = getString(R.string.avamel_ghalabeh_dam)
                tusiyehhaye_Darmani = getString(R.string.darman_ghalabeh_dam)
                khususiyat_Akhlaghi = getString(R.string.darman_ghalabeh_dam)
            }
            MezajehGhalebehEnum.GhalabehShadidsafra, MezajehGhalebehEnum.GhalabehMotavasetsafra, MezajehGhalebehEnum.GhalabehKamsafra ->
            {
                avarez_Ghalabeh = getString(R.string.avarez_ghalabeh_safra)
                avamel_Ghalabeh = getString(R.string.avamel_ghalabeh_safra)
                tusiyehhaye_Darmani = getString(R.string.darman_ghalabeh_safra)
                khususiyat_Akhlaghi = getString(R.string.khususiyyat_Akhlaghi_safra)
            }
            MezajehGhalebehEnum.GhalabehShadidsoda, MezajehGhalebehEnum.GhalabehMotavasetsoda, MezajehGhalebehEnum.GhalabehKamsoda ->
            {
                avarez_Ghalabeh = getString(R.string.avarez_ghalabeh_soda)
                avamel_Ghalabeh = getString(R.string.avamel_ghalabeh_soda)
                tusiyehhaye_Darmani = getString(R.string.darman_ghalabeh_soda)
                khususiyat_Akhlaghi = getString(R.string.khususiyyat_akhtalaghi_soda)
            }
            MezajehGhalebehEnum.GhalabehShadidbalgham, MezajehGhalebehEnum.GhalabehMotavasetbalgham, MezajehGhalebehEnum.GhalabehKambalgham ->
            {
                avarez_Ghalabeh = getString(R.string.avarez_ghalabeh_balgham)
                avamel_Ghalabeh =    getString( R.string.avamel_ghalabeh_balgham)
                tusiyehhaye_Darmani =getString(R.string.darman_ghalabeh_balgham)
                khususiyat_Akhlaghi =getString(R.string.khususiyyat_akhtalaghi_balgham)
            }
        }
        when(tapPosition)
        {
            0 ->
            {
                actv_natayej_mezaj.text = tusiyehhaye_Darmani
            }
            1 ->
            {
                actv_natayej_mezaj.text = khususiyat_Akhlaghi
            }
            2 ->
            {
                actv_natayej_mezaj.text = avarez_Ghalabeh
            }
            3 ->
            {
                actv_natayej_mezaj.text = avamel_Ghalabeh
            }
        }
    }
}