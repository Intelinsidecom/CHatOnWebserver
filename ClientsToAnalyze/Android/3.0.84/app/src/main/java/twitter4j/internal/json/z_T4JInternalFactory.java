package twitter4j.internal.json;

import java.io.Serializable;
import org.json.JSONObject;
import twitter4j.AccountSettings;
import twitter4j.AccountTotals;
import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.Friendship;
import twitter4j.IDs;
import twitter4j.Location;
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
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.api.HelpMethods;
import twitter4j.internal.http.HttpResponse;

/* loaded from: classes.dex */
public interface z_T4JInternalFactory extends Serializable {
    UserList createAUserList(JSONObject jSONObject);

    UserList createAUserList(HttpResponse httpResponse);

    AccountSettings createAccountSettings(HttpResponse httpResponse);

    AccountTotals createAccountTotals(HttpResponse httpResponse);

    ResponseList<Category> createCategoryList(HttpResponse httpResponse);

    DirectMessage createDirectMessage(JSONObject jSONObject);

    DirectMessage createDirectMessage(HttpResponse httpResponse);

    ResponseList<DirectMessage> createDirectMessageList(HttpResponse httpResponse);

    <T> ResponseList<T> createEmptyResponseList();

    ResponseList<Friendship> createFriendshipList(HttpResponse httpResponse);

    IDs createIDs(HttpResponse httpResponse);

    ResponseList<HelpMethods.Language> createLanguageList(HttpResponse httpResponse);

    ResponseList<Location> createLocationList(HttpResponse httpResponse);

    PagableResponseList<User> createPagableUserList(HttpResponse httpResponse);

    PagableResponseList<UserList> createPagableUserListList(HttpResponse httpResponse);

    Place createPlace(HttpResponse httpResponse);

    ResponseList<Place> createPlaceList(HttpResponse httpResponse);

    ProfileImage createProfileImage(HttpResponse httpResponse);

    QueryResult createQueryResult(HttpResponse httpResponse, Query query);

    RateLimitStatus createRateLimitStatus(HttpResponse httpResponse);

    RelatedResults createRelatedResults(HttpResponse httpResponse);

    Relationship createRelationship(HttpResponse httpResponse);

    SavedSearch createSavedSearch(HttpResponse httpResponse);

    ResponseList<SavedSearch> createSavedSearchList(HttpResponse httpResponse);

    SimilarPlaces createSimilarPlaces(HttpResponse httpResponse);

    Status createStatus(JSONObject jSONObject);

    Status createStatus(HttpResponse httpResponse);

    ResponseList<Status> createStatusList(HttpResponse httpResponse);

    Trends createTrends(HttpResponse httpResponse);

    ResponseList<Trends> createTrendsList(HttpResponse httpResponse);

    TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse httpResponse);

    User createUser(JSONObject jSONObject);

    User createUser(HttpResponse httpResponse);

    ResponseList<User> createUserList(HttpResponse httpResponse);

    ResponseList<User> createUserListFromJSONArray(HttpResponse httpResponse);

    ResponseList<User> createUserListFromJSONArray_Users(HttpResponse httpResponse);

    ResponseList<UserList> createUserListList(HttpResponse httpResponse);
}
