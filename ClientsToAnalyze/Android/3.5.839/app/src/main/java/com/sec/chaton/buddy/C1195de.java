package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.C0096i;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1107d;
import com.sec.chaton.p055d.C2133n;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2265bk;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.de */
/* loaded from: classes.dex */
class C1195de implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4424a;

    C1195de(BuddyFragment buddyFragment) {
        this.f4424a = buddyFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        C4904y.m18639b("onQueryComplete", getClass().getSimpleName());
        if (i == 1000) {
            try {
                int count = cursor.getCount();
                String[] strArr = new String[count];
                if (count <= 0) {
                    C4904y.m18641c("DB has no member of hide buddy", getClass().getSimpleName());
                    C4809aa.m18104a().m18125b("Is DB Hide List Uploaded", (Boolean) true);
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                } else {
                    C4904y.m18641c("DB has " + count + " member of hide buddy", getClass().getSimpleName());
                    if (cursor.moveToFirst()) {
                        int i2 = 0;
                        do {
                            strArr[i2] = cursor.getString(cursor.getColumnIndex("buddy_no"));
                            i2++;
                        } while (cursor.moveToNext());
                    }
                    C2133n c2133n = new C2133n(this.f4424a.f3769v);
                    if (strArr.length > 0) {
                        c2133n.m9563b(strArr);
                    }
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                }
            } catch (Exception e) {
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
            cursor.close();
            return;
        }
        if (i == 1001) {
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        c1107dM7081a = cursor.moveToFirst() ? C1107d.m7081a(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("description")), cursor.getString(cursor.getColumnIndex("followcount")), cursor.getString(cursor.getColumnIndex("likecount")), cursor.getString(cursor.getColumnIndex("msgstatus")), cursor.getString(cursor.getColumnIndex("photoloaded")), cursor.getString(cursor.getColumnIndex("status")), cursor.getString(cursor.getColumnIndex("url")), cursor.getString(cursor.getColumnIndex("weburl")), cursor.getString(cursor.getColumnIndex("islike")), cursor.getString(cursor.getColumnIndex("tel")), cursor.getString(cursor.getColumnIndex("usertype"))) : null;
                        this.f4424a.m6327W();
                    }
                } finally {
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (c1107dM7081a != null) {
                this.f4424a.m6368a(c1107dM7081a);
                return;
            } else {
                if (C4904y.f17872b) {
                    C4904y.m18639b("PROFILE_QUERY_SPECIAL_BUDDY_INFO is not exist", BuddyFragment.f3576a);
                    return;
                }
                return;
            }
        }
        if (i == 1002) {
            C4904y.m18639b("[EventBanner] QUERY_PLUS_EVENT", BuddyFragment.f3576a);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        boolean z = false;
                        while (true) {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            long j = cursor.getLong(cursor.getColumnIndex("start_time"));
                            long j2 = cursor.getLong(cursor.getColumnIndex("end_time"));
                            long timeInMillis = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
                            C4904y.m18639b("[EventBanner] QUERY_PLUS_EVENT startTime : " + j, BuddyFragment.f3576a);
                            C4904y.m18639b("[EventBanner] QUERY_PLUS_EVENT currentTime : " + j2, BuddyFragment.f3576a);
                            C4904y.m18639b("[EventBanner] QUERY_PLUS_EVENT currentTime : " + timeInMillis, BuddyFragment.f3576a);
                            if (cursor.getString(cursor.getColumnIndex("menutype")).compareTo(EnumC2265bk.EVENT.m10125a()) == 0 && j < timeInMillis && timeInMillis < j2) {
                                C4904y.m18639b("[EventBanner] QUERY_PLUS_EVENT : make event banner", BuddyFragment.f3576a);
                                String string = cursor.getString(cursor.getColumnIndex("weburl"));
                                String string2 = cursor.getString(cursor.getColumnIndex("id"));
                                C4904y.m18639b("[EventBanner] webUrl : " + string, BuddyFragment.f3576a);
                                C4904y.m18639b("[EventBanner] eventid : " + string2, BuddyFragment.f3576a);
                                this.f4424a.m6489c(string, string2);
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            this.f4424a.f3734cN = null;
                            if (C4809aa.m18104a().m18120a("new_promotion_count", (Integer) 0).intValue() > 0) {
                                C4809aa.m18104a().m18123a("new_promotion_ids");
                                C4809aa.m18104a().m18126b("new_promotion_count", (Integer) 0);
                                C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("promotion_event_update"));
                            }
                        }
                    }
                } finally {
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
        C4904y.m18639b("onInsertComplete", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        C4904y.m18639b("onUpdateComplete", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
        C4904y.m18639b("onDeleteComplete", getClass().getSimpleName());
        if (i == 1) {
            this.f4424a.f3642aW.setText(this.f4424a.getResources().getString(R.string.trunk_toast_deleted));
            this.f4424a.f3642aW.setDuration(0);
            this.f4424a.f3642aW.show();
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_last_message", "");
            this.f4424a.f3643aX.startUpdate(0, null, C2299s.f8209a, contentValues, "inbox_no='" + this.f4424a.f3619Z + "'", null);
        }
    }
}
