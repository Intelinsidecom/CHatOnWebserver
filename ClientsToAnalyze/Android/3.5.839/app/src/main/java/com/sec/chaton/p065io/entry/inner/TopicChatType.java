package com.sec.chaton.p065io.entry.inner;

import android.text.TextUtils;
import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class TopicChatType extends Entry {
    public String channelname;
    public String ctid;
    public String suid;

    public TopicChatType() {
    }

    public TopicChatType(String str, String str2, String str3) {
        this.suid = str;
        this.ctid = str2;
        this.channelname = str3;
    }

    public String getSuid() {
        return this.suid;
    }

    public String getCtid() {
        return this.ctid;
    }

    public boolean isChatForCP() {
        return TextUtils.isEmpty(this.ctid);
    }
}
