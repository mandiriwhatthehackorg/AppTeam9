package mandiri.com.carmob.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CarListResponse (
    @SerializedName("result") val result: Result
){
    data class Result(
        @SerializedName("cars") var cars : MutableList<Cars>
    ) : Serializable
}