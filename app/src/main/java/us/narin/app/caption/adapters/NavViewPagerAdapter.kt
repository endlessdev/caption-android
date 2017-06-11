package us.narin.app.caption.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class NavViewPagerAdapter(
        fm: FragmentManager,
        val fragmentBuilders: List<Fragment>) :
        FragmentPagerAdapter(fm) {


    override fun getItem(position: Int) =
            fragmentBuilders[position]


    override fun getCount(): Int =
            fragmentBuilders.size

}