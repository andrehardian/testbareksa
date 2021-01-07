package com.test.testbareksa.fragment.imbal.viewModel

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.test.testbareksa.adapter.recycler.AdapterRecycler
import com.test.testbareksa.model.ModelParentButtonDetail

class ParentButtonDetailVM(
    data: ModelParentButtonDetail,
    recycler: RecyclerView
) : ViewModel() {
    init {
        recycler.adapter = AdapterRecycler(data.listButton)
    }
}