package com.coolots.chaton.buddy.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class BuddyTable implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.coolots.chaton.buddy.model.BuddyTable.1
        @Override // android.os.Parcelable.Creator
        public BuddyTable createFromParcel(Parcel inParcel) {
            return new BuddyTable(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int size) {
            return new BuddyTable[size];
        }
    };
    private final int DEFAULT_VALUE = -1;
    private long userNo = -1;
    private String userId = null;
    private String accountID = null;
    private String displayName = null;
    private String editedName = null;
    private String nativeName = null;
    private String buddyName = null;
    private String message = null;
    private String region = null;
    private String countrycode = null;
    private String nationalcode = null;
    private String firstNumber = null;
    private String imageURL = null;
    private int favorite = -1;
    private int block = -1;
    private int hide = -1;
    private int freshBuddy = -1;
    private int presence = -1;
    private int suggestion = -1;
    private int removed = -1;
    private long imageupdateDate = -1;
    private long updateDate = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.userNo);
        dest.writeString(this.userId);
        dest.writeString(this.accountID);
        dest.writeString(this.displayName);
        dest.writeString(this.editedName);
        dest.writeString(this.nativeName);
        dest.writeString(this.buddyName);
        dest.writeString(this.message);
        dest.writeString(this.region);
        dest.writeString(this.countrycode);
        dest.writeString(this.nationalcode);
        dest.writeString(this.firstNumber);
        dest.writeString(this.imageURL);
        dest.writeInt(this.favorite);
        dest.writeInt(this.block);
        dest.writeInt(this.hide);
        dest.writeInt(this.freshBuddy);
        dest.writeInt(this.presence);
        dest.writeInt(this.suggestion);
        dest.writeInt(this.removed);
        dest.writeLong(this.updateDate);
    }

    private void readFromParcel(Parcel parcel) {
        this.userNo = parcel.readLong();
        this.userId = parcel.readString();
        this.accountID = parcel.readString();
        this.displayName = parcel.readString();
        this.editedName = parcel.readString();
        this.nativeName = parcel.readString();
        this.buddyName = parcel.readString();
        this.message = parcel.readString();
        this.region = parcel.readString();
        this.countrycode = parcel.readString();
        this.nationalcode = parcel.readString();
        this.firstNumber = parcel.readString();
        this.imageURL = parcel.readString();
        this.favorite = parcel.readInt();
        this.block = parcel.readInt();
        this.hide = parcel.readInt();
        this.freshBuddy = parcel.readInt();
        this.presence = parcel.readInt();
        this.suggestion = parcel.readInt();
        this.removed = parcel.readInt();
        this.updateDate = parcel.readLong();
    }

    public BuddyTable() {
    }

    public BuddyTable(Parcel parcel) {
        readFromParcel(parcel);
    }

    public long getUserNo() {
        return this.userNo;
    }

    public void setUserNo(long userNo) {
        this.userNo = userNo;
    }

    public String getUserID() {
        return this.userId;
    }

    public void setUserID(String userID) {
        this.userId = userID;
    }

    public String getAccountID() {
        return this.accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String name) {
        this.displayName = name;
    }

    public String getEditedName() {
        return this.editedName;
    }

    public void setEditedName(String editedName) {
        this.editedName = editedName;
    }

    public String getNativeName() {
        return this.nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getBuddyName() {
        return this.buddyName;
    }

    public void setBuddyName(String buddyName) {
        this.buddyName = buddyName;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountryCode() {
        return this.countrycode;
    }

    public void setCountryCode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getNationalCode() {
        return this.nationalcode;
    }

    public void setNationalCode(String nationalcode) {
        this.nationalcode = nationalcode;
    }

    public String getFirstNumber() {
        return this.firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getFavorite() {
        return this.favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getBlock() {
        return this.block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getHide() {
        return this.hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public int getFreshBuddy() {
        return this.freshBuddy;
    }

    public void setFreshBuddy(int freshBuddy) {
        this.freshBuddy = freshBuddy;
    }

    public int getPrecense() {
        return this.presence;
    }

    public void setPrecense(int presence) {
        this.presence = presence;
    }

    public int getSuggestion() {
        return this.suggestion;
    }

    public void setSuggestion(int suggestion) {
        this.suggestion = suggestion;
    }

    public int getRemoved() {
        return this.removed;
    }

    public void setRemoved(int removed) {
        this.removed = removed;
    }

    public long getImageUpdateDate() {
        return this.imageupdateDate;
    }

    public void setImageUpdateDate(long updateDate) {
        this.imageupdateDate = updateDate;
    }

    public long getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }
}
