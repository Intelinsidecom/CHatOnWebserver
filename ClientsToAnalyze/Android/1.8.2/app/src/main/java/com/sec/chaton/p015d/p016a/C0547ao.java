package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0165cd;
import com.sec.chaton.p007a.C0168cg;
import com.sec.chaton.p007a.C0169ch;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0701p;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0662f;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;

/* compiled from: GetBuddyNicknameTask.java */
/* renamed from: com.sec.chaton.d.a.ao */
/* loaded from: classes.dex */
public class C0547ao extends AbstractC0559b {

    /* renamed from: h */
    private ArrayList f2221h;

    /* renamed from: i */
    private String f2222i;

    /* renamed from: j */
    private ContentResolver f2223j;

    public C0547ao(Handler handler, ArrayList arrayList, String str) {
        super(handler);
        this.f2221h = arrayList;
        this.f2222i = str;
        this.f2223j = GlobalApplication.m3260b().getContentResolver();
        this.f2240f = -1L;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        if (this.f2240f == -1) {
            this.f2240f = C1735ar.m5918a();
        }
        C0169ch c0169chM1448a = C0168cg.newBuilder().m1448a(this.f2240f);
        if (this.f2221h == null) {
            this.f2221h = C0670n.m3081a(this.f2223j, this.f2222i, C0670n.m3086b(this.f2223j, this.f2222i));
        }
        if (this.f2221h.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f2221h.size()) {
                    c0169chM1448a.m1451a(((String) this.f2221h.get(i2)).toString());
                    i = i2 + 1;
                } else {
                    C1786r.m6063c("ch@t[" + c0169chM1448a.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", MsgID : " + c0169chM1448a.m1456f() + ", Users : " + C1786r.m6049a(c0169chM1448a.m1457g()), getClass().getSimpleName());
                    return new C0771ac().m3296a(c0169chM1448a.build()).m3294a(18).m3299b();
                }
            }
        } else {
            C1786r.m6061b("unknown participant count 0.", getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        Message message = new Message();
        message.what = 18;
        if (obj2 != null) {
            C0165cd c0165cd = (C0165cd) ((C0770ab) obj2).m3290c();
            for (int i2 = 0; i2 < c0165cd.m1403e().size(); i2++) {
                sb.append("[" + i2 + "] User : " + c0165cd.m1399a(i2).m1373d()).append(", Nickname : " + c0165cd.m1399a(i2).m1375f());
            }
            C1786r.m6063c("ch@t[" + c0165cd.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", ResultCode : " + c0165cd.m1405g().m1467d() + ", ResultMessage : " + c0165cd.m1405g().m1469f() + ", MsgID : " + c0165cd.m1402d() + ", NicknameList : " + sb.toString(), getClass().getSimpleName());
            int iM1467d = c0165cd.m1405g().m1467d();
            if (iM1467d == 1000 || iM1467d == 1001) {
                C0639k c0639kM2914b = C0639k.m2914b(this.f2222i);
                if (c0639kM2914b != null && c0639kM2914b.m2956h()) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < c0165cd.m1403e().size()) {
                            String strM1375f = c0165cd.m1399a(i4).m1375f();
                            String strM1373d = c0165cd.m1399a(i4).m1373d();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("participants_buddy_name", strM1375f);
                            this.f2223j.update(C0701p.f2644a, contentValues, "participants_buddy_no=?", new String[]{strM1373d});
                            Cursor cursorQuery = this.f2223j.query(C0694i.f2616a, null, "inbox_last_msg_sender=?", new String[]{strM1373d}, null);
                            if (cursorQuery != null) {
                                while (cursorQuery.moveToNext()) {
                                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                                    C0662f c0662fM3030d = C0660d.m3030d(this.f2223j, string);
                                    if (c0662fM3030d != null) {
                                        String[] strArrSplit = c0662fM3030d.f2537d.split(";");
                                        if (strArrSplit.length == 4) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(strArrSplit[0]).append(";").append(strArrSplit[1]).append(";").append(strArrSplit[2]).append(";").append(C0493bg.m2684a(strM1375f));
                                            c0662fM3030d.f2537d = sb2.toString();
                                        }
                                        C1786r.m6063c("InBoxDatabaseHelper.updateInBox", getClass().getSimpleName());
                                        C0660d.m3005a(this.f2223j, string, c0662fM3030d);
                                    }
                                }
                                cursorQuery.close();
                            }
                            i3 = i4 + 1;
                        } else {
                            C1786r.m6063c("temp connection - clearMessageControl() call!", getClass().getSimpleName());
                            c0639kM2914b.m2953e();
                            return;
                        }
                    }
                } else {
                    C0662f c0662fM3030d2 = C0660d.m3030d(this.f2223j, this.f2222i);
                    if (c0662fM3030d2 != null) {
                        String strM1375f2 = null;
                        boolean z = false;
                        for (int i5 = 0; i5 < c0165cd.m1403e().size(); i5++) {
                            if (C0670n.m3085b(this.f2223j, c0165cd.m1399a(i5).m1373d(), this.f2222i, c0165cd.m1399a(i5).m1375f())) {
                                z = true;
                                if (c0165cd.m1399a(i5).m1373d().equals(c0662fM3030d2.f2543j)) {
                                    strM1375f2 = c0165cd.m1399a(i5).m1375f();
                                }
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("participants_buddy_name", c0165cd.m1399a(i5).m1375f());
                                this.f2223j.update(C0701p.f2644a, contentValues2, "participants_buddy_no=?", new String[]{c0165cd.m1399a(i5).m1373d()});
                            }
                        }
                        if (z) {
                            if (strM1375f2 != null) {
                                String[] strArrSplit2 = c0662fM3030d2.f2537d.split(";");
                                if (strArrSplit2.length == 4) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(strArrSplit2[0]).append(";").append(strArrSplit2[1]).append(";").append(strArrSplit2[2]).append(";").append(C0493bg.m2684a(strM1375f2));
                                    c0662fM3030d2.f2537d = sb3.toString();
                                }
                            }
                            C1786r.m6063c("InBoxDatabaseHelper.updateInBox", getClass().getSimpleName());
                            C0660d.m3005a(this.f2223j, this.f2222i, c0662fM3030d2);
                        }
                        message.obj = new C0103d(true, c0165cd.m1405g().m1467d());
                    }
                }
            } else {
                C1786r.m6064d("reply.getResult().getResultCode():" + c0165cd.m1405g().m1467d());
                message.obj = new C0103d(false, c0165cd.m1405g().m1467d());
            }
            this.f2236b.sendMessage(message);
            return;
        }
        C1786r.m6063c("Fail to get Nickname", getClass().getSimpleName());
        message.obj = new C0103d(false, i);
        if (this.f2239e >= f2235a || i == 11 || i == 22 || i == 3) {
            if (i == 24 || i == 23 || i == 21) {
                C0660d.m3031e(this.f2223j, this.f2222i);
            }
            C0639k c0639kM2914b2 = C0639k.m2914b(this.f2222i);
            if (c0639kM2914b2 != null && c0639kM2914b2.m2956h()) {
                c0639kM2914b2.m2953e();
                return;
            }
        }
        this.f2236b.sendMessage(message);
    }
}
