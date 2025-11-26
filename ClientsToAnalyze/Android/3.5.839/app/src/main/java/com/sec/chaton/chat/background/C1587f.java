package com.sec.chaton.chat.background;

import android.app.Service;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p057e.p058a.C2206t;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4839bd;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/* compiled from: JobContainer.java */
/* renamed from: com.sec.chaton.chat.background.f */
/* loaded from: classes.dex */
public class C1587f {

    /* renamed from: a */
    protected Handler f6030a;

    /* renamed from: b */
    protected String f6031b;

    /* renamed from: c */
    protected String f6032c;

    /* renamed from: d */
    protected String f6033d;

    /* renamed from: e */
    protected String f6034e;

    /* renamed from: f */
    protected EnumC2300t f6035f;

    /* renamed from: i */
    protected String f6038i;

    /* renamed from: j */
    protected int f6039j;

    /* renamed from: k */
    protected long f6040k;

    /* renamed from: m */
    protected Handler f6042m;

    /* renamed from: q */
    protected EnumC2214ab f6046q;

    /* renamed from: r */
    protected String f6047r;

    /* renamed from: s */
    protected Service f6048s;

    /* renamed from: t */
    protected int f6049t;

    /* renamed from: u */
    protected int f6050u;

    /* renamed from: h */
    protected C2142w f6037h = null;

    /* renamed from: g */
    protected ArrayList<String> f6036g = new ArrayList<>();

    /* renamed from: l */
    protected long f6041l = C4843bh.m18322a();

    /* renamed from: n */
    protected boolean f6043n = false;

    /* renamed from: o */
    protected long f6044o = -1;

    /* renamed from: p */
    protected long f6045p = -1;

    public C1587f(Handler handler, Looper looper, Service service, int i, int i2) {
        this.f6042m = handler;
        this.f6048s = service;
        this.f6049t = i;
        this.f6050u = i2;
        m8452a(new HandlerC1588g(this, looper));
    }

