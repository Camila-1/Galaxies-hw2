package com.example.galaxies


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private var selectedItem: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        selectedItem = arguments?.getParcelable("selectedItem")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedItem?.image?.let { item_image.setImageResource(it) }
        selectedItem?.title?.let { item_title.text = it }
        selectedItem?.description?.let { item_description.text = it }
        item_details.text = selectedItem?.details ?: getString(R.string.nothing_selected)
    }

    fun setItem(item: Item?) {
        arguments = bundleOf("selectedItem" to item)
    }

}
