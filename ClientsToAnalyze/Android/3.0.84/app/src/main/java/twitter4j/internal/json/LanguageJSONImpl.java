package twitter4j.internal.json;

import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.api.HelpMethods;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;

/* loaded from: classes.dex */
public class LanguageJSONImpl implements HelpMethods.Language {
    private String code;
    private String name;
    private String status;

    LanguageJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.name = jSONObject.getString("name");
            this.code = jSONObject.getString("code");
            this.status = jSONObject.getString("status");
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(jSONObject.toString()).toString(), e);
        }
    }

    @Override // twitter4j.api.HelpMethods.Language
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.api.HelpMethods.Language
    public String getCode() {
        return this.code;
    }

    @Override // twitter4j.api.HelpMethods.Language
    public String getStatus() {
        return this.status;
    }

    static ResponseList<HelpMethods.Language> createLanguageList(HttpResponse httpResponse, Configuration configuration) {
        return createLanguageList(httpResponse.asJSONArray(), httpResponse, configuration);
    }

    static ResponseList<HelpMethods.Language> createLanguageList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IllegalArgumentException, InvocationTargetException {
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
        }
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                LanguageJSONImpl languageJSONImpl = new LanguageJSONImpl(jSONObject);
                responseListImpl.add(languageJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(languageJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        } catch (TwitterException e2) {
            throw e2;
        }
    }
}
