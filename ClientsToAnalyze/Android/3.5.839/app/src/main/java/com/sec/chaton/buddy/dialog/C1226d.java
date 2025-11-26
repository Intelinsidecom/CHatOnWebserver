package com.sec.chaton.buddy.dialog;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0993ac;
import com.sec.chaton.EnumC1005ad;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p057e.C2293m;
import com.sec.chaton.p057e.p058a.C2187am;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4883f;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.d */
/* loaded from: classes.dex */
class C1226d implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f4726a;

    C1226d(BuddyDialog buddyDialog) {
        this.f4726a = buddyDialog;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) throws UnsupportedEncodingException {
        if (i == 3) {
            C4904y.m18639b("Buddy information exist : " + this.f4726a.f4509d, BuddyDialog.f4430a);
            this.f4726a.f4489ag = true;
            if (cursor != null && cursor.getCount() > 0) {
                if (cursor.moveToNext()) {
                    this.f4726a.f4524s = new C1106c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_orginal_numbers")), cursor.getString(cursor.getColumnIndex("buddy_msisdns")), cursor.getString(cursor.getColumnIndex("buddy_multidevice")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_birthday")) == null ? "" : cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false, cursor.getInt(cursor.getColumnIndex("buddy_show_phone_number")), cursor.getString(cursor.getColumnIndex("buddy_extra_info")), cursor.getInt(cursor.getColumnIndex("buddy_account_info")), cursor.getString(cursor.getColumnIndex("buddy_sainfo")), cursor.getString(cursor.getColumnIndex("buddy_contact_buddy")), cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use")));
                    if (cursor.getString(cursor.getColumnIndex("is_favorite")).equals("Y")) {
                        this.f4726a.f4488af = true;
                    } else {
                        this.f4726a.f4488af = false;
                    }
                    this.f4726a.f4498ap = C4883f.m18540a(this.f4726a.f4509d, this.f4726a.f4524s.m7057f());
                    if (!this.f4726a.f4498ap) {
                        this.f4726a.f4496an = false;
                        this.f4726a.f4497ao = this.f4726a.m7243s();
                        if (!this.f4726a.f4497ao) {
                            this.f4726a.f4511f = this.f4726a.f4524s.m7056e();
                            if (TextUtils.isEmpty(this.f4726a.f4511f)) {
                                if (this.f4726a.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                                    this.f4726a.f4511f = this.f4726a.f4524s.m7054c();
                                } else {
                                    this.f4726a.f4511f = "+" + this.f4726a.f4509d;
                                }
                            }
                        } else {
                            this.f4726a.f4511f = this.f4726a.f4524s.m7056e();
                            if (TextUtils.isEmpty(this.f4726a.f4511f)) {
                                this.f4726a.f4511f = null;
                            }
                        }
                    } else {
                        List listM7241r = this.f4726a.m7241r();
                        if (listM7241r.size() > 0) {
                            this.f4726a.f4511f = "+" + ((String) listM7241r.get(0));
                        }
                    }
                    this.f4726a.m7175a(false);
                }
                if (this.f4726a.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b(" Buddy dialog Contact buddy case ", BuddyDialog.f4430a);
                    }
                } else if (C4904y.f17872b) {
                    C4904y.m18639b(" Buddy dialog ChatON buddy case ", BuddyDialog.f4430a);
                }
            } else {
                C4904y.m18639b("Buddy information not found : " + this.f4726a.f4509d, BuddyDialog.f4430a);
                this.f4726a.f4489ag = false;
                this.f4726a.f4488af = false;
                if (this.f4726a.f4480aV != null && this.f4726a.f4480aV.equals("sms")) {
                    this.f4726a.m7214g();
                } else if (C2187am.m9783b(this.f4726a.f4509d)) {
                    this.f4726a.f4489ag = true;
                    this.f4726a.f4490ah = true;
                    if (this.f4726a.f4522q == null) {
                        this.f4726a.f4522q = new C2075ah(this.f4726a.f4481aW);
                    }
                    this.f4726a.f4522q.m9314d(this.f4726a.f4509d);
                } else {
                    this.f4726a.m7210f();
                }
            }
        } else if (i == 4) {
            if (cursor.getCount() >= 50) {
                C5179v.m19811a(this.f4726a.getApplicationContext(), String.format(this.f4726a.getResources().getString(R.string.contact_list_addfavorites_toast_failed_50), 50), 0).show();
                this.f4726a.f4488af = false;
                this.f4726a.f4433A.setImageResource(R.drawable.actionbar_ic_favorite_02);
            } else {
                C1106c c1106c = (C1106c) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_relation_group", (Integer) 1);
                contentValues.put("group_relation_buddy", c1106c.m7046a());
                this.f4726a.f4500ar.startInsert(1, c1106c, C2293m.f8204a, contentValues);
            }
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
        if (i == 1) {
            C1106c c1106c = (C1106c) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                this.f4726a.f4495am.setText(this.f4726a.getString(R.string.buddy_profile_addfavorites_toast_success, new Object[]{c1106c.m7051b()}));
                this.f4726a.f4495am.setDuration(0);
                this.f4726a.f4495am.show();
                this.f4726a.f4488af = true;
                this.f4726a.f4433A.setImageResource(R.drawable.actionbar_ic_favorite_01);
                C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.ADD_FAVORITE, c1106c.m7046a()));
                return;
            }
            C5179v.m19811a(this.f4726a.getApplicationContext(), this.f4726a.getResources().getString(R.string.buddy_profile_addfavorites_toast_failed), 0).show();
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (i == 2) {
            C1106c c1106c = (C1106c) obj;
            if (i2 != -1) {
                this.f4726a.f4495am.setText(R.string.buddy_list_removefavorites_toast_success);
                this.f4726a.f4495am.setDuration(0);
                this.f4726a.f4495am.show();
                this.f4726a.f4488af = false;
                this.f4726a.f4433A.setImageResource(R.drawable.actionbar_ic_favorite_02);
                C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.REMOVE_FAVORITE, c1106c.m7046a()));
                return;
            }
            C5179v.m19811a(this.f4726a.getApplicationContext(), this.f4726a.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
        }
    }
}
