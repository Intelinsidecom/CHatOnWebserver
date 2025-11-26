package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class LiveFollowResp {
    private String count;

    public String getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LiveFollowResp [count=").append(this.count).append("]");
        return sb.toString();
    }
}
