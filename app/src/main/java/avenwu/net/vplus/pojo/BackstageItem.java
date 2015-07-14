package avenwu.net.vplus.pojo;

import java.util.List;

/**
 * Created by chaobin on 7/14/15.
 */
public class BackstageItem extends Response<List<BackstageItem.Data>> {

    /**
     * "cateid": "4",
     * "postid": "47074",
     * "title": "\u8fd9\u4e00\u5b9a\u662f\u4e16\u754c\u4e0a\u6700\u75af\u72c2\u7684\u7535\u5f71\u5e55\u540e",
     * "is_xpc": 0,
     * "is_promote": 0,
     * "is_xpc_zp": 0,
     * "is_xpc_cp": 0,
     * "is_xpc_fx": 0,
     * "is_collect": 0,
     * "share_link": "http:\/\/www.vmovier.com\/47074?_vfrom=VmovierApp",
     * "image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-13\/55a3a5fdcb625_cut.jpeg",
     * "rating": "0",
     * "duration": "183",
     * "publish_time": "1436789706",
     * "like_num": "2",
     * "share_num": "6",
     * "video_link": "http:\/\/v.youku.com\/v_show\/id_XMTI4NDAxMTgwOA==.html,http:\/\/v.youku.com\/v_show\/id_XMTI4NDAxMTgwMA==.html,http:\/\/v.youku.com\/v_show\/id_XMTI4NDAxMTgxMg==.html"
     */
    public static class Data {
        public String cateid;
        public String postid;
        public String title;
        public int is_xpc;
        public int is_promote;
        public int is_xpc_zp;
        public int is_xpc_cp;
        public int is_xpc_fx;
        public int is_collect;
        public String share_link;
        public String image;
        public String rating;
        public String duration;
        public String publish_time;
        public String like_num;
        public String share_num;
        public String video_link;
    }

}
