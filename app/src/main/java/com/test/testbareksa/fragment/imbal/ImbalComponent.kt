package com.test.testbareksa.fragment.imbal

import dagger.Component

@Component(modules = [ImbalModule::class])
interface ImbalComponent {
    fun inject(fragment: ImbalFragment)
}