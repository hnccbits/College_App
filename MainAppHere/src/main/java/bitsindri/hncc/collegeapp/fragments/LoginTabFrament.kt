package com.anjali.myapplication.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.IInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import bitsindri.hncc.collegeapp.activities.IntroQuestion
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.ForgotPasswordActivity
import bitsindri.hncc.collegeapp.activities.IntroductionActivity
import bitsindri.hncc.collegeapp.activities.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginTabFrament:Fragment() {

    lateinit var email:EditText
    lateinit var pass:EditText
    lateinit var btnLogin:Button
    lateinit var txtForgotPassword:TextView
    lateinit var txtcasualLogin:TextView

    lateinit var Auth: FirebaseAuth
    lateinit var userId: String
    lateinit var progressBar: ProgressBar

    var v:Float = 0F

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.login_tab_fragment,container,false)



        Auth = FirebaseAuth.getInstance()
        userId = Auth.currentUser?.uid.toString()

        val mUser = Auth.currentUser

        if (mUser != null) {
            if (Auth.currentUser != null) {
                if(mUser.isEmailVerified){

                    val intent = Intent(activity as Context, IntroQuestion::class.java)
                    startActivity(intent)
                    activity?.finish()
                }
            }
            else{
                Toast.makeText(activity as Context, "No user found with this credentials", Toast.LENGTH_SHORT)
                        .show()
            }
        }

        progressBar=view.findViewById(R.id.progressBar)
        email = view.findViewById(R.id.email)
        pass = view.findViewById(R.id.pass)
        btnLogin =  view.findViewById(R.id.btnLogin)
        txtForgotPassword=view.findViewById(R.id.txtForgotPassword)
        txtcasualLogin = view.findViewById(R.id.txtcasualLogin)

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


        btnLogin.setOnClickListener{
            val Email:String = email.text.toString()
            val Password:String = pass.text.toString()

            if(!Email.equals("") && !Password.equals("")){

//          if(Password2.length<6){
//              Toast.makeText(this@LoginActivity,"Invalid Password",Toast.LENGTH_SHORT).show()
//          }else {
                progressBar.visibility = View.VISIBLE
                btnLogin.visibility = View.GONE

                //authentication of user

                Auth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener {//addOnCompleteListener mthod is used to verify whether the task is done successfully or not
                            task ->
                            progressBar.visibility = View.GONE
                            btnLogin.visibility = View.VISIBLE

                            if (task.isSuccessful) {
                                Toast.makeText(
                                        activity,
                                        "Logged In Successfully",
                                        Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(activity, IntroQuestion::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                          intent.putExtra("URL",downloadedUrl)
                                startActivity(intent)
                            } else {
                                Toast.makeText(
                                        activity,
                                        "Error! = " + (task.exception),
                                        Toast.LENGTH_SHORT
                                ).show()
                                progressBar.visibility = View.GONE
                                btnLogin.visibility = View.VISIBLE
                            }

//                  }
                        }
            }else{

                Toast.makeText(activity,"Enter all Details",Toast.LENGTH_SHORT).show()

            }


        }
        txtForgotPassword.setOnClickListener{
            startActivity(Intent(activity,ForgotPasswordActivity::class.java))
            activity?.finish()
        }

        txtcasualLogin.setOnClickListener{
                    startActivity(Intent(activity,MainActivity::class.java))
                    activity?.finish()
        }

        return  view

    }

    override fun onResume() {
        email.setText("")
        pass.setText("")
        super.onResume()
    }
}