package mandiri.com.carmob.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import mandiri.com.carmob.R

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        vpMenu.adapter = MenuViewPagerAdapter(supportFragmentManager)
        tbMenu.setupWithViewPager(vpMenu)
    }
}
