package eu.gitcode.salesrepresentative.feature.shops.add

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.gitcode.salesrepresentative.R
import eu.gitcode.salesrepresentative.common.extension.replaceFragment

class NewShopActivity : AppCompatActivity() {
    companion object {
        val SHOP_ADDED_REQUEST_CODE: Int = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        if (savedInstanceState == null) {
            replaceFragment(R.id.fragment_container, NewShopFragment()).commit()
        }
    }
}