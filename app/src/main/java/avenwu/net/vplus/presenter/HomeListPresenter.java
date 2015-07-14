package avenwu.net.vplus.presenter;

import avenwu.net.vplus.api.CoreApi;
import avenwu.net.vplus.pojo.HomeListData;
import retrofit.Callback;

/**
 * Created by chaobin on 7/12/15.
 */
public class HomeListPresenter extends Presenter {

    /**
     * 获取分类视频流
     *
     * @param cateId   分类id
     * @param page     页码
     * @param callback 回调
     */
    public void queryDataInCategory(int cateId, int page, Callback<HomeListData> callback) {
        CoreApi.movie().getHomeList1(cateId, page, addCallback(new DetachableCallback<HomeListData>
                (callback)));
    }
}
