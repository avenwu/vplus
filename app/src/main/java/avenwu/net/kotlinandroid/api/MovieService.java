package avenwu.net.kotlinandroid.api;

import java.util.List;

import avenwu.net.kotlinandroid.pojo.BannerListData;
import avenwu.net.kotlinandroid.pojo.CategoryData;
import avenwu.net.kotlinandroid.pojo.HomeListData;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by chaobin on 7/1/15.
 */
public interface MovieService {
    String DOMAIN = "http://apiv2.vmovier.com";

    /**
     * http://apiv2.vmovier.com/api/post/getPostInCate?cateid=0&p=1
     */
    @GET("/api/post/getPostInCate")
    void getHomeList1(@Query("cateid") int cateid, @Query("p") int p, Callback<HomeListData> callback);

    /**
     * http://apiv2.vmovier.com/api/index/getBanner?
     */
    @GET("/api/index/getBanner")
    BannerListData getBannerList();

    /**
     * /api/cate/getListV4
     */
    @GET("/api/cate/getListV4")
    void getCategoryList(Callback<List<CategoryData>> callback);
}
