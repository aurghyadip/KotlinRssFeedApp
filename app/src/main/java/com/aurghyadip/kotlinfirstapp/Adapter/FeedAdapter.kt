package com.aurghyadip.kotlinfirstapp.Adapter

import android.content.Context
import android.support.constraint.R.id.parent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.aurghyadip.kotlinfirstapp.Interface.ItemClickListener
import com.aurghyadip.kotlinfirstapp.Model.RssFeed
import com.aurghyadip.kotlinfirstapp.R

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    var txtTitle:TextView
    var txtPubDate:TextView
    var txtContent:TextView

    private var itemClickListener : ItemClickListener?=null

    init {
        txtTitle = itemView.findViewById(R.id.txtTitle) as TextView
        txtPubDate = itemView.findViewById(R.id.txtPubDate) as TextView
        txtContent = itemView.findViewById(R.id.txtContent) as TextView

        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        itemClickListener!!.onClick(v, adapterPosition, false)
    }

    override fun onLongClick(v: View?): Boolean {
        itemClickListener!!.onClick(v, adapterPosition, true)
    }

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
    }

}
