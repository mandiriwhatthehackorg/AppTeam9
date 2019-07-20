package mandiri.com.carmob.network

import mandiri.com.carmob.model.CarListResponse
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface CarMobService {

    @GET("list-car")
    fun getCarList() : Call<CarListResponse>
}