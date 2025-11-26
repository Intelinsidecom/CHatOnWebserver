package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ci */
/* loaded from: classes.dex */
class C0428ci implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1420a;

    C0428ci(BuddyFragment buddyFragment) {
        this.f1420a = buddyFragment;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
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
        if (i == 1) {
            this.f1420a.f1129al.setText(this.f1420a.getResources().getString(R.string.trunk_toast_deleted));
            this.f1420a.f1129al.setDuration(0);
            this.f1420a.f1129al.show();
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_last_message", "");
            this.f1420a.f1132ao.startUpdate(0, null, C0671x.f2315a, contentValues, "inbox_no='" + this.f1420a.f1168z + "'", null);
        }
    }
}
