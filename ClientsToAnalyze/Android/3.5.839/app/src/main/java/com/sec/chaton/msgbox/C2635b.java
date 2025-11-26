package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.b */
/* loaded from: classes.dex */
class C2635b implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ C2608a f9484a;

    C2635b(C2608a c2608a) {
        this.f9484a = c2608a;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        switch (i) {
            case 1:
                if (cursor == null || cursor.getCount() == 0) {
                    if (cursor != null) {
                        cursor.close();
                        break;
                    }
                } else {
                    cursor.moveToFirst();
                    String string = cursor.getString(cursor.getColumnIndex("buddy_name"));
                    this.f9484a.m11154a(cursor.getString(cursor.getColumnIndex("buddy_no")), string);
                    cursor.close();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
