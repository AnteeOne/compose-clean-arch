package tech.antee.second.product_list.impl.ui.recycler.view_holders

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.antee.second.product_list.impl.databinding.ItemProductListBinding
import tech.antee.second.product_list.impl.ui.recycler.models.RecyclerItem

class ProductListViewHolder(
    private val binding: ItemProductListBinding,
    private val onDetailsClick: (productGuid: String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private val TAG = "ProductListViewHolder"

    fun bind(item: RecyclerItem.Product) {
        Log.d(TAG, "Binded ${item.productItem.name}")
        binding.root.setOnClickListener { onDetailsClick(item.productItem.guid) }
        binding.itemProductListName.text = item.productItem.name
        binding.itemProductPrice.text = item.productItem.price + "₽" // TODO: to string (лень кпц)
    }

    companion object {
        fun from(parent: ViewGroup, onDetailsClick: (productGuid: String) -> Unit): ProductListViewHolder {
            val binding = ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ProductListViewHolder(binding, onDetailsClick)
        }
    }
}
