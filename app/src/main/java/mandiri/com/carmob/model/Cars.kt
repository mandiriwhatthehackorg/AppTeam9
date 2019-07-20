package mandiri.com.carmob.model

import com.google.gson.annotations.SerializedName

data class Cars (
    @SerializedName("id") val id : Int,
    @SerializedName("rating_name") val ratiingName : String,
    @SerializedName("rating_status") val ratingStatus : String,
    @SerializedName("answers") val mutableList: MutableList<ListCar>
) {
    data class ListCar(
        @SerializedName ("id") val id : Int,
        @SerializedName ("name_mobil") val namaMobil : String,
        @SerializedName ("harga_mobil") val hargaMobil : String,
        @SerializedName ("nama_dealer") val namaDealer : String,
        @SerializedName ("rating") val rating : Int,
        @SerializedName ("image_url") val imageUrl : String
    )
}
