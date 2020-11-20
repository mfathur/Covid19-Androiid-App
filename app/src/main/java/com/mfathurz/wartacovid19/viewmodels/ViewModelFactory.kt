package com.mfathurz.wartacovid19.viewmodels


import androidx.lifecycle.ViewModelProvider
import com.mfathurz.wartacovid19.Repository

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

//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return when{
////            modelClass.isAssignableFrom()
//        }
//    }
}