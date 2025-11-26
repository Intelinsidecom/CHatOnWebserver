package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ChatListInfoEntryDetail extends Entry {
    public String activated;
    public List<ChatListInfoEntryDetailMemberInfo> chatroommemberinfo = new ArrayList();
    public String chattype;
    public String createtime;
    public String creatorchatonid;

    /* renamed from: ip */
    public String f8563ip;
    public String lastmsgbody;
    public String lastmsgsender;
    public Long lastmsgtimestamp;
    public String lastmsgtype;
    public boolean needToBeRemoved;
    public String oldsessionid;
    public String originregion;
    public String port;
    public String sessionid;
}
