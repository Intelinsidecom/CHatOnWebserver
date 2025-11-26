package com.sec.chaton.p065io.entry.inner;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class Msg extends Entry {
    public String address;
    public Integer chattype;

    /* renamed from: id */
    public String f8574id;
    public String msgFromLang;
    public String msgToLang;
    public String msgTranslated;
    public Integer port;
    public String receiver;
    public String sender;
    public String sessionid;
    public String tid;
    public Long time;
    public String type;

    public boolean isValid() {
        return (this.tid == null || this.type == null || this.f8574id == null || this.sender == null || this.receiver == null || this.sessionid == null) ? false : true;
    }
}
