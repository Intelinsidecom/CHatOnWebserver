package com.sec.chaton.multimedia.vcard;

import android.text.TextUtils;
import com.sec.chaton.util.C1786r;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import weibo4android.org.json.HTTP;

/* compiled from: VCardComposer.java */
/* renamed from: com.sec.chaton.multimedia.vcard.p */
/* loaded from: classes.dex */
public class C1046p {

    /* renamed from: c */
    private static final HashMap f3893c = new HashMap();

    /* renamed from: d */
    private static final HashMap f3894d = new HashMap();

    /* renamed from: e */
    private static final HashMap f3895e = new HashMap();

    /* renamed from: f */
    private static final HashMap f3896f = new HashMap();

    /* renamed from: g */
    private static final HashMap f3897g = new HashMap();

    /* renamed from: a */
    private String f3898a;

    /* renamed from: b */
    private StringBuilder f3899b;

    static {
        f3893c.put(1, "HOME");
        f3893c.put(2, "CELL");
        f3893c.put(3, "WORK");
        f3893c.put(4, "WORK-FAX");
        f3893c.put(5, "HOME-FAX");
        f3893c.put(6, "PAGER");
        f3893c.put(7, "OTHER");
        f3893c.put(8, "CALLBACK");
        f3893c.put(9, "CAR");
        f3893c.put(10, "COMPANY_MAIN");
        f3893c.put(11, "ISDN");
        f3893c.put(12, "MAIN");
        f3893c.put(13, "OTHER_FAX");
        f3893c.put(14, "RADIO");
        f3893c.put(15, "TELEX");
        f3893c.put(16, "TTY_TDD");
        f3893c.put(17, "WORK_MOBILE");
        f3893c.put(18, "WORK_PAGER");
        f3893c.put(19, "ASSISTANT");
        f3893c.put(20, "MMS");
        f3894d.put(1, "HOME");
        f3894d.put(2, "WORK");
        f3894d.put(3, "OTHER");
        f3894d.put(4, "MOBILE");
        f3895e.put(1, "HOME");
        f3895e.put(2, "WORK");
        f3895e.put(3, "OTHER");
        f3896f.put(0, "X-AIM");
        f3896f.put(5, "X-GOOGLE_TALK");
        f3896f.put(6, "X-ICQ");
        f3896f.put(7, "X-JABBER");
        f3896f.put(1, "X-MSN");
        f3896f.put(8, "X-NETMEETING");
        f3896f.put(4, "X-QQ");
        f3896f.put(3, "X-SKYPE");
        f3896f.put(2, "X-YAHOO");
        f3897g.put(11, "OTHER");
        f3897g.put(8, "BDAY");
        f3897g.put(9, "ANNIVERSARY");
        f3897g.put(10, "WEBSITE");
    }

