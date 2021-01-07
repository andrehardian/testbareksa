package com.test.testbareksa.activity.main

import dagger.Component

@Component
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}