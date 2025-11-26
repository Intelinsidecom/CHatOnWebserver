package com.sec.chaton.chat.background;

import android.app.Service;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1435c;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: GetMessageJobContainer.java */
/* renamed from: com.sec.chaton.chat.background.d */
/* loaded from: classes.dex */
public class C0970d extends C0972f {

    /* renamed from: v */
    private final String f3973v;

    /* renamed from: w */
    private long f3974w;

    public C0970d(Handler handler, Looper looper, Service service, int i, int i2) {
        super(handler, looper, service, i, i2);
        this.f3973v = "GetMessageJonContainer";
        this.f3988m = handler;
        this.f3983h = null;
        this.f3987l = C3193bh.m11148a();
        this.f3989n = false;
        this.f3991p = -1L;
        this.f3994s = service;
        this.f3995t = i;
        this.f3996u = i2;
        m5201a(new HandlerC0971e(this, looper));
    }

    @Override // com.sec.chaton.chat.background.C0972f
    /* renamed from: a */
    public int mo5194a(C0974h c0974h) {
        if (c0974h == null) {
            return 4;
        }
        this.f3986k = c0974h.m5206b();
        this.f3978c = c0974h.m5218n();
        this.f3991p = c0974h.m5212h();
        this.f3977b = c0974h.m5211g();
        this.f3980e = c0974h.m5205a();
        return (TextUtils.isEmpty(this.f3978c) || this.f3991p == -1 || TextUtils.isEmpty(this.f3977b) || TextUtils.isEmpty(this.f3980e)) ? 4 : 1;
    }

    @Override // com.sec.chaton.chat.background.C0972f
    /* renamed from: a */
    public boolean mo5195a() throws Throwable {
        if (this.f3996u == 1) {
            if (C3250y.f11735c) {
                C3250y.m11453c("Need to network", "GetMessageJonContainer");
            }
            int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
            if (-3 == iM6733a || -2 == iM6733a) {
                return mo5198a(false, 2, this.f3991p);
            }
            if (!mo5197a((EnumC1450r) null)) {
                return mo5198a(false, 9, this.f3991p);
            }
            if (this.f3981f == EnumC1450r.UNKNOWN) {
                return mo5198a(false, 5, this.f3991p);
            }
            int iMo5199b = mo5199b(this.f3981f);
            if (iMo5199b != 1) {
                return mo5198a(false, iMo5199b, this.f3991p);
            }
            return true;
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("No need to network", "GetMessageJonContainer");
        }
        mo5196a(this.f3987l);
        return mo5198a(true, 1, this.f3991p);
    }

    @Override // com.sec.chaton.chat.background.C0972f
    /* renamed from: a */
    public boolean mo5198a(boolean z, int i, long j) throws Throwable {
        if (TextUtils.isEmpty(this.f3977b)) {
            if (C3250y.f11735c) {
                C3250y.m11453c("packagename is empty", "GetMessageJonContainer");
            }
            return false;
        }
        m5192a(i);
        return true;
    }

