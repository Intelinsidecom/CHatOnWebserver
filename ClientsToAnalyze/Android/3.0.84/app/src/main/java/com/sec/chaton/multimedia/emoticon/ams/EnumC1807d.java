package com.sec.chaton.multimedia.emoticon.ams;

/* compiled from: AmsContainerItemType.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.ams.d */
/* loaded from: classes.dex */
public enum EnumC1807d {
    Basic(10000),
    Download(20000),
    User(30000);


    /* renamed from: d */
    private long f6748d;

    EnumC1807d(long j) {
        this.f6748d = j;
    }

    /* renamed from: a */
    public long m7450a() {
        return this.f6748d;
    }

    /* renamed from: a */
    public static EnumC1807d m7449a(long j) {
        if (j >= User.m7450a()) {
            return User;
        }
        if (j >= Download.m7450a()) {
            return Download;
        }
        if (j >= Basic.m7450a()) {
            return Basic;
        }
        throw new RuntimeException("Unknown item type(" + j + ")");
    }
}
