package com.sec.chaton.chat.translate;

import android.content.Context;
import android.text.TextUtils;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p055d.p056a.C1974ct;
import com.sec.chaton.p055d.p056a.C2032ex;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/* compiled from: LanguageTranslator.java */
/* renamed from: com.sec.chaton.chat.translate.c */
/* loaded from: classes.dex */
public class C1850c {

    /* renamed from: a */
    private static final String f7034a = C1850c.class.getSimpleName();

    /* renamed from: i */
    private static C1850c f7035i;

    /* renamed from: h */
    private C1863p f7042h;

    /* renamed from: b */
    private int f7036b = 0;

    /* renamed from: c */
    private String f7037c = null;

    /* renamed from: d */
    private String f7038d = null;

    /* renamed from: e */
    private String f7039e = null;

    /* renamed from: f */
    private final Object f7040f = new Object();

    /* renamed from: g */
    private String f7041g = null;

    /* renamed from: j */
    private C1844a f7043j = new C1844a();

    /* renamed from: a */
    public String m9026a() {
        String str;
        synchronized (this.f7040f) {
            str = this.f7037c;
        }
        return str;
    }

    /* renamed from: a */
    public void m9030a(EnumC1853f enumC1853f) {
        synchronized (this.f7040f) {
            if (enumC1853f == EnumC1853f.SECONDARY) {
                this.f7037c = this.f7039e;
            } else {
                this.f7037c = this.f7038d;
            }
        }
    }

    /* renamed from: b */
    public synchronized String m9033b() {
        return C4809aa.m18104a().m18121a("translation_access_token", "");
    }

    /* renamed from: c */
    public synchronized String m9036c() {
        if (TextUtils.isEmpty(this.f7041g)) {
            String string = UUID.randomUUID().toString();
            StringBuilder sb = new StringBuilder();
            int length = 64 - string.length();
            for (int i = 0; i < length; i++) {
                sb.append(Spam.ACTIVITY_CANCEL);
            }
            this.f7041g = sb.append(string).toString();
            this.f7041g = this.f7041g.replaceAll("-", Spam.ACTIVITY_CANCEL);
        }
        return this.f7041g;
    }

    /* renamed from: d */
    public static synchronized C1850c m9024d() {
        if (f7035i == null) {
            f7035i = new C1850c();
        }
        return f7035i;
    }

    private C1850c() {
        this.f7042h = null;
        this.f7042h = C1863p.m9065a();
    }

    /* renamed from: e */
    public C1844a m9039e() {
        return this.f7043j;
    }

