package com.aurghyadip.kotlinfirstapp.model


data class RssFeed(
        val status: String,
        val feed: Feed,
        val items: List<Item>
)