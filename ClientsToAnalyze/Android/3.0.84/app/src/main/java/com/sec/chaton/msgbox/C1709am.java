package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.am */
/* loaded from: classes.dex */
class C1709am implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f6356a;

    C1709am(MsgboxSelectionFragment msgboxSelectionFragment) {
        this.f6356a = msgboxSelectionFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
        C3250y.m11454d("result:" + i2);
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (this.f6356a.f6291D) {
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        if (this.f6356a.getActivity() != null) {
            switch (i) {
                case 1:
                    this.f6356a.f6306i.setVisibility(8);
                    if (cursor == null || cursor.getCount() == 0) {
                        this.f6356a.f6305h.setVisibility(0);
                        this.f6356a.f6307j.setVisibility(8);
                        this.f6356a.f6309l.setVisibility(8);
                    } else {
                        this.f6356a.f6305h.setVisibility(8);
                        this.f6356a.f6307j.setVisibility(0);
                        if (3 != this.f6356a.f6294G) {
                            this.f6356a.f6309l.setVisibility(0);
                        }
                    }
                    Cursor cursorSwapCursor = this.f6356a.f6308k.swapCursor(cursor);
                    if (cursorSwapCursor != null) {
                        cursorSwapCursor.close();
                        break;
                    }
                    break;
                default:
                    if ((cursor == null || cursor.getCount() == 0) && cursor != null) {
                        cursor.close();
                        break;
                    }
                    break;
            }
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
