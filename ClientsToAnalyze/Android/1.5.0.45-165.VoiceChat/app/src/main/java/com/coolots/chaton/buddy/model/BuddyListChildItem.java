package com.coolots.chaton.buddy.model;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyListChildItem implements Serializable {
    private String mAccountID;
    private boolean mBuddyCheckboxSelected;
    private String mBuddyID;
    private String mBuddyMsg;
    private String mBuddyName;
    private long mBuddyNo;
    private boolean mBuddyType;
    private boolean mFavorite;
    private boolean presence;
    private final ArrayList<Long> userNoList = new ArrayList<>();
    private String mHighLightedName = null;

    public BuddyListChildItem(String _id, String name, long buddyNo, String msg, boolean type, boolean checkboxSelected, boolean presenceBuddy) {
        this.presence = false;
        this.mBuddyID = _id;
        this.mBuddyName = name;
        this.mBuddyNo = buddyNo;
        this.mBuddyMsg = msg;
        this.mBuddyType = type;
        this.mBuddyCheckboxSelected = checkboxSelected;
        this.presence = presenceBuddy;
    }

    public String getBuddyName() {
        return this.mBuddyName;
    }

    public String getHighLightedName() {
        return this.mHighLightedName;
    }

    public String getBuddyMsg() {
        return this.mBuddyMsg;
    }

    public String getBuddyId() {
        return this.mBuddyID;
    }

    public boolean getBuddyType() {
        return this.mBuddyType;
    }

    public boolean isCheckboxSelected() {
        return this.mBuddyCheckboxSelected;
    }

    public long getUserNo() {
        return this.mBuddyNo;
    }

    public void setCheckboxSelected(boolean checkboxSelected) {
        this.mBuddyCheckboxSelected = checkboxSelected;
    }

    public void setBuddyName(String name) {
        this.mBuddyName = name;
    }

    public void setHighLightedName(String mHighLightedName) {
        this.mHighLightedName = mHighLightedName;
    }

    public void setBuddyMsg(String msg) {
        this.mBuddyMsg = msg;
    }

    public void setBuddyId(String _id) {
        this.mBuddyID = _id;
    }

    public void setBuddyType(boolean type) {
        this.mBuddyType = type;
    }

    public void setBuddyNo(long buddyNo) {
        this.mBuddyNo = buddyNo;
    }

    public void setFavorite(boolean favorite) {
        this.mFavorite = favorite;
    }

    public boolean isFavorite() {
        return this.mFavorite;
    }

    public void setmAccountID(String mAccountID) {
        this.mAccountID = mAccountID;
    }

    public String getAccountID() {
        return this.mAccountID;
    }

    public ArrayList<Long> getUserNoList() {
        return this.userNoList;
    }

    public void setUserNoList(long userNo) {
        this.userNoList.add(Long.valueOf(userNo));
    }

    public boolean getPresence() {
        return this.presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }
}
