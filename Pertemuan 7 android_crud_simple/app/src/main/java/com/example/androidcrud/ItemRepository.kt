
package com.example.androidcrud

class ItemRepository(private val dao: ItemDao) {
    val items = dao.getAll()
    suspend fun add(name: String) = dao.insert(Item(name=name))
    suspend fun update(item: Item) = dao.update(item)
    suspend fun delete(item: Item) = dao.delete(item)
}
