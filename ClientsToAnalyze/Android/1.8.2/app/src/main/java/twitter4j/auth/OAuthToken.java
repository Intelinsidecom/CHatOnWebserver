package twitter4j.auth;

import java.io.Serializable;
import javax.crypto.spec.SecretKeySpec;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalStringUtil;

/* loaded from: classes.dex */
abstract class OAuthToken implements Serializable {
    private static final long serialVersionUID = 3891133932519746686L;
    String[] responseStr;
    private transient SecretKeySpec secretKeySpec;
    private String token;
    private String tokenSecret;

    public OAuthToken(String str, String str2) {
        this.responseStr = null;
        this.token = str;
        this.tokenSecret = str2;
    }

    OAuthToken(HttpResponse httpResponse) {
        this(httpResponse.asString());
    }

    OAuthToken(String str) {
        this.responseStr = null;
        this.responseStr = z_T4JInternalStringUtil.split(str, "&");
        this.tokenSecret = getParameter("oauth_token_secret");
        this.token = getParameter("oauth_token");
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenSecret() {
        return this.tokenSecret;
    }

    void setSecretKeySpec(SecretKeySpec secretKeySpec) {
        this.secretKeySpec = secretKeySpec;
    }

    SecretKeySpec getSecretKeySpec() {
        return this.secretKeySpec;
    }

    public String getParameter(String str) {
        for (String str2 : this.responseStr) {
            if (str2.startsWith(new StringBuffer().append(str).append('=').toString())) {
                return z_T4JInternalStringUtil.split(str2, "=")[1].trim();
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OAuthToken)) {
            return false;
        }
        OAuthToken oAuthToken = (OAuthToken) obj;
        return this.token.equals(oAuthToken.token) && this.tokenSecret.equals(oAuthToken.tokenSecret);
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.tokenSecret.hashCode();
    }

    public String toString() {
        return new StringBuffer().append("OAuthToken{token='").append(this.token).append('\'').append(", tokenSecret='").append(this.tokenSecret).append('\'').append(", secretKeySpec=").append(this.secretKeySpec).append('}').toString();
    }
}
