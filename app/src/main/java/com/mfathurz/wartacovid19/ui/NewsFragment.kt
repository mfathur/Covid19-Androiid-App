package com.mfathurz.wartacovid19.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.network.CovidNetwork
import com.mfathurz.wartacovid19.ui.adapters.NewsListAdapter
import com.mfathurz.wartacovid19.viewmodels.NewsViewModel
import com.mfathurz.wartacovid19.viewmodels.NewsViewModelFactory
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    private lateinit var newsViewModel :NewsViewModel
    private val listAdapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory=NewsViewModelFactory(Repository(CovidNetwork))
        newsViewModel=ViewModelProvider(this,viewModelFactory).get(NewsViewModel::class.java)

        requireActivity().apply {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor=ContextCompat.getColor(requireContext(),R.color.colorDarkGrey)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.news.observe(viewLifecycleOwner, Observer {
            it.body()?.let {news->
                listAdapter.submitList(news.articles)
                newsRecyclerView.apply {
                    adapter=listAdapter
                    layoutManager=LinearLayoutManager(requireContext())
                    setHasFixedSize(true)
                }
            }
        })
    }

}