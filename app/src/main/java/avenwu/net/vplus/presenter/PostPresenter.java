package avenwu.net.vplus.presenter;

import avenwu.net.vplus.api.CoreApi;
import avenwu.net.vplus.pojo.MovieItem;
import retrofit.Callback;

/**
 * Created by chaobin on 7/14/15.
 */
public class PostPresenter extends Presenter {

    public void getHotListData(String tag, int page, Callback<MovieItem> callback) {
        CoreApi.movie().getPostByTab(tag, page, addCallback(new DetachableCallback<MovieItem>(callback)));
    }
}
