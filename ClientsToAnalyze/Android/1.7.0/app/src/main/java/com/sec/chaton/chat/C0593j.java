package com.sec.chaton.chat;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.j */
/* loaded from: classes.dex */
class C0593j implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ ChatActivity f2032a;

    C0593j(ChatActivity chatActivity) {
        this.f2032a = chatActivity;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
        if (this.f2032a.f1720u == null) {
            C1341p.m4651a("onQueryCompleted - Activity is null", getClass().getSimpleName());
        }
        switch (i) {
            case 9:
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    this.f2032a.m2593a(cursor.getInt(cursor.getColumnIndex("unread_item_count")));
                }
                if (cursor != null) {
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
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) {
    }
}
