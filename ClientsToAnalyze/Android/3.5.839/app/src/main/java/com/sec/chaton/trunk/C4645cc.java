package com.sec.chaton.trunk;

import com.sec.chaton.trunk.p121c.EnumC4642g;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.cc */
/* loaded from: classes.dex */
public class C4645cc {

    /* renamed from: a */
    String f16828a;

    /* renamed from: b */
    String f16829b;

    /* renamed from: c */
    String f16830c;

    /* renamed from: d */
    String f16831d;

    /* renamed from: e */
    long f16832e;

    /* renamed from: f */
    String f16833f;

    /* renamed from: g */
    String f16834g;

    /* renamed from: h */
    String f16835h;

    /* renamed from: i */
    EnumC4642g f16836i;

    /* renamed from: j */
    int f16837j;

    /* renamed from: k */
    boolean f16838k;

    /* renamed from: l */
    String f16839l;

    /* renamed from: m */
    int f16840m;

    /* renamed from: n */
    final /* synthetic */ TrunkPageActivity f16841n;

    public C4645cc(TrunkPageActivity trunkPageActivity, String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, EnumC4642g enumC4642g, int i, boolean z, String str8, int i2) {
        this.f16841n = trunkPageActivity;
        this.f16828a = str;
        this.f16829b = str2;
        this.f16830c = str3;
        this.f16831d = str4;
        this.f16832e = j;
        this.f16833f = str5;
        this.f16834g = str6;
        this.f16835h = str7;
        this.f16836i = enumC4642g;
        this.f16837j = i;
        this.f16838k = z;
        this.f16839l = str8;
        this.f16840m = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sessionId: " + this.f16828a);
        sb.append("inboxNo: " + this.f16829b);
        sb.append("itemId: " + this.f16833f);
        sb.append(", contentType: " + this.f16836i);
        sb.append(", sender: " + this.f16830c);
        sb.append(", buddyName: " + this.f16831d);
        sb.append(", downloadUri: " + this.f16835h);
        sb.append(", time: " + this.f16832e);
        sb.append(", contentType: " + this.f16836i);
        sb.append(", totalCommentCount" + this.f16837j);
        sb.append(", unread" + this.f16840m);
        sb.append("\n");
        return sb.toString();
    }
}
