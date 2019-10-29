package com.example.galaxies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.list_fragment, ListFragment()).commit()
    }

    fun itemClicked(item: Item) {
        val toast: Toast = Toast.makeText(applicationContext, "${item.title} clicked", Toast.LENGTH_SHORT)
        toast.show()
    }
}
