package mandiri.com.carmob.ui.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_order_final.*
import kotlinx.android.synthetic.main.layout_toolbar_no_icon.*
import mandiri.com.carmob.R

class OrderFinalActivity : AppCompatActivity() {

    var paymentType : String ? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_final)

        ivToolbarBack.setOnClickListener {
            onBackPressed()
        }

        tvToolbarInfoTitle.text = "Detail Pesanan"

        paymentType = intent.getStringExtra("paymentType")

        if(paymentType.equals("Cash")){
            kreditType.text = "Cash"
        }else {
            kreditType.text = "Kredit"
        }

        checkTestDrive.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if(p1) {
                    testDriveLayout.visibility = View.VISIBLE
                }else {
                    testDriveLayout.visibility = View.GONE
                }
            }
        })
    }
}
