package tech.antee.second.product_list.impl.ui.recycler.view_holders

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.antee.second.product_list.impl.databinding.ItemHeaderBinding
import tech.antee.second.product_list.impl.ui.recycler.models.RecyclerItem

class HeaderViewHolder(
    private val binding: ItemHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val TAG = "HeaderViewHolder"

    fun bind(item: RecyclerItem.Header) {
        Log.d(TAG, "Binded ${item.title}")
        binding.title.text = item.title
    }

    companion object {
        fun from(parent: ViewGroup): HeaderViewHolder {
            val binding = ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return HeaderViewHolder(binding)
        }
    }
}
