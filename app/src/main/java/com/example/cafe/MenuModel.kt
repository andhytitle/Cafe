package com.example.cafe

import android.media.Image

data class MenuModel(
    var result: ArrayList<Result>
) {
    data class Result(
        val id: Int,
        val nama: String,
        val deskripsi: String,
        val harga: Int,
        val image: String
    )
}
