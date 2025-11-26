package com.sec.chaton.multimedia.vcard;

import android.text.TextUtils;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import weibo4android.org.json.HTTP;

/* compiled from: VCardComposer.java */
/* renamed from: com.sec.chaton.multimedia.vcard.k */
/* loaded from: classes.dex */
public class C1937k {

    /* renamed from: c */
    private static final HashMap<Integer, String> f7439c = new HashMap<>();

    /* renamed from: d */
    private static final HashMap<Integer, String> f7440d = new HashMap<>();

    /* renamed from: e */
    private static final HashMap<Integer, String> f7441e = new HashMap<>();

    /* renamed from: f */
    private static final HashMap<Integer, String> f7442f = new HashMap<>();

    /* renamed from: g */
    private static final HashMap<Integer, String> f7443g = new HashMap<>();

    /* renamed from: a */
    private String f7444a;

    /* renamed from: b */
    private StringBuilder f7445b;

    static {
        f7439c.put(1, "HOME");
        f7439c.put(2, "CELL");
        f7439c.put(3, "WORK");
        f7439c.put(4, "WORK-FAX");
        f7439c.put(5, "HOME-FAX");
        f7439c.put(6, "PAGER");
        f7439c.put(7, "OTHER");
        f7439c.put(8, "CALLBACK");
        f7439c.put(9, "CAR");
        f7439c.put(10, "COMPANY_MAIN");
        f7439c.put(11, "ISDN");
        f7439c.put(12, "MAIN");
        f7439c.put(13, "OTHER_FAX");
        f7439c.put(14, "RADIO");
        f7439c.put(15, "TELEX");
        f7439c.put(16, "TTY_TDD");
        f7439c.put(17, "WORK_MOBILE");
        f7439c.put(18, "WORK_PAGER");
        f7439c.put(19, "ASSISTANT");
        f7439c.put(20, "MMS");
        f7440d.put(1, "HOME");
        f7440d.put(2, "WORK");
        f7440d.put(3, "OTHER");
        f7440d.put(4, "MOBILE");
        f7441e.put(1, "HOME");
        f7441e.put(2, "WORK");
        f7441e.put(3, "OTHER");
        f7442f.put(0, "X-AIM");
        f7442f.put(5, "X-GOOGLE_TALK");
        f7442f.put(6, "X-ICQ");
        f7442f.put(7, "X-JABBER");
        f7442f.put(1, "X-MSN");
        f7442f.put(8, "X-NETMEETING");
        f7442f.put(4, "X-QQ");
        f7442f.put(3, "X-SKYPE");
        f7442f.put(2, "X-YAHOO");
        f7443g.put(11, "OTHER");
        f7443g.put(8, "BDAY");
        f7443g.put(9, "ANNIVERSARY");
        f7443g.put(10, "WEBSITE");
    }

