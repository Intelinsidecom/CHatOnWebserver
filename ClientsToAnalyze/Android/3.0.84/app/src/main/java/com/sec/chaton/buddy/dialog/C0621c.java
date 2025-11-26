package com.sec.chaton.buddy.dialog;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p027e.C1445m;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.util.List;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.c */
/* loaded from: classes.dex */
class C0621c implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f2841a;

    C0621c(BuddyDialog buddyDialog) {
        this.f2841a = buddyDialog;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == 3) {
            C3250y.m11450b("Buddy information exist : " + this.f2841a.f2666d, BuddyDialog.f2599a);
            this.f2841a.f2640aa = true;
            if (cursor != null && cursor.getCount() > 0) {
                if (cursor.moveToNext()) {
                    this.f2841a.f2679q = new C0513c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_orginal_numbers")), cursor.getString(cursor.getColumnIndex("buddy_msisdns")), cursor.getString(cursor.getColumnIndex("buddy_multidevice")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_birthday")) == null ? "" : cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false, cursor.getInt(cursor.getColumnIndex("buddy_show_phone_number")), cursor.getString(cursor.getColumnIndex("buddy_extra_info")), cursor.getInt(cursor.getColumnIndex("buddy_account_info")), cursor.getString(cursor.getColumnIndex("buddy_sainfo")));
                    if (cursor.getString(cursor.getColumnIndex("is_favorite")).equals("Y")) {
                        this.f2841a.f2627Z = true;
                    } else {
                        this.f2841a.f2627Z = false;
                    }
                    if (((this.f2841a.f2666d.length() < 19 || !this.f2841a.f2666d.startsWith("10")) && !this.f2841a.f2666d.startsWith("0")) || TextUtils.isEmpty(this.f2841a.f2679q.m3980g())) {
                        this.f2841a.f2651al = false;
                    } else {
                        this.f2841a.f2651al = true;
                    }
                    if (!this.f2841a.f2651al) {
                        this.f2841a.f2649aj = false;
                        this.f2841a.f2650ak = this.f2841a.m4172o();
                        if (!this.f2841a.f2650ak) {
                            this.f2841a.f2668f = this.f2841a.f2679q.m3979f();
                            if (TextUtils.isEmpty(this.f2841a.f2668f)) {
                                this.f2841a.f2668f = "+" + this.f2841a.f2666d;
                            }
                        } else {
                            this.f2841a.f2668f = this.f2841a.f2679q.m3979f();
                            if (TextUtils.isEmpty(this.f2841a.f2668f)) {
                                this.f2841a.f2668f = null;
                            }
                        }
                    } else {
                        List listM4170n = this.f2841a.m4170n();
                        if (listM4170n.size() > 0) {
                            this.f2841a.f2668f = "+" + ((String) listM4170n.get(0));
                        }
                    }
                    this.f2841a.m4118a(false);
                }
            } else {
                C3250y.m11450b("Buddy information not found : " + this.f2841a.f2666d, BuddyDialog.f2599a);
                this.f2841a.f2640aa = false;
                this.f2841a.f2627Z = false;
                this.f2841a.m4136d();
            }
        } else if (i == 4) {
            if (cursor.getCount() >= 50) {
                C3641ai.m13211a(this.f2841a.getApplicationContext(), String.format(this.f2841a.getResources().getString(R.string.buddy_list_addfavorites_toast_failed_50), 50), 0).show();
                this.f2841a.f2627Z = false;
                this.f2841a.f2688z.setImageResource(R.drawable.actionbar_ic_favorite_02);
            } else {
                C0513c c0513c = (C0513c) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_relation_group", (Integer) 1);
                contentValues.put("group_relation_buddy", c0513c.m3975b());
                this.f2841a.f2653an.startInsert(1, c0513c, C1445m.f5377a, contentValues);
            }
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
        if (i == 1) {
            C0513c c0513c = (C0513c) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                this.f2841a.f2648ai.setText(this.f2841a.getString(R.string.buddy_profile_addfavorites_toast_success, new Object[]{c0513c.m3976c()}));
                this.f2841a.f2648ai.setDuration(0);
                this.f2841a.f2648ai.show();
                this.f2841a.f2627Z = true;
                this.f2841a.f2688z.setImageResource(R.drawable.actionbar_ic_favorite_01);
                return;
            }
            C3641ai.m13211a(this.f2841a.getApplicationContext(), this.f2841a.getResources().getString(R.string.buddy_profile_addfavorites_toast_failed), 0).show();
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (i == 2) {
            if (i2 != -1) {
                this.f2841a.f2648ai.setText(R.string.buddy_list_removefavorites_toast_success);
                this.f2841a.f2648ai.setDuration(0);
                this.f2841a.f2648ai.show();
                this.f2841a.f2627Z = false;
                this.f2841a.f2688z.setImageResource(R.drawable.actionbar_ic_favorite_02);
                return;
            }
            C3641ai.m13211a(this.f2841a.getApplicationContext(), this.f2841a.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
        }
    }
}
