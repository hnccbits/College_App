package com.anjali.myapplication.models

class DynamicRVModelClass(val name:String) {

    @JvmName("getName1")
    fun getName():String{
        return name
    }
}