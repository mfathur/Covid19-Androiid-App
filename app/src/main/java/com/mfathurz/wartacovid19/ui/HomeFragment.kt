package com.mfathurz.wartacovid19.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    private var onTreatment=0

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonClick()

        homeViewModel.indoCovidSummary.observe(viewLifecycleOwner, Observer {
          it.body()?.let {

              val iterator=it.Countries.listIterator()
              while (iterator.hasNext()){
                  txt_date.text=Utils.formatDate(it.Date)
                  val item =iterator.next()
                  if (item.Country=="Indonesia"){
                      numPositive.text=Utils.numberConverter(item.TotalConfirmed)
                      numRecovered.text=Utils.numberConverter(item.TotalRecovered)
                      numDeaths.text=Utils.numberConverter(item.TotalDeaths)
                      txt_new_positive.text="+${Utils.numberConverter(item.NewConfirmed)}"
                      txt_new_death.text="+${Utils.numberConverter(item.NewDeaths)}"
                      txt_new_recovered.text="+${Utils.numberConverter(item.NewRecovered)}"
                      positive=item.TotalConfirmed
                      death=item.TotalDeaths
                      onTreatment=item.TotalRecovered

                      if (item.NewConfirmed==0) txt_new_positive.visibility=View.GONE
                      if (item.NewDeaths==0) txt_new_death.visibility=View.GONE
                      if (item.NewRecovered==0) txt_new_recovered.visibility=View.GONE
                      break
                  }
              }
            }
        })
    }

    private fun buttonClick() {
        btn_goToDetail.setOnClickListener {
            val actionToDetail=HomeFragmentDirections.toDetailIndonesiaFragment()
            actionToDetail.indonesiaSummary= IndoSummaryModel(positive,death,onTreatment)
            Navigation.findNavController(it).navigate(actionToDetail)
        }
    }
}