package com.sec.chaton.trunk.entry.inner;

import com.sec.chaton.p028io.entry.Entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TrunkItem extends Entry {
    public String description;
    public String itemid;
    public long lastcmtdttm;
    public long regdttm;
    public String sessionid;
    public int totcmtcnt;
    public int unreadcmtcnt;
    public User user = new User();
    public File file = new File();
    public List comment = new ArrayList();
}
