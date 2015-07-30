package avenwu.net.vplus.presenter;

import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import net.avenwu.support.presenter.Presenter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import avenwu.net.vplus.api.CoreApi;
import avenwu.net.vplus.pojo.CategoryData;
import avenwu.net.vplus.pojo.CategoryJsonData;
import io.realm.Realm;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by chaobin on 7/14/15.
 */
public class HomePresenter extends Presenter {
    public static final String ACTION_GET_CACHED_CATEGORY = "action_get_cached_category";
    public static final String ACTION_QUERY_CATEGORY = "action_query_category";

    public void getCachedCategoryList() {
        AsyncTaskCompat.executeParallel(new AsyncTask<Void, Void, List<CategoryData>>() {
            @Override
            protected List<CategoryData> doInBackground(Void... params) {
                List<CategoryData> categoryList;
                Realm realm = Realm.getDefaultInstance();
                CategoryJsonData jsonData = realm.where(CategoryJsonData.class).findFirst();
                if (jsonData != null && !TextUtils.isEmpty(jsonData.getJson())) {
                    Gson gson = new GsonBuilder().create();
                    Type collectionType = new TypeToken<Collection<CategoryData>>() {
                    }.getType();
                    categoryList = gson.fromJson(jsonData.getJson(), collectionType);
                } else {
                    categoryList = new ArrayList<CategoryData>(0);
                }
                realm.close();
                return categoryList;
            }

            @Override
            protected void onPostExecute(List<CategoryData> categoryDatas) {
                invoke(ACTION_GET_CACHED_CATEGORY, categoryDatas);
            }
        });
    }

    public void queryOnlineCategory() {
        CoreApi.movie().getCategoryList(addCallback(new DetachableCallback<List<CategoryData>>(
                new Callback<List<CategoryData>>() {
                    @Override
                    public void success(List<CategoryData> categoryDatas, Response response) {
                        invoke(ACTION_QUERY_CATEGORY, categoryDatas);
                        saveCategory2Cache(categoryDatas);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        invoke(ACTION_QUERY_CATEGORY, null);
                    }
                })));
    }

    private void saveCategory2Cache(List<CategoryData> dataList) {
        AsyncTaskCompat.executeParallel(new AsyncTask<List<CategoryData>, Void, Void>() {
            @Override
            protected Void doInBackground(List<CategoryData>... params) {
                Gson gson = new GsonBuilder().create();
                Type collectionType = new TypeToken<Collection<CategoryData>>() {
                }.getType();
                String json = gson.toJson(params[0], collectionType);
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                CategoryJsonData data = new CategoryJsonData();
                data.setJson(json);
                realm.copyToRealm(data);
                realm.commitTransaction();
                realm.close();
                return null;
            }
        }, dataList);
    }
}
