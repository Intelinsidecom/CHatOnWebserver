package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class Buddy extends Entry {
    public Boolean authenticated;
    public String birthday;
    public String countrycode;
    public String devicetype;
    public String einfo;
    public String email;
    public String group;
    public String imgstatus;
    public String msisdns;
    public String name;
    public String orgname;
    public String orgnum;
    public String orgnums;
    public String result;
    public String sainfo;
    public String samsungemail;
    public Boolean showphonenumber;
    public String status;
    public Boolean deleted = false;
    public Boolean blocked = false;
    public Boolean forcedel = false;
    public Boolean isHidden = false;

    public enum BuddyImageStatus {
        PROFILE_UPDATED(1),
        PROFILE_DELETED(2),
        NONE_PROFILE(3),
        NOT_CHANGE(4),
        GROUP_IMAGE(5),
        ME_IMAGE(6),
        CONTACT_IMAGE(7);

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
