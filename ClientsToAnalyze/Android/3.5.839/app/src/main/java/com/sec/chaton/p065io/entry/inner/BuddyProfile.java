package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BuddyProfile extends Entry {
    public String birthday;
    public String email;
    public String imgstatus;
    public String name;
    public String samsungemail;

    @EntryField(type = SnsInfoEntry.class)
    public List<SnsInfoEntry> snsid = new ArrayList();
    public String status;
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
