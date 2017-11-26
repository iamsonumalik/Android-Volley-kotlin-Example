package com.example.sonumalik.mykotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatTextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiHit()
    }

    private fun apiHit() {
        val textView : AppCompatTextView = findViewById(R.id.textView)
        val url = "https://jsonplaceholder.typicode.com/users"
        val queue : RequestQueue = Volley.newRequestQueue(this)
        val request =  JsonObjectRequest(Request.Method.GET ,  url, null , {
            response: JSONObject? ->
            textView.text = response.toString()
        } , {
            error: VolleyError? ->
            textView.text =  error.toString()
        })
        queue.add(request)
    }
}
