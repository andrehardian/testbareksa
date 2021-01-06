package com.test.testbareksa.activity.main

import com.test.testbareksa.activity.main.MainActivity
import com.test.testbareksa.fragment.imbal.ImbalFragment
import com.test.testbareksa.fragment.imbal.ImbalVM
import dagger.Component

@Component
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}