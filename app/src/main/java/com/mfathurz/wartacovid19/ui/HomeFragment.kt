package com.mfathurz.wartacovid19.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import com.mfathurz.wartacovid19.network.CovidNetwork
import com.mfathurz.wartacovid19.utils.Utils
import com.mfathurz.wartacovid19.viewmodels.HomeViewModel
import com.mfathurz.wartacovid19.viewmodels.HomeViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var homeViewModel:HomeViewModel
    private var positive=0
    private var death=0
    private var recovered=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository=Repository(CovidNetwork)
        val homeViewModelFactory=HomeViewModelFactory(repository)
        homeViewModel=ViewModelProvider(this,homeViewModelFactory).get(HomeViewModel::class.java)

        requireActivity().apply {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor= ContextCompat.getColor(requireContext(),R.color.colorPrimaryDark)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonClick()

        homeViewModel.indoCovidSummary.observe(viewLifecycleOwner, Observer {
          it.body()?.let {item->
              numPositive.text=Utils.numberConverter(item.jumlahKasus)
              numDeaths.text=Utils.numberConverter(item.meninggal)
              numRecovered.text=Utils.numberConverter(item.sembuh)
              positive=item.jumlahKasus
              death=item.meninggal
              recovered=item.sembuh
            }
        })
    }

    private fun buttonClick() {
        btn_goToDetail.setOnClickListener {
            val actionToDetail=HomeFragmentDirections.toDetailIndonesiaFragment()
            actionToDetail.indonesiaSummary= IndoSummaryModel(positive,death,recovered)
            Navigation.findNavController(it).navigate(actionToDetail)
        }
    }
}