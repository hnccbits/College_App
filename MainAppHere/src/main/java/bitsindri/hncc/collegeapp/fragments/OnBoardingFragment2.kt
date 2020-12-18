package bitsindri.hncc.collegeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.LoginActivity

class OnBoardingFragment2:Fragment() {

    lateinit var skip:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_on_boarding2,container,false)

        skip = view.findViewById(R.id.skip)
        skip.setOnClickListener{
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }
        return  view

    }
}