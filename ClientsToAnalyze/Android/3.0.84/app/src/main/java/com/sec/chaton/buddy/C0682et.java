package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import com.sec.chaton.p027e.C1441i;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.et */
/* loaded from: classes.dex */
class C0682et extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2904a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0682et(BuddyProfileFragment buddyProfileFragment, Handler handler) {
        super(handler);
        this.f2904a = buddyProfileFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Cursor cursorQuery = this.f2904a.f2058aQ.getContentResolver().query(C1441i.f5369a, null, "buddy_no = ? ", new String[]{this.f2904a.f2117t}, null);
        while (cursorQuery != null && cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_status_message"));
            if (this.f2904a.f2032Q != null) {
                this.f2904a.f2032Q.setText(string);
            }
            if (this.f2904a.f2033R != null) {
                this.f2904a.f2033R.setText(string2);
            }
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
            cursorQuery.close();
        }
    }
}
