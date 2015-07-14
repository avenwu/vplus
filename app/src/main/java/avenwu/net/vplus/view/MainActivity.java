package avenwu.net.vplus.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import avenwu.net.vplus.R;
import avenwu.net.vplus.presenter.HomePresenter;

public class MainActivity extends PresenterActivity<HomePresenter> implements NavigationView
        .OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;

    @Override
    protected Class<? extends HomePresenter> getPresenterClass() {
        return HomePresenter.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, new HomeFragment
                    (), HomeFragment.class.getCanonicalName()).commitAllowingStateLoss();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        mDrawerLayout.closeDrawers();
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                setContent(HomeFragment.class);
                break;
            case R.id.menu_hot:
                setContent(HotFragment.class);
                break;
            case R.id.menu_stared:

                break;
            case R.id.menu_stage:

                break;
            case R.id.menu_series:

                break;
            case R.id.menu_random:

                break;
        }
        return true;
    }

    private void setContent(Class<? extends Fragment> clz) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(clz.getCanonicalName());
        if (fragment == null) {
            try {
                getSupportFragmentManager().beginTransaction().replace(R.id.content, clz.newInstance
                        (), clz.getCanonicalName()).commitAllowingStateLoss();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            getSupportFragmentManager().beginTransaction().show(fragment);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
