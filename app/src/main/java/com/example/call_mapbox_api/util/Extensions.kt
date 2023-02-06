package com.example.call_mapbox_api.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast


fun hideKeyboard(view: View, context: Context) {
    val inputMethodManager =
        context.
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun showKeyboard(view: View, context: Context) {
    val inputMethodManager =
        context.
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(view , InputMethodManager.SHOW_FORCED)
}
/*
fun onSearchQuery(letter: String,addresses: List<EvPointsEntity>):  {
    val listAddresses = addresses.map { it.AddressInfo }
        .filter { it.AddressLine1?.split(" ")?.any { word -> word.startsWith(letter, ignoreCase = true) } == true ||
                it.AddressLine2?.split(" ")?.any { word -> word.startsWith(letter, ignoreCase = true) } == true ||
                it.Postcode?.startsWith(letter, ignoreCase = true) == true ||
                it.Title?.startsWith(letter, ignoreCase = true) == true ||
                it.Town?.startsWith(letter, ignoreCase = true) == true }
}
*/

/*fun onSearchQuery(letter: String, addresses: (EvPointsEntity) -> ItemDataConverter): List<EvPointsEntity> {
    return addresses.filter { it.split(" ").any { word -> word.startsWith(letter, ignoreCase = true) } }
}*/

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
