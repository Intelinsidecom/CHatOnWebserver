package com.sec.chaton.p033io.entry.inner;

import com.sec.chaton.p033io.entry.Entry;

/* loaded from: classes.dex */
public class Buddy extends Entry {
    public String birthday;
    public String einfo;
    public String email;
    public String group;
    public String imgstatus;
    public String name;
    public String orgname;
    public String orgnum;
    public String samsungemail;
    public Boolean showphonenumber;
    public String status;
    public Boolean deleted = false;
    public Boolean blocked = false;

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
