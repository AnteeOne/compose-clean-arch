package tech.antee.second.product_list.impl.ui.recycler

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tech.antee.second.product_list.impl.ui.models.ProductListItem

@Composable
fun ProductRecyclerListComponent(
    items: List<ProductListItem>,
    modifier: Modifier = Modifier,
    onDetailsClick: (productGuid: String) -> Unit,
) {
    val context = LocalContext.current
    val listAdapter = remember { ProductListAdapter(onDetailsClick) }
    val listLayoutManager = remember { LinearLayoutManager(context) }
    AndroidView(
        modifier = modifier,
        factory = {
            RecyclerView(it).apply {
                adapter = listAdapter
                layoutManager = listLayoutManager
            }
        }
    )
    listAdapter.submitList(items) // TODO: check AndroidView Factory method
}
