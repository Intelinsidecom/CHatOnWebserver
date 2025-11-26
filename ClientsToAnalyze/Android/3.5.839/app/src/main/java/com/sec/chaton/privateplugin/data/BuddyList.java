package com.sec.chaton.privateplugin.data;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyList {
    private ArrayList<Buddy> buddy = new ArrayList<>();
    private Long timestamp;

    public ArrayList<Buddy> getBuddyList() {
        return this.buddy;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BuddyList [timestamp=").append(this.timestamp).append(", buddy=").append(this.buddy).append("]");
        return sb.toString();
    }
}
