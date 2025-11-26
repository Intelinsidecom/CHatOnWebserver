package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.buddy.p010a.C0258d;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: SpecialBuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fo */
/* loaded from: classes.dex */
class C0411fo implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyProfileFragment f1570a;

    C0411fo(SpecialBuddyProfileFragment specialBuddyProfileFragment) {
        this.f1570a = specialBuddyProfileFragment;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        switch (i) {
            case 1:
                if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                    this.f1570a.f1288r = false;
                } else {
                    this.f1570a.f1275e = new C0258d(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("description")), cursor.getString(cursor.getColumnIndex("followcount")), cursor.getString(cursor.getColumnIndex("likecount")), cursor.getString(cursor.getColumnIndex("msgstatus")), cursor.getString(cursor.getColumnIndex("photoloaded")), cursor.getString(cursor.getColumnIndex("status")), cursor.getString(cursor.getColumnIndex(RtspHeaders.Values.URL)), cursor.getString(cursor.getColumnIndex("weburl")), cursor.getString(cursor.getColumnIndex("islike")));
                    if (cursor.getString(cursor.getColumnIndex("islike")).equals("Y")) {
                        this.f1570a.f1288r = true;
                    } else {
                        this.f1570a.f1288r = false;
                    }
                }
                this.f1570a.m2276a(true);
                cursor.close();
                break;
            case 4:
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    this.f1570a.f1275e = new C0258d(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("description")), cursor.getString(cursor.getColumnIndex("followcount")), cursor.getString(cursor.getColumnIndex("likecount")), cursor.getString(cursor.getColumnIndex("msgstatus")), cursor.getString(cursor.getColumnIndex("photoloaded")), cursor.getString(cursor.getColumnIndex("status")), cursor.getString(cursor.getColumnIndex(RtspHeaders.Values.URL)), cursor.getString(cursor.getColumnIndex("weburl")));
                }
                cursor.close();
                this.f1570a.m2276a(false);
                break;
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
