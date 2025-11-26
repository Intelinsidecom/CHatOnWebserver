package twitter4j.internal.json;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.RelatedResults;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;

/* loaded from: classes.dex */
final class RelatedResultsJSONImpl extends TwitterResponseImpl implements Serializable, RelatedResults {
    private static final String TWEETS_FROM_USER = "TweetsFromUser";
    private static final String TWEETS_WITH_CONVERSATION = "TweetsWithConversation";
    private static final String TWEETS_WITH_REPLY = "TweetsWithReply";
    private static final long serialVersionUID = -7417061781993004083L;
    private Map<String, ResponseList<Status>> tweetsMap;

    RelatedResultsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IllegalArgumentException, InvocationTargetException {
        super(httpResponse);
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
        }
        init(httpResponse.asJSONArray(), httpResponse, configuration.isJSONStoreEnabled());
    }

    RelatedResultsJSONImpl(JSONArray jSONArray) throws JSONException, TwitterException {
        init(jSONArray, null, false);
    }

    private void init(JSONArray jSONArray, HttpResponse httpResponse, boolean z) throws JSONException, TwitterException {
        ResponseList<Status> responseList;
        this.tweetsMap = new HashMap(2);
        try {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if ("Tweet".equals(jSONObject.getString("resultType"))) {
                    String string = jSONObject.getString("groupName");
                    if (string.length() != 0 && (string.equals(TWEETS_WITH_CONVERSATION) || string.equals(TWEETS_WITH_REPLY) || string.equals(TWEETS_FROM_USER))) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("results");
                        ResponseList<Status> responseList2 = this.tweetsMap.get(string);
                        if (responseList2 == null) {
                            ResponseListImpl responseListImpl = new ResponseListImpl(jSONArray2.length(), httpResponse);
                            this.tweetsMap.put(string, responseListImpl);
                            responseList = responseListImpl;
                        } else {
                            responseList = responseList2;
                        }
                        int length2 = jSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i2).getJSONObject("value");
                            StatusJSONImpl statusJSONImpl = new StatusJSONImpl(jSONObject2);
                            if (z) {
                                DataObjectFactoryUtil.registerJSONObject(statusJSONImpl, jSONObject2);
                            }
                            responseList.add(statusJSONImpl);
                        }
                        if (z) {
                            DataObjectFactoryUtil.registerJSONObject(responseList, jSONArray2);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    @Override // twitter4j.RelatedResults
    public ResponseList<Status> getTweetsWithConversation() {
        ResponseList<Status> responseList = this.tweetsMap.get(TWEETS_WITH_CONVERSATION);
        return responseList != null ? responseList : new ResponseListImpl(0, null);
    }

    @Override // twitter4j.RelatedResults
    public ResponseList<Status> getTweetsWithReply() {
        ResponseList<Status> responseList = this.tweetsMap.get(TWEETS_WITH_REPLY);
        return responseList != null ? responseList : new ResponseListImpl(0, null);
    }

    @Override // twitter4j.RelatedResults
    public ResponseList<Status> getTweetsFromUser() {
        ResponseList<Status> responseList = this.tweetsMap.get(TWEETS_FROM_USER);
        return responseList != null ? responseList : new ResponseListImpl(0, null);
    }

    public int hashCode() {
        return this.tweetsMap.hashCode() + 31;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RelatedResultsJSONImpl)) {
            return false;
        }
        RelatedResultsJSONImpl relatedResultsJSONImpl = (RelatedResultsJSONImpl) obj;
        if (this.tweetsMap == null) {
            if (relatedResultsJSONImpl.tweetsMap != null) {
                return false;
            }
        } else if (!this.tweetsMap.equals(relatedResultsJSONImpl.tweetsMap)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return new StringBuffer().append("RelatedResultsJSONImpl {tweetsMap=").append(this.tweetsMap).append("}").toString();
    }
}
