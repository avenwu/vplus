package avenwu.net.kotlinandroid.pojo;

import io.realm.RealmObject;

/**
 * Created by chaobin on 7/11/15.
 */
public class CategoryJsonData extends RealmObject {
    private String json;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
