package com.sec.chaton.multimedia.audio;

/* compiled from: PlaySoundTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.f */
/* loaded from: classes.dex */
public enum EnumC1774f {
    PLAY_STATUS_INVALID(-1),
    PLAY_STATUS_DOWNLOADING(900),
    PLAY_STATUS_DOWNLOAD_FAILED(901),
    PLAY_STATUS_DOWNLOAD_INTERRUPTED(902),
    PLAY_STATUS_STARTED(1000),
    PLAY_STATUS_ONPLAYING(1001),
    PLAY_STATUS_FINISHED(1002),
    PLAY_STATUS_CANCELED(1003);


    /* renamed from: i */
    private int f6567i;

    EnumC1774f(int i) {
        this.f6567i = i;
    }

    /* renamed from: a */
    public int m7324a() {
        return this.f6567i;
    }

    /* renamed from: a */
    public static EnumC1774f m7323a(int i) {
        switch (i) {
            case 900:
                return PLAY_STATUS_DOWNLOADING;
            case 901:
                return PLAY_STATUS_DOWNLOAD_FAILED;
            case 902:
                return PLAY_STATUS_DOWNLOAD_INTERRUPTED;
            case 1000:
                return PLAY_STATUS_STARTED;
            case 1001:
                return PLAY_STATUS_ONPLAYING;
            case 1002:
                return PLAY_STATUS_FINISHED;
            case 1003:
                return PLAY_STATUS_CANCELED;
            default:
                return PLAY_STATUS_INVALID;
        }
    }
}
