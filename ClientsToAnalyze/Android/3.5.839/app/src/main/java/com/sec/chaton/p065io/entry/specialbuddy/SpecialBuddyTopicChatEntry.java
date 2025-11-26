package com.sec.chaton.p065io.entry.specialbuddy;

import android.text.TextUtils;
import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class SpecialBuddyTopicChatEntry extends Entry {
    public String buddyid;
    public String channelname;
    public String contenttitle;
    public String ctid;
    public String sessionid;
    public String suid;
    public String usertype;

    public SpecialBuddyTopicChatEntry() {
    }

    public SpecialBuddyTopicChatEntry(String str, String str2, String str3, String str4, String str5) {
        this.sessionid = str;
        this.buddyid = str2;
        this.suid = str3;
        this.channelname = str4;
        this.usertype = str5;
    }

    public boolean isCpTopicChat() {
        return TextUtils.isEmpty(this.ctid);
    }
}
