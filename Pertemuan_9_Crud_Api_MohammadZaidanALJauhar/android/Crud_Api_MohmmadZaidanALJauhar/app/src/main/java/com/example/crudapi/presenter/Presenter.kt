package com.example.crudapi.presenter

import android.util.Log
import com.example.crudapi.model.ResultStaff
import retrofit2.Call
import retrofit2.Response

class Presenter(val crudView: com.example.crudapi.MainActivity) {

    fun getData(){
        com.example.crudapi.network.NetworkConfig.getService().getData()
            .enqueue(object : retrofit2.Callback<ResultStaff>{
                override fun onFailure(call: Call<ResultStaff>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage ?: "Error")
                    Log.d("Error", "Error Data: ${t.localizedMessage}")
                }

                override fun onResponse(call: Call<ResultStaff>, response: Response<ResultStaff>) {
                    if(response.isSuccessful){
                        val status = response.body()?.status
                        if (status == 200){
                            val data = response.body()?.staff
                            crudView.onSuccessGet(data)
                        } else{
                            crudView.onFailedGet("Error $status")
                        }
                    } else {
                        crudView.onFailedGet("Response not successful: ${response.code()}")
                    }
                }
            })
    }

    fun hapusData(id: String?){
        com.example.crudapi.network.NetworkConfig.getService()
            .deleteStaff(id)
            .enqueue(object : retrofit2.Callback<com.example.crudapi.model.ResultStatus>{
                override fun onFailure(call: Call<com.example.crudapi.model.ResultStatus>, t: Throwable) {
                    crudView.onErrorDelete(t.localizedMessage ?: "Error")
                }

                override fun onResponse(call: Call<com.example.crudapi.model.ResultStatus>, response: Response<com.example.crudapi.model.ResultStatus>) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.onSuccessDelete(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorDelete(response.body()?.pesan ?: "" )
                    }
                }
            })
    }
}
