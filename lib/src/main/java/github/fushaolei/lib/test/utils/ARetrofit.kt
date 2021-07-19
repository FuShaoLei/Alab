package github.fushaolei.lib.test.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ARetrofit {

    fun <T> getService(url: String, service: Class<T>): T? {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(service)
    }
}