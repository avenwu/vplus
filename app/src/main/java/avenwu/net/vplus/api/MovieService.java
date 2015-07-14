package avenwu.net.vplus.api;

import java.util.List;

import avenwu.net.vplus.pojo.BannerListData;
import avenwu.net.vplus.pojo.CategoryData;
import avenwu.net.vplus.pojo.MovieItem;
import retrofit.Callback;
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
    void getPostInCategory(@Query("cateid") int cateid, @Query("p") int p, Callback<MovieItem> callback);

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

    /**
     * http://apiv2.vmovier.com/api/post/getPostByTab?tab=hot&p=1
     */
    @GET("/api/post/getPostByTab")
    void getPostByTab(@Query("tab") String tab, @Query("p") int page, Callback<MovieItem> callback);
}
