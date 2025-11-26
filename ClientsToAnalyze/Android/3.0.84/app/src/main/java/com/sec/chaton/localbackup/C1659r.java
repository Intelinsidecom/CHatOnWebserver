package com.sec.chaton.localbackup;

/* compiled from: EncryptionBackupFile.java */
/* renamed from: com.sec.chaton.localbackup.r */
/* loaded from: classes.dex */
/* synthetic */ class C1659r {

    /* renamed from: a */
    static final /* synthetic */ int[] f6139a;

    /* renamed from: b */
    static final /* synthetic */ int[] f6140b = new int[EnumC1660s.values().length];

    static {
        try {
            f6140b[EnumC1660s.ENCRYPT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6140b[EnumC1660s.DECRYPT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f6139a = new int[EnumC1661t.values().length];
        try {
            f6139a[EnumC1661t.FILE_ENCRYPT.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6139a[EnumC1661t.FILE_DECRYPT.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
    }
}
