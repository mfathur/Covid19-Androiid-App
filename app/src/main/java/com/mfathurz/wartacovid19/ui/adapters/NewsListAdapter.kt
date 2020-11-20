package com.mfathurz.wartacovid19.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.models.news.Article
import com.mfathurz.wartacovid19.ui.NewsFragmentDirections
import com.mfathurz.wartacovid19.utils.Utils
import kotlinx.android.synthetic.main.item_rv_news.view.*

class NewsListAdapter : ListAdapter<Article, NewsListAdapter.NewsViewHolder>(NEWS_COMPARATOR) {
    inner class NewsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: Article) {
            with(view) {
                img_item_news.load(data.urlToImage) {
                    crossfade(true)
                    error(R.drawable.ic_image_placeholder)
                }
                txt_item_title_news.text = data.title
                txt_item_content_news.text = data.content
                txt_item_publishedAt.text = Utils.formatDate(data.publishedAt)
                btn_readMore.setOnClickListener {
                    val actionToDetailNews = NewsFragmentDirections.toDetailNewsFragment()
                    actionToDetailNews.newsUrl = data.url
                    Navigation.findNavController(it).navigate(actionToDetailNews)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        private val NEWS_COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

        }
    }
}