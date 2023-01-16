package com.example.call_mapbox_api.homescreen.ui

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.call_mapbox_api.R
import com.example.call_mapbox_api.homescreen.data.SearchRecycleAdapter
import kotlinx.coroutines.launch

class SearchListActivity : AppCompatActivity() {

    private val viewModel: SearchListViewModel by viewModels { SearchListViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchlist)
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_search)
        var t = 0
        var f = true

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                t += dy
                if (((t > 0) || (t < 0)) and f) {
                    val inputMethodManager =
                        getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                    f = false
                }
            }
        })
        // use viewLifecycleOwner.lifecycleScope.lunch { } in fragment
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listOfItems.observe(
                    this@SearchListActivity
                ) {
                    val adapter = SearchRecycleAdapter(it)
                    if (recyclerView != null) {
                        recyclerView.layoutManager =
                            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                    }
                    if (recyclerView != null) {
                        recyclerView.adapter = adapter
                    }
                }
            }
        }
    }
}
    /*  fun hideKeyboard(activity: Activity) {
          val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
          //Find the currently focused view, so we can grab the correct window token from it.
          val view = activity.getCurrentFocus()
          //If no view currently has focus, create a new one, just so we can grab a window token from it
          if (view == null) {
              view = new View(activity);
          }
          inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
      }*/
//    fun View.hideKeyboard(activity: Activity) {
//        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        val view = activity.getCurrentFocus()
//        if (view == null) {
//            view = activity.vi
//        }
//        inputManager.hideSoftInputFromWindow(windowToken, 0)
//    }



/*override fun onTouchEvent(event: MotionEvent): Boolean {
    return when (MotionEventCompat.getActionMasked(event)) {

        // Display a Toast whenever a movement is captured on the screen
        MotionEvent.ACTION_MOVE -> {
            Toast.makeText(applicationContext, "Action was MOVE", Toast.LENGTH_SHORT).show()
            true
        }
        else -> super.onTouchEvent(event)
    }
}*/