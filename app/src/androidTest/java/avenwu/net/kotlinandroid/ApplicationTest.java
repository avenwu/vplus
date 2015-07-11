package avenwu.net.kotlinandroid;

import android.app.Application;
import android.test.ApplicationTestCase;

import avenwu.net.kotlinandroid.api.CoreApi;
import avenwu.net.kotlinandroid.api.MovieService;
import avenwu.net.kotlinandroid.pojo.BannerListData;
import avenwu.net.kotlinandroid.pojo.HomeListData;
import avenwu.net.kotlinandroid.pojo.Response;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    private void commonCheck(Response data) {
        assertNotNull("data can not be null", data);
        assertEquals("status非0", 0, data.status);
        assertEquals("msg不是ok", "ok", data.msg.toLowerCase());
        assertNotNull("数据为空", data.data);
    }

    /**
     * 测试首页列表数据
     */
    public void testHomeList() {
        MovieService service = CoreApi.movie();
////        HomeListData data = service.getHomeList(0, 1);
//        commonCheck(data);
//        assertTrue("size为空", data.data.size() > 0);
    }

    /**
     * 测试banner轮播图数据
     */
    public void testBanner() {
        MovieService service = CoreApi.movie();
        BannerListData data = service.getBannerList();
        commonCheck(data);
        assertTrue("size为空", data.data.size() > 0);
    }

    public void testDetail() {

    }
}