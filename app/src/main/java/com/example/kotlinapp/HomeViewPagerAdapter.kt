package com.example.kotlinapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup

/**
 * Created by Pear on 4/2/2019.
 */
class HomeViewPagerAdapter(fragmentManager: FragmentManager?, private var tabCount: Int) : FragmentStatePagerAdapter(fragmentManager) {
    private val title = arrayOf("Friday", "Saturday", "Sunday")
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(p0: Int): Fragment? {
        return when(p0){
            0 -> HomeTabOne()
            1 -> HomeTabTwo()
            2 -> HomeTabThree()
            else -> null
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }
}