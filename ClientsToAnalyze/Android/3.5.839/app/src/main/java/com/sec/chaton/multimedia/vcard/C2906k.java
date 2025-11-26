package com.sec.chaton.multimedia.vcard;

import android.text.TextUtils;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

/* compiled from: VCardComposer.java */
/* renamed from: com.sec.chaton.multimedia.vcard.k */
/* loaded from: classes.dex */
public class C2906k {

    /* renamed from: c */
    private static final HashMap<Integer, String> f10760c = new HashMap<>();

    /* renamed from: d */
    private static final HashMap<Integer, String> f10761d = new HashMap<>();

    /* renamed from: e */
    private static final HashMap<Integer, String> f10762e = new HashMap<>();

    /* renamed from: f */
    private static final HashMap<Integer, String> f10763f = new HashMap<>();

    /* renamed from: g */
    private static final HashMap<Integer, String> f10764g = new HashMap<>();

    /* renamed from: a */
    private String f10765a;

    /* renamed from: b */
    private StringBuilder f10766b;

    static {
        f10760c.put(1, "HOME");
        f10760c.put(2, "CELL");
        f10760c.put(3, "WORK");
        f10760c.put(4, "WORK-FAX");
        f10760c.put(5, "HOME-FAX");
        f10760c.put(6, "PAGER");
        f10760c.put(7, "OTHER");
        f10760c.put(8, "CALLBACK");
        f10760c.put(9, "CAR");
        f10760c.put(10, "COMPANY_MAIN");
        f10760c.put(11, "ISDN");
        f10760c.put(12, "MAIN");
        f10760c.put(13, "OTHER_FAX");
        f10760c.put(14, "RADIO");
        f10760c.put(15, "TELEX");
        f10760c.put(16, "TTY_TDD");
        f10760c.put(17, "WORK_MOBILE");
        f10760c.put(18, "WORK_PAGER");
        f10760c.put(19, "ASSISTANT");
        f10760c.put(20, "MMS");
        f10761d.put(1, "HOME");
        f10761d.put(2, "WORK");
        f10761d.put(3, "OTHER");
        f10761d.put(4, "MOBILE");
        f10762e.put(1, "HOME");
        f10762e.put(2, "WORK");
        f10762e.put(3, "OTHER");
        f10763f.put(0, "X-AIM");
        f10763f.put(5, "X-GOOGLE_TALK");
        f10763f.put(6, "X-ICQ");
        f10763f.put(7, "X-JABBER");
        f10763f.put(1, "X-MSN");
        f10763f.put(8, "X-NETMEETING");
        f10763f.put(4, "X-QQ");
        f10763f.put(3, "X-SKYPE");
        f10763f.put(2, "X-YAHOO");
        f10764g.put(11, "OTHER");
        f10764g.put(8, "BDAY");
        f10764g.put(9, "ANNIVERSARY");
        f10764g.put(10, "WEBSITE");
    }

