package com.example.grid_java

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var images = intArrayOf(
        R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
        R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j,
        R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o,
        R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t,
        R.drawable.u, R.drawable.v
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gridView:GridView = findViewById(R.id.gridView)
        val customAdapter = CustomAdapter(images, this)
        gridView.adapter = customAdapter
        gridView.onItemClickListener = OnItemClickListener { _, _, i, _ ->
            val selectedImage = images[i]
            startActivity(
                Intent(this@MainActivity, ClickItemActivity::class.java).putExtra(
                    "image",
                    selectedImage
                )
            )
        }
    }

    inner class CustomAdapter(private val imagesPhoto: IntArray, context: Context) :
        BaseAdapter() {
        private val layoutInflater: LayoutInflater
        override fun getCount(): Int {
            return imagesPhoto.size
        }

        override fun getItem(i: Int): Any? {
            return null
        }

        override fun getItemId(i: Int): Long {
            return 0
        }

        override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View? {
            var view1 = view
            if (view == null) {
                view1 = layoutInflater.inflate(R.layout.row_items, viewGroup, false)
            }
            val imageView = view1?.findViewById<ImageView>(R.id.imageView)
            imageView?.setImageResource(imagesPhoto[i])
            return view1
        }

        init {
            layoutInflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
    }
}