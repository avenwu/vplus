package avenwu.net.vplus.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import avenwu.net.vplus.R;

/**
 * Created by chaobin on 7/20/15.
 */
public class SimpleLoadingStatus extends LinearLayout implements LoadingStatus {
    ProgressBar mProgressbar;
    TextView mLabel;

    public SimpleLoadingStatus(Context context) {
        super(context);
    }

    public SimpleLoadingStatus(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleLoadingStatus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public SimpleLoadingStatus(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mProgressbar = (ProgressBar) findViewById(R.id.progress);
        mLabel = (TextView) findViewById(R.id.label);
    }

    @Override
    public void onStatusChanged(State state) {
        if (State.IDLE.equals(state)) {
            mProgressbar.setVisibility(GONE);
            mLabel.setText("Nothing to load ...");
        } else if (State.LOADING.equals(state)) {
            mProgressbar.setVisibility(VISIBLE);
            mLabel.setText("Loading ...");
        }
    }
}
