package weibo4android.http;

/* loaded from: classes.dex */
public class AccessToken extends OAuthToken {
    private static final long serialVersionUID = -8344528374458826291L;
    private String screenName;
    private long userId;

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
