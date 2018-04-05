package com.aurghyadip.kotlinfirstapp.adapter

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.aurghyadip.kotlinfirstapp.model.RssFeed
import com.aurghyadip.kotlinfirstapp.R
import com.bumptech.glide.Glide

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var txtTitle:TextView = itemView.findViewById(R.id.txtTitle) as TextView
    var txtPubDate:TextView = itemView.findViewById(R.id.txtPubDate) as TextView
    var txtContent:TextView = itemView.findViewById(R.id.txtContent) as TextView
    var postImage:ImageView = itemView.findViewById(R.id.postImage) as ImageView

}

class FeedAdapter(private val rssFeed: RssFeed, private val mContext: Context):RecyclerView.Adapter<FeedViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val itemView = inflater.inflate(R.layout.row, parent, false)
        return FeedViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return rssFeed.items.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.txtTitle.text = rssFeed.items[position].title
        holder.txtPubDate.text = rssFeed.items[position].pubDate
        holder.txtContent.text = rssFeed.items[position].content
        Glide.with(holder.postImage.context).load(rssFeed.items[position].enclosure.link).into(holder.postImage)

        holder.itemView.setOnClickListener{ _ ->
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(rssFeed.items[position].link))
            browserIntent.flags = FLAG_ACTIVITY_NEW_TASK
            mContext.startActivity(browserIntent)
        }
    }

}
