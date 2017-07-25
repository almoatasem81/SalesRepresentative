package eu.gitcode.salesrepresentative.feature.shops

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import eu.gitcode.salesrepresentative.model.Shop

class ShopsAdapter : RecyclerView.Adapter<ShopViewHolder>() {

    val shopsList: MutableList<Shop> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ShopViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return ShopViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(shopsList[position])
    }

    override fun getItemCount() = shopsList.size

    fun setShops(shopsList: List<Shop>) {
        this.shopsList.clear()
        this.shopsList.addAll(shopsList)
        notifyDataSetChanged()
    }
}