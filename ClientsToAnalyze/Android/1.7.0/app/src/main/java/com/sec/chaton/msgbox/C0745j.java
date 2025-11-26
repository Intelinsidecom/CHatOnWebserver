package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.j */
/* loaded from: classes.dex */
class C0745j implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ C0736a f2541a;

    C0745j(C0736a c0736a) {
        this.f2541a = c0736a;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
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
                    this.f2541a.m3180a(cursor.getString(cursor.getColumnIndex("buddy_no")), string);
                    cursor.close();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) {
    }
}
