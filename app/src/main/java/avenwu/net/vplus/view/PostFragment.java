package avenwu.net.vplus.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.avenwu.support.presenter.PresenterFragment;

import avenwu.net.vplus.R;
import avenwu.net.vplus.adapter.PostInCategoryAdapter;
import avenwu.net.vplus.pojo.MovieItem;
import avenwu.net.vplus.presenter.PostPresenter;
import avenwu.net.vplus.widget.OnLastItemVisible;
import avenwu.net.vplus.widget.State;
import avenwu.net.vplus.widget.SwipeRecyclerFooterLayout;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by chaobin on 7/14/15.
 */
public class PostFragment extends PresenterFragment<PostPresenter> implements SwipeRefreshLayout
        .OnRefreshListener {
    PostInCategoryAdapter mAdapter = new PostInCategoryAdapter();
    RecyclerView mRecyclerView;
    SwipeRecyclerFooterLayout mSwipeLayout;
    String mTab;
    String mTitle;
    int mPageIndex = 1;

    @Override
    protected Class<? extends PostPresenter> getPresenterClass() {
        return PostPresenter.class;
    }

    public static final String KEY_TAB = "key_tab";
    public static final String KEY_TITLE = "key_title";
    public static final String TAB_HOT = "hot";
    public static final String TAB_STAR = "star";
    public static final String TAB_RANDOM = "rand";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTab = getArguments().getString(KEY_TAB);
        mTitle = getArguments().getString(KEY_TITLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_layout, null);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        toolbar.setTitle(mTitle);
        final ActionBar ab = ((MainActivity) getActivity()).getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
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
        mSwipeLayout.inject(R.layout.loading_layout).withListener(new OnLastItemVisible() {
            @Override
            public void onVisible() {
            }

            @Override
            public void onLoad(State state) {
                requestListData();
            }
        });
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
        mPageIndex = 1;
        requestListData();
    }

    private void requestListData() {
        getPresenter().getHotListData(mTab, mPageIndex, new Callback<MovieItem>() {
            @Override
            public void success(MovieItem itemData, Response response) {
                if (mPageIndex == 1) {
                    mAdapter.setData(itemData.data);
                } else {
                    mAdapter.appendData(itemData.data);
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
