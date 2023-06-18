package com.example.apicalling

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ProductAdapter(val context: Context, val  data:List<DataModel>): BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return  data[position]
    }

    override fun getItemId(position: Int): Long {
        return data.size.toLong()
    }
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = LayoutInflater.from(context).inflate(R.layout.listviewdesign, parent, false)


        val name=   rowView.findViewById<TextView>(R.id.title)
        val title=   rowView.findViewById<TextView>(R.id.description)
        val price= rowView.findViewById<TextView>(R.id.price)
        val img=rowView.findViewById<ImageView>(R.id.image)
        val abc=data[position]
        Glide.with(context).load(abc.image).error(R.drawable.ic_launcher_background).into(img);
        name.text=data[position].title
        price.text=data[position].price
        title.text=data[position].description
        return  rowView


    }
}