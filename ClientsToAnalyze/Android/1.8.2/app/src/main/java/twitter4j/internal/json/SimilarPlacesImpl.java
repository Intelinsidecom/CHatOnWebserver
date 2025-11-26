package twitter4j.internal.json;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.SimilarPlaces;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;

/* loaded from: classes.dex */
public class SimilarPlacesImpl extends ResponseListImpl implements SimilarPlaces {
    private static final long serialVersionUID = -7897806745732767803L;
    private final String token;

    @Override // twitter4j.internal.json.ResponseListImpl, twitter4j.TwitterResponse
    public int getAccessLevel() {
        return super.getAccessLevel();
    }

    @Override // twitter4j.internal.json.ResponseListImpl, twitter4j.ResponseList
    public RateLimitStatus getFeatureSpecificRateLimitStatus() {
        return super.getFeatureSpecificRateLimitStatus();
    }

    @Override // twitter4j.internal.json.ResponseListImpl, twitter4j.ResponseList, twitter4j.TwitterResponse
    public RateLimitStatus getRateLimitStatus() {
        return super.getRateLimitStatus();
    }

    SimilarPlacesImpl(ResponseList responseList, HttpResponse httpResponse, String str) {
        super(responseList.size(), httpResponse);
        addAll(responseList);
        this.token = str;
    }

    @Override // twitter4j.SimilarPlaces
    public String getToken() {
        return this.token;
    }

    static SimilarPlaces createSimilarPlaces(HttpResponse httpResponse, Configuration configuration) throws JSONException, TwitterException, IOException {
        JSONObject jSONObjectAsJSONObject = null;
        try {
            jSONObjectAsJSONObject = httpResponse.asJSONObject();
            JSONObject jSONObject = jSONObjectAsJSONObject.getJSONObject("result");
            return new SimilarPlacesImpl(PlaceJSONImpl.createPlaceList(jSONObject.getJSONArray("places"), httpResponse, configuration), httpResponse, jSONObject.getString("token"));
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(jSONObjectAsJSONObject.toString()).toString(), e);
        }
    }
}
