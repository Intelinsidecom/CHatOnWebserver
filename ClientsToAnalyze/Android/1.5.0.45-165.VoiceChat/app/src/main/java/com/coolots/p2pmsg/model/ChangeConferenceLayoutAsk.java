package com.coolots.p2pmsg.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/* loaded from: classes.dex */
public class ChangeConferenceLayoutAsk extends MsgBody {
    public static final int LAYOUT_1 = 10;
    public static final int LAYOUT_2 = 22;
    public static final int LAYOUT_FOCUS_VIEW = 2;
    public static final int LAYOUT_SAME_SIZE_VIEW = 1;

    @NotNull
    @Pattern(regexp = "[0-9]{16}")
    private String ConferenceNo;

    @Max(2)
    @NotNull
    @Min(1)
    private int LayoutID;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public int getLayoutID() {
        return this.LayoutID;
    }

    public void setLayoutID(int layoutID) {
        this.LayoutID = layoutID;
    }
}
