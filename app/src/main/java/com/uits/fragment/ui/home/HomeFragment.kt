package com.uits.fragment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.uits.baseproject.base.BaseContainerFragment
import com.uits.fragment.R
import com.uits.fragment.ui.home.detail1.Home1Fragment

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    fun newInstance(someInt: Int): HomeFragment? {
        val myFragment = HomeFragment()
        val args = Bundle()
        args.putInt("someInt", someInt)
        myFragment.arguments = args
        return myFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val textView: TextView = root.findViewById(R.id.text_home)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        textView.setOnClickListener {
            if (parentFragment is BaseContainerFragment) {
                (parentFragment as BaseContainerFragment?)?.replaceFragment(Home1Fragment().newInstance(2)!!, true)
            }
        }
        return root
    }
}