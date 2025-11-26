package com.sec.chaton.chat.background;

import android.app.Service;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p027e.p028a.C1375s;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3189bd;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/* compiled from: JobContainer.java */
/* renamed from: com.sec.chaton.chat.background.f */
/* loaded from: classes.dex */
public class C0972f {

    /* renamed from: a */
    protected Handler f3976a;

    /* renamed from: b */
    protected String f3977b;

    /* renamed from: c */
    protected String f3978c;

    /* renamed from: d */
    protected String f3979d;

    /* renamed from: e */
    protected String f3980e;

    /* renamed from: f */
    protected EnumC1450r f3981f;

    /* renamed from: i */
    protected String f3984i;

    /* renamed from: j */
    protected int f3985j;

    /* renamed from: k */
    protected long f3986k;

    /* renamed from: m */
    protected Handler f3988m;

    /* renamed from: q */
    protected EnumC1455w f3992q;

    /* renamed from: r */
    protected String f3993r;

    /* renamed from: s */
    protected Service f3994s;

    /* renamed from: t */
    protected int f3995t;

    /* renamed from: u */
    protected int f3996u;

    /* renamed from: h */
    protected C1337o f3983h = null;

    /* renamed from: g */
    protected ArrayList<String> f3982g = new ArrayList<>();

    /* renamed from: l */
    protected long f3987l = C3193bh.m11148a();

    /* renamed from: n */
    protected boolean f3989n = false;

    /* renamed from: o */
    protected long f3990o = -1;

    /* renamed from: p */
    protected long f3991p = -1;

    public C0972f(Handler handler, Looper looper, Service service, int i, int i2) {
        this.f3988m = handler;
        this.f3994s = service;
        this.f3995t = i;
        this.f3996u = i2;
        m5201a(new HandlerC0973g(this, looper));
    }

    /* renamed from: b */
    public void m5202b() {
        if (this.f3982g != null) {
            this.f3982g.clear();
            this.f3982g = null;
        }
        if (this.f3983h != null) {
            this.f3983h.m5888b(this.f3976a);
        }
        if (m5204d()) {
            if (C3250y.f11735c) {
                C3250y.m11453c("stopSelfResult( ) is true", "JobContainer");
            }
        } else if (C3250y.f11735c) {
            C3250y.m11453c("stopSelfResult( ) is false", "JobContainer");
        }
    }

    /* renamed from: a */
    protected boolean mo5197a(EnumC1450r enumC1450r) throws Resources.NotFoundException {
        boolean z;
        if (enumC1450r == EnumC1450r.ONETOONE) {
            Cursor cursorQuery = GlobalApplication.m6447a().getContentResolver().query(C1449q.m6337g(), null, "buddy_no=?", new String[]{this.f3982g.get(0), null, String.valueOf(enumC1450r.m6342a())}, null);
            if (cursorQuery == null || cursorQuery.getCount() == 0) {
                this.f3978c = C3189bd.m11137a();
            } else {
                cursorQuery.moveToFirst();
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
                this.f3978c = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                if (i != 12) {
                    this.f3979d = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
                    this.f3984i = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
                    this.f3985j = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } else {
            Cursor cursorQuery2 = GlobalApplication.m6447a().getContentResolver().query(C1449q.f5381a, null, "inbox_chat_type=? AND inbox_participants=?", new String[]{String.valueOf(enumC1450r.m6342a()), String.valueOf(this.f3982g.size())}, "inbox_last_time DESC");
            if (cursorQuery2 == null || cursorQuery2.getCount() == 0) {
                this.f3978c = C3189bd.m11137a();
                try {
                    HashMap map = new HashMap();
                    C1360d.m6033a(GlobalApplication.m6447a().getContentResolver(), (String[]) this.f3982g.toArray(new String[this.f3982g.size()]), map);
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> it = this.f3982g.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!next.equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
                            if (C3250y.f11734b) {
                                C3250y.m11450b("Insert Participants : " + next, getClass().getSimpleName());
                            }
                            arrayList.add(C1381y.m6207a(this.f3978c, next, (String) map.get(next)));
                            i2++;
                        }
                    }
                    C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("inbox_no", this.f3978c);
                    contentValues.put("inbox_chat_type", Integer.valueOf(enumC1450r.m6342a()));
                    contentValues.put("inbox_last_chat_type", (Integer) 12);
                    contentValues.put("inbox_participants", Integer.valueOf(i2));
                    GlobalApplication.m6447a().getContentResolver().insert(C1449q.f5381a, contentValues);
                } catch (OperationApplicationException e) {
                    C3250y.m11443a(e, "JobContainer");
                } catch (RemoteException e2) {
                    C3250y.m11443a(e2, "JobContainer");
                }
            } else {
                Cursor cursorQuery3 = null;
                while (true) {
                    if (!cursorQuery2.moveToNext()) {
                        break;
                    }
                    String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("inbox_no"));
                    cursorQuery3 = GlobalApplication.m6447a().getContentResolver().query(C1457y.f5415a, new String[]{"participants_buddy_no"}, "participants_inbox_no = ?", new String[]{string}, null);
                    while (cursorQuery3 != null && cursorQuery3.moveToNext()) {
                        if (!this.f3982g.contains(cursorQuery3.getString(0))) {
                            z = false;
                            break;
                        }
                    }
                    z = true;
                    if (z) {
                        this.f3978c = string;
                        if (cursorQuery2.getInt(cursorQuery2.getColumnIndex("inbox_last_chat_type")) != 12) {
                            this.f3979d = cursorQuery2.getString(cursorQuery2.getColumnIndex("inbox_session_id"));
                            this.f3984i = cursorQuery2.getString(cursorQuery2.getColumnIndex("inbox_server_ip"));
                            this.f3985j = cursorQuery2.getInt(cursorQuery2.getColumnIndex("inbox_server_port"));
                        }
                    }
                }
                if (cursorQuery3 != null) {
                    cursorQuery3.close();
                }
            }
            if (cursorQuery2 != null) {
                cursorQuery2.close();
            }
            if (TextUtils.isEmpty(this.f3978c)) {
                this.f3978c = C3189bd.m11137a();
            }
        }
        this.f3983h = C1337o.m5795a(this.f3978c, enumC1450r);
        if (this.f3983h == null) {
            return false;
        }
        this.f3983h.m5874a(this.f3976a);
        if (TextUtils.isEmpty(this.f3984i)) {
            this.f3983h.m5880a(this.f3978c, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
        } else {
            this.f3983h.m5880a(this.f3978c, this.f3984i, this.f3985j);
        }
        if (TextUtils.isEmpty(this.f3979d)) {
            this.f3989n = true;
        }
        return true;
    }

