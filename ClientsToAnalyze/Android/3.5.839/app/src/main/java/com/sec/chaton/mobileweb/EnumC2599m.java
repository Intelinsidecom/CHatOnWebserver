package com.sec.chaton.mobileweb;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MobileWebApiUsageType.java */
/* renamed from: com.sec.chaton.mobileweb.m */
/* loaded from: classes.dex */
public enum EnumC2599m {
    LIVE_CONTENTS(1, EnumC2604r.LIVE_SERVER, "/live/contents.html"),
    LIVE_MAIN(2, EnumC2604r.LIVE_SERVER, "/live/main.html"),
    SHOP_MAIN(5, EnumC2604r.SHOP_SERVER, "/shop/getMain"),
    CHATON_GAME(6, EnumC2604r.GAME_SERVER, "/game/info.html"),
    LIVE_GENERAL(7, EnumC2604r.LIVE_SERVER, "/general/info.html"),
    EVENT(8, null, null);


    /* renamed from: g */
    int f9297g;

    /* renamed from: h */
    String f9298h;

    /* renamed from: i */
    EnumC2604r f9299i;

    EnumC2599m(int i, EnumC2604r enumC2604r, String str) {
        this.f9297g = i;
        this.f9299i = enumC2604r;
        this.f9298h = str;
    }

    /* renamed from: a */
    public String m11007a() {
        return this.f9299i.m11024a();
    }

    /* renamed from: b */
    public String m11008b() {
        return this.f9298h;
    }

    /* renamed from: c */
    public List<EnumC2598l> m11009c() {
        ArrayList arrayList = new ArrayList();
        switch (this) {
            case LIVE_CONTENTS:
                arrayList.add(EnumC2598l.HANDSHAKE_V2);
                arrayList.add(EnumC2598l.SHARE_V2);
                arrayList.add(EnumC2598l.GOPAGE_V3);
                arrayList.add(EnumC2598l.FOLLOWINGSTATUS_V1);
                arrayList.add(EnumC2598l.TOPICCHAT_V1);
                arrayList.add(EnumC2598l.RECOMMEND_V1);
                arrayList.add(EnumC2598l.TOAST_V1);
                break;
            case LIVE_MAIN:
                arrayList.add(EnumC2598l.HANDSHAKE_V2);
                arrayList.add(EnumC2598l.GOPAGE_V3);
                arrayList.add(EnumC2598l.BADGECLEAR_V1);
                arrayList.add(EnumC2598l.FOLLOWINGSTATUS_V1);
                arrayList.add(EnumC2598l.TOAST_V1);
                break;
            case EVENT:
                arrayList.add(EnumC2598l.HANDSHAKE_V2);
                arrayList.add(EnumC2598l.GOPAGE_V2);
                break;
            case SHOP_MAIN:
                arrayList.add(EnumC2598l.HANDSHAKE_V2);
                arrayList.add(EnumC2598l.GOPAGE_V2);
                arrayList.add(EnumC2598l.BADGECLEAR_V1);
                arrayList.add(EnumC2598l.ITEMPURCHASE_V1);
                arrayList.add(EnumC2598l.ITEMDOWNLOAD_V1);
                arrayList.add(EnumC2598l.ITEMDOWNLOAD_V2);
                arrayList.add(EnumC2598l.ITEMLIST_V1);
                arrayList.add(EnumC2598l.ITEMCANCEL_V1);
                arrayList.add(EnumC2598l.ITEMDELETE_V1);
                arrayList.add(EnumC2598l.ITEMAPPLY_V1);
                arrayList.add(EnumC2598l.VERIFIEDITEMLIST_V1);
                arrayList.add(EnumC2598l.ITEMMULTIDOWNLOAD_V2);
                arrayList.add(EnumC2598l.VIEWRESOLUTION_V1);
                arrayList.add(EnumC2598l.PREDOWNLOAD_V1);
                arrayList.add(EnumC2598l.FORWARDCHATMESSAGE_V1);
                arrayList.add(EnumC2598l.CLEARHISTORY_V1);
                arrayList.add(EnumC2598l.TOAST_V1);
                break;
            case CHATON_GAME:
                arrayList.add(EnumC2598l.HANDSHAKE_V2);
                arrayList.add(EnumC2598l.GOPAGE_V2);
                arrayList.add(EnumC2598l.BADGECLEAR_V1);
                arrayList.add(EnumC2598l.APPLIST_V1);
                arrayList.add(EnumC2598l.APPEXEC_V1);
                break;
            case LIVE_GENERAL:
                arrayList.add(EnumC2598l.HANDSHAKE_V2);
                break;
        }
        return arrayList;
    }
}
