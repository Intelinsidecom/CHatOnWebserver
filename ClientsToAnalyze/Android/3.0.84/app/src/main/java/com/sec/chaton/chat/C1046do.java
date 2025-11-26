package com.sec.chaton.chat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import java.io.UnsupportedEncodingException;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.do */
/* loaded from: classes.dex */
class C1046do implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f4157a;

    C1046do(ChatInfoFragment chatInfoFragment) {
        this.f4157a = chatInfoFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) throws UnsupportedEncodingException {
        if (i == 2) {
            if (cursor == null || cursor.getCount() <= 0) {
                C3250y.m11450b("Buddy information not found : " + this.f4157a.f3713A, ChatInfoFragment.f3712a);
            } else {
                C3250y.m11450b("Buddy information exist : " + this.f4157a.f3713A, ChatInfoFragment.f3712a);
                cursor.moveToFirst();
                this.f4157a.f3714B = cursor.getInt(cursor.getColumnIndex("buddy_profile_status"));
                if (this.f4157a.f3714B == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode() || this.f4157a.f3714B == Buddy.BuddyImageStatus.NOT_CHANGE.getCode() || this.f4157a.f3714B == Buddy.BuddyImageStatus.PROFILE_DELETED.getCode()) {
                    new C1330h(null).m5717a();
                    C3205bt.m11182a(this.f4157a.f3740h).m11211a(this.f4157a.f3751s, this.f4157a.f3713A, this.f4157a.f3714B);
                }
            }
        } else if (i == 70) {
            if (cursor.getCount() <= 0) {
                this.f4157a.f3754v.setText(this.f4157a.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore));
                this.f4157a.f3754v.setDuration(0);
                this.f4157a.f3754v.show();
            } else {
                Intent intent = new Intent(this.f4157a.f3740h, (Class<?>) BuddyActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 5);
                intent.putExtra(ChatFragment.f3489f, this.f4157a.f3744l);
                intent.putExtra("chatType", this.f4157a.f3743k);
                this.f4157a.startActivityForResult(intent, 5);
            }
        } else if (i == 4) {
            if (cursor.getCount() > 0) {
                this.f4157a.f3750r.setVisibility(8);
            } else {
                this.f4157a.f3750r.setVisibility(0);
                if (this.f4157a.f3744l.length > 0) {
                    this.f4157a.f3750r.setEnabled(true);
                } else {
                    this.f4157a.f3750r.setEnabled(false);
                }
            }
        }
        if (cursor != null) {
            cursor.close();
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
        if (i == 1) {
            this.f4157a.f3754v.setText(this.f4157a.getResources().getString(R.string.trunk_toast_deleted));
            this.f4157a.f3754v.setDuration(0);
            this.f4157a.f3754v.show();
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_last_message", "");
            this.f4157a.f3753u.startUpdate(0, null, C1449q.f5381a, contentValues, "inbox_no='" + this.f4157a.f3742j + "'", null);
        }
    }
}
