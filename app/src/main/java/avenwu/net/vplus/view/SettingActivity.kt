package avenwu.net.vplus.view

import android.os.Bundle
import android.view.MenuItem

import avenwu.net.vplus.presenter.Presenter

/**
 * Created by chaobin on 7/16/15.
 */
public class SettingActivity : PresenterActivity<Presenter>() {
    override fun getPresenterClass(): Class<out Presenter> {
        return javaClass()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true)
        getFragmentManager().beginTransaction().replace(android.R.id.content, SettingFragment()).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            when (it.getItemId()) {
                android.R.id.home -> {
                    finish()
                    return true
                }
            }
            return super.onOptionsItemSelected(it)
        }
        return super.onOptionsItemSelected(item)
    }
}
