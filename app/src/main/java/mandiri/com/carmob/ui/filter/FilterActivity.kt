package mandiri.com.carmob.ui.filter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_toolbar_no_icon.*
import mandiri.com.carmob.R

class FilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        tvToolbarInfoTitle.text = "Filter"

        ivToolbarBack.setOnClickListener {
            onBackPressed()
        }
    }
}
