package avenwu.net.vplus.presenter;

import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.avenwu.support.presenter.Presenter;

import avenwu.net.vplus.api.CoreApi;
import avenwu.net.vplus.pojo.BackstageCategoryData;
import avenwu.net.vplus.pojo.StageCategoryJsonData;
import io.realm.Realm;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by chaobin on 7/14/15.
 */
public class StagePresenter extends Presenter {
    public static final String ACTION_GET_CACHED_CATEGORY = "action_get_cached_category";
    public static final String ACTION_QUERY_CATEGORY = "action_query_category";

    public void getCachedCategoryList() {
        AsyncTaskCompat.executeParallel(new AsyncTask<Void, Void, BackstageCategoryData>() {
            @Override
            protected BackstageCategoryData doInBackground(Void... params) {
                BackstageCategoryData categoryList = null;
                Realm realm = Realm.getDefaultInstance();
                StageCategoryJsonData jsonData = realm.where(StageCategoryJsonData.class).findFirst();
                if (jsonData != null && !TextUtils.isEmpty(jsonData.getJson())) {
                    Gson gson = new GsonBuilder().create();
                    categoryList = gson.fromJson(jsonData.getJson(), BackstageCategoryData.class);
                }
                realm.close();
                return categoryList;
            }

            @Override
            protected void onPostExecute(BackstageCategoryData categoryDatas) {
                invoke(ACTION_GET_CACHED_CATEGORY, categoryDatas);
            }
        });
    }

    public void queryOnlineCategory() {
        CoreApi.movie().getBackstageCategory(addCallback(new DetachableCallback<BackstageCategoryData>(
                new Callback<BackstageCategoryData>() {
                    @Override
                    public void success(BackstageCategoryData categoryDatas, Response response) {
                        invoke(ACTION_QUERY_CATEGORY, categoryDatas);
                        saveCategory2Cache(categoryDatas);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        invoke(ACTION_QUERY_CATEGORY, null);
                    }
                })));
    }

    private void saveCategory2Cache(BackstageCategoryData data) {
        AsyncTaskCompat.executeParallel(new AsyncTask<BackstageCategoryData, Void, Void>() {
            @Override
            protected Void doInBackground(BackstageCategoryData... params) {
                Gson gson = new GsonBuilder().create();
                String json = gson.toJson(params[0], BackstageCategoryData.class);
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                StageCategoryJsonData data = new StageCategoryJsonData();
                data.setJson(json);
                realm.copyToRealm(data);
                realm.commitTransaction();
                realm.close();
                return null;
            }
        }, data);
    }
}
