package com.mfathurz.wartacovid19.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mfathurz.wartacovid19.data.Repository

class ViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(repository: Repository): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(repository)
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailGlobalViewModel::class.java) -> {
                DetailGlobalViewModel(repository) as T
            }

            modelClass.isAssignableFrom(DetailIndonesiaViewModel::class.java) -> {
                DetailIndonesiaViewModel(repository) as T
            }

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(repository) as T
            }

            modelClass.isAssignableFrom(NewsViewModel::class.java) -> {
                NewsViewModel(repository) as T
            }

            else -> throw IllegalStateException("Unknown ViewModel class : ${modelClass.name}")
        }
    }
}