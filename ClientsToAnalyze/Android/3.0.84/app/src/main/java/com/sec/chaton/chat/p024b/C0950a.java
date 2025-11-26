package com.sec.chaton.chat.p024b;

import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: LanguageManager.java */
/* renamed from: com.sec.chaton.chat.b.a */
/* loaded from: classes.dex */
public class C0950a {

    /* renamed from: a */
    public String f3898a;

    /* renamed from: b */
    public String f3899b;

    /* renamed from: c */
    public String f3900c;

    /* renamed from: d */
    public String f3901d;

    /* renamed from: e */
    public String f3902e;

    /* renamed from: f */
    public String f3903f;

    /* renamed from: g */
    public String f3904g;

    /* renamed from: h */
    public String f3905h;

    /* renamed from: i */
    public String f3906i;

    /* renamed from: j */
    public String f3907j;

    /* renamed from: k */
    public String f3908k;

    /* renamed from: l */
    public String f3909l;

    /* renamed from: m */
    public String f3910m;

    /* renamed from: n */
    public String f3911n;

    /* renamed from: o */
    public String f3912o;

    /* renamed from: p */
    public String f3913p;

    /* renamed from: q */
    public String f3914q;

    /* renamed from: r */
    public String f3915r;

    /* renamed from: s */
    public String f3916s;

    /* renamed from: t */
    public String f3917t;

    /* renamed from: u */
    public String f3918u;

    /* renamed from: v */
    public String f3919v;

    /* renamed from: w */
    public String[] f3920w;

    /* renamed from: x */
    public String[] f3921x;

    /* renamed from: y */
    public ArrayList<String> f3922y;

    /* renamed from: z */
    public ArrayList<String> f3923z;

    /* renamed from: a */
    private String m5128a(int i) {
        return GlobalApplication.m11493l().getString(i);
    }

    public C0950a() {
        m5130a();
    }

    /* renamed from: a */
    public void m5130a() {
        this.f3906i = m5128a(R.string.chinese);
        this.f3898a = m5128a(R.string.english_uk);
        this.f3899b = m5128a(R.string.english_us);
        this.f3901d = m5128a(R.string.french);
        this.f3902e = m5128a(R.string.german);
        this.f3903f = m5128a(R.string.italian);
        this.f3905h = m5128a(R.string.japanese);
        this.f3904g = m5128a(R.string.korean);
        this.f3907j = m5128a(R.string.portuguese);
        this.f3900c = m5128a(R.string.spanish);
        this.f3908k = "unknown";
        this.f3917t = "zh-CN";
        this.f3909l = "en-UK";
        this.f3910m = "en-US";
        this.f3912o = "fr-FR";
        this.f3913p = "de-DE";
        this.f3914q = "it-IT";
        this.f3916s = "ja-JP";
        this.f3915r = "ko-KR";
        this.f3918u = "pt-PT";
        this.f3911n = "es-ES";
        this.f3919v = "pt";
        this.f3920w = new String[10];
        this.f3920w[0] = this.f3917t;
        this.f3920w[1] = this.f3909l;
        this.f3920w[2] = this.f3910m;
        this.f3920w[3] = this.f3912o;
        this.f3920w[4] = this.f3913p;
        this.f3920w[5] = this.f3914q;
        this.f3920w[6] = this.f3916s;
        this.f3920w[7] = this.f3915r;
        this.f3920w[8] = this.f3918u;
        this.f3920w[9] = this.f3911n;
        this.f3921x = new String[10];
        this.f3921x[0] = this.f3906i;
        this.f3921x[1] = this.f3898a;
        this.f3921x[2] = this.f3899b;
        this.f3921x[3] = this.f3901d;
        this.f3921x[4] = this.f3902e;
        this.f3921x[5] = this.f3903f;
        this.f3921x[6] = this.f3905h;
        this.f3921x[7] = this.f3904g;
        this.f3921x[8] = this.f3907j;
        this.f3921x[9] = this.f3900c;
        this.f3922y = new ArrayList<>();
        this.f3922y.add(this.f3906i);
        this.f3922y.add(this.f3898a);
        this.f3922y.add(this.f3899b);
        this.f3922y.add(this.f3901d);
        this.f3922y.add(this.f3902e);
        this.f3922y.add(this.f3903f);
        this.f3922y.add(this.f3905h);
        this.f3922y.add(this.f3904g);
        this.f3922y.add(this.f3907j);
        this.f3922y.add(this.f3900c);
        this.f3923z = new ArrayList<>();
        this.f3923z.add(this.f3917t);
        this.f3923z.add(this.f3909l);
        this.f3923z.add(this.f3910m);
        this.f3923z.add(this.f3912o);
        this.f3923z.add(this.f3913p);
        this.f3923z.add(this.f3914q);
        this.f3923z.add(this.f3916s);
        this.f3923z.add(this.f3915r);
        this.f3923z.add(this.f3918u);
        this.f3923z.add(this.f3911n);
    }

