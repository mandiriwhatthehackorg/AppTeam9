package mandiri.com.carmob.ui.car.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import angga.com.movielist.network.service.ServiceGenerator
import kotlinx.android.synthetic.main.activity_car_list.*
import mandiri.com.carmob.R
import mandiri.com.carmob.model.CarListResponse
import mandiri.com.carmob.network.CarMobService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarListActivity : AppCompatActivity() {

    var carMobService : CarMobService = ServiceGenerator.createService(CarMobService::class.java)

    private val carListAdapter : CarListAdapter by lazy {
        CarListAdapter()
    }

    private val carListFavoriteListAdapter : CarFavoriteListAdapter by lazy {
        CarFavoriteListAdapter()
    }

    private val gridLayoutManager by lazy {
        GridLayoutManager(this, 2)
    }

    private val linearLayoutManager by lazy {
        LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_list)

        carMobService.getCarList().enqueue(object : Callback<CarListResponse> {

            override fun onFailure(call: Call<CarListResponse>, t: Throwable) {
                Toast.makeText(this@CarListActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<CarListResponse>, response: Response<CarListResponse>) {
                response?.body()?.result?.cars?.get(0)?.mutableList?.let {
                    carListAdapter.setData(it)
                    carListFavoriteListAdapter.setData(it)
                }

                response?.body()?.result?.cars?.get(1)?.mutableList?.let {
                    carListFavoriteListAdapter.setData(it)
                }
            }

        })

        rvGoodChoice.apply {
            layoutManager = gridLayoutManager
            adapter = carListAdapter
            isNestedScrollingEnabled = false
        }

        rvFavoriteCars.apply {
            layoutManager = linearLayoutManager
            adapter = carListFavoriteListAdapter
            isNestedScrollingEnabled = false
        }
    }
}
