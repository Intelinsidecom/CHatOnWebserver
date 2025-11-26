package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.chat.C1072en;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1089fd;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p016a.C0336cf;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p025d.C1304aq;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1589q;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: InitChatRoomTask.java */
/* renamed from: com.sec.chaton.d.a.cu */
/* loaded from: classes.dex */
public class C1220cu extends C1280s {

    /* renamed from: h */
    private EnumC1455w f4727h;

    /* renamed from: i */
    private EnumC1450r f4728i;

    /* renamed from: j */
    private String[] f4729j;

    /* renamed from: k */
    private String f4730k;

    /* renamed from: l */
    private ContentResolver f4731l;

    /* renamed from: n */
    private String f4732n;

    public C1220cu(Handler handler, String str, long j, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String[] strArr, String str2, EnumC1751k enumC1751k) {
        super(handler, 1, enumC1751k);
        this.f4702f = j;
        this.f4732n = str;
        this.f4727h = enumC1455w;
        this.f4728i = enumC1450r;
        this.f4729j = strArr;
        this.f4730k = str2;
        this.f4731l = CommonApplication.m11493l().getContentResolver();
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        super.mo5504b();
        if (C1493a.m6463a("broadcast2_feature") && this.f4728i == EnumC1450r.BROADCAST) {
            this.f4728i = EnumC1450r.BROADCAST2;
        }
        C1759s.m7260a(getClass().getSimpleName(), "onPreExecute()", new Object[0]);
        return C1304aq.m5604a().m5608a(this.f4732n, this.f4702f, this.f4727h, this.f4728i, this.f4729j, this.f4730k);
    }

