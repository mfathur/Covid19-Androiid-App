package com.mfathurz.wartacovid19.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mfathurz.wartacovid19.R
import kotlinx.android.synthetic.main.fragment_spread_detail.*

class SpreadDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spread_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && fab_toGlobalSpreadDetail.visibility == View.VISIBLE) {
                    fab_toGlobalSpreadDetail.hide();
                } else if (dy < 0 && fab_toGlobalSpreadDetail.visibility != View.VISIBLE) {
                    fab_toGlobalSpreadDetail.show();
                }
            }
        })
    }

}