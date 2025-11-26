package com.sec.chaton.multimedia.vcard;

import android.text.TextUtils;
import com.sec.chaton.util.C1341p;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: VCardComposer.java */
/* renamed from: com.sec.chaton.multimedia.vcard.a */
/* loaded from: classes.dex */
public class C0824a {

    /* renamed from: c */
    private static final HashMap f2856c = new HashMap();

    /* renamed from: d */
    private static final HashMap f2857d = new HashMap();

    /* renamed from: e */
    private static final HashMap f2858e = new HashMap();

    /* renamed from: f */
    private static final HashMap f2859f = new HashMap();

    /* renamed from: g */
    private static final HashMap f2860g = new HashMap();

    /* renamed from: a */
    private String f2861a;

    /* renamed from: b */
    private StringBuilder f2862b;

    static {
        f2856c.put(1, "HOME");
        f2856c.put(2, "CELL");
        f2856c.put(3, "WORK");
        f2856c.put(4, "WORK-FAX");
        f2856c.put(5, "HOME-FAX");
        f2856c.put(6, "PAGER");
        f2856c.put(7, "OTHER");
        f2856c.put(8, "CALLBACK");
        f2856c.put(9, "CAR");
        f2856c.put(10, "COMPANY_MAIN");
        f2856c.put(11, "ISDN");
        f2856c.put(12, "MAIN");
        f2856c.put(13, "OTHER_FAX");
        f2856c.put(14, "RADIO");
        f2856c.put(15, "TELEX");
        f2856c.put(16, "TTY_TDD");
        f2856c.put(17, "WORK_MOBILE");
        f2856c.put(18, "WORK_PAGER");
        f2856c.put(19, "ASSISTANT");
        f2856c.put(20, "MMS");
        f2857d.put(1, "HOME");
        f2857d.put(2, "WORK");
        f2857d.put(3, "OTHER");
        f2857d.put(4, "MOBILE");
        f2858e.put(1, "HOME");
        f2858e.put(2, "WORK");
        f2858e.put(3, "OTHER");
        f2859f.put(0, "X-AIM");
        f2859f.put(5, "X-GOOGLE_TALK");
        f2859f.put(6, "X-ICQ");
        f2859f.put(7, "X-JABBER");
        f2859f.put(1, "X-MSN");
        f2859f.put(8, "X-NETMEETING");
        f2859f.put(4, "X-QQ");
        f2859f.put(3, "X-SKYPE");
        f2859f.put(2, "X-YAHOO");
        f2860g.put(11, "OTHER");
        f2860g.put(8, "BDAY");
        f2860g.put(9, "ANNIVERSARY");
        f2860g.put(10, "WEBSITE");
    }