    /* renamed from: a */
    public String m9027a(Long l, String str, boolean z, String str2, String str3, String str4, boolean z2) {
        String strM9963p;
        String strM9964q;
        C4904y.m18639b("translateChatSync(), " + String.format("isForced(%s), meLang(%s), buddyLang(%s), inboxNO(%s), msgId(%d)", Boolean.valueOf(z), str2, str3, str4, l), f7034a);
        if ((!z && !C2198l.m9962o(GlobalApplication.m18732r().getContentResolver(), str4)) || TextUtils.isEmpty(str)) {
            return null;
        }
        EnumC2214ab enumC2214abM10019a = C2204r.m10019a(str);
        if (enumC2214abM10019a == EnumC2214ab.IMAGE || enumC2214abM10019a == EnumC2214ab.VIDEO || enumC2214abM10019a == EnumC2214ab.ANICON || enumC2214abM10019a == EnumC2214ab.GEO || enumC2214abM10019a == EnumC2214ab.AMS) {
            String[] strArr = new String[0];
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length > 6 && "mixed".equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 6; i < strArrSplit.length; i++) {
                    stringBuffer.append(strArrSplit[i] + "\n");
                }
                str = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            } else {
                return null;
            }
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            strM9963p = C2198l.m9963p(GlobalApplication.m18732r().getContentResolver(), str4);
            strM9964q = C2198l.m9964q(GlobalApplication.m18732r().getContentResolver(), str4);
        } else {
            strM9964q = str3;
            strM9963p = str2;
        }
        if (strM9964q.equals(strM9963p)) {
            return null;
        }
        String strM9029a = m9029a(str, strM9964q, strM9963p);
        if (l.longValue() != -1 && !TextUtils.isEmpty(strM9029a)) {
            C2204r.m10003a(GlobalApplication.m10279a().getContentResolver(), strM9029a, l, strM9964q, strM9963p, z2);
            return strM9029a;
        }
        return strM9029a;
    }

    /* renamed from: b */
    public void m9035b(Long l, String str, boolean z, String str2, String str3, String str4, boolean z2) {
        String strSubstring;
        String strM9963p;
        String strM9964q;
        C4904y.m18639b("translateChatASync(), " + String.format("isForced(%s), meLang(%s), buddyLang(%s), inboxNO(%s), msgId(%d)", Boolean.valueOf(z), str2, str3, str4, l), f7034a);
        if (z2) {
            if ((z || C2198l.m9962o(GlobalApplication.m18732r().getContentResolver(), str4)) && !TextUtils.isEmpty(str) && TextUtils.isEmpty(C2204r.m10026a(GlobalApplication.m18732r().getContentResolver(), l, z2))) {
                EnumC2214ab enumC2214abM10019a = C2204r.m10019a(str);
                if (enumC2214abM10019a == EnumC2214ab.IMAGE || enumC2214abM10019a == EnumC2214ab.VIDEO || enumC2214abM10019a == EnumC2214ab.ANICON || enumC2214abM10019a == EnumC2214ab.GEO || enumC2214abM10019a == EnumC2214ab.AMS) {
                    String[] strArrSplit = str.split("\n");
                    if (strArrSplit.length > 6 && "mixed".equals(strArrSplit[0])) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 6; i < strArrSplit.length; i++) {
                            stringBuffer.append(strArrSplit[i] + "\n");
                        }
                        strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                    } else {
                        return;
                    }
                } else {
                    strSubstring = str;
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    strM9963p = C2198l.m9963p(GlobalApplication.m18732r().getContentResolver(), str4);
                    strM9964q = C2198l.m9964q(GlobalApplication.m18732r().getContentResolver(), str4);
                } else {
                    strM9964q = str3;
                    strM9963p = str2;
                }
                if (!strM9964q.equals(strM9963p)) {
                    this.f7042h.m9066a(new RunnableC1861n(strSubstring, strM9963p, strM9964q, l, z2));
                }
            }
        }
    }

    /* renamed from: a */
    public String m9029a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || !C1865r.m9069a(str2, str3)) {
            return null;
        }
        try {
            String strM9023c = m9023c(str.replace("\n", " --\n"), str2, str3);
            if (!TextUtils.isEmpty(strM9023c)) {
                return strM9023c.replace("  ", " ").replace("--\n", "\n");
            }
            return strM9023c;
        } catch (Exception e) {
            C4904y.m18635a(e, f7034a);
            return null;
        }
    }

    /* renamed from: b */
    private C2032ex m9022b(String str, String str2, String str3) throws ExecutionException, InterruptedException {
        C2032ex c2032exM9025d = m9025d(str, str2, str3);
        EnumC1860m enumC1860mM9168a = EnumC1860m.ERROR_LOCAL_EXCEPTION;
        if (c2032exM9025d != null) {
            enumC1860mM9168a = c2032exM9025d.m9168a();
        }
        switch (C1852e.f7046a[enumC1860mM9168a.ordinal()]) {
            case 2:
                m9031a(true);
                break;
            case 3:
                m9030a(EnumC1853f.SECONDARY);
                break;
            case 4:
                m9030a(EnumC1853f.SECONDARY);
                C2032ex c2032exM9025d2 = m9025d(str, str2, str3);
                EnumC1860m enumC1860m = EnumC1860m.ERROR_SERVER_ERROR;
                if (c2032exM9025d2 != null) {
                    c2032exM9025d2.m9168a();
                }
                if (enumC1860mM9168a == enumC1860m) {
                    m9040f();
                }
                break;
        }
        return c2032exM9025d;
    }

    /* renamed from: c */
    private String m9023c(String str, String str2, String str3) throws ExecutionException, InterruptedException, IOException {
        if (TextUtils.isEmpty(str)) {
            C4904y.m18639b("(doTranslateSync)text is empty : " + str, f7034a);
            return null;
        }
        if (!m9031a(false)) {
            C4904y.m18639b("setAuthen error (1)", f7034a);
            if (!m9031a(true)) {
                C4904y.m18639b("setAuthen error (2), do nothing more", f7034a);
                return null;
            }
        }
        boolean z = false;
        int length = str.length();
        if (length > 2000) {
            C4904y.m18639b("sentenceBreaker start!!", f7034a);
            z = true;
        }
        C4904y.m18639b(String.format("textLength(%d), isSentenceBreaking(%s)", Integer.valueOf(length), Boolean.valueOf(z)), f7034a);
        if (!z) {
            C2032ex c2032exM9022b = m9022b(str, str2, str3);
            if (c2032exM9022b != null) {
                return c2032exM9022b.m9169b();
            }
            return null;
        }
        String[] strArrM9032a = m9032a(str, 1900);
        StringBuffer stringBuffer = new StringBuffer();
        if (strArrM9032a == null) {
            C4904y.m18639b("sentenceArray is null", f7034a);
            return null;
        }
        C4904y.m18639b("sentenceArray.length: " + strArrM9032a.length, f7034a);
        for (int i = 0; i < strArrM9032a.length; i++) {
            String str4 = strArrM9032a[i];
            C2032ex c2032exM9022b2 = m9022b(str4, str2, str3);
            if (c2032exM9022b2 != null) {
                if (c2032exM9022b2.m9168a() != EnumC1860m.SUCCESS) {
                    C4904y.m18639b("failed to translate HTTP : " + i, f7034a);
                    return null;
                }
                String strM9169b = c2032exM9022b2.m9169b();
                stringBuffer.append(strM9169b);
                if (C4904y.f17872b) {
                    int length2 = stringBuffer.length();
                    int length3 = str4.length();
                    int length4 = 0;
                    if (strM9169b != null) {
                        length4 = strM9169b.length();
                    }
                    C4904y.m18639b(String.format("[%d/%d] origin text piece(%d) / trans text piece(%d), total trans current (%d)", Integer.valueOf(i + 1), Integer.valueOf(strArrM9032a.length), Integer.valueOf(length2), Integer.valueOf(length3), Integer.valueOf(length4)), f7034a);
                }
            }
        }
        String string = stringBuffer.toString();
        C4904y.m18639b("LAST. origin text length : " + length + ", trans text length : " + string.length(), f7034a);
        return string;
    }

    /* renamed from: d */
    private C2032ex m9025d(String str, String str2, String str3) {
        if (str2.equals("ar-SA")) {
            str2 = "ar";
        }
        if (str3.equals("ar-SA")) {
            str3 = "ar";
        }
        try {
            return (C2032ex) C2134o.m9565a(m9033b(), m9020a(str2, str3), str).get().m3105a();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public boolean m9031a(boolean z) throws ExecutionException, InterruptedException {
        C0778b c0778b;
        C4904y.m18639b("setAuthen(), force : " + z, f7034a);
        synchronized (this.f7040f) {
            this.f7038d = C4809aa.m18104a().m18121a("primary_translation_address", "");
            this.f7039e = C4809aa.m18104a().m18121a("secondary_translation_address", "");
            if (!z && !TextUtils.isEmpty(this.f7038d) && !TextUtils.isEmpty(this.f7039e)) {
                C4904y.m18639b("setAuthen(), Exist URL for Translation already.", f7034a);
                synchronized (this.f7040f) {
                    if (TextUtils.isEmpty(this.f7037c)) {
                        m9030a(EnumC1853f.PRIMARY);
                    }
                }
                return true;
            }
            try {
                c0778b = C2134o.m9564a(m9033b(), m9036c()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                c0778b = null;
            } catch (ExecutionException e2) {
                e2.printStackTrace();
                c0778b = null;
            }
            if (c0778b == null) {
                return false;
            }
            if (((C1974ct) c0778b.m3105a()).m9132a() != EnumC1860m.SUCCESS) {
                C4904y.m18634a("setAuthen(), failed to getUserInfo()", f7034a);
                return false;
            }
            synchronized (this.f7040f) {
                this.f7038d = C4809aa.m18104a().m18121a("primary_translation_address", "");
                this.f7039e = C4809aa.m18104a().m18121a("secondary_translation_address", "");
                m9030a(EnumC1853f.PRIMARY);
            }
            return true;
        }
    }

    /* renamed from: a */
    public String m9028a(String str) {
        return this.f7043j.m9006a(str);
    }

    /* renamed from: b */
    public String m9034b(String str) {
        return this.f7043j.m9011b(str);
    }

    /* renamed from: c */
    public Locale m9037c(String str) {
        return this.f7043j.m9012c(str);
    }

    /* renamed from: a */
    public static boolean m9021a(Context context) {
        if (C2349a.m10301a("chaton_translator")) {
            return true;
        }
        return C2948h.m12190a().m12192a(context, EnumC2949i.STranslator);
    }

    /* renamed from: a */
    public String[] m9032a(String str, int i) throws IOException {
        String[] strArr;
        Exception exc;
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        try {
            this.f7036b = 0;
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
            C1854g c1854g = new C1854g();
            c1854g.m9042a(i);
            c1854g.m9043a(new C1851d(this, arrayList));
            c1854g.m9044a(Locale.ENGLISH, sb.toString());
            String[] strArr2 = new String[this.f7036b];
            while (true) {
                try {
                    int i3 = i2;
                    if (i3 >= this.f7036b) {
                        return strArr2;
                    }
                    strArr2[i3] = (String) arrayList.get(i3);
                    i2 = i3 + 1;
                } catch (Exception e) {
                    strArr = strArr2;
                    exc = e;
                    C4904y.m18635a(exc, f7034a);
                    return strArr;
                }
            }
        } catch (Exception e2) {
            strArr = null;
            exc = e2;
        }
    }

    /* renamed from: a */
    private static String m9020a(String str, String str2) {
        try {
            return URLEncoder.encode(str + "/" + str2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (!C4904y.f17875e) {
                return null;
            }
            C4904y.m18635a(e, f7034a);
            return null;
        }
    }

    /* renamed from: d */
    public String m9038d(String str) {
        if ("en-UK".equals(str)) {
            return "en-GB";
        }
        if ("pt-PT".equals(str)) {
            return "pt-BR";
        }
        return str;
    }

    /* renamed from: f */
    void m9040f() {
        synchronized (this.f7040f) {
            C4809aa.m18104a().m18123a("primary_translation_address");
            C4809aa.m18104a().m18123a("secondary_translation_address");
            this.f7038d = null;
            this.f7039e = null;
        }
    }
}
