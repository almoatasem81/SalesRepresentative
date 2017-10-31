package eu.gitcode.salesrepresentative.feature.shops.add

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import eu.gitcode.salesrepresentative.R
import eu.gitcode.salesrepresentative.common.extension.replaceFragment

class NewShopActivity : AppCompatActivity() {
    companion object {
        val SHOP_ADDED_REQUEST_CODE: Int = 1
        internal val SHOP_ID = "shop_id"

        fun startActivityIntent(fragment: Fragment, shopId: Long, requestCode: Int) {
            val intent = Intent(fragment.context, NewShopActivity::class.java)
            intent.putExtra(SHOP_ID, shopId)
            fragment.startActivityForResult(intent, requestCode)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        if (savedInstanceState == null) {
            if (intent.hasExtra(SHOP_ID)) {
                val shopId: Long = intent.getLongExtra(SHOP_ID, 0)
                replaceFragment(R.id.fragment_container, NewShopFragment.newInstance(shopId)).commit()
            } else {
                replaceFragment(R.id.fragment_container, NewShopFragment()).commit()
            }
        }
    }
}