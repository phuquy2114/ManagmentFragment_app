package com.uits.fragment.ui.home.detail1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.uits.fragment.R

class Home1Fragment : Fragment() {

    private lateinit var homeViewModel: Home1ViewModel

    fun newInstance(someInt: Int): Home1Fragment? {
        val myFragment = Home1Fragment()
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
                ViewModelProviders.of(this).get(Home1ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}