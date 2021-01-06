package com.test.testbareksa.fragment.imbal

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.test.testbareksa.adapter.recycler.AdapterRecycler
import com.test.testbareksa.model.ModelParentDetail

class ParentDetailVM(data: ModelParentDetail, recycler: RecyclerView) : ViewModel() {
    val title = ObservableField<String>()

    init {
        title.set(data.title)
        recycler.adapter = AdapterRecycler(listData = data!!.data!!)
    }
}