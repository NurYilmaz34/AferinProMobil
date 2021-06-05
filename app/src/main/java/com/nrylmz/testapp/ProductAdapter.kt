package com.nrylmz.testapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ProductAdapter(var context: Context, var arraylist:ArrayList<Product>): BaseAdapter() {
    override fun getCount(): Int {
        return arraylist.size
    }

    override fun getItem(position: Int): Any {
        return arraylist.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(context, R.layout.grid_card,null)

        var icons: ImageView = view.findViewById(R.id.iconid)
        var names: TextView = view.findViewById(R.id.product)

        var product:Product=arraylist.get(position)
        icons.setImageResource(product.icons!!)
        names.text=product.name

        return view
    }

}