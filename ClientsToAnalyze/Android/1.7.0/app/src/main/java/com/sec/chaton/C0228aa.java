package com.sec.chaton;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;

/* compiled from: HomeTabFragment.java */
/* renamed from: com.sec.chaton.aa */
/* loaded from: classes.dex */
class C0228aa implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f562a;

    C0228aa(HomeTabFragment homeTabFragment) {
        this.f562a = homeTabFragment;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
        int count = 0;
        if (i == 1) {
            if (cursor != null) {
                count = cursor.getCount();
                cursor.close();
            }
            HomeTabFragment.m662b(this.f562a.f270c, "Buddies", count);
            return;
        }
        if (i == 2) {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    count += cursor.getInt(cursor.getColumnIndex("inbox_unread_count"));
                }
                cursor.close();
            }
            HomeTabFragment.m662b(this.f562a.f270c, "Chat", count);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
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
