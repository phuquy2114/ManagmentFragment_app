package com.uits.fragment.ui.home.base

import android.app.Activity
import android.content.Context
import android.view.View
import com.uits.baseproject.base.BaseContainerFragment
import com.uits.baseproject.base.OnCurrentFragmentListener
import com.uits.fragment.R
import com.uits.fragment.ui.home.HomeFragment

/**
 * BaseHomeFragment
 *
 * Copyright © 2020 UITS CO.,LTD
 * Created PHUQUY on 10/10/20.
 **/
class BaseHomeFragment : BaseContainerFragment() {

    private lateinit var mListener : OnCurrentFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            val activity = context as Activity
            mListener = activity as OnCurrentFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnChangeHeaderListener")
        }
    }

    override fun getLayoutId(): Int {
      return R.layout.fragment_base_home
    }

    override fun onViewCreated(view: View) {
        replaceFragment(HomeFragment().newInstance(1)!!, false)
    }

    override fun onResume() {
        super.onResume()
        mListener.onCurrentFragment(this)
    }
}