    /* renamed from: b */
    public void m8453b() {
        if (this.f6036g != null) {
            this.f6036g.clear();
            this.f6036g = null;
        }
        if (this.f6037h != null) {
            this.f6037h.m9267b(this.f6030a);
        }
        if (m8455d()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("stopSelfResult( ) is true", "JobContainer");
            }
        } else if (C4904y.f17873c) {
            C4904y.m18641c("stopSelfResult( ) is false", "JobContainer");
        }
    }

    /* renamed from: a */
    protected boolean mo8448a(EnumC2300t enumC2300t) throws Throwable {
        boolean z;
        if (enumC2300t == EnumC2300t.ONETOONE) {
            Cursor cursorQuery = GlobalApplication.m10279a().getContentResolver().query(C2299s.m10201n(), null, "buddy_no=?", new String[]{this.f6036g.get(0), null, String.valueOf(enumC2300t.m10210a())}, null);
            if (cursorQuery == null || cursorQuery.getCount() == 0) {
                this.f6032c = C4839bd.m18311a();
            } else {
                cursorQuery.moveToFirst();
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
                this.f6032c = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                if (i != 12) {
                    this.f6033d = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
                    this.f6038i = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
                    this.f6039j = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } else {
            Cursor cursorQuery2 = GlobalApplication.m10279a().getContentResolver().query(C2299s.f8209a, null, "inbox_chat_type=? AND inbox_participants=?", new String[]{String.valueOf(enumC2300t.m10210a()), String.valueOf(this.f6036g.size())}, "inbox_last_time DESC");
            if (cursorQuery2 == null || cursorQuery2.getCount() == 0) {
                this.f6032c = C4839bd.m18311a();
                try {
                    HashMap map = new HashMap();
                    C2190d.m9816a(GlobalApplication.m10279a().getContentResolver(), (String[]) this.f6036g.toArray(new String[this.f6036g.size()]), map);
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> it = this.f6036g.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!next.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("Insert Participants : " + next, getClass().getSimpleName());
                            }
                            arrayList.add(C2176ab.m9672a(this.f6032c, next, (String) map.get(next)));
                            i2++;
                        }
                    }
                    C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("inbox_no", this.f6032c);
                    contentValues.put("inbox_chat_type", Integer.valueOf(enumC2300t.m10210a()));
                    contentValues.put("inbox_last_chat_type", (Integer) 12);
                    contentValues.put("inbox_participants", Integer.valueOf(i2));
                    GlobalApplication.m10279a().getContentResolver().insert(C2299s.f8209a, contentValues);
                } catch (OperationApplicationException e) {
                    C4904y.m18635a(e, "JobContainer");
                } catch (RemoteException e2) {
                    C4904y.m18635a(e2, "JobContainer");
                }
            } else {
                Cursor cursorQuery3 = null;
                while (true) {
                    if (!cursorQuery2.moveToNext()) {
                        break;
                    }
                    String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("inbox_no"));
                    cursorQuery3 = GlobalApplication.m10279a().getContentResolver().query(C2220ah.f7942a, new String[]{"participants_buddy_no"}, "participants_inbox_no = ?", new String[]{string}, null);
                    while (cursorQuery3 != null && cursorQuery3.moveToNext()) {
                        if (!this.f6036g.contains(cursorQuery3.getString(0))) {
                            z = false;
                            break;
                        }
                    }
                    z = true;
                    if (z) {
                        this.f6032c = string;
                        if (cursorQuery2.getInt(cursorQuery2.getColumnIndex("inbox_last_chat_type")) != 12) {
                            this.f6033d = cursorQuery2.getString(cursorQuery2.getColumnIndex("inbox_session_id"));
                            this.f6038i = cursorQuery2.getString(cursorQuery2.getColumnIndex("inbox_server_ip"));
                            this.f6039j = cursorQuery2.getInt(cursorQuery2.getColumnIndex("inbox_server_port"));
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
            if (TextUtils.isEmpty(this.f6032c)) {
                this.f6032c = C4839bd.m18311a();
            }
        }
        this.f6037h = C2142w.m9593a(this.f6032c, enumC2300t);
        if (this.f6037h == null) {
            return false;
        }
        this.f6037h.m9246a(this.f6030a);
        if (TextUtils.isEmpty(this.f6038i)) {
            this.f6037h.mo9252a(this.f6032c, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
        } else {
            this.f6037h.mo9252a(this.f6032c, this.f6038i, this.f6039j);
        }
        if (TextUtils.isEmpty(this.f6033d)) {
            this.f6043n = true;
        }
        return true;
    }

    /* renamed from: a */
    public void m8452a(Handler handler) {
        this.f6030a = handler;
    }

    /* renamed from: c */
    public long m8454c() {
        return this.f6041l;
    }

    /* renamed from: d */
    public boolean m8455d() {
        if (this.f6048s == null) {
            return false;
        }
        return this.f6048s.stopSelfResult(this.f6049t);
    }

    /* renamed from: a */
    public int mo8445a(C1589h c1589h) {
        if (c1589h == null) {
            return 4;
        }
        this.f6034e = c1589h.m8456a();
        this.f6031b = c1589h.m8463h();
        this.f6040k = c1589h.m8458c();
        this.f6045p = c1589h.m8464i();
        this.f6035f = EnumC2300t.m10207a(c1589h.m8460e());
        this.f6046q = EnumC2214ab.m10070a(c1589h.m8461f());
        this.f6032c = c1589h.m8470o();
        if (EnumC2300t.UNKNOWN == this.f6035f) {
            return 5;
        }
        if (this.f6046q == EnumC2214ab.SYSTEM) {
            return 6;
        }
        for (String str : c1589h.m8459d()) {
            this.f6036g.add(str);
        }
        this.f6047r = c1589h.m8462g();
        return 1;
    }

    /* renamed from: b */
    protected int mo8450b(EnumC2300t enumC2300t) {
        C2206t c2206t;
        String string;
        String strSubstring;
        String upperCase;
        if (this.f6045p == -1) {
            c2206t = null;
        } else {
            C2206t c2206tM10045b = C2204r.m10045b(GlobalApplication.m10279a().getContentResolver(), String.valueOf(this.f6045p), C4809aa.m18104a().m18121a("chaton_id", ""));
            if (c2206tM10045b == null) {
                return 10;
            }
            c2206t = c2206tM10045b;
        }
        if (EnumC2214ab.TEXT == this.f6046q || EnumC2214ab.LIVERECOMMEND == this.f6046q || EnumC2214ab.LIVESHARE == this.f6046q || EnumC2214ab.LIVECONTENTS == this.f6046q || EnumC2214ab.APPLINK == this.f6046q || EnumC2214ab.GLYMPSE == this.f6046q || EnumC2214ab.HUGEFILE == this.f6046q) {
            if (this.f6045p != -1) {
                this.f6044o = this.f6037h.m9217a(this.f6045p, this.f6032c, this.f6046q, enumC2300t, this.f6033d, (String[]) this.f6036g.toArray(new String[this.f6036g.size()]), this.f6047r, this.f6043n, EnumC2706n.YES);
            } else if (this.f6043n) {
                this.f6044o = this.f6037h.m9627a(this.f6032c, this.f6046q, enumC2300t, (String[]) this.f6036g.toArray(new String[this.f6036g.size()]), this.f6047r, (String) null, EnumC2706n.YES);
            } else {
                this.f6044o = this.f6037h.m9223a(this.f6046q, enumC2300t, this.f6033d, (String[]) this.f6036g.toArray(new String[this.f6036g.size()]), this.f6047r, (String) null, EnumC2706n.YES);
            }
        } else if (EnumC2214ab.GEO != this.f6046q) {
            String str = this.f6047r;
            if (TextUtils.isEmpty(str)) {
                return 11;
            }
            if (str.contains("file://")) {
                strSubstring = str.substring(7);
            } else if (str.contains("content://")) {
                Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(Uri.parse(str), null, null, null, null);
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
            if (EnumC2214ab.IMAGE == this.f6046q || EnumC2214ab.VIDEO == this.f6046q) {
                upperCase = strSubstring.substring(strSubstring.lastIndexOf(".") + 1);
            } else if (EnumC2214ab.AUDIO == this.f6046q) {
                StringTokenizer stringTokenizer = new StringTokenizer(strSubstring, ".");
                while (stringTokenizer.hasMoreTokens()) {
                    strNextToken = stringTokenizer.nextToken();
                }
                upperCase = strNextToken.toUpperCase();
            } else {
                return 12;
            }
            if (this.f6045p != -1) {
                if (1 == c2206t.f7888q) {
                    this.f6044o = this.f6037h.m9253b(this.f6045p, this.f6035f, c2206t.f7879h, this.f6033d, (String[]) this.f6036g.toArray(new String[this.f6036g.size()]), this.f6043n, c2206t.f7883l, upperCase, this.f6046q, EnumC2706n.YES);
                } else {
                    this.f6044o = this.f6037h.m9211a(this.f6045p, file, (String) null, this.f6046q, enumC2300t, this.f6033d, (String[]) this.f6036g.toArray(new String[this.f6036g.size()]), this.f6043n, strSubstring, EnumC2706n.YES);
                }
            } else {
                this.f6044o = this.f6037h.m9237a(file, (String) null, this.f6046q, enumC2300t, this.f6033d, (String[]) this.f6036g.toArray(new String[this.f6036g.size()]), this.f6043n, strSubstring, EnumC2706n.YES);
            }
        } else if (this.f6045p != -1) {
            this.f6044o = this.f6037h.m9210a(this.f6045p, this.f6035f, this.f6033d, (String[]) this.f6036g.toArray(new String[this.f6036g.size()]), this.f6043n, this.f6047r, EnumC2706n.YES);
        } else {
            this.f6044o = this.f6037h.m9234a(this.f6035f, this.f6033d, (String[]) this.f6036g.toArray(new String[this.f6036g.size()]), this.f6043n, this.f6047r, EnumC2706n.YES);
        }
        C4904y.m18639b("TaskID : " + String.valueOf(this.f6044o), "JobContainer");
        return 1;
    }

    /* renamed from: e */
    private boolean m8451e() {
        if (this.f6036g == null || this.f6036g.size() == 0) {
            return false;
        }
        Iterator<String> it = this.f6036g.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo8446a() {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            return mo8449a(false, 2, this.f6045p);
        }
        if (!m8451e()) {
            return mo8449a(false, 13, this.f6045p);
        }
        if (!mo8448a(this.f6035f)) {
            return mo8449a(false, 9, this.f6045p);
        }
        int iMo8450b = mo8450b(this.f6035f);
        if (iMo8450b != 1) {
            return mo8449a(false, iMo8450b, this.f6045p);
        }
        return true;
    }

    /* renamed from: a */
    protected boolean mo8449a(boolean z, int i, long j) {
        if (TextUtils.isEmpty(this.f6031b)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("packagename is empty", "JobContainer");
            }
            return false;
        }
        Intent intent = new Intent("com.sec.chaton.chat.background.MESSAGE_SEND_RESULT");
        intent.setData(new Uri.Builder().scheme(this.f6031b).build());
        intent.putExtra("result", z);
        intent.putExtra("result_code", i);
        intent.putExtra("request_id", this.f6040k);
        intent.putExtra("message_id", j);
        CommonApplication.m18732r().sendBroadcast(intent);
        if (C4904y.f17873c) {
            C4904y.m18641c("result : " + String.valueOf(z), "JobContainer");
            C4904y.m18641c("result_code : " + String.valueOf(i), "JobContainer");
            C4904y.m18641c("request_id : " + String.valueOf(this.f6040k), "JobContainer");
            C4904y.m18641c("message_id : " + String.valueOf(j), "JobContainer");
            C4904y.m18641c("packagename : " + this.f6031b, "JobContainer");
        }
        return true;
    }

    /* renamed from: a */
    protected boolean mo8447a(long j) {
        if (this.f6042m == null) {
            return false;
        }
        Message messageObtainMessage = this.f6042m.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = new Long(j);
        return this.f6042m.sendMessage(messageObtainMessage);
    }
}
