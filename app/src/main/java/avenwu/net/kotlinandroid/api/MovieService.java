package avenwu.net.kotlinandroid.api;

import avenwu.net.kotlinandroid.pojo.BannerListData;
import avenwu.net.kotlinandroid.pojo.HomeListData;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by chaobin on 7/1/15.
 */
public interface MovieService {
    String DOMAIN = "http://apiv2.vmovier.com";

    /**
     * http://apiv2.vmovier.com/api/post/getPostInCate?cateid=0&p=1
     */
    @GET("/api/post/getPostInCate")
    HomeListData getHomeList(@Query("cateid") int cateid, @Query("p") int p);

    /**
     * http://apiv2.vmovier.com/api/index/getBanner?
     */
    @GET("/api/index/getBanner")
    BannerListData getBannerList();

}