    /* renamed from: a */
    public void m5201a(Handler handler) {
        this.f3976a = handler;
    }

    /* renamed from: c */
    public long m5203c() {
        return this.f3987l;
    }

    /* renamed from: d */
    public boolean m5204d() {
        if (this.f3994s == null) {
            return false;
        }
        return this.f3994s.stopSelfResult(this.f3995t);
    }

    /* renamed from: a */
    public int mo5194a(C0974h c0974h) {
        if (c0974h == null) {
            return 4;
        }
        this.f3980e = c0974h.m5205a();
        this.f3977b = c0974h.m5211g();
        this.f3986k = c0974h.m5206b();
        this.f3991p = c0974h.m5212h();
        this.f3981f = EnumC1450r.m6339a(c0974h.m5208d());
        this.f3992q = EnumC1455w.m6358a(c0974h.m5209e());
        this.f3978c = c0974h.m5218n();
        if (EnumC1450r.UNKNOWN == this.f3981f) {
            return 5;
        }
        if (this.f3992q == EnumC1455w.SYSTEM) {
            return 6;
        }
        for (String str : c0974h.m5207c()) {
            this.f3982g.add(str);
        }
        this.f3993r = c0974h.m5210f();
        return 1;
    }

    /* renamed from: b */
    protected int mo5199b(EnumC1450r enumC1450r) {
        C1375s c1375s;
        String string;
        String strSubstring;
        String upperCase;
        if (this.f3991p == -1) {
            c1375s = null;
        } else {
            C1375s c1375sM6189b = C1373q.m6189b(GlobalApplication.m6447a().getContentResolver(), String.valueOf(this.f3991p), C3159aa.m10962a().m10979a("chaton_id", ""));
            if (c1375sM6189b == null) {
                return 10;
            }
            c1375s = c1375sM6189b;
        }
        if (EnumC1455w.TEXT == this.f3992q || EnumC1455w.LIVERECOMMEND == this.f3992q || EnumC1455w.LIVESHARE == this.f3992q || EnumC1455w.LIVECONTENTS == this.f3992q || EnumC1455w.APPLINK == this.f3992q) {
            if (this.f3991p != -1) {
                this.f3990o = this.f3983h.m5837a(this.f3991p, this.f3978c, this.f3992q, enumC1450r, this.f3979d, (String[]) this.f3982g.toArray(new String[this.f3982g.size()]), this.f3993r, this.f3989n, EnumC1751k.YES);
            } else if (this.f3989n) {
                this.f3990o = this.f3983h.m5864a(this.f3978c, this.f3992q, enumC1450r, (String[]) this.f3982g.toArray(new String[this.f3982g.size()]), this.f3993r, (String) null, EnumC1751k.YES);
            } else {
                this.f3990o = this.f3983h.m5855a(this.f3992q, enumC1450r, this.f3979d, (String[]) this.f3982g.toArray(new String[this.f3982g.size()]), this.f3993r, (String) null, EnumC1751k.YES);
            }
        } else if (EnumC1455w.GEO != this.f3992q) {
            String str = this.f3993r;
            if (TextUtils.isEmpty(str)) {
                return 11;
            }
            if (str.contains("file://")) {
                strSubstring = str.substring(7);
            } else if (str.contains("content://")) {
                Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(Uri.parse(str), null, null, null, null);
                if (cursorQuery != null) {
                    string = str;
                    while (cursorQuery.moveToNext()) {
                        int columnIndex = cursorQuery.getColumnIndex("_data");
                        if (columnIndex != -1) {
                            string = cursorQuery.getString(columnIndex);
                        }
                    }
                    cursorQuery.close();
                } else {
                    string = str;
                }
                strSubstring = string;
            } else {
                return 11;
            }
            File file = new File(strSubstring);
            String strNextToken = "";
            if (EnumC1455w.IMAGE == this.f3992q || EnumC1455w.VIDEO == this.f3992q) {
                upperCase = strSubstring.substring(strSubstring.lastIndexOf(".") + 1);
            } else if (EnumC1455w.AUDIO == this.f3992q) {
                StringTokenizer stringTokenizer = new StringTokenizer(strSubstring, ".");
                while (stringTokenizer.hasMoreTokens()) {
                    strNextToken = stringTokenizer.nextToken();
                }
                upperCase = strNextToken.toUpperCase();
            } else {
                return 12;
            }
            if (this.f3991p != -1) {
                if (1 == c1375s.f5161q) {
                    this.f3990o = this.f3983h.m5819a(this.f3991p, this.f3981f, c1375s.f5152h, this.f3979d, (String[]) this.f3982g.toArray(new String[this.f3982g.size()]), this.f3989n, c1375s.f5156l, upperCase, this.f3992q, EnumC1751k.YES);
                } else {
                    this.f3990o = this.f3983h.m5830a(this.f3991p, file, (String) null, this.f3992q, enumC1450r, this.f3979d, (String[]) this.f3982g.toArray(new String[this.f3982g.size()]), this.f3989n, strSubstring, EnumC1751k.YES);
                }
            } else {
                this.f3990o = this.f3983h.m5858a(file, (String) null, this.f3992q, enumC1450r, this.f3979d, (String[]) this.f3982g.toArray(new String[this.f3982g.size()]), this.f3989n, strSubstring, EnumC1751k.YES);
            }
        } else if (this.f3991p != -1) {
            this.f3990o = this.f3983h.m5828a(this.f3991p, this.f3981f, this.f3979d, (String[]) this.f3982g.toArray(new String[this.f3982g.size()]), this.f3989n, this.f3993r, EnumC1751k.YES);
        } else {
            this.f3990o = this.f3983h.m5850a(this.f3981f, this.f3979d, (String[]) this.f3982g.toArray(new String[this.f3982g.size()]), this.f3989n, this.f3993r, EnumC1751k.YES);
        }
        C3250y.m11450b("TaskID : " + String.valueOf(this.f3990o), "JobContainer");
        return 1;
    }

