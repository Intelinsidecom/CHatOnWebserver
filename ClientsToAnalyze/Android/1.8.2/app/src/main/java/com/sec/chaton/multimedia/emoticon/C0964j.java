package com.sec.chaton.multimedia.emoticon;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: EmoticonSelectionView.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.j */
/* loaded from: classes.dex */
class C0964j extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ C0963i f3552a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0964j(C0963i c0963i, Handler handler) {
        super(handler);
        this.f3552a = c0963i;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        if (this.f3552a.f3549b.requery()) {
            this.f3552a.f3551d = true;
            this.f3552a.notifyDataSetChanged();
        }
    }
}
