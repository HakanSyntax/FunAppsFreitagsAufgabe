package de.syntax_institut.funappsvorlage.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntax_institut.funappsvorlage.data.datamodels.Result
import de.syntax_institut.funappsvorlage.data.remote.SearchApi
import java.lang.Exception

const val TAG = "AppRepository"

class AppRepository(private val api: SearchApi) {

    private val _results = MutableLiveData<List<Result>>()
    val results: LiveData<List<Result>>
        get() = _results

    suspend fun getResults(term: String) {
        try {
            val resultList = api.retrofitService.getResults(term)
            _results.value = resultList.results
        } catch (e: Exception) {
            Log.e(TAG, "Error loading Data from API: $e")
        }
    }
}
