package com.legacy.phnassignment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.legacy.phnassignment.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productadapter: ProductAdapter
    private val products = ArrayList<Product>()
    private lateinit var requestQueue : RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initView()
        initRequestQueue()
        fetchProducts()

    }

    private fun fetchProducts() {
        val req = JsonObjectRequest(
            Request.Method.GET,
            "https://dummyjson.com/products",
            null,
            { jsonObject ->

                Log.e("tag",  jsonObject.toString())

                val gson = Gson()

                val productsArray = gson.fromJson<Array<Product>>(
                    jsonObject.getJSONArray("products").toString(),
                    Array<Product>::class.java

                )

                products.addAll(productsArray)
                productadapter.notifyDataSetChanged()
            },
            { error ->
                Log.e("tag", "error")
            }
        )
        requestQueue.add(req)
    }
    private fun initRequestQueue(){
        requestQueue= Volley.newRequestQueue(this@MainActivity)
    }

    private fun initView() {
        binding.recyclerViewProducts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        productadapter = ProductAdapter(this,products)
        binding.recyclerViewProducts.adapter = productadapter


    }

}