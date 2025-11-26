package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.ab */
/* loaded from: classes.dex */
public class C1384ab implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5178a = C1439g.f5367b.buildUpon().appendPath("poston_comments").build();

    /* renamed from: b */
    public static final Uri f5179b = f5178a.buildUpon().appendEncodedPath("joined_buddy").build();
}
