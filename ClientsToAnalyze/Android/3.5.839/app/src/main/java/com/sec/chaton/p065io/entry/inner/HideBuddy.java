package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class HideBuddy extends Entry {
    public String imgstatus;
    public String name;

    public enum BuddyImageStatus {
        PROFILE_UPDATED(1),
        PROFILE_DELETED(2),
        NONE_PROFILE(3),
        NOT_CHANGE(4),
        GROUP_IMAGE(5),
        ME_IMAGE(6);

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
