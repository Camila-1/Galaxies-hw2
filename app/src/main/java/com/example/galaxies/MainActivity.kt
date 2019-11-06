package com.example.galaxies

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_list.*


class MainActivity : AppCompatActivity() {
    private var checkedItem: Item? = null

    private val listFragment: ListFragment = ListFragment()
    private val detailsFragment: DetailsFragment = DetailsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkedItem = savedInstanceState?.getParcelable("item")
        render(checkedItem)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
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
        val orientation: Int = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            transaction.replace(R.id.details_fragment, DetailsFragment.newInstance(item))
                .commit()
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            transaction.replace(R.id.fragment, DetailsFragment.newInstance(item))
                .commit()
        }
    }

    private fun render(item: Item?) {
        val orientation: Int = resources.configuration.orientation
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        if (item != null) {
            if (orientation == Configuration.ORIENTATION_PORTRAIT)
                transaction.replace(R.id.fragment, DetailsFragment.newInstance(item)).commit()
            if (orientation == Configuration.ORIENTATION_LANDSCAPE)
                transaction.replace(R.id.list_fragment, listFragment)
                    .replace(R.id.details_fragment, DetailsFragment.newInstance(item)).commit()
        } else {
            if (orientation == Configuration.ORIENTATION_PORTRAIT)
                transaction.replace(R.id.fragment, listFragment).commit()
            if (orientation == Configuration.ORIENTATION_LANDSCAPE)
                transaction.replace(R.id.list_fragment, listFragment)
                    .replace(R.id.details_fragment, DetailsFragment.newInstance(item)).commit()
        }
    }

    override fun onBackPressed() {
        checkedItem = null

        val orientation: Int = resources.configuration.orientation
        if(
            recycler_view == null &&
            orientation == Configuration.ORIENTATION_PORTRAIT
        ) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, listFragment)
                    .commit()
        } else super.onBackPressed()
    }
}

