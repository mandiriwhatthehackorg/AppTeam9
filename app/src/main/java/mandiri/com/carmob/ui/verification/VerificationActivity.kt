package mandiri.com.carmob.ui.verification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_verification.*
import kotlinx.android.synthetic.main.layout_toolbar_no_icon.*
import mandiri.com.carmob.R
import mandiri.com.carmob.ui.order.OrderFinalActivity

class VerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        tvToolbarInfoTitle.text = "Verifikasi Data"

        tvToolbarInfoTitle.setOnClickListener {
            onBackPressed()
        }

        btnLanjutkan.setOnClickListener {
            val orderIntent = Intent(this@VerificationActivity, OrderFinalActivity::class.java)
            startActivity(orderIntent)
        }
    }
}