    /* renamed from: a */
    public String m5129a(String str) {
        if (str.equals(this.f3910m)) {
            return this.f3899b;
        }
        if (str.equals(this.f3909l)) {
            return this.f3898a;
        }
        if (str.equals(this.f3911n)) {
            return this.f3900c;
        }
        if (str.equals(this.f3912o)) {
            return this.f3901d;
        }
        if (str.equals(this.f3913p)) {
            return this.f3902e;
        }
        if (str.equals(this.f3914q)) {
            return this.f3903f;
        }
        if (str.equals(this.f3915r)) {
            return this.f3904g;
        }
        if (str.equals(this.f3916s)) {
            return this.f3905h;
        }
        if (str.equals(this.f3917t)) {
            return this.f3906i;
        }
        if (str.equals(this.f3918u)) {
            return this.f3907j;
        }
        return null;
    }

    /* renamed from: b */
    public String m5134b(String str) {
        if (str.equals(this.f3899b)) {
            return this.f3910m;
        }
        if (str.equals(this.f3898a)) {
            return this.f3909l;
        }
        if (str.equals(this.f3900c)) {
            return this.f3911n;
        }
        if (str.equals(this.f3901d)) {
            return this.f3912o;
        }
        if (str.equals(this.f3902e)) {
            return this.f3913p;
        }
        if (str.equals(this.f3903f)) {
            return this.f3914q;
        }
        if (str.equals(this.f3904g)) {
            return this.f3915r;
        }
        if (str.equals(this.f3905h)) {
            return this.f3916s;
        }
        if (str.equals(this.f3906i)) {
            return this.f3917t;
        }
        if (str.equals(this.f3907j)) {
            return this.f3918u;
        }
        return null;
    }

    /* renamed from: c */
    public Locale m5135c(String str) {
        if (str.equals(this.f3910m)) {
            return Locale.ENGLISH;
        }
        if (str.equals(this.f3911n)) {
            return new Locale("es", "ES");
        }
        if (str.equals(this.f3912o)) {
            return Locale.FRENCH;
        }
        if (str.equals(this.f3913p)) {
            return Locale.GERMAN;
        }
        if (str.equals(this.f3914q)) {
            return Locale.ITALIAN;
        }
        if (str.equals(this.f3915r)) {
            return Locale.KOREAN;
        }
        if (str.equals(this.f3916s)) {
            return Locale.JAPANESE;
        }
        if (str.equals(this.f3917t)) {
            return Locale.CHINESE;
        }
        if (str.equals(this.f3918u)) {
            return new Locale(this.f3919v);
        }
        return Locale.ENGLISH;
    }

