package com.example.marketapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ItemActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val title: TextView = findViewById(R.id.tvItem_list_title_one)
        val text: TextView = findViewById(R.id.tvItem_list_text)
        var image: ImageView = findViewById(R.id.ivItem_list_image_one)


        val imageId = intent.getIntExtra("itemImg", 0)
        if (imageId != 0) {
            image.setImageResource(imageId)
        }

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")

    }
}