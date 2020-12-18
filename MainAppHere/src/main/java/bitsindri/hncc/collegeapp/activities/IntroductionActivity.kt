package bitsindri.hncc.collegeapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils.loadAnimation
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.fragments.OnBoardingFragment1
import bitsindri.hncc.collegeapp.fragments.OnBoardingFragment2
import bitsindri.hncc.collegeapp.fragments.OnBoardingFragment3
import com.airbnb.lottie.LottieAnimationView
import com.google.firebase.auth.FirebaseAuth


class IntroductionActivity : AppCompatActivity() {

    lateinit var logo:ImageView
    lateinit var app_name:TextView
    lateinit var bg:ImageView
    lateinit var lottie:LottieAnimationView

    lateinit var viewPager: ViewPager
    lateinit var pagerAdapter: ScreenSlidePagerAdapter
    lateinit var Auth:FirebaseAuth

    lateinit var anim:Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        Auth = FirebaseAuth.getInstance()
        val mUser = Auth.currentUser

        if (mUser != null) {
            if (Auth.currentUser != null && mUser.isEmailVerified) {//user has an account by checking if the current user object is present
                val intent = Intent(this, IntroQuestion::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "No user found with this credentials", Toast.LENGTH_SHORT)
                        .show()
            }
        }

        logo = findViewById(R.id.logo)
        app_name= findViewById(R.id.app_name)
        bg = findViewById(R.id.bg)
        lottie = findViewById(R.id.lottie)

        viewPager = findViewById(R.id.pager)
        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

        anim = loadAnimation(this, R.anim.o_b_anim)
        viewPager.startAnimation(anim)

        bg.animate().translationY(-2200F).setDuration(1000).setStartDelay(8000)
        logo.animate().translationY(2200F).setDuration(1000).setStartDelay(8000)
        app_name.animate().translationY(2000F).setDuration(1000).setStartDelay(8000)
        lottie.animate().translationY(2000F).setDuration(1000).setStartDelay(8000)
    }

    class ScreenSlidePagerAdapter(fm:FragmentManager):FragmentStatePagerAdapter(fm) {
        lateinit var tab: Fragment

        override fun getCount(): Int {
        return 3
        }

        override fun getItem(position: Int): Fragment {
            when{
                position==0->{
                    val tab = OnBoardingFragment1()
                    return tab
                }
                position==1->{
                    val tab = OnBoardingFragment2()
                    return tab
                }
                position==2->{
                    val tab = OnBoardingFragment3()
                    return tab
                }
            }
            return tab
        }

    }

    override fun onResume() {
        super.onResume()
    }
}