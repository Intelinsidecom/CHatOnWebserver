package twitter4j.internal.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.AccountSettings;
import twitter4j.AccountTotals;
import twitter4j.DirectMessage;
import twitter4j.GeoLocation;
import twitter4j.IDs;
import twitter4j.PagableResponseList;
import twitter4j.Place;
import twitter4j.ProfileImage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.RelatedResults;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.SimilarPlaces;
import twitter4j.Status;
import twitter4j.Trends;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalStringUtil;

/* loaded from: classes.dex */
public class z_T4JInternalJSONImplFactory implements z_T4JInternalFactory {
    private Configuration conf;

    public z_T4JInternalJSONImplFactory(Configuration configuration) {
        this.conf = configuration;
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public Status createStatus(JSONObject jSONObject) {
        return new StatusJSONImpl(jSONObject);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public User createUser(JSONObject jSONObject) {
        return new UserJSONImpl(jSONObject);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public UserList createAUserList(JSONObject jSONObject) {
        return new UserListJSONImpl(jSONObject);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public DirectMessage createDirectMessage(JSONObject jSONObject) {
        return new DirectMessageJSONImpl(jSONObject);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public RateLimitStatus createRateLimitStatus(HttpResponse httpResponse) {
        return new RateLimitStatusJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public Status createStatus(HttpResponse httpResponse) {
        return new StatusJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createStatusList(HttpResponse httpResponse) {
        return StatusJSONImpl.createStatusList(httpResponse, this.conf);
    }

    static GeoLocation createGeoLocation(JSONObject jSONObject) throws JSONException, TwitterException {
        try {
            if (!jSONObject.isNull("geo")) {
                String[] strArrSplit = z_T4JInternalStringUtil.split(jSONObject.getJSONObject("geo").getString("coordinates").substring(1, r0.length() - 1), ",");
                return new GeoLocation(Double.parseDouble(strArrSplit[0]), Double.parseDouble(strArrSplit[1]));
            }
            return null;
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    static GeoLocation[][] coordinatesAsGeoLocationArray(JSONArray jSONArray) throws JSONException, TwitterException {
        try {
            GeoLocation[][] geoLocationArr = new GeoLocation[jSONArray.length()][];
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                geoLocationArr[i] = new GeoLocation[jSONArray2.length()];
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONArray jSONArray3 = jSONArray2.getJSONArray(i2);
                    geoLocationArr[i][i2] = new GeoLocation(jSONArray3.getDouble(1), jSONArray3.getDouble(0));
                }
            }
            return geoLocationArr;
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    public static RateLimitStatus createRateLimitStatusFromResponseHeader(HttpResponse httpResponse) {
        return RateLimitStatusJSONImpl.createFromResponseHeader(httpResponse);
    }

    public static RateLimitStatus createFeatureSpecificRateLimitStatusFromResponseHeader(HttpResponse httpResponse) {
        return RateLimitStatusJSONImpl.createFeatureSpecificRateLimitStatusFromResponseHeader(httpResponse);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public Trends createTrends(HttpResponse httpResponse) {
        return new TrendsJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createTrendsList(HttpResponse httpResponse) {
        return TrendsJSONImpl.createTrendsList(httpResponse, this.conf.isJSONStoreEnabled());
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public User createUser(HttpResponse httpResponse) {
        return new UserJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createUserList(HttpResponse httpResponse) {
        return UserJSONImpl.createUserList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createUserListFromJSONArray(HttpResponse httpResponse) {
        return UserJSONImpl.createUserList(httpResponse.asJSONArray(), httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createUserListFromJSONArray_Users(HttpResponse httpResponse) throws TwitterException {
        try {
            return UserJSONImpl.createUserList(httpResponse.asJSONObject().getJSONArray("users"), httpResponse, this.conf);
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public QueryResult createQueryResult(HttpResponse httpResponse, Query query) throws TwitterException {
        try {
            return new QueryResultJSONImpl(httpResponse, this.conf);
        } catch (TwitterException e) {
            if (404 == e.getStatusCode()) {
                return new QueryResultJSONImpl(query);
            }
            throw e;
        }
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public IDs createIDs(HttpResponse httpResponse) {
        return new IDsJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public PagableResponseList createPagableUserList(HttpResponse httpResponse) {
        return UserJSONImpl.createPagableUserList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public UserList createAUserList(HttpResponse httpResponse) {
        return new UserListJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public PagableResponseList createPagableUserListList(HttpResponse httpResponse) {
        return UserListJSONImpl.createPagableUserListList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createUserListList(HttpResponse httpResponse) {
        return UserListJSONImpl.createUserListList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createCategoryList(HttpResponse httpResponse) {
        return CategoryJSONImpl.createCategoriesList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ProfileImage createProfileImage(HttpResponse httpResponse) {
        return new ProfileImageImpl(httpResponse);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public DirectMessage createDirectMessage(HttpResponse httpResponse) {
        return new DirectMessageJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createDirectMessageList(HttpResponse httpResponse) {
        return DirectMessageJSONImpl.createDirectMessageList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public Relationship createRelationship(HttpResponse httpResponse) {
        return new RelationshipJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createFriendshipList(HttpResponse httpResponse) {
        return FriendshipJSONImpl.createFriendshipList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public AccountTotals createAccountTotals(HttpResponse httpResponse) {
        return new AccountTotalsJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public AccountSettings createAccountSettings(HttpResponse httpResponse) {
        return new AccountSettingsJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public SavedSearch createSavedSearch(HttpResponse httpResponse) {
        return new SavedSearchJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createSavedSearchList(HttpResponse httpResponse) {
        return SavedSearchJSONImpl.createSavedSearchList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createLocationList(HttpResponse httpResponse) {
        return LocationJSONImpl.createLocationList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public Place createPlace(HttpResponse httpResponse) {
        return new PlaceJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createPlaceList(HttpResponse httpResponse) throws TwitterException {
        try {
            return PlaceJSONImpl.createPlaceList(httpResponse, this.conf);
        } catch (TwitterException e) {
            if (e.getStatusCode() == 404) {
                return new ResponseListImpl(0, null);
            }
            throw e;
        }
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public SimilarPlaces createSimilarPlaces(HttpResponse httpResponse) {
        return SimilarPlacesImpl.createSimilarPlaces(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public RelatedResults createRelatedResults(HttpResponse httpResponse) {
        return new RelatedResultsJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse httpResponse) {
        return new TwitterAPIConfigurationJSONImpl(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createLanguageList(HttpResponse httpResponse) {
        return LanguageJSONImpl.createLanguageList(httpResponse, this.conf);
    }

    @Override // twitter4j.internal.json.z_T4JInternalFactory
    public ResponseList createEmptyResponseList() {
        return new ResponseListImpl(0, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z_T4JInternalJSONImplFactory)) {
            return false;
        }
        z_T4JInternalJSONImplFactory z_t4jinternaljsonimplfactory = (z_T4JInternalJSONImplFactory) obj;
        if (this.conf != null) {
            if (this.conf.equals(z_t4jinternaljsonimplfactory.conf)) {
                return true;
            }
        } else if (z_t4jinternaljsonimplfactory.conf == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.conf != null) {
            return this.conf.hashCode();
        }
        return 0;
    }

    public String toString() {
        return new StringBuffer().append("JSONImplFactory{conf=").append(this.conf).append('}').toString();
    }
}
