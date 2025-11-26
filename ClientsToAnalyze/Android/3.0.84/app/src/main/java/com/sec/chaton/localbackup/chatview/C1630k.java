package com.sec.chaton.localbackup.chatview;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.k */
/* loaded from: classes.dex */
class C1630k implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f6075a;

    C1630k(ChatViewFragment chatViewFragment) {
        this.f6075a = chatViewFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        Cursor cursorSwapCursor = null;
        if (this.f6075a.f6034f != null) {
            if (i == 1) {
                if (cursor != null) {
                    try {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("count : " + cursor.getCount(), ChatViewFragment.f6029c);
                        }
                        Cursor cursorSwapCursor2 = this.f6075a.f6036h.swapCursor(cursor);
                        if (cursor == null || cursor.getCount() <= 0) {
                            this.f6075a.f6038j.setSelection(0);
                            this.f6075a.f6046r = false;
                        } else {
                            this.f6075a.f6043o = cursor.getCount();
                            if (this.f6075a.f6044p) {
                                this.f6075a.f6038j.setSelection(cursor.getCount());
                            }
                            this.f6075a.f6046r = true;
                        }
                        if (cursorSwapCursor2 != null) {
                            this.f6075a.m6871a(cursorSwapCursor2);
                            return;
                        }
                        return;
                    } finally {
                    }
                }
                return;
            }
            if (i == 2) {
                try {
                    cursorSwapCursor = this.f6075a.f6036h.swapCursor(cursor);
                    if (cursorSwapCursor != null) {
                        this.f6075a.m6871a(cursorSwapCursor);
                    }
                    if (cursor == null || cursor.getCount() <= 0) {
                        this.f6075a.f6038j.setSelection(0);
                        this.f6075a.f6046r = false;
                    } else {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("onQueryCompleted - QUERY_MESSAGE_LOAD_MORE, " + cursor.getCount(), ChatViewFragment.f6029c);
                        }
                        int count = cursor.getCount();
                        int i2 = count - this.f6075a.f6043o;
                        this.f6075a.f6043o = count;
                        if (this.f6075a.f6044p) {
                            this.f6075a.f6038j.setSelection(cursor.getCount());
                        } else if (i2 > 0) {
                            if (i2 < 30) {
                                this.f6075a.f6038j.setSelection(i2);
                            } else {
                                this.f6075a.f6038j.setSelection(30);
                            }
                        }
                        if (i2 > 0) {
                            this.f6075a.f6046r = true;
                        } else {
                            this.f6075a.f6046r = false;
                        }
                    }
                    this.f6075a.f6045q = false;
                    if (cursorSwapCursor != null) {
                        this.f6075a.m6871a(cursorSwapCursor);
                    }
                } finally {
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