    /* renamed from: a */
    private void m5192a(int i) throws Throwable {
        if (C3250y.f11735c) {
            C3250y.m11453c("result_code : " + String.valueOf(i), "GetMessageJonContainer");
            C3250y.m11453c("request_id : " + String.valueOf(this.f3986k), "GetMessageJonContainer");
            C3250y.m11453c("request_msg_id: " + String.valueOf(this.f3991p), "GetMessageJonContainer");
        }
        Intent intent = new Intent("com.sec.chaton.chat.background.RES_FULL_MESSAGE");
        intent.setData(new Uri.Builder().scheme(this.f3977b).build());
        intent.putExtra("request_id", this.f3986k);
        if (i == 1) {
            Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1435c.m6291a(), null, null, new String[]{this.f3978c, Long.toString(this.f3991p)}, null);
            if (cursorQuery == null || cursorQuery.getCount() == 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    i = 0;
                } else {
                    i = 0;
                }
            } else {
                intent.putExtra("inbox_no", this.f3978c);
                intent.putExtra("message_id", this.f3991p);
                cursorQuery.moveToFirst();
                int i2 = cursorQuery.getString(cursorQuery.getColumnIndex("sender_chatonv_available")).equals("true") ? 1 : 0;
                intent.putExtra("message_type", cursorQuery.getInt(cursorQuery.getColumnIndex("message_type")));
                intent.putExtra("message", cursorQuery.getString(cursorQuery.getColumnIndex("message")));
                intent.putExtra("sender_id", cursorQuery.getString(cursorQuery.getColumnIndex("sender_id")));
                intent.putExtra("sender_name", cursorQuery.getString(cursorQuery.getColumnIndex("sender_name")));
                intent.putExtra("sender_phoneNumber", cursorQuery.getString(cursorQuery.getColumnIndex("sender_phoneNumber")));
                intent.putExtra("chat_type", cursorQuery.getInt(cursorQuery.getColumnIndex("chat_type")));
                intent.putExtra("received_time", cursorQuery.getLong(cursorQuery.getColumnIndex("received_time")));
                intent.putExtra("sender_chatonv_available", i2);
                intent.putExtra("chatroom_title", cursorQuery.getString(cursorQuery.getColumnIndex("chatroom_title")));
                cursorQuery.close();
                m5193e();
            }
        }
        intent.putExtra("result_code", i);
        CommonApplication.m11493l().sendBroadcast(intent);
    }

    @Override // com.sec.chaton.chat.background.C0972f
    /* renamed from: a */
    protected boolean mo5197a(EnumC1450r enumC1450r) {
        if (this.f3978c.isEmpty()) {
            return false;
        }
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1449q.f5381a, null, "inbox_no=?", new String[]{this.f3978c}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            this.f3984i = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
            this.f3985j = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
            this.f3981f = EnumC1450r.m6339a(cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type")));
            this.f3979d = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
            this.f3974w = cursorQuery.getLong(cursorQuery.getColumnIndex("lasst_session_merge_time"));
            cursorQuery.close();
            if (this.f3981f == EnumC1450r.BROADCAST || this.f3979d == null || "null".equals(this.f3979d)) {
                this.f3979d = "";
                this.f3981f = EnumC1450r.BROADCAST;
            }
            this.f3983h = C1337o.m5795a(this.f3978c, this.f3981f);
            if (this.f3983h == null) {
                return false;
            }
            this.f3983h.m5874a(this.f3976a);
            this.f3983h.m5893c(Long.MAX_VALUE);
            if (TextUtils.isEmpty(this.f3984i)) {
                this.f3983h.m5880a(this.f3978c, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
            } else {
                this.f3983h.m5880a(this.f3978c, this.f3984i, this.f3985j);
            }
            if (this.f3981f == EnumC1450r.BROADCAST || this.f3979d == null || "null".equals(this.f3979d)) {
                this.f3983h.m5897e(this.f3978c);
            } else {
                this.f3983h.m5867a(this.f3974w);
            }
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    @Override // com.sec.chaton.chat.background.C0972f
    /* renamed from: b */
    protected int mo5199b(EnumC1450r enumC1450r) throws Throwable {
        if (!this.f3983h.m5875a(this.f3981f, this.f3980e, Long.valueOf(this.f3991p), this.f3979d, this.f3978c, this.f3974w)) {
            mo5198a(true, 1, this.f3991p);
            mo5196a(this.f3987l);
            this.f3983h.m5871a(this.f3981f, this.f3979d);
        }
        return 1;
    }

    @Override // com.sec.chaton.chat.background.C0972f
    /* renamed from: a */
    protected boolean mo5196a(long j) {
        if (this.f3988m == null) {
            return false;
        }
        Message messageObtainMessage = this.f3988m.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = new Long(j);
        return this.f3988m.sendMessage(messageObtainMessage);
    }

    /* renamed from: e */
    private void m5193e() throws Throwable {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        CommonApplication.m11493l().getContentResolver().update(C1449q.f5381a, contentValues, "inbox_no='" + this.f3978c + "'", null);
        C1103a.m5432a(CommonApplication.m11493l()).m5454a(this.f3978c, C1103a.f4447i);
    }
}
