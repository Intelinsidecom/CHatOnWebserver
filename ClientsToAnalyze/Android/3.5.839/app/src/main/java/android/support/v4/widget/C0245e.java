package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: CursorAdapter.java */
/* renamed from: android.support.v4.widget.e */
/* loaded from: classes.dex */
class C0245e extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ AbstractC0243c f586a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0245e(AbstractC0243c abstractC0243c) {
        super(new Handler());
        this.f586a = abstractC0243c;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f586a.m879b();
    }
}
