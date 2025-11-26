package weibo4android.http;

/* loaded from: classes.dex */
public class AccessToken extends OAuthToken {
    private static final long serialVersionUID = -8344528374458826291L;
    private String screenName;
    private long userId;

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ String getParameter(String str) {
        return super.getParameter(str);
    }

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ String getToken() {
        return super.getToken();
    }

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ String getTokenSecret() {
        return super.getTokenSecret();
    }

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // weibo4android.http.OAuthToken
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    AccessToken(Response response) {
        this(response.asString());
    }

    AccessToken(String str) {
        super(str);
        this.screenName = getParameter("screen_name");
        String parameter = getParameter("user_id");
        if (parameter != null) {
            this.userId = Long.parseLong(parameter);
        }
    }

    public AccessToken(String str, String str2) {
        super(str, str2);
    }

    public String getScreenName() {
        return this.screenName;
    }

    public long getUserId() {
        return this.userId;
    }
}
