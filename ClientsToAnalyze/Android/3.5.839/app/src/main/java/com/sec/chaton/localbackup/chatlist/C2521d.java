package com.sec.chaton.localbackup.chatlist;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.localbackup.database.C2543a;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatListFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatlist.d */
/* loaded from: classes.dex */
class C2521d implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ ChatListFragment f9071a;

    C2521d(ChatListFragment chatListFragment) {
        this.f9071a = chatListFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        Cursor cursor2 = null;
        if (i == 1) {
            this.f9071a.m10893c();
            if (cursor != null) {
                try {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("count : " + cursor.getCount(), ChatListFragment.f9053b);
                    }
                    Cursor cursorB = this.f9071a.f9057e.mo877b(cursor);
                    if (cursorB != null) {
                        cursorB.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            return;
        }
        if (i == 2 && cursor != null) {
            try {
                if (cursor.getColumnIndex("inbox_room_type") >= 0) {
                    this.f9071a.f9055c.startQuery(1, null, C2543a.m10949b(), null, null, new String[]{""}, null);
                } else {
                    this.f9071a.f9055c.startQuery(1, null, C2543a.m10947a(), null, null, new String[]{""}, null);
                }
            } finally {
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
