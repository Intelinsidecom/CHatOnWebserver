package com.sec.chaton.trunk.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryParserInfo;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class TrunkItem extends Entry {
    public String description;
    public String itemid;
    public Long lastcmtdttm;
    public Long regdttm;
    public String sessionid;
    public Integer totcmtcnt;
    public Integer unreadcmtcnt;

    @EntryParserInfo(name = Config.NOTIFICATION_INTENT_SENDER)
    public User user = new User();

    @EntryParserInfo(name = "file")
    public File file = new File();

    @EntryParserInfo(name = "commentlist")
    public CommentList commentlist = new CommentList();
}
