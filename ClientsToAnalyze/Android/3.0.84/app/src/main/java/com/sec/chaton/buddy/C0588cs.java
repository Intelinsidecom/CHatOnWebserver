package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cs */
/* loaded from: classes.dex */
class C0588cs implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2551a;

    C0588cs(BuddyFragment buddyFragment) {
        this.f2551a = buddyFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
        if (i == 1) {
            this.f2551a.f1772aJ.setText(this.f2551a.getResources().getString(R.string.trunk_toast_deleted));
            this.f2551a.f1772aJ.setDuration(0);
            this.f2551a.f1772aJ.show();
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_last_message", "");
            this.f2551a.f1773aK.startUpdate(0, null, C1449q.f5381a, contentValues, "inbox_no='" + this.f2551a.f1752P + "'", null);
        }
    }
}