    /* renamed from: b */
    public String m5133b() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return this.f3910m;
        }
        String language = locale.getLanguage();
        if (language == null) {
            return this.f3910m;
        }
        if (language.equalsIgnoreCase("en")) {
            if (locale.equals(Locale.UK)) {
                return this.f3909l;
            }
            return this.f3910m;
        }
        if (language.equalsIgnoreCase("es")) {
            return this.f3911n;
        }
        if (language.equalsIgnoreCase("fr")) {
            return this.f3912o;
        }
        if (language.equalsIgnoreCase("de")) {
            return this.f3913p;
        }
        if (language.equalsIgnoreCase("it")) {
            return this.f3914q;
        }
        if (language.equalsIgnoreCase("ko")) {
            return this.f3915r;
        }
        if (language.equalsIgnoreCase("ja")) {
            return this.f3916s;
        }
        if (language.equalsIgnoreCase("zh")) {
            return this.f3917t;
        }
        if (language.equalsIgnoreCase("pt")) {
            return this.f3918u;
        }
        return this.f3910m;
    }

    /* renamed from: a */
    public void m5131a(Spinner spinner, String str, String str2) {
        ArrayAdapter<String> arrayAdapter = (ArrayAdapter) spinner.getAdapter();
        C0952c c0952cM5143c = C0952c.m5143c();
        C0950a c0950aM5156d = c0952cM5143c.m5156d();
        if (str.equals(c0950aM5156d.f3917t)) {
            arrayAdapter.clear();
            arrayAdapter.add(c0950aM5156d.f3899b);
            arrayAdapter.add(c0950aM5156d.f3905h);
            arrayAdapter.add(c0950aM5156d.f3904g);
            arrayAdapter.notifyDataSetChanged();
            if (!m5132a(c0952cM5143c, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return;
            }
            return;
        }
        if (str.equals(c0950aM5156d.f3909l)) {
            arrayAdapter.clear();
            arrayAdapter.add(c0950aM5156d.f3901d);
            arrayAdapter.add(c0950aM5156d.f3902e);
            arrayAdapter.add(c0950aM5156d.f3903f);
            arrayAdapter.add(c0950aM5156d.f3907j);
            arrayAdapter.add(c0950aM5156d.f3900c);
            arrayAdapter.notifyDataSetChanged();
            if (!m5132a(c0952cM5143c, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return;
            }
            return;
        }
        if (str.equals(c0950aM5156d.f3910m)) {
            arrayAdapter.clear();
            arrayAdapter.add(c0950aM5156d.f3906i);
            arrayAdapter.add(c0950aM5156d.f3901d);
            arrayAdapter.add(c0950aM5156d.f3902e);
            arrayAdapter.add(c0950aM5156d.f3903f);
            arrayAdapter.add(c0950aM5156d.f3905h);
            arrayAdapter.add(c0950aM5156d.f3904g);
            arrayAdapter.add(c0950aM5156d.f3907j);
            arrayAdapter.add(c0950aM5156d.f3900c);
            arrayAdapter.notifyDataSetChanged();
            if (!m5132a(c0952cM5143c, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return;
            }
            return;
        }
        if (str.equals(c0950aM5156d.f3912o) || str.equals(c0950aM5156d.f3913p) || str.equals(c0950aM5156d.f3914q) || str.equals(c0950aM5156d.f3911n) || str.equals(c0950aM5156d.f3918u)) {
            arrayAdapter.clear();
            arrayAdapter.add(c0950aM5156d.f3898a);
            arrayAdapter.add(c0950aM5156d.f3899b);
            arrayAdapter.notifyDataSetChanged();
            if (!m5132a(c0952cM5143c, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return;
            }
            return;
        }
        if (str.equals(c0950aM5156d.f3916s)) {
            arrayAdapter.clear();
            arrayAdapter.add(c0950aM5156d.f3906i);
            arrayAdapter.add(c0950aM5156d.f3899b);
            arrayAdapter.add(c0950aM5156d.f3904g);
            arrayAdapter.notifyDataSetChanged();
            if (!m5132a(c0952cM5143c, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
                return;
            }
            return;
        }
        if (str.equals(c0950aM5156d.f3915r)) {
            arrayAdapter.clear();
            arrayAdapter.add(c0950aM5156d.f3906i);
            arrayAdapter.add(c0950aM5156d.f3899b);
            arrayAdapter.add(c0950aM5156d.f3905h);
            arrayAdapter.notifyDataSetChanged();
            if (!m5132a(c0952cM5143c, spinner, arrayAdapter, str2)) {
                spinner.setSelection(0);
            }
        }
    }

    /* renamed from: a */
    public boolean m5132a(C0952c c0952c, Spinner spinner, ArrayAdapter<String> arrayAdapter, String str) {
        for (int i = 0; i < arrayAdapter.getCount(); i++) {
            if (str.equals(c0952c.m5154b(arrayAdapter.getItem(i)))) {
                spinner.setSelection(i);
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public String m5136d(String str) {
        if (TextUtils.isEmpty(str)) {
            return m5133b();
        }
        return str;
    }

    /* renamed from: e */
    public String m5137e(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.f3910m;
        }
        return str;
    }
}
