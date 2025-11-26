package com.coolots.chaton.account.authorization;

/* loaded from: classes.dex */
public class AuthorizeTokenVO {
    public static final String AUTHCODE_CANT_FIND_TOKEN = "LIC_4102";
    public static final String AUTHCODE_SUCCESS = "LIC_2101";
    public static final int CODE_BAD_REQUEST = 400;
    public static final int CODE_DEFAULT = -1;
    public static final int CODE_OK = 200;
    public static final int RESULT_CANT_FIND_TOKEN = 4102;
    public static final int RESULT_DEFAULT = -1;
    public static final int RESULT_SUCCESS = 2101;
    private String mAuthorizeCode;
    private int mStatusCode = -1;
    private String mReasonPhrase = "";
    private String mDescription = "";
    private String mAuthenticateUserID = "";
    private String mResourceClass = "";
    private int mResultCode = -1;

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setStatusCode(int mStatusCode) {
        this.mStatusCode = mStatusCode;
    }

    public String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public void setReasonPhrase(String mReasonPhrase) {
        this.mReasonPhrase = mReasonPhrase;
    }

    public String getAuthorizeCode() {
        return this.mAuthorizeCode;
    }

    public void setAuthorizeCode(String mAuthorizeCode) {
        this.mAuthorizeCode = mAuthorizeCode;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getAuthenticateUserID() {
        return this.mAuthenticateUserID;
    }

    public void setAuthenticateUserID(String mAuthenticateUserID) {
        this.mAuthenticateUserID = mAuthenticateUserID;
    }

    public String getResourceClass() {
        return this.mResourceClass;
    }

    public void setResourceClass(String mResourceClass) {
        this.mResourceClass = mResourceClass;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public void setResultCode() {
        if (AUTHCODE_SUCCESS.equals(this.mAuthorizeCode)) {
            this.mResultCode = RESULT_SUCCESS;
        } else if (AUTHCODE_CANT_FIND_TOKEN.equals(this.mAuthorizeCode)) {
            this.mResultCode = RESULT_CANT_FIND_TOKEN;
        } else {
            this.mResultCode = -1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nmStatusCode = " + this.mStatusCode);
        sb.append("\nmReasonPhrase = " + this.mReasonPhrase);
        sb.append("\nmAuthorizeCode = " + this.mAuthorizeCode);
        sb.append("\nmDescription = " + this.mDescription);
        sb.append("\nmAuthenticateUserID = " + this.mAuthenticateUserID);
        sb.append("\nmResourceClass = " + this.mResourceClass);
        sb.append("\nmResultCode = " + this.mResultCode);
        return sb.toString();
    }
}
