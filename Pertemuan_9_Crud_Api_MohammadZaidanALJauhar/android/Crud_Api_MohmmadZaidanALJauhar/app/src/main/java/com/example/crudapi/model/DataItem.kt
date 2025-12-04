package com.example.crudapi.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataItem(
    @field:SerializedName("staff_name") val staffName: String? = null,
    @field:SerializedName("staff_id") val staffId: String? = null,
    @field:SerializedName("staff_hp") val staffHp: String? = null,
    @field:SerializedName("staff_alamat") val staffAlamat: String? = null
) : Serializable
