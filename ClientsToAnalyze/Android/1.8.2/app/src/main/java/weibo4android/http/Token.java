package weibo4android.http;

import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class Token {
    private long mExpiresIn;
    protected String mOauth_Token_Secret;
    private String mOauth_verifier;
    private String mRefreshToken;
    protected SecretKeySpec mSecretKeySpec;
    private String mToken;
    protected String[] responseStr;

    public Token() {
        this.mToken = "";
        this.mRefreshToken = "";
        this.mExpiresIn = 0L;
        this.mOauth_verifier = "";
        this.mOauth_Token_Secret = "";
        this.responseStr = null;
    }

    public String getToken() {
        return this.mToken;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public long getExpiresIn() {
        return this.mExpiresIn;
    }

    public void setExpiresIn(long j) {
        this.mExpiresIn = j;
    }

    public void setExpiresIn(String str) {
        if (str != null && !str.equals("0")) {
            setExpiresIn(System.currentTimeMillis() + (Integer.parseInt(str) * 1000));
        }
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setVerifier(String str) {
        this.mOauth_verifier = str;
    }

    public String getVerifier() {
        return this.mOauth_verifier;
    }

    public String getSecret() {
        return this.mOauth_Token_Secret;
    }

    public Token(String str) {
        this.mToken = "";
        this.mRefreshToken = "";
        this.mExpiresIn = 0L;
        this.mOauth_verifier = "";
        this.mOauth_Token_Secret = "";
        this.responseStr = null;
        this.responseStr = str.split("&");
        this.mOauth_Token_Secret = getParameter("oauth_token_secret");
        this.mToken = getParameter("oauth_token");
    }

    public Token(String str, String str2) {
        this.mToken = "";
        this.mRefreshToken = "";
        this.mExpiresIn = 0L;
        this.mOauth_verifier = "";
        this.mOauth_Token_Secret = "";
        this.responseStr = null;
        this.mToken = str;
        this.mOauth_Token_Secret = str2;
    }

    public String getParameter(String str) {
        for (String str2 : this.responseStr) {
            if (str2.startsWith(String.valueOf(str) + '=')) {
                return str2.split("=")[1].trim();
            }
        }
        return null;
    }

    protected void setSecretKeySpec(SecretKeySpec secretKeySpec) {
        this.mSecretKeySpec = secretKeySpec;
    }

    protected SecretKeySpec getSecretKeySpec() {
        return this.mSecretKeySpec;
    }
}
