package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1786r;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.i */
/* loaded from: classes.dex */
class C0853i implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f3172a;

    C0853i(MsgboxFragment msgboxFragment) {
        this.f3172a = msgboxFragment;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
        C1786r.m6064d("result:" + i2);
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (this.f3172a.getActivity() != null) {
            if (i == 1) {
                if (cursor == null || cursor.getCount() == 0) {
                    this.f3172a.getView().findViewById(R.id.linList).setVisibility(8);
                } else {
                    this.f3172a.getView().findViewById(R.id.linList).setVisibility(0);
                }
                if (this.f3172a.f3115i != null) {
                    this.f3172a.f3115i.close();
                }
                this.f3172a.f3115i = cursor;
                this.f3172a.f3115i = this.f3172a.f3114h.swapCursor(cursor);
                return;
            }
            if (i == 2) {
                this.f3172a.f3118l.clear();
                if (cursor == null || cursor.getCount() == 0) {
                    if (cursor != null) {
                        cursor.close();
                    }
                } else {
                    while (cursor.moveToNext()) {
                        this.f3172a.f3118l.add(cursor.getString(cursor.getColumnIndex("participants_buddy_no")));
                    }
                    cursor.close();
                }
            }
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
