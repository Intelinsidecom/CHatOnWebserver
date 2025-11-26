package com.sec.chaton.chat.p024b;

import android.content.Context;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p025d.p026a.C1213cn;
import com.sec.chaton.p025d.p026a.C1252dz;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import twitter4j.Query;

/* compiled from: LanguageTranslator.java */
/* renamed from: com.sec.chaton.chat.b.c */
/* loaded from: classes.dex */
public class C0952c {

    /* renamed from: a */
    private static final String f3924a = C0952c.class.getSimpleName();

    /* renamed from: h */
    private static C0952c f3925h;

    /* renamed from: c */
    private String f3927c;

    /* renamed from: b */
    private int f3926b = 0;

    /* renamed from: d */
    private String f3928d = null;

    /* renamed from: e */
    private String f3929e = null;

    /* renamed from: f */
    private Object f3930f = new Object();

    /* renamed from: g */
    private String f3931g = null;

    /* renamed from: i */
    private C0950a f3932i = new C0950a();

    /* renamed from: a */
    public String m5146a() {
        String str;
        synchronized (this.f3930f) {
            str = this.f3927c;
        }
        return str;
    }

    /* renamed from: a */
    public void m5150a(EnumC0955f enumC0955f) {
        synchronized (this.f3930f) {
            if (enumC0955f == EnumC0955f.SECONDARY) {
                this.f3927c = this.f3929e;
            } else {
                this.f3927c = this.f3928d;
            }
        }
    }

    /* renamed from: b */
    public synchronized String m5153b() {
        if (TextUtils.isEmpty(this.f3931g)) {
            this.f3931g = UUID.randomUUID().toString();
        }
        return this.f3931g;
    }

    /* renamed from: c */
    public static synchronized C0952c m5143c() {
        if (f3925h == null) {
            f3925h = new C0952c();
        }
        return f3925h;
    }

    private C0952c() {
    }

    /* renamed from: d */
    public C0950a m5156d() {
        return this.f3932i;
    }

