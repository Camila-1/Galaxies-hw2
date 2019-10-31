package com.example.galaxies

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
//    private val listFragment = ListFragment()
//    private val detailsFragment = DetailsFragment()
    private var checkedItem: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orientation: Int = resources.configuration.orientation
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            transaction.replace(R.id.list_fragment, ListFragment()).replace(R.id.details_fragment, DetailsFragment()).commit()
        } else if(orientation == Configuration.ORIENTATION_PORTRAIT){
            transaction.replace(R.id.fragment, ListFragment()).commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelable("item", checkedItem)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        checkedItem = savedInstanceState.getParcelable("item")
    }

    fun itemClicked(item: Item) {
        checkedItem = item
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, DetailsFragment.newInstance(item.details))
            .addToBackStack(null)
            .commit()
    }

//    private fun renderPortrait() {
//        val fragmentManager = supportFragmentManager
//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.list_fragment, DetailsFragment.newInstance(item.details))
//            .addToBackStack(null)
//            .commit()
//    }
}
