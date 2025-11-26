package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import com.sec.chaton.p017e.C0688c;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.cr */
/* loaded from: classes.dex */
class C0333cr extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1475a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0333cr(BuddyProfileFragment buddyProfileFragment, Handler handler) {
        super(handler);
        this.f1475a = buddyProfileFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Cursor cursorQuery = this.f1475a.f1157s.getContentResolver().query(C0688c.f2606a, null, "buddy_no = ? ", new String[]{this.f1475a.f1159u}, null);
        while (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
            if (this.f1475a.f1164z != null) {
                this.f1475a.f1164z.setText(string);
            }
        }
    }
}
