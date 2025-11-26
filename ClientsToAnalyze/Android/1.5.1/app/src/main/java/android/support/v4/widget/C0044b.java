package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: android.support.v4.widget.b */
/* loaded from: classes.dex */
class C0044b extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ CursorAdapter f187a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0044b(CursorAdapter cursorAdapter) {
        super(new Handler());
        this.f187a = cursorAdapter;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f187a.onContentChanged();
    }
}
