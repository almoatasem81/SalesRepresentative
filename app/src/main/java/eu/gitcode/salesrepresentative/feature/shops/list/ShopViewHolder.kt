package eu.gitcode.salesrepresentative.feature.shops.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import eu.gitcode.salesrepresentative.R
import eu.gitcode.salesrepresentative.data.shop.model.Shop
import kotlinx.android.synthetic.main.shop_view_holder.view.*

class ShopViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup?,
                     private val listener: ShopViewHolderListener)
    : RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.shop_view_holder, parent, false)) {

    lateinit private var shop: Shop

    fun bind(shop: Shop) {
        this.shop = shop
        itemView.nameTxt.text = shop.name
        itemView.addressTxt.text = shop.location
        itemView.timeTxt.text = shop.openingHours
        itemView.setOnClickListener { listener.onShopClicked(shop) }
    }

    interface ShopViewHolderListener {
        fun onShopClicked(shop: Shop)
    }
}