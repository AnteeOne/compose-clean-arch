package tech.antee.second.product_list.impl.ui.recycler.diffutils

import androidx.recyclerview.widget.DiffUtil
import tech.antee.second.product_list.impl.ui.recycler.models.RecyclerItem

class RecyclerItemCallback : DiffUtil.ItemCallback<RecyclerItem>() {

    override fun areItemsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem) =
        when {
            oldItem is RecyclerItem.Product && newItem is RecyclerItem.Product -> oldItem.productItem.guid == newItem.productItem.guid
            else -> oldItem == newItem
        }

    override fun areContentsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem) = oldItem == newItem
}
