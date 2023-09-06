package com.legacy.phnassignment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.legacy.phnassignment.databinding.ActivityMainBinding
import com.legacy.phnassignment.databinding.ProductViewBinding
import com.squareup.picasso.Picasso

class ProductAdapter(
    private val context: Context,
    private val products: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ProductViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.txtProductTitle.text = product.title
            binding.txtProductBrand.text = product.brand
            binding.txtProductPrice.text = product.price.toString()
            binding.txtProductDescription.text = product.description
            binding.txtProductThumbnail.text = product.thumbnail

           Glide.with(context)
                .load(product.thumbnail)
                .into(binding.imgThumbProduct)

            binding.root.setOnClickListener {
                val intent = Intent(context, ProductDetailsActivity::class.java)
                intent.putExtra("product", product)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }
}