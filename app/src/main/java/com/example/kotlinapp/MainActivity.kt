package com.example.kotlinapp

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private val onNavigationView = NavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.nav_camera -> {
//                val profileFragment = ProfileFragment.newInstance()
//                openFragmentOverNav(profileFragment)
//            }
//            R.id.nav_gallery -> {
//
//            }
//            R.id.nav_slideshow -> {
//
//            }
//            R.id.nav_manage -> {
//
//            }
//            R.id.nav_share -> {
//
//            }
//            R.id.nav_send -> {
//                val settingFragment = SettingFragment.newInstance()
//                openFragmentOverNav(settingFragment)
//            }
//        }
//        drawer_layout.closeDrawer(GravityCompat.START)
//        true
//    }

//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_home -> {
//                mainToolbar.title = "Home"
////                mainToolbar.setTitle(R.string.title_home)
//                val homeFragment = HomeFragment.newInstance()
//                openFragment(homeFragment)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_dashboard -> {
////                mainToolbar.setTitle(R.string.title_dashboard)
//                val dashboardFragment = DashboardFragment.newInstance()
//                openFragment(dashboardFragment)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_notifications -> {
////                mainToolbar.setTitle(R.string.title_notifications)
//                val notificationFragment = NotificationFragment.newInstance()
//                openFragment(notificationFragment)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_explore -> {
////                mainToolbar.setTitle(R.string.title_explore)
//                val exploreFragment = ExploreFragment.newInstance()
//                openFragment(exploreFragment)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_others -> {
////                mainToolbar.setTitle(R.string.title_others)
//                val otherFragment = OtherFragment.newInstance()
//                openFragment(otherFragment)
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }

    private fun setupBottomNavMenu(navController: NavController) {
        navigation.setupWithNavController(navController)
    }

    private fun setupDrawerMenu(navController: NavController) {
        nav_view.setupWithNavController(navController)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(mainToolbar)
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return

        val navController = host.navController

        setupBottomNavMenu(navController)
        setupDrawerMenu(navController)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, mainToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotification()
        }

//        nav_view.setNavigationItemSelectedListener(onNavigationView)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return item.onNavDestinationSelected(findNavController(R.id.my_nav_host_fragment)) || super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotification() {
        // if you wanna create channel group, you have to create channel group first then create channel
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channelId = "test_notification"
        val channelName = "Noti"

        val channel = NotificationChannel(channelId, channelName, importance)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }

    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun openFragmentOverNav(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
