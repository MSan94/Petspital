package com.example.petspital.util.room.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hosp(
    @PrimaryKey var uid: String,
    @ColumnInfo(name="address") var address: String?,
    @ColumnInfo(name="appData") var appData: String?,
    @ColumnInfo(name="entId") var endId: String?,
    @ColumnInfo(name="gugun") var gugun: String?,
    @ColumnInfo(name="title") var title: String?
)