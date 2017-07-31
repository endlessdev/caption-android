package us.narin.app.caption.api

import retrofit2.Retrofit
import us.narin.app.caption.BuildConfig
import us.narin.app.caption.api.request.RankRequest

/**
 * Created by endlessdev on 6/25/17.
 */

object RequestUtils {

    private val BASE_URL = BuildConfig.API_ENDPOINT

    val rankService: RankRequest
        get() = requestClientInstance.create(RankRequest::class.java)

    private val requestClientInstance: Retrofit
        get() = HttpClient.getInstance(BASE_URL)


}
