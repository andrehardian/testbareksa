package com.test.testbareksa.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.test.testbareksa.R
import com.test.testbareksa.model.*

class UtilsDummy {
    val listColor = ArrayList<Drawable>()

    fun prepareDummydata(context: Context): ArrayList<*> {
        setListColor(context)
        val listDataDummy = ArrayList<Any>()
        listDataDummy.add(dummyCompany(context))
        listDataDummy.add(
            makeParentDetail(
                "Jenis Reksa Dana",
                arrayOf("Saham", "Pasar Uang", "Saham")
            )
        )
        listDataDummy.add(
            makeParentDetail(
                "Imbal Hasil",
                arrayOf("5,50% / 5 thn", "6,29% / thn", "7,17% / 5 thn")
            )
        )

        listDataDummy.add(
            makeParentDetail(
                "Dana kelolaan",
                arrayOf("3,64 Miliar", "215,97 Miliar", "3,89 Triliun")
            )
        )

        listDataDummy.add(
            makeParentDetail(
                "Min. pembelian",
                arrayOf("1 Juta", "100 Ribu", "100 Ribu")
            )
        )

        listDataDummy.add(
            makeParentDetail(
                "Jangka waktu",
                arrayOf("5 Tahun", "1 Tahun", "5 Tahun")
            )
        )

        listDataDummy.add(
            makeParentDetail(
                "Tingkat risiko",
                arrayOf("Tinggi", "Rendah", "Tinggi")
            )
        )

        listDataDummy.add(
            makeParentDetail(
                "Peluncuran",
                arrayOf("16 Apr 2014", "14 Jan 2016", "20 Feb 2007")
            )
        )

        listDataDummy.add(makeButtonDetail())
        listDataDummy.add(makeButtonBuy())
        return listDataDummy
    }

    private fun makeButtonDetail(): ModelParentButtonDetail {
        return ModelParentButtonDetail(
            arrayListOf(
                ModelButtonDetail(),
                ModelButtonDetail(), ModelButtonDetail
                    ()
            )
        )
    }

    private fun makeButtonBuy(): ModelParentButtonBuy {
        return ModelParentButtonBuy(
            arrayListOf(
                ModelButtonBuy(),
                ModelButtonBuy(), ModelButtonBuy()
            )
        )
    }

    private fun setListColor(context: Context) {
        listColor.add(ContextCompat.getDrawable(context, R.drawable.background_green2)!!)
        listColor.add(ContextCompat.getDrawable(context, R.drawable.background_magenta)!!)
        listColor.add(ContextCompat.getDrawable(context, R.drawable.background_green)!!)
    }

    private fun makeParentDetail(title: String, dataDetails: Array<String>): ModelParentDetail {
        val modelParentDetail = ModelParentDetail()
        modelParentDetail.title = title
        val details = ArrayList<ModelDetailItem>()
        for (pos in 0..2) {
            details.add(ModelDetailItem(dataDetails.get(pos), listColor.get(pos)))
        }
        modelParentDetail.data = details
        return modelParentDetail
    }

    fun dummyCompany(context: Context): ModelParentCompany {
        val listCompany = ArrayList<ModelCompany>()
        listCompany.add(
            makeCompany(
                "BNI-AM Inspiring Equity Fund",
                ContextCompat.getDrawable(context, R.drawable.ic_bni),
                listColor.get(0)
            )
        )
        listCompany.add(
            makeCompany(
                "Cipta Dana Cash",
                ContextCompat.getDrawable(context, R.drawable.ic_ciptadana),
                listColor.get(1)
            )
        )
        listCompany.add(
            makeCompany(
                "Ascend Reksa Dana Saham Eq...",
                ContextCompat.getDrawable(context, R.drawable.ic_ascend),
                listColor.get(2)
            )
        )
        return ModelParentCompany(listCompany)
    }

    private fun makeCompany(
        name: String,
        color: Drawable?,
        bg: Drawable
    ): ModelCompany {
        return ModelCompany(color, bg, name)
    }
}