package com.sec.chaton.chat;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.smsplugin.provider.C3945c;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bo */
/* loaded from: classes.dex */
class HandlerC1607bo extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6123a;

    HandlerC1607bo(ChatFragment chatFragment) {
        this.f6123a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        long j;
        String string;
        String string2;
        int i = 0;
        switch (message.what) {
            case 22:
                C3945c c3945c = (C3945c) message.obj;
                ContentValues contentValues = (ContentValues) c3945c.f14222g;
                Cursor cursor = (Cursor) c3945c.f14223h;
                if (cursor != null && cursor.getCount() > 0 && !cursor.isClosed()) {
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                string = cursor.getString(0);
                                j = cursor.getLong(1);
                                if (!cursor.isNull(2)) {
                                    i = cursor.getInt(2);
                                }
                            } else {
                                j = 0;
                                string = null;
                            }
                            this.f6123a.m8121c(cursor);
                            string2 = string;
                        } finally {
                            this.f6123a.m8121c(cursor);
                        }
                    } else {
                        j = 0;
                        string2 = null;
                    }
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("inbox_last_time", Long.valueOf(j));
                    if (TextUtils.isEmpty(string2)) {
                        string2 = this.f6123a.getResources().getString(R.string.no_subject);
                    }
                    contentValues2.put("inbox_last_message", C3947e.m15257a(string2, i));
                    if (j > (contentValues.containsKey("inbox_last_time") ? contentValues.getAsLong("inbox_last_time").longValue() : 0L)) {
                        C4904y.m18639b("##### handleMessage: QUERY_SMS_LASTMESSAGE actual the last message is SMS/MMS for mInboxNO : " + this.f6123a.f5750v, ChatFragment.f5461a);
                        this.f6123a.f5546ao.startUpdate(4, null, C2299s.f8209a, contentValues2, "inbox_no='" + this.f6123a.f5750v + "'", null);
                    } else {
                        C4904y.m18639b("##### handleMessage: QUERY_SMS_LASTMESSAGE actual the last message is ChatON for mInboxNO : " + this.f6123a.f5750v, ChatFragment.f5461a);
                        this.f6123a.f5546ao.startUpdate(4, null, C2299s.f8209a, contentValues, "inbox_no='" + this.f6123a.f5750v + "'", null);
                    }
                }
                if (cursor == null || cursor.isClosed()) {
                    return;
                } else {
                    return;
                }
            case 100:
                this.f6123a.f5534aa.removeMessages(100);
                if (this.f6123a.f5624cN != null) {
                    this.f6123a.m7988aQ();
                    return;
                } else {
                    C4904y.m18641c("[handleMessage] attach activity is null. return", ChatFragment.f5461a);
                    return;
                }
            case 9527:
            case 9528:
                C3945c c3945c2 = (C3945c) message.obj;
                long jLongValue = ((Long) c3945c2.f14222g).longValue();
                Cursor cursor2 = (Cursor) c3945c2.f14223h;
                if (this.f6123a.f5624cN == null) {
                    C4904y.m18634a("handleMessage MESSAGE_LIST_QUERY_TOKEN - Activity is null", getClass().getSimpleName());
                    if (cursor2 != null) {
                        cursor2.close();
                        return;
                    }
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("##### onQueryComplete: msg history result for threadId " + jLongValue, ChatFragment.f5461a);
                }
                if (jLongValue != this.f6123a.f5731ej.m14359d()) {
                    C4904y.m18639b("onQueryComplete: msg history query result is for threadId " + jLongValue + ", but mConversation has threadId " + this.f6123a.f5731ej.m14359d() + " starting a new query", ChatFragment.f5461a);
                    this.f6123a.m7998aV();
                    return;
                }
                if (cursor2 == null || cursor2.getCount() <= 0) {
                    this.f6123a.f5652cp = false;
                } else {
                    int count = this.f6123a.f5528aU.mo871a() != null ? this.f6123a.f5528aU.mo871a().getCount() - this.f6123a.f5528aU.mo871a().getPosition() : 0;
                    Cursor cursorM8574e = this.f6123a.f5528aU.m8574e(cursor2);
                    if (cursorM8574e != null) {
                        this.f6123a.m8121c(cursorM8574e);
                    }
                    int count2 = this.f6123a.f5528aU.getCount();
                    int i2 = count2 - this.f6123a.f5651co;
                    this.f6123a.f5651co = count2;
                    if (message.what == 9528) {
                        this.f6123a.f5527aT.setSelection(count2 - count);
                    }
                    this.f6123a.f5652cp = true;
                    this.f6123a.f5528aU.m8571c(cursor2.getCount());
                    if (this.f6123a.f5731ej != null) {
                        this.f6123a.f5731ej.m14351a(cursor2.getCount());
                    }
                }
                if (cursor2 == null || cursor2.getCount() != this.f6123a.f5653cq) {
                    this.f6123a.f5652cp = true;
                } else {
                    this.f6123a.f5652cp = false;
                }
                if (cursor2 != null) {
                    this.f6123a.f5653cq = cursor2.getCount();
                    return;
                }
                return;
            case 9700:
                if (message.arg1 == 0) {
                    if (this.f6123a.m8126d(((Integer) ((C3945c) message.obj).f14223h).intValue()) <= 0) {
                        this.f6123a.m8262g(this.f6123a.f5751w);
                    }
                    this.f6123a.m8016ae();
                    this.f6123a.m8017af();
                    return;
                }
                return;
            case 9702:
                C3945c c3945c3 = (C3945c) message.obj;
                long jLongValue2 = ((Long) c3945c3.f14222g).longValue();
                if (C4904y.f17872b) {
                    C4904y.m18639b("##### handleMessage: SMS_DRAFT_LIST_QUERY_TOKEN for threadId : " + jLongValue2 + "result : " + message.arg1, ChatFragment.f5461a);
                }
                long jM14359d = this.f6123a.f5731ej.m14359d();
                if (jLongValue2 != jM14359d) {
                    C4904y.m18639b("onQueryComplete: msg history query result is for threadId " + jLongValue2 + ", but mConversation has threadId " + jM14359d + " starting a new query", ChatFragment.f5461a);
                    this.f6123a.m8002aX();
                    return;
                } else {
                    if (message.arg1 == 0) {
                        String str = (String) c3945c3.f14223h;
                        this.f6123a.f5564bF.setText(str);
                        this.f6123a.f5564bF.setSelection(str.length());
                        this.f6123a.f5745ex = jM14359d;
                        this.f6123a.m8003aY();
                        return;
                    }
                    return;
                }
            case 9703:
            case 9704:
                C3945c c3945c4 = (C3945c) message.obj;
                long jLongValue3 = ((Long) c3945c4.f14222g).longValue();
                if (C4904y.f17872b) {
                    C4904y.m18639b("##### handleMessage: SMS_DRAFT_DELETED_TOKEN for threadId : " + jLongValue3 + " result : " + message.arg1, ChatFragment.f5461a);
                }
                long jM14359d2 = this.f6123a.f5731ej.m14359d();
                if (jLongValue3 != jM14359d2) {
                    C4904y.m18639b("handleMessage: SMS_DRAFT_DELETED_TOKEN msg history query result is for threadId " + jLongValue3 + ", but mConversation has threadId " + jM14359d2, ChatFragment.f5461a);
                    return;
                }
                long jLongValue4 = ((Long) c3945c4.f14223h).longValue();
                C4904y.m18639b("##### handleMessage: SMS_DRAFT_DELETED_TOKEN deletedCount : " + jLongValue4, ChatFragment.f5461a);
                if (jLongValue4 > 0) {
                    this.f6123a.m8017af();
                    return;
                } else {
                    if (jLongValue4 == -1) {
                        this.f6123a.m8132d(true);
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }
}
