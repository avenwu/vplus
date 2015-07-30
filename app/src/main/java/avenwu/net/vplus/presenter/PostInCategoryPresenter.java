package avenwu.net.vplus.presenter;

import net.avenwu.support.presenter.Presenter;

import avenwu.net.vplus.api.CoreApi;
import avenwu.net.vplus.pojo.MovieItem;
import retrofit.Callback;

/**
 * Created by chaobin on 7/12/15.
 */
public class PostInCategoryPresenter extends Presenter {

    /**
     * 获取分类视频流
     *
     * @param cateId   分类id
     * @param page     页码
     * @param callback 回调
     */
    public void queryDataInCategory(int cateId, int page, Callback<MovieItem> callback) {
        CoreApi.movie().getPostInCategory(cateId, page, addCallback(new DetachableCallback<MovieItem>
                (callback)));
    }
}
