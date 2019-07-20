package mandiri.com.carmob.ui.menu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MenuViewPagerAdapter (fragmentManager: FragmentManager)
    : FragmentPagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                DashboardFragment()
            }1 -> {
                ProfileFragment()
            }2 -> {
                OrderFragment()
            }else -> {
                HistoryFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> {"Beranda"}
            1 -> {"Profile"}
            2 -> {"Pesanan"}
            else -> {"Aktivitas"}
        }
    }
}