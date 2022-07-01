package com.example.grid_java

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ClickItemActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_item)
        imageView = findViewById(R.id.imageView)
        val intent = intent
        if (intent.extras != null) {
            val selectedImage = intent.getIntExtra("image", 0)
            imageView?.setImageResource(selectedImage)
        }
    }
}