    /* renamed from: a */
    public String m3398a(C0833j c0833j, int i) throws C0841r {
        this.f2862b = new StringBuilder();
        if ((c0833j.f2895a == null || c0833j.f2895a.trim().length() == 0) && (c0833j.f2896b == null || c0833j.f2896b.trim().length() == 0)) {
            if (!TextUtils.isEmpty(c0833j.f2897c)) {
                c0833j.f2895a = c0833j.f2897c;
            } else if (c0833j.f2902h != null) {
                if (!TextUtils.isEmpty(((C0825b) c0833j.f2902h.get(0)).f2864b)) {
                    c0833j.f2895a = ((C0825b) c0833j.f2902h.get(0)).f2864b;
                } else {
                    c0833j.f2895a = "#";
                }
            } else if (c0833j.f2903i != null) {
                if (!TextUtils.isEmpty(((C0842s) c0833j.f2903i.get(0)).f2922b)) {
                    c0833j.f2895a = ((C0842s) c0833j.f2903i.get(0)).f2922b;
                } else {
                    c0833j.f2895a = "#";
                }
            } else if (c0833j.f2904j != null && !TextUtils.isEmpty(((C0830g) c0833j.f2904j.get(0)).f2877c)) {
                c0833j.f2895a = ((C0830g) c0833j.f2904j.get(0)).f2877c;
            } else {
                c0833j.f2895a = "#";
            }
        }
        if (i == 1 || i == 2) {
            this.f2861a = "\r\n";
            this.f2862b.append("BEGIN:VCARD").append(this.f2861a);
            if (i == 1) {
                this.f2862b.append("VERSION:2.1").append(this.f2861a);
            } else if (i == 2) {
                this.f2862b.append("VERSION:3.0").append(this.f2861a);
            } else if (i == 3) {
                this.f2862b.append("VERSION:4.0").append(this.f2861a);
            } else {
                this.f2862b.append("VERSION:2.1").append(this.f2861a);
            }
            if (!TextUtils.isEmpty(c0833j.f2895a)) {
                if (!TextUtils.isEmpty(c0833j.f2896b)) {
                    this.f2862b.append("N;").append(m3389a(c0833j.f2896b)).append(";").append(m3393b(c0833j.f2895a)).append(this.f2861a);
                    this.f2862b.append("FN;").append(m3389a(c0833j.f2895a)).append(" ").append(m3393b(c0833j.f2896b)).append(this.f2861a);
                } else {
                    this.f2862b.append("N;").append(m3389a(c0833j.f2895a)).append(this.f2861a);
                    this.f2862b.append("FN;").append(m3389a(c0833j.f2895a)).append(this.f2861a);
                }
            } else if (!TextUtils.isEmpty(c0833j.f2896b)) {
                this.f2862b.append("N;").append(m3389a(c0833j.f2896b)).append(";").append(this.f2861a);
                this.f2862b.append("FN;").append(m3389a(c0833j.f2896b)).append(this.f2861a);
            }
            if (!TextUtils.isEmpty(c0833j.f2897c)) {
                this.f2862b.append("ORG:").append(c0833j.f2897c).append(this.f2861a);
            }
            if (!TextUtils.isEmpty(c0833j.f2898d)) {
                this.f2862b.append("NOTE;").append(m3389a(c0833j.f2898d)).append(this.f2861a);
            }
            if (!TextUtils.isEmpty(c0833j.f2899e)) {
                this.f2862b.append("TITLE:").append(m3390a(c0833j.f2899e, i)).append(this.f2861a);
            }
            if (c0833j.f2900f != null) {
                m3392a(c0833j.f2900f, c0833j.f2901g, i);
            }
            if (c0833j.f2902h != null) {
                m3391a(c0833j.f2902h, i);
            }
            if (c0833j.f2903i != null) {
                m3394b(c0833j.f2903i, i);
            }
            if (c0833j.f2904j != null) {
                m3395c(c0833j.f2904j, i);
            }
            if (c0833j.f2905k != null) {
                m3396d(c0833j.f2905k, i);
            }
            if (c0833j.f2906l != null) {
                m3397e(c0833j.f2906l, i);
            }
            this.f2862b.append("END:VCARD").append(this.f2861a);
            return this.f2862b.toString();
        }
        throw new C0841r(" version not match VERSION_VCARD21 or VERSION_VCARD30.");
    }

    /* renamed from: a */
    private String m3390a(String str, int i) {
        String strSubstring;
        if (str.endsWith("\r\n")) {
            strSubstring = str.substring(0, str.length() - 2);
        } else {
            if (!str.endsWith("\n")) {
                return null;
            }
            strSubstring = str.substring(0, str.length() - 1);
        }
        String strReplaceAll = strSubstring.replaceAll("\r\n", "\n");
        if (i == 1) {
            return strReplaceAll.replaceAll("\n", "\r\n ");
        }
        if (i == 2) {
            return strReplaceAll.replaceAll("\n", "\n ");
        }
        return null;
    }

    /* renamed from: a */
    private void m3392a(byte[] bArr, String str, int i) {
        if (TextUtils.isEmpty(str)) {
        }
    }

