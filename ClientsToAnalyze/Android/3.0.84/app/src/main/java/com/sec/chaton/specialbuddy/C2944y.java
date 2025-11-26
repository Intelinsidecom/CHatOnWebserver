package com.sec.chaton.specialbuddy;

import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.mobileweb.EnumC1681h;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.y */
/* loaded from: classes.dex */
class C2944y implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f10480a;

    C2944y(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f10480a = specialBuddyChatFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        String str;
        switch (i) {
            case 1:
                this.f10480a.f10428S = false;
                this.f10480a.m10136r();
                C3250y.m11450b("spbd_refresh, onQueryComplete(), QUERY_INBOX #2", SpecialBuddyChatFragment.f10409m);
                C3250y.m11450b("onQueryCompleted - QUERY_INBOX", SpecialBuddyChatFragment.f10409m);
                if (cursor == null) {
                    C3250y.m11450b("onQueryCompleted - QUERY_INBOX, #1 null", SpecialBuddyChatFragment.f10409m);
                    break;
                } else if (cursor.getCount() > 0) {
                    if (this.f10480a.f10443t || !this.f10480a.m6966k()) {
                        cursor.close();
                        C3250y.m11450b("onQueryCompleted - QUERY_INBOX, #3 (conditional return).", SpecialBuddyChatFragment.f10409m);
                        break;
                    } else if (!cursor.moveToFirst()) {
                        cursor.close();
                        C3250y.m11450b("onQueryCompleted - QUERY_INBOX, #4 fail : moveToFirst.", SpecialBuddyChatFragment.f10409m);
                        break;
                    } else {
                        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_last_chat_type"));
                        this.f10480a.f10445v = cursor.getString(cursor.getColumnIndex("inbox_no"));
                        this.f10480a.f10416G = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
                        String string = cursor.getString(cursor.getColumnIndex("weburl"));
                        String string2 = cursor.getString(cursor.getColumnIndex("inbox_web_url"));
                        if (!TextUtils.isEmpty(string)) {
                            C3250y.m11450b("onQueryComplete(), use WebUrl from BuddyTable: " + string, SpecialBuddyChatFragment.f10409m);
                            str = string;
                        } else if (!TextUtils.isEmpty(string2)) {
                            C3250y.m11450b("onQueryComplete(), use WebUrl from InboxTable: " + string2, SpecialBuddyChatFragment.f10409m);
                            str = string2;
                        } else if (TextUtils.isEmpty(this.f10480a.f10414E)) {
                            str = null;
                        } else {
                            String str2 = this.f10480a.f10414E;
                            C3250y.m11450b("onQueryComplete(), use mForwardedWebURL from External: " + this.f10480a.f10414E, SpecialBuddyChatFragment.f10409m);
                            str = str2;
                        }
                        if (TextUtils.isEmpty(str)) {
                            this.f10480a.m6955b(EnumC1681h.REQ_STARTING_MOBILE_WEB_CONTENTS);
                            this.f10480a.f10432W.sendEmptyMessage(2);
                            C3250y.m11450b("onQueryComplete(), no way of getting WebUrl: " + str, SpecialBuddyChatFragment.f10409m);
                            break;
                        } else {
                            if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(string2)) {
                                C1370n.m6129a(this.f10480a.f10441r, 5, this.f10480a.f10445v, str);
                                C3250y.m11450b("onQueryComplete(), spbd_weburl.update inbox : " + str, SpecialBuddyChatFragment.f10409m);
                                C3250y.m11450b("onQueryComplete(), recoverty ??", SpecialBuddyChatFragment.f10409m);
                            }
                            if (C3250y.f11734b) {
                                C3250y.m11450b("onQueryComplete(), spbd_weburl buddy : " + string, SpecialBuddyChatFragment.f10409m);
                                C3250y.m11450b("onQueryComplete(), spbd_weburl inbox : " + string2, SpecialBuddyChatFragment.f10409m);
                                C3250y.m11450b("onQueryComplete(), spbd_weburl mForwardedWebURL : " + this.f10480a.f10414E, SpecialBuddyChatFragment.f10409m);
                                C3250y.m11450b("onQueryComplete(), spbd_weburl. applied weburl : " + str, SpecialBuddyChatFragment.f10409m);
                            }
                            if (i2 == 12) {
                                if (this.f10480a.m10142v()) {
                                    this.f10480a.f10442s.m5880a(this.f10480a.f10445v, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                                    this.f10480a.f10442s.m5893c(Long.MAX_VALUE);
                                    this.f10480a.f10442s.m5902k();
                                } else {
                                    cursor.close();
                                    break;
                                }
                            } else {
                                this.f10480a.f10412C = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                                this.f10480a.f10449z = Long.valueOf(cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no")));
                                String string3 = cursor.getString(cursor.getColumnIndex("inbox_title"));
                                C3250y.m11450b("hslee_title, mChatTitle from DB query : " + string3, SpecialBuddyChatFragment.f10409m);
                                if (!TextUtils.isEmpty(string3)) {
                                    this.f10480a.f10413D = string3;
                                    C3250y.m11450b("hslee_title, setTitle() #2 : " + this.f10480a.f10413D, SpecialBuddyChatFragment.f10409m);
                                    this.f10480a.mo10070d(this.f10480a.f10413D);
                                }
                                this.f10480a.f10447x = cursor.getString(cursor.getColumnIndex("buddy_name"));
                                C3250y.m11450b("hslee_title, mBuddyName from DB query: " + this.f10480a.f10447x, SpecialBuddyChatFragment.f10409m);
                                if (TextUtils.isEmpty(this.f10480a.f10413D)) {
                                    this.f10480a.f10413D = this.f10480a.f10447x;
                                    C3250y.m11450b("hslee_title, setTitle() #3 : " + this.f10480a.f10413D, SpecialBuddyChatFragment.f10409m);
                                    this.f10480a.mo10070d(this.f10480a.f10413D);
                                }
                                this.f10480a.f10446w = cursor.getInt(cursor.getColumnIndex("_id"));
                                this.f10480a.f10444u = cursor.getString(cursor.getColumnIndex("buddy_no"));
                                this.f10480a.f10411B = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
                                this.f10480a.f10410A = cursor.getLong(cursor.getColumnIndex("inbox_last_timestamp"));
                                String str3 = this.f10480a.f10444u;
                                if (this.f10480a.f10448y == EnumC1450r.GROUPCHAT) {
                                    str3 = this.f10480a.f10445v;
                                }
                                if (this.f10480a.m10142v()) {
                                    this.f10480a.f10442s.m5880a(this.f10480a.f10445v, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                                    this.f10480a.f10442s.m5893c(Long.MAX_VALUE);
                                    if (this.f10480a.f10411B) {
                                        C3250y.m11450b("spbd_refresh, onQueryComplete(), QUERY_INBOX, call allowChat() #2-1", SpecialBuddyChatFragment.f10409m);
                                        this.f10480a.f10442s.m5876a(EnumC1450r.BROADCAST, str3, this.f10480a.f10449z, this.f10480a.f10412C, this.f10480a.f10445v, this.f10480a.f10410A, true);
                                    }
                                } else {
                                    cursor.close();
                                    break;
                                }
                            }
                            cursor.close();
                            this.f10480a.f10428S = true;
                            this.f10480a.f10429T = C1357af.m5995b(GlobalApplication.m11493l().getContentResolver(), this.f10480a.f10444u);
                            C3250y.m11450b("onQueryReturn(), mIsInService: " + this.f10480a.f10429T, SpecialBuddyChatFragment.f10409m);
                            this.f10480a.m10136r();
                            this.f10480a.m10102a(this.f10480a.f10416G);
                            if (!TextUtils.isEmpty(str)) {
                                if (TextUtils.isEmpty(this.f10480a.f10444u)) {
                                    C3250y.m11450b("onQueryComplete(), mBuddyNo is null", SpecialBuddyChatFragment.f10409m);
                                    this.f10480a.m6955b((EnumC1681h) null);
                                } else if (!this.f10480a.m6964i()) {
                                    this.f10480a.m6958c(this.f10480a.m10148a(str, this.f10480a.f10444u));
                                } else {
                                    this.f10480a.mo6965j();
                                }
                            } else {
                                C3250y.m11450b("onQueryComplete(), mWebURL is null", SpecialBuddyChatFragment.f10409m);
                                this.f10480a.m6955b((EnumC1681h) null);
                            }
                            this.f10480a.m10133q();
                            break;
                        }
                    }
                } else {
                    cursor.close();
                    C3250y.m11450b("onQueryCompleted - QUERY_INBOX, #2 nothing", SpecialBuddyChatFragment.f10409m);
                    break;
                }
                break;
            default:
                if (cursor != null) {
                    cursor.close();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) throws Throwable {
        if (this.f10480a.m6966k() && i == 4) {
            C1103a.m5432a(this.f10480a.m6961f()).m5454a(this.f10480a.f10445v, C1103a.f4445g);
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