    /* renamed from: a */
    public String m5147a(Long l, String str, boolean z, String str2, String str3, String str4, boolean z2) {
        String strM6150n;
        String strM6151o;
        C3250y.m11450b("translateChatSync(), " + String.format("isForced(%s), meLang(%s), buddyLang(%s), inboxNO(%s), msgId(%d)", Boolean.valueOf(z), str2, str3, str4, l, Boolean.valueOf(z2)), f3924a);
        if (!z2) {
            return null;
        }
        if ((!z && !C1370n.m6149m(GlobalApplication.m11493l().getContentResolver(), str4)) || TextUtils.isEmpty(str)) {
            return null;
        }
        String strM6177a = C1373q.m6177a(GlobalApplication.m11493l().getContentResolver(), l, z2);
        if (!TextUtils.isEmpty(strM6177a)) {
            return strM6177a;
        }
        EnumC1455w enumC1455wM6173a = C1373q.m6173a(str);
        if (enumC1455wM6173a == EnumC1455w.IMAGE || enumC1455wM6173a == EnumC1455w.VIDEO || enumC1455wM6173a == EnumC1455w.ANICON || enumC1455wM6173a == EnumC1455w.GEO || enumC1455wM6173a == EnumC1455w.AMS) {
            String[] strArr = new String[0];
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length <= 6 || !Query.MIXED.equals(strArrSplit[0])) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 6; i < strArrSplit.length; i++) {
                stringBuffer.append(strArrSplit[i] + "\n");
            }
            str = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            strM6150n = C1370n.m6150n(GlobalApplication.m11493l().getContentResolver(), str4);
            strM6151o = C1370n.m6151o(GlobalApplication.m11493l().getContentResolver(), str4);
        } else {
            strM6151o = str3;
            strM6150n = str2;
        }
        if (strM6151o.equals(strM6150n)) {
            return null;
        }
        String strM5149a = m5149a(str, strM6151o, strM6150n);
        if (!TextUtils.isEmpty(strM5149a)) {
            C1373q.m6159a(GlobalApplication.m6447a().getContentResolver(), strM5149a, l, strM6151o, strM6150n, z2);
            return strM5149a;
        }
        return strM5149a;
    }

    /* renamed from: a */
    public String m5149a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || !C0965p.m5183a(str2, str3)) {
            return null;
        }
        try {
            String strM5144c = m5144c(str.replace("\n", " --\n"), str2, str3);
            if (!TextUtils.isEmpty(strM5144c)) {
                return strM5144c.replace("  ", " ").replace("--\n", "\n");
            }
            return strM5144c;
        } catch (Exception e) {
            C3250y.m11443a(e, f3924a);
            return null;
        }
    }

    /* renamed from: b */
    private C1252dz m5142b(String str, String str2, String str3) {
        C1252dz c1252dzM5145d = m5145d(str, str2, str3);
        EnumC0962m enumC0962mM5566a = c1252dzM5145d.m5566a();
        switch (C0954e.f3935a[enumC0962mM5566a.ordinal()]) {
            case 1:
            default:
                return c1252dzM5145d;
            case 2:
                m5151a(true);
                return m5145d(str, str2, str3);
            case 3:
                m5150a(EnumC0955f.SECONDARY);
                return m5145d(str, str2, str3);
            case 4:
                m5150a(EnumC0955f.SECONDARY);
                C1252dz c1252dzM5145d2 = m5145d(str, str2, str3);
                if (enumC0962mM5566a == c1252dzM5145d2.m5566a()) {
                    m5158e();
                    return c1252dzM5145d2;
                }
                return c1252dzM5145d2;
        }
    }

    /* renamed from: c */
    private String m5144c(String str, String str2, String str3) throws Exception {
        if (TextUtils.isEmpty(str)) {
            C3250y.m11450b("(doTranslateSync)text is empty : " + str, f3924a);
            return null;
        }
        if (!m5151a(false)) {
            C3250y.m11450b("setAuthen error (1)", f3924a);
            if (!m5151a(true)) {
                C3250y.m11450b("setAuthen error (2), do nothing more", f3924a);
                throw new Exception("Authen error");
            }
        }
        boolean z = false;
        int length = str.length();
        if (length > 1100) {
            C3250y.m11450b("sentenceBreaker start!!", f3924a);
            z = true;
        }
        C3250y.m11450b(String.format("textLength(%d), isSentenceBreaking(%s)", Integer.valueOf(length), Boolean.valueOf(z)), f3924a);
        if (!z) {
            return m5142b(str, str2, str3).m5567b();
        }
        String[] strArrM5152a = m5152a(str, 1000);
        if (strArrM5152a == null) {
            C3250y.m11450b("sentenceArray is null", f3924a);
            throw new Exception("SentenceBreaker error");
        }
        C3250y.m11450b("sentenceArray.length: " + strArrM5152a.length, f3924a);
        String str4 = "";
        int i = 0;
        while (i < strArrM5152a.length) {
            String str5 = strArrM5152a[i];
            C1252dz c1252dzM5142b = m5142b(str5, str2, str3);
            if (c1252dzM5142b.m5566a() != EnumC0962m.SUCCESS) {
                C3250y.m11450b("failed to translate HTTP : " + i, f3924a);
                return null;
            }
            String strM5567b = c1252dzM5142b.m5567b();
            String str6 = str4 + strM5567b;
            if (C3250y.f11734b) {
                int length2 = str6.length();
                int length3 = str5.length();
                int length4 = 0;
                if (strM5567b != null) {
                    length4 = strM5567b.length();
                }
                C3250y.m11450b(String.format("[%d/%d] origin text piece(%d) / trans text piece(%d), total trans current (%d)", Integer.valueOf(i + 1), Integer.valueOf(strArrM5152a.length), Integer.valueOf(length2), Integer.valueOf(length3), Integer.valueOf(length4)), f3924a);
            }
            i++;
            str4 = str6;
        }
        C3250y.m11450b("LAST. origin text length : " + length + ", trans text length : " + str4.length(), f3924a);
        return str4;
    }

    /* renamed from: d */
    private C1252dz m5145d(String str, String str2, String str3) {
        try {
            return (C1252dz) C1335m.m5779a(m5153b(), m5140a(str2, str3), str).m5491b().m1348a();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public boolean m5151a(boolean z) {
        C0267d c0267dB;
        C3250y.m11450b("setAuthen(), force : " + z, f3924a);
        synchronized (this.f3930f) {
            this.f3928d = C3159aa.m10962a().m10979a("primary_translation_address", "");
            this.f3929e = C3159aa.m10962a().m10979a("secondary_translation_address", "");
            if (!z && !TextUtils.isEmpty(this.f3928d) && !TextUtils.isEmpty(this.f3929e)) {
                C3250y.m11450b("setAuthen(), Exist URL for Translation already.", f3924a);
                synchronized (this.f3930f) {
                    if (TextUtils.isEmpty(this.f3927c)) {
                        m5150a(EnumC0955f.PRIMARY);
                    }
                }
                return true;
            }
            try {
                c0267dB = C1335m.m5778a(m5153b()).m5491b();
            } catch (InterruptedException e) {
                e.printStackTrace();
                c0267dB = null;
            }
            if (c0267dB == null) {
                return false;
            }
            if (((C1213cn) c0267dB.m1348a()).m5546a() != EnumC0962m.SUCCESS) {
                C3250y.m11442a("setAuthen(), failed to getUserInfo()", f3924a);
                return false;
            }
            synchronized (this.f3930f) {
                this.f3928d = C3159aa.m10962a().m10979a("primary_translation_address", "");
                this.f3929e = C3159aa.m10962a().m10979a("secondary_translation_address", "");
                m5150a(EnumC0955f.PRIMARY);
            }
            return true;
        }
    }

    /* renamed from: a */
    public String m5148a(String str) {
        return this.f3932i.m5129a(str);
    }

    /* renamed from: b */
    public String m5154b(String str) {
        return this.f3932i.m5134b(str);
    }

    /* renamed from: c */
    public Locale m5155c(String str) {
        return this.f3932i.m5135c(str);
    }

    /* renamed from: a */
    public static boolean m5141a(Context context) {
        return C1954g.m7916a().m7918a(context, EnumC1955h.STranslator);
    }

    /* renamed from: a */
    public String[] m5152a(String str, int i) throws Exception {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        try {
            this.f3926b = 0;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes("UTF8")), "UTF8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line).append('\n');
            }
            bufferedReader.close();
            C0956g c0956g = new C0956g();
            c0956g.m5160a(i);
            c0956g.m5161a(new C0953d(this, arrayList));
            c0956g.m5162a(Locale.ENGLISH, sb.toString());
            String[] strArr = new String[this.f3926b];
            while (true) {
                int i3 = i2;
                if (i3 < this.f3926b) {
                    strArr[i3] = (String) arrayList.get(i3);
                    i2 = i3 + 1;
                } else {
                    return strArr;
                }
            }
        } catch (Exception e) {
            C3250y.m11443a(e, f3924a);
            throw new Exception("SentenceBreaker error");
        }
    }

    /* renamed from: a */
    private static String m5140a(String str, String str2) {
        try {
            return URLEncoder.encode(str + "/" + str2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (!C3250y.f11737e) {
                return null;
            }
            C3250y.m11443a(e, f3924a);
            return null;
        }
    }

    /* renamed from: d */
    public String m5157d(String str) {
        if ("en-UK".equals(str)) {
            return "en-GB";
        }
        if ("pt-PT".equals(str)) {
            return "pt-BR";
        }
        return str;
    }

    /* renamed from: e */
    void m5158e() {
        synchronized (this.f3930f) {
            C3159aa.m10962a().m10981a("primary_translation_address");
            C3159aa.m10962a().m10981a("secondary_translation_address");
            this.f3928d = null;
            this.f3929e = null;
        }
    }
}
