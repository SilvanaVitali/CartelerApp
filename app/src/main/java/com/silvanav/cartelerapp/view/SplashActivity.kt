package com.silvanav.cartelerapp.view

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.silvanav.cartelerapp.MainActivity

class SplashActivity : AppCompatActivity() {

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val isGranted = permissions.entries.all {
            it.value
        }
        val message = if(isGranted) "Todos los permisos concedidos" else "Advertencia: Faltan permisos por conceder"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        requestPermissionLauncher.launch(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE))
    }
}