package twitter4j.internal.json;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Category;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class CategoryJSONImpl implements Serializable, Category {
    private static final long serialVersionUID = -6703617743623288566L;
    private String name;
    private int size;
    private String slug;

    CategoryJSONImpl(JSONObject jSONObject) {
        init(jSONObject);
    }

    void init(JSONObject jSONObject) {
        this.name = jSONObject.getString("name");
        this.slug = jSONObject.getString("slug");
        this.size = z_T4JInternalParseUtil.getInt("size", jSONObject);
    }

    static ResponseList createCategoriesList(HttpResponse httpResponse, Configuration configuration) {
        return createCategoriesList(httpResponse.asJSONArray(), httpResponse, configuration);
    }

    static ResponseList createCategoriesList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IllegalArgumentException, InvocationTargetException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            ResponseListImpl responseListImpl = new ResponseListImpl(jSONArray.length(), httpResponse);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                CategoryJSONImpl categoryJSONImpl = new CategoryJSONImpl(jSONObject);
                responseListImpl.add(categoryJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(categoryJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    @Override // twitter4j.Category
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.Category
    public String getSlug() {
        return this.slug;
    }

    @Override // twitter4j.Category
    public int getSize() {
        return this.size;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CategoryJSONImpl categoryJSONImpl = (CategoryJSONImpl) obj;
        if (this.size != categoryJSONImpl.size) {
            return false;
        }
        if (this.name == null ? categoryJSONImpl.name != null : !this.name.equals(categoryJSONImpl.name)) {
            return false;
        }
        if (this.slug != null) {
            if (this.slug.equals(categoryJSONImpl.slug)) {
                return true;
            }
        } else if (categoryJSONImpl.slug == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.name != null ? this.name.hashCode() : 0) * 31) + (this.slug != null ? this.slug.hashCode() : 0)) * 31) + this.size;
    }

    public String toString() {
        return new StringBuffer().append("CategoryJSONImpl{name='").append(this.name).append('\'').append(", slug='").append(this.slug).append('\'').append(", size=").append(this.size).append('}').toString();
    }
}
