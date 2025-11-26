package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.buddy.p019a.C0514d;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hq */
/* loaded from: classes.dex */
class C0760hq implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3027a;

    C0760hq(SpecialBuddyFragment specialBuddyFragment) {
        this.f3027a = specialBuddyFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (!GlobalApplication.m6456e() || this.f3027a.getActivity() != null) {
            switch (i) {
                case 1:
                    if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                        this.f3027a.f2316u = false;
                    } else {
                        this.f3027a.f2302g = new C0514d(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("description")), cursor.getString(cursor.getColumnIndex("followcount")), cursor.getString(cursor.getColumnIndex("likecount")), cursor.getString(cursor.getColumnIndex("msgstatus")), cursor.getString(cursor.getColumnIndex("photoloaded")), cursor.getString(cursor.getColumnIndex("status")), cursor.getString(cursor.getColumnIndex("url")), cursor.getString(cursor.getColumnIndex("weburl")), cursor.getString(cursor.getColumnIndex("islike")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("usertype")));
                        this.f3027a.f2307l = this.f3027a.f2302g.m4001b();
                        if (cursor.getString(cursor.getColumnIndex("islike")).equals("Y")) {
                            this.f3027a.f2316u = true;
                        } else {
                            this.f3027a.f2316u = false;
                        }
                    }
                    if (this.f3027a.f2302g == null) {
                        this.f3027a.m3894e();
                    } else {
                        if (GlobalApplication.m6456e() && !this.f3027a.f2296af) {
                            this.f3027a.m3890d();
                        }
                        this.f3027a.m3874a(this.f3027a.f2302g, true);
                    }
                    if (cursor != null) {
                        cursor.close();
                        break;
                    }
                    break;
                case 4:
                    if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                        this.f3027a.f2302g = new C0514d(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("description")), cursor.getString(cursor.getColumnIndex("followcount")), cursor.getString(cursor.getColumnIndex("likecount")), cursor.getString(cursor.getColumnIndex("msgstatus")), cursor.getString(cursor.getColumnIndex("photoloaded")), cursor.getString(cursor.getColumnIndex("status")), cursor.getString(cursor.getColumnIndex("url")), cursor.getString(cursor.getColumnIndex("weburl")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("usertype")));
                    } else {
                        this.f3027a.f2302g = new C0514d(this.f3027a.f2306k, this.f3027a.f2307l);
                    }
                    if (this.f3027a.f2302g == null) {
                        this.f3027a.m3894e();
                    } else {
                        if (GlobalApplication.m6456e() && !this.f3027a.f2296af) {
                            this.f3027a.m3890d();
                        }
                        this.f3027a.m3874a(this.f3027a.f2302g, false);
                    }
                    if (cursor != null) {
                        cursor.close();
                        break;
                    }
                    break;
            }
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
