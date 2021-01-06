package com.test.testbareksa.fragment.imbal

import android.content.Context
import com.test.testbareksa.activity.main.MainActivity
import com.test.testbareksa.fragment.imbal.ImbalFragment
import com.test.testbareksa.fragment.imbal.ImbalVM
import dagger.Component

@Component(modules = [ImbalModule::class])
interface ImbalComponent {
    fun inject(fragment: ImbalFragment)
}