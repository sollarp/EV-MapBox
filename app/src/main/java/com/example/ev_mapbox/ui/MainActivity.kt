package com.example.ev_mapbox.ui

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ev_mapbox.util.LocationPermission.checkAndRequestLocationPermissions
import com.example.ev_mapbox.BuildConfig
import com.example.ev_mapbox.R
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*AppCenter.start(
            application, "b963b324-5670-4a3a-8720-1317529ff65b",
            Analytics::class.java, Crashes::class.java
        )*/
        checkAndRequestLocationPermissions(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults[0] ==
                PackageManager.PERMISSION_GRANTED && grantResults[1] ==
                PackageManager.PERMISSION_GRANTED
            ) {
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("This app requires location permission to function properly.")
                    .setPositiveButton("Agree") { dialog, _ ->
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
}