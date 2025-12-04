package com.example.crudapi.presenter

import android.util.Log
import com.example.crudapi.model.ResultStatus
import retrofit2.Call
import retrofit2.Response

class Presenter2 (val crudView: com.example.crudapi.UpdateAddActivity) {

    fun addData(name : String, hp : String, alamat : String){
        com.example.crudapi.network.NetworkConfig.getService()
            .addStaff(name, hp, alamat)
            .enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.errorAdd(t.localizedMessage ?: "Error")
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.successAdd(response.body()?.pesan ?: "")
                    }else {
                        crudView.errorAdd(response.body()?.pesan ?: "")
                    }
                }
            })
    }

    fun updateData(id: String, name: String, hp: String, alamat: String){
        com.example.crudapi.network.NetworkConfig.getService()
            .updateStaff(id, name, hp, alamat)
            .enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorUpdate(t.localizedMessage ?: "Error")
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    }else{
                        crudView.onErrorUpdate(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}
