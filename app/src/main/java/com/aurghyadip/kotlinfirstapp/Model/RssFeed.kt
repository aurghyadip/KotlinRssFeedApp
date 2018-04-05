package com.aurghyadip.kotlinfirstapp.Model


data class RssFeed(
        val status: String,
        val feed: Feed,
        val items: List<Item>
)