package com.sec.chaton.trunk;

import com.sec.chaton.trunk.p061c.EnumC3026g;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.by */
/* loaded from: classes.dex */
public class C3017by {

    /* renamed from: a */
    String f10865a;

    /* renamed from: b */
    String f10866b;

    /* renamed from: c */
    String f10867c;

    /* renamed from: d */
    String f10868d;

    /* renamed from: e */
    long f10869e;

    /* renamed from: f */
    String f10870f;

    /* renamed from: g */
    String f10871g;

    /* renamed from: h */
    String f10872h;

    /* renamed from: i */
    EnumC3026g f10873i;

    /* renamed from: j */
    int f10874j;

    /* renamed from: k */
    boolean f10875k;

    /* renamed from: l */
    String f10876l;

    /* renamed from: m */
    int f10877m;

    /* renamed from: n */
    final /* synthetic */ TrunkPageActivity f10878n;

    public C3017by(TrunkPageActivity trunkPageActivity, String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, EnumC3026g enumC3026g, int i, boolean z, String str8, int i2) {
        this.f10878n = trunkPageActivity;
        this.f10865a = str;
        this.f10866b = str2;
        this.f10867c = str3;
        this.f10868d = str4;
        this.f10869e = j;
        this.f10870f = str5;
        this.f10871g = str6;
        this.f10872h = str7;
        this.f10873i = enumC3026g;
        this.f10874j = i;
        this.f10875k = z;
        this.f10876l = str8;
        this.f10877m = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sessionId: " + this.f10865a);
        sb.append("inboxNo: " + this.f10866b);
        sb.append("itemId: " + this.f10870f);
        sb.append(", contentType: " + this.f10873i);
        sb.append(", sender: " + this.f10867c);
        sb.append(", buddyName: " + this.f10868d);
        sb.append(", downloadUri: " + this.f10872h);
        sb.append(", time: " + this.f10869e);
        sb.append(", contentType: " + this.f10873i);
        sb.append(", totalCommentCount" + this.f10874j);
        sb.append(", unread" + this.f10877m);
        sb.append("\n");
        return sb.toString();
    }
}
