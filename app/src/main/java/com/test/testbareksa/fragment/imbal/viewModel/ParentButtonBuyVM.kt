package com.test.testbareksa.fragment.imbal.viewModel

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.test.testbareksa.adapter.recycler.AdapterRecycler
import com.test.testbareksa.model.ModelButtonBuy
import com.test.testbareksa.model.ModelParentButtonBuy

class ParentButtonBuyVM(data: ModelParentButtonBuy, recycler: RecyclerView) : ViewModel() {
    init {
        recycler.adapter = AdapterRecycler(data.listButton)
    }
}