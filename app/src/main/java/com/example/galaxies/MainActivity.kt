package com.example.galaxies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
//    private val listFragment = ListFragment()
//    private val detailsFragment = DetailsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.list_fragment, ListFragment()).commit()
    }

    fun itemClicked(item: Item) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.list_fragment, DetailsFragment.newInstance(item.details))
            .addToBackStack(null)
            .commit()
    }
}
