package com.mfathurz.wartacovid19.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.models.Country
import com.mfathurz.wartacovid19.utils.Utils
import kotlinx.android.synthetic.main.item_rv_spread_detail.view.*

class CountryListAdapter : ListAdapter<Country, CountryListAdapter.CountryViewHolder>(
    COUNTRY_COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rv_spread_detail, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class CountryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(countryData: Country) {
            with(view) {
                txt_item_area.text = countryData.Country
                num_item_positive.text = Utils.numberConverter(countryData.TotalConfirmed)
                num_item_death.text = Utils.numberConverter(countryData.TotalDeaths)
                num_item_recovered.text = Utils.numberConverter(countryData.TotalRecovered)
            }
        }
    }

    companion object {
        private val COUNTRY_COMPARATOR = object : DiffUtil.ItemCallback<Country>() {
            override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
                return oldItem.Country == newItem.Country
            }

            override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
                return oldItem == newItem
            }

        }
    }
}