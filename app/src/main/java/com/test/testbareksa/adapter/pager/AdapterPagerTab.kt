package com.test.testbareksa.adapter.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.test.testbareksa.model.ModelTab

class AdapterPagerTab(
    fm: FragmentManager,
    val listData: ArrayList<ModelTab>
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return listData.get(position).fragment as Fragment;
    }

    override fun getCount(): Int {
       return listData.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listData.get(position).title
    }
}