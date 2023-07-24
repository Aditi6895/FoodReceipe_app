package com.aditi.foodapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var foodArrayList: ArrayList<Food>, var context: Activity) :

    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

        private lateinit var myListener: onItemClickListener

        interface onItemClickListener {
            fun onItemClicking(position: Int)
        }

        fun setOnItemClickListener(listener : onItemClickListener){
            myListener = listener
        }

        // to create new view instance
        // when layout manager fails to find a suitable view for each item
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): MyAdapter.MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem,parent,false)
            return MyViewHolder(itemView, myListener)
        }

        // populate items with data
        override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
            val currentItem = foodArrayList[position]
            holder.hTitle.text = currentItem.foodHeading
            holder.hImage.setImageResource(currentItem.foodImage)
        }

        // how many list views are present in your array
        override fun getItemCount(): Int {
            return foodArrayList.size
        }

        // it holds the view sp views are not created everytime, so memory can be stored
        class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
            val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
            val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

            init {
                itemView.setOnClickListener {
                    listener.onItemClicking(adapterPosition)
                }
            }

        }
    }




