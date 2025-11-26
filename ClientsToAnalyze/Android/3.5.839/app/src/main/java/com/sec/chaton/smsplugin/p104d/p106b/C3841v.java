package com.sec.chaton.smsplugin.p104d.p106b;

import org.p146b.p147a.p149b.InterfaceC5256p;

/* compiled from: TimeImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.v */
/* loaded from: classes.dex */
public class C3841v implements InterfaceC5256p {

    /* renamed from: a */
    short f13734a;

    /* renamed from: b */
    boolean f13735b;

    /* renamed from: c */
    double f13736c;

    C3841v(String str, int i) {
        int i2;
        if (str.equals("indefinite") && (i & 1) != 0) {
            this.f13734a = (short) 0;
            return;
        }
        if ((i & 2) != 0) {
            if (str.startsWith("+")) {
                str = str.substring(1);
                i2 = 1;
            } else if (str.startsWith("-")) {
                str = str.substring(1);
                i2 = -1;
            } else {
                i2 = 1;
            }
            this.f13736c = (i2 * m14607a(str)) / 1000.0d;
            this.f13735b = true;
            this.f13734a = (short) 1;
            return;
        }
        throw new IllegalArgumentException("Unsupported time value");
    }

    /* renamed from: a */
    public static float m14607a(String str) {
        float fM14608a;
        int i = 0;
        try {
            String strTrim = str.trim();
            if (strTrim.endsWith("ms")) {
                return m14608a(strTrim, 2, true);
            }
            if (strTrim.endsWith("s")) {
                return m14608a(strTrim, 1, true) * 1000.0f;
            }
            if (strTrim.endsWith("min")) {
                return m14608a(strTrim, 3, true) * 60000.0f;
            }
            if (strTrim.endsWith("h")) {
                return 3600000.0f * m14608a(strTrim, 1, true);
            }
            try {
                return m14608a(strTrim, 0, true) * 1000.0f;
            } catch (NumberFormatException e) {
                String[] strArrSplit = strTrim.split(":");
                if (strArrSplit.length == 2) {
                    fM14608a = 0.0f;
                } else if (strArrSplit.length == 3) {
                    fM14608a = 3600000 * ((int) m14608a(strArrSplit[0], 0, false));
                    i = 1;
                } else {
                    throw new IllegalArgumentException();
                }
                int iM14608a = (int) m14608a(strArrSplit[i], 0, false);
                if (iM14608a >= 0 && iM14608a <= 59) {
                    float f = fM14608a + (iM14608a * 60000);
                    float fM14608a2 = m14608a(strArrSplit[i + 1], 0, true);
                    if (fM14608a2 >= 0.0f && fM14608a2 < 60.0f) {
                        return (fM14608a2 * 60000.0f) + f;
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    private static float m14608a(String str, int i, boolean z) throws NumberFormatException {
        String strSubstring = str.substring(0, str.length() - i);
        int iIndexOf = strSubstring.indexOf(46);
        if (iIndexOf != -1) {
            if (!z) {
                throw new IllegalArgumentException("int value contains decimal");
            }
            String str2 = strSubstring + "000";
            return (Float.parseFloat(str2.substring(iIndexOf + 1, iIndexOf + 4)) / 1000.0f) + Float.parseFloat(str2.substring(0, iIndexOf));
        }
        return Integer.parseInt(strSubstring);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5256p
    /* renamed from: a */
    public double mo14609a() {
        return 0.0d;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5256p
    /* renamed from: b */
    public boolean mo14610b() {
        return this.f13735b;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5256p
    /* renamed from: c */
    public double mo14611c() {
        return this.f13736c;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5256p
    /* renamed from: d */
    public short mo14612d() {
        return this.f13734a;
    }
}