    /* renamed from: a */
    public String m12110a(C2897b c2897b, int i) throws Exception {
        this.f10766b = new StringBuilder();
        if ((c2897b.f10712a == null || c2897b.f10712a.trim().length() == 0) && (c2897b.f10713b == null || c2897b.f10713b.trim().length() == 0)) {
            if (!TextUtils.isEmpty(c2897b.f10714c)) {
                c2897b.f10712a = c2897b.f10714c;
            } else if (c2897b.f10717f != null) {
                if (!TextUtils.isEmpty(c2897b.f10717f.get(0).f10738b)) {
                    c2897b.f10712a = c2897b.f10717f.get(0).f10738b;
                } else {
                    c2897b.f10712a = "#";
                }
            } else if (c2897b.f10718g != null) {
                if (!TextUtils.isEmpty(c2897b.f10718g.get(0).f10729b)) {
                    c2897b.f10712a = c2897b.f10718g.get(0).f10729b;
                } else {
                    c2897b.f10712a = "#";
                }
            } else if (c2897b.f10719h != null && !TextUtils.isEmpty(c2897b.f10719h.get(0).f10743c)) {
                c2897b.f10712a = c2897b.f10719h.get(0).f10743c;
            } else {
                c2897b.f10712a = "#";
            }
        }
        if (i == 1 || i == 2) {
            this.f10765a = "\r\n";
            this.f10766b.append("BEGIN:VCARD").append(this.f10765a);
            if (i == 1) {
                this.f10766b.append("VERSION:2.1").append(this.f10765a);
            } else if (i == 2) {
                this.f10766b.append("VERSION:3.0").append(this.f10765a);
            } else if (i == 3) {
                this.f10766b.append("VERSION:4.0").append(this.f10765a);
            } else {
                this.f10766b.append("VERSION:2.1").append(this.f10765a);
            }
            if (!TextUtils.isEmpty(c2897b.f10712a)) {
                if (!TextUtils.isEmpty(c2897b.f10713b)) {
                    this.f10766b.append("N;").append(m12102a(c2897b.f10713b)).append(Config.KEYVALUE_SPLIT).append(m12105b(c2897b.f10712a)).append(this.f10765a);
                    this.f10766b.append("FN;").append(m12102a(c2897b.f10712a)).append(" ").append(m12105b(c2897b.f10713b)).append(this.f10765a);
                } else {
                    this.f10766b.append("N;").append(m12102a(c2897b.f10712a)).append(this.f10765a);
                    this.f10766b.append("FN;").append(m12102a(c2897b.f10712a)).append(this.f10765a);
                }
            } else if (!TextUtils.isEmpty(c2897b.f10713b)) {
                this.f10766b.append("N;").append(m12102a(c2897b.f10713b)).append(Config.KEYVALUE_SPLIT).append(this.f10765a);
                this.f10766b.append("FN;").append(m12102a(c2897b.f10713b)).append(this.f10765a);
            }
            if (!TextUtils.isEmpty(c2897b.f10714c)) {
                this.f10766b.append("ORG:").append(c2897b.f10714c).append(this.f10765a);
            }
            if (!TextUtils.isEmpty(c2897b.f10715d)) {
                this.f10766b.append("NOTE;").append(m12102a(c2897b.f10715d)).append(this.f10765a);
            }
            if (!TextUtils.isEmpty(c2897b.f10716e)) {
                this.f10766b.append("TITLE:").append(m12103a(c2897b.f10716e, i)).append(this.f10765a);
            }
            if (c2897b.f10717f != null) {
                m12104a(c2897b.f10717f, i);
            }
            if (c2897b.f10718g != null) {
                m12106b(c2897b.f10718g, i);
            }
            if (c2897b.f10719h != null) {
                m12107c(c2897b.f10719h, i);
            }
            if (c2897b.f10720i != null) {
                m12108d(c2897b.f10720i, i);
            }
            if (c2897b.f10721j != null) {
                m12109e(c2897b.f10721j, i);
            }
            this.f10766b.append("END:VCARD").append(this.f10765a);
            return this.f10766b.toString();
        }
        throw new Exception(" version not match VERSION_VCARD21 or VERSION_VCARD30.");
    }

    /* renamed from: a */
    private String m12103a(String str, int i) {
        String strSubstring;
        if (str.endsWith("\r\n")) {
            strSubstring = str.substring(0, str.length() - 2);
        } else if (str.endsWith("\n")) {
            strSubstring = str.substring(0, str.length() - 1);
        } else {
            return "";
        }
        String strReplaceAll = strSubstring.replaceAll("\r\n", "\n");
        if (i == 1) {
            return strReplaceAll.replaceAll("\n", "\r\n ");
        }
        if (i == 2) {
            return strReplaceAll.replaceAll("\n", "\n ");
        }
        return "";
    }

    /* renamed from: a */
    private void m12104a(List<C2901f> list, int i) {
        for (C2901f c2901f : list) {
            if (!TextUtils.isEmpty(c2901f.f10738b)) {
                String strM12100a = m12100a(c2901f);
                if (i == 1) {
                    this.f10766b.append("TEL;");
                } else {
                    this.f10766b.append("TEL;TYPE=");
                }
                this.f10766b.append(strM12100a).append(";VOICE:").append(c2901f.f10738b).append(this.f10765a);
            }
        }
    }

