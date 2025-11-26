package com.sec.chaton.chat.background;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p018c.C0476aa;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0624d;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1325bu;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1351z;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* compiled from: JobContainer.java */
/* renamed from: com.sec.chaton.chat.background.f */
/* loaded from: classes.dex */
public class C0559f {

    /* renamed from: a */
    private Handler f1944a;

    /* renamed from: b */
    private String f1945b;

    /* renamed from: c */
    private String f1946c;

    /* renamed from: d */
    private String f1947d;

    /* renamed from: e */
    private String f1948e;

    /* renamed from: f */
    private EnumC0665r f1949f;

    /* renamed from: i */
    private String f1952i;

    /* renamed from: j */
    private int f1953j;

    /* renamed from: k */
    private long f1954k;

    /* renamed from: m */
    private Handler f1956m;

    /* renamed from: q */
    private int f1960q;

    /* renamed from: r */
    private String f1961r;

    /* renamed from: h */
    private C0223v f1951h = null;

    /* renamed from: g */
    private ArrayList f1950g = new ArrayList();

    /* renamed from: l */
    private long f1955l = C1325bu.m4591a();

    /* renamed from: n */
    private boolean f1957n = false;

    /* renamed from: o */
    private long f1958o = -1;

    /* renamed from: p */
    private long f1959p = -1;

    public C0559f(Handler handler, Looper looper) {
        this.f1956m = handler;
        m2761a(new HandlerC0555b(this, looper));
    }

    /* renamed from: a */
    public void m2760a() {
        if (this.f1950g != null) {
            this.f1950g.clear();
            this.f1950g = null;
        }
        if (this.f1951h != null) {
            this.f1951h.m853b(this.f1944a);
        }
    }

