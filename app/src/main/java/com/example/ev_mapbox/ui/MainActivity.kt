package com.example.ev_mapbox.ui

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ev_mapbox.util.LocationPermission.checkAndRequestLocationPermissions
import com.example.ev_mapbox.R
import com.example.ev_mapbox.util.Constants.AGREE
import com.example.ev_mapbox.util.Constants.LOCATION_MESSAGE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkAndRequestLocationPermissions(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            (grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED && grantResults[1] ==
                    PackageManager.PERMISSION_GRANTED
                    )
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(LOCATION_MESSAGE)
                .setPositiveButton(AGREE) { dialog, _ ->
                    dialog.dismiss()
                    checkAndRequestLocationPermissions(this)
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                    finish()
                }
            val dialog = builder.create()
            dialog.show()
        }
    }
}
