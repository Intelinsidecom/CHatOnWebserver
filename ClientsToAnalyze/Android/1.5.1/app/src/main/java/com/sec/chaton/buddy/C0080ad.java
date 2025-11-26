package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.buddy.ad */
/* loaded from: classes.dex */
class C0080ad implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f614a;

    C0080ad(BuddyProfileActivity buddyProfileActivity) {
        this.f614a = buddyProfileActivity;
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo530a(int i, Object obj, Cursor cursor) throws NumberFormatException {
        if (i == 3) {
            ChatONLogWriter.m3506b("Buddy information exist : " + this.f614a.f586k, BuddyProfileActivity.f553a);
            if (cursor.getCount() <= 0) {
                ChatONLogWriter.m3506b("Buddy information not found : " + this.f614a.f586k, BuddyProfileActivity.f553a);
                this.f614a.f588m = false;
                this.f614a.m608a(2);
            } else if (cursor.moveToNext()) {
                this.f614a.f585j = new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")) == null ? "" : cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false);
                if (cursor.getString(cursor.getColumnIndex("is_favorite")).equals("Y")) {
                    this.f614a.f588m = true;
                } else {
                    this.f614a.f588m = false;
                }
                this.f614a.f585j.m679d(cursor.getInt(cursor.getColumnIndex("buddy_show_phone_number")));
                this.f614a.m608a(1);
            }
        } else if (i == 4) {
            if (cursor.getCount() >= 50) {
                Toast.makeText(this.f614a.getApplicationContext(), String.format(this.f614a.getResources().getString(C0062R.string.buddy_list_addfavorites_toast_failed_50), 50), 0).show();
                this.f614a.f592q.setChecked(false);
            } else {
                BuddyItem buddyItem = (BuddyItem) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_relation_group", (Integer) 1);
                contentValues.put("group_relation_buddy", buddyItem.m668a());
                this.f614a.f583h.startInsert(1, buddyItem, ChatONContract.GroupRelationTable.f1715a, contentValues);
            }
        }
        if (cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo531a(int i, Object obj, Uri uri) {
        if (i == 1) {
            BuddyItem buddyItem = (BuddyItem) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) == -1) {
                Toast.makeText(this.f614a.f584i, this.f614a.getResources().getString(C0062R.string.buddy_profile_addfavorites_toast_failed), 0).show();
            } else {
                Toast.makeText(this.f614a.f584i, this.f614a.getString(C0062R.string.buddy_profile_addfavorites_toast_success, new Object[]{buddyItem.m673b()}), 0).show();
                this.f614a.f592q.setChecked(true);
            }
        }
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: b */
    public void mo534b(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (i == 2) {
            if (i2 != -1) {
                Toast.makeText(this.f614a.f584i, C0062R.string.buddy_profile_removefavorites_toast_success, 0).show();
                this.f614a.f592q.setChecked(false);
            } else {
                Toast.makeText(this.f614a.f584i, this.f614a.getResources().getString(C0062R.string.buddy_list_removefavorites_toast_failed), 0).show();
            }
        }
    }
}
