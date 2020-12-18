package bitsindri.hncc.collegeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import bitsindri.hncc.collegeapp.activities.LoginActivity
import bitsindri.hncc.collegeapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OnBoardingFragment3:Fragment() {

    lateinit var floatingActionButton: FloatingActionButton
    lateinit var skip:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_on_boarding3,container,false)
        floatingActionButton = view.findViewById(R.id.fab)

        floatingActionButton.setOnClickListener{
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }

        skip = view.findViewById(R.id.skip)
        skip.setOnClickListener{
            startActivity(Intent(activity,LoginActivity::class.java))
            activity?.finish()
        }
        return  view

    }
}