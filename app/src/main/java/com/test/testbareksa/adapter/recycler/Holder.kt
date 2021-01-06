package com.test.testbareksa.adapter.recycler

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView

class Holder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root),
    LifecycleOwner {
    private val lifecycleRegistry = LifecycleRegistry(this)
    var viewBinding = binding

    fun bind() {
        binding.executePendingBindings()
        binding.lifecycleOwner = this
    }

    init {
        lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

}