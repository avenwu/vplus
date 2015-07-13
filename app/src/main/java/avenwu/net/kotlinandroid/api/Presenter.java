package avenwu.net.kotlinandroid.api;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by chaobin on 7/12/15.
 */
public class Presenter {
    List<DetachableCallback<?>> mCallback = new ArrayList<>();

    public void attach() {

    }

    public <T> Callback<T> addCallback(DetachableCallback<T> callback) {
        mCallback.add(callback);
        return callback;
    }

    public void detach() {
        for (DetachableCallback<?> callback : mCallback) {
            callback.detach();
        }
    }

    protected static class DetachableCallback<T> implements Callback<T> {
        Callback<T> callback;

        public DetachableCallback(Callback<T> callback) {
            this.callback = callback;
        }

        @Override
        public void success(T t, Response response) {
            if (callback != null) {
                callback.success(t, response);
            }
        }

        @Override
        public void failure(RetrofitError error) {
            if (callback != null) {
                callback.failure(error);
            }
        }

        public void detach() {
            callback = null;
        }
    }
}
