package tech.antee.second.product_list.impl.ui.recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import tech.antee.second.product_list.impl.databinding.ItemProductListBinding
import tech.antee.second.product_list.impl.ui.models.ProductListItem

class ProductListAdapter(
    private val onDetailsClick: (productGuid: String) -> Unit,
) :
    ListAdapter<ProductListItem, ProductListAdapter.ProductListViewHolder>(ProductListItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val binding = ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductListViewHolder(binding, onDetailsClick)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductListItemCallback : DiffUtil.ItemCallback<ProductListItem>() {

        override fun areItemsTheSame(oldItem: ProductListItem, newItem: ProductListItem) = oldItem.guid == newItem.guid

        override fun areContentsTheSame(oldItem: ProductListItem, newItem: ProductListItem) = oldItem == newItem
    }

    class ProductListViewHolder(
        private val binding: ItemProductListBinding,
        private val onDetailsClick: (productGuid: String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private val TAG = "ProductListViewHolder"

        fun bind(item: ProductListItem) {
            Log.d(TAG, "Binded ${item.name}")
            binding.root.setOnClickListener { onDetailsClick(item.guid) }
            binding.itemProductListName.text = item.name
            binding.itemProductListImage.load(item.image)
        }
    }
}
