package com.sec.chaton.multimedia.vcard;

import com.sec.chaton.multimedia.vcard.ContactStruct;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VCardComposer {

    /* renamed from: c */
    private static final HashMap f2336c = new HashMap();

    /* renamed from: d */
    private static final HashMap f2337d = new HashMap();

    /* renamed from: e */
    private static final HashMap f2338e = new HashMap();

    /* renamed from: f */
    private static final HashMap f2339f = new HashMap();

    /* renamed from: g */
    private static final HashMap f2340g = new HashMap();

    /* renamed from: a */
    private String f2341a;

    /* renamed from: b */
    private StringBuilder f2342b;

    static {
        f2336c.put(1, "HOME");
        f2336c.put(2, "CELL");
        f2336c.put(3, "WORK");
        f2336c.put(4, "WORK-FAX");
        f2336c.put(5, "HOME-FAX");
        f2336c.put(6, "PAGER");
        f2336c.put(7, "OTHER");
        f2336c.put(8, "CALLBACK");
        f2336c.put(9, "CAR");
        f2336c.put(10, "COMPANY_MAIN");
        f2336c.put(11, "ISDN");
        f2336c.put(12, "MAIN");
        f2336c.put(13, "OTHER_FAX");
        f2336c.put(14, "RADIO");
        f2336c.put(15, "TELEX");
        f2336c.put(16, "TTY_TDD");
        f2336c.put(17, "WORK_MOBILE");
        f2336c.put(18, "WORK_PAGER");
        f2336c.put(19, "ASSISTANT");
        f2336c.put(20, "MMS");
        f2337d.put(1, "HOME");
        f2337d.put(2, "WORK");
        f2337d.put(3, "OTHER");
        f2337d.put(4, "MOBILE");
        f2338e.put(1, "HOME");
        f2338e.put(2, "WORK");
        f2338e.put(3, "OTHER");
        f2339f.put(0, "X-AIM");
        f2339f.put(5, "X-GOOGLE_TALK");
        f2339f.put(6, "X-ICQ");
        f2339f.put(7, "X-JABBER");
        f2339f.put(1, "X-MSN");
        f2339f.put(8, "X-NETMEETING");
        f2339f.put(4, "X-QQ");
        f2339f.put(3, "X-SKYPE");
        f2339f.put(2, "X-YAHOO");
        f2340g.put(11, "OTHER");
        f2340g.put(8, "BDAY");
        f2340g.put(9, "ANNIVERSARY");
        f2340g.put(10, "WEBSITE");
    }

    /* renamed from: a */
    private String m2628a(ContactStruct.EmailData emailData) {
        int i = emailData.f2299a;
        if (f2337d.containsKey(Integer.valueOf(i))) {
            return (String) f2337d.get(Integer.valueOf(i));
        }
        if (i != 0) {
            return "EMAIL";
        }
        String upperCase = emailData.f2301c.toUpperCase();
        return !upperCase.startsWith("X-") ? "X-CUSTOM-" + upperCase : upperCase;
    }

    /* renamed from: a */
    private String m2629a(ContactStruct.ImData imData) {
        int i = imData.f2305c;
        return f2339f.containsKey(Integer.valueOf(i)) ? (String) f2339f.get(Integer.valueOf(i)) : "X-IMPP";
    }

    /* renamed from: a */
    private String m2630a(ContactStruct.PhoneData phoneData) {
        int i = phoneData.f2308a;
        if (f2336c.containsKey(Integer.valueOf(i))) {
            return (String) f2336c.get(Integer.valueOf(i));
        }
        if (i != 0) {
            return "VOICE";
        }
        String upperCase = phoneData.f2310c.toUpperCase();
        return !upperCase.startsWith("X-") ? "X-CUSTOM-" + upperCase : upperCase;
    }

    /* renamed from: a */
    private String m2631a(ContactStruct.PostalData postalData) {
        int i = postalData.f2319h;
        if (f2338e.containsKey(Integer.valueOf(i))) {
            return (String) f2338e.get(Integer.valueOf(i));
        }
        if (i != -1) {
            return "POSTAL";
        }
        String upperCase = postalData.f2320i.toUpperCase();
        return !upperCase.startsWith("X-") ? "X-CUSTOM-" + upperCase : upperCase;
    }

    /* renamed from: a */
    private String m2632a(String str, int i) {
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
    private void m2633a(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ContactStruct.PhoneData phoneData = (ContactStruct.PhoneData) it.next();
            if (!m2635a(phoneData.f2309b)) {
                String strM2630a = m2630a(phoneData);
                if (i == 1) {
                    this.f2342b.append("TEL;");
                } else {
                    this.f2342b.append("TEL;TYPE=");
                }
                this.f2342b.append(strM2630a).append(";VOICE:").append(phoneData.f2309b).append(this.f2341a);
            }
        }
    }

    /* renamed from: a */
    private void m2634a(byte[] bArr, String str, int i) {
        if (m2635a(str)) {
        }
    }

    /* renamed from: a */
    private boolean m2635a(String str) {
        return str == null || str.trim().equals("");
    }

    /* renamed from: b */
    private String m2636b(String str) {
        try {
            String[] strArrSplit = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
            }
            return "CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + sb.toString().substring(0, sb.toString().length() - 1);
        } catch (UnsupportedEncodingException e) {
            ChatONLogWriter.m3499a("Cannot encode", "VCardComposer");
            return null;
        }
    }

    /* renamed from: b */
    private void m2637b(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ContactStruct.EmailData emailData = (ContactStruct.EmailData) it.next();
            if (!m2635a(emailData.f2300b)) {
                String strM2628a = m2628a(emailData);
                if (i == 1) {
                    this.f2342b.append("EMAIL;");
                } else {
                    this.f2342b.append("EMAIL;TYPE=");
                }
                this.f2342b.append(strM2628a).append(";").append(m2636b(emailData.f2300b)).append(this.f2341a);
            }
        }
    }

    /* renamed from: c */
    private String m2638c(String str) {
        try {
            String[] strArrSplit = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                sb.append(URLEncoder.encode(str2, "UTF-8").replaceAll("%", "=") + " ");
            }
            return sb.toString().substring(0, sb.toString().length() - 1);
        } catch (UnsupportedEncodingException e) {
            ChatONLogWriter.m3499a("Cannot encode", "VCardComposer");
            return null;
        }
    }

    /* renamed from: c */
    private void m2639c(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ContactStruct.PostalData postalData = (ContactStruct.PostalData) it.next();
            if (!m2635a(postalData.f2312a) || !m2635a(postalData.f2313b) || !m2635a(postalData.f2314c) || !m2635a(postalData.f2315d) || !m2635a(postalData.f2316e) || !m2635a(postalData.f2317f) || !m2635a(postalData.f2318g)) {
                String strM2631a = m2631a(postalData);
                if (i == 2 && strM2631a.indexOf(";") != -1) {
                    strM2631a = strM2631a.replace(";", "-");
                }
                if (i == 1) {
                    this.f2342b.append("ADR;");
                } else {
                    this.f2342b.append("ADR;TYPE=");
                }
                this.f2342b.append(strM2631a).append(":");
                if (m2635a(postalData.f2312a)) {
                    this.f2342b.append(";");
                } else {
                    this.f2342b.append(postalData.f2312a).append(";");
                }
                if (m2635a(postalData.f2313b)) {
                    this.f2342b.append(";");
                } else {
                    this.f2342b.append(postalData.f2313b).append(";");
                }
                if (m2635a(postalData.f2314c)) {
                    this.f2342b.append(";");
                } else {
                    this.f2342b.append(postalData.f2314c).append(";");
                }
                if (m2635a(postalData.f2315d)) {
                    this.f2342b.append(";");
                } else {
                    this.f2342b.append(postalData.f2315d).append(";");
                }
                if (m2635a(postalData.f2316e)) {
                    this.f2342b.append(";");
                } else {
                    this.f2342b.append(postalData.f2316e).append(";");
                }
                if (m2635a(postalData.f2317f)) {
                    this.f2342b.append(";");
                } else {
                    this.f2342b.append(postalData.f2317f).append(";");
                }
                if (m2635a(postalData.f2318g)) {
                    this.f2342b.append(this.f2341a);
                } else {
                    this.f2342b.append(postalData.f2318g).append(this.f2341a);
                }
            }
        }
    }

    /* renamed from: d */
    private void m2640d(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ContactStruct.ImData imData = (ContactStruct.ImData) it.next();
            if (Integer.valueOf(imData.f2303a) != null && !m2635a(imData.f2306d)) {
                String strM2629a = m2629a(imData);
                if (i == 1) {
                    this.f2342b.append("IMPP;");
                } else {
                    this.f2342b.append("IMPP;TYPE=");
                }
                this.f2342b.append(strM2629a).append(":").append(imData.f2306d).append(this.f2341a);
            }
        }
    }

    /* renamed from: e */
    private void m2641e(List list, int i) {
    }

    /* renamed from: a */
    public String m2642a(ContactStruct contactStruct, int i) throws VCardException {
        this.f2342b = new StringBuilder();
        if ((contactStruct.f2281a == null || contactStruct.f2281a.trim().equals("")) && (contactStruct.f2282b == null || contactStruct.f2282b.trim().equals(""))) {
            if (!m2635a(contactStruct.f2283c)) {
                contactStruct.f2281a = contactStruct.f2283c;
            } else if (contactStruct.f2288h != null) {
                if (m2635a(((ContactStruct.PhoneData) contactStruct.f2288h.get(0)).f2309b)) {
                    contactStruct.f2281a = "#";
                } else {
                    contactStruct.f2281a = ((ContactStruct.PhoneData) contactStruct.f2288h.get(0)).f2309b;
                }
            } else if (contactStruct.f2289i != null) {
                if (m2635a(((ContactStruct.EmailData) contactStruct.f2289i.get(0)).f2300b)) {
                    contactStruct.f2281a = "#";
                } else {
                    contactStruct.f2281a = ((ContactStruct.EmailData) contactStruct.f2289i.get(0)).f2300b;
                }
            } else if (contactStruct.f2290j == null || m2635a(((ContactStruct.PostalData) contactStruct.f2290j.get(0)).f2314c)) {
                contactStruct.f2281a = "#";
            } else {
                contactStruct.f2281a = ((ContactStruct.PostalData) contactStruct.f2290j.get(0)).f2314c;
            }
        }
        if (i != 1 && i != 2) {
            throw new VCardException(" version not match VERSION_VCARD21 or VERSION_VCARD30.");
        }
        this.f2341a = "\r\n";
        this.f2342b.append("BEGIN:VCARD").append(this.f2341a);
        if (i == 1) {
            this.f2342b.append("VERSION:2.1").append(this.f2341a);
        } else if (i == 2) {
            this.f2342b.append("VERSION:3.0").append(this.f2341a);
        } else if (i == 3) {
            this.f2342b.append("VERSION:4.0").append(this.f2341a);
        } else {
            this.f2342b.append("VERSION:2.1").append(this.f2341a);
        }
        if (m2635a(contactStruct.f2281a)) {
            if (!m2635a(contactStruct.f2282b)) {
                this.f2342b.append("N;").append(m2636b(contactStruct.f2282b)).append(";").append(this.f2341a);
                this.f2342b.append("FN;").append(m2636b(contactStruct.f2282b)).append(this.f2341a);
            }
        } else if (m2635a(contactStruct.f2282b)) {
            this.f2342b.append("N;").append(m2636b(contactStruct.f2281a)).append(this.f2341a);
            this.f2342b.append("FN;").append(m2636b(contactStruct.f2281a)).append(this.f2341a);
        } else {
            this.f2342b.append("N;").append(m2636b(contactStruct.f2282b)).append(";").append(m2638c(contactStruct.f2281a)).append(this.f2341a);
            this.f2342b.append("FN;").append(m2636b(contactStruct.f2281a)).append(" ").append(m2638c(contactStruct.f2282b)).append(this.f2341a);
        }
        if (!m2635a(contactStruct.f2283c)) {
            this.f2342b.append("ORG:").append(contactStruct.f2283c).append(this.f2341a);
        }
        if (!m2635a(contactStruct.f2284d)) {
            this.f2342b.append("NOTE;").append(m2636b(contactStruct.f2284d)).append(this.f2341a);
        }
        if (!m2635a(contactStruct.f2285e)) {
            this.f2342b.append("TITLE:").append(m2632a(contactStruct.f2285e, i)).append(this.f2341a);
        }
        if (contactStruct.f2286f != null) {
            m2634a(contactStruct.f2286f, contactStruct.f2287g, i);
        }
        if (contactStruct.f2288h != null) {
            m2633a(contactStruct.f2288h, i);
        }
        if (contactStruct.f2289i != null) {
            m2637b(contactStruct.f2289i, i);
        }
        if (contactStruct.f2290j != null) {
            m2639c(contactStruct.f2290j, i);
        }
        if (contactStruct.f2291k != null) {
            m2640d(contactStruct.f2291k, i);
        }
        if (contactStruct.f2292l != null) {
            m2641e(contactStruct.f2292l, i);
        }
        this.f2342b.append("END:VCARD").append(this.f2341a);
        return this.f2342b.toString();
    }
}
