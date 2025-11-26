package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class JoinStatus {
    private String app_chaton_id;
    private String chaton_id;
    private String join_status;

    public String getJoinStatus() {
        return this.join_status;
    }

    public void setJoinStatus(String str) {
        this.join_status = str;
    }

    public String getChatonId() {
        return this.chaton_id;
    }

    public void setChatonId(String str) {
        this.chaton_id = str;
    }

    public String getAppChatonId() {
        return this.app_chaton_id;
    }

    public void setAppChatonId(String str) {
        this.app_chaton_id = str;
    }
}
