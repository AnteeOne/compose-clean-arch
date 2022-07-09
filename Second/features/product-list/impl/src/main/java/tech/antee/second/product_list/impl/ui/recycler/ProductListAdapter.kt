package tech.antee.second.product_list.impl.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tech.antee.second.product_list.impl.ui.models.ProductListItem
import tech.antee.second.product_list.impl.ui.recycler.diffutils.RecyclerItemCallback
import tech.antee.second.product_list.impl.ui.recycler.models.RecycleItemViewType
import tech.antee.second.product_list.impl.ui.recycler.models.RecyclerItem
import tech.antee.second.product_list.impl.ui.recycler.view_holders.HeaderViewHolder
import tech.antee.second.product_list.impl.ui.recycler.view_holders.ProductListViewHolder

class ProductListAdapter(
    private val onDetailsClick: (productGuid: String) -> Unit,
    private val onCartButtonClick: (productGuid: String) -> Unit
) : ListAdapter<RecyclerItem, RecyclerView.ViewHolder>(RecyclerItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            RecycleItemViewType.PRODUCT.viewType -> ProductListViewHolder.from(
                parent,
                onDetailsClick,
                onCartButtonClick
            )
            RecycleItemViewType.HEADER.viewType -> HeaderViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductListViewHolder -> holder.bind(getItem(position) as RecyclerItem.Product)
            is HeaderViewHolder -> holder.bind(getItem(position) as RecyclerItem.Header)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            if (payloads[0] == true) {
                when (holder) {
                    is ProductListViewHolder -> {
                        val recyclerItem = getItem(position) as RecyclerItem.Product
                        holder.bindShoppingCartButtonState(recyclerItem.productItem.isInCart)
                    }
                    is HeaderViewHolder -> holder.bind(getItem(position) as RecyclerItem.Header)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is RecyclerItem.Header -> RecycleItemViewType.HEADER.viewType
        is RecyclerItem.Product -> RecycleItemViewType.PRODUCT.viewType
    }

    fun submitSectionalSortedList(
        list: List<ProductListItem>,
        priceBorder: Int = PRICE_BORDER
    ) {
        val sortedProducts = buildList {
            add(RecyclerItem.Header("< $priceBorder ₽"))
            addAll(list.filter { it.parseProductPrice() < priceBorder }.map { RecyclerItem.Product(it) })
            add(RecyclerItem.Header(">= $priceBorder ₽"))
            addAll(list.filter { it.parseProductPrice() >= priceBorder }.map { RecyclerItem.Product(it) })
        }
        submitList(sortedProducts)
    }

    private companion object {
        const val PRICE_BORDER = 100
    }
}
