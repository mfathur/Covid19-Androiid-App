package com.mfathurz.wartacovid19.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.di.Injection
import com.mfathurz.wartacovid19.ui.adapters.CountryListAdapter
import com.mfathurz.wartacovid19.utils.Utils
import com.mfathurz.wartacovid19.viewmodels.DetailGlobalViewModel
import com.mfathurz.wartacovid19.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_detail_global.*

class DetailGlobalFragment : Fragment() {

    private lateinit var detailGlobalViewModel: DetailGlobalViewModel
    private val adapter = CountryListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ViewModelFactory.getInstance(Injection.provideRepository(requireContext()))
        detailGlobalViewModel = ViewModelProvider(this, factory)
            .get(DetailGlobalViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_global, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonClick()

        detailGlobalViewModel.covidGlobalSummary.observe(viewLifecycleOwner, Observer {
            it.body()?.let { data ->
                num_head_positive.text = Utils.numberConverter(data.Global.TotalConfirmed)
                num_head_death.text = Utils.numberConverter(data.Global.TotalDeaths)
                num_head_recovered.text = Utils.numberConverter(data.Global.TotalRecovered)

                adapter.submitList(data.Countries)
                detailGlobalRecyclerView.adapter = adapter
                detailGlobalRecyclerView.setHasFixedSize(true)
                detailGlobalRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            }
        })

    }

    private fun buttonClick() {
        btn_backToDetailIndonesia.setOnClickListener { requireActivity().onBackPressed() }
    }

}