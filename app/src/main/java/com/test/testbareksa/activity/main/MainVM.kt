package com.test.testbareksa.activity.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.test.testbareksa.adapter.pager.AdapterPagerTab
import com.test.testbareksa.fragment.imbal.ImbalFragment
import com.test.testbareksa.model.ModelTab
import javax.inject.Inject

class MainVM @Inject constructor() : ViewModel() {
    fun initTab(
        tab: TabLayout,
        pager: ViewPager,
        supportFragmentManager: FragmentManager
    ) {
        val listTab = ArrayList<ModelTab>()
        listTab.add(ModelTab("Imbal Hasil", ImbalFragment()))
        listTab.add(ModelTab("Dana Kelolaan", Fragment()))
        pager.adapter = AdapterPagerTab(supportFragmentManager, listTab)
        tab.setupWithViewPager(pager)
    }

}