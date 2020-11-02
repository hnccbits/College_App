package com.anjali.myapplication.models

class StaticRecyclerViewModel(val image:Int,val text:String) {

    @JvmName("getImage1")
   fun getImage():Int{
        return image
    }

    @JvmName("getText1")
    fun getText():String{
        return text
    }


}