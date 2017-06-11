package us.narin.app.caption.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import us.narin.app.caption.R
import us.narin.app.caption.adapters.NavViewPagerAdapter
import us.narin.app.caption.databinding.ActivityNavBinding
import us.narin.app.caption.fragments.CaptionsFragment
import us.narin.app.caption.fragments.InboxFragment
import us.narin.app.caption.fragments.SettingsFragment

class NavActivity : AppCompatActivity() {

    private var binding: ActivityNavBinding? = null
    private var fragmentManager: FragmentManager? = null
    private var prevMenuItem : MenuItem? = null

    private val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->

        var itemPosition: Int = 0

        when (item.itemId) {
            R.id.navigation_home -> itemPosition = 0
            R.id.navigation_dashboard -> itemPosition = 1
            R.id.navigation_notifications -> itemPosition = 2
        }

        binding!!.navViewPager.currentItem = itemPosition
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentManager = supportFragmentManager
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav)

        val viewPagerAdapter: NavViewPagerAdapter =
                NavViewPagerAdapter(fragmentManager!!, listOf(
                        CaptionsFragment.newInstance("", ""),
                        InboxFragment.newInstance("", ""),
                        SettingsFragment.newInstance()
                ))

        binding!!.navViewPager.adapter = viewPagerAdapter
        binding!!.navViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if(prevMenuItem != null)
                    prevMenuItem!!.isChecked = false
                else
                    binding!!.navigation.menu.getItem(0).isChecked = false

                binding!!.navigation.menu.getItem(position).isChecked = true
                prevMenuItem = binding!!.navigation.menu.getItem(position)
            }


        })
        binding!!.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }
}
