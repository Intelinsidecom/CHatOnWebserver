package com.sec.chaton.chat.translate;

import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: LanguageManager.java */
/* renamed from: com.sec.chaton.chat.translate.a */
/* loaded from: classes.dex */
public class C1844a {

    /* renamed from: A */
    public String f6990A;

    /* renamed from: B */
    public String f6991B;

    /* renamed from: C */
    public String f6992C;

    /* renamed from: D */
    public String f6993D;

    /* renamed from: E */
    public String f6994E;

    /* renamed from: F */
    public String f6995F;

    /* renamed from: G */
    public String[] f6996G;

    /* renamed from: H */
    public String[] f6997H;

    /* renamed from: I */
    public ArrayList<String> f6998I;

    /* renamed from: J */
    public ArrayList<String> f6999J;

    /* renamed from: a */
    public String f7000a;

    /* renamed from: b */
    public String f7001b;

    /* renamed from: c */
    public String f7002c;

    /* renamed from: d */
    public String f7003d;

    /* renamed from: e */
    public String f7004e;

    /* renamed from: f */
    public String f7005f;

    /* renamed from: g */
    public String f7006g;

    /* renamed from: h */
    public String f7007h;

    /* renamed from: i */
    public String f7008i;

    /* renamed from: j */
    public String f7009j;

    /* renamed from: k */
    public String f7010k;

    /* renamed from: l */
    public String f7011l;

    /* renamed from: m */
    public String f7012m;

    /* renamed from: n */
    public String f7013n;

    /* renamed from: o */
    public String f7014o;

    /* renamed from: p */
    public String f7015p;

    /* renamed from: q */
    public String f7016q;

    /* renamed from: r */
    public String f7017r;

    /* renamed from: s */
    public String f7018s;

    /* renamed from: t */
    public String f7019t;

    /* renamed from: u */
    public String f7020u;

    /* renamed from: v */
    public String f7021v;

    /* renamed from: w */
    public String f7022w;

    /* renamed from: x */
    public String f7023x;

    /* renamed from: y */
    public String f7024y;

    /* renamed from: z */
    public String f7025z;

    /* renamed from: a */
    private String m9005a(int i) {
        return GlobalApplication.m18732r().getString(i);
    }

    public C1844a() {
        m9007a();
    }

