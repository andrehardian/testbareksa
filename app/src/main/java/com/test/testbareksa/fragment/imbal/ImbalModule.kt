package com.test.testbareksa.fragment.imbal

import android.content.Context
import com.test.testbareksa.utils.UtilsDummy
import dagger.Module
import dagger.Provides

@Module
class ImbalModule {
    @Provides
    fun util():UtilsDummy{
        return UtilsDummy()
    }
}