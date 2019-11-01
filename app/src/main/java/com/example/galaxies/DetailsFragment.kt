package com.example.galaxies


import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.fragment_details.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {

    private var details: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        details = arguments?.getString("itemDetails")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item_details.movementMethod = ScrollingMovementMethod()
        if(details != null) item_details.text = details
        else item_details.text = getString(R.string.nothing_selected)

    }

    companion object {
        fun newInstance(details: String?) : Fragment = DetailsFragment().apply {
            if (!details.isNullOrEmpty())
                arguments = bundleOf("itemDetails" to details)
        }
    }

}
