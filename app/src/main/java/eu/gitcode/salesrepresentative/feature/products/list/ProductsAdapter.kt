package eu.gitcode.salesrepresentative.feature.products.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import eu.gitcode.salesrepresentative.data.product.model.Product

class ProductsAdapter(
        private val listener: ProductViewHolder.ProductViewHolderListener)
    : RecyclerView.Adapter<ProductViewHolder>() {

    val productsList: MutableList<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return ProductViewHolder(layoutInflater, parent, listener)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productsList[position])
    }

    override fun getItemCount() = productsList.size

    fun setProducts(productsList: List<Product>) {
        this.productsList.clear()
        this.productsList.addAll(productsList)
        notifyDataSetChanged()
    }
}