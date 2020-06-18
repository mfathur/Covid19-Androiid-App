package com.mfathurz.wartacovid19.database

import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.models.InfoCovidModel

object InfoAboutCovid {
        val symptoms:ArrayList<InfoCovidModel>
        get() {
                val list= arrayListOf<InfoCovidModel>()
                list.add(InfoCovidModel("symptom1","lorem ipsum", R.drawable.android))
                list.add(InfoCovidModel("symptom2","lorem ipsum", R.drawable.android))
                list.add(InfoCovidModel("symptom3","lorem ipsum", R.drawable.android))
                list.add(InfoCovidModel("symptom4","lorem ipsum", R.drawable.android))
                list.add(InfoCovidModel("symptom5","lorem ipsum", R.drawable.android))
                return list
        }

        val transmissions:ArrayList<InfoCovidModel>
                get() {
                        val list= arrayListOf<InfoCovidModel>()
                        list.add(InfoCovidModel("transmission1","lorem ipsum", R.drawable.android))
                        list.add(InfoCovidModel("transmission2","lorem ipsum", R.drawable.android))
                        list.add(InfoCovidModel("transmission3","lorem ipsum", R.drawable.android))
                        list.add(InfoCovidModel("transmission4","lorem ipsum", R.drawable.android))
                        list.add(InfoCovidModel("transmission5","lorem ipsum", R.drawable.android))
                        return list
                }

        val prevention:ArrayList<InfoCovidModel>
                get() {
                        val list= arrayListOf<InfoCovidModel>()
                        list.add(InfoCovidModel("prevention1","lorem ipsum", R.drawable.android))
                        list.add(InfoCovidModel("prevention2","lorem ipsum", R.drawable.android))
                        list.add(InfoCovidModel("prevention3","lorem ipsum", R.drawable.android))
                        list.add(InfoCovidModel("prevention4","lorem ipsum", R.drawable.android))
                        list.add(InfoCovidModel("prevention5","lorem ipsum", R.drawable.android))
                        return list
                }
}