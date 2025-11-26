package com.sec.chaton.mobileweb;

import com.sec.chaton.global.C1493a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MobileWebApiUsageType.java */
/* renamed from: com.sec.chaton.mobileweb.p */
/* loaded from: classes.dex */
public enum EnumC1689p {
    LIVE_CONTENTS(1, EnumC1694u.LIVE_SERVER, null),
    LIVE_MAIN(2, EnumC1694u.LIVE_SERVER, "/live/main.html"),
    LIVE_BUDDYLIST(3, EnumC1694u.LIVE_SERVER, "/live/main.html?view=buddy"),
    LIVE_EVENT(4, EnumC1694u.LIVE_SERVER, null);


    /* renamed from: e */
    int f6219e;

    /* renamed from: f */
    String f6220f;

    /* renamed from: g */
    EnumC1694u f6221g;

    EnumC1689p(int i, EnumC1694u enumC1694u, String str) {
        this.f6219e = i;
        this.f6221g = enumC1694u;
        this.f6220f = str;
    }

    /* renamed from: a */
    public String m6982a() {
        return this.f6221g.m6991a();
    }

    /* renamed from: b */
    public String m6983b() {
        return this.f6220f;
    }

    /* renamed from: c */
    public List<EnumC1688o> m6984c() {
        ArrayList arrayList = new ArrayList();
        switch (this) {
            case LIVE_CONTENTS:
                arrayList.add(EnumC1688o.HANDSHAKE_V2);
                arrayList.add(EnumC1688o.SHARE_V2);
                if (C1493a.m6463a("live_chat_feature")) {
                    arrayList.add(EnumC1688o.GOPAGE_V2);
                    break;
                } else {
                    arrayList.add(EnumC1688o.GOPAGE_V1);
                    break;
                }
            case LIVE_MAIN:
                arrayList.add(EnumC1688o.HANDSHAKE_V2);
                if (C1493a.m6463a("live_chat_feature")) {
                    arrayList.add(EnumC1688o.GOPAGE_V2);
                } else {
                    arrayList.add(EnumC1688o.GOPAGE_V1);
                }
                arrayList.add(EnumC1688o.BADGECLEAR_V1);
                break;
            case LIVE_BUDDYLIST:
                arrayList.add(EnumC1688o.HANDSHAKE_V2);
                if (C1493a.m6463a("live_chat_feature")) {
                    arrayList.add(EnumC1688o.GOPAGE_V2);
                    break;
                } else {
                    arrayList.add(EnumC1688o.GOPAGE_V1);
                    break;
                }
            case LIVE_EVENT:
                arrayList.add(EnumC1688o.HANDSHAKE_V2);
                break;
        }
        return arrayList;
    }
}
