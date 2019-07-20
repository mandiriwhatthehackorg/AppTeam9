package mandiri.com.carmob.ui.car.detail.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CarDetailViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                EngineFragment()
            } 1 -> {
                BodyFragment()
            } 2 -> {
                OtherFragment()
            } 3 -> {
                EntertainmentFragment()
            } else -> {
                SafetyFragment()
            }
        }
    }

    override fun getCount(): Int {
       return  5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> {"Mesin"}
            1 -> {"Bodi"}
            2 -> {"Rangka dan Kaki - Kaki"}
            3-> {"Hiburan"}
            else -> {"Keselamatan"}
        }
    }
}