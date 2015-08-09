package avenwu.net.vplus.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import avenwu.net.vplus.R;

/**
 * Created by chaobin on 7/20/15.
 */
public class LoadingIndicator extends RecyclerView.OnScrollListener {
    int[] mPositions = {0, 0};
    OnLastItemVisible mLastItemVisible;
    State mState = State.IDLE;
    SimpleLoadingStatus mLoadingStatus;
    RecyclerView mRecyclerView;

    public static LoadingIndicator newIndicator(OnLastItemVisible onLastItemVisible) {
        LoadingIndicator indicator = new LoadingIndicator();
        indicator.mLastItemVisible = onLastItemVisible;
        return indicator;
    }

    public LoadingIndicator fromXml(Context context, @LayoutRes int id) {
        mLoadingStatus = (SimpleLoadingStatus) View.inflate(context, id, new SimpleLoadingStatus(context));
        return this;
    }

    public LoadingIndicator inject(RecyclerView recyclerView) {
        ViewParent viewParent = recyclerView.getParent();
        if (viewParent instanceof ViewGroup && mLoadingStatus != null) {
            final int recyclerIndex = ((ViewGroup) viewParent).indexOfChild(recyclerView);

            FrameLayout newRootParent = new FrameLayout(recyclerView.getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(recyclerView.getLayoutParams());
            newRootParent.setLayoutParams(params);

            ((ViewGroup) viewParent).removeViewAt(recyclerIndex);
            recyclerView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
            newRootParent.addView(recyclerView);
            FrameLayout.LayoutParams loadingParams = new FrameLayout.LayoutParams(ViewGroup
                .LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            loadingParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
            mLoadingStatus.setLayoutParams(loadingParams);
            newRootParent.addView(mLoadingStatus);
            ((ViewGroup) viewParent).addView(newRootParent, recyclerIndex);
        }
        recyclerView.addOnScrollListener(this);
        int spanCount = 1;
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            spanCount = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        } else if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        } else {
            spanCount = 1;
        }
        recyclerView.addItemDecoration(new FooterDecoration(mLoadingStatus, 2));
        mRecyclerView = recyclerView;
        return this;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        mLoadingStatus.setTranslationY(-dy);
        int loadPos = recyclerView.getAdapter().getItemCount() - 1;
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) recyclerView.getLayoutManager())
                .findLastCompletelyVisibleItemPositions(mPositions);
            if (dy > 0 && (mPositions[0] >= loadPos || mPositions[1] >= loadPos)) {
//                mLoadingStatus.setVisibility(View.VISIBLE);
                updateFooterStatus();
            } else {
//                mLoadingStatus.setVisibility(View.GONE);
            }
        } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            if (dy > 0 && ((LinearLayoutManager) recyclerView.getLayoutManager())
                .findLastCompletelyVisibleItemPosition() >= loadPos) {
//                mLoadingStatus.setVisibility(View.VISIBLE);
            } else {
//                mLoadingStatus.setVisibility(View.GONE);
            }
        }
    }

    private void updateFooterStatus() {
        if (mLastItemVisible != null) {
            mLastItemVisible.onVisible();
            if (State.IDLE.equals(mState)) {
                mLastItemVisible.onLoad(mState);
                mState = State.LOADING;
            }
            mLoadingStatus.onStatusChanged(mState);
        }
    }

    public void setLoading(State state) {
        if (!state.equals(mState)) {
            mState = state;
            mLoadingStatus.onStatusChanged(mState);
        }

    }

    static class FooterDecoration extends RecyclerView.ItemDecoration {
        SimpleLoadingStatus mLoadingStatus;
        int mSpanCount;

        public FooterDecoration(SimpleLoadingStatus loadingStatus, int spanCount) {
            mLoadingStatus = loadingStatus;
            mSpanCount = spanCount;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int count = parent.getAdapter().getItemCount();
            int position = parent.getChildAdapterPosition(view);
            if (count - mSpanCount <= position) {
                Log.d("Test Log", "spancount:" + mSpanCount + ",position:" + position);
                outRect.bottom = mLoadingStatus.getHeight();
            }
        }
    }
}