    /* renamed from: a */
    public String m4043a(C1038h c1038h, int i) throws C1047q {
        this.f3899b = new StringBuilder();
        if ((c1038h.f3843a == null || c1038h.f3843a.trim().length() == 0) && (c1038h.f3844b == null || c1038h.f3844b.trim().length() == 0)) {
            if (!TextUtils.isEmpty(c1038h.f3845c)) {
                c1038h.f3843a = c1038h.f3845c;
            } else if (c1038h.f3850h != null) {
                if (!TextUtils.isEmpty(((C1042l) c1038h.f3850h.get(0)).f3871b)) {
                    c1038h.f3843a = ((C1042l) c1038h.f3850h.get(0)).f3871b;
                } else {
                    c1038h.f3843a = "#";
                }
            } else if (c1038h.f3851i != null) {
                if (!TextUtils.isEmpty(((C1040j) c1038h.f3851i.get(0)).f3862b)) {
                    c1038h.f3843a = ((C1040j) c1038h.f3851i.get(0)).f3862b;
                } else {
                    c1038h.f3843a = "#";
                }
            } else if (c1038h.f3852j != null && !TextUtils.isEmpty(((C1043m) c1038h.f3852j.get(0)).f3876c)) {
                c1038h.f3843a = ((C1043m) c1038h.f3852j.get(0)).f3876c;
            } else {
                c1038h.f3843a = "#";
            }
        }
        if (i == 1 || i == 2) {
            this.f3898a = HTTP.CRLF;
            this.f3899b.append("BEGIN:VCARD").append(this.f3898a);
            if (i == 1) {
                this.f3899b.append("VERSION:2.1").append(this.f3898a);
            } else if (i == 2) {
                this.f3899b.append("VERSION:3.0").append(this.f3898a);
            } else if (i == 3) {
                this.f3899b.append("VERSION:4.0").append(this.f3898a);
            } else {
                this.f3899b.append("VERSION:2.1").append(this.f3898a);
            }
            if (!TextUtils.isEmpty(c1038h.f3843a)) {
                if (!TextUtils.isEmpty(c1038h.f3844b)) {
                    this.f3899b.append("N;").append(m4034a(c1038h.f3844b)).append(";").append(m4038b(c1038h.f3843a)).append(this.f3898a);
                    this.f3899b.append("FN;").append(m4034a(c1038h.f3843a)).append(" ").append(m4038b(c1038h.f3844b)).append(this.f3898a);
                } else {
                    this.f3899b.append("N;").append(m4034a(c1038h.f3843a)).append(this.f3898a);
                    this.f3899b.append("FN;").append(m4034a(c1038h.f3843a)).append(this.f3898a);
                }
            } else if (!TextUtils.isEmpty(c1038h.f3844b)) {
                this.f3899b.append("N;").append(m4034a(c1038h.f3844b)).append(";").append(this.f3898a);
                this.f3899b.append("FN;").append(m4034a(c1038h.f3844b)).append(this.f3898a);
            }
            if (!TextUtils.isEmpty(c1038h.f3845c)) {
                this.f3899b.append("ORG:").append(c1038h.f3845c).append(this.f3898a);
            }
            if (!TextUtils.isEmpty(c1038h.f3846d)) {
                this.f3899b.append("NOTE;").append(m4034a(c1038h.f3846d)).append(this.f3898a);
            }
            if (!TextUtils.isEmpty(c1038h.f3847e)) {
                this.f3899b.append("TITLE:").append(m4035a(c1038h.f3847e, i)).append(this.f3898a);
            }
            if (c1038h.f3848f != null) {
                m4037a(c1038h.f3848f, c1038h.f3849g, i);
            }
            if (c1038h.f3850h != null) {
                m4036a(c1038h.f3850h, i);
            }
            if (c1038h.f3851i != null) {
                m4039b(c1038h.f3851i, i);
            }
            if (c1038h.f3852j != null) {
                m4040c(c1038h.f3852j, i);
            }
            if (c1038h.f3853k != null) {
                m4041d(c1038h.f3853k, i);
            }
            if (c1038h.f3854l != null) {
                m4042e(c1038h.f3854l, i);
            }
            this.f3899b.append("END:VCARD").append(this.f3898a);
            return this.f3899b.toString();
        }
        throw new C1047q(" version not match VERSION_VCARD21 or VERSION_VCARD30.");
    }

    /* renamed from: a */
    private String m4035a(String str, int i) {
        String strSubstring;
        if (str.endsWith(HTTP.CRLF)) {
            strSubstring = str.substring(0, str.length() - 2);
        } else {
            if (!str.endsWith("\n")) {
                return null;
            }
            strSubstring = str.substring(0, str.length() - 1);
        }
        String strReplaceAll = strSubstring.replaceAll(HTTP.CRLF, "\n");
        if (i == 1) {
            return strReplaceAll.replaceAll("\n", "\r\n ");
        }
        if (i == 2) {
            return strReplaceAll.replaceAll("\n", "\n ");
        }
        return null;
    }

    /* renamed from: a */
    private void m4037a(byte[] bArr, String str, int i) {
        if (TextUtils.isEmpty(str)) {
        }
    }

