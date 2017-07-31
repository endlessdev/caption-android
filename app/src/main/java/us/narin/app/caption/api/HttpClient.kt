package us.narin.app.caption.api

import com.facebook.stetho.okhttp3.StethoInterceptor

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by endlessdev on 6/25/17.
 */

object HttpClient {

    private var retrofit: Retrofit? = null

    fun getInstance(baseUrl: String): Retrofit {

        val client = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit!!
    }
}
