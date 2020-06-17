package com.mfathurz.wartacovid19.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.models.Data
import com.mfathurz.wartacovid19.network.CovidNetwork
import com.mfathurz.wartacovid19.ui.adapters.ProvinceListAdapter
import com.mfathurz.wartacovid19.viewmodels.DetailIndonesiaViewModel
import com.mfathurz.wartacovid19.viewmodels.DetailIndonesiaViewModelFactory
import kotlinx.android.synthetic.main.fragment_detail_indonesia.*

class DetailIndonesiaFragment : Fragment() {

    lateinit var detailIndonesiaViewModel : DetailIndonesiaViewModel

    private val adapter=
        ProvinceListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository=Repository(CovidNetwork)
        val viewModelFactory=DetailIndonesiaViewModelFactory(repository)
        detailIndonesiaViewModel=ViewModelProvider(this,viewModelFactory)
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

        detailIndonesiaViewModel.covidProvinceSummary.observe(viewLifecycleOwner, Observer {
            val list : ArrayList<Data> = ArrayList()
            it.body()?.let {
                val iterator=it.data.listIterator()
                while (iterator.hasNext()){
                    val item=iterator.next()
                    if (item.provinsi!="Indonesia")
                    list.add(item)
                }
                adapter.submitList(list)
                detailRecyclerView.adapter=adapter
                detailRecyclerView.layoutManager=LinearLayoutManager(requireContext())
            }
        })
    }

    private fun buttonClick() {
        fab_toGlobalSpreadDetail.setOnClickListener {
            val actionToGlobalDetail=DetailIndonesiaFragmentDirections.toDetailGlobalFragment()
            Navigation.findNavController(it).navigate(actionToGlobalDetail)
        }

        btn_backToHomeFragment.setOnClickListener { requireActivity().onBackPressed() }
    }

    private fun fabAnim(){
        detailRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && fab_toGlobalSpreadDetail.visibility == View.VISIBLE)
                    fab_toGlobalSpreadDetail.hide();

                else if (dy < 0 && fab_toGlobalSpreadDetail.visibility != View.VISIBLE)
                    fab_toGlobalSpreadDetail.show();
            }
        })
    }


}