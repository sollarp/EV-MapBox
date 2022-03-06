package com.example.evmapbox.data

import javax.inject.Inject

class testImpl @Inject constructor() {
    fun provideTestString1() = "This is a string we will inject"

}