    /* renamed from: e */
    private boolean m5200e() {
        if (this.f3982g == null || this.f3982g.size() == 0) {
            return false;
        }
        Iterator<String> it = this.f3982g.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo5195a() {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            return mo5198a(false, 2, this.f3991p);
        }
        if (!m5200e()) {
            return mo5198a(false, 13, this.f3991p);
        }
        if (!mo5197a(this.f3981f)) {
            return mo5198a(false, 9, this.f3991p);
        }
        int iMo5199b = mo5199b(this.f3981f);
        if (iMo5199b != 1) {
            return mo5198a(false, iMo5199b, this.f3991p);
        }
        return true;
    }

    /* renamed from: a */
    protected boolean mo5198a(boolean z, int i, long j) {
        if (TextUtils.isEmpty(this.f3977b)) {
            if (C3250y.f11735c) {
                C3250y.m11453c("packagename is empty", "JobContainer");
            }
            return false;
        }
        Intent intent = new Intent("com.sec.chaton.chat.background.MESSAGE_SEND_RESULT");
        intent.setData(new Uri.Builder().scheme(this.f3977b).build());
        intent.putExtra("result", z);
        intent.putExtra("result_code", i);
        intent.putExtra("request_id", this.f3986k);
        intent.putExtra("message_id", j);
        CommonApplication.m11493l().sendBroadcast(intent);
        if (C3250y.f11735c) {
            C3250y.m11453c("result : " + String.valueOf(z), "JobContainer");
            C3250y.m11453c("result_code : " + String.valueOf(i), "JobContainer");
            C3250y.m11453c("request_id : " + String.valueOf(this.f3986k), "JobContainer");
            C3250y.m11453c("message_id : " + String.valueOf(j), "JobContainer");
            C3250y.m11453c("packagename : " + this.f3977b, "JobContainer");
        }
        return true;
    }

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
}
