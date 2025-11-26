package com.sec.chaton.specialbuddy;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import java.util.ArrayList;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.q */
/* loaded from: classes.dex */
class C4552q implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16424a;

    C4552q(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f16424a = specialBuddyChatFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) throws RemoteException, OperationApplicationException {
        boolean z = false;
        switch (i) {
            case 1:
                this.f16424a.f16329aC = false;
                this.f16424a.m17193m();
                C4904y.m18639b("spbd_refresh, onQueryComplete(), QUERY_INBOX #2", SpecialBuddyChatFragment.f16299l);
                C4904y.m18639b("onQueryCompleted - QUERY_INBOX", SpecialBuddyChatFragment.f16299l);
                if (cursor == null) {
                    C4904y.m18639b("onQueryCompleted - QUERY_INBOX, #1 null", SpecialBuddyChatFragment.f16299l);
                    break;
                } else if (cursor.getCount() > 0) {
                    if (this.f16424a.f16374s || !this.f16424a.isValidActivity()) {
                        cursor.close();
                        C4904y.m18639b("onQueryCompleted - QUERY_INBOX, #3 (conditional return).", SpecialBuddyChatFragment.f16299l);
                        break;
                    } else if (!cursor.moveToFirst()) {
                        cursor.close();
                        C4904y.m18639b("onQueryCompleted - QUERY_INBOX, #4 fail : moveToFirst.", SpecialBuddyChatFragment.f16299l);
                        break;
                    } else {
                        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_last_chat_type"));
                        this.f16424a.f16376u = cursor.getString(cursor.getColumnIndex("inbox_no"));
                        this.f16424a.f16304E = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
                        C1813b.m8906b().m8924a(this.f16424a.f16376u, EnumC4549n.LIVECONTENTS);
                        String string = cursor.getString(cursor.getColumnIndex("inbox_title"));
                        C4904y.m18639b("QUERY INBOX, title : " + string, SpecialBuddyChatFragment.f16299l);
                        if (!TextUtils.isEmpty(string)) {
                            this.f16424a.f16302C = string;
                            this.f16424a.setTitle(this.f16424a.f16302C);
                        }
                        String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                        C4904y.m18639b("QUERY INBOX, buddy name : " + string2 + ", mBuddyName:" + this.f16424a.f16378w, SpecialBuddyChatFragment.f16299l);
                        if (TextUtils.isEmpty(this.f16424a.f16378w)) {
                            if (!TextUtils.isEmpty(string2)) {
                                this.f16424a.f16378w = string2;
                            } else {
                                this.f16424a.f16378w = CommonApplication.m18732r().getResources().getString(R.string.unknown);
                            }
                        }
                        if (this.f16424a.f16378w.equals(GlobalApplication.m10283b().getString(R.string.unknown))) {
                            z = true;
                        } else {
                            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                            arrayList.add(C2176ab.m9687c(this.f16424a.f16376u, this.f16424a.f16375t, this.f16424a.f16378w));
                            try {
                                CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                            } catch (Exception e) {
                                if (C4904y.f17873c) {
                                    C4904y.m18641c("Failed to update participant name of unfollowing Live CP.", SpecialBuddyChatFragment.f16299l);
                                }
                            }
                        }
                        if (TextUtils.isEmpty(this.f16424a.f16302C)) {
                            this.f16424a.f16302C = this.f16424a.f16378w;
                            this.f16424a.setTitle(this.f16424a.f16302C);
                            if (z) {
                                this.f16424a.f16358ax.m9535i(this.f16424a.f16375t);
                            }
                        }
                        String string3 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                        C4904y.m18639b("QUERY INBOX, BuddyNo : " + string3, SpecialBuddyChatFragment.f16299l);
                        if (TextUtils.isEmpty(this.f16424a.f16375t)) {
                            this.f16424a.f16375t = string3;
                        }
                        String string4 = cursor.getString(cursor.getColumnIndex("usertype"));
                        C4904y.m18639b("QUERY INBOX, UserType : " + string4, SpecialBuddyChatFragment.f16299l);
                        if (!TextUtils.isEmpty(string4)) {
                            this.f16424a.f16305F = EnumC1109f.m7094a(string4);
                        }
                        if (i2 == 12) {
                            if (this.f16424a.m17200q()) {
                                this.f16424a.f16373r.mo9252a(this.f16424a.f16376u, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                                this.f16424a.f16373r.mo9243a(Long.MAX_VALUE);
                                this.f16424a.f16373r.mo9278f();
                            } else {
                                cursor.close();
                                break;
                            }
                        } else {
                            this.f16424a.f16380y = Long.valueOf(cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no")));
                            this.f16424a.f16377v = cursor.getInt(cursor.getColumnIndex("_id"));
                            boolean zEquals = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
                            this.f16424a.f16381z = cursor.getLong(cursor.getColumnIndex("inbox_last_timestamp"));
                            String str = this.f16424a.f16375t;
                            if (this.f16424a.f16379x == EnumC2300t.GROUPCHAT) {
                                str = this.f16424a.f16376u;
                            }
                            if (this.f16424a.m17200q()) {
                                this.f16424a.f16373r.mo9252a(this.f16424a.f16376u, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                                this.f16424a.f16373r.mo9243a(Long.MAX_VALUE);
                                if (zEquals) {
                                    C4904y.m18639b("spbd_refresh, onQueryComplete(), QUERY_INBOX, call allowChat() #2-1", SpecialBuddyChatFragment.f16299l);
                                    this.f16424a.f16373r.mo9248a(EnumC2300t.BROADCAST, str, this.f16424a.f16380y, (String) null, this.f16424a.f16376u, this.f16424a.f16381z, true);
                                }
                            } else {
                                cursor.close();
                                break;
                            }
                        }
                        cursor.close();
                        if (TextUtils.isEmpty(this.f16424a.f16302C)) {
                            this.f16424a.f16302C = GlobalApplication.m10283b().getString(R.string.unknown);
                            C4904y.m18639b("hslee_title, setTitle() #4 : " + this.f16424a.f16302C, SpecialBuddyChatFragment.f16299l);
                            this.f16424a.setTitle(this.f16424a.f16302C);
                        }
                        this.f16424a.f16329aC = true;
                        this.f16424a.f16330aD = C2186al.m9772b(GlobalApplication.m18732r().getContentResolver(), this.f16424a.f16375t);
                        C4904y.m18639b("onQueryReturn(), mIsInService: " + this.f16424a.f16330aD, SpecialBuddyChatFragment.f16299l);
                        this.f16424a.m17193m();
                        this.f16424a.m17162a(this.f16424a.f16304E);
                        if (TextUtils.isEmpty(this.f16424a.f16375t)) {
                            C4904y.m18639b("onQueryComplete(), mBuddyNo is null", SpecialBuddyChatFragment.f16299l);
                            this.f16424a.dismissOpenProgress(null);
                        } else if (!this.f16424a.isRequestedLoadingWeb()) {
                            this.f16424a.m17217f();
                            this.f16424a.startWebContents(this.f16424a.m17213a(this.f16424a.f16375t));
                        }
                        this.f16424a.m17189k();
                        break;
                    }
                } else {
                    cursor.close();
                    C4904y.m18639b("onQueryCompleted - QUERY_INBOX, #2 nothing", SpecialBuddyChatFragment.f16299l);
                    break;
                }
                break;
            case 98:
                if (cursor != null) {
                    this.f16424a.m17153a(cursor);
                    break;
                }
                break;
            case 99:
                C4904y.m18646e("[MSGBOX] onQueryComplete() QUERY_MSGBOX", SpecialBuddyChatFragment.f16299l);
                Cursor cursorB = this.f16424a.f16362f.mo877b(cursor);
                if (cursorB != null) {
                    this.f16424a.m17153a(cursorB);
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

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        if (this.f16424a.isValidActivity() && i == 4) {
            this.f16424a.f16359ay = i2;
            C1813b.m8906b().m8923a(this.f16424a.f16376u, C1813b.f6838g, false, true);
            if (this.f16424a.f16346al != null) {
                ((ActionBarFragmentActivity) this.f16424a.f16346al).mo51u_();
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
