package mandiri.com.carmob.ui.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import angga.com.movielist.network.service.ServiceGenerator
import kotlinx.android.synthetic.main.fragment_dashboard.*

import mandiri.com.carmob.R
import mandiri.com.carmob.model.CarListResponse
import mandiri.com.carmob.network.CarMobService
import mandiri.com.carmob.ui.car.list.CarFavoriteListAdapter
import mandiri.com.carmob.ui.car.list.CarListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DashboardFragment : Fragment() {

    var carMobService : CarMobService = ServiceGenerator.createService(CarMobService::class.java)

    private val carListAdapter : CarListAdapter by lazy {
        CarListAdapter()
    }

    private val carListFavoriteListAdapter : CarFavoriteListAdapter by lazy {
        CarFavoriteListAdapter()
    }

    private val gridLayoutManager by lazy {
        GridLayoutManager(context, 2)
    }

    private val linearLayoutManager by lazy {
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        carMobService.getCarList().enqueue (object : Callback<CarListResponse> {

            override fun onFailure(call: Call<CarListResponse>, t: Throwable) {
                Toast.makeText(getContext(), t.message, Toast.LENGTH_SHORT).show()
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
            layoutManager =  GridLayoutManager(context, 2)
            adapter = carListAdapter
            isNestedScrollingEnabled = false
        }

        rvFavoriteCars.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = carListFavoriteListAdapter
            isNestedScrollingEnabled = false
        }
    }
}