    /* renamed from: a */
    public void m9007a() {
        this.f7008i = m9005a(R.string.chinese);
        this.f7000a = m9005a(R.string.english_uk);
        this.f7001b = m9005a(R.string.english_us);
        this.f7003d = m9005a(R.string.french);
        this.f7004e = m9005a(R.string.german);
        this.f7005f = m9005a(R.string.italian);
        this.f7007h = m9005a(R.string.japanese);
        this.f7006g = m9005a(R.string.korean);
        this.f7009j = m9005a(R.string.portuguese);
        this.f7010k = m9005a(R.string.russian);
        this.f7002c = m9005a(R.string.spanish);
        this.f7011l = m9005a(R.string.india);
        this.f7012m = m9005a(R.string.saudi);
        this.f7013n = m9005a(R.string.turkish);
        this.f7014o = m9005a(R.string.farsi);
        this.f7015p = "unknown";
        this.f7024y = "zh-CN";
        this.f7016q = "en-UK";
        this.f7017r = "en-US";
        this.f7019t = "fr-FR";
        this.f7020u = "de-DE";
        this.f7021v = "it-IT";
        this.f7023x = "ja-JP";
        this.f7022w = "ko-KR";
        this.f7025z = "pt-PT";
        this.f6990A = "ru-RU";
        this.f7018s = "es-ES";
        this.f6991B = "hi-IN";
        this.f6992C = "ar-SA";
        this.f6993D = "tr-TR";
        this.f6994E = "fa-IR";
        this.f6995F = "pt";
        this.f6996G = new String[15];
        this.f6996G[0] = this.f7017r;
        this.f6996G[1] = this.f6992C;
        this.f6996G[2] = this.f7024y;
        this.f6996G[3] = this.f7016q;
        this.f6996G[4] = this.f7019t;
        this.f6996G[5] = this.f6994E;
        this.f6996G[6] = this.f7020u;
        this.f6996G[7] = this.f6991B;
        this.f6996G[8] = this.f7021v;
        this.f6996G[9] = this.f7023x;
        this.f6996G[10] = this.f7022w;
        this.f6996G[11] = this.f7025z;
        this.f6996G[12] = this.f6990A;
        this.f6996G[13] = this.f7018s;
        this.f6996G[14] = this.f6993D;
        this.f6997H = new String[15];
        this.f6997H[0] = this.f7001b;
        this.f6997H[1] = this.f7012m;
        this.f6997H[2] = this.f7008i;
        this.f6997H[3] = this.f7000a;
        this.f6997H[4] = this.f7003d;
        this.f6997H[5] = this.f7014o;
        this.f6997H[6] = this.f7004e;
        this.f6997H[7] = this.f7011l;
        this.f6997H[8] = this.f7005f;
        this.f6997H[9] = this.f7007h;
        this.f6997H[10] = this.f7006g;
        this.f6997H[11] = this.f7009j;
        this.f6997H[12] = this.f7010k;
        this.f6997H[13] = this.f7002c;
        this.f6997H[14] = this.f7013n;
        this.f6998I = new ArrayList<>();
        this.f6998I.add(this.f7001b);
        if (C1865r.m9072c()) {
            this.f6998I.add(this.f7012m);
        }
        this.f6998I.add(this.f7008i);
        this.f6998I.add(this.f7000a);
        this.f6998I.add(this.f7003d);
        if (C1865r.m9075f()) {
            this.f6998I.add(this.f7014o);
        }
        this.f6998I.add(this.f7004e);
        if (C1865r.m9073d()) {
            this.f6998I.add(this.f7011l);
        }
        this.f6998I.add(this.f7005f);
        this.f6998I.add(this.f7007h);
        this.f6998I.add(this.f7006g);
        this.f6998I.add(this.f7009j);
        this.f6998I.add(this.f7010k);
        this.f6998I.add(this.f7002c);
        if (C1865r.m9074e()) {
            this.f6998I.add(this.f7013n);
        }
        this.f6999J = new ArrayList<>();
        this.f6999J.add(this.f7017r);
        if (C1865r.m9072c()) {
            this.f6999J.add(this.f6992C);
        }
        this.f6999J.add(this.f7024y);
        this.f6999J.add(this.f7016q);
        this.f6999J.add(this.f7019t);
        if (C1865r.m9075f()) {
            this.f6999J.add(this.f6994E);
        }
        this.f6999J.add(this.f7020u);
        if (C1865r.m9073d()) {
            this.f6999J.add(this.f6991B);
        }
        this.f6999J.add(this.f7021v);
        this.f6999J.add(this.f7023x);
        this.f6999J.add(this.f7022w);
        this.f6999J.add(this.f7025z);
        this.f6999J.add(this.f6990A);
        this.f6999J.add(this.f7018s);
        if (C1865r.m9074e()) {
            this.f6999J.add(this.f6993D);
        }
    }

    /* renamed from: a */
    public String m9006a(String str) {
        if (str.equals(this.f7017r)) {
            return this.f7001b;
        }
        if (str.equals(this.f7016q)) {
            return this.f7000a;
        }
        if (str.equals(this.f7018s)) {
            return this.f7002c;
        }
        if (str.equals(this.f7019t)) {
            return this.f7003d;
        }
        if (str.equals(this.f7020u)) {
            return this.f7004e;
        }
        if (str.equals(this.f7021v)) {
            return this.f7005f;
        }
        if (str.equals(this.f7022w)) {
            return this.f7006g;
        }
        if (str.equals(this.f7023x)) {
            return this.f7007h;
        }
        if (str.equals(this.f7024y)) {
            return this.f7008i;
        }
        if (str.equals(this.f7025z)) {
            return this.f7009j;
        }
        if (str.equals(this.f6990A)) {
            return this.f7010k;
        }
        if (str.equals(this.f6991B)) {
            return this.f7011l;
        }
        if (str.equals(this.f6992C)) {
            return this.f7012m;
        }
        if (str.equals(this.f6993D)) {
            return this.f7013n;
        }
        if (str.equals(this.f6994E)) {
            return this.f7014o;
        }
        return null;
    }

    /* renamed from: b */
    public String m9011b(String str) {
        if (str.equals(this.f7001b)) {
            return this.f7017r;
        }
        if (str.equals(this.f7000a)) {
            return this.f7016q;
        }
        if (str.equals(this.f7002c)) {
            return this.f7018s;
        }
        if (str.equals(this.f7003d)) {
            return this.f7019t;
        }
        if (str.equals(this.f7004e)) {
            return this.f7020u;
        }
        if (str.equals(this.f7005f)) {
            return this.f7021v;
        }
        if (str.equals(this.f7006g)) {
            return this.f7022w;
        }
        if (str.equals(this.f7007h)) {
            return this.f7023x;
        }
        if (str.equals(this.f7008i)) {
            return this.f7024y;
        }
        if (str.equals(this.f7009j)) {
            return this.f7025z;
        }
        if (str.equals(this.f7010k)) {
            return this.f6990A;
        }
        if (str.equals(this.f7011l)) {
            return this.f6991B;
        }
        if (str.equals(this.f7012m)) {
            return this.f6992C;
        }
        if (str.equals(this.f7013n)) {
            return this.f6993D;
        }
        if (str.equals(this.f7014o)) {
            return this.f6994E;
        }
        return null;
    }

