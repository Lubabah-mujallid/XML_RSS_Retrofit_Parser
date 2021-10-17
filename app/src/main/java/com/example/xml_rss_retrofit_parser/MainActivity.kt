package com.example.xml_rss_retrofit_parser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xml_rss_retrofit_parser.channel.Rss
import com.example.xml_rss_retrofit_parser.channel.item.Item
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var myList: ArrayList<Item>

    private val TAG = "MainActivity"
    private val BASE_URL = "https://rss.nytimes.com/services/xml/rss/nyt/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tvTitle = findViewById(R.id.tvTitle)
        //btnFetch = findViewById(R.id.btnFetch)
        myList = ArrayList()

        requestAPI()

        val adapter = RecyclerAdapter(this@MainActivity, myList)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this@MainActivity)

    }

    private fun requestAPI(){
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create()).build()
        val feedAPI = retrofit.create(FeedAPI::class.java)
        val call = feedAPI.feed


        call!!.enqueue(object : Callback<Rss?> {
            override fun onResponse(call: Call<Rss?>, response: Response<Rss?>) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString())
                Log.d(TAG, "onResponse: Server Response: $response")
                val entries = response.body()!!.channel!!.items
                for (entry in entries!!) {
                    Log.d(TAG, "onResponse: " + entry.title)
                    myList.add(entry)
                    //var text = tvTitle.text.toString()
                    //tvTitle.text = text + "\n" + entry.title
                }
                rv.adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Rss?>, t: Throwable) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.message)
                Toast.makeText(this@MainActivity, "An Error Occured", Toast.LENGTH_SHORT).show()
            }
        })
    }

}

/*

Find a free open-source RSS API that gives you RSS results/data in XML format

Parse the data and display it in a RecyclerView

Bonus:

Allow users to tap on an item in the RecyclerView that will take them to a new screen and display more detailed information about the item

Create a visually appealing design


 */