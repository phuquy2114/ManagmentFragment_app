package com.uits.fragment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.uits.baseproject.base.BaseContainerFragment
import com.uits.baseproject.base.BaseFragment
import com.uits.baseproject.base.OnCurrentFragmentListener
import com.uits.fragment.ui.home.HomeFragment

class MainActivity : AppCompatActivity(), OnCurrentFragmentListener {

    private lateinit var mToastExit: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        mToastExit = Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    /**
     * check current fragment id
     *
     * @return
     */
    fun getCurrentFragment(): BaseFragment? {
        return supportFragmentManager.findFragmentById(R.id.mFrameContainer) as BaseFragment?
    }

    override fun onBackFragment() {
        val fragment: BaseContainerFragment = getCurrentFragment() as BaseContainerFragment
        if (!fragment.popFragment()) {
            val isExit: Boolean = mToastExit.getView().isShown()
            if (!isExit) {
                mToastExit.show()
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onCurrentFragment(fragment: Fragment) {
        if (fragment is HomeFragment) {

        }
    }
}