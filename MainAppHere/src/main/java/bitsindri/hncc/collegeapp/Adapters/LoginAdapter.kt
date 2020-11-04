package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.anjali.myapplication.fragments.LoginTabFrament
import com.anjali.myapplication.fragments.SignupTabFrament

class LoginAdapter(val fm:FragmentManager, var context: Context, val totalTabs:Int):FragmentPagerAdapter(fm) {

    lateinit var tab: Fragment

    override fun getCount(): Int {
      return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        when{
            position==0->{
                val tab = LoginTabFrament()
                return tab
            }
            position==1->{
                val tab = SignupTabFrament()
                return tab
            }
        }
        return tab
    }
}