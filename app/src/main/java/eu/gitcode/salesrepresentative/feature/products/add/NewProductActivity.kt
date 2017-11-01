package eu.gitcode.salesrepresentative.feature.products.add

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import eu.gitcode.salesrepresentative.R
import eu.gitcode.salesrepresentative.common.extension.replaceFragment

class NewProductActivity : AppCompatActivity() {
    companion object {
        val PRODUCT_ADDED_REQUEST_CODE: Int = 1
        internal val PRODUCT_ID = "product_id"

        fun startActivityIntent(fragment: Fragment, productId: Long, requestCode: Int) {
            val intent = Intent(fragment.context, NewProductActivity::class.java)
            intent.putExtra(PRODUCT_ID, productId)
            fragment.startActivityForResult(intent, requestCode)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        if (savedInstanceState == null) {
            if (intent.hasExtra(PRODUCT_ID)) {
                val productId: Long = intent.getLongExtra(PRODUCT_ID, 0)
                replaceFragment(R.id.fragment_container, NewProductFragment.newInstance(productId)).commit()
            } else {
                replaceFragment(R.id.fragment_container, NewProductFragment()).commit()
            }
        }
    }
}