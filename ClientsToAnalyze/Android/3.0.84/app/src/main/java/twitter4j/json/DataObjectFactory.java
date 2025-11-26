package twitter4j.json;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.AccountTotals;
import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.Place;
import twitter4j.RateLimitStatus;
import twitter4j.RelatedResults;
import twitter4j.Relationship;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Tweet;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;

/* loaded from: classes.dex */
public final class DataObjectFactory {
    private static final Constructor<IDs> IDsConstructor;
    private static final Constructor<AccountTotals> accountTotalsConstructor;
    private static final Constructor<Category> categoryConstructor;
    static Class class$java$lang$String;
    static Class class$org$json$JSONArray;
    static Class class$org$json$JSONObject;
    private static final Constructor<DirectMessage> directMessageConstructor;
    private static final Constructor<Location> locationConstructor;
    private static final Constructor<Place> placeConstructor;
    private static final Constructor<RateLimitStatus> rateLimitStatusConstructor;
    private static final ThreadLocal<Map> rawJsonMap;
    private static final Constructor<RelatedResults> relatedResultsConstructor;
    private static final Constructor<Relationship> relationshipConstructor;
    private static final Constructor<SavedSearch> savedSearchConstructor;
    private static final Constructor<Status> statusConstructor;
    private static final Constructor<StatusDeletionNotice> statusDeletionNoticeConstructor;
    private static final Constructor<Trend> trendConstructor;
    private static final Constructor<Trends> trendsConstructor;
    private static final Constructor<Tweet> tweetConstructor;
    private static final Constructor<User> userConstructor;
    private static final Constructor<UserList> userListConstructor;

    private DataObjectFactory() {
        throw new AssertionError("not intended to be instantiated.");
    }

