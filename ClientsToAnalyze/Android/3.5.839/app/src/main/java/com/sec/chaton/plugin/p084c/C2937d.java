package com.sec.chaton.plugin.p084c;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import com.sec.chaton.util.C4904y;

/* compiled from: SMSUtils.java */
/* renamed from: com.sec.chaton.plugin.c.d */
/* loaded from: classes.dex */
final class C2937d extends AsyncQueryHandler {

    /* renamed from: a */
    final /* synthetic */ C2934a f10828a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2937d(C2934a c2934a, ContentResolver contentResolver) {
        super(contentResolver);
        this.f10828a = c2934a;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        switch (i) {
            case 1702:
                break;
            case 1802:
                if (C4904y.f17872b) {
                    C4904y.m18639b("[SMS]response locked SMS", C2934a.f10821a);
                }
                if (this.f10828a.f10824d != null) {
                    if (cursor == null || cursor.getCount() <= 0) {
                        this.f10828a.f10824d.sendEmptyMessage(2);
                        break;
                    } else {
                        this.f10828a.f10824d.sendEmptyMessage(1);
                        break;
                    }
                }
                break;
            default:
                if (C4904y.f17872b) {
                    C4904y.m18639b("ThreadListQueryHandler onQueryComplete() error case received[" + i + "]", C2934a.f10821a);
                    break;
                }
                break;
        }
    }
}