    /* renamed from: a */
    private void m3391a(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0825b c0825b = (C0825b) it.next();
            if (!TextUtils.isEmpty(c0825b.f2864b)) {
                String strM3385a = m3385a(c0825b);
                if (i == 1) {
                    this.f2862b.append("TEL;");
                } else {
                    this.f2862b.append("TEL;TYPE=");
                }
                this.f2862b.append(strM3385a).append(";VOICE:").append(c0825b.f2864b).append(this.f2861a);
            }
        }
    }

    /* renamed from: a */
    private String m3385a(C0825b c0825b) {
        int i = c0825b.f2863a;
        if (f2856c.containsKey(Integer.valueOf(i))) {
            return (String) f2856c.get(Integer.valueOf(i));
        }
        if (i == 0) {
            String upperCase = c0825b.f2865c.toUpperCase();
            if (!upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "VOICE";
    }

    /* renamed from: b */
    private void m3394b(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0842s c0842s = (C0842s) it.next();
            if (!TextUtils.isEmpty(c0842s.f2922b)) {
                String strM3388a = m3388a(c0842s);
                if (i == 1) {
                    this.f2862b.append("EMAIL;");
                } else {
                    this.f2862b.append("EMAIL;TYPE=");
                }
                this.f2862b.append(strM3388a).append(";").append(m3389a(c0842s.f2922b)).append(this.f2861a);
            }
        }
    }

    /* renamed from: a */
    private String m3388a(C0842s c0842s) {
        int i = c0842s.f2921a;
        String upperCase = null;
        if (f2857d.containsKey(Integer.valueOf(i))) {
            return (String) f2857d.get(Integer.valueOf(i));
        }
        if (i == 0) {
            if (c0842s.f2923c != null) {
                upperCase = c0842s.f2923c.toUpperCase();
            }
            if (upperCase == null || !upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "EMAIL";
    }

    /* renamed from: c */
    private void m3395c(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0830g c0830g = (C0830g) it.next();
            if (!TextUtils.isEmpty(c0830g.f2875a) || !TextUtils.isEmpty(c0830g.f2876b) || !TextUtils.isEmpty(c0830g.f2877c) || !TextUtils.isEmpty(c0830g.f2878d) || !TextUtils.isEmpty(c0830g.f2879e) || !TextUtils.isEmpty(c0830g.f2880f) || !TextUtils.isEmpty(c0830g.f2881g)) {
                String strM3386a = m3386a(c0830g);
                if (i == 2 && strM3386a.indexOf(";") != -1) {
                    strM3386a = strM3386a.replace(";", "-");
                }
                if (i == 1) {
                    this.f2862b.append("ADR;");
                } else {
                    this.f2862b.append("ADR;TYPE=");
                }
                this.f2862b.append(strM3386a).append(":");
                if (!TextUtils.isEmpty(c0830g.f2875a)) {
                    this.f2862b.append(c0830g.f2875a).append(";");
                } else {
                    this.f2862b.append(";");
                }
                if (!TextUtils.isEmpty(c0830g.f2876b)) {
                    this.f2862b.append(c0830g.f2876b).append(";");
                } else {
                    this.f2862b.append(";");
                }
                if (!TextUtils.isEmpty(c0830g.f2877c)) {
                    this.f2862b.append(c0830g.f2877c).append(";");
                } else {
                    this.f2862b.append(";");
                }
                if (!TextUtils.isEmpty(c0830g.f2878d)) {
                    this.f2862b.append(c0830g.f2878d).append(";");
                } else {
                    this.f2862b.append(";");
                }
                if (!TextUtils.isEmpty(c0830g.f2879e)) {
                    this.f2862b.append(c0830g.f2879e).append(";");
                } else {
                    this.f2862b.append(";");
                }
                if (!TextUtils.isEmpty(c0830g.f2880f)) {
                    this.f2862b.append(c0830g.f2880f).append(";");
                } else {
                    this.f2862b.append(";");
                }
                if (!TextUtils.isEmpty(c0830g.f2881g)) {
                    this.f2862b.append(c0830g.f2881g).append(this.f2861a);
                } else {
                    this.f2862b.append(this.f2861a);
                }
            }
        }
    }

    /* renamed from: a */
    private String m3386a(C0830g c0830g) {
        int i = c0830g.f2882h;
        if (f2858e.containsKey(Integer.valueOf(i))) {
            return (String) f2858e.get(Integer.valueOf(i));
        }
        if (i == -1) {
            String upperCase = c0830g.f2883i.toUpperCase();
            if (!upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "POSTAL";
    }

    /* renamed from: d */
    private void m3396d(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0831h c0831h = (C0831h) it.next();
            if (Integer.valueOf(c0831h.f2886a) != null && !TextUtils.isEmpty(c0831h.f2889d)) {
                String strM3387a = m3387a(c0831h);
                if (i == 1) {
                    this.f2862b.append("IMPP;");
                } else {
                    this.f2862b.append("IMPP;TYPE=");
                }
                this.f2862b.append(strM3387a).append(":").append(c0831h.f2889d).append(this.f2861a);
            }
        }
    }

    /* renamed from: a */
    private String m3387a(C0831h c0831h) {
        int i = c0831h.f2888c;
        if (f2859f.containsKey(Integer.valueOf(i))) {
            return (String) f2859f.get(Integer.valueOf(i));
        }
        return "X-IMPP";
    }

    /* renamed from: e */
    private void m3397e(List list, int i) {
    }

    /* renamed from: a */
    private String m3389a(String str) {
        try {
            String[] strArrSplit = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
            }
            if (sb.toString().length() > 0) {
                return "CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + sb.toString().substring(0, sb.toString().length() - 1);
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            C1341p.m4651a("Cannot encode", "VCardComposer");
            return null;
        }
    }

    /* renamed from: b */
    private String m3393b(String str) {
        try {
            String[] strArrSplit = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
            }
            return sb.toString().substring(0, sb.toString().length() - 1);
        } catch (UnsupportedEncodingException e) {
            C1341p.m4651a("Cannot encode", "VCardComposer");
            return null;
        }
    }
}
