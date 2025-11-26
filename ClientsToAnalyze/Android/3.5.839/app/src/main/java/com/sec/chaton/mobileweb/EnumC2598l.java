package com.sec.chaton.mobileweb;

/* compiled from: MobileWebApi.java */
/* renamed from: com.sec.chaton.mobileweb.l */
/* loaded from: classes.dex */
public enum EnumC2598l {
    HANDSHAKE_V1(101, "handshake", "v1"),
    HANDSHAKE_V2(102, "handshake", "v2"),
    PROXY_V2(202, "proxy", "v2"),
    GOPAGE_V1(301, "gopage", "v1"),
    GOPAGE_V2(302, "gopage", "v2"),
    GOPAGE_V3(303, "gopage", "v3"),
    SHARE_V2(402, "share", "v2"),
    BADGECLEAR_V1(501, "badgeclear", "v1"),
    FOLLOW_V1(601, "follow", "v1"),
    ITEMPURCHASE_V1(611, "itempurchase", "v1"),
    ITEMDOWNLOAD_V1(621, "itemdownload", "v1"),
    ITEMDOWNLOAD_V2(622, "itemdownload", "v2"),
    ITEMLIST_V1(631, "itemdownloadedlist", "v1"),
    ITEMCANCEL_V1(641, "itemdownloadcancel", "v1"),
    ITEMDELETE_V1(651, "itemdelete", "v1"),
    ITEMAPPLY_V1(661, "itemapply", "v1"),
    VERIFIEDITEMLIST_V1(671, "verifieditemlist", "v1"),
    ITEMMULTIDOWNLOAD_V1(681, "itemmultidownload", "v1"),
    ITEMMULTIDOWNLOAD_V2(682, "itemmultidownload", "v2"),
    APPLIST_V1(701, "applist", "v1"),
    APPEXEC_V1(711, "appexec", "v1"),
    VIEWRESOLUTION_V1(811, "viewresolution", "v1"),
    PREDOWNLOAD_V1(821, "predownload", "v1"),
    FORWARDCHATMESSAGE_V1(831, "forwardchatmessage", "v1"),
    CLEARHISTORY_V1(901, "clearhistory", "v1"),
    TOAST_V1(999, "toast", "v1"),
    FOLLOWINGSTATUS_V1(1001, "followingstatus", "v1"),
    TOPICCHAT_V1(1101, "topicchat", "v1"),
    RECOMMEND_V1(1111, "recommend", "v1");


    /* renamed from: D */
    private int f9287D;

    /* renamed from: E */
    private String f9288E;

    /* renamed from: F */
    private String f9289F;

    /* renamed from: a */
    public static EnumC2598l m11002a(int i) {
        switch (i) {
            case 101:
                return HANDSHAKE_V1;
            case 102:
                return HANDSHAKE_V2;
            case 202:
                return PROXY_V2;
            case 301:
                return GOPAGE_V1;
            case 302:
                return GOPAGE_V2;
            case 303:
                return GOPAGE_V3;
            case 402:
                return SHARE_V2;
            case 501:
                return BADGECLEAR_V1;
            case 601:
                return FOLLOW_V1;
            case 611:
                return ITEMPURCHASE_V1;
            case 621:
                return ITEMDOWNLOAD_V1;
            case 622:
                return ITEMDOWNLOAD_V2;
            case 631:
                return ITEMLIST_V1;
            case 641:
                return ITEMCANCEL_V1;
            case 651:
                return ITEMDELETE_V1;
            case 661:
                return ITEMAPPLY_V1;
            case 671:
                return VERIFIEDITEMLIST_V1;
            case 681:
                return ITEMMULTIDOWNLOAD_V1;
            case 682:
                return ITEMMULTIDOWNLOAD_V2;
            case 701:
                return APPLIST_V1;
            case 711:
                return APPEXEC_V1;
            case 811:
                return VIEWRESOLUTION_V1;
            case 821:
                return PREDOWNLOAD_V1;
            case 831:
                return FORWARDCHATMESSAGE_V1;
            case 901:
                return CLEARHISTORY_V1;
            case 999:
                return TOAST_V1;
            case 1001:
                return FOLLOWINGSTATUS_V1;
            case 1101:
                return TOPICCHAT_V1;
            case 1111:
                return RECOMMEND_V1;
            default:
                return null;
        }
    }

    EnumC2598l(int i, String str, String str2) {
        this.f9287D = i;
        this.f9288E = str;
        this.f9289F = str2;
    }

    /* renamed from: a */
    public int m11003a() {
        return this.f9287D;
    }

    /* renamed from: b */
    public String m11004b() {
        return this.f9288E;
    }

    /* renamed from: c */
    public String m11005c() {
        return this.f9289F;
    }

    /* renamed from: d */
    public String m11006d() {
        return m11004b() + "_" + m11005c();
    }
}
