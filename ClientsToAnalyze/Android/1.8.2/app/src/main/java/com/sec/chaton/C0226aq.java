package com.sec.chaton;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;

/* compiled from: HomeTabletFragment.java */
/* renamed from: com.sec.chaton.aq */
/* loaded from: classes.dex */
class C0226aq implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ HomeTabletFragment f760a;

    C0226aq(HomeTabletFragment homeTabletFragment) {
        this.f760a = homeTabletFragment;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        int i2 = 0;
        if (i == 1) {
            if (cursor != null) {
                this.f760a.f269q = cursor.getCount();
                cursor.close();
            }
            this.f760a.m633b(0, this.f760a.f269q + this.f760a.f270r);
            return;
        }
        if (i == 2) {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    i2 += cursor.getInt(cursor.getColumnIndex("inbox_unread_count"));
                }
                cursor.close();
            }
            this.f760a.m633b(1, i2);
            return;
        }
        if (i == 3) {
            if (cursor != null) {
                this.f760a.f270r = cursor.getCount();
                cursor.close();
            }
            this.f760a.m633b(0, this.f760a.f269q + this.f760a.f270r);
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
