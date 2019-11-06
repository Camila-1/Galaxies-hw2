package com.example.galaxies

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_list.*

@Parcelize
data class Item(val image: Int, val title: String, val description: String, val details: String = "details") : Parcelable

class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = Adapter(initItems()) {
            (activity as MainActivity).itemClicked(it)
        }
    }

    private fun initItems() = listOf(
        Item(R.drawable.milky_way, getString(R.string.milky_way_title), getString(R.string.milky_way_description), getString(R.string.milky_way_details)),
        Item(R.drawable.messier_61, getString(R.string.messier_61_title), getString(R.string.messier_61_description), getString(R.string.messier_61_details)),
        Item(R.drawable.m51, getString(R.string.m51_title), getString(R.string.m51_description), getString(R.string.m51_details)),
        Item(R.drawable.hoags_object, getString(R.string.hoags_object_title), getString(R.string.hoags_object_description), getString(R.string.hoags_object_details)),
        Item(R.drawable.ngc_1300, getString(R.string.ngc_1300_title), getString(R.string.ngc_1300_description), getString(R.string.ngc_1300_details)),
        Item(R.drawable.m104, getString(R.string.m104_title), getString(R.string.m104_description), getString(R.string.m104_details)),
        Item(R.drawable.ngc_1672, getString(R.string.ngc_1672_title), getString(R.string.ngc_1672_description), getString(R.string.ngc_1672_details)),
        Item(R.drawable.ngc_247, getString(R.string.ngc_247_title), getString(R.string.ngc_247_description), getString(R.string.ngc_247_details)),
        Item(R.drawable.ngc_5584, getString(R.string.ngc_5584_title), getString(R.string.ngc_5584_description), getString(R.string.ngc_5584_details)),
        Item(R.drawable.ngc_6240, getString(R.string.ngc_6240_title), getString(R.string.ngc_6240_description), getString(R.string.ngc_6240_details)),
        Item(R.drawable.ngc_6872, getString(R.string.ngc_6872_title), getString(R.string.ngc_6872_description), getString(R.string.ngc_6872_details)),
        Item(R.drawable.m101, getString(R.string.m101_title), getString(R.string.m101_description), getString(R.string.m101_details)),
        Item(R.drawable.m74, getString(R.string.m74_title), getString(R.string.m74_description), getString(R.string.m74_details)),
        Item(R.drawable.m64, getString(R.string.m64_title), getString(R.string.m64_description), getString(R.string.m64_details)),
        Item(R.drawable.ngc_2903, getString(R.string.ngc_2903_title), getString(R.string.ngc_2903_description), getString(R.string.ngc_2903_details)),
        Item(R.drawable.ngc_1365, getString(R.string.ngc_1365_title), getString(R.string.ngc_1365_description), getString(R.string.ngc_1365_details)),
        Item(R.drawable.m81, getString(R.string.m81_title), getString(R.string.m81_description), getString(R.string.m81_details)),
        Item(R.drawable.m106, getString(R.string.m106_title), getString(R.string.m106_description), getString(R.string.m106_details)),
        Item(R.drawable.ngc_3628, getString(R.string.ngc_3628_title), getString(R.string.ngc_3628_description), getString(R.string.ngc_3628_details)),
        Item(R.drawable.ngc_1404, getString(R.string.ngc_1404_title), getString(R.string.ngc_1404_description), getString(R.string.ngc_1404_details)),
        Item(R.drawable.ngc_7714, getString(R.string.ngc_7714_title), getString(R.string.ngc_7714_description), getString(R.string.ngc_7714_details))
    )

}
