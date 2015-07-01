package avenwu.net.kotlinandroid.api;

import retrofit.RestAdapter;

/**
 * Created by chaobin on 7/1/15.
 */
public class CoreApi {
    /**
     * 获取MovieService
     */
    public static MovieService movie() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(MovieService.DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL).build();
        return adapter.create(MovieService.class);
    }
}
