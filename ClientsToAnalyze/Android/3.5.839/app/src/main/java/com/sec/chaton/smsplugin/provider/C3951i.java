package com.sec.chaton.smsplugin.provider;

import java.util.Comparator;

/* compiled from: FullSyncTask.java */
/* renamed from: com.sec.chaton.smsplugin.provider.i */
/* loaded from: classes.dex */
class C3951i implements Comparator<C3952j> {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC3950h f14232a;

    C3951i(AsyncTaskC3950h asyncTaskC3950h) {
        this.f14232a = asyncTaskC3950h;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C3952j c3952j, C3952j c3952j2) {
        long jLongValue = Long.valueOf(c3952j.f14233a).longValue() - Long.valueOf(c3952j2.f14233a).longValue();
        if (jLongValue < 0) {
            return -1;
        }
        if (jLongValue > 0) {
            return 1;
        }
        return 0;
    }
}