    /* renamed from: a */
    public String m7882a(C1928b c1928b, int i) throws Exception {
        this.f7445b = new StringBuilder();
        if ((c1928b.f7391a == null || c1928b.f7391a.trim().length() == 0) && (c1928b.f7392b == null || c1928b.f7392b.trim().length() == 0)) {
            if (!TextUtils.isEmpty(c1928b.f7393c)) {
                c1928b.f7391a = c1928b.f7393c;
            } else if (c1928b.f7396f != null) {
                if (!TextUtils.isEmpty(c1928b.f7396f.get(0).f7417b)) {
                    c1928b.f7391a = c1928b.f7396f.get(0).f7417b;
                } else {
                    c1928b.f7391a = "#";
                }
            } else if (c1928b.f7397g != null) {
                if (!TextUtils.isEmpty(c1928b.f7397g.get(0).f7408b)) {
                    c1928b.f7391a = c1928b.f7397g.get(0).f7408b;
                } else {
                    c1928b.f7391a = "#";
                }
            } else if (c1928b.f7398h != null && !TextUtils.isEmpty(c1928b.f7398h.get(0).f7422c)) {
                c1928b.f7391a = c1928b.f7398h.get(0).f7422c;
            } else {
                c1928b.f7391a = "#";
            }
        }
        if (i == 1 || i == 2) {
            this.f7444a = HTTP.CRLF;
            this.f7445b.append("BEGIN:VCARD").append(this.f7444a);
            if (i == 1) {
                this.f7445b.append("VERSION:2.1").append(this.f7444a);
            } else if (i == 2) {
                this.f7445b.append("VERSION:3.0").append(this.f7444a);
            } else if (i == 3) {
                this.f7445b.append("VERSION:4.0").append(this.f7444a);
            } else {
                this.f7445b.append("VERSION:2.1").append(this.f7444a);
            }
            if (!TextUtils.isEmpty(c1928b.f7391a)) {
                if (!TextUtils.isEmpty(c1928b.f7392b)) {
                    this.f7445b.append("N;").append(m7874a(c1928b.f7392b)).append(Config.KEYVALUE_SPLIT).append(m7877b(c1928b.f7391a)).append(this.f7444a);
                    this.f7445b.append("FN;").append(m7874a(c1928b.f7391a)).append(" ").append(m7877b(c1928b.f7392b)).append(this.f7444a);
                } else {
                    this.f7445b.append("N;").append(m7874a(c1928b.f7391a)).append(this.f7444a);
                    this.f7445b.append("FN;").append(m7874a(c1928b.f7391a)).append(this.f7444a);
                }
            } else if (!TextUtils.isEmpty(c1928b.f7392b)) {
                this.f7445b.append("N;").append(m7874a(c1928b.f7392b)).append(Config.KEYVALUE_SPLIT).append(this.f7444a);
                this.f7445b.append("FN;").append(m7874a(c1928b.f7392b)).append(this.f7444a);
            }
            if (!TextUtils.isEmpty(c1928b.f7393c)) {
                this.f7445b.append("ORG:").append(c1928b.f7393c).append(this.f7444a);
            }
            if (!TextUtils.isEmpty(c1928b.f7394d)) {
                this.f7445b.append("NOTE;").append(m7874a(c1928b.f7394d)).append(this.f7444a);
            }
            if (!TextUtils.isEmpty(c1928b.f7395e)) {
                this.f7445b.append("TITLE:").append(m7875a(c1928b.f7395e, i)).append(this.f7444a);
            }
            if (c1928b.f7396f != null) {
                m7876a(c1928b.f7396f, i);
            }
            if (c1928b.f7397g != null) {
                m7878b(c1928b.f7397g, i);
            }
            if (c1928b.f7398h != null) {
                m7879c(c1928b.f7398h, i);
            }
            if (c1928b.f7399i != null) {
                m7880d(c1928b.f7399i, i);
            }
            if (c1928b.f7400j != null) {
                m7881e(c1928b.f7400j, i);
            }
            this.f7445b.append("END:VCARD").append(this.f7444a);
            return this.f7445b.toString();
        }
        throw new Exception(" version not match VERSION_VCARD21 or VERSION_VCARD30.");
    }

    /* renamed from: a */
    private String m7875a(String str, int i) {
        String strSubstring;
        if (str.endsWith(HTTP.CRLF)) {
            strSubstring = str.substring(0, str.length() - 2);
        } else if (str.endsWith("\n")) {
            strSubstring = str.substring(0, str.length() - 1);
        } else {
            return "";
        }
        String strReplaceAll = strSubstring.replaceAll(HTTP.CRLF, "\n");
        if (i == 1) {
            return strReplaceAll.replaceAll("\n", "\r\n ");
        }
        if (i == 2) {
            return strReplaceAll.replaceAll("\n", "\n ");
        }
        return "";
    }

    /* renamed from: a */
    private void m7876a(List<C1932f> list, int i) {
        for (C1932f c1932f : list) {
            if (!TextUtils.isEmpty(c1932f.f7417b)) {
                String strM7872a = m7872a(c1932f);
                if (i == 1) {
                    this.f7445b.append("TEL;");
                } else {
                    this.f7445b.append("TEL;TYPE=");
                }
                this.f7445b.append(strM7872a).append(";VOICE:").append(c1932f.f7417b).append(this.f7444a);
            }
        }
    }

