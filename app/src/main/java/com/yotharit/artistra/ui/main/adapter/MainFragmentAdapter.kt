package com.yotharit.artistra.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yotharit.artistra.ui.main.calendar.CalendarFragment
import com.yotharit.artistra.ui.main.feed.FeedFragment
import com.yotharit.artistra.ui.main.search.SearchFragment
import com.yotharit.artistra.ui.main.user.UserFragment

class MainFragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        lateinit var fragment : Fragment
        when(position) {
            0 -> fragment = FeedFragment()
            1 -> return SearchFragment()
            2 -> return CalendarFragment()
            3 -> return UserFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return 4
    }
}