package avenwu.net.vplus;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import avenwu.net.vplus.api.CoreApi;
import avenwu.net.vplus.api.MovieService;
import avenwu.net.vplus.pojo.BannerListData;
import avenwu.net.vplus.pojo.Response;
import avenwu.net.vplus.presenter.Presenter;
import avenwu.net.vplus.protocol.UIAction;
import avenwu.net.vplus.utils.ToolKit;

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
        String rawUrl = "vmovier://play?qiniu_url=http://vmovier.qiniudn.com/559f8d1cb40de.mp4&title=%E4%B8%96%E7%95%8C%E7%BA%A7%E7%94%B5%E5%BD%B1%E8%8A%82%E5%B1%A1%E8%8E%B7%E5%85%A5%E9%80%89%E7%9F%AD%E7%89%87%E3%80%8A%E4%B8%BA%E4%BD%A0%E5%8C%96%E4%BD%9C%E9%A3%98%E9%9B%AA%E3%80%8B";
        String url = ToolKit.getVideoUrl(rawUrl);
    }

    public void testPresenter() {
        Presenter presenter = new Presenter();
        presenter.addAction("TEST1", new UIAction<Object>() {
            @Override
            public void onUpdateUI(Object data) {
                Log.d("TEST1", "test1 invoked");
            }
        }).addAction("TEST2", new UIAction<Object>() {
            @Override
            public void onUpdateUI(Object data) {
                Log.d("TEST2", "test2 invoked");
            }
        }).addAction("TEST3", new UIAction<Object>() {
            @Override
            public void onUpdateUI(Object data) {
                Log.d("TEST3", "test3 invoked");
            }
        }).addAction("TEST4", new UIAction<Object>() {
            @Override
            public void onUpdateUI(Object data) {
                Log.d("TEST4", "test4 invoked");
            }
        });
        presenter.detach();
        presenter.invoke("TEST1", "Hello1");
        presenter.invoke("TEST2", "Hello2");
        presenter.invoke("TEST3", "Hello3");
        presenter.invoke("TEST4", "Hello4");
    }
}