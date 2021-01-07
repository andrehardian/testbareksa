package com.test.testbareksa.activity.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.test.testbareksa.R
import com.test.testbareksa.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainVM: MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        DaggerMainComponent.create().inject(this)
        val vm = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        vm.mainVM = mainVM
        mainVM.initTab(vm.tab, vm.pager, supportFragmentManager)
        setSupportActionBar(vm.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}