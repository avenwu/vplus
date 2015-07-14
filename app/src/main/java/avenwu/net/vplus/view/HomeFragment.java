package avenwu.net.vplus.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import avenwu.net.vplus.R;
import avenwu.net.vplus.pojo.CategoryData;
import avenwu.net.vplus.presenter.HomePresenter;
import avenwu.net.vplus.protocol.UIAction;

/**
 * Created by chaobin on 7/14/15.
 */
public class HomeFragment extends PresenterFragment<HomePresenter> {

    TabLayout mTabLayout;
    ViewPager mViewPager;
    List<CategoryData> mCategoryList = new ArrayList<CategoryData>();
    HomePresenter mPresenter;

    @Override
    protected Class<? extends HomePresenter> getPresenterClass() {
        return HomePresenter.class;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().addAction(HomePresenter.ACTION_QUERY_CATEGORY, new UIAction<List<CategoryData>>() {
            @Override
            public void onUpdateUI(List<CategoryData> data) {
                if (data == null || data.size() <= 0) {
                    Toast.makeText(getActivity(), R.string.request_failed, Toast
                            .LENGTH_SHORT).show();
                } else {
                    mCategoryList.addAll(data);
                    notifyTabLayout();
                }
            }
        }).addAction(HomePresenter.ACTION_GET_CACHED_CATEGORY, new UIAction<List<CategoryData>>() {
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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_layout, null);
        ((MainActivity) getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));
        final ActionBar ab = ((MainActivity) getActivity()).getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        getPresenter().getCachedCategoryList();
        return view;
    }

    private void notifyTabLayout() {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PostInCategoryFragment.newInstance(Integer.parseInt(mCategoryList.get(position).cateid));
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
