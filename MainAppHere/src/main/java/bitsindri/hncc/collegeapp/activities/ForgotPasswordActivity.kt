package bitsindri.hncc.collegeapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import bitsindri.hncc.collegeapp.R
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var resetLink: Button
    lateinit var Auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        email = findViewById(R.id.email)
        resetLink = findViewById(R.id.resetLink)
        Auth = FirebaseAuth.getInstance()

        resetLink.setOnClickListener{
            val Email = email.text.toString()
            if(!Email.equals("")){
                Auth.sendPasswordResetEmail(Email).addOnSuccessListener(this){
                    Toast.makeText(
                            this@ForgotPasswordActivity,
                            "Reset Link Sent To Your Email",
                            Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(
                            this@ForgotPasswordActivity,
                            LoginActivity::class.java
                    )

                    startActivity(intent)
                    finish()

                }.addOnFailureListener(this){
                    Toast.makeText(
                            this@ForgotPasswordActivity,
                            "Error! Reset Link Is Not Sent",
                            Toast.LENGTH_SHORT
                    ).show()
//                    val intent = Intent(
//                            this@ForgotPasswordActivity,
//                            LoginActivity::class.java
//                    )
//
//                    startActivity(intent)
//                    finish()
                }

            }else{
                Toast.makeText(
                        this@ForgotPasswordActivity,
                        "Email is required",
                        Toast.LENGTH_SHORT
                ).show()

            }

        }
    }
}