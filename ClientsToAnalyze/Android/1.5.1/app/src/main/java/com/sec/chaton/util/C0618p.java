package com.sec.chaton.util;

import com.sec.chaton.util.ProfileImageLoader;

/* renamed from: com.sec.chaton.util.p */
/* loaded from: classes.dex */
/* synthetic */ class C0618p {

    /* renamed from: a */
    static final /* synthetic */ int[] f3792a = new int[ProfileImageLoader.ImageType.values().length];

    static {
        try {
            f3792a[ProfileImageLoader.ImageType.BROADCAST.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3792a[ProfileImageLoader.ImageType.GROUP.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3792a[ProfileImageLoader.ImageType.BUDDY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
