package com.mfathurz.wartacovid19.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.di.Injection
import com.mfathurz.wartacovid19.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel
    private val listAdapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ViewModelFactory.getInstance(Injection.provideRepository(requireContext()))
        newsViewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)

        requireActivity().apply {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.colorDarkGrey)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

        newsViewModel.news.observe(viewLifecycleOwner, Observer { list ->
            listAdapter.submitList(list)
        })
    }
}