    /* renamed from: a */
    private void m4036a(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1042l c1042l = (C1042l) it.next();
            if (!TextUtils.isEmpty(c1042l.f3871b)) {
                String strM4032a = m4032a(c1042l);
                if (i == 1) {
                    this.f3899b.append("TEL;");
                } else {
                    this.f3899b.append("TEL;TYPE=");
                }
                this.f3899b.append(strM4032a).append(";VOICE:").append(c1042l.f3871b).append(this.f3898a);
            }
        }
    }

    /* renamed from: a */
    private String m4032a(C1042l c1042l) {
        int i = c1042l.f3870a;
        if (f3893c.containsKey(Integer.valueOf(i))) {
            return (String) f3893c.get(Integer.valueOf(i));
        }
        if (i == 0) {
            String upperCase = c1042l.f3872c.toUpperCase();
            if (!upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "VOICE";
    }

    /* renamed from: b */
    private void m4039b(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1040j c1040j = (C1040j) it.next();
            if (!TextUtils.isEmpty(c1040j.f3862b)) {
                String strM4030a = m4030a(c1040j);
                if (i == 1) {
                    this.f3899b.append("EMAIL;");
                } else {
                    this.f3899b.append("EMAIL;TYPE=");
                }
                this.f3899b.append(strM4030a).append(";").append(m4034a(c1040j.f3862b)).append(this.f3898a);
            }
        }
    }

    /* renamed from: a */
    private String m4030a(C1040j c1040j) {
        int i = c1040j.f3861a;
        String upperCase = null;
        if (f3894d.containsKey(Integer.valueOf(i))) {
            return (String) f3894d.get(Integer.valueOf(i));
        }
        if (i == 0) {
            if (c1040j.f3863c != null) {
                upperCase = c1040j.f3863c.toUpperCase();
            }
            if (!upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "EMAIL";
    }

    /* renamed from: c */
    private void m4040c(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1043m c1043m = (C1043m) it.next();
            if (!TextUtils.isEmpty(c1043m.f3874a) || !TextUtils.isEmpty(c1043m.f3875b) || !TextUtils.isEmpty(c1043m.f3876c) || !TextUtils.isEmpty(c1043m.f3877d) || !TextUtils.isEmpty(c1043m.f3878e) || !TextUtils.isEmpty(c1043m.f3879f) || !TextUtils.isEmpty(c1043m.f3880g)) {
                String strM4033a = m4033a(c1043m);
                if (i == 2 && strM4033a.indexOf(";") != -1) {
                    strM4033a = strM4033a.replace(";", "-");
                }
                if (i == 1) {
                    this.f3899b.append("ADR;");
                } else {
                    this.f3899b.append("ADR;TYPE=");
                }
                this.f3899b.append(strM4033a).append(":");
                if (!TextUtils.isEmpty(c1043m.f3874a)) {
                    this.f3899b.append(c1043m.f3874a).append(";");
                } else {
                    this.f3899b.append(";");
                }
                if (!TextUtils.isEmpty(c1043m.f3875b)) {
                    this.f3899b.append(c1043m.f3875b).append(";");
                } else {
                    this.f3899b.append(";");
                }
                if (!TextUtils.isEmpty(c1043m.f3876c)) {
                    this.f3899b.append(c1043m.f3876c).append(";");
                } else {
                    this.f3899b.append(";");
                }
                if (!TextUtils.isEmpty(c1043m.f3877d)) {
                    this.f3899b.append(c1043m.f3877d).append(";");
                } else {
                    this.f3899b.append(";");
                }
                if (!TextUtils.isEmpty(c1043m.f3878e)) {
                    this.f3899b.append(c1043m.f3878e).append(";");
                } else {
                    this.f3899b.append(";");
                }
                if (!TextUtils.isEmpty(c1043m.f3879f)) {
                    this.f3899b.append(c1043m.f3879f).append(";");
                } else {
                    this.f3899b.append(";");
                }
                if (!TextUtils.isEmpty(c1043m.f3880g)) {
                    this.f3899b.append(c1043m.f3880g).append(this.f3898a);
                } else {
                    this.f3899b.append(this.f3898a);
                }
            }
        }
    }

    /* renamed from: a */
    private String m4033a(C1043m c1043m) {
        int i = c1043m.f3881h;
        if (f3895e.containsKey(Integer.valueOf(i))) {
            return (String) f3895e.get(Integer.valueOf(i));
        }
        if (i == -1) {
            String upperCase = c1043m.f3882i.toUpperCase();
            if (!upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "POSTAL";
    }

    /* renamed from: d */
    private void m4041d(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1041k c1041k = (C1041k) it.next();
            if (Integer.valueOf(c1041k.f3865a) != null && !TextUtils.isEmpty(c1041k.f3868d)) {
                String strM4031a = m4031a(c1041k);
                if (i == 1) {
                    this.f3899b.append("IMPP;");
                } else {
                    this.f3899b.append("IMPP;TYPE=");
                }
                this.f3899b.append(strM4031a).append(":").append(c1041k.f3868d).append(this.f3898a);
            }
        }
    }

    /* renamed from: a */
    private String m4031a(C1041k c1041k) {
        int i = c1041k.f3867c;
        if (f3896f.containsKey(Integer.valueOf(i))) {
            return (String) f3896f.get(Integer.valueOf(i));
        }
        return "X-IMPP";
    }

    /* renamed from: e */
    private void m4042e(List list, int i) {
    }

    /* renamed from: a */
    private String m4034a(String str) {
        try {
            String[] strArrSplit = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
            }
            return "CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + sb.toString().substring(0, sb.toString().length() - 1);
        } catch (UnsupportedEncodingException e) {
            C1786r.m6054a("Cannot encode", "VCardComposer");
            return null;
        }
    }

    /* renamed from: b */
    private String m4038b(String str) {
        try {
            String[] strArrSplit = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
            }
            return sb.toString().substring(0, sb.toString().length() - 1);
        } catch (UnsupportedEncodingException e) {
            C1786r.m6054a("Cannot encode", "VCardComposer");
            return null;
        }
    }
}
