package com.sec.chaton.chat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.p016a.p017a.C0264a;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3189bd;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.spp.push.Config;
import com.sec.widget.C3641ai;
import java.util.Iterator;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bb */
/* loaded from: classes.dex */
class C0979bb implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4043a;

    C0979bb(ChatFragment chatFragment) {
        this.f4043a = chatFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) throws Throwable {
        boolean zM5324b;
        if (this.f4043a.f3672cr != null) {
            if (this.f4043a.f3594bQ) {
                if (cursor != null) {
                    this.f4043a.m4870b(cursor);
                    return;
                }
                return;
            }
            switch (i) {
                case 0:
                    C3250y.m11450b("onQueryCompleted - QUERY_MESSAGE", getClass().getSimpleName());
                    if (this.f4043a.f3605bb) {
                        C3250y.m11450b("onQueryCompleted - QUERY_MESSAGE : isQueryForMark true", getClass().getSimpleName());
                        return;
                    }
                    if (cursor != null && cursor.getCount() > 0 && this.f4043a.f3710y == null) {
                        cursor.moveToFirst();
                        this.f4043a.f3710y = cursor.getString(cursor.getColumnIndex("message_session_id"));
                    }
                    Cursor cursorSwapCursor = this.f4043a.f3527aC.swapCursor(cursor);
                    if (cursorSwapCursor != null) {
                        this.f4043a.m4870b(cursorSwapCursor);
                    }
                    if (cursor == null || cursor.getCount() <= 0) {
                        this.f4043a.f3526aB.setSelection(0);
                        if (this.f4043a.f3705t) {
                            this.f4043a.m4859ay();
                            return;
                        } else {
                            this.f4043a.f3593bP = false;
                            return;
                        }
                    }
                    this.f4043a.f3592bO = cursor.getCount();
                    if (this.f4043a.f3503E) {
                        this.f4043a.f3526aB.setSelection(cursor.getCount());
                    }
                    this.f4043a.f3593bP = true;
                    return;
                case 1:
                    C3250y.m11450b("onQueryCompleted - QUERY_INBOX", getClass().getSimpleName());
                    if (cursor != null && cursor.getCount() != 0) {
                        this.f4043a.m4742a(cursor);
                        this.f4043a.m4789aF();
                        if (cursor != null && !cursor.isClosed()) {
                            this.f4043a.m4870b(cursor);
                        }
                    } else {
                        if (TextUtils.isEmpty(this.f4043a.f3703r)) {
                            this.f4043a.f3703r = C3189bd.m11137a();
                        }
                        if (this.f4043a.m4690I()) {
                            this.f4043a.f3530aF.m5880a(this.f4043a.f3703r, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                            this.f4043a.f3530aF.m5893c(Long.MAX_VALUE);
                            if (!this.f4043a.f3530aF.m5903l()) {
                                this.f4043a.f3530aF.m5902k();
                            }
                            synchronized (this.f4043a.f3524Z) {
                                this.f4043a.f3551aa.startQuery(2, null, C1441i.m6313f(), null, "buddy_no IN" + C1075eq.m5321a(this.f4043a.f3536aL), null, null);
                            }
                            this.f4043a.f3705t = false;
                            this.f4043a.f3706u = false;
                            if (cursor != null) {
                                this.f4043a.m4870b(cursor);
                            }
                            if (this.f4043a.f3709x == EnumC1450r.GROUPCHAT) {
                                if (!TextUtils.isEmpty(this.f4043a.f3707v)) {
                                    CharSequence charSequenceM7508a = C1835j.m7508a(this.f4043a.f3672cr, this.f4043a.f3707v, (int) (this.f4043a.f3613bj.getLineHeight() * 1.2f));
                                    if (!this.f4043a.f3684dc && TextUtils.isEmpty(this.f4043a.f3613bj.getText().toString())) {
                                        this.f4043a.f3613bj.setText(charSequenceM7508a);
                                        this.f4043a.f3613bj.setSelection(charSequenceM7508a.length());
                                    }
                                }
                                this.f4043a.f3612bi = C3159aa.m10962a().m10977a("Setting alert_new_groupchat", (Boolean) true).booleanValue();
                            }
                            ((ActionBarFragmentActivity) this.f4043a.getActivity()).supportInvalidateOptionsMenu();
                        } else {
                            if (cursor != null) {
                                this.f4043a.m4870b(cursor);
                                return;
                            }
                            return;
                        }
                    }
                    this.f4043a.m4791aG();
                    return;
                case 2:
                    if (cursor == null || cursor.getCount() == 0) {
                        if (this.f4043a.f3588bK.containsKey("receivers")) {
                            synchronized (this.f4043a.f3524Z) {
                                for (String str : this.f4043a.f3588bK.getStringArray("receivers")) {
                                    this.f4043a.f3536aL.add(str);
                                    this.f4043a.f3537aM.put(str, new C0264a(str));
                                }
                            }
                        }
                        if (cursor != null) {
                            this.f4043a.m4870b(cursor);
                        }
                        this.f4043a.f3540aP = C1075eq.m5322a(this.f4043a.f3536aL, this.f4043a.f3537aM);
                        if (this.f4043a.f3709x == EnumC1450r.GROUPCHAT && this.f4043a.f3536aL.size() <= 0) {
                            this.f4043a.f3540aP = GlobalApplication.m6451b().getString(R.string.chat_title_no_buddies);
                        }
                        this.f4043a.f3639cI.setText(this.f4043a.f3540aP, TextView.BufferType.NORMAL);
                    } else {
                        if (this.f4043a.f3546aV == null) {
                            this.f4043a.m4824ah();
                            if (this.f4043a.f3543aS == null || !this.f4043a.f3543aS.equals("Y")) {
                                this.f4043a.f3540aP = C1075eq.m5316a(cursor, this.f4043a.f3536aL, this.f4043a.f3537aM);
                            } else {
                                this.f4043a.f3540aP = this.f4043a.f3542aR;
                            }
                            if (this.f4043a.f3709x == EnumC1450r.GROUPCHAT && this.f4043a.f3536aL.size() <= 0) {
                                this.f4043a.f3540aP = GlobalApplication.m6451b().getString(R.string.chat_title_no_buddies);
                            }
                            if (this.f4043a.f3628by) {
                                this.f4043a.f3540aP = this.f4043a.f3627bx;
                                this.f4043a.f3628by = false;
                            } else {
                                this.f4043a.f3541aQ = this.f4043a.f3540aP;
                                this.f4043a.f3639cI.setText(this.f4043a.f3540aP);
                            }
                        }
                        this.f4043a.m4870b(cursor);
                    }
                    this.f4043a.m5007h();
                    if (this.f4043a.f3578bA) {
                        this.f4043a.m4982a(this.f4043a.f3588bK.getStringArray("receivers"));
                        this.f4043a.f3578bA = false;
                    }
                    this.f4043a.f3629bz = false;
                    return;
                case 3:
                case 4:
                case 8:
                case 9:
                case 18:
                default:
                    return;
                case 5:
                    if (cursor != null) {
                        if (C3250y.f11735c) {
                            C3250y.m11453c("QUERY_PARTICIPANTS_AFTER_onQueryCompleted : " + String.valueOf(cursor.getCount()), ChatFragment.f3484a);
                        }
                        synchronized (this.f4043a.f3524Z) {
                            zM5324b = C1075eq.m5324b(cursor, this.f4043a.f3536aL, this.f4043a.f3537aM);
                        }
                        if (C3250y.f11735c) {
                            C3250y.m11453c("QUERY_PARTICIPANTS_AFTER_onQueryCompleted - isParticipantsChanged : " + String.valueOf(zM5324b), ChatFragment.f3484a);
                        }
                        this.f4043a.m4824ah();
                        if (TextUtils.isEmpty(this.f4043a.f3704s)) {
                            try {
                                this.f4043a.f3704s = (String) this.f4043a.f3536aL.get(0);
                                this.f4043a.f3545aU = ((C0264a) this.f4043a.f3537aM.get(this.f4043a.f3704s)).m1329a();
                            } catch (Exception e) {
                                this.f4043a.f3545aU = GlobalApplication.m6451b().getString(R.string.unknown);
                            }
                        }
                        if (zM5324b) {
                            this.f4043a.f3540aP = "";
                            if (C3250y.f11735c) {
                                C3250y.m11453c("QUERY_PARTICIPANTS_AFTER_onQueryCompleted : invalidate option ", ChatFragment.f3484a);
                            }
                            ((ActionBarFragmentActivity) this.f4043a.getActivity()).supportInvalidateOptionsMenu();
                        }
                        if (this.f4043a.f3543aS == null) {
                            if (this.f4043a.f3546aV != null) {
                                this.f4043a.f3540aP = this.f4043a.f3546aV;
                                this.f4043a.f3546aV = null;
                            } else if (zM5324b) {
                                if (this.f4043a.f3536aL.size() <= 0) {
                                    this.f4043a.f3540aP = GlobalApplication.m6451b().getString(R.string.chat_title_no_buddies);
                                } else {
                                    Iterator it = this.f4043a.f3536aL.iterator();
                                    while (it.hasNext()) {
                                        ChatFragment.m4739a(this.f4043a, (Object) (((C0264a) this.f4043a.f3537aM.get((String) it.next())).m1329a() + ", "));
                                    }
                                    if (this.f4043a.f3540aP.length() > 1) {
                                        this.f4043a.f3540aP = this.f4043a.f3540aP.substring(0, this.f4043a.f3540aP.length() - 2);
                                    }
                                }
                                this.f4043a.f3541aQ = this.f4043a.f3540aP;
                                this.f4043a.f3639cI.setText(this.f4043a.f3540aP);
                            }
                        } else if (zM5324b) {
                            if (this.f4043a.f3543aS.equals("Y")) {
                                this.f4043a.f3540aP = this.f4043a.f3542aR;
                            } else {
                                if (this.f4043a.f3536aL.size() <= 0) {
                                    this.f4043a.f3540aP = GlobalApplication.m6451b().getString(R.string.chat_title_no_buddies);
                                } else {
                                    Iterator it2 = this.f4043a.f3536aL.iterator();
                                    while (it2.hasNext()) {
                                        ChatFragment.m4739a(this.f4043a, (Object) (((C0264a) this.f4043a.f3537aM.get((String) it2.next())).m1329a() + ", "));
                                    }
                                    if (this.f4043a.f3540aP.length() > 1) {
                                        this.f4043a.f3540aP = this.f4043a.f3540aP.substring(0, this.f4043a.f3540aP.length() - 2);
                                    }
                                }
                                if (!this.f4043a.f3540aP.equals(this.f4043a.f3542aR)) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("inbox_title", this.f4043a.f3540aP);
                                    contentValues.put("inbox_participants", Integer.valueOf(this.f4043a.f3536aL.size()));
                                    this.f4043a.f3551aa.startUpdate(18, null, C1449q.f5381a, contentValues, "inbox_no='" + this.f4043a.f3703r + "'", null);
                                }
                                this.f4043a.f3542aR = this.f4043a.f3540aP;
                            }
                            this.f4043a.f3541aQ = this.f4043a.f3540aP;
                            this.f4043a.f3639cI.setText(this.f4043a.f3540aP);
                        } else {
                            this.f4043a.f3540aP = this.f4043a.f3542aR;
                            if (!this.f4043a.f3543aS.equals("Y") && this.f4043a.f3536aL.size() <= 0) {
                                this.f4043a.f3540aP = GlobalApplication.m6451b().getString(R.string.chat_title_no_buddies);
                            }
                            if (!this.f4043a.f3563am) {
                                this.f4043a.f3541aQ = this.f4043a.f3540aP;
                                this.f4043a.f3639cI.setText(this.f4043a.f3540aP);
                            }
                        }
                        this.f4043a.m4870b(cursor);
                    }
                    this.f4043a.m5007h();
                    if (this.f4043a.f3578bA) {
                        this.f4043a.m4982a(this.f4043a.f3588bK.getStringArray("receivers"));
                        this.f4043a.f3578bA = false;
                    }
                    this.f4043a.f3629bz = false;
                    return;
                case 6:
                    if (cursor != null) {
                        this.f4043a.m4870b(cursor);
                        return;
                    }
                    return;
                case 7:
                    if (cursor != null && cursor.getCount() != 0) {
                        cursor.moveToNext();
                        this.f4043a.f3500B.add(new C0513c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), !cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y")));
                        Intent intent = new Intent(this.f4043a.f3672cr, (Class<?>) BuddyProfileActivity.class);
                        intent.putExtra("PROFILE_BUDDY_INFO", this.f4043a.f3500B.get(0));
                        intent.setFlags(67108864);
                        this.f4043a.startActivityForResult(intent, 20);
                    }
                    if (cursor != null) {
                        this.f4043a.m4870b(cursor);
                        return;
                    }
                    return;
                case 10:
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        this.f4043a.f3609bf = "Y".equals(cursor.getString(0));
                        if (!this.f4043a.f3609bf) {
                            this.f4043a.f3569as.setVisibility(8);
                        }
                        this.f4043a.f3527aC.m5287a(this.f4043a.f3609bf);
                        String string = cursor.getString(1);
                        if (!TextUtils.isEmpty(string) && !string.equals(this.f4043a.f3710y)) {
                            this.f4043a.f3710y = string;
                        }
                        this.f4043a.f3611bh = cursor.getLong(2);
                        this.f4043a.f3548aX = cursor.getString(4);
                        this.f4043a.f3709x = EnumC1450r.m6339a(cursor.getInt(cursor.getColumnIndex("inbox_chat_type")));
                        if (C3250y.f11735c) {
                            C3250y.m11453c("QUERY_INBOX_CHANGED - sessionId:" + this.f4043a.f3710y + ",lasstTid:" + this.f4043a.f3548aX + ",chatType:" + this.f4043a.f3709x, ChatFragment.f3484a);
                        }
                    }
                    if (cursor != null) {
                        this.f4043a.m4870b(cursor);
                        return;
                    }
                    return;
                case 11:
                    ContentValues contentValues2 = new ContentValues();
                    if (cursor != null && cursor.getCount() != 0) {
                        cursor.moveToLast();
                        if (0 <= cursor.getCount()) {
                            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
                            int i2 = cursor.getInt(cursor.getColumnIndex("message_type"));
                            EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                            String string3 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                            String string4 = cursor.getString(cursor.getColumnIndex("message_time"));
                            String string5 = cursor.getString(cursor.getColumnIndex("message_sever_id"));
                            String string6 = cursor.getString(cursor.getColumnIndex("message_sender"));
                            contentValues2.put("inbox_last_message", String.format("%d;%d;%s;%s", Integer.valueOf(i2), Integer.valueOf(enumC1455wM6358a.m6364a()), C1075eq.m5318a(string2), C1075eq.m5318a(string3)));
                            contentValues2.put("inbox_last_msg_no", string5);
                            contentValues2.put("inbox_last_time", string4);
                            contentValues2.put("inbox_last_msg_sender", string6);
                            this.f4043a.f3551aa.startUpdate(4, null, C1449q.f5381a, contentValues2, "inbox_no='" + this.f4043a.f3703r + "'", null);
                        }
                    } else {
                        contentValues2.put("inbox_last_message", "");
                        this.f4043a.f3551aa.startUpdate(4, null, C1449q.f5381a, contentValues2, "inbox_no='" + this.f4043a.f3703r + "'", null);
                    }
                    if (cursor != null) {
                        this.f4043a.m4870b(cursor);
                        return;
                    }
                    return;
                case 12:
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        long j = cursor.getLong(cursor.getColumnIndex("message_total_count"));
                        long j2 = cursor.getLong(cursor.getColumnIndex("message_sent_count"));
                        this.f4043a.f3527aC.m5283a(j - j2);
                        this.f4043a.f3527aC.m5289b(j2);
                    }
                    if (cursor != null) {
                        this.f4043a.m4870b(cursor);
                    }
                    if (!this.f4043a.f3563am) {
                        this.f4043a.m5015p();
                    }
                    this.f4043a.m4676B();
                    return;
                case 13:
                    if (cursor != null && cursor.getCount() > 0) {
                        Intent intent2 = new Intent(this.f4043a.f3672cr, (Class<?>) BuddyActivity2.class);
                        intent2.putExtra("ACTIVITY_PURPOSE", 5);
                        intent2.putExtra("chatType", this.f4043a.f3709x.m6342a());
                        synchronized (this.f4043a.f3524Z) {
                            intent2.putExtra(ChatFragment.f3489f, (String[]) this.f4043a.f3536aL.toArray(new String[this.f4043a.f3536aL.size()]));
                        }
                        this.f4043a.startActivityForResult(intent2, 4);
                        this.f4043a.f3701p = true;
                    } else {
                        C3641ai.m13211a(CommonApplication.m11493l(), this.f4043a.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
                    }
                    if (cursor != null) {
                        this.f4043a.m4870b(cursor);
                        return;
                    }
                    return;
                case 14:
                case 19:
                    C3250y.m11450b("onQueryCompleted - QUERY_MESSAGE_LOAD_MORE", getClass().getSimpleName());
                    if (cursor != null && cursor.getCount() > 0 && this.f4043a.f3710y == null) {
                        cursor.moveToFirst();
                        this.f4043a.f3710y = cursor.getString(cursor.getColumnIndex("message_session_id"));
                    }
                    Cursor cursorSwapCursor2 = this.f4043a.f3527aC.swapCursor(cursor);
                    if (cursorSwapCursor2 != null) {
                        this.f4043a.m4870b(cursorSwapCursor2);
                    }
                    if (cursor == null || cursor.getCount() <= 0) {
                        this.f4043a.f3526aB.setSelection(0);
                    } else {
                        int count = cursor.getCount();
                        int i3 = count - this.f4043a.f3592bO;
                        this.f4043a.f3592bO = count;
                        if (i3 == 0) {
                            this.f4043a.m4859ay();
                        }
                        if (this.f4043a.f3503E) {
                            this.f4043a.f3526aB.setSelection(cursor.getCount());
                        } else if (i3 > 0) {
                            if (i3 < 30) {
                                this.f4043a.f3526aB.setSelection(i3);
                            } else {
                                this.f4043a.f3526aB.setSelection(30);
                            }
                        }
                    }
                    if (i == 19) {
                        this.f4043a.m4779aA();
                        return;
                    } else {
                        if (i == 14) {
                            this.f4043a.f3632cB = false;
                            return;
                        }
                        return;
                    }
                case 15:
                    C3250y.m11450b("onQueryCompleted - QUERY_MESSAGE_UNREAD_MARK", getClass().getSimpleName());
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        long j3 = cursor.getLong(cursor.getColumnIndex("message_time"));
                        C3250y.m11450b("first unread message content:" + cursor.getString(cursor.getColumnIndex("message_content")), getClass().getSimpleName());
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.MARK.m6248a()), "mark", C1075eq.m5318a("mark"))).append(Config.KEYVALUE_SPLIT);
                        C1373q.m6163a(this.f4043a.f3551aa, 1, this.f4043a.f3703r, sb.toString(), j3 - 1);
                        this.f4043a.f3605bb = true;
                        return;
                    }
                    return;
                case 16:
                    C3250y.m11450b("onQueryCompleted - QUERY_MESSAGE_FOR_MARK", getClass().getSimpleName());
                    if (cursor != null && cursor.getCount() > 0 && this.f4043a.f3710y == null) {
                        cursor.moveToFirst();
                        this.f4043a.f3710y = cursor.getString(cursor.getColumnIndex("message_session_id"));
                    }
                    Cursor cursorSwapCursor3 = this.f4043a.f3527aC.swapCursor(cursor);
                    if (cursorSwapCursor3 != null) {
                        this.f4043a.m4870b(cursorSwapCursor3);
                    }
                    if (cursor == null || cursor.getCount() <= 0) {
                        this.f4043a.f3526aB.setSelection(0);
                        this.f4043a.f3604ba = true;
                        this.f4043a.f3605bb = false;
                        return;
                    } else {
                        this.f4043a.f3592bO = cursor.getCount();
                        new Handler().postDelayed(new RunnableC0980bc(this), 1300L);
                        return;
                    }
                case 17:
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        this.f4043a.f3535aK = true;
                        this.f4043a.f3532aH = cursor.getInt(cursor.getColumnIndex("buddy_show_phone_number"));
                        this.f4043a.f3533aI = cursor.getString(cursor.getColumnIndex("buddy_extra_info"));
                        this.f4043a.f3534aJ = cursor.getString(cursor.getColumnIndex("buddy_msisdns"));
                        if (C3250y.f11735c) {
                            C3250y.m11453c("QUERY_BUDDY_INFO - mShowPhoneNumber:" + this.f4043a.f3532aH + ",mExtraInfo:" + this.f4043a.f3533aI + ",mMsisdns:" + this.f4043a.f3534aJ, ChatFragment.f3484a);
                        }
                        if (!TextUtils.isEmpty(this.f4043a.f3534aJ)) {
                            if (TextUtils.isEmpty(this.f4043a.f3704s)) {
                                this.f4043a.f3532aH = 0;
                            } else if (this.f4043a.m4998d(this.f4043a.f3534aJ)) {
                                if (this.f4043a.m4948r(this.f4043a.f3534aJ).size() == 0) {
                                    this.f4043a.f3532aH = 0;
                                } else {
                                    this.f4043a.f3532aH = 1;
                                }
                            }
                        }
                        if (!cursor.isClosed()) {
                            this.f4043a.m4870b(cursor);
                        }
                    }
                    if (this.f4043a.f3535aK) {
                        this.f4043a.m4855aw();
                        return;
                    } else {
                        new C1330h(this.f4043a.f3522X).m5748f(this.f4043a.f3704s, false);
                        return;
                    }
            }
        }
        C3250y.m11442a("onQueryCompleted - Activity is null", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) throws Throwable {
        if (i == 4) {
            C3250y.m11450b("QUERY_UPDATE_INBOX - completed. result:" + i2, ChatFragment.f3484a);
            if (i2 > 0) {
                C1103a.m5432a(this.f4043a.f3672cr).m5454a(this.f4043a.f3703r, C1103a.f4445g);
            } else if (C1103a.m5432a(this.f4043a.f3672cr).m5468d(this.f4043a.f3703r)) {
                C1103a.m5432a(this.f4043a.f3672cr).m5454a(this.f4043a.f3703r, C1103a.f4445g);
            }
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
        if (i == 3) {
            this.f4043a.f3526aB.setChoiceMode(0);
            if (!this.f4043a.f3503E) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("DeleteMessageObserver_QUERY_MESSAGE", getClass().getSimpleName());
                }
                this.f4043a.f3551aa.startQuery(0, null, C1454v.m6344a(this.f4043a.f3597bT), null, "message_inbox_no=?", new String[]{this.f4043a.f3703r}, null);
            }
            this.f4043a.f3526aB.clearChoices();
            if (this.f4043a.f3609bf) {
                this.f4043a.f3569as.setVisibility(0);
            }
            this.f4043a.f3551aa.startQuery(11, null, C1454v.m6348b(), null, "message_inbox_no = ? AND ( message_type = ? OR message_type = ? ) AND message_content_type != ?", new String[]{this.f4043a.f3703r, String.valueOf(1), String.valueOf(2), String.valueOf(EnumC1455w.SYSTEM.m6364a())}, "message_is_failed , message_time , _id");
        }
    }
}
