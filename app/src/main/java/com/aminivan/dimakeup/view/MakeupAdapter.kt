package com.aminivan.dimakeup.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aminivan.dimakeup.databinding.ItemMakeupBinding
import com.aminivan.dimakeup.model.ResponseDataMakeUpItem
import com.bumptech.glide.Glide

class MakeupAdapter(var listMakeUp : List<ResponseDataMakeUpItem>): RecyclerView.Adapter<MakeupAdapter.ViewHolder>() {

    var onDelete : ((ResponseDataMakeUpItem)->Unit)? = null
    var onDetail : ((ResponseDataMakeUpItem)->Unit)? = null

    class ViewHolder(var binding : ItemMakeupBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeupAdapter.ViewHolder {
        var view = ItemMakeupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MakeupAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.nameCar.text = listMakeUp!![position].name
        holder.binding.categoryCar.text = listMakeUp!![position].category
        holder.binding.priceCar.text = listMakeUp!![position].price.toString()
        Glide.with(holder.itemView.context).load(listMakeUp!![position].imageLink).into(holder.binding.imgCar)

        holder.binding.deleteCar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val bun = Bundle()
                bun.putString("id", listMakeUp[position].id.toString())
            }
        })

    }

    override fun getItemCount(): Int {

        return listMakeUp.size

    }
}