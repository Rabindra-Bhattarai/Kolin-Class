//package com.example.a35b.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplication.R
//import de.hdodenhof.circleimageview.CircleImageView
//
//class FruitsAdapters(
//    val context: Context,
//    val imageList: ArrayList<Int>,
//    val fruitsTitle: ArrayList<String>,
//    val fruitsDesc: ArrayList<String>
//) : RecyclerView.Adapter<FruitsAdapters.FruitsViewHolder>() {
//    class FruitsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var image: CircleImageView = itemView.findViewById(R.id.profile_image)
//        var title: TextView = itemView.findViewById(R.id.lblFruitName)
//        var desc: TextView = itemView.findViewById(R.id.lblDescription)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
//        val itemView: View=LayoutInflater.from(context).inflate(R.layout.single_product, parent,false)
//        return  FruitsViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return 3
//    }
//
//    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
//        holder.title.text=fruitsTitle[position]
//        holder.desc.text =fruitsDesc[position]
//        holder.image.setImageResource(imageList[position])
//    }
//}



package com.example.a35b.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import de.hdodenhof.circleimageview.CircleImageView

// Adapter for displaying a list of fruits in a RecyclerView
class FruitsAdapters(
    val context: Context, // Context for inflating layouts
    val imageList: ArrayList<Int>, // List of image resource IDs
    val fruitsTitle: ArrayList<String>, // List of fruit names
    val fruitsDesc: ArrayList<String> // List of fruit descriptions
) : RecyclerView.Adapter<FruitsAdapters.FruitsViewHolder>() {

    // ViewHolder to hold and reuse views
    class FruitsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: CircleImageView = itemView.findViewById(R.id.profile_image) // Image view for fruit
        var title: TextView = itemView.findViewById(R.id.lblFruitName) // Text view for fruit name
        var desc: TextView = itemView.findViewById(R.id.lblDescription) // Text view for description
    }

    // Inflate the item layout and create a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.single_product, parent, false)
        return FruitsViewHolder(itemView)
    }

    // Return the number of items to display
    override fun getItemCount(): Int {
        return 3 // Currently fixed to 3 items
    }




    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.title.text = fruitsTitle[position] // Set fruit name
        holder.desc.text = fruitsDesc[position] // Set description
        holder.image.setImageResource(imageList[position]) // Set image
    }
}
