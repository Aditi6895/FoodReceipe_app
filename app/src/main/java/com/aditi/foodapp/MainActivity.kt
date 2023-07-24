package com.aditi.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView : RecyclerView
    lateinit var foodArrayList: ArrayList<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        myRecyclerView = findViewById(R.id.recyclerView)
        val foodImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5)

        val foodHeadingArray = arrayOf("Chilli Garlic Noodles", "Pizza", "Burger", "Gulab Jamun", "Pizza Paratha")

        val foodContent = arrayOf( getString(R.string.foods_contents), getString(R.string.foods_contents),
            getString(R.string.foods_contents), getString(R.string.foods_contents),getString(R.string.foods_contents))


        myRecyclerView.layoutManager = LinearLayoutManager(this)
        foodArrayList = arrayListOf<Food>()

        for (index in foodImageArray.indices){
            val food = Food(foodHeadingArray[index], foodImageArray[index], foodContent[index])
            foodArrayList.add(food)
        }

        var myAdapter = MyAdapter(foodArrayList, this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClicking(position: Int) {
                // on clicking action we want to perform
                val intent = Intent(this@MainActivity,foodDetailsActivity::class.java)
                intent.putExtra("heading", foodArrayList[position].foodHeading)
                intent.putExtra("imageId", foodArrayList[position].foodImage)
                intent.putExtra("foodContent", foodArrayList[position].foodContent)
                startActivity(intent)
            }
        })
    }
}