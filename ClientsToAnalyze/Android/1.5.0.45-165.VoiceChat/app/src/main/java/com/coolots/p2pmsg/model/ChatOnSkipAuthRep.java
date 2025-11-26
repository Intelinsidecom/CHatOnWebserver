package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ChatOnSkipAuthRep extends MsgBody {
    public static final String RESULT_FAIL = "0";
    public static final String RESULT_SUCCESS = "1";

    @NotNull
    @Pattern(regexp = "[10]{1}")
    private String Result;

    @Size(max = 16, min = 16)
    private String UserToken;

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }

    public String getUserToken() {
        return this.UserToken;
    }

    public void setUserToken(String userToken) {
        this.UserToken = userToken;
    }
}
