package com.sec.chaton.localbackup.chatlist;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatListFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatlist.d */
/* loaded from: classes.dex */
class C1619d implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ ChatListFragment f6027a;

    C1619d(ChatListFragment chatListFragment) {
        this.f6027a = chatListFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == 1) {
            this.f6027a.m6862c();
            if (cursor != null) {
                Cursor cursor2 = null;
                try {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("count : " + cursor.getCount(), ChatListFragment.f6009b);
                    }
                    Cursor cursorSwapCursor = this.f6027a.f6013e.swapCursor(cursor);
                    if (cursorSwapCursor != null) {
                        cursorSwapCursor.close();
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
