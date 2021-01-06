package com.test.testbareksa.fragment.imbal

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.test.testbareksa.adapter.recycler.AdapterRecycler
import com.test.testbareksa.model.ModelCompany

class ParentCompanyVM(data: ArrayList<ModelCompany>, recycler: RecyclerView) : ViewModel() {
    init {
        recycler.adapter = AdapterRecycler(listData = data)
    }
}