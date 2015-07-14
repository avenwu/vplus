package avenwu.net.vplus.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import avenwu.net.vplus.R;
import avenwu.net.vplus.pojo.CategoryData;
import avenwu.net.vplus.presenter.MainPresenter;
import avenwu.net.vplus.protocol.UIAction;

public class MainActivity extends PresenterActivity<MainPresenter> {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    List<CategoryData> mCategoryList = new ArrayList<CategoryData>();
    MainPresenter mPresenter;

    @Override
    protected Class<? extends MainPresenter> getPresenterClass() {
        return MainPresenter.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        getPresenter().addAction(MainPresenter.ACTION_QUERY_CATEGORY, new UIAction<List<CategoryData>>() {
            @Override
            public void onUpdateUI(List<CategoryData> data) {
                if (data == null || data.size() <= 0) {
                    Toast.makeText(MainActivity.this, R.string.request_failed, Toast
                            .LENGTH_SHORT).show();
                } else {
                    mCategoryList.addAll(data);
                    notifyTabLayout();
                }
            }
        }).addAction(MainPresenter.ACTION_GET_CACHED_CATEGORY, new UIAction<List<CategoryData>>() {
            @Override
            public void onUpdateUI(List<CategoryData> data) {
                if (data == null || data.size() <= 0) {
                    mPresenter.queryOnlineCategory();
                } else {
                    mCategoryList.addAll(data);
                    notifyTabLayout();
                }
            }
        });
        getPresenter().getCachedCategoryList();
    }

    private void notifyTabLayout() {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return HomeListFragment.newInstance(Integer.parseInt(mCategoryList.get(position).cateid));
            }

            @Override
            public int getCount() {
                return mCategoryList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mCategoryList.get(position).catename;
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