    @Override // com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws Resources.NotFoundException, RemoteException, OperationApplicationException {
        super.mo5502a(i, obj, obj2);
        C1759s.m7260a(getClass().getSimpleName(), "onPostExecute()", new Object[0]);
        Message message = new Message();
        message.what = 0;
        if (obj2 != null) {
            C0336cf c0336cf = (C0336cf) ((C1548ag) obj2).m6575c();
            C1072en.m5302a(this.f4732n, c0336cf, getClass().getSimpleName());
            int iM2494d = c0336cf.m2096l().m2494d();
            String strM2496f = c0336cf.m2096l().m2496f();
            if (iM2494d == 1000 || iM2494d == 1001 || iM2494d == 3002) {
                HashMap map = new HashMap();
                C3250y.m11453c("buddyname retrieve end", getClass().getSimpleName());
                C1360d.m6033a(this.f4731l, this.f4729j, map);
                C3250y.m11453c("participant insert start", getClass().getSimpleName());
                int length = this.f4729j.length;
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                arrayList.add(C1381y.m6204a(this.f4732n));
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(C1381y.m6207a(this.f4732n, this.f4729j[i2], (String) map.get(this.f4729j[i2])));
                }
                try {
                    if (arrayList.size() > 0) {
                        this.f4731l.applyBatch("com.sec.chaton.provider", arrayList);
                    }
                } catch (Exception e) {
                    C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
                    C3250y.m11453c("Fail to insert participant to DB", getClass().getSimpleName());
                }
                C3250y.m11453c("participant insert end", getClass().getSimpleName());
                C1335m.m5784a((Handler) null, this.f4732n, c0336cf.m2090f(), 0L);
                C1370n.m6119a(this.f4731l, this.f4732n, c0336cf, this.f4730k, this.f4728i, this.f4729j, this.f4727h);
                C1373q.m6158a(this.f4731l, Long.valueOf(c0336cf.m2092h()), c0336cf.m2090f(), c0336cf.m2088d(), Long.valueOf(this.f4702f), this.f4729j.length);
                if (iM2494d == 1001) {
                    String[] strArrSplit = strM2496f.substring(strM2496f.indexOf("[") + 1, strM2496f.indexOf("]")).trim().split(",");
                    ArrayList arrayList2 = new ArrayList();
                    for (String str : strArrSplit) {
                        String strM6220e = C1381y.m6220e(this.f4731l, this.f4732n, str);
                        C3250y.m11453c("1001 error - invalidUserName:" + strM6220e, getClass().getSimpleName());
                        arrayList2.add(strM6220e);
                        C1381y.m6219d(this.f4731l, this.f4732n, str);
                    }
                    C1370n.m6136c(this.f4731l, this.f4732n);
                    message.obj = new C1221cv(this, true, c0336cf.m2090f(), iM2494d, arrayList2, this.f4702f);
                } else {
                    message.obj = new C1221cv(this, true, c0336cf.m2090f(), iM2494d, this.f4702f);
                }
            } else {
                if (iM2494d == 7006) {
                    C1089fd.m5358a().m5362a(this.f4698b, this.f4732n, this.f4728i, c0336cf.m2096l());
                }
                message.obj = new C0272i(false, iM2494d, this.f4702f);
                C3250y.m11453c("InitChatReply : InBoxNO = " + this.f4732n + ", InitChat Fail", getClass().getSimpleName());
                if (iM2494d == 3001) {
                    C1373q.m6156a(this.f4731l, Long.valueOf(this.f4702f), Long.valueOf(C3193bh.m11148a()));
                } else {
                    C1373q.m6187b(this.f4731l, Long.valueOf(this.f4702f));
                }
                if (iM2494d == 6002) {
                    String[] strArrM6217c = C1381y.m6217c(this.f4731l, this.f4732n);
                    ArrayList arrayList3 = new ArrayList();
                    for (String str2 : strArrM6217c) {
                        arrayList3.add(C1381y.m6220e(this.f4731l, this.f4732n, str2));
                    }
                    if (EnumC1450r.m6340a(this.f4728i) && strArrM6217c.length > 0) {
                        m5549a(strArrM6217c, c0336cf.m2092h());
                    }
                    message.obj = new C1221cv(this, false, iM2494d, (ArrayList<String>) arrayList3, this.f4702f);
                } else if (iM2494d == 7006 && c0336cf.m2096l() != null && c0336cf.m2096l().m2500j() != null) {
                    message.obj = new C1221cv(this, false, iM2494d, c0336cf.m2096l().m2500j(), this.f4702f);
                }
            }
            this.f4698b.sendMessage(message);
            return;
        }
        if (!mo5503a() || i == 11 || i == 22 || i == 3) {
            if (!this.f4893m.m7198a() && C1589q.m6726a(i)) {
                C1373q.m6155a(this.f4731l, Long.valueOf(this.f4702f));
            } else {
                C1373q.m6187b(this.f4731l, Long.valueOf(this.f4702f));
            }
            if (i == 24 || i == 23 || i == 21) {
                C1370n.m6141e(this.f4731l, this.f4732n);
            }
        }
        message.obj = new C0272i(false, i, this.f4702f);
        this.f4698b.sendMessage(message);
        C1072en.m5296a(1, this.f4732n, i, this.f4702f, "", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    public boolean mo5503a() {
        if (this.f4893m.m7198a() || !C1757q.m7251b()) {
            return super.mo5503a();
        }
        return false;
    }

    /* renamed from: a */
    private void m5549a(String[] strArr, long j) {
        String strM6220e;
        StringBuilder sb = new StringBuilder();
        String str = "";
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (C1381y.m6211a(this.f4731l, str2, this.f4732n)) {
                strM6220e = C1381y.m6220e(this.f4731l, this.f4732n, str2);
                if (TextUtils.isEmpty(strM6220e)) {
                    strM6220e = str;
                }
                C3250y.m11453c("6002 error - invalidUserName:" + strM6220e, getClass().getSimpleName());
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.LEAVE.m6248a()), str2, C1075eq.m5318a(strM6220e))).append(Config.KEYVALUE_SPLIT);
                C1381y.m6219d(this.f4731l, this.f4732n, str2);
            } else {
                strM6220e = str;
            }
            i++;
            str = strM6220e;
        }
        if (sb.length() > 0) {
            C1373q.m6166a(this.f4731l, this.f4732n, sb.toString(), j, C3159aa.m10962a().m10979a("chaton_id", ""));
            C1370n.m6136c(this.f4731l, this.f4732n);
        }
    }
}
