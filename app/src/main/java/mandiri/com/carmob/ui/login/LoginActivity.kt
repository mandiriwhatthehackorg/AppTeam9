package mandiri.com.carmob.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import mandiri.com.carmob.R
import mandiri.com.carmob.ui.car.list.CarListActivity
import mandiri.com.carmob.ui.menu.MenuActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val mainMenu = Intent(this, MenuActivity::class.java)
            startActivity(mainMenu)
        }
    }
}
