package github.fushaolei.lib.test.utils

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * 申请权限工具类
 */
typealias PermissionCallback = (Boolean, List<String>) -> Unit

object APermission {
    private const val FRAGMENT_TAG = "InvisibleFragment"
    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callback: PermissionCallback,
    ) {
        val fm = activity.supportFragmentManager
        val existedFragment = fm.findFragmentByTag(FRAGMENT_TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fm.beginTransaction().add(invisibleFragment, FRAGMENT_TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permissions)
    }

}

class InvisibleFragment : Fragment() {
    private val REQUEST_CODE = 1
    private var callback: PermissionCallback? = null
    fun requestNow(cb: PermissionCallback, vararg permission: String) {
        callback = cb
        requestPermissions(permission, REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        if (requestCode == REQUEST_CODE) {
            val denieList = ArrayList<String>()
            for ((index, result) in grantResults.withIndex()) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    denieList.add(permissions[index])
                }
            }
            val allGranted = denieList.isEmpty()
            callback?.let { it(allGranted, denieList) }
        }
    }
}