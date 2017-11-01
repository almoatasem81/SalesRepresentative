package eu.gitcode.salesrepresentative.feature.products.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import eu.gitcode.salesrepresentative.R
import eu.gitcode.salesrepresentative.data.product.model.Product
import kotlinx.android.synthetic.main.product_view_holder.view.*

class ProductViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup?,
                        private val listener: ProductViewHolderListener)
    : RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.product_view_holder, parent, false)) {

    lateinit private var product: Product

    fun bind(product: Product) {
        this.product = product
        itemView.nameTxt.text = product.name
        itemView.capacityTxt.text = product.capacity?.toString()
        itemView.costTxt.text = product.cost?.toString()
        itemView.setOnClickListener { listener.onProductClicked(product) }
    }

    interface ProductViewHolderListener {
        fun onProductClicked(product: Product)
    }
}