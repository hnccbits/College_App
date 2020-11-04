package com.anjali.myapplication.models

import android.view.ViewGroup
import bitsindri.hncc.collegeapp.Drawer.DrawerAdapter

abstract class DrawerItems<T: DrawerAdapter>(val isChecked:Boolean){

    abstract fun createViewHolder(parent:ViewGroup):T

    abstract fun bindViewHolder(holder:T)



    @JvmName("isChecked1")
    fun isChecked() :Boolean{
        return isChecked()
    }

    fun isSelected():Boolean{
        return true
    }



}