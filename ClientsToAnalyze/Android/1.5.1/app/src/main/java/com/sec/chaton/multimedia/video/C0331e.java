package com.sec.chaton.multimedia.video;

import com.sec.chaton.multimedia.video.VideoRecordManager;

/* renamed from: com.sec.chaton.multimedia.video.e */
/* loaded from: classes.dex */
/* synthetic */ class C0331e {

    /* renamed from: a */
    static final /* synthetic */ int[] f2420a = new int[VideoRecordManager.State.values().length];

    static {
        try {
            f2420a[VideoRecordManager.State.BEFORE_START.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2420a[VideoRecordManager.State.READY_TO_START.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2420a[VideoRecordManager.State.RECORDING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2420a[VideoRecordManager.State.TERMINATED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
