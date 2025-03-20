package com.example.marketapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class   ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()
        items.add(Item(1, "img_rickowens", "Rick Owens", "Sneakers are comfortable sports shoes designed for an active lifestyle. They provide cushioning, support, and flexibility, making them ideal for running, training, and everyday wear.", "Sneakers are versatile footwear designed for both sports and casual use. They are lightweight, flexible, and offer excellent shock absorption, reducing stress on the joints while walking or running. The upper part is typically made from breathable materials like mesh or synthetic fabrics, while the sole is crafted from rubber or foam for better grip and comfort. Modern sneakers often feature advanced technologies to enhance stability, foot support, and durability.", "1000$" ))
        items.add(Item(2, "img_balenciaga_hoodie", "Balenciaga", "The Balenciaga hoodie is a stylish and high-quality piece of streetwear, known for its oversized fit, premium materials, and bold branding. It combines luxury with casual comfort, making it a statement piece for any wardrobe.", "The Balenciaga hoodie is a premium fashion staple that blends high-end design with urban streetwear aesthetics. Made from soft, heavyweight cotton, it offers an oversized silhouette for a relaxed yet fashionable look. Signature details often include the brand’s logo, graphic prints, or distressed elements, adding to its unique appeal. Perfect for layering, the hoodie provides both warmth and effortless style, making it a must-have for those who appreciate luxury and contemporary fashion.", "750$"))
        items.add(Item(3, "img_yori", "Yori", "Yori pants are stylish and comfortable bottoms known for their elegant yet relaxed fit. Designed with premium fabrics and a modern silhouette, they offer a perfect balance between sophistication and casual wear.", "Yori pants are versatile and fashion-forward trousers that blend comfort with refined aesthetics. Crafted from high-quality materials, they feature a tailored yet relaxed fit, making them suitable for both casual and semi-formal occasions. With thoughtful details such as pleats, elastic waistbands, or wide-leg cuts, Yori pants provide effortless elegance while ensuring all-day comfort. Ideal for modern wardrobes, they complement a variety of styles, from minimalistic chic to sophisticated layering.", "600$"))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

    }
}