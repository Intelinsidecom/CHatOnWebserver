package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class SetFavoriteBuddyRep extends MsgBody {
    private String Favorite;
    private long UserNo;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public String getFavorite() {
        return this.Favorite;
    }

    public void setFavorite(String favorite) {
        this.Favorite = favorite;
    }
}
