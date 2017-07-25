package eu.gitcode.salesrepresentative.feature.main

import ClientProfilePagesEnum
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.SparseArray
import android.view.ViewGroup
import eu.gitcode.salesrepresentative.feature.shops.ShopsFragment

class MainFragmentsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    companion object {
        val PAGE_COUNT = ClientProfilePagesEnum.values().size
    }

    private val clientProfileFragments: SparseArray<Fragment> = SparseArray()

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    @Override
    override fun getItem(position: Int): Fragment {
        // TODO 25.07.17 Add correct fragments
        when (ClientProfilePagesEnum.values()[position]) {
            ClientProfilePagesEnum.ORDERS -> return Fragment()
            ClientProfilePagesEnum.SHOPS -> return ShopsFragment()
            ClientProfilePagesEnum.GOODS -> return Fragment()
            ClientProfilePagesEnum.NOTES -> return Fragment()
            ClientProfilePagesEnum.TIMETABLE -> return Fragment()
        }
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val fragment = super.instantiateItem(container, position)
        clientProfileFragments.put(position, fragment as Fragment)
        return fragment
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        super.destroyItem(container, position, `object`)
        clientProfileFragments.remove(position)
    }

    fun getClientProfileFragment(enum: ClientProfilePagesEnum): Fragment {
        return clientProfileFragments.get(enum.ordinal)
    }
}