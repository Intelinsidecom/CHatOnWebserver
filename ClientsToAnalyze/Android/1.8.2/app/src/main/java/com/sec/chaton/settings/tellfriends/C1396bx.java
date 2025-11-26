package com.sec.chaton.settings.tellfriends;

import android.graphics.drawable.ColorDrawable;
import java.lang.ref.WeakReference;

/* compiled from: TellFriendsImageDownloader.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bx */
/* loaded from: classes.dex */
class C1396bx extends ColorDrawable {

    /* renamed from: a */
    private final WeakReference f5258a;

    public C1396bx(AsyncTaskC1395bw asyncTaskC1395bw) {
        this.f5258a = new WeakReference(asyncTaskC1395bw);
    }

    /* renamed from: a */
    public AsyncTaskC1395bw m5149a() {
        return (AsyncTaskC1395bw) this.f5258a.get();
    }
}
