package com.anjali.myapplication.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.CameraDialog
import bitsindri.hncc.collegeapp.activities.IntroQuestion
import bitsindri.hncc.collegeapp.activities.CameraDialog.DialogListener
import bitsindri.hncc.collegeapp.activities.IntroductionActivity
import com.google.android.gms.common.wrappers.Wrappers.packageManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import java.util.*
import kotlin.math.sign

class SignupTabFrament:Fragment() {

    lateinit var email:EditText
    lateinit var phone:EditText
    lateinit var pass:EditText
    lateinit var conf_pass:EditText
    lateinit var signup:Button
    lateinit var progressBar: ProgressBar
    lateinit var upload:ImageView
    lateinit var username:EditText

    lateinit var Auth:FirebaseAuth
    lateinit var userId: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.signup_tab_fragment, container, false)

        email = view.findViewById(R.id.email)
        phone = view.findViewById(R.id.phone)
        pass = view.findViewById(R.id.pass)
        conf_pass = view.findViewById(R.id.conf_pass)
        signup = view.findViewById(R.id.signup)
        progressBar = view.findViewById(R.id.progressBar)
        upload = view.findViewById(R.id.upload)
        username = view.findViewById(R.id.name)

        Auth = FirebaseAuth.getInstance()

        if (Auth.currentUser != null) {//user has an account by checking if the current user object is present
            val intent = Intent(activity as Context, IntroQuestion::class.java)
            startActivity(intent)
            activity?.finish()
        }


        upload.setOnClickListener {

            Log.d(
                    "RegisterActivity",
                    "try to show photo selector"
            )//use of implicit intent to launch gallery
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                    Intent.createChooser(intent, "Select Picture"),
                    0
            )// the constant requestcode is used in our next phase to verify what intent our result is coming from

        }



        signup.setOnClickListener {

            val Email = email.text.toString()
            val Password = pass.text.toString()
            val Confirm_Password = conf_pass.text.toString()
            val Phone = phone.text.toString()
            val Name = username.text.toString()

            if (!Email.equals("") && !Password.equals("") && !Confirm_Password.equals("") && !Phone.equals("") && !Name.equals("") && selectedPhotoUri != null) {
                if (Password.length < 6) {

                    Toast.makeText(
                            activity as Context,
                            "Password Must Be Of >= 6 Characters",
                            Toast.LENGTH_SHORT
                    ).show()
                } else {

                    if (Password == Confirm_Password){

                        progressBar.visibility = View.VISIBLE
                        signup.setVisibility(View.INVISIBLE)

                        //to register the user in firebase

                        Auth.createUserWithEmailAndPassword(Email, Password)
                                .addOnCompleteListener {//addOnCompleteListener mthod is used to verify whether the task is done successfully or not
                                    task ->
                                    progressBar.visibility = View.GONE

                                    if (task.isSuccessful) {


                                        Toast.makeText(
                                                activity as Context,
                                                "User Created",
                                                Toast.LENGTH_SHORT
                                        ).show()

                                    uploadImageToFirebase()

                                        verifyEmail()

                                    } else {
                                        Toast.makeText(
                                                activity as Context,
                                                "Error! = " + (task.exception),
                                                Toast.LENGTH_SHORT
                                        ).show()
                                        progressBar.visibility = View.GONE
                                    }

                                }
                    }
                    else{
                        progressBar.visibility = View.INVISIBLE
                        signup.setVisibility(View.VISIBLE)

                        Toast.makeText(
                                activity as Context,
                                "Password must match",
                                Toast.LENGTH_SHORT
                        ).show()
                    }


                }

            } else {

                progressBar.visibility = View.INVISIBLE
                signup.setVisibility(View.VISIBLE)
                Toast.makeText(activity as Context, "Enter All Credentials", Toast.LENGTH_SHORT)
                        .show()
            }

        }

        return  view

    }
    private fun verifyEmail() {
        val mAuth = Auth
        val mUser = mAuth.currentUser
        mUser!!.sendEmailVerification().addOnCompleteListener{ task ->
            if (task.isSuccessful) {
                Toast.makeText(
                        activity as Context,
                        "Verification email is sent to" + mUser.email,
                        Toast.LENGTH_SHORT
                ).show()

                reassignCredential()

            } else {
                Toast.makeText(
                        activity,
                        "Fail to send verification email ",
                        Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun reassignCredential() {
        username.setText("")
        email.setText("")
        pass.setText("")
        conf_pass.setText("")
        phone.setText("")
        signup.setVisibility(View.VISIBLE)
        upload.setImageResource(R.drawable.userphoto)
    }

    var selectedPhotoUri: Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            Log.d("RegisterActivity", "photo was selected")

            selectedPhotoUri = data.data
            upload.setImageURI(selectedPhotoUri)
        }
    }

    private fun uploadImageToFirebase() {
        if (selectedPhotoUri == null) return
        val filename = UUID.randomUUID().toString()//uuid  refers a unique id
        val ref = FirebaseStorage.getInstance().getReference("/images/$filename")
        ref.putFile(selectedPhotoUri!!).addOnSuccessListener { it ->
            Log.d("SignUp", "image uploaded successfully: ${it.metadata?.path}")

            //to access the image url created in the storage section of firebase

            ref.downloadUrl.addOnSuccessListener() {
                it.toString()   //it refers to the url
                Log.d("SignUp", "File Location: $it")


            }
        }

    }

}
