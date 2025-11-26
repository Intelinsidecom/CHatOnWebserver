package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0138bd;
import com.sec.chaton.p007a.C0141bg;
import com.sec.chaton.p007a.C0142bh;
import com.sec.chaton.p007a.C0161c;
import com.sec.chaton.p007a.C0179f;
import com.sec.chaton.p007a.C0180g;
import com.sec.chaton.p007a.EnumC0116ai;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.C0701p;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.p022h.C0810t;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: EndChatTask.java */
/* renamed from: com.sec.chaton.d.a.v */
/* loaded from: classes.dex */
public class C0606v extends AbstractC0559b {

    /* renamed from: h */
    private EnumC0695j f2381h;

    /* renamed from: i */
    private String f2382i;

    /* renamed from: j */
    private String[] f2383j;

    /* renamed from: k */
    private String f2384k;

    /* renamed from: l */
    private ContentResolver f2385l;

    public C0606v(Handler handler, EnumC0695j enumC0695j, String str, String str2, String[] strArr) {
        super(handler);
        this.f2381h = enumC0695j;
        this.f2382i = str;
        this.f2384k = str2;
        this.f2383j = strArr;
        this.f2385l = GlobalApplication.m3260b().getContentResolver();
        this.f2240f = -1L;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        if (!C0810t.m3426a(this.f2237c)) {
            C0660d.m3018a(this.f2385l, this.f2384k, this.f2237c);
            long jM5918a = C1735ar.m5918a();
            C0180g c0180gNewBuilder = C0179f.newBuilder();
            c0180gNewBuilder.m1567a(jM5918a).m1569a(EnumC0116ai.m813a(this.f2381h.m3146a())).m1577d(C1789u.m6075a().getString("uid", "")).m1579e(C1721ad.m5873a()).m1575c(C1789u.m6075a().getString("msisdn", ""));
            if (this.f2383j == null || this.f2383j.length == 0) {
                c0180gNewBuilder.m1573b(this.f2384k);
            } else {
                c0180gNewBuilder.m1573b(String.valueOf(this.f2383j[0]));
            }
            if (!TextUtils.isEmpty(this.f2382i)) {
                c0180gNewBuilder.m1571a(this.f2382i);
            }
            C1786r.m6063c("ch@t[AllowChatRequest]UID : " + C1789u.m6075a().getString("uid", "") + ", ChatType : " + c0180gNewBuilder.m1581g() + ", MsgID : " + c0180gNewBuilder.m1580f() + ", Receiver : " + c0180gNewBuilder.m1584j() + ", Sender : " + c0180gNewBuilder.m1583i() + ", SessionID : " + c0180gNewBuilder.m1582h(), getClass().getSimpleName());
            C0771ac c0771ac = new C0771ac();
            c0771ac.m3294a(2).m3296a(c0180gNewBuilder.build()).m3295a(30000L);
            return c0771ac.m3299b();
        }
        C1786r.m6061b("EndChatTask", "EndChat Start, chatType : " + this.f2381h.toString() + "InBonxNO : " + this.f2384k + ", SessionID : " + this.f2382i);
        if (this.f2240f == -1) {
            this.f2240f = C1735ar.m5918a();
        }
        C0142bh c0142bhM1086c = C0141bg.newBuilder().m1078a(this.f2240f).m1080a(EnumC0116ai.m813a(this.f2381h.m3146a())).m1082a(this.f2382i).m1084b(C1789u.m6075a().getString("uid", "")).m1086c(C1789u.m6075a().getString("msisdn", ""));
        Cursor cursorM3080a = C0670n.m3080a(this.f2385l, this.f2384k);
        C1786r.m6061b("EndChatTask", "Participants Count : " + cursorM3080a.getCount());
        while (cursorM3080a.moveToNext()) {
            String string = cursorM3080a.getString(cursorM3080a.getColumnIndex("participants_buddy_no"));
            C1786r.m6061b("EndChatTask", "Request End Chat To : " + string);
            c0142bhM1086c.m1088d(string);
        }
        cursorM3080a.close();
        C1786r.m6063c("ch@t[" + c0142bhM1086c.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", ChatType : " + c0142bhM1086c.m1091g() + ", MsgID : " + c0142bhM1086c.m1090f() + ", Receivers : " + C1786r.m6049a(c0142bhM1086c.m1094j()) + ", Sender : " + c0142bhM1086c.m1093i() + ", SessionID : " + c0142bhM1086c.m1092h(), getClass().getSimpleName());
        return new C0771ac().m3296a(c0142bhM1086c.build()).m3294a(8).m3295a(30000L).m3299b();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 8;
        if (obj2 != null) {
            C0770ab c0770ab = (C0770ab) obj2;
            switch (c0770ab.m3289b()) {
                case 3:
                    C0161c c0161c = (C0161c) c0770ab.m3290c();
                    C1786r.m6063c("ch@t[" + c0161c.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", MsgID : " + c0161c.m1358d() + ", ResultCode : " + c0161c.m1360f().m1467d() + ", ResultMsg : " + c0161c.m1360f().m1469f(), getClass().getSimpleName());
                    int iM1467d = c0161c.m1360f().m1467d();
                    if (iM1467d == 1000) {
                        message.obj = new C0103d(true, 10000, this.f2384k);
                        break;
                    } else {
                        message.obj = new C0103d(false, iM1467d, this.f2384k);
                        break;
                    }
                case 9:
                    C0138bd c0138bd = (C0138bd) c0770ab.m3290c();
                    C1786r.m6063c("ch@t[" + c0138bd.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", ResultCode : " + c0138bd.m1022f().m1467d() + ", ResultMessage : " + c0138bd.m1022f().m1469f() + ", MsgID : " + c0138bd.m1020d(), getClass().getSimpleName());
                    int iM1467d2 = c0138bd.m1022f().m1467d();
                    if (iM1467d2 == 1000 || iM1467d2 == 6002 || iM1467d2 == 1001 || iM1467d2 == 3006) {
                        this.f2385l.delete(C0698m.f2626a, "message_inbox_no=?", new String[]{this.f2384k});
                        this.f2385l.delete(C0694i.f2616a, "inbox_no=?", new String[]{this.f2384k});
                        this.f2385l.delete(C0701p.f2644a, "participants_inbox_no=?", new String[]{this.f2384k});
                        message.obj = new C0103d(true, iM1467d2);
                        break;
                    } else {
                        C1786r.m6064d("reply.getResult().getResultCode():" + iM1467d2);
                        message.obj = new C0103d(false, iM1467d2);
                        break;
                    }
            }
            this.f2236b.sendMessage(message);
            return;
        }
        if ((this.f2239e >= f2235a || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C0660d.m3031e(this.f2385l, this.f2384k);
        }
        C1786r.m6063c("Fail to send endChat message", getClass().getSimpleName());
        message.obj = new C0103d(false, i);
        this.f2236b.sendMessage(message);
    }
}
