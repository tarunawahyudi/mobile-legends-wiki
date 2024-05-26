package com.tarunawahyudi.mobilelegends

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val photo: Int,
    val role: String,
    val story: String,
    val imageDetail: Int,
): Parcelable
