package com.test.testbareksa.fragment.imbal

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.test.testbareksa.model.ModelDetailItem

class DetailVM(data: ModelDetailItem) : ViewModel() {
    val name = ObservableField<String>()
    val color = ObservableField<Drawable>()

    init {
        name.set(data.name)
        color.set(data.background)
    }
}