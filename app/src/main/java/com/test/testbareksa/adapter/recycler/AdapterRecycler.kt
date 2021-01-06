package com.test.testbareksa.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.test.testbareksa.databinding.AdapterCompanyItemBinding
import com.test.testbareksa.databinding.AdapterCompanyParentBinding
import com.test.testbareksa.fragment.imbal.CompanyVM
import com.test.testbareksa.model.ModelCompany

class AdapterRecycler(val listData: ArrayList<*>) : RecyclerView.Adapter<Holder>() {
    val companyParent = 1;
    val companyItem = 2;
    val detailParent = 3;
    val detailItem = 4;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
       when(viewType){
           companyParent->return createHolderCompanyParent(parent)
           else->return createHolderCompanyItem(parent)
       }
    }

    private fun createHolderCompanyParent(parent: ViewGroup): Holder {
        return Holder(AdapterCompanyParentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    private fun createHolderCompanyItem(parent: ViewGroup): Holder {
        return Holder(AdapterCompanyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        if (listData.get(position) is ArrayList<*>) {
            if (listData.get(position).get(0) is ModelCompany) {
                return companyParent
            } else {
                return detailParent
            }
        } else if (listData.get(position) is ModelCompany) {
            return companyItem
        } else {
            return detailItem
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        if (holder.viewBinding is AdapterCompanyItemBinding) {
            (holder.viewBinding as AdapterCompanyItemBinding).companyVM =
                CompanyVM(listData.get(position) as ModelCompany)
        }
    }
}