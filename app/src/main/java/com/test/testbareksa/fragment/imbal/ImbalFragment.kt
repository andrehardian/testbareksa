package com.test.testbareksa.fragment.imbal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.test.testbareksa.R
import com.test.testbareksa.databinding.ImbalFragmentBinding
import javax.inject.Inject

class ImbalFragment : Fragment() {
    @Inject
    lateinit var imbalVM: ImbalVM
    lateinit var dataBinding: ImbalFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.imbal_fragment, container, false)
        return dataBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerImbalComponent.create().inject(this)
        dataBinding.imbalVM = imbalVM
        imbalVM.init(dataBinding, this!!.context!!)
    }
}