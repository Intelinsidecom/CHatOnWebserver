package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.C0691f;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.dc */
/* loaded from: classes.dex */
class C0345dc implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1488a;

    C0345dc(BuddyProfileFragment buddyProfileFragment) {
        this.f1488a = buddyProfileFragment;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) throws NumberFormatException {
        if (i == 3) {
            C1786r.m6061b("Buddy information exist : " + this.f1488a.f1159u, BuddyProfileFragment.f1089a);
            if (cursor == null || cursor.getCount() <= 0) {
                C1786r.m6061b("Buddy information not found : " + this.f1488a.f1159u, BuddyProfileFragment.f1089a);
                this.f1488a.f1161w = false;
                this.f1488a.m2129a(2);
            } else if (cursor.moveToNext()) {
                this.f1488a.f1158t = new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")) == null ? "" : cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false, cursor.getInt(cursor.getColumnIndex("buddy_show_phone_number")), cursor.getString(cursor.getColumnIndex("buddy_extra_info")));
                if (cursor.getString(cursor.getColumnIndex("is_favorite")).equals("Y")) {
                    this.f1488a.f1161w = true;
                } else {
                    this.f1488a.f1161w = false;
                }
                if (this.f1488a.f1158t.m2335g()) {
                    this.f1488a.f1156r.startQuery(7, null, Uri.parse("content://com.sec.chaton.provider/relation"), null, "relation_buddy_id = ?  AND relation_rank != 0 ", new String[]{this.f1488a.f1159u}, "relation_rank ASC LIMIT 30");
                } else {
                    this.f1488a.m2129a(1);
                }
            }
        } else if (i == 7) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToNext() && this.f1488a.f1158t != null) {
                int i2 = cursor.getInt(cursor.getColumnIndex("relation_send"));
                int i3 = cursor.getInt(cursor.getColumnIndex("relation_received"));
                int i4 = cursor.getInt(cursor.getColumnIndex("relation_point"));
                cursor.getInt(cursor.getColumnIndex("relation_icon"));
                int i5 = cursor.getInt(cursor.getColumnIndex("relation_increase"));
                int i6 = cursor.getInt(cursor.getColumnIndex("relation_rank"));
                this.f1488a.f1158t.m2319a(i2);
                this.f1488a.f1158t.m2325b(i3);
                this.f1488a.f1158t.m2328c(i4);
                this.f1488a.f1158t.m2334f(i6);
                this.f1488a.f1158t.m2332e(i5);
            }
            this.f1488a.m2129a(1);
        } else if (i == 4) {
            if (cursor.getCount() >= 50) {
                Toast.makeText(this.f1488a.getActivity().getApplicationContext(), String.format(this.f1488a.f1157s.getString(R.string.buddy_list_addfavorites_toast_failed_50), 50), 0).show();
                this.f1488a.f1093B.setChecked(false);
            } else {
                C0257c c0257c = (C0257c) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_relation_group", (Integer) 1);
                contentValues.put("group_relation_buddy", c0257c.m2318a());
                this.f1488a.f1156r.startInsert(1, c0257c, C0691f.f2613a, contentValues);
            }
        } else if (i == 6 && cursor != null && cursor.getCount() > 0 && cursor.moveToNext()) {
            this.f1488a.f1119ab = true;
            this.f1488a.f1120ac = cursor.getInt(cursor.getColumnIndex("_id"));
            C1786r.m6061b("ContactSaved id : " + this.f1488a.f1120ac, BuddyProfileFragment.f1089a);
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
        if (i == 1) {
            C0257c c0257c = (C0257c) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                Toast.makeText(this.f1488a.f1157s, this.f1488a.f1157s.getString(R.string.buddy_list_addfavorites_toast_success, c0257c.m2324b()), 0).show();
                this.f1488a.f1093B.setChecked(true);
            } else {
                Toast.makeText(this.f1488a.f1157s, this.f1488a.f1157s.getString(R.string.buddy_profile_addfavorites_toast_failed), 0).show();
            }
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
        if (i == 2) {
            if (i2 != -1) {
                Toast.makeText(this.f1488a.f1157s, R.string.buddy_list_removefavorites_toast_success, 0).show();
                this.f1488a.f1093B.setChecked(false);
            } else {
                Toast.makeText(this.f1488a.f1157s, this.f1488a.f1157s.getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
            }
        }
    }
}