    /* renamed from: a */
    private String m7872a(C1932f c1932f) {
        int i = c1932f.f7416a;
        if (f7439c.containsKey(Integer.valueOf(i))) {
            return f7439c.get(Integer.valueOf(i));
        }
        if (i == 0) {
            String upperCase = c1932f.f7418c.toUpperCase();
            if (!upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "VOICE";
    }

    /* renamed from: b */
    private void m7878b(List<C1930d> list, int i) {
        for (C1930d c1930d : list) {
            if (!TextUtils.isEmpty(c1930d.f7408b)) {
                String strM7870a = m7870a(c1930d);
                if (i == 1) {
                    this.f7445b.append("EMAIL;");
                } else {
                    this.f7445b.append("EMAIL;TYPE=");
                }
                this.f7445b.append(strM7870a).append(Config.KEYVALUE_SPLIT).append(m7874a(c1930d.f7408b)).append(this.f7444a);
            }
        }
    }

    /* renamed from: a */
    private String m7870a(C1930d c1930d) {
        int i = c1930d.f7407a;
        String upperCase = "";
        if (f7440d.containsKey(Integer.valueOf(i))) {
            return f7440d.get(Integer.valueOf(i));
        }
        if (i == 0) {
            if (c1930d.f7409c != null) {
                upperCase = c1930d.f7409c.toUpperCase();
            }
            if (upperCase == null || !upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "EMAIL";
    }

    /* renamed from: c */
    private void m7879c(List<C1933g> list, int i) {
        for (C1933g c1933g : list) {
            if (!TextUtils.isEmpty(c1933g.f7420a) || !TextUtils.isEmpty(c1933g.f7421b) || !TextUtils.isEmpty(c1933g.f7422c) || !TextUtils.isEmpty(c1933g.f7423d) || !TextUtils.isEmpty(c1933g.f7424e) || !TextUtils.isEmpty(c1933g.f7425f) || !TextUtils.isEmpty(c1933g.f7426g)) {
                String strM7873a = m7873a(c1933g);
                if (i == 2 && strM7873a.indexOf(Config.KEYVALUE_SPLIT) != -1) {
                    strM7873a = strM7873a.replace(Config.KEYVALUE_SPLIT, "-");
                }
                if (i == 1) {
                    this.f7445b.append("ADR;");
                } else {
                    this.f7445b.append("ADR;TYPE=");
                }
                this.f7445b.append(strM7873a).append(":");
                if (!TextUtils.isEmpty(c1933g.f7420a)) {
                    this.f7445b.append(c1933g.f7420a).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f7445b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c1933g.f7421b)) {
                    this.f7445b.append(c1933g.f7421b).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f7445b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c1933g.f7422c)) {
                    this.f7445b.append(c1933g.f7422c).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f7445b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c1933g.f7423d)) {
                    this.f7445b.append(c1933g.f7423d).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f7445b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c1933g.f7424e)) {
                    this.f7445b.append(c1933g.f7424e).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f7445b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c1933g.f7425f)) {
                    this.f7445b.append(c1933g.f7425f).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f7445b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c1933g.f7426g)) {
                    this.f7445b.append(c1933g.f7426g).append(this.f7444a);
                } else {
                    this.f7445b.append(this.f7444a);
                }
            }
        }
    }

    /* renamed from: a */
    private String m7873a(C1933g c1933g) {
        int i = c1933g.f7427h;
        if (f7441e.containsKey(Integer.valueOf(i))) {
            return f7441e.get(Integer.valueOf(i));
        }
        if (i == -1) {
            String upperCase = c1933g.f7428i.toUpperCase();
            if (!upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "POSTAL";
    }

    /* renamed from: d */
    private void m7880d(List<C1931e> list, int i) {
        for (C1931e c1931e : list) {
            if (Integer.valueOf(c1931e.f7411a) != null && !TextUtils.isEmpty(c1931e.f7414d)) {
                String strM7871a = m7871a(c1931e);
                if (i == 1) {
                    this.f7445b.append("IMPP;");
                } else {
                    this.f7445b.append("IMPP;TYPE=");
                }
                this.f7445b.append(strM7871a).append(":").append(c1931e.f7414d).append(this.f7444a);
            }
        }
    }

    /* renamed from: a */
    private String m7871a(C1931e c1931e) {
        int i = c1931e.f7413c;
        if (f7442f.containsKey(Integer.valueOf(i))) {
            return f7442f.get(Integer.valueOf(i));
        }
        return "X-IMPP";
    }

    /* renamed from: e */
    private void m7881e(List<C1929c> list, int i) {
    }

    /* renamed from: a */
    private String m7874a(String str) {
        if (str != null) {
            try {
                String[] strArrSplit = str.split(" ");
                StringBuilder sb = new StringBuilder();
                for (String str2 : strArrSplit) {
                    sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
                }
                if (sb.toString().length() > 0) {
                    return "CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + sb.toString().substring(0, sb.toString().length() - 1);
                }
            } catch (UnsupportedEncodingException e) {
                C3250y.m11442a("Cannot encode", "VCardComposer");
                return "";
            }
        }
        return "";
    }

    /* renamed from: b */
    private String m7877b(String str) {
        if (str != null) {
            try {
                String[] strArrSplit = str.split(" ");
                StringBuilder sb = new StringBuilder();
                for (String str2 : strArrSplit) {
                    sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
                }
                return sb.toString().substring(0, sb.toString().length() - 1);
            } catch (UnsupportedEncodingException e) {
                C3250y.m11442a("Cannot encode", "VCardComposer");
            }
        }
        return "";
    }
}
