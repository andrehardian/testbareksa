package com.test.testbareksa.fragment.imbal

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.test.testbareksa.model.ModelCompany

class CompanyVM(data: ModelCompany) : ViewModel() {
    val alias = ObservableField<String>()
    val name = ObservableField<String>()
    val color = ObservableField<Drawable>()
    val background = ObservableField<Drawable>()

    init {
        alias.set(data.name!!.toCharArray()[0].toString().toUpperCase())
        name.set(data.name)
        color.set(data.color)
        background.set(data.background)
    }
}