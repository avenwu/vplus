package avenwu.net.vplus.pojo;

import java.util.List;

/**
 * Created by chaobin on 7/14/15.
 */
public class BackstageCategoryData extends Response<List<BackstageCategoryData.Data>> {

    /**
     * "cateid": "2",
     * "catename": "\u5168\u90e8"
     */
    public static class Data {
        public String cateid;
        public String catename;
    }
}
