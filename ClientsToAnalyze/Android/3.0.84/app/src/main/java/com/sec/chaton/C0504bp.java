package com.sec.chaton;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bp */
/* loaded from: classes.dex */
class C0504bp implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1642a;

    C0504bp(TabActivity tabActivity) {
        this.f1642a = tabActivity;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (this.f1642a.f788l) {
            if (cursor != null) {
                this.f1642a.m1235a(cursor);
            }
            this.f1642a.f789m = true;
            this.f1642a.f792p = true;
            return;
        }
        if (i == 1) {
            if (cursor != null) {
                this.f1642a.f793q = cursor.getCount();
                this.f1642a.m1235a(cursor);
                if (this.f1642a.f793q > 0) {
                    LocalBroadcastManager.getInstance(this.f1642a.getApplicationContext()).sendBroadcast(new Intent("buddy_tab_badge_update"));
                }
            }
            this.f1642a.m1283l();
            return;
        }
        if (i == 2) {
            this.f1642a.f795s = 0;
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    TabActivity.m1255c(this.f1642a, cursor.getInt(cursor.getColumnIndex("inbox_unread_count")));
                }
                this.f1642a.m1235a(cursor);
            }
            this.f1642a.m1283l();
            return;
        }
        if (i == 3) {
            if (cursor != null) {
                this.f1642a.f794r = cursor.getCount();
                this.f1642a.m1235a(cursor);
                if (this.f1642a.f794r > 0) {
                    LocalBroadcastManager.getInstance(this.f1642a.getApplicationContext()).sendBroadcast(new Intent("buddy_tab_badge_update"));
                }
            }
            this.f1642a.m1283l();
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
