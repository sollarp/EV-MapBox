package com.example.call_mapbox_api.ui

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.call_mapbox_api.R
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.call_mapbox_api.ui.homescreen.MapBarFragment
import com.example.call_mapbox_api.util.LocationPermission.checkAndRequestLocationPermissions

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