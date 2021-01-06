package com.test.testbareksa.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.test.testbareksa.R
import com.test.testbareksa.model.ModelCompany

class UtilsDummy {
    fun prepareDummydata(context: Context): ArrayList<ArrayList<*>> {
        var listDataDummy = ArrayList<ArrayList<*>>()
        listDataDummy.add(listDummyCompany(context))
        return listDataDummy
    }

    fun listDummyCompany(context: Context): ArrayList<ModelCompany> {
        var listCompany = ArrayList<ModelCompany>()
        listCompany.add(
            makeCompany(
                "BNI-AM Inspiring Equity Fund",
                ContextCompat.getDrawable(context, R.drawable.circle_orange)
            )
        )
        listCompany.add(
            makeCompany(
                "Cipta Dana Cash",
                ContextCompat.getDrawable(context, R.drawable.circle_red)
            )
        )
        listCompany.add(
            makeCompany(
                "Ascend Reksa Dana Saham Eq...",
                ContextCompat.getDrawable(context, R.drawable.circle_blue)
            )
        )
        return listCompany
    }

    private fun makeCompany(name: String, color: Drawable?): ModelCompany {
        val modelCompany = ModelCompany()
        modelCompany.name = name
        modelCompany.color = color
        return modelCompany
    }
}