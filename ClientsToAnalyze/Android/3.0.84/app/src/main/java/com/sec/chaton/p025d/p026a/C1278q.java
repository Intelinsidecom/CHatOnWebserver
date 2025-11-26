package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.C0277aa;
import com.sec.chaton.p016a.C0278ab;
import com.sec.chaton.p016a.C0280ad;
import com.sec.chaton.p016a.C0409x;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p020c.C0822g;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p027e.p029b.C1421l;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AsyncEndChatTask.java */
/* renamed from: com.sec.chaton.d.a.q */
/* loaded from: classes.dex */
public class C1278q extends AbstractC1253e {

    /* renamed from: h */
    private ArrayList<C0280ad> f4886h;

    /* renamed from: i */
    private ArrayList<String> f4887i;

    /* renamed from: j */
    private String f4888j;

    /* renamed from: k */
    private String f4889k;

    /* renamed from: l */
    private ContentResolver f4890l;

    public C1278q(Handler handler, ArrayList<String> arrayList, ArrayList<C0280ad> arrayList2) {
        super(handler);
        this.f4886h = (ArrayList) arrayList2.clone();
        this.f4887i = (ArrayList) arrayList.clone();
        this.f4889k = C3159aa.m10962a().m10979a("uid", "");
        this.f4888j = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f4890l = CommonApplication.m11493l().getContentResolver();
        this.f4702f = -1L;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        super.mo5504b();
        C0278ab c0278abNewBuilder = C0277aa.newBuilder();
        if (this.f4702f == -1) {
            this.f4702f = C3193bh.m11148a();
        }
        c0278abNewBuilder.m1403a(this.f4702f);
        c0278abNewBuilder.m1408a(this.f4889k);
        c0278abNewBuilder.m1410b(this.f4888j);
        c0278abNewBuilder.m1407a(this.f4886h);
        C3250y.m11453c("ch@t[AsyncEndChatReqeust] UID : " + this.f4889k + ", MsgID : " + this.f4702f + ", Sender : " + this.f4888j, "AsyncEndChatTask");
        return new C1549ah().m6581a(c0278abNewBuilder.build()).m6579a(25).m6580a(C0822g.m4374c()).m6584b();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws RemoteException, OperationApplicationException {
        super.mo5502a(i, obj, obj2);
        Message message = new Message();
        message.what = 25;
        if (obj2 != null) {
            C1548ag c1548ag = (C1548ag) obj2;
            switch (c1548ag.m6574b()) {
                case 26:
                    C0409x c0409x = (C0409x) c1548ag.m6575c();
                    C3250y.m11453c("ch@t[AsyncEndChatReply]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", ResultCode : " + c0409x.m3001f().m2494d() + ", ResultMessage : " + c0409x.m3001f().m2496f() + ", MsgID : " + c0409x.m2999d(), getClass().getSimpleName());
                    int iM2494d = c0409x.m3001f().m2494d();
                    if (iM2494d == 1000) {
                        m5583c();
                        C1379w.m6203a(new C1379w(), -1, new C1421l(null, C1103a.f4442d, false));
                        message.obj = new C0272i(true, iM2494d);
                        break;
                    } else {
                        message.obj = new C0272i(false, iM2494d);
                        break;
                    }
            }
            this.f4698b.sendMessage(message);
        } else {
            if ((!mo5503a() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
                C1370n.m6141e(this.f4890l, this.f4887i.get(0));
            }
            C3250y.m11453c("Fail to send endChat message", getClass().getSimpleName());
            message.obj = new C0272i(false, i);
            this.f4698b.sendMessage(message);
        }
        this.f4887i.clear();
        this.f4886h.clear();
    }

    /* renamed from: c */
    private void m5583c() throws RemoteException, OperationApplicationException {
        String string;
        String string2;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        Iterator<String> it = this.f4887i.iterator();
        while (it.hasNext()) {
            String next = it.next();
            m5582a(next);
            String strM11328b = C3223ck.m11328b();
            C3243r.m11419a(strM11328b + "/" + next);
            Cursor cursorQuery = this.f4890l.query(C1449q.f5381a, new String[]{"inbox_old_no", "inbox_session_id"}, "inbox_no=?", new String[]{next}, null);
            if (cursorQuery == null) {
                string = "";
                string2 = null;
            } else {
                if (!cursorQuery.moveToFirst()) {
                    string = "";
                    string2 = null;
                } else {
                    string2 = cursorQuery.getString(0);
                    string = cursorQuery.getString(1);
                }
                cursorQuery.close();
            }
            if (!TextUtils.isEmpty(string2)) {
                String[] strArrSplit = string2.split(",");
                if (strArrSplit.length > 0) {
                    for (String str : strArrSplit) {
                        m5582a(str);
                        C3243r.m11419a(strM11328b + "/" + str);
                    }
                }
            }
            arrayList.add(ContentProviderOperation.newDelete(C1449q.f5381a).withSelection("inbox_no=?", new String[]{next}).build());
            arrayList.add(ContentProviderOperation.newDelete(C1454v.f5393a).withSelection("message_inbox_no=?", new String[]{next}).build());
            arrayList.add(ContentProviderOperation.newDelete(C1457y.f5415a).withSelection("participants_inbox_no=?", new String[]{next}).build());
            C1337o c1337oM5813d = C1337o.m5813d(next);
            if (c1337oM5813d != null) {
                c1337oM5813d.m5901j();
                c1337oM5813d.m5900i();
            }
            try {
                if (!TextUtils.isEmpty(string)) {
                    C3044a.m10564a(CommonApplication.m11493l(), C3044a.m10560a(string));
                } else {
                    C1555a.m6596a().m6600a(next);
                    C1561g.m6628a().m6635a(next);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Iterator<String> it2 = C1381y.m6221e(GlobalApplication.m11493l().getContentResolver(), next).iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                C3205bt.m11182a(GlobalApplication.m11493l()).m11227b(next2);
                C3205bt.m11182a(GlobalApplication.m11493l()).m11216a(next2, EnumC1450r.GROUPCHAT);
            }
        }
        try {
            if (arrayList.size() > 0) {
                this.f4890l.applyBatch("com.sec.chaton.provider", arrayList);
            }
        } catch (OperationApplicationException e2) {
            C3250y.m11442a(e2.toString(), getClass().getSimpleName());
        } catch (RemoteException e3) {
            C3250y.m11442a(e3.toString(), getClass().getSimpleName());
        }
        arrayList.clear();
    }

    /* renamed from: a */
    private void m5582a(String str) {
        File[] fileArrListFiles = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().listFiles(new C1279r(this, str));
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                C3250y.m11450b("[Delete File] " + file + " : " + file.delete(), "AsyncEndChatTask");
            }
        }
    }
}
