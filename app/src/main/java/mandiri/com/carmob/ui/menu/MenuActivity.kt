package mandiri.com.carmob.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import mandiri.com.carmob.R
import android.view.LayoutInflater
import android.widget.TextView



class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        vpMenu.adapter = MenuViewPagerAdapter(supportFragmentManager)
        tbMenu.setupWithViewPager(vpMenu)

        val tabOne = LayoutInflater.from(this).inflate(R.layout.nav_tab, null) as TextView
        tabOne.text = "Beranda"
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_home_active, 0, 0)
        tbMenu.getTabAt(0)?.customView = tabOne

        val tabTwo = LayoutInflater.from(this).inflate(R.layout.nav_tab, null) as TextView
        tabTwo.text = "Profile"
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_user_active, 0, 0)
        tbMenu.getTabAt(1)?.customView = tabTwo

        val tabThree = LayoutInflater.from(this).inflate(R.layout.nav_tab, null) as TextView
        tabThree.text = "Pesanan"
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_car_active, 0, 0)
        tbMenu.getTabAt(2)?.customView = tabThree

        val tabFour = LayoutInflater.from(this).inflate(R.layout.nav_tab, null) as TextView
        tabFour.text = "Aktifitas"
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_history_active, 0, 0)
        tbMenu.getTabAt(3)?.customView = tabFour
    }
}