    /* renamed from: a */
    private String m12100a(C2901f c2901f) {
        int i = c2901f.f10737a;
        if (f10760c.containsKey(Integer.valueOf(i))) {
            return f10760c.get(Integer.valueOf(i));
        }
        if (i == 0) {
            String upperCase = c2901f.f10739c.toUpperCase();
            if (!upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "VOICE";
    }

    /* renamed from: b */
    private void m12106b(List<C2899d> list, int i) {
        for (C2899d c2899d : list) {
            if (!TextUtils.isEmpty(c2899d.f10729b)) {
                String strM12098a = m12098a(c2899d);
                if (i == 1) {
                    this.f10766b.append("EMAIL;");
                } else {
                    this.f10766b.append("EMAIL;TYPE=");
                }
                this.f10766b.append(strM12098a).append(Config.KEYVALUE_SPLIT).append(m12102a(c2899d.f10729b)).append(this.f10765a);
            }
        }
    }

    /* renamed from: a */
    private String m12098a(C2899d c2899d) {
        int i = c2899d.f10728a;
        if (f10761d.containsKey(Integer.valueOf(i))) {
            return f10761d.get(Integer.valueOf(i));
        }
        if (i == 0) {
            String upperCase = c2899d.f10730c != null ? c2899d.f10730c.toUpperCase() : "";
            if (upperCase == null || !upperCase.startsWith("X-")) {
                if (upperCase == null) {
                    return null;
                }
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "EMAIL";
    }

    /* renamed from: c */
    private void m12107c(List<C2902g> list, int i) {
        for (C2902g c2902g : list) {
            if (!TextUtils.isEmpty(c2902g.f10741a) || !TextUtils.isEmpty(c2902g.f10742b) || !TextUtils.isEmpty(c2902g.f10743c) || !TextUtils.isEmpty(c2902g.f10744d) || !TextUtils.isEmpty(c2902g.f10745e) || !TextUtils.isEmpty(c2902g.f10746f) || !TextUtils.isEmpty(c2902g.f10747g)) {
                String strM12101a = m12101a(c2902g);
                if (i == 2 && strM12101a.indexOf(Config.KEYVALUE_SPLIT) != -1) {
                    strM12101a = strM12101a.replace(Config.KEYVALUE_SPLIT, "-");
                }
                if (i == 1) {
                    this.f10766b.append("ADR;");
                } else {
                    this.f10766b.append("ADR;TYPE=");
                }
                this.f10766b.append(strM12101a).append(":");
                if (!TextUtils.isEmpty(c2902g.f10741a)) {
                    this.f10766b.append(c2902g.f10741a).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f10766b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c2902g.f10742b)) {
                    this.f10766b.append(c2902g.f10742b).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f10766b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c2902g.f10743c)) {
                    this.f10766b.append(c2902g.f10743c).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f10766b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c2902g.f10744d)) {
                    this.f10766b.append(c2902g.f10744d).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f10766b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c2902g.f10745e)) {
                    this.f10766b.append(c2902g.f10745e).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f10766b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c2902g.f10746f)) {
                    this.f10766b.append(c2902g.f10746f).append(Config.KEYVALUE_SPLIT);
                } else {
                    this.f10766b.append(Config.KEYVALUE_SPLIT);
                }
                if (!TextUtils.isEmpty(c2902g.f10747g)) {
                    this.f10766b.append(c2902g.f10747g).append(this.f10765a);
                } else {
                    this.f10766b.append(this.f10765a);
                }
            }
        }
    }

    /* renamed from: a */
    private String m12101a(C2902g c2902g) {
        int i = c2902g.f10748h;
        if (f10762e.containsKey(Integer.valueOf(i))) {
            return f10762e.get(Integer.valueOf(i));
        }
        if (i == -1) {
            String upperCase = c2902g.f10749i.toUpperCase();
            if (!upperCase.startsWith("X-")) {
                return "X-CUSTOM-" + upperCase;
            }
            return upperCase;
        }
        return "POSTAL";
    }

    /* renamed from: d */
    private void m12108d(List<C2900e> list, int i) {
        for (C2900e c2900e : list) {
            if (Integer.valueOf(c2900e.f10732a) != null && !TextUtils.isEmpty(c2900e.f10735d)) {
                String strM12099a = m12099a(c2900e);
                if (i == 1) {
                    this.f10766b.append("IMPP;");
                } else {
                    this.f10766b.append("IMPP;TYPE=");
                }
                this.f10766b.append(strM12099a).append(":").append(c2900e.f10735d).append(this.f10765a);
            }
        }
    }

    /* renamed from: a */
    private String m12099a(C2900e c2900e) {
        int i = c2900e.f10734c;
        if (f10763f.containsKey(Integer.valueOf(i))) {
            return f10763f.get(Integer.valueOf(i));
        }
        return "X-IMPP";
    }

    /* renamed from: e */
    private void m12109e(List<C2898c> list, int i) {
    }

    /* renamed from: a */
    private String m12102a(String str) {
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
                C4904y.m18634a("Cannot encode", "VCardComposer");
                return "";
            }
        }
        return "";
    }

    /* renamed from: b */
    private String m12105b(String str) {
        if (str != null) {
            try {
                String[] strArrSplit = str.split(" ");
                StringBuilder sb = new StringBuilder();
                for (String str2 : strArrSplit) {
                    sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
                }
                return sb.toString().substring(0, sb.toString().length() - 1);
            } catch (UnsupportedEncodingException e) {
                C4904y.m18634a("Cannot encode", "VCardComposer");
            }
        }
        return "";
    }
}
