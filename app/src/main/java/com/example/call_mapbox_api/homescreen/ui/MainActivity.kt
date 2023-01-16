package com.example.call_mapbox_api.homescreen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.call_mapbox_api.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapbar)
        val searchBar = findViewById<EditText>(R.id.input_search)
        searchBar.focusable = View.NOT_FOCUSABLE
        searchBar.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View?) {
                val softKey =
                    application.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                softKey.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
                searchBar.focusable = View.FOCUSABLE
                val intent = Intent(this@MainActivity, SearchListActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
