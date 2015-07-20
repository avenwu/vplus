package avenwu.net.vplus.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by chaobin on 7/20/15.
 */
public class LoadingIndicator extends RecyclerView.OnScrollListener {
    int[] mPositions = {0, 0};
    OnLastItemVisible mLastItemVisible;
    State mState = State.IDLE;
    LoadingStatus mLoadingStatus;

    public static LoadingIndicator newIndicator(OnLastItemVisible onLastItemVisible) {
        LoadingIndicator indicator = new LoadingIndicator();
        indicator.mLastItemVisible = onLastItemVisible;
        return indicator;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int loadPos = recyclerView.getAdapter().getItemCount() - 1;
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) recyclerView.getLayoutManager())
                    .findLastCompletelyVisibleItemPositions(mPositions);
            if (dy > 0 && (mPositions[0] >= loadPos || mPositions[1] >= loadPos)) {
                if (mLastItemVisible != null) {
                    if (mLoadingStatus == null) {
                        mLoadingStatus = mLastItemVisible.getLoadingStatus();
                    }
                    mLastItemVisible.onVisible();
                    if (State.IDLE.equals(mState)) {
                        mLastItemVisible.onLoad(mState);
                        mState = State.LOADING;
                    }
                    mLoadingStatus.onStatusChanged(mState);
                }
            }
        }
    }

    public void setLoading(State state) {
        if (!state.equals(mState)) {
            mState = state;
            //TODO notify UI state
            mLoadingStatus.onStatusChanged(mState);
        }

    }
}
