package com.mfathurz.wartacovid19.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.di.Injection
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import com.mfathurz.wartacovid19.models.ProvinceData
import com.mfathurz.wartacovid19.ui.adapters.ProvinceListAdapter
import com.mfathurz.wartacovid19.utils.Utils
import com.mfathurz.wartacovid19.viewmodels.DetailIndonesiaViewModel
import com.mfathurz.wartacovid19.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_detail_indonesia.*

class DetailIndonesiaFragment : Fragment() {

    private lateinit var detailIndonesiaViewModel: DetailIndonesiaViewModel
    private var indoSummary: IndoSummaryModel? = null
    private val adapter = ProvinceListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = ViewModelFactory.getInstance(Injection.provideRepository(requireContext()))
        detailIndonesiaViewModel = ViewModelProvider(this, factory)
            .get(DetailIndonesiaViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_indonesia, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabAnim()
        buttonClick()

        arguments?.let {
            indoSummary = DetailIndonesiaFragmentArgs.fromBundle(it).indonesiaSummary
            num_head_positive.text = Utils.numberConverter(indoSummary?.cases as Int)
            num_head_death.text = Utils.numberConverter(indoSummary?.death as Int)
            num_head_recovered.text = Utils.numberConverter(indoSummary?.cured as Int)
        }

        detailIndonesiaViewModel.getCovidProvinceSummary().observe(viewLifecycleOwner, Observer {
            val list: ArrayList<ProvinceData> = ArrayList()
            it.body()?.let { provinceSummaryModel ->
                val iterator = provinceSummaryModel.data.listIterator()
                while (iterator.hasNext()) {
                    val item = iterator.next()
                    if (item.province != "Indonesia")
                        list.add(item)
                }
                adapter.submitList(list)
                detailRecyclerView.adapter = adapter
                detailRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                detailRecyclerView.setHasFixedSize(true)
            }
        })
    }

    private fun buttonClick() {
        fab_toGlobalSpreadDetail.setOnClickListener {
            val actionToGlobalDetail = DetailIndonesiaFragmentDirections.toDetailGlobalFragment()
            Navigation.findNavController(it).navigate(actionToGlobalDetail)
        }

        btn_backToHomeFragment.setOnClickListener { requireActivity().onBackPressed() }
    }

    private fun fabAnim() {
        detailRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                fab_toGlobalSpreadDetail?.let { fab ->
                    if (dy > 0 && fab.visibility == View.VISIBLE)
                        fab.hide()
                    else if (dy < 0 && fab.visibility != View.VISIBLE)
                        fab.show()
                }
            }
        })
    }


}