package com.sec.chaton.settings.downloads;

/* compiled from: AniconPackageDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.au */
/* loaded from: classes.dex */
enum EnumC2554au {
    INVALID_SORT(-1),
    SORT_BY_TIME(0),
    SORT_BY_TITLE(1),
    SORT_BY_CHARACTER(2),
    SORT_BY_POPULARITY(3);


    /* renamed from: f */
    private int f9707f;

    EnumC2554au(int i) {
        this.f9707f = i;
    }

    /* renamed from: a */
    public int m9486a() {
        return this.f9707f;
    }

    /* renamed from: a */
    static EnumC2554au m9485a(int i) {
        switch (i) {
            case 0:
                return SORT_BY_TIME;
            case 1:
                return SORT_BY_TITLE;
            case 2:
                return SORT_BY_CHARACTER;
            case 3:
                return SORT_BY_POPULARITY;
            default:
                return INVALID_SORT;
        }
    }
}
