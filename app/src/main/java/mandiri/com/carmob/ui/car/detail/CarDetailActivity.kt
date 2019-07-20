package mandiri.com.carmob.ui.car.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_car_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import mandiri.com.carmob.R
import mandiri.com.carmob.ui.car.detail.fragment.CarDetailViewPagerAdapter

class CarDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)

        ivToolbarBack.setOnClickListener {
            onBackPressed()
        }

        tvToolbarInfoTitle.text = "Deskripsi"

        configViewPager()
    }

    private fun configViewPager(){
        vpCarDetail.adapter = CarDetailViewPagerAdapter(supportFragmentManager)
        tlCarDetail.setupWithViewPager(vpCarDetail)
    }
}