    /* renamed from: c */
    public Locale m9012c(String str) {
        if (str.equals(this.f7017r)) {
            return Locale.ENGLISH;
        }
        if (!str.equals(this.f7018s)) {
            if (str.equals(this.f7019t)) {
                return Locale.FRENCH;
            }
            if (str.equals(this.f7020u)) {
                return Locale.GERMAN;
            }
            if (str.equals(this.f7021v)) {
                return Locale.ITALIAN;
            }
            if (str.equals(this.f7022w)) {
                return Locale.KOREAN;
            }
            if (str.equals(this.f7023x)) {
                return Locale.JAPANESE;
            }
            if (str.equals(this.f7024y)) {
                return Locale.CHINESE;
            }
            if (str.equals(this.f7025z)) {
                return new Locale(this.f6995F);
            }
            if (str.equals(this.f6990A)) {
                return new Locale("ru", "RU");
            }
            if (str.equals(this.f6991B)) {
                return new Locale("hi", "IN");
            }
            if (str.equals(this.f6992C)) {
                return new Locale("ar", "SA");
            }
            if (str.equals(this.f6993D)) {
                return new Locale("tr", "TR");
            }
            if (str.equals(this.f6994E)) {
                return new Locale("fa", "IR");
            }
        }
        return Locale.ENGLISH;
    }

