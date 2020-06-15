package com.mfathurz.wartacovid19.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.network.CovidNetwork
import com.mfathurz.wartacovid19.viewmodels.HomeViewModel
import com.mfathurz.wartacovid19.viewmodels.HomeViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var homeViewModel:HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository=Repository(CovidNetwork)
        val homeViewModelFactory=HomeViewModelFactory(repository)
        homeViewModel=ViewModelProvider(this,homeViewModelFactory).get(HomeViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonClick()

        homeViewModel.indoCovidSummary.observe(viewLifecycleOwner, Observer {
          it.body()?.listIterator().let {item->
                val item=item!!.next()
                numPositive.text=item.positif
                numDeaths.text=item.meninggal
                numRecovered.text=item.sembuh
            }

        })
    }

    private fun buttonClick() {
        btn_goToDetail.setOnClickListener {
            val actionToDetail=HomeFragmentDirections.toDetailIndonesiaFragment()
            Navigation.findNavController(it).navigate(actionToDetail)
        }
    }
}