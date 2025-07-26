package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.chaquo.python.PyException
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val python = Python.getInstance()
        val mainModule = python.getModule("main")

        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.myBtn)

        btn.setOnClickListener {
            try {
                val msg = mainModule.callAttr("hello_world").toString()
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            } catch (e: PyException) {
                Toast.makeText(this, "Python error: ${e.message}", Toast.LENGTH_LONG).show()
                e.printStackTrace()
            }
        }
    }
}
