package de.syntax_institut.funappsvorlage.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.funappsvorlage.data.AppRepository
import de.syntax_institut.funappsvorlage.data.remote.SearchApi
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _inputText = MutableLiveData<String>()
    val inputText: LiveData<String>
        get() = _inputText

    private val repository = AppRepository(SearchApi)

    val results = repository.results

    fun loadData(term: String) {
        viewModelScope.launch {
            repository.getResults(term)
        }
    }

    fun updateInputText(text: String) {
        _inputText.value = text
    }
}
