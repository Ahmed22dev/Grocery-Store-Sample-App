package com.elkhami.mobcategories.view.productdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.model.data.Product
import com.elkhami.mobcategories.utils.Constants
import com.elkhami.mobcategories.utils.Constants.Companion.productItemExtra
import kotlinx.android.synthetic.main.activity_product_detail.*


/**
 * Created by A.Elkhami on 20,February,2021
 */
class ProductDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.extras?.getParcelable<Product>(productItemExtra)

        product?.let {

            title = getString(R.string.details_screen_title, it.name)

            val url = Constants.BASE_URL.replaceAfter("com", it.url, "//")

            Glide
                .with(this)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_food_and_drink)
                .into(productImageView)

            productNameTextView.text = it.name

            productPriceTextView.text = getString(
                R.string.amount_with_currency,
                it.salePrice.amount,
                it.salePrice.currency
            )
        }


    }
}