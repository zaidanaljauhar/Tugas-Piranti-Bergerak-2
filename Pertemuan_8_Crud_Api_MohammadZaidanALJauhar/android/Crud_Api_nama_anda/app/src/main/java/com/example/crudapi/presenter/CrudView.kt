package com.example.crudapi.presenter

import com.example.crudapi.model.DataItem

interface CrudView {
    fun onSuccessGet(data: List<DataItem>?)
    fun onFailedGet(msg : String)

    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg: String)

    fun successAdd(msg : String)
    fun errorAdd(msg: String)

    fun onSuccessUpdate(msg : String)
    fun onErrorUpdate(msg : String)
}
