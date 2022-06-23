package com.tabletop.companionapp.data

import com.tabletop.companionapp.R

object GlobalData {
    val characters = arrayListOf("Dendi", "Ciko", "Siput", "Jopi", "Asep", "Emil")

    val allTasks = arrayListOf(
        Task("Bakso Beranak", 5, 70000, "Green", R.drawable.bakso_beranak),
        Task("Bakso Njamur", 4, 45000, "Green", R.drawable.bakso_njamur),
        Task("Bakso Granat", 5, 65000, "Orange", R.drawable.bakso_granat),
        Task("Bakso Lava", 4, 50000, "Orange", R.drawable.bakso_lava),
        Task("Bakso Aci Tomyum", 5, 60000, "Pink", R.drawable.bakso_aci_tomyum),
        Task("Bakso Aci Cuankie", 4, 45000, "Pink", R.drawable.bakso_aci_cuanki),
        Task("Bakso Sumsum", 5, 65000, "Red", R.drawable.bakso_sumsum),
        Task("Bakso Kikil", 4, 55000, "Red", R.drawable.bakso_kikil),
        Task("Bakso Ayam Cincang", 5, 70000, "Yellow", R.drawable.bakso_ayam_cincang),
        Task("Bakso Ceker", 4, 55000, "Yellow", R.drawable.bakso_ceker),
        Task("Bakso Udang", 5, 65000, "Tosca", R.drawable.bakso_udang),
        Task("Bakso Ikan", 4, 50000, "Tosca", R.drawable.bakso_ikan),
        Task("Bakso Jumbo Spesial", 3, 45000, "Red", R.drawable.bakso_jumbo_spesial),
        Task("Bakso Campur", 3, 45000, "Tosca", R.drawable.bakso_campur),
        Task("Bakso Keju", 3, 40000, "Green", R.drawable.bakso_keju),
        Task("Bakso Biasa", 2, 35000, "Green", R.drawable.bakso_biasa),
        Task("Bakso Telur", 2, 35000, "Yellow", R.drawable.bakso_telur),
        Task("Bakso Mie", 2, 35000, "Pink", R.drawable.bakso_mie),
        Task("Bakso Kembang Api", 1, 30000, "Yellow", R.drawable.kembang_api),
        Task("Sate Bakso", 1, 35000, "Red", R.drawable.sate_bakso),
        Task("Bakso Aci Keju", 3, 45000, "Pink", R.drawable.bakso_aci_keju),
        Task("Siomay Udang", 3, 40000, "Tosca", R.drawable.siomay_udang),
        Task("Bakso Setan", 4, 55000, "Orange", R.drawable.bakso_setan),
        Task("Bakso Iblis", 5, 60000, "Orange", R.drawable.bakso_iblis)
    )

    val players = mutableListOf<Player>()
    fun showImage(char: String):Int{
        var img = 0
        when(char){
            "Dendi" -> img = R.drawable.bakso_campur
            "Ciko" -> img = R.drawable.bakso_mie
            "Siput" -> img = R.drawable.bakso_iblis
            "Jopi" -> img = R.drawable.bakso_telur
            "Asep" -> img = R.drawable.bakso_biasa
            "Emil" -> img = R.drawable.bakso_ikan
        }
        return img
    }
}