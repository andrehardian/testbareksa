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
        listTab.add(makeTab("Imbal Hasil",
            ImbalFragment()
        ))
        listTab.add(makeTab("Dana Kelolaan", Fragment()))
        pager.adapter=AdapterPagerTab(supportFragmentManager,listTab)
        tab.setupWithViewPager(pager)
    }

    private fun makeTab(title: String, fragment: Fragment): ModelTab {
        val modelTab = ModelTab()
        modelTab.title = title
        modelTab.fragment = fragment
        return modelTab
    }

}