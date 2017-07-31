package us.narin.app.caption.api.request

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import us.narin.app.caption.models.RanksResult

/**
 * Created by endlessdev on 6/25/17.
 */

interface RankRequest {

    @GET("rank/{rank}/")
    fun getRanks(
            @Path("rank") category: String
    ): Call<RanksResult>
}
