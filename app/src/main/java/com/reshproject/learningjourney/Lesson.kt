package com.reshproject.learningjourney

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lesson(
    val name: String,
) : Parcelable