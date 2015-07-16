package avenwu.net.vplus.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import avenwu.net.vplus.R;
import avenwu.net.vplus.adapter.StageCategoryAdapter;
import avenwu.net.vplus.pojo.BackstageItem;
import avenwu.net.vplus.presenter.StageCategoryPresenter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackstageCategoryFragment extends PresenterFragment<StageCategoryPresenter> implements SwipeRefreshLayout
        .OnRefreshListener {
    StageCategoryAdapter mAdapter = new StageCategoryAdapter();
    RecyclerView mRecylerView;
    SwipeRefreshLayout mSwipeLayout;
    int mCateId;

    public BackstageCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<? extends StageCategoryPresenter> getPresenterClass() {
        return StageCategoryPresenter.class;
    }

    public static BackstageCategoryFragment newInstance(int cateId) {
        BackstageCategoryFragment fragment = new BackstageCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cate_id", cateId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCateId = getArguments().getInt("cate_id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_list, null);
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
        requestHomeListData();
    }

    @Override
    public void onRefresh() {
        requestHomeListData();
    }

    private void requestHomeListData() {
        getPresenter().queryDataInCategory(mCateId, 1, new Callback<BackstageItem>() {
            @Override
            public void success(BackstageItem itemData, Response response) {
                mAdapter.setData(itemData.data);
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