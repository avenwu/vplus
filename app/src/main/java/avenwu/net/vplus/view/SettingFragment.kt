package avenwu.net.vplus.view

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.util.DisplayMetrics
import android.view.View
import android.widget.TextView
import android.widget.Toast
import avenwu.net.vplus.BuildConfig

import avenwu.net.vplus.R

/**
 * Created by chaobin on 7/16/15.
 */
public class SettingFragment : PreferenceFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.setting_screen)
        findPreference("feedback")?.let {
            it.setOnPreferenceClickListener(object : Preference.OnPreferenceClickListener {
                override fun onPreferenceClick(preference: Preference): Boolean {
                    val uri = Uri.parse(getString(R.string.mail_to))
                    val metrics = getDisplayMetrics(getActivity())
                    val content = getString(R.string.default_feedback_devices_info,
                            "${android.os.Build.MODEL}(${android.os.Build.PRODUCT})",
                            "${metrics.widthPixels}*${metrics.heightPixels}",
                            Build.VERSION.RELEASE,
                            Build.VERSION.SDK_INT,
                            BuildConfig.VERSION_NAME,
                            getNetworkInfo(getActivity()).getTypeName());
                    val it = Intent(Intent.ACTION_SENDTO, uri).putExtra(Intent.EXTRA_TEXT, content)
                    if (checkIntentAvailable(getActivity(), it)) {
                        startActivity(it)
                    } else {
                        Toast.makeText(getActivity(), R.string.no_email_provider, Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
        }
    }

    public fun getDisplayMetrics(context: Activity): DisplayMetrics {
        val dm = DisplayMetrics()
        context.getWindowManager().getDefaultDisplay().getMetrics(dm)
        return dm
    }

    public fun checkIntentAvailable(context: Context, intent: Intent): Boolean {
        return context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0
    }

    public fun getNetworkInfo(context: Context): NetworkInfo {
        return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).getActiveNetworkInfo()
    }
}
