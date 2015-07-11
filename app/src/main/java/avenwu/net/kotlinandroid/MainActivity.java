package avenwu.net.kotlinandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import avenwu.net.kotlinandroid.api.CoreApi;
import avenwu.net.kotlinandroid.pojo.CategoryData;
import avenwu.net.kotlinandroid.pojo.CategoryJsonData;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    List<CategoryData> mCategoryList = new ArrayList<CategoryData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

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
                if (categoryDatas.size() <= 0) {
                    CoreApi.movie().getCategoryList(new Callback<List<CategoryData>>() {
                        @Override
                        public void success(List<CategoryData> categoryDatas, Response response) {
                            mCategoryList.addAll(categoryDatas);
                            notifyTabLayout();
                            AsyncTaskCompat.executeParallel(new AsyncTask<List<CategoryData>, Void,
                                    Void>() {
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
                            }, categoryDatas);
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(MainActivity.this, R.string.request_failed, Toast
                                    .LENGTH_SHORT).show();
                        }
                    });
                } else {
                    mCategoryList.addAll(categoryDatas);
                    notifyTabLayout();
                }
            }
        });


    }

    private void notifyTabLayout() {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return HomeListFragment.newInstance(Integer.parseInt(mCategoryList.get(position).cateid));
            }

            @Override
            public int getCount() {
                return mCategoryList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mCategoryList.get(position).catename;
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
