package com.example.ev_mapbox.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.example.ev_mapbox.data.local.EvPointsEntity


fun hideKeyboard(view: View, context: Context) {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun EditText.showKeyboardDelayed(delayMillis: Long = 200) {
    this.postDelayed({
        this.requestFocus()
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }, delayMillis)
}

fun searchPoints(letter: String, addresses: List<EvPointsEntity>): List<EvPointsEntity> {
    return addresses.filter { address ->
        val addressInfo = address.AddressInfo
        addressInfo.AddressLine1?.split(" ")
            ?.any { word -> word.startsWith(letter, ignoreCase = true) } == true ||
                addressInfo.AddressLine2?.split(" ")
                    ?.any { word -> word.startsWith(letter, ignoreCase = true) } == true ||
                addressInfo.Postcode?.startsWith(letter, ignoreCase = true) == true ||
                addressInfo.Title?.startsWith(letter, ignoreCase = true) == true ||
                addressInfo.Town?.startsWith(letter, ignoreCase = true) == true
    }
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
