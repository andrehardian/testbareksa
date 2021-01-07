package com.test.testbareksa.fragment.imbal.viewModel

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.test.testbareksa.adapter.recycler.AdapterRecycler
import com.test.testbareksa.model.ModelCompany
import com.test.testbareksa.model.ModelParentCompany

class ParentCompanyVM(data: ModelParentCompany, recycler: RecyclerView) : ViewModel() {
    init {
        recycler.adapter = AdapterRecycler(listData = data.listCompany)
    }
}