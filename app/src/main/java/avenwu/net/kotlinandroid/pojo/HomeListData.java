package avenwu.net.kotlinandroid.pojo;

import java.util.List;

/**
 * Created by chaobin on 7/1/15.
 */
public class HomeListData extends Response<List<HomeListData.Data>> {

    /**
     * "banner_id": "379",
     * "title": "",
     * "image": "http://apiv2.vmovier.com/Uploads/Vmovier/banner/2015/07-01/559361e8eb52b.jpg",
     * "type": "post",
     * "object_id": "46986"
     */
    public static class Data {
        public String banner_id;
        public String title;
        public String image;
        public String type;
        public String object_id;
    }
}
