package com.sec.chaton.settings.downloads;

import com.sec.chaton.multimedia.audio.EnumC1774f;

/* compiled from: SoundHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.dg */
/* loaded from: classes.dex */
/* synthetic */ class C2621dg {

    /* renamed from: a */
    static final /* synthetic */ int[] f9848a;

    /* renamed from: b */
    static final /* synthetic */ int[] f9849b = new int[EnumC1774f.values().length];

    static {
        try {
            f9849b[EnumC1774f.PLAY_STATUS_DOWNLOADING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9849b[EnumC1774f.PLAY_STATUS_STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9849b[EnumC1774f.PLAY_STATUS_ONPLAYING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9849b[EnumC1774f.PLAY_STATUS_FINISHED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f9849b[EnumC1774f.PLAY_STATUS_CANCELED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f9849b[EnumC1774f.PLAY_STATUS_DOWNLOAD_FAILED.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f9849b[EnumC1774f.PLAY_STATUS_DOWNLOAD_INTERRUPTED.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        f9848a = new int[EnumC2624dj.values().length];
        try {
            f9848a[EnumC2624dj.BUTTON_PLAY.ordinal()] = 1;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f9848a[EnumC2624dj.BUTTON_STOP.ordinal()] = 2;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f9848a[EnumC2624dj.BUTTON_PROGRESS.ordinal()] = 3;
        } catch (NoSuchFieldError e10) {
        }
    }
}
