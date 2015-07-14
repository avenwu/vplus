package avenwu.net.vplus.api;

import avenwu.net.vplus.BuildConfig;
import retrofit.RestAdapter;

/**
 * Created by chaobin on 7/1/15.
 */
public class CoreApi {
    static MovieService sMovieService;

    static {
        sMovieService = new RestAdapter.Builder()
                .setEndpoint(MovieService.DOMAIN)
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .build()
                .create(MovieService.class);
    }

    /**
     * 获取MovieService
     */
    public static MovieService movie() {
        return sMovieService;
    }
}
