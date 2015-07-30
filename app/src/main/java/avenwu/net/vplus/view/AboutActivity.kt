package avenwu.net.vplus.view

import android.os.Bundle
import android.view.MenuItem
import avenwu.net.vplus.BuildConfig
import avenwu.net.vplus.R
import kotlinx.android.synthetic.about_layout.*
import net.avenwu.support.presenter.Presenter
import net.avenwu.support.presenter.PresenterActivity

/**
 * Created by chaobin on 7/16/15.
 */
public class AboutActivity : PresenterActivity<Presenter>() {
    override fun getPresenterClass(): Class<out Presenter> {
        return javaClass()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_layout)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true)
        tv_version.setText(getString(R.string.version_name, BuildConfig.VERSION_NAME))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
