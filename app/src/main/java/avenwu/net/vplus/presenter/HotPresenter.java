package avenwu.net.vplus.presenter;

import avenwu.net.vplus.api.CoreApi;
import avenwu.net.vplus.pojo.MovieItem;
import retrofit.Callback;

/**
 * Created by chaobin on 7/14/15.
 */
public class HotPresenter extends Presenter {

    public void getHotListData(int page, Callback<MovieItem> callback) {
        CoreApi.movie().getPostByTab("tab", page, callback);
    }
}
