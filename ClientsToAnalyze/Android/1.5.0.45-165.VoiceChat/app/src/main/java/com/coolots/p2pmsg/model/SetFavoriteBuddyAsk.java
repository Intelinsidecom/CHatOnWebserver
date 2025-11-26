package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class SetFavoriteBuddyAsk extends MsgBody {

    @StringCase(caseArray = {"Y", "N"})
    @NotNull
    private String Favorite;

    @Range(min = 1)
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
