package com.anjali.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anjali.myapplication.R
import com.anjali.myapplication.activity.LoginActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OnBoardingFragment3:Fragment() {

    lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_on_boarding3,container,false)
        floatingActionButton = view.findViewById(R.id.fab)

        floatingActionButton.setOnClickListener{
            startActivity(Intent(activity, LoginActivity::class.java))
        }
        return  view

    }
}