package avenwu.net.vplus.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import avenwu.net.vplus.R;
import avenwu.net.vplus.adapter.PostInCategoryAdapter;
import avenwu.net.vplus.pojo.MovieItem;
import avenwu.net.vplus.presenter.HotPresenter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by chaobin on 7/14/15.
 */
public class HotFragment extends PresenterFragment<HotPresenter> implements SwipeRefreshLayout
        .OnRefreshListener {
    PostInCategoryAdapter mAdapter = new PostInCategoryAdapter();
    RecyclerView mRecylerView;
    SwipeRefreshLayout mSwipeLayout;

    @Override
    protected Class<? extends HotPresenter> getPresenterClass() {
        return HotPresenter.class;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_layout, null);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        final ActionBar ab = ((MainActivity) getActivity()).getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
        mSwipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);
        mRecylerView = (RecyclerView) view.findViewById(R.id.recylerview);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecylerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecylerView.setAdapter(mAdapter);
        mRecylerView.setItemAnimator(new DefaultItemAnimator());
        mSwipeLayout.setColorSchemeResources(R.color.indigo_500, R.color.indigo_700);
        mSwipeLayout.setOnRefreshListener(this);
        // make sure the refresh view show as expected
        mSwipeLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeLayout.setRefreshing(true);
            }
        });
        requestListData();
    }

    @Override
    public void onRefresh() {
        requestListData();
    }

    private void requestListData() {
        getPresenter().getHotListData(1, new Callback<MovieItem>() {
            @Override
            public void success(MovieItem homeListData, Response response) {
                mAdapter.setData(homeListData.data);
                mAdapter.notifyDataSetChanged();
                mSwipeLayout.setRefreshing(false);
            }

            @Override
            public void failure(RetrofitError error) {
                mSwipeLayout.setRefreshing(false);
                Toast.makeText(getActivity(), R.string.request_failed, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
