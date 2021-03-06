package com.elkhami.mobcategories.view.productlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.elkhami.mobcategories.R
import com.elkhami.mobcategories.model.data.Product

/**
 * Created by A.Elkhami on 20,February,2021
 */
class ProductRecyclerAdapter(
    private val productList: List<Product>,
    private val clickListener: ProductRecyclerAdapterCallback
) :
    RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.productItemImageView)
        val productTextView: TextView = itemView.findViewById(R.id.productItemNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.product_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productItem = productList[position]

        Glide
            .with(holder.itemView)
            .load(productItem.url)
            .placeholder(R.drawable.ic_placeholder)
            .circleCrop()
            .transition(
                DrawableTransitionOptions()
                    .crossFade()
            )
            .into(holder.productImageView)

        holder.productTextView.text = productItem.name

        holder.itemView.setOnClickListener {
            clickListener.onProductClick(productItem)
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}