package com.mfathurz.wartacovid19.ui.covid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.models.InfoCovidModel
import kotlinx.android.synthetic.main.item_rv_about_covid.view.*

class InfoCovidRecyclerAdapter(private val infoCovid: ArrayList<InfoCovidModel>) :
    RecyclerView.Adapter<InfoCovidRecyclerAdapter.SymptomViewHolder>() {

    inner class SymptomViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_about_covid, parent, false)
        return SymptomViewHolder(view)
    }

    override fun getItemCount(): Int = infoCovid.size

    override fun onBindViewHolder(holder: SymptomViewHolder, position: Int) {
        holder.view.txt_item_title_covid.text = infoCovid[position].title
        holder.view.img_item_info_covid.load(infoCovid[position].image) {
            crossfade(true)
        }
    }

}