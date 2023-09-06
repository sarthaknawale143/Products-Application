package com.legacy.phnassignment

import android.media.Rating
import java.io.Serializable

data class Product(
   // val id: Int,
    val title: String,
    val description: String,
    val price : Double,
    val brand : String,
    val thumbnail : String,
    //val rating: String,
    // val stock : String,
    // val category: String,
 //   val productimageId :String
) : Serializable
