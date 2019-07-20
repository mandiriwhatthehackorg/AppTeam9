package mandiri.com.carmob.ui.car.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_car_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import mandiri.com.carmob.R

class CarDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)

        ivToolbarBack.setOnClickListener {
            onBackPressed()
        }

        tvToolbarInfoTitle.text = "Deskripsi"

        btnPilih.setOnClickListener {
            val bottomSheetFragment = BottomSheetDialog()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

        Glide.with(this)
            .load("https://img.pngio.com/white-rolls-royce-ghost-luxury-car-png-image-luxury-car-png-500_228.png")
            .into(ivCarImage)
    }

}