    /* renamed from: b */
    public String m9010b() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return this.f7017r;
        }
        String language = locale.getLanguage();
        if (language == null) {
            return this.f7017r;
        }
        if (language.equalsIgnoreCase("en")) {
            if (locale.equals(Locale.UK)) {
                return this.f7016q;
            }
            return this.f7017r;
        }
        if (language.equalsIgnoreCase("es")) {
            return this.f7018s;
        }
        if (language.equalsIgnoreCase("fr")) {
            return this.f7019t;
        }
        if (language.equalsIgnoreCase("de")) {
            return this.f7020u;
        }
        if (language.equalsIgnoreCase("it")) {
            return this.f7021v;
        }
        if (language.equalsIgnoreCase("ko")) {
            return this.f7022w;
        }
        if (language.equalsIgnoreCase("ja")) {
            return this.f7023x;
        }
        if (language.equalsIgnoreCase("zh")) {
            return this.f7024y;
        }
        if (language.equalsIgnoreCase("pt")) {
            return this.f7025z;
        }
        if (language.equalsIgnoreCase("ru")) {
            return this.f6990A;
        }
        if (language.equalsIgnoreCase("hi")) {
            return this.f6991B;
        }
        if (language.equalsIgnoreCase("ar")) {
            return this.f6992C;
        }
        if (language.equalsIgnoreCase("tr")) {
            return this.f6993D;
        }
        if (language.equalsIgnoreCase("fa")) {
            return this.f6994E;
        }
        return this.f7017r;
    }

    /* renamed from: a */
    public boolean m9008a(Spinner spinner, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        ArrayAdapter<String> arrayAdapter = (ArrayAdapter) spinner.getAdapter();
        C1850c c1850cM9024d = C1850c.m9024d();
        C1844a c1844aM9039e = c1850cM9024d.m9039e();
        if (str.equals(c1844aM9039e.f7024y)) {
            arrayAdapter.clear();
            arrayAdapter.add(c1844aM9039e.f7001b);
            arrayAdapter.add(c1844aM9039e.f7007h);
            arrayAdapter.add(c1844aM9039e.f7006g);
            arrayAdapter.notifyDataSetChanged();
            if (!m9009a(c1850cM9024d, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return true;
            }
        } else if (str.equals(c1844aM9039e.f7016q)) {
            arrayAdapter.clear();
            if (C1865r.m9072c()) {
                arrayAdapter.add(c1844aM9039e.f7012m);
            }
            arrayAdapter.add(c1844aM9039e.f7003d);
            if (C1865r.m9075f()) {
                arrayAdapter.add(c1844aM9039e.f7014o);
            }
            arrayAdapter.add(c1844aM9039e.f7004e);
            if (C1865r.m9073d()) {
                arrayAdapter.add(c1844aM9039e.f7011l);
            }
            arrayAdapter.add(c1844aM9039e.f7005f);
            arrayAdapter.add(c1844aM9039e.f7009j);
            arrayAdapter.add(c1844aM9039e.f7010k);
            arrayAdapter.add(c1844aM9039e.f7002c);
            if (C1865r.m9074e()) {
                arrayAdapter.add(c1844aM9039e.f7013n);
            }
            arrayAdapter.notifyDataSetChanged();
            if (!m9009a(c1850cM9024d, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return true;
            }
        } else if (str.equals(c1844aM9039e.f7017r)) {
            arrayAdapter.clear();
            if (C1865r.m9072c()) {
                arrayAdapter.add(c1844aM9039e.f7012m);
            }
            arrayAdapter.add(c1844aM9039e.f7008i);
            arrayAdapter.add(c1844aM9039e.f7003d);
            if (C1865r.m9075f()) {
                arrayAdapter.add(c1844aM9039e.f7014o);
            }
            arrayAdapter.add(c1844aM9039e.f7004e);
            if (C1865r.m9073d()) {
                arrayAdapter.add(c1844aM9039e.f7011l);
            }
            arrayAdapter.add(c1844aM9039e.f7005f);
            arrayAdapter.add(c1844aM9039e.f7007h);
            arrayAdapter.add(c1844aM9039e.f7006g);
            arrayAdapter.add(c1844aM9039e.f7009j);
            arrayAdapter.add(c1844aM9039e.f7010k);
            arrayAdapter.add(c1844aM9039e.f7002c);
            if (C1865r.m9074e()) {
                arrayAdapter.add(c1844aM9039e.f7013n);
            }
            arrayAdapter.notifyDataSetChanged();
            if (!m9009a(c1850cM9024d, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return true;
            }
        } else if (str.equals(c1844aM9039e.f7020u) || str.equals(c1844aM9039e.f7021v) || str.equals(c1844aM9039e.f7018s) || str.equals(c1844aM9039e.f7025z) || str.equals(c1844aM9039e.f6990A) || str.equals(c1844aM9039e.f6991B) || str.equals(c1844aM9039e.f6993D) || str.equals(c1844aM9039e.f6994E)) {
            arrayAdapter.clear();
            arrayAdapter.add(c1844aM9039e.f7001b);
            arrayAdapter.add(c1844aM9039e.f7000a);
            arrayAdapter.notifyDataSetChanged();
            if (!m9009a(c1850cM9024d, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return true;
            }
        } else if (str.equals(c1844aM9039e.f7023x)) {
            arrayAdapter.clear();
            arrayAdapter.add(c1844aM9039e.f7001b);
            arrayAdapter.add(c1844aM9039e.f7008i);
            arrayAdapter.add(c1844aM9039e.f7006g);
            arrayAdapter.notifyDataSetChanged();
            if (!m9009a(c1850cM9024d, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return true;
            }
        } else if (str.equals(c1844aM9039e.f7022w)) {
            arrayAdapter.clear();
            arrayAdapter.add(c1844aM9039e.f7001b);
            arrayAdapter.add(c1844aM9039e.f7008i);
            arrayAdapter.add(c1844aM9039e.f7007h);
            arrayAdapter.notifyDataSetChanged();
            if (!m9009a(c1850cM9024d, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return true;
            }
        } else if (str.equals(c1844aM9039e.f7019t)) {
            arrayAdapter.clear();
            arrayAdapter.add(c1844aM9039e.f7001b);
            if (C1865r.m9072c()) {
                arrayAdapter.add(c1844aM9039e.f7012m);
            }
            arrayAdapter.add(c1844aM9039e.f7000a);
            arrayAdapter.notifyDataSetChanged();
            if (!m9009a(c1850cM9024d, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return true;
            }
        } else if (str.equals(c1844aM9039e.f6992C)) {
            arrayAdapter.clear();
            arrayAdapter.add(c1844aM9039e.f7001b);
            arrayAdapter.add(c1844aM9039e.f7000a);
            arrayAdapter.add(c1844aM9039e.f7003d);
            arrayAdapter.notifyDataSetChanged();
            if (!m9009a(c1850cM9024d, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m9009a(C1850c c1850c, Spinner spinner, ArrayAdapter<String> arrayAdapter, String str) {
        for (int i = 0; i < arrayAdapter.getCount(); i++) {
            if (str.equals(c1850c.m9034b(arrayAdapter.getItem(i)))) {
                spinner.setSelection(i);
                return true;
            }
        }
        C5179v.m19810a(CommonApplication.m18732r(), R.string.translator_toast_set_as_default_language, 0).show();
        return false;
    }

    /* renamed from: d */
    public String m9013d(String str) {
        if (TextUtils.isEmpty(str)) {
            return m9010b();
        }
        return str;
    }

    /* renamed from: e */
    public String m9014e(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.f7017r;
        }
        return str;
    }
}
