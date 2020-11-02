package com.anjali.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.anjali.myapplication.activity.DashboardActivity
import com.anjali.myapplication.R

class LoginTabFrament:Fragment() {

    lateinit var email:EditText
    lateinit var pass:EditText
    lateinit var btnLogin:Button
    lateinit var txtForgotPassword:TextView

    var v:Float = 0F

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.login_tab_fragment,container,false)

        email = view.findViewById(R.id.email)
        pass = view.findViewById(R.id.pass)
        btnLogin =  view.findViewById(R.id.btnLogin)
        txtForgotPassword=view.findViewById(R.id.txtForgotPassword)

        email.translationX=800F
        pass.translationX=800F
        btnLogin.translationX=800F
        txtForgotPassword.translationX=800F

        email.alpha=v
        pass.alpha=v
        btnLogin.alpha=v
        txtForgotPassword.alpha=v

        email.animate().translationX(0F).alpha(1F).setDuration(800).setStartDelay(300).start()
        pass.animate().translationX(0F).alpha(1F).setDuration(800).setStartDelay(500).start()
        btnLogin.animate().translationX(0F).alpha(1F).setDuration(800).setStartDelay(500).start()
        txtForgotPassword.animate().translationX(0F).alpha(1F).setDuration(800).setStartDelay(700).start()


        btnLogin.setOnClickListener {
            val intent = Intent(activity, DashboardActivity::class.java)
            startActivity(intent)

        }



        return  view

    }
}