    /* renamed from: a */
    private boolean m2757a(EnumC0665r enumC0665r) {
        Cursor cursorQuery = enumC0665r == EnumC0665r.ONETOONE ? GlobalApplication.m3105f().getContentResolver().query(C0671x.m3043d(), null, "buddy_no=?", new String[]{(String) this.f1950g.get(0), null}, null) : null;
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            this.f1946c = C1351z.m4716a();
        } else {
            cursorQuery.moveToFirst();
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
            this.f1946c = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
            if (i != 12) {
                this.f1947d = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
                this.f1952i = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
                this.f1953j = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        this.f1951h = C0223v.m806a(this.f1946c, enumC0665r);
        if (this.f1951h == null) {
            return false;
        }
        this.f1951h.m848a(this.f1944a);
        if (TextUtils.isEmpty(this.f1952i)) {
            this.f1951h.m851a(this.f1946c, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
        } else {
            this.f1951h.m851a(this.f1946c, this.f1952i, this.f1953j);
        }
        if (TextUtils.isEmpty(this.f1947d)) {
            this.f1957n = true;
        }
        C0476aa.m2436a().m2440b();
        return true;
    }

    /* renamed from: a */
    public void m2761a(Handler handler) {
        this.f1944a = handler;
    }

    /* renamed from: b */
    public long m2764b() {
        return this.f1955l;
    }

    /* renamed from: a */
    public boolean m2762a(C0558e c0558e) {
        if (c0558e == null) {
            return false;
        }
        this.f1949f = EnumC0665r.m3011a(c0558e.m2746d());
        this.f1960q = c0558e.m2747e();
        if (EnumC0665r.UNKNOWN == this.f1949f || -1 == this.f1960q) {
            return false;
        }
        this.f1948e = c0558e.m2743a();
        this.f1945b = c0558e.m2749g();
        this.f1954k = c0558e.m2744b();
        this.f1959p = c0558e.m2750h();
        for (String str : c0558e.m2745c()) {
            this.f1950g.add(str);
        }
        this.f1961r = c0558e.m2748f();
        return true;
    }

    /* renamed from: b */
    private boolean m2759b(EnumC0665r enumC0665r) {
        C0624d c0624d;
        String upperCase;
        if (this.f1959p == -1) {
            c0624d = null;
        } else {
            C0624d c0624dM2949c = C0635o.m2949c(GlobalApplication.m3105f().getContentResolver(), String.valueOf(this.f1959p), C1323bs.m4575a().getString("msisdn", ""));
            if (c0624dM2949c == null) {
                return false;
            }
            c0624d = c0624dM2949c;
        }
        EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(this.f1960q);
        if (EnumC0651d.TEXT == enumC0651dM2976a) {
            if (this.f1959p != -1) {
                this.f1958o = this.f1951h.m830a(this.f1959p, this.f1946c, enumC0651dM2976a, enumC0665r, this.f1947d, (String[]) this.f1950g.toArray(new String[this.f1950g.size()]), this.f1961r, this.f1957n);
            } else if (this.f1957n) {
                this.f1958o = this.f1951h.m839a(this.f1946c, enumC0651dM2976a, enumC0665r, (String[]) this.f1950g.toArray(new String[this.f1950g.size()]), this.f1961r);
            } else {
                this.f1958o = this.f1951h.m832a(enumC0651dM2976a, enumC0665r, this.f1947d, (String[]) this.f1950g.toArray(new String[this.f1950g.size()]), this.f1961r);
            }
        } else if (EnumC0651d.GEO != enumC0651dM2976a) {
            String strSubstring = this.f1961r;
            if (TextUtils.isEmpty(strSubstring)) {
                return false;
            }
            if (strSubstring.contains("file://")) {
                strSubstring = strSubstring.substring(7);
            }
            File file = new File(strSubstring);
            String strNextToken = "";
            if (EnumC0651d.IMAGE == enumC0651dM2976a || EnumC0651d.VIDEO == enumC0651dM2976a) {
                upperCase = strSubstring.substring(strSubstring.lastIndexOf(".") + 1);
            } else if (EnumC0651d.AUDIO == enumC0651dM2976a) {
                StringTokenizer stringTokenizer = new StringTokenizer(strSubstring, ".");
                while (stringTokenizer.hasMoreTokens()) {
                    strNextToken = stringTokenizer.nextToken();
                }
                upperCase = strNextToken.toUpperCase();
            } else {
                return false;
            }
            if (this.f1959p != -1) {
                if (3 == c0624d.f2189p) {
                    this.f1958o = this.f1951h.m825a(this.f1959p, this.f1949f, c0624d.f2181h, this.f1947d, (String[]) this.f1950g.toArray(new String[this.f1950g.size()]), this.f1957n, c0624d.f2185l, upperCase, enumC0651dM2976a);
                } else {
                    this.f1958o = this.f1951h.m829a(this.f1959p, file, enumC0651dM2976a, enumC0665r, this.f1947d, (String[]) this.f1950g.toArray(new String[this.f1950g.size()]), this.f1957n, strSubstring);
                }
            } else {
                this.f1958o = this.f1951h.m838a(file, enumC0651dM2976a, enumC0665r, this.f1947d, (String[]) this.f1950g.toArray(new String[this.f1950g.size()]), this.f1957n, strSubstring);
            }
        } else if (this.f1959p != -1) {
            this.f1958o = this.f1951h.m826a(this.f1959p, this.f1949f, this.f1947d, (String[]) this.f1950g.toArray(new String[this.f1950g.size()]), this.f1957n, this.f1961r);
        } else {
            this.f1958o = this.f1951h.m836a(this.f1949f, this.f1947d, (String[]) this.f1950g.toArray(new String[this.f1950g.size()]), this.f1957n, this.f1961r);
        }
        C1341p.m4658b("TaskID : " + String.valueOf(this.f1958o), getClass().getSimpleName());
        return true;
    }

    /* renamed from: c */
    public boolean m2765c() {
        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
        if (-3 == iM2526a || -2 == iM2526a) {
            return m2763a(false, 2, this.f1959p);
        }
        if (!m2757a(this.f1949f)) {
            return m2763a(false, 0, this.f1959p);
        }
        if (!m2759b(this.f1949f)) {
            return m2763a(false, 0, this.f1959p);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m2763a(boolean z, int i, long j) {
        Intent intent = new Intent("com.sec.chaton.chat.background.MESSAGE_SEND_RESULT");
        intent.setData(new Uri.Builder().scheme(this.f1945b).build());
        intent.putExtra("result", z);
        intent.putExtra("result_code", i);
        intent.putExtra("request_id", this.f1954k);
        intent.putExtra("message_id", j);
        GlobalApplication.m3100a().sendBroadcast(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2755a(long j) {
        if (this.f1956m == null) {
            return false;
        }
        Message messageObtainMessage = this.f1956m.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = new Long(j);
        return this.f1956m.sendMessage(messageObtainMessage);
    }
}
