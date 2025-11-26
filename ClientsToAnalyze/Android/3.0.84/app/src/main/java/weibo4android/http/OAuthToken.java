package weibo4android.http;

import java.io.Serializable;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
abstract class OAuthToken implements Serializable {
    private static final long serialVersionUID = 2385887178385032767L;
    String[] responseStr;
    private transient SecretKeySpec secretKeySpec;
    private String token;
    private String tokenSecret;

    public OAuthToken(String str, String str2) {
        this.responseStr = null;
        this.token = str;
        this.tokenSecret = str2;
    }

    OAuthToken(Response response) {
        this(response.asString());
    }

    OAuthToken(String str) {
        this.responseStr = null;
        this.responseStr = str.split("&");
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
            if (str2.startsWith(str + '=')) {
                return str2.split("=")[1].trim();
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
        if (this.secretKeySpec == null ? oAuthToken.secretKeySpec != null : !this.secretKeySpec.equals(oAuthToken.secretKeySpec)) {
            return false;
        }
        return this.token.equals(oAuthToken.token) && this.tokenSecret.equals(oAuthToken.tokenSecret);
    }

    public int hashCode() {
        return (this.secretKeySpec != null ? this.secretKeySpec.hashCode() : 0) + (((this.token.hashCode() * 31) + this.tokenSecret.hashCode()) * 31);
    }

    public String toString() {
        return "OAuthToken{token='" + this.token + "', tokenSecret='" + this.tokenSecret + "', secretKeySpec=" + this.secretKeySpec + '}';
    }
}