    static {
        Class<?> clsClass$;
        Class<?> clsClass$2;
        Class<?> clsClass$3;
        Class<?> clsClass$4;
        Class<?> clsClass$5;
        Class<?> clsClass$6;
        Class<?> clsClass$7;
        Class<?> clsClass$8;
        Class<?> clsClass$9;
        Class<?> clsClass$10;
        Class<?> clsClass$11;
        Class<?> clsClass$12;
        Class<?> clsClass$13;
        Class<?> clsClass$14;
        Class<?> clsClass$15;
        Class<?> clsClass$16;
        Class<?> clsClass$17;
        try {
            Class<?> cls = Class.forName("twitter4j.internal.json.StatusJSONImpl");
            Class<?>[] clsArr = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$ = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$;
            } else {
                clsClass$ = class$org$json$JSONObject;
            }
            clsArr[0] = clsClass$;
            statusConstructor = cls.getDeclaredConstructor(clsArr);
            statusConstructor.setAccessible(true);
            Class<?> cls2 = Class.forName("twitter4j.internal.json.UserJSONImpl");
            Class<?>[] clsArr2 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$2 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$2;
            } else {
                clsClass$2 = class$org$json$JSONObject;
            }
            clsArr2[0] = clsClass$2;
            userConstructor = cls2.getDeclaredConstructor(clsArr2);
            userConstructor.setAccessible(true);
            Class<?> cls3 = Class.forName("twitter4j.internal.json.TweetJSONImpl");
            Class<?>[] clsArr3 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$3 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$3;
            } else {
                clsClass$3 = class$org$json$JSONObject;
            }
            clsArr3[0] = clsClass$3;
            tweetConstructor = cls3.getDeclaredConstructor(clsArr3);
            tweetConstructor.setAccessible(true);
            Class<?> cls4 = Class.forName("twitter4j.internal.json.RelationshipJSONImpl");
            Class<?>[] clsArr4 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$4 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$4;
            } else {
                clsClass$4 = class$org$json$JSONObject;
            }
            clsArr4[0] = clsClass$4;
            relationshipConstructor = cls4.getDeclaredConstructor(clsArr4);
            relationshipConstructor.setAccessible(true);
            Class<?> cls5 = Class.forName("twitter4j.internal.json.PlaceJSONImpl");
            Class<?>[] clsArr5 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$5 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$5;
            } else {
                clsClass$5 = class$org$json$JSONObject;
            }
            clsArr5[0] = clsClass$5;
            placeConstructor = cls5.getDeclaredConstructor(clsArr5);
            placeConstructor.setAccessible(true);
            Class<?> cls6 = Class.forName("twitter4j.internal.json.SavedSearchJSONImpl");
            Class<?>[] clsArr6 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$6 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$6;
            } else {
                clsClass$6 = class$org$json$JSONObject;
            }
            clsArr6[0] = clsClass$6;
            savedSearchConstructor = cls6.getDeclaredConstructor(clsArr6);
            savedSearchConstructor.setAccessible(true);
            Class<?> cls7 = Class.forName("twitter4j.internal.json.TrendJSONImpl");
            Class<?>[] clsArr7 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$7 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$7;
            } else {
                clsClass$7 = class$org$json$JSONObject;
            }
            clsArr7[0] = clsClass$7;
            trendConstructor = cls7.getDeclaredConstructor(clsArr7);
            trendConstructor.setAccessible(true);
            Class<?> cls8 = Class.forName("twitter4j.internal.json.TrendsJSONImpl");
            Class<?>[] clsArr8 = new Class[1];
            if (class$java$lang$String == null) {
                clsClass$8 = class$("java.lang.String");
                class$java$lang$String = clsClass$8;
            } else {
                clsClass$8 = class$java$lang$String;
            }
            clsArr8[0] = clsClass$8;
            trendsConstructor = cls8.getDeclaredConstructor(clsArr8);
            trendsConstructor.setAccessible(true);
            Class<?> cls9 = Class.forName("twitter4j.internal.json.IDsJSONImpl");
            Class<?>[] clsArr9 = new Class[1];
            if (class$java$lang$String == null) {
                clsClass$9 = class$("java.lang.String");
                class$java$lang$String = clsClass$9;
            } else {
                clsClass$9 = class$java$lang$String;
            }
            clsArr9[0] = clsClass$9;
            IDsConstructor = cls9.getDeclaredConstructor(clsArr9);
            IDsConstructor.setAccessible(true);
            Class<?> cls10 = Class.forName("twitter4j.internal.json.RateLimitStatusJSONImpl");
            Class<?>[] clsArr10 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$10 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$10;
            } else {
                clsClass$10 = class$org$json$JSONObject;
            }
            clsArr10[0] = clsClass$10;
            rateLimitStatusConstructor = cls10.getDeclaredConstructor(clsArr10);
            rateLimitStatusConstructor.setAccessible(true);
            Class<?> cls11 = Class.forName("twitter4j.internal.json.CategoryJSONImpl");
            Class<?>[] clsArr11 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$11 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$11;
            } else {
                clsClass$11 = class$org$json$JSONObject;
            }
            clsArr11[0] = clsClass$11;
            categoryConstructor = cls11.getDeclaredConstructor(clsArr11);
            categoryConstructor.setAccessible(true);
            Class<?> cls12 = Class.forName("twitter4j.internal.json.DirectMessageJSONImpl");
            Class<?>[] clsArr12 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$12 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$12;
            } else {
                clsClass$12 = class$org$json$JSONObject;
            }
            clsArr12[0] = clsClass$12;
            directMessageConstructor = cls12.getDeclaredConstructor(clsArr12);
            directMessageConstructor.setAccessible(true);
            Class<?> cls13 = Class.forName("twitter4j.internal.json.LocationJSONImpl");
            Class<?>[] clsArr13 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$13 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$13;
            } else {
                clsClass$13 = class$org$json$JSONObject;
            }
            clsArr13[0] = clsClass$13;
            locationConstructor = cls13.getDeclaredConstructor(clsArr13);
            locationConstructor.setAccessible(true);
            Class<?> cls14 = Class.forName("twitter4j.internal.json.UserListJSONImpl");
            Class<?>[] clsArr14 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$14 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$14;
            } else {
                clsClass$14 = class$org$json$JSONObject;
            }
            clsArr14[0] = clsClass$14;
            userListConstructor = cls14.getDeclaredConstructor(clsArr14);
            userListConstructor.setAccessible(true);
            Class<?> cls15 = Class.forName("twitter4j.internal.json.RelatedResultsJSONImpl");
            Class<?>[] clsArr15 = new Class[1];
            if (class$org$json$JSONArray == null) {
                clsClass$15 = class$("org.json.JSONArray");
                class$org$json$JSONArray = clsClass$15;
            } else {
                clsClass$15 = class$org$json$JSONArray;
            }
            clsArr15[0] = clsClass$15;
            relatedResultsConstructor = cls15.getDeclaredConstructor(clsArr15);
            relatedResultsConstructor.setAccessible(true);
            Class<?> cls16 = Class.forName("twitter4j.StatusDeletionNoticeImpl");
            Class<?>[] clsArr16 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$16 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$16;
            } else {
                clsClass$16 = class$org$json$JSONObject;
            }
            clsArr16[0] = clsClass$16;
            statusDeletionNoticeConstructor = cls16.getDeclaredConstructor(clsArr16);
            statusDeletionNoticeConstructor.setAccessible(true);
            Class<?> cls17 = Class.forName("twitter4j.internal.json.AccountTotalsJSONImpl");
            Class<?>[] clsArr17 = new Class[1];
            if (class$org$json$JSONObject == null) {
                clsClass$17 = class$("org.json.JSONObject");
                class$org$json$JSONObject = clsClass$17;
            } else {
                clsClass$17 = class$org$json$JSONObject;
            }
            clsArr17[0] = clsClass$17;
            accountTotalsConstructor = cls17.getDeclaredConstructor(clsArr17);
            accountTotalsConstructor.setAccessible(true);
            rawJsonMap = new ThreadLocal<Map>() { // from class: twitter4j.json.DataObjectFactory.1
                @Override // java.lang.ThreadLocal
                protected Map initialValue() {
                    return initialValue2();
                }

                @Override // java.lang.ThreadLocal
                /* renamed from: initialValue, reason: avoid collision after fix types in other method */
                protected Map initialValue2() {
                    return new HashMap();
                }
            };
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        } catch (NoSuchMethodException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static String getRawJSON(Object obj) {
        Object obj2 = rawJsonMap.get().get(obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 != null) {
            return obj2.toString();
        }
        return null;
    }

    public static Status createStatus(String str) throws TwitterException {
        try {
            return statusConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static User createUser(String str) throws TwitterException {
        try {
            return userConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static AccountTotals createAccountTotals(String str) throws TwitterException {
        try {
            return accountTotalsConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static Tweet createTweet(String str) throws TwitterException {
        try {
            return tweetConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static Relationship createRelationship(String str) throws TwitterException {
        try {
            return relationshipConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static Place createPlace(String str) throws TwitterException {
        try {
            return placeConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static SavedSearch createSavedSearch(String str) throws TwitterException {
        try {
            return savedSearchConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static Trend createTrend(String str) throws TwitterException {
        try {
            return trendConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static Trends createTrends(String str) throws TwitterException {
        try {
            return trendsConstructor.newInstance(str);
        } catch (IllegalAccessException e) {
            throw new TwitterException(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    public static IDs createIDs(String str) throws TwitterException {
        try {
            return IDsConstructor.newInstance(str);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        }
    }

    public static RateLimitStatus createRateLimitStatus(String str) throws TwitterException {
        try {
            return rateLimitStatusConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static Category createCategory(String str) throws TwitterException {
        try {
            return categoryConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static DirectMessage createDirectMessage(String str) throws TwitterException {
        try {
            return directMessageConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static Location createLocation(String str) throws TwitterException {
        try {
            return locationConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static UserList createUserList(String str) throws TwitterException {
        try {
            return userListConstructor.newInstance(new JSONObject(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static RelatedResults createRelatedResults(String str) throws TwitterException {
        try {
            return relatedResultsConstructor.newInstance(new JSONArray(str));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    public static Object createObject(String str) throws TwitterException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObjectType jSONObjectTypeDetermine = JSONObjectType.determine(jSONObject);
            if (JSONObjectType.SENDER == jSONObjectTypeDetermine) {
                return registerJSONObject(directMessageConstructor.newInstance(jSONObject.getJSONObject("direct_message")), jSONObject);
            }
            if (JSONObjectType.STATUS == jSONObjectTypeDetermine) {
                return registerJSONObject(statusConstructor.newInstance(jSONObject), jSONObject);
            }
            if (JSONObjectType.DIRECT_MESSAGE == jSONObjectTypeDetermine) {
                return registerJSONObject(directMessageConstructor.newInstance(jSONObject.getJSONObject("direct_message")), jSONObject);
            }
            if (JSONObjectType.DELETE == jSONObjectTypeDetermine) {
                return registerJSONObject(statusDeletionNoticeConstructor.newInstance(jSONObject.getJSONObject("delete").getJSONObject("status")), jSONObject);
            }
            if (JSONObjectType.LIMIT == jSONObjectTypeDetermine || JSONObjectType.SCRUB_GEO == jSONObjectTypeDetermine) {
            }
            return jSONObject;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new TwitterException(e2);
        } catch (InvocationTargetException e3) {
            throw new TwitterException(e3);
        } catch (JSONException e4) {
            throw new TwitterException(e4);
        }
    }

    static void clearThreadLocalMap() {
        rawJsonMap.get().clear();
    }

    static <T> T registerJSONObject(T t, Object obj) {
        rawJsonMap.get().put(t, obj);
        return t;
    }
}
