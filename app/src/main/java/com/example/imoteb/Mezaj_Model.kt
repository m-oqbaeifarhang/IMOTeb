package com.example.imoteb

class Mezaj_Model(mezaj_title: String , mezaj_description: String , image : Int)
{
    var mezaj_title : String = ""
    var mezaj_description : String = ""
    var image : Int = 0

    init
    {
        this.mezaj_title = mezaj_title
        this.mezaj_description = mezaj_description
        this.image = image
    }
}