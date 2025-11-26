package com.sec.chaton.settings.downloads;

/* compiled from: DownloadableCounter.java */
/* renamed from: com.sec.chaton.settings.downloads.ax */
/* loaded from: classes.dex */
/* synthetic */ class C2557ax {

    /* renamed from: a */
    static final /* synthetic */ int[] f9714a = new int[EnumC2558ay.values().length];

    static {
        try {
            f9714a[EnumC2558ay.STATUS_NOT_INSTALLED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9714a[EnumC2558ay.STATUS_INSTALLED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9714a[EnumC2558ay.STATUS_INSTALL_PROGRESSING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
