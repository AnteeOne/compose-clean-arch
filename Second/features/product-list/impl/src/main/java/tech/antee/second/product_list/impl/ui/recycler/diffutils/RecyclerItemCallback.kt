package tech.antee.second.product_list.impl.ui.recycler.diffutils

import androidx.recyclerview.widget.DiffUtil
import tech.antee.second.product_list.impl.ui.recycler.models.RecyclerItem

class RecyclerItemCallback : DiffUtil.ItemCallback<RecyclerItem>() {

    override fun areItemsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem) =
        when {
            oldItem is RecyclerItem.Product && newItem is RecyclerItem.Product -> oldItem.productItem.guid == newItem.productItem.guid
            else -> oldItem.javaClass.name == newItem.javaClass.name
        }

    override fun areContentsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem) = oldItem == newItem

    override fun getChangePayload(oldItem: RecyclerItem, newItem: RecyclerItem): Any? = when {
        oldItem is RecyclerItem.Product &&
        newItem is RecyclerItem.Product &&
        oldItem.productItem.isInCart != newItem.productItem.isInCart -> true
        else -> null

    }
}
