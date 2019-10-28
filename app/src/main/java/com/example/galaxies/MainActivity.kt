package com.example.galaxies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

data class Item(val image: Int, val title: String, val description: String)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view_main.layoutManager = LinearLayoutManager(this)
        recycler_view_main.adapter = Adapter(initItems()) {
            val toast: Toast = Toast.makeText(applicationContext, "${it.title} clicked", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initItems() = listOf(
        Item(R.drawable.milky_way, getString(R.string.milky_way_title), getString(R.string.milky_way_description)),
        Item(R.drawable.messier_61, getString(R.string.messier_61_title), getString(R.string.messier_61_description)),
        Item(R.drawable.m51, getString(R.string.m51_title), getString(R.string.m51_description)),
        Item(R.drawable.hoags_object, getString(R.string.hoags_object_title), getString(R.string.hoags_object_description)),
        Item(R.drawable.ngc_1300, getString(R.string.ngc_1300_title), getString(R.string.ngc_1300_description)),
        Item(R.drawable.ngc_1672, getString(R.string.ngc_1672_title), getString(R.string.ngc_1672_description)),
        Item(R.drawable.ngc_247, getString(R.string.ngc_247_title), getString(R.string.ngc_247_description)),
        Item(R.drawable.ngc_5584, getString(R.string.ngc_5584_title), getString(R.string.ngc_5584_description)),
        Item(R.drawable.ngc_6240, getString(R.string.ngc_6240_title), getString(R.string.ngc_6240_description)),
        Item(R.drawable.ngc_6872, getString(R.string.ngc_6872_title), getString(R.string.ngc_6872_description))
    )
}
