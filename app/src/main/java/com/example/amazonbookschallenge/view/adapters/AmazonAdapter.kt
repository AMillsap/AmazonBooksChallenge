package com.example.amazonbookschallenge.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amazonbookschallenge.R
import com.example.amazonbookschallenge.model.amazonResponse.AmazonResult
import kotlinx.android.synthetic.main.amazon_item.view.*

class AmazonAdapter() : RecyclerView.Adapter<AmazonAdapter.ViewHolder>()
{
        var amazonList = ArrayList<AmazonResult>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.amazon_item, parent, false))


        override fun getItemCount() = amazonList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int)  =
            holder.populateAmazon(amazonList[position])

        fun addList(list : ArrayList<AmazonResult>)
        {
            amazonList = list
            notifyDataSetChanged()
        }


        inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
            fun populateAmazon(amazonResponse: AmazonResult)
            {
                itemView.tvTitle.text = amazonResponse.title
                itemView.tvAuthor.text = amazonResponse.author
                if(amazonResponse.imageURL != null) {
                    val url = amazonResponse.imageURL.replace("http", "https")
                    Glide
                        .with(itemView)
                        .load(url)
                        .into(itemView.ivImage)
                }
            }
        }
}