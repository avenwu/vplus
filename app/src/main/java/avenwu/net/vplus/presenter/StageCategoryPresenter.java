package avenwu.net.vplus.presenter;

import avenwu.net.vplus.api.CoreApi;
import avenwu.net.vplus.pojo.BackstageItem;
import avenwu.net.vplus.pojo.MovieItem;
import retrofit.Callback;

/**
 * Created by chaobin on 7/12/15.
 */
public class StageCategoryPresenter extends Presenter {

    /**
     * 获取分类视频流
     *
     * @param cateId   分类id
     * @param page     页码
     * @param callback 回调
     */
    public void queryDataInCategory(int cateId, int page, Callback<BackstageItem> callback) {
        CoreApi.movie().getPostByCategory(cateId, page, addCallback(new
                DetachableCallback<BackstageItem>(callback)));
    }
}
