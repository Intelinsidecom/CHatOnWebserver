package com.sec.chaton.localbackup;

/* compiled from: EncryptionBackupFile.java */
/* renamed from: com.sec.chaton.localbackup.t */
/* loaded from: classes.dex */
/* synthetic */ class C2561t {

    /* renamed from: a */
    static final /* synthetic */ int[] f9184a;

    /* renamed from: b */
    static final /* synthetic */ int[] f9185b = new int[EnumC2562u.values().length];

    static {
        try {
            f9185b[EnumC2562u.ENCRYPT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9185b[EnumC2562u.DECRYPT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f9184a = new int[EnumC2563v.values().length];
        try {
            f9184a[EnumC2563v.FILE_ENCRYPT.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9184a[EnumC2563v.FILE_DECRYPT.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
    }
}
