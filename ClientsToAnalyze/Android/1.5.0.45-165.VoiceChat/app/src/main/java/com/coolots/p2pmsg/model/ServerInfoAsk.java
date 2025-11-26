package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;

/* loaded from: classes.dex */
public class ServerInfoAsk extends MsgBody {
    public static final String GET_ALL_SERVER = "0";
    public static final String GET_AVAILABLE_SERVER = "1";

    @StringCase(caseArray = {"0", "1"})
    private String ServerSearchType;

    public String getServerSearchType() {
        return this.ServerSearchType;
    }

    public void setServerSearchType(String serverSearchType) {
        this.ServerSearchType = serverSearchType;
    }
}
