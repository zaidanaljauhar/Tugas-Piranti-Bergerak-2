package com.example.crudapi.service

import com.example.crudapi.model.ResultStaff
import com.example.crudapi.model.ResultStatus
import retrofit2.Call
import retrofit2.http.*

interface StaffService {

    @FormUrlEncoded
    @POST("add-staff")
    fun addStaff(@Field("name") name : String,
                 @Field("hp") hp : String,
                 @Field("alamat") alamat : String) : Call<ResultStatus>

    @GET("get-staff")
    fun getData() : Call<ResultStaff>

    @FormUrlEncoded
    @POST("delete-staff")
    fun deleteStaff(@Field("id") id: String?) : Call<ResultStatus>

    @FormUrlEncoded
    @POST("update-staff")
    fun updateStaff(@Field("id") id: String,
                    @Field("name") name: String,
                    @Field("hp") hp : String,
                    @Field("alamat") alamat : String) : Call<ResultStatus>
}
