package com.sec.chaton.p025d;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.ay */
/* loaded from: classes.dex */
/* synthetic */ class C1312ay {

    /* renamed from: a */
    static final /* synthetic */ int[] f4959a;

    /* renamed from: b */
    static final /* synthetic */ int[] f4960b = new int[EnumC1315ba.values().length];

    static {
        try {
            f4960b[EnumC1315ba.FACEBOOK_TYPE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4960b[EnumC1315ba.RENREN_TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4960b[EnumC1315ba.TWITTER_TYPE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4960b[EnumC1315ba.WEIBO_TYPE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f4959a = new int[EnumC1313az.values().length];
        try {
            f4959a[EnumC1313az.STARTING.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f4959a[EnumC1313az.SIGNING_UP.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f4959a[EnumC1313az.SKIPING_SMS.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f4959a[EnumC1313az.SYNCING_FRIENDS.ordinal()] = 4;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f4959a[EnumC1313az.RETRIEVING_FRIENDS.ordinal()] = 5;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f4959a[EnumC1313az.ADDING_BUDDIES.ordinal()] = 6;
        } catch (NoSuchFieldError e10) {
        }
    }
}
