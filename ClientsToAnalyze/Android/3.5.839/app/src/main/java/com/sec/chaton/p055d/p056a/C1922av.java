package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1753gz;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.C0845bz;
import com.sec.chaton.p046a.C0849cc;
import com.sec.chaton.p046a.C0850cd;
import com.sec.chaton.p046a.EnumC0822bc;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p051c.C1433g;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.Iterator;

/* compiled from: EndChatTask.java */
/* renamed from: com.sec.chaton.d.a.av */
/* loaded from: classes.dex */
public class C1922av extends AbstractC1981d {

    /* renamed from: h */
    private EnumC2300t f7168h;

    /* renamed from: i */
    private String f7169i;

    /* renamed from: j */
    private String f7170j;

    /* renamed from: k */
    private ContentResolver f7171k;

    public C1922av(Handler handler, EnumC2300t enumC2300t, String str, String str2) {
        super(handler);
        this.f7168h = enumC2300t;
        this.f7169i = str;
        this.f7170j = str2;
        this.f7171k = CommonApplication.m18732r().getContentResolver();
        this.f7190f = -1L;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        super.mo9093b();
        String strM9650h = C2142w.m9606c(this.f7170j).m9650h();
        if (!TextUtils.isEmpty(strM9650h)) {
            this.f7169i = strM9650h;
        }
        if (this.f7190f == -1) {
            this.f7190f = C4843bh.m18322a();
        }
        C0850cd c0850cdM3909c = C0849cc.newBuilder().m3897a(this.f7190f).m3899a(EnumC0822bc.m3576a(this.f7168h.m10210a())).m3901a(this.f7169i).m3905b(C4809aa.m18104a().m18121a("uid", "")).m3909c(C4809aa.m18104a().m18121a("chaton_id", ""));
        String[] strArrM9689c = C2176ab.m9689c(this.f7171k, this.f7170j);
        if (strArrM9689c != null && strArrM9689c.length > 0) {
            c0850cdM3909c.m3911d(strArrM9689c[0]);
        }
        long jM9651i = C2142w.m9606c(this.f7170j).m9651i();
        if (jM9651i > 0) {
            c0850cdM3909c.m3904b(jM9651i);
        }
        C4904y.m18641c("ch@t[EndChatRequest]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", ChatType : " + c0850cdM3909c.m3914g() + ", MsgID : " + c0850cdM3909c.m3913f() + ", Receivers : " + TextUtils.join(",", c0850cdM3909c.m3917j()) + ", Sender : " + c0850cdM3909c.m3916i() + ", LastSessionMergeTime : " + c0850cdM3909c.m3918k() + ", SessionID : " + c0850cdM3909c.m3915h(), getClass().getSimpleName());
        return new C2427ap().m10519a(c0850cdM3909c.build()).m10517a(8).m10518a(C1433g.m7529c()).m10522b();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        super.mo9092a(i, obj, obj2);
        Message message = new Message();
        message.what = 8;
        if (obj2 != null) {
            C2426ao c2426ao = (C2426ao) obj2;
            switch (c2426ao.m10512b()) {
                case 9:
                    C0845bz c0845bz = (C0845bz) c2426ao.m10513c();
                    C4904y.m18641c("ch@t[EndChatReply]UID : " + C4809aa.m18104a().m18121a("uid", "") + ", ResultCode : " + c0845bz.m3812f().m5229d() + ", ResultMessage : " + c0845bz.m3812f().m5231f() + ", MsgID : " + c0845bz.m3810d(), getClass().getSimpleName());
                    int iM5229d = c0845bz.m3812f().m5229d();
                    if (iM5229d == 1000 || iM5229d == 6002 || iM5229d == 1001 || iM5229d == 3006 || iM5229d == 7001 || iM5229d == 7002 || iM5229d == 7003) {
                        if (iM5229d == 7002) {
                            C1753gz.m8698a().m8701a(this.f7186b, this.f7170j, c0845bz.m3812f());
                        }
                        message.obj = new C0788l(true, iM5229d);
                        this.f7186b.sendMessage(message);
                        m9099c();
                        this.f7171k.delete(C2306z.f8229a, "message_inbox_no=?", new String[]{this.f7170j});
                        this.f7171k.delete(C2299s.f8209a, "inbox_no=?", new String[]{this.f7170j});
                        C1813b.m8906b().m8922a(this.f7170j, C1813b.f6839h);
                        Iterator<String> it = C2176ab.m9694e(GlobalApplication.m18732r().getContentResolver(), this.f7170j).iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            C4855bt.m18351a(GlobalApplication.m18732r()).m18363a(next);
                            C4855bt.m18351a(GlobalApplication.m18732r()).m18364a(next, EnumC2300t.GROUPCHAT);
                        }
                        this.f7171k.delete(C2220ah.f7942a, "participants_inbox_no=?", new String[]{this.f7170j});
                        C2142w.m9606c(this.f7170j).mo9274d();
                        C2142w.m9610d(this.f7170j);
                        try {
                            C4664a.m17659a(CommonApplication.m18732r(), C4664a.m17655a(this.f7169i));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7170j}));
                        break;
                    } else {
                        message.obj = new C0788l(false, iM5229d);
                        this.f7186b.sendMessage(message);
                        break;
                    }
                    break;
                default:
                    this.f7186b.sendMessage(message);
                    break;
            }
            return;
        }
        if ((!mo9104a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C2198l.m9953f(this.f7171k, this.f7170j);
            C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7170j}));
        }
        C4904y.m18641c("Fail to send endChat message", getClass().getSimpleName());
        message.obj = new C0788l(false, i);
        this.f7186b.sendMessage(message);
    }

    /* renamed from: c */
    private void m9099c() {
        m9098a(this.f7170j);
        String strM18501b = C4873ck.m18501b();
        C4894o.m18606a(strM18501b + "/" + this.f7170j);
        Cursor cursorQuery = this.f7171k.query(C2299s.f8209a, new String[]{"inbox_old_no"}, "inbox_no=?", new String[]{this.f7170j}, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
            cursorQuery.close();
        }
        if (!TextUtils.isEmpty(string)) {
            String[] strArrSplit = string.split(",");
            if (strArrSplit.length > 0) {
                for (String str : strArrSplit) {
                    m9098a(str);
                    C4894o.m18606a(strM18501b + "/" + str);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9098a(String str) {
        File[] fileArrListFiles = CommonApplication.m18732r().getFilesDir().getAbsoluteFile().listFiles(new C1923aw(this, str));
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                C4904y.m18639b("[Delete File] " + file + " : " + file.delete(), "EndChatTask");
            }
        }
    }
}
