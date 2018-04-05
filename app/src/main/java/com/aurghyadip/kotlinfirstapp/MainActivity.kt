package com.aurghyadip.kotlinfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.aurghyadip.kotlinfirstapp.adapter.FeedAdapter
import com.aurghyadip.kotlinfirstapp.model.RssFeed
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val url = "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Frss.nytimes.com%2Fservices%2Fxml%2Frss%2Fnyt%2FScience.xml"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title ="NEWS"
        setSupportActionBar(toolbar)

        val linearLayoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        val request = StringRequest(url, Response.Listener {
            val rssFeed = Gson().fromJson<RssFeed>(it, RssFeed::class.java)
            recyclerView.adapter = FeedAdapter(rssFeed, baseContext)
        }, Response.ErrorListener {

        })
        val queue = Volley.newRequestQueue(this)
        queue.add(request)
    }
}
