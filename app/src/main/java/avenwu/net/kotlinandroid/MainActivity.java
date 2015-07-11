package avenwu.net.kotlinandroid;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.facebook.drawee.backends.pipeline.Fresco;

import avenwu.net.kotlinandroid.adapter.HomeListAdapter;
import avenwu.net.kotlinandroid.api.CoreApi;
import avenwu.net.kotlinandroid.pojo.HomeListData;
import io.fabric.sdk.android.Fabric;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    HomeListAdapter mAdapter = new HomeListAdapter();
    RecyclerView mRecylerView;
    SwipeRefreshLayout mSwipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        mRecylerView = (RecyclerView) findViewById(R.id.recylerview);
        mRecylerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecylerView.setAdapter(mAdapter);
        mRecylerView.setItemAnimator(new DefaultItemAnimator());
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setRefreshing(true);
        requestHomeListData();
    }

    @Override
    public void onRefresh() {
        requestHomeListData();
    }

    private void requestHomeListData() {
        CoreApi.movie().getHomeList1(0, 1, new Callback<HomeListData>() {
            @Override
            public void success(HomeListData homeListData, Response response) {
                mSwipeLayout.setRefreshing(false);
                mAdapter.setData(homeListData.data);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                mSwipeLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, R.string.request_failed, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
