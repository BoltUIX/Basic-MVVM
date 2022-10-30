package com.boltuix.mvvm.model.repository

import com.boltuix.mvvm.model.api.MyImageUrlService


class MyImageRepository() {

    private val service = MyImageUrlService()

    fun getRandomImageUrl(): String {
        return service.getImageUrl()
    }
}