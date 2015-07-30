package avenwu.net.vplus.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.Toast;

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
        Bundle bundle = null;
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                setFragmentContent("home", HomeFragment.class, bundle);
                break;
            case R.id.menu_hot:
                bundle = new Bundle();
                bundle.putString(PostFragment.KEY_TAB, PostFragment.TAB_HOT);
                bundle.putString(PostFragment.KEY_TITLE, getResources().getString(R.string.menu_hot));
                setFragmentContent("hot", PostFragment.class, bundle);
                break;
            case R.id.menu_stared:
                bundle = new Bundle();
                bundle.putString(PostFragment.KEY_TAB, PostFragment.TAB_STAR);
                bundle.putString(PostFragment.KEY_TITLE, getResources().getString(R.string.menu_stared));
                setFragmentContent("star", PostFragment.class, bundle);
                break;
            case R.id.menu_stage:
                setFragmentContent("stage", BackstageFragment.class, bundle);
                break;
            case R.id.menu_random:
                bundle = new Bundle();
                bundle.putString(PostFragment.KEY_TAB, PostFragment.TAB_RANDOM);
                bundle.putString(PostFragment.KEY_TITLE, getResources().getString(R.string.menu_random));
                setFragmentContent("rand", PostFragment.class, bundle);
                break;
            case R.id.menu_setting:
                Toast.makeText(MainActivity.this, "测试Toast", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                break;
            case R.id.menu_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
        return true;
    }

    private void setFragmentContent(String tag, Class<? extends Fragment> clz, Bundle bundle) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            try {
                fragment = clz.newInstance();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment, tag)
                        .commitAllowingStateLoss();
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
