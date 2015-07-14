package avenwu.net.vplus.utils;

import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by chaobin on 7/11/15.
 */
public class ToolKit {
    public static final String CUSTOM_SCHEME = "vmovier://play";
    public static final String VIDEO_KEY = "qiniu_url";

    /**
     * vmovier://play?qiniu_url=http://vmovier.qiniudn.com/559f8d1cb40de.mp4&title=%E4%B8%96%E7%95%8C%E7%BA%A7%E7%94%B5%E5%BD%B1%E8%8A%82%E5%B1%A1%E8%8E%B7%E5%85%A5%E9%80%89%E7%9F%AD%E7%89%87%E3%80%8A%E4%B8%BA%E4%BD%A0%E5%8C%96%E4%BD%9C%E9%A3%98%E9%9B%AA%E3%80%8B
     *
     * @param url
     * @return
     */
    public static String getVideoUrl(String url) {
        if (!TextUtils.isEmpty(url) && url.startsWith(CUSTOM_SCHEME)) {
            return Uri.parse(url).getQueryParameter(VIDEO_KEY);
        }
        return "";
    }
}
