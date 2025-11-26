package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/* loaded from: classes.dex */
public class LinkAccountRep extends MsgBody {
    public static final String RESULT_FAIL = "0";
    public static final String RESULT_SUCCESS = "1";

    @NotNull
    @Pattern(regexp = "[10]{1}")
    private String Result;

    @Min(1)
    private Long UserNo;

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }

    public Long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(Long userNo) {
        this.UserNo = userNo;
    }
}
