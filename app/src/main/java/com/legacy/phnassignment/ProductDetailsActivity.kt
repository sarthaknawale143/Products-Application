package com.legacy.phnassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.legacy.phnassignment.databinding.ActivityProductDetailsBinding
import com.squareup.picasso.Picasso

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getSerializableExtra("product") as Product

        if(product != null){
            binding.titleTextView.text = product.title
            binding.descriptionTextView.text = product.description
            binding.priceTextView.text = "${product.price}"
            binding.brandTextView.text = product.brand


            Picasso.get()
                .load(product.thumbnail)
                .into(binding.thumbnailImageView)
        }
    }
}