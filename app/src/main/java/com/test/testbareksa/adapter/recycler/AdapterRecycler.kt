package com.test.testbareksa.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.testbareksa.databinding.*
import com.test.testbareksa.fragment.imbal.viewModel.*
import com.test.testbareksa.model.*

class AdapterRecycler(val listData: ArrayList<*>) : RecyclerView.Adapter<Holder>() {
    private val companyParent = 1
    private val companyItem = 2
    private val detailParent = 3
    private val detailItem = 4
    private val buttonDetailParent = 5
    private val buttonDetail = 6
    private val buttonBuyParent = 7
    private val buttonBuy = 8

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        when (viewType) {
            companyParent -> return createHolderCompanyParent(parent)
            companyItem -> return createHolderCompanyItem(parent)
            detailParent -> return createHolderDetailParent(parent)
            detailItem -> return createHolderDetailItem(parent)
            buttonDetailParent -> return createHolderButtonDetailParent(parent)
            buttonDetail -> return createHolderButtonDetailItem(parent)
            buttonBuyParent -> return createHolderButtonBuyParent(parent)
            else -> return createHolderButtonBuyItem(parent)
        }
    }

    private fun createHolderCompanyParent(parent: ViewGroup): Holder {
        return Holder(
            AdapterCompanyParentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createHolderCompanyItem(parent: ViewGroup): Holder {
        return Holder(
            AdapterCompanyItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createHolderDetailParent(parent: ViewGroup): Holder {
        return Holder(
            AdapterDetailParentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createHolderDetailItem(parent: ViewGroup): Holder {
        return Holder(
            AdapterDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createHolderButtonDetailParent(parent: ViewGroup): Holder {
        return Holder(
            AdapterButtonDetailParentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createHolderButtonDetailItem(parent: ViewGroup): Holder {
        return Holder(
            AdapterButtonDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createHolderButtonBuyParent(parent: ViewGroup): Holder {
        return Holder(
            AdapterButtonBuyParentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createHolderButtonBuyItem(parent: ViewGroup): Holder {
        return Holder(
            AdapterButtonBuyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        val data = listData.get(position)
        if (data is ModelParentCompany) {
            return companyParent
        } else if (data is ModelParentDetail) {
            return detailParent
        } else if (data is ModelCompany) {
            return companyItem
        } else if (data is ModelDetailItem) {
            return detailItem
        } else if (data is ModelParentButtonDetail) {
            return buttonDetailParent
        } else if (data is ModelButtonDetail) {
            return buttonDetail
        } else if (data is ModelParentButtonBuy) {
            return buttonBuyParent
        } else {
            return buttonBuy
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val binding = holder.viewBinding
        val data = listData.get(position)
        if (binding is AdapterCompanyItemBinding) {
            binding.companyVM =
                CompanyVM(
                    data as ModelCompany
                )
        } else if (binding is AdapterCompanyParentBinding) {
            binding.parentCompany =
                ParentCompanyVM(
                    data as ModelParentCompany,
                    binding.recycler
                )
        } else if (binding is AdapterDetailParentBinding) {
            binding.parentDetailVM =
                ParentDetailVM(data as ModelParentDetail, binding.recycler)
        } else if (binding is AdapterDetailBinding) {
            binding.detailVM = DetailVM(data as ModelDetailItem)
        } else if (binding is AdapterButtonDetailParentBinding) {
            binding.parentButtonDetail =
                ParentButtonDetailVM(data as ModelParentButtonDetail, binding.recyclerButtonDetail)
        } else if (binding is AdapterButtonBuyParentBinding) {
            binding.parentButtonBuyVM =
                ParentButtonBuyVM(data as ModelParentButtonBuy, binding.recyclerButtonBuy)
        }
    }
}