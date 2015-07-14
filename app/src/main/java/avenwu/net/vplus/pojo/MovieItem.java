package avenwu.net.vplus.pojo;

import java.util.List;

/**
 * Created by chaobin on 7/1/15.
 */
public class MovieItem extends Response<List<MovieItem.Data>> {

    /**
     * postid: "47050",
     * title: "创意逗趣戳心窝短片《当“失眠”被拟人化》",
     * is_xpc: 0,
     * is_promote: 0,
     * is_xpc_zp: 0,
     * is_xpc_cp: 0,
     * is_xpc_fx: 0,
     * recent_hot: 0,
     * discussion: 0,
     * image: "http://cs.vmovier.com/Uploads/cover/2015-07-09/559e447830993_cut.jpeg",
     * rating: "3.7",
     * duration: "122",
     * publish_time: "1436581922",
     * like_num: "0",
     * share_num: "0
     */
    public static class Data {
        public String postid;
        public String title;
        public int is_xpc;
        public int is_promote;
        public int is_xpc_zp;
        public int is_xpc_cp;
        public int is_xpc_fx;
        public int recent_hot;
        public int discussion;
        public String image;
        public String rating;
        public String duration;
        public String publish_time;
        public String like_num;
        public String share_num;
    }
}
