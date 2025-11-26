package com.sec.chaton.p025d.p026a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.chat.C1089fd;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.C0326bw;
import com.sec.chaton.p016a.C0329bz;
import com.sec.chaton.p016a.C0331ca;
import com.sec.chaton.p016a.EnumC0302az;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p020c.C0822g;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: EndChatTask.java */
/* renamed from: com.sec.chaton.d.a.aw */
/* loaded from: classes.dex */
public class C1168aw extends AbstractC1253e {

    /* renamed from: h */
    private EnumC1450r f4629h;

    /* renamed from: i */
    private String f4630i;

    /* renamed from: j */
    private String f4631j;

    /* renamed from: k */
    private ContentResolver f4632k;

    public C1168aw(Handler handler, EnumC1450r enumC1450r, String str, String str2) {
        super(handler);
        this.f4629h = enumC1450r;
        this.f4630i = str;
        this.f4631j = str2;
        this.f4632k = CommonApplication.m11493l().getContentResolver();
        this.f4702f = -1L;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        super.mo5504b();
        String strM5895d = C1337o.m5813d(this.f4631j).m5895d();
        if (!TextUtils.isEmpty(strM5895d)) {
            this.f4630i = strM5895d;
        }
        if (this.f4702f == -1) {
            this.f4702f = C3193bh.m11148a();
        }
        C0331ca c0331caM2016c = C0329bz.newBuilder().m2007a(this.f4702f).m2009a(EnumC0302az.m1704a(this.f4629h.m6342a())).m2011a(this.f4630i).m2014b(C3159aa.m10962a().m10979a("uid", "")).m2016c(C3159aa.m10962a().m10979a("chaton_id", ""));
        String[] strArrM6217c = C1381y.m6217c(this.f4632k, this.f4631j);
        if (strArrM6217c != null && strArrM6217c.length > 0) {
            c0331caM2016c.m2018d(strArrM6217c[0]);
        }
        long jM5896e = C1337o.m5813d(this.f4631j).m5896e();
        if (jM5896e > 0) {
            c0331caM2016c.m2013b(jM5896e);
        }
        C3250y.m11453c("ch@t[EndChatRequest]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", ChatType : " + c0331caM2016c.m2021g() + ", MsgID : " + c0331caM2016c.m2020f() + ", Receivers : " + C3250y.m11437a((List<? extends Object>) c0331caM2016c.m2024j()) + ", Sender : " + c0331caM2016c.m2023i() + ", LastSessionMergeTime : " + c0331caM2016c.m2025k() + ", SessionID : " + c0331caM2016c.m2022h(), getClass().getSimpleName());
        return new C1549ah().m6581a(c0331caM2016c.build()).m6579a(8).m6580a(C0822g.m4374c()).m6584b();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws Throwable {
        super.mo5502a(i, obj, obj2);
        Message message = new Message();
        message.what = 8;
        if (obj2 != null) {
            C1548ag c1548ag = (C1548ag) obj2;
            switch (c1548ag.m6574b()) {
                case 9:
                    C0326bw c0326bw = (C0326bw) c1548ag.m6575c();
                    C3250y.m11453c("ch@t[EndChatReply]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", ResultCode : " + c0326bw.m1934f().m2494d() + ", ResultMessage : " + c0326bw.m1934f().m2496f() + ", MsgID : " + c0326bw.m1932d(), getClass().getSimpleName());
                    int iM2494d = c0326bw.m1934f().m2494d();
                    if (iM2494d == 1000 || iM2494d == 6002 || iM2494d == 1001 || iM2494d == 3006 || iM2494d == 7001 || iM2494d == 7002 || iM2494d == 7003) {
                        if (iM2494d == 7002) {
                            C1089fd.m5358a().m5361a(this.f4698b, this.f4631j, c0326bw.m1934f());
                        }
                        message.obj = new C0272i(true, iM2494d);
                        this.f4698b.sendMessage(message);
                        m5513c();
                        this.f4632k.delete(C1454v.f5393a, "message_inbox_no=?", new String[]{this.f4631j});
                        this.f4632k.delete(C1449q.f5381a, "inbox_no=?", new String[]{this.f4631j});
                        C1103a.m5432a(CommonApplication.m11493l()).m5454a(this.f4631j, C1103a.f4446h);
                        Iterator<String> it = C1381y.m6221e(GlobalApplication.m11493l().getContentResolver(), this.f4631j).iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            C3205bt.m11182a(GlobalApplication.m11493l()).m11227b(next);
                            C3205bt.m11182a(GlobalApplication.m11493l()).m11216a(next, EnumC1450r.GROUPCHAT);
                        }
                        this.f4632k.delete(C1457y.f5415a, "participants_inbox_no=?", new String[]{this.f4631j});
                        C1337o.m5813d(this.f4631j).m5901j();
                        C1337o.m5813d(this.f4631j).m5900i();
                        try {
                            C3044a.m10564a(CommonApplication.m11493l(), C3044a.m10560a(this.f4630i));
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        message.obj = new C0272i(false, iM2494d);
                        this.f4698b.sendMessage(message);
                        break;
                    }
                    break;
                default:
                    this.f4698b.sendMessage(message);
                    break;
            }
            return;
        }
        if ((!mo5503a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C1370n.m6141e(this.f4632k, this.f4631j);
        }
        C3250y.m11453c("Fail to send endChat message", getClass().getSimpleName());
        message.obj = new C0272i(false, i);
        this.f4698b.sendMessage(message);
    }

    /* renamed from: c */
    private void m5513c() {
        m5512a(this.f4631j);
        String strM11328b = C3223ck.m11328b();
        C3243r.m11419a(strM11328b + "/" + this.f4631j);
        Cursor cursorQuery = this.f4632k.query(C1449q.f5381a, new String[]{"inbox_old_no"}, "inbox_no=?", new String[]{this.f4631j}, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
            cursorQuery.close();
        }
        if (!TextUtils.isEmpty(string)) {
            String[] strArrSplit = string.split(",");
            if (strArrSplit.length > 0) {
                for (String str : strArrSplit) {
                    m5512a(str);
                    C3243r.m11419a(strM11328b + "/" + str);
                }
            }
        }
    }

    /* renamed from: a */
    private void m5512a(String str) {
        File[] fileArrListFiles = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().listFiles(new C1169ax(this, str));
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                C3250y.m11450b("[Delete File] " + file + " : " + file.delete(), "EndChatTask");
            }
        }
    }
}
