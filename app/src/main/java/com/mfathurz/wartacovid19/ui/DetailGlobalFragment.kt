package com.mfathurz.wartacovid19.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mfathurz.wartacovid19.R
import kotlinx.android.synthetic.main.fragment_detail_global.*

class DetailGlobalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_global, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonClick()
    }

    private fun buttonClick() {
        btn_backToDetailIndonesia.setOnClickListener { requireActivity().onBackPressed() }
    }

}