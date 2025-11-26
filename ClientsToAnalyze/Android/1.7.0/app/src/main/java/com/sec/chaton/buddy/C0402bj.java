package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.p025d.C0668u;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.bj */
/* loaded from: classes.dex */
class C0402bj implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1376a;

    C0402bj(BuddyProfileActivity buddyProfileActivity) {
        this.f1376a = buddyProfileActivity;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) throws PackageManager.NameNotFoundException, NumberFormatException {
        if (i == 3) {
            C1341p.m4658b("Buddy information exist : " + this.f1376a.f1242m, BuddyProfileActivity.f1198a);
            if (cursor == null || cursor.getCount() <= 0) {
                C1341p.m4658b("Buddy information not found : " + this.f1376a.f1242m, BuddyProfileActivity.f1198a);
                this.f1376a.f1244o = false;
                this.f1376a.m2252a(2);
            } else if (cursor.moveToNext()) {
                this.f1376a.f1241l = new C0363a(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")) == null ? "" : cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false, cursor.getInt(cursor.getColumnIndex("buddy_show_phone_number")), cursor.getString(cursor.getColumnIndex("buddy_extra_info")));
                if (cursor.getString(cursor.getColumnIndex("is_favorite")).equals("Y")) {
                    this.f1376a.f1244o = true;
                } else {
                    this.f1376a.f1244o = false;
                }
                if (this.f1376a.f1241l.m2322h() <= 0) {
                    this.f1376a.f1227ad = false;
                    this.f1376a.f1238i.startQuery(6, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode("+" + this.f1376a.f1242m)), null, null, null, null);
                } else {
                    this.f1376a.f1227ad = true;
                }
                this.f1376a.m2252a(1);
            }
        } else if (i == 4) {
            if (cursor.getCount() >= 50) {
                C1619g.m5889a(this.f1376a.getApplicationContext(), String.format(this.f1376a.getResources().getString(R.string.buddy_list_addfavorites_toast_failed_50), 50), 0).show();
                this.f1376a.f1248s.setChecked(false);
            } else {
                C0363a c0363a = (C0363a) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_relation_group", (Integer) 1);
                contentValues.put("group_relation_buddy", c0363a.m2308a());
                this.f1376a.f1238i.startInsert(1, c0363a, C0668u.f2311a, contentValues);
            }
        } else if (i == 6) {
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToNext()) {
                this.f1376a.f1227ad = false;
                this.f1376a.f1228ae = 0;
            } else {
                this.f1376a.f1227ad = true;
                this.f1376a.f1228ae = cursor.getInt(cursor.getColumnIndex("_id"));
                C1341p.m4658b("ContactSaved id : " + this.f1376a.f1228ae, BuddyProfileActivity.f1198a);
            }
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
        if (i == 1) {
            C0363a c0363a = (C0363a) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                this.f1376a.f1239j.setText(this.f1376a.getString(R.string.buddy_profile_addfavorites_toast_success, new Object[]{c0363a.m2314b()}));
                this.f1376a.f1239j.setDuration(0);
                this.f1376a.f1239j.show();
                this.f1376a.f1248s.setChecked(true);
                return;
            }
            C1619g.m5889a(this.f1376a.f1240k, this.f1376a.getResources().getString(R.string.buddy_profile_addfavorites_toast_failed), 0).show();
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (i == 2) {
            if (i2 != -1) {
                this.f1376a.f1239j.setText(R.string.buddy_list_removefavorites_toast_success);
                this.f1376a.f1239j.setDuration(0);
                this.f1376a.f1239j.show();
                this.f1376a.f1248s.setChecked(false);
                return;
            }
            C1619g.m5889a(this.f1376a.f1240k, this.f1376a.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
        }
    }
}
