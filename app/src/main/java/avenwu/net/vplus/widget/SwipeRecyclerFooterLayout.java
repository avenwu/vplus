package avenwu.net.vplus.widget;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;

import avenwu.net.vplus.R;

/**
 * Created by chaobin on 7/21/15.
 */
public class SwipeRecyclerFooterLayout extends SwipeRefreshLayout {
    LoadingIndicator mLoadingIndicator;
    RecyclerView mRecyclerView;
    OnLastItemVisible onLastItemVisible;

    public SwipeRecyclerFooterLayout(Context context) {
        this(context, null);
    }

    public SwipeRecyclerFooterLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRecyclerView = new RecyclerView(context, attrs);
        mRecyclerView.setClipToPadding(false);
        int margin = getResources().getDimensionPixelSize(R.dimen.item_margin);
        mRecyclerView.setPadding(margin, margin, margin, margin);
        addView(mRecyclerView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//        inject(R.layout.loading_layout);
    }

    public SwipeRecyclerFooterLayout inject(@LayoutRes int id) {
        mLoadingIndicator = LoadingIndicator.newIndicator(new OnLastItemVisible() {
            @Override
            public void onVisible() {
                if (onLastItemVisible != null) {
                    onLastItemVisible.onVisible();
                }
            }

            @Override
            public void onLoad(State state) {
                if (onLastItemVisible != null) {
                    onLastItemVisible.onLoad(state);
                }
            }
        }).fromXml(getContext(), id).inject(mRecyclerView);
        return this;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public boolean canChildScrollUp() {
        if (mRecyclerView != null && mRecyclerView.getVisibility() == View.VISIBLE) {
            return canListViewScrollUp();
        } else {
            return super.canChildScrollUp();
        }
    }

    int[] mPosition = {0, 0};

    private boolean canListViewScrollUp() {
        if (android.os.Build.VERSION.SDK_INT < 14) {
            return mRecyclerView.getChildCount() > 0 && (isFirstVisiblePositionEqualZero() ||
                mRecyclerView.getChildAt(0).getTop() < mRecyclerView.getPaddingTop());
        } else {
            return ViewCompat.canScrollVertically(mRecyclerView, -1);
        }
    }

    private boolean isFirstVisiblePositionEqualZero() {
        if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) mRecyclerView.getLayoutManager()).findFirstVisibleItemPositions(mPosition);
            return mPosition[0] > 0;
        } else {
            return ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition() > 0;
        }
    }

    public void withListener(OnLastItemVisible lastItemVisible) {
        this.onLastItemVisible = lastItemVisible;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public LoadingIndicator getLoadingIndicator() {
        return mLoadingIndicator;
    }
}
