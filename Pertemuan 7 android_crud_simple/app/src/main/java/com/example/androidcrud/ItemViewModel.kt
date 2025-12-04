
package com.example.androidcrud

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ItemViewModel(app: Application) : AndroidViewModel(app) {
    private val dao = AppDatabase.getDatabase(app).itemDao()
    private val repo = ItemRepository(dao)

    val items = repo.items

    fun add(name: String) = viewModelScope.launch { repo.add(name) }
    fun delete(item: Item) = viewModelScope.launch { repo.delete(item) }
}
