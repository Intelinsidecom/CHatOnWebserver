package com.sec.chaton.p035io.entry.inner;

import com.sec.chaton.p035io.entry.Entry;

/* loaded from: classes.dex */
public class Buddy2 extends Entry {
    public String birthday;
    public String imgstatus;
    public String name;
    public String orgname;
    public String orgnum;
    public String sainfo;
    public String samsungemail;
    public String showphonenumber;
    public String status;
    public String statusupdatetime;
    public String timestamp;

    public enum BuddyImageStatus {
        PROFILE_UPDATED(1),
        PROFILE_DELETED(2),
        NONE_PROFILE(3),
        NOT_CHANGE(4);

        private int code;

        BuddyImageStatus(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    public BuddyImageStatus getImagestatus() throws NumberFormatException {
        if (this.imgstatus == null || this.imgstatus.equals("")) {
            return BuddyImageStatus.NOT_CHANGE;
        }
        return BuddyImageStatus.values()[Integer.parseInt(this.imgstatus) - 1];
    }
}
