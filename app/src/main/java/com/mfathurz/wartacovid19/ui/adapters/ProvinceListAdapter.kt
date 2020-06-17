package com.mfathurz.wartacovid19.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.models.Data
import com.mfathurz.wartacovid19.utils.Utils
import kotlinx.android.synthetic.main.item_rv_spread_detail.view.*

class ProvinceListAdapter :ListAdapter<Data, ProvinceListAdapter.ProvinceViewHolder>(ProvinceCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_spread_detail,parent,false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) =holder.bind(getItem(position))

    inner class ProvinceViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        fun bind(data : Data){
            with(view){
                txt_item_area.text=data.provinsi
                num_item_positive.text=Utils.numberConverter(data.kasusPosi)
                num_item_recovered.text=Utils.numberConverter(data.kasusSemb)
                num_item_death.text=Utils.numberConverter(data.kasusMeni)
            }
        }
    }
}

private class ProvinceCallBack:DiffUtil.ItemCallback<Data>(){
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.provinsi==newItem.provinsi
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem==newItem
    }

}