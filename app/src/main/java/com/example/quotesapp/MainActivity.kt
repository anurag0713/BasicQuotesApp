package com.example.quotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), Adapter.OnItemClickListener {

    private var areQuotesLoaded: Boolean = false
    private var quotesData: ArrayList<QuoteModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView =  findViewById<RecyclerView>(R.id.quotes_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val quotesAdapter = Adapter(this, getQuotes(), this)
        recyclerView.adapter = quotesAdapter

    }

    override fun onItemClick(quote: String, author: String) {
        val intent = Intent(this, SingleQuote::class.java)
        intent.putExtra("Quote", quote)
        intent.putExtra("Author", author)

        startActivity(intent)
    }


    private fun getQuotes(): ArrayList<QuoteModel> {
        if (!areQuotesLoaded){
            quotesData.add(QuoteModel("The greatest glory in living lies not in never falling, but in rising every time we fall.", "Nelson Mandela"))
            quotesData.add(QuoteModel("Be yourself; everyone else is already taken.","Oscar Wilde"))
            quotesData.add(QuoteModel("Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.","Albert Einstein"))
            quotesData.add(QuoteModel("Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.","Bernard M. Baruch"))
            quotesData.add(QuoteModel("You know you're in love when you can't fall asleep because reality is finally better than your dreams.","Dr. Seuss"))
            quotesData.add(QuoteModel("In three words I can sum up everything I've learned about life: it goes on.","Robert Frost"))
            quotesData.add(QuoteModel("If you want to know what a man's like, take a good look at how he treats his inferiors, not his equals.","J.K. Rowling"))
            quotesData.add(QuoteModel("I've learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.","Maya Angelou"))
            quotesData.add(QuoteModel("A friend is someone who knows all about you and still loves you.","Elbert Hubbard"))
            quotesData.add(QuoteModel("Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.","Martin Luther King Jr"))
            quotesData.add(QuoteModel("Live as if you were to die tomorrow. Learn as if you were to live forever.","Mahatma Gandhi"))

            areQuotesLoaded = true
        }

        return quotesData
    }



}