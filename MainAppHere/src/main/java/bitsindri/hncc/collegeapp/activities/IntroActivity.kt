package bitsindri.hncc.collegeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import bitsindri.hncc.collegeapp.R
import com.airbnb.lottie.LottieAnimationView

class IntroActivity : AppCompatActivity() {

    lateinit var logo: ImageView
    lateinit var app_name: ImageView
    lateinit var bg: ImageView
    lateinit var lottie: LottieAnimationView

    lateinit var viewPager: ViewPager

    lateinit var anim: Animation
    lateinit var pagerAdapter: IntroductionActivity.ScreenSlidePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
//        logo = findViewById(R.id.logo)
//        app_name= findViewById(R.id.app_name)
//        bg = findViewById(R.id.bg)
//        lottie = findViewById(R.id.lottie)
//
//        viewPager = findViewById(R.id.pager)
//        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
//        viewPager.adapter = pagerAdapter
//
//        anim = AnimationUtils.loadAnimation(this, R.anim.o_b_anim)
//        viewPager.startAnimation(anim)
//
//        bg.animate().translationY(-1600F).setDuration(1000).setStartDelay(8000)
//        logo.animate().translationY(1400F).setDuration(1000).setStartDelay(8000)
//        app_name.animate().translationY(1400F).setDuration(1000).setStartDelay(8000)
//        lottie.animate().translationY(1400F).setDuration(1000).setStartDelay(8000)
//    }
//
//    class ScreenSlidePagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
//        lateinit var tab: Fragment
//
//        override fun getCount(): Int {
//            return 3
//        }
//
//        override fun getItem(position: Int): Fragment {
//            when{
//                position==0->{
//                    val tab = OnBoardingFragment1()
//                    return tab
//                }
//                position==1->{
//                    val tab = OnBoardingFragment2()
//                    return tab
//                }
//                position==2->{
//                    val tab = OnBoardingFragment3()
//                    return tab
//                }
//            }
//            return tab
//        }
    }
}