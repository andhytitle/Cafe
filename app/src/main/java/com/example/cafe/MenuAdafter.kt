package com.example.cafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listmenu.view.*


class MenuAdafter(
    var result: ArrayList<MenuModel.Result>,
    val listener: OnAdapterChangeListener
) : RecyclerView.Adapter<MenuAdafter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.listmenu, parent, false)
    )

    override fun getItemCount() = result.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val result = result[position]
        holder.view.tvNama.text = result.nama
        holder.view.tvDeskripsi.text = result.deskripsi
        holder.view.tvHarga.text = "Rp. ${result.harga.toString()}"
        Glide.with(holder.view)
            .load(result.id)
            .placeholder(R.drawable.ic_restaurant)
            .error(R.drawable.ic_restaurant)
            .centerCrop()
            .into(holder.view.ivMenu)

        holder.view.setOnClickListener { listener.onClick(result) }
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    interface OnAdapterChangeListener {
        fun onClick(result: MenuModel.Result)
    }


}