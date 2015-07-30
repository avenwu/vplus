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

import net.avenwu.support.presenter.PresenterFragment;

import avenwu.net.vplus.R;
import avenwu.net.vplus.adapter.PostInCategoryAdapter;
import avenwu.net.vplus.pojo.MovieItem;
import avenwu.net.vplus.presenter.PostInCategoryPresenter;
import avenwu.net.vplus.widget.OnLastItemVisible;
import avenwu.net.vplus.widget.State;
import avenwu.net.vplus.widget.SwipeRecyclerFooterLayout;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostInCategoryFragment extends PresenterFragment<PostInCategoryPresenter> implements SwipeRefreshLayout
        .OnRefreshListener {
    PostInCategoryAdapter mAdapter = new PostInCategoryAdapter();
    RecyclerView mRecyclerView;
    SwipeRecyclerFooterLayout mSwipeLayout;
    int mCateId;
    int mPageIndex = 1;
    int mItemMargin;

    public PostInCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<? extends PostInCategoryPresenter> getPresenterClass() {
        return PostInCategoryPresenter.class;
    }

    public static PostInCategoryFragment newInstance(int cateId) {
        PostInCategoryFragment fragment = new PostInCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cate_id", cateId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCateId = getArguments().getInt("cate_id");
        mItemMargin = getResources().getDimensionPixelSize(R.dimen.item_margin);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_list, null);
        mSwipeLayout = (SwipeRecyclerFooterLayout) view.findViewById(R.id.swipe_layout);
        mRecyclerView = mSwipeLayout.getRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mSwipeLayout.setColorSchemeResources(R.color.indigo_500, R.color.indigo_700);
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setOnLastItemVisible(new OnLastItemVisible() {
            @Override
            public void onVisible() {
            }

            @Override
            public void onLoad(State state) {
                requestHomeListData();
            }
        });
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
        mPageIndex = 1;
        requestHomeListData();
    }

    private void requestHomeListData() {
        getPresenter().queryDataInCategory(mCateId, mPageIndex, new Callback<MovieItem>() {
            @Override
            public void success(MovieItem homeListData, Response response) {
                if (mPageIndex == 1) {
                    mAdapter.setData(homeListData.data);
                } else {
                    mAdapter.appendData(homeListData.data);
                }
                mSwipeLayout.setRefreshing(false);
                mSwipeLayout.getLoadingIndicator().setLoading(State.IDLE);
                mPageIndex++;
            }

            @Override
            public void failure(RetrofitError error) {
                mSwipeLayout.setRefreshing(false);
                mSwipeLayout.getLoadingIndicator().setLoading(State.IDLE);
                Toast.makeText(getActivity(), R.string.request_failed, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
