package com.example.call_mapbox_api.ui

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.call_mapbox_api.BuildConfig
import com.example.call_mapbox_api.R
import com.example.call_mapbox_api.util.LocationPermission.checkAndRequestLocationPermissions
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCenter.start(
            application, BuildConfig.APP_SECRET_KEY,
            Analytics::class.java, Crashes::class.java
        )
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