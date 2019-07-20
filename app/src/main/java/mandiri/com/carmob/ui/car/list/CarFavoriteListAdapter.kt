package mandiri.com.carmob.ui.car.list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout_favorite.view.*
import mandiri.com.carmob.R
import mandiri.com.carmob.model.Cars
import mandiri.com.carmob.ui.car.detail.CarDetailActivity

class CarFavoriteListAdapter : RecyclerView.Adapter<CarFavoriteListAdapter.ViewHolder>() {

    var listCar = mutableListOf<Cars.ListCar>()

    lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_layout_favorite,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
       return listCar.size
    }

    fun setData(carList: MutableList<Cars.ListCar>) {
        this.listCar.clear()
        this.listCar.addAll(carList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(listCar[position])

        holder.itemView.setOnClickListener {
            val detailIntent = Intent(context, CarDetailActivity::class.java)
            context.startActivity(detailIntent)
        }
    }


    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        fun bind (listCar : Cars.ListCar) {
            with(itemView) {
                Glide.with(context)
                    .load(listCar.imageUrl)
                    .into(ivCarImage)
                tvCarName.text = listCar.namaMobil
                tvCarPrice.text = listCar.hargaMobil
                tvDealerName.text = listCar.namaDealer
                tvCarRating.rating = listCar.rating.toFloat()
            }
        }
    }
}