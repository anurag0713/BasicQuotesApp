package com.example.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SingleQuote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_quote)

        val quote = intent.getStringExtra("Quote")
        val author = intent.getStringExtra("Author")

        val quoteText = findViewById<TextView>(R.id.quote_text)
        val authorText = findViewById<TextView>(R.id.author)

        quoteText.text = quote
        authorText.text = author
    }
}