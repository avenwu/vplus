package avenwu.net.vplus.widget;

/**
 * Created by chaobin on 7/20/15.
 */
public interface OnLastItemVisible {
    void onVisible();

    void onLoad(State state);

    LoadingStatus getLoadingStatus();
}
