package com.sec.chaton.p065io.entry.specialbuddy;

import android.text.TextUtils;
import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class SpecialBuddyFollowEntry extends Entry {
    public String error;

    /* renamed from: id */
    public String f8583id;
    public String success;
    public String type;

    public static boolean isValid(SpecialBuddyFollowEntry specialBuddyFollowEntry) {
        return (specialBuddyFollowEntry == null || TextUtils.isEmpty(specialBuddyFollowEntry.f8583id) || TextUtils.isEmpty(specialBuddyFollowEntry.type) || TextUtils.isEmpty(specialBuddyFollowEntry.success) || TextUtils.isEmpty(specialBuddyFollowEntry.error)) ? false : true;
    }

    public static SpecialBuddyFollowEntry copy(SpecialBuddyFollowEntry specialBuddyFollowEntry) {
        if (specialBuddyFollowEntry == null) {
            return null;
        }
        SpecialBuddyFollowEntry specialBuddyFollowEntry2 = new SpecialBuddyFollowEntry();
        specialBuddyFollowEntry2.f8583id = new String(specialBuddyFollowEntry.f8583id);
        specialBuddyFollowEntry2.type = new String(specialBuddyFollowEntry.type);
        specialBuddyFollowEntry2.success = new String(specialBuddyFollowEntry.success);
        specialBuddyFollowEntry2.error = new String(specialBuddyFollowEntry.error);
        return specialBuddyFollowEntry2;
    }
}
