package com.sec.google.android.p134a.p135a;

import android.R;
import android.content.res.Resources;
import android.util.Log;
import com.sec.google.android.p134a.C5104b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: PluginPduParser.java */
/* renamed from: com.sec.google.android.a.a.s */
/* loaded from: classes.dex */
public class C5096s {

    /* renamed from: a */
    static final /* synthetic */ boolean f18559a;

    /* renamed from: e */
    private static byte[] f18560e;

    /* renamed from: f */
    private static byte[] f18561f;

    /* renamed from: b */
    private ByteArrayInputStream f18562b;

    /* renamed from: c */
    private C5093p f18563c = null;

    /* renamed from: d */
    private C5086i f18564d = null;

    static {
        f18559a = !C5096s.class.desiredAssertionStatus();
        f18560e = null;
        f18561f = null;
    }

    public C5096s(byte[] bArr) {
        this.f18562b = null;
        this.f18562b = new ByteArrayInputStream(bArr);
    }

    /* renamed from: a */
    public C5095r m19425a() {
        if (this.f18562b == null) {
            return null;
        }
        this.f18563c = m19424a(this.f18562b);
        if (this.f18563c == null) {
            return null;
        }
        int iM19368a = this.f18563c.m19368a(140);
        byte[] bArrM19375b = this.f18563c.m19375b(132);
        if (!m19409a(this.f18563c)) {
            m19407a("check mandatory headers failed!");
            return null;
        }
        if (128 == iM19368a || 132 == iM19368a) {
            this.f18564d = m19405a(this.f18562b, bArrM19375b);
            if (this.f18564d == null) {
                return null;
            }
            if (new String(bArrM19375b).equals("text/plain")) {
                this.f18563c.m19372a("application/vnd.wap.multipart.mixed".getBytes(), 132);
            }
        }
        switch (iM19368a) {
            case 128:
                break;
            case 129:
                break;
            case 130:
                break;
            case 131:
                break;
            case 132:
                C5101x c5101x = new C5101x(this.f18563c, this.f18564d);
                byte[] bArrM19458f = c5101x.m19458f();
                if (bArrM19458f != null) {
                    String str = new String(bArrM19458f);
                    if (!str.equals("application/vnd.wap.multipart.mixed") && !str.equals("application/vnd.wap.multipart.related") && !str.equals("text/plain") && !str.equals("application/vnd.wap.multipart.alternative")) {
                        if (str.equals("application/vnd.wap.multipart.alternative")) {
                            C5094q c5094qM19328a = this.f18564d.m19328a(0);
                            this.f18564d.m19330a();
                            this.f18564d.m19331a(0, c5094qM19328a);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
            case 133:
                break;
            case 134:
                break;
            case 135:
                break;
            case 136:
                break;
            default:
                m19407a("Parser doesn't support this message type in this version!");
                break;
        }
        return null;
    }

    /* renamed from: a */
    protected C5093p m19424a(ByteArrayInputStream byteArrayInputStream) {
        C5082e c5082e;
        byte[] bArrM19307b;
        if (byteArrayInputStream == null) {
            return null;
        }
        C5093p c5093p = new C5093p();
        boolean z = true;
        while (z && byteArrayInputStream.available() > 0) {
            byteArrayInputStream.mark(1);
            int iM19419e = m19419e(byteArrayInputStream);
            if (iM19419e >= 32 && iM19419e <= 127) {
                byteArrayInputStream.reset();
                m19411a(byteArrayInputStream, 0);
            } else {
                switch (iM19419e) {
                    case 129:
                    case 130:
                    case 151:
                        C5082e c5082eM19418d = m19418d(byteArrayInputStream);
                        if (c5082eM19418d == null) {
                            continue;
                        } else {
                            byte[] bArrM19307b2 = c5082eM19418d.m19307b();
                            if (bArrM19307b2 != null) {
                                String str = new String(bArrM19307b2);
                                int iIndexOf = str.indexOf("/");
                                if (iIndexOf > 0) {
                                    str = str.substring(0, iIndexOf);
                                }
                                try {
                                    c5082eM19418d.m19305a(str.getBytes());
                                } catch (NullPointerException e) {
                                    m19407a("null pointer error!");
                                    return null;
                                }
                            }
                            try {
                                c5093p.m19374b(c5082eM19418d, iM19419e);
                                break;
                            } catch (NullPointerException e2) {
                                m19407a("null pointer error!");
                                break;
                            } catch (RuntimeException e3) {
                                m19407a(iM19419e + "is not Encoded-String-Value header field!");
                                return null;
                            }
                        }
                    case 131:
                    case 139:
                    case 152:
                    case 158:
                    case 183:
                    case 184:
                    case 185:
                    case 189:
                    case 190:
                        byte[] bArrM19411a = m19411a(byteArrayInputStream, 0);
                        if (bArrM19411a == null) {
                            break;
                        } else {
                            try {
                                c5093p.m19372a(bArrM19411a, iM19419e);
                                break;
                            } catch (NullPointerException e4) {
                                m19407a("null pointer error!");
                                break;
                            } catch (RuntimeException e5) {
                                m19407a(iM19419e + "is not Text-String header field!");
                                return null;
                            }
                        }
                    case 132:
                        HashMap map = new HashMap();
                        byte[] bArrM19412a = m19412a(byteArrayInputStream, (HashMap<Integer, Object>) map);
                        if (bArrM19412a != null) {
                            try {
                                c5093p.m19372a(bArrM19412a, 132);
                            } catch (NullPointerException e6) {
                                m19407a("null pointer error!");
                            } catch (RuntimeException e7) {
                                m19407a(iM19419e + "is not Text-String header field!");
                                return null;
                            }
                        }
                        f18561f = (byte[]) map.get(153);
                        f18560e = (byte[]) map.get(131);
                        z = false;
                        break;
                    case 133:
                    case 142:
                    case 159:
                        try {
                            c5093p.m19370a(m19421g(byteArrayInputStream), iM19419e);
                            break;
                        } catch (RuntimeException e8) {
                            m19407a(iM19419e + "is not Long-Integer header field!");
                            return null;
                        }
                    case 134:
                    case 143:
                    case 144:
                    case 145:
                    case 146:
                    case 148:
                    case 149:
                    case 153:
                    case 155:
                    case 156:
                    case 162:
                    case 163:
                    case 165:
                    case 167:
                    case 169:
                    case 171:
                    case 177:
                    case 180:
                    case 186:
                    case 187:
                    case 188:
                    case 191:
                        int iM19419e2 = m19419e(byteArrayInputStream);
                        try {
                            c5093p.m19369a(iM19419e2, iM19419e);
                            break;
                        } catch (C5104b e9) {
                            m19407a("Set invalid Octet value: " + iM19419e2 + " into the header filed: " + iM19419e);
                            return null;
                        } catch (RuntimeException e10) {
                            m19407a(iM19419e + "is not Octet header field!");
                            return null;
                        }
                    case 135:
                    case 136:
                    case 157:
                        m19416c(byteArrayInputStream);
                        int iM19419e3 = m19419e(byteArrayInputStream);
                        try {
                            long jM19421g = m19421g(byteArrayInputStream);
                            if (129 == iM19419e3) {
                                jM19421g += System.currentTimeMillis() / 1000;
                            }
                            try {
                                c5093p.m19370a(jM19421g, iM19419e);
                                break;
                            } catch (RuntimeException e11) {
                                m19407a(iM19419e + "is not Long-Integer header field!");
                                return null;
                            }
                        } catch (RuntimeException e12) {
                            m19407a(iM19419e + "is not Long-Integer header field!");
                            return null;
                        }
                    case 137:
                        m19416c(byteArrayInputStream);
                        if (128 == m19419e(byteArrayInputStream)) {
                            c5082e = m19418d(byteArrayInputStream);
                            if (c5082e != null && (bArrM19307b = c5082e.m19307b()) != null) {
                                String str2 = new String(bArrM19307b);
                                int iIndexOf2 = str2.indexOf("/");
                                if (iIndexOf2 > 0) {
                                    str2 = str2.substring(0, iIndexOf2);
                                }
                                try {
                                    c5082e.m19305a(str2.getBytes());
                                } catch (NullPointerException e13) {
                                    m19407a("null pointer error!");
                                    return null;
                                }
                            }
                        } else {
                            try {
                                c5082e = new C5082e("insert-address-token".getBytes());
                            } catch (NullPointerException e14) {
                                m19407a(iM19419e + "is not Encoded-String-Value header field!");
                                return null;
                            }
                        }
                        try {
                            c5093p.m19371a(c5082e, 137);
                            break;
                        } catch (NullPointerException e15) {
                            m19407a("null pointer error!");
                            break;
                        } catch (RuntimeException e16) {
                            m19407a(iM19419e + "is not Encoded-String-Value header field!");
                            return null;
                        }
                        break;
                    case 138:
                        byteArrayInputStream.mark(1);
                        int iM19419e4 = m19419e(byteArrayInputStream);
                        if (iM19419e4 >= 128) {
                            if (128 == iM19419e4) {
                                try {
                                    c5093p.m19372a("personal".getBytes(), 138);
                                    break;
                                } catch (NullPointerException e17) {
                                    m19407a("null pointer error!");
                                    break;
                                } catch (RuntimeException e18) {
                                    m19407a(iM19419e + "is not Text-String header field!");
                                    return null;
                                }
                            } else if (129 == iM19419e4) {
                                c5093p.m19372a("advertisement".getBytes(), 138);
                                break;
                            } else if (130 == iM19419e4) {
                                c5093p.m19372a("informational".getBytes(), 138);
                                break;
                            } else if (131 != iM19419e4) {
                                break;
                            } else {
                                c5093p.m19372a("auto".getBytes(), 138);
                                break;
                            }
                        } else {
                            byteArrayInputStream.reset();
                            byte[] bArrM19411a2 = m19411a(byteArrayInputStream, 0);
                            if (bArrM19411a2 == null) {
                                break;
                            } else {
                                try {
                                    c5093p.m19372a(bArrM19411a2, 138);
                                    break;
                                } catch (NullPointerException e19) {
                                    m19407a("null pointer error!");
                                    break;
                                } catch (RuntimeException e20) {
                                    m19407a(iM19419e + "is not Text-String header field!");
                                    return null;
                                }
                            }
                        }
                    case 140:
                        int iM19419e5 = m19419e(byteArrayInputStream);
                        switch (iM19419e5) {
                            case 137:
                            case 138:
                            case 139:
                            case 140:
                            case 141:
                            case 142:
                            case 143:
                            case 144:
                            case 145:
                            case 146:
                            case 147:
                            case 148:
                            case 149:
                            case 150:
                            case 151:
                                return null;
                            default:
                                try {
                                    c5093p.m19369a(iM19419e5, iM19419e);
                                    break;
                                } catch (C5104b e21) {
                                    m19407a("Set invalid Octet value: " + iM19419e5 + " into the header filed: " + iM19419e);
                                    return null;
                                } catch (RuntimeException e22) {
                                    m19407a(iM19419e + "is not Octet header field!");
                                    return null;
                                }
                        }
                    case 141:
                        int iM19420f = m19420f(byteArrayInputStream);
                        try {
                            c5093p.m19369a(iM19420f, 141);
                            break;
                        } catch (C5104b e23) {
                            m19407a("Set invalid Octet value: " + iM19420f + " into the header filed: " + iM19419e);
                            return null;
                        } catch (RuntimeException e24) {
                            m19407a(iM19419e + "is not Octet header field!");
                            return null;
                        }
                    case 147:
                    case 154:
                    case 166:
                    case 181:
                    case 182:
                        C5082e c5082eM19418d2 = m19418d(byteArrayInputStream);
                        if (c5082eM19418d2 == null) {
                            break;
                        } else {
                            try {
                                c5093p.m19371a(c5082eM19418d2, iM19419e);
                                break;
                            } catch (NullPointerException e25) {
                                m19407a("null pointer error!");
                                break;
                            } catch (RuntimeException e26) {
                                m19407a(iM19419e + "is not Encoded-String-Value header field!");
                                return null;
                            }
                        }
                    case 150:
                        C5082e c5082eM19423i = m19423i(byteArrayInputStream);
                        if (c5082eM19423i != null) {
                            try {
                                c5093p.m19371a(c5082eM19423i, iM19419e);
                                break;
                            } catch (NullPointerException e27) {
                                m19407a("null pointer error!");
                                break;
                            } catch (RuntimeException e28) {
                                m19407a(iM19419e + "is not Encoded-String-Value header field!");
                                return null;
                            }
                        } else {
                            m19407a("Subject is null!");
                            break;
                        }
                    case 160:
                        m19416c(byteArrayInputStream);
                        try {
                            m19422h(byteArrayInputStream);
                            C5082e c5082eM19418d3 = m19418d(byteArrayInputStream);
                            if (c5082eM19418d3 == null) {
                                break;
                            } else {
                                try {
                                    c5093p.m19371a(c5082eM19418d3, 160);
                                    break;
                                } catch (NullPointerException e29) {
                                    m19407a("null pointer error!");
                                    break;
                                } catch (RuntimeException e30) {
                                    m19407a(iM19419e + "is not Encoded-String-Value header field!");
                                    return null;
                                }
                            }
                        } catch (RuntimeException e31) {
                            m19407a(iM19419e + " is not Integer-Value");
                            return null;
                        }
                    case 161:
                        m19416c(byteArrayInputStream);
                        try {
                            m19422h(byteArrayInputStream);
                            try {
                                c5093p.m19370a(m19421g(byteArrayInputStream), 161);
                                break;
                            } catch (RuntimeException e32) {
                                m19407a(iM19419e + "is not Long-Integer header field!");
                                return null;
                            }
                        } catch (RuntimeException e33) {
                            m19407a(iM19419e + " is not Integer-Value");
                            return null;
                        }
                    case 164:
                        m19416c(byteArrayInputStream);
                        m19419e(byteArrayInputStream);
                        m19418d(byteArrayInputStream);
                        break;
                    case 168:
                    case 174:
                    case 176:
                    default:
                        m19407a("Unknown header");
                        break;
                    case 170:
                    case 172:
                        m19416c(byteArrayInputStream);
                        m19419e(byteArrayInputStream);
                        try {
                            m19422h(byteArrayInputStream);
                            break;
                        } catch (RuntimeException e34) {
                            m19407a(iM19419e + " is not Integer-Value");
                            return null;
                        }
                    case 173:
                    case 175:
                    case 179:
                        try {
                            c5093p.m19370a(m19422h(byteArrayInputStream), iM19419e);
                            break;
                        } catch (RuntimeException e35) {
                            m19407a(iM19419e + "is not Long-Integer header field!");
                            return null;
                        }
                    case 178:
                        m19412a(byteArrayInputStream, (HashMap<Integer, Object>) null);
                        break;
                }
            }
        }
        return c5093p;
    }

    /* renamed from: a */
    protected static C5086i m19405a(ByteArrayInputStream byteArrayInputStream, byte[] bArr) {
        C5094q c5094qM19328a;
        if (byteArrayInputStream == null) {
            return null;
        }
        C5086i c5086i = new C5086i();
        String str = new String(bArr);
        if (str.equals("application/vnd.wap.multipart.mixed") || str.equals("application/vnd.wap.multipart.related")) {
            int iM19413b = m19413b(byteArrayInputStream);
            for (int i = 0; i < iM19413b; i++) {
                int iM19413b2 = m19413b(byteArrayInputStream);
                int iM19413b3 = m19413b(byteArrayInputStream);
                C5094q c5094q = new C5094q();
                int iAvailable = byteArrayInputStream.available();
                if (iAvailable <= 0) {
                    return null;
                }
                HashMap map = new HashMap();
                byte[] bArrM19412a = m19412a(byteArrayInputStream, (HashMap<Integer, Object>) map);
                if (bArrM19412a != null) {
                    c5094q.m19389e(bArrM19412a);
                } else {
                    c5094q.m19389e(C5092o.f18550a[0].getBytes());
                }
                byte[] bArr2 = (byte[]) map.get(151);
                if (bArr2 != null) {
                    c5094q.m19393g(bArr2);
                }
                Integer num = (Integer) map.get(129);
                if (num != null) {
                    c5094q.m19379a(num.intValue());
                }
                int iAvailable2 = iM19413b2 - (iAvailable - byteArrayInputStream.available());
                if (iAvailable2 > 0) {
                    if (!m19410a(byteArrayInputStream, c5094q, iAvailable2)) {
                        return null;
                    }
                } else if (iAvailable2 < 0) {
                    return null;
                }
                if (c5094q.m19390e() == null && c5094q.m19397i() == null && c5094q.m19398j() == null && c5094q.m19386c() == null) {
                    c5094q.m19385c(Long.toOctalString(System.currentTimeMillis()).getBytes());
                }
                if (iM19413b3 > 0) {
                    byte[] bArrM19452a = new byte[iM19413b3];
                    String str2 = new String(c5094q.m19394g());
                    if (byteArrayInputStream.read(bArrM19452a, 0, iM19413b3) == -1) {
                        return null;
                    }
                    if (str2.equalsIgnoreCase("application/vnd.wap.multipart.alternative")) {
                        c5094qM19328a = m19405a(new ByteArrayInputStream(bArrM19452a), bArrM19412a).m19328a(0);
                    } else {
                        byte[] bArrM19396h = c5094q.m19396h();
                        if (bArrM19396h != null) {
                            String str3 = new String(bArrM19396h);
                            if (str3.equalsIgnoreCase("base64")) {
                                bArrM19452a = C5079b.m19297a(bArrM19452a);
                            } else if (str3.equalsIgnoreCase("quoted-printable")) {
                                bArrM19452a = C5098u.m19452a(bArrM19452a);
                            }
                        }
                        if (bArrM19452a == null) {
                            m19407a("Decode part data error!");
                            return null;
                        }
                        c5094q.m19381a(bArrM19452a);
                        c5094qM19328a = c5094q;
                    }
                } else {
                    c5094qM19328a = c5094q;
                }
                if (m19404a(c5094qM19328a) == 0) {
                    c5086i.m19331a(0, c5094qM19328a);
                } else {
                    c5086i.m19332a(c5094qM19328a);
                }
            }
        } else if (str.equals("text/plain")) {
            String str4 = new String("<smil><head><layout><root-layout width=\"320px\" height=\"480px\"/><region id=\"Text\" left=\"0\" top=\"320\" width=\"320px\" height=\"160px\" fit=\"meet\"/></layout></head><body><par><text src=\"attach.txt\" region=\"Text\"/></par></body></smil>");
            C5094q c5094q2 = new C5094q();
            c5094q2.m19384b("smil.txt".getBytes());
            c5094q2.m19385c("smil.txt".getBytes());
            c5094q2.m19389e("application/smil".getBytes());
            c5094q2.m19381a(str4.getBytes());
            c5086i.m19331a(0, c5094q2);
            C5094q c5094q3 = new C5094q();
            c5094q3.m19385c("attach.txt".getBytes());
            c5094q3.m19384b("attach.txt".getBytes());
            c5094q3.m19389e("text/plain".getBytes());
            int iAvailable3 = byteArrayInputStream.available();
            byte[] bArr3 = new byte[iAvailable3];
            byteArrayInputStream.read(bArr3, 0, iAvailable3);
            c5094q3.m19381a(bArr3);
            c5086i.m19332a(c5094q3);
        }
        return c5086i;
    }

    /* renamed from: a */
    private static void m19407a(String str) {
    }

    /* renamed from: b */
    protected static int m19413b(ByteArrayInputStream byteArrayInputStream) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        int i = 0;
        int i2 = byteArrayInputStream.read();
        if (i2 != -1) {
            while ((i2 & 128) != 0) {
                i = (i << 7) | (i2 & 127);
                i2 = byteArrayInputStream.read();
                if (i2 == -1) {
                    return i2;
                }
            }
            return (i2 & 127) | (i << 7);
        }
        return i2;
    }

    /* renamed from: c */
    protected static int m19416c(ByteArrayInputStream byteArrayInputStream) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        int i = byteArrayInputStream.read();
        if (!f18559a && -1 == i) {
            throw new AssertionError();
        }
        int i2 = i & 255;
        if (i2 > 30) {
            if (i2 == 31) {
                return m19413b(byteArrayInputStream);
            }
            throw new RuntimeException("Value length > LENGTH_QUOTE!");
        }
        return i2;
    }

    /* renamed from: d */
    protected static C5082e m19418d(ByteArrayInputStream byteArrayInputStream) {
        int iM19420f;
        C5082e c5082e;
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        byteArrayInputStream.mark(1);
        int i = byteArrayInputStream.read();
        if (!f18559a && -1 == i) {
            throw new AssertionError();
        }
        if (i == 0) {
            return null;
        }
        int i2 = i & 255;
        byteArrayInputStream.reset();
        if (i2 < 32) {
            m19416c(byteArrayInputStream);
            iM19420f = m19420f(byteArrayInputStream);
        } else {
            iM19420f = 0;
        }
        byte[] bArrM19411a = m19411a(byteArrayInputStream, 0);
        try {
            if (iM19420f != 0) {
                c5082e = new C5082e(iM19420f, bArrM19411a);
            } else {
                c5082e = new C5082e(bArrM19411a);
            }
            return c5082e;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    protected static byte[] m19411a(ByteArrayInputStream byteArrayInputStream, int i) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        byteArrayInputStream.mark(1);
        int i2 = byteArrayInputStream.read();
        if (!f18559a && -1 == i2) {
            throw new AssertionError();
        }
        if (1 == i && 34 == i2) {
            byteArrayInputStream.mark(1);
        } else if (i == 0 && 127 == i2) {
            byteArrayInputStream.mark(1);
        } else {
            byteArrayInputStream.reset();
        }
        return m19415b(byteArrayInputStream, i);
    }

    /* renamed from: a */
    protected static boolean m19408a(int i) {
        if (i < 33 || i > 126) {
            return false;
        }
        switch (i) {
            case 34:
            case 40:
            case 41:
            case 44:
            case 47:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 91:
            case 92:
            case 93:
            case 123:
            case 125:
                break;
        }
        return false;
    }

    /* renamed from: b */
    protected static boolean m19414b(int i) {
        if (i >= 32 && i <= 126) {
            return true;
        }
        if (i >= 128 && i <= 255) {
            return true;
        }
        switch (i) {
        }
        return true;
    }

    /* renamed from: b */
    protected static byte[] m19415b(ByteArrayInputStream byteArrayInputStream, int i) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = byteArrayInputStream.read();
        if (!f18559a && -1 == i2) {
            throw new AssertionError();
        }
        while (-1 != i2 && i2 != 0) {
            if (i == 2) {
                if (m19408a(i2)) {
                    byteArrayOutputStream.write(i2);
                }
            } else if (m19414b(i2)) {
                byteArrayOutputStream.write(i2);
            }
            i2 = byteArrayInputStream.read();
            if (!f18559a && -1 == i2) {
                throw new AssertionError();
            }
        }
        if (byteArrayOutputStream.size() > 0) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    /* renamed from: e */
    protected static int m19419e(ByteArrayInputStream byteArrayInputStream) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        int i = byteArrayInputStream.read();
        if (f18559a || -1 != i) {
            return i & 255;
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    protected static int m19420f(ByteArrayInputStream byteArrayInputStream) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        int i = byteArrayInputStream.read();
        if (f18559a || -1 != i) {
            return i & 127;
        }
        throw new AssertionError();
    }

    /* renamed from: g */
    protected static long m19421g(ByteArrayInputStream byteArrayInputStream) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        int i = byteArrayInputStream.read();
        if (!f18559a && -1 == i) {
            throw new AssertionError();
        }
        int i2 = i & 255;
        if (i2 > 8) {
            throw new RuntimeException("Octet count greater than 8 and I can't represent that!");
        }
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = byteArrayInputStream.read();
            if (!f18559a && -1 == i4) {
                throw new AssertionError();
            }
            j = (j << 8) + (i4 & 255);
        }
        return j;
    }

    /* renamed from: h */
    protected static long m19422h(ByteArrayInputStream byteArrayInputStream) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        byteArrayInputStream.mark(1);
        int i = byteArrayInputStream.read();
        if (!f18559a && -1 == i) {
            throw new AssertionError();
        }
        byteArrayInputStream.reset();
        return i > 127 ? m19420f(byteArrayInputStream) : m19421g(byteArrayInputStream);
    }

    /* renamed from: c */
    protected static int m19417c(ByteArrayInputStream byteArrayInputStream, int i) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        int i2 = byteArrayInputStream.read(new byte[i], 0, i);
        if (i2 < i) {
            return -1;
        }
        return i2;
    }

    /* renamed from: a */
    protected static void m19406a(ByteArrayInputStream byteArrayInputStream, HashMap<Integer, Object> map, Integer num) {
        byte[] bytes;
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        if (!f18559a && num.intValue() <= 0) {
            throw new AssertionError();
        }
        int iAvailable = byteArrayInputStream.available();
        int iIntValue = num.intValue();
        while (iIntValue > 0) {
            int i = byteArrayInputStream.read();
            if (!f18559a && -1 == i) {
                throw new AssertionError();
            }
            iIntValue--;
            switch (i) {
                case 129:
                    byteArrayInputStream.mark(1);
                    int iM19419e = m19419e(byteArrayInputStream);
                    byteArrayInputStream.reset();
                    if ((iM19419e > 32 && iM19419e < 127) || iM19419e == 0) {
                        byte[] bArrM19411a = m19411a(byteArrayInputStream, 0);
                        try {
                            int iM19299a = C5080c.m19299a(new String(bArrM19411a));
                            if (map != null) {
                                map.put(129, Integer.valueOf(iM19299a));
                            }
                        } catch (UnsupportedEncodingException e) {
                            Log.e("PduParser", Arrays.toString(bArrM19411a), e);
                            map.put(129, 0);
                        }
                    } else {
                        int iM19422h = (int) m19422h(byteArrayInputStream);
                        if (map != null) {
                            map.put(129, Integer.valueOf(iM19422h));
                        }
                    }
                    iIntValue = num.intValue() - (iAvailable - byteArrayInputStream.available());
                    break;
                case 131:
                case 137:
                    byteArrayInputStream.mark(1);
                    int iM19419e2 = m19419e(byteArrayInputStream);
                    byteArrayInputStream.reset();
                    if (iM19419e2 > 127) {
                        int iM19420f = m19420f(byteArrayInputStream);
                        if (iM19420f < C5092o.f18550a.length && (bytes = C5092o.f18550a[iM19420f].getBytes()) != null && map != null) {
                            map.put(131, bytes);
                        }
                    } else {
                        byte[] bArrM19411a2 = m19411a(byteArrayInputStream, 0);
                        if (bArrM19411a2 != null && map != null) {
                            map.put(131, bArrM19411a2);
                        }
                    }
                    iIntValue = num.intValue() - (iAvailable - byteArrayInputStream.available());
                    break;
                case 133:
                case 151:
                    byte[] bArrM19411a3 = m19411a(byteArrayInputStream, 0);
                    if (bArrM19411a3 != null && map != null) {
                        map.put(151, bArrM19411a3);
                    }
                    iIntValue = num.intValue() - (iAvailable - byteArrayInputStream.available());
                    break;
                case 138:
                case 153:
                    byte[] bArrM19411a4 = m19411a(byteArrayInputStream, 0);
                    if (bArrM19411a4 != null && map != null) {
                        map.put(153, bArrM19411a4);
                    }
                    iIntValue = num.intValue() - (iAvailable - byteArrayInputStream.available());
                    break;
                default:
                    if (-1 != m19417c(byteArrayInputStream, iIntValue)) {
                        iIntValue = 0;
                        break;
                    } else {
                        Log.e("PduParser", "Corrupt Content-Type");
                        break;
                    }
            }
        }
        if (iIntValue != 0) {
            Log.e("PduParser", "Corrupt Content-Type");
        }
    }

    /* renamed from: a */
    protected static byte[] m19412a(ByteArrayInputStream byteArrayInputStream, HashMap<Integer, Object> map) {
        byte[] bArrM19411a;
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        byteArrayInputStream.mark(1);
        int i = byteArrayInputStream.read();
        if (!f18559a && -1 == i) {
            throw new AssertionError();
        }
        byteArrayInputStream.reset();
        int i2 = i & 255;
        if (i2 < 32) {
            int iM19416c = m19416c(byteArrayInputStream);
            int iAvailable = byteArrayInputStream.available();
            byteArrayInputStream.mark(1);
            int i3 = byteArrayInputStream.read();
            if (!f18559a && -1 == i3) {
                throw new AssertionError();
            }
            byteArrayInputStream.reset();
            int i4 = i3 & 255;
            if (i4 >= 32 && i4 <= 127) {
                bArrM19411a = m19411a(byteArrayInputStream, 0);
            } else if (i4 > 127) {
                int iM19420f = m19420f(byteArrayInputStream);
                if (iM19420f < C5092o.f18550a.length) {
                    bArrM19411a = C5092o.f18550a[iM19420f].getBytes();
                } else {
                    byteArrayInputStream.reset();
                    bArrM19411a = m19411a(byteArrayInputStream, 0);
                }
            } else {
                Log.e("PduParser", "Corrupt content-type");
                return C5092o.f18550a[0].getBytes();
            }
            int iAvailable2 = iM19416c - (iAvailable - byteArrayInputStream.available());
            if (iAvailable2 > 0) {
                m19406a(byteArrayInputStream, map, Integer.valueOf(iAvailable2));
            }
            if (iAvailable2 < 0) {
                Log.e("PduParser", "Corrupt MMS message");
                return C5092o.f18550a[0].getBytes();
            }
            return bArrM19411a;
        }
        if (i2 <= 127) {
            return m19411a(byteArrayInputStream, 0);
        }
        return C5092o.f18550a[m19420f(byteArrayInputStream)].getBytes();
    }

    /* renamed from: i */
    protected static C5082e m19423i(ByteArrayInputStream byteArrayInputStream) {
        C5082e c5082e;
        int iM19420f;
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        byteArrayInputStream.mark(1);
        int i = byteArrayInputStream.read();
        if (!f18559a && -1 == i) {
            throw new AssertionError();
        }
        if (i == 0) {
            return null;
        }
        int i2 = i & 255;
        if (i2 > 0) {
            byteArrayInputStream.reset();
            if (i2 < 32) {
                m19416c(byteArrayInputStream);
                iM19420f = m19420f(byteArrayInputStream);
            } else {
                iM19420f = 0;
            }
            byte[] bArrM19411a = m19411a(byteArrayInputStream, 0);
            try {
                if (iM19420f != 0) {
                    c5082e = new C5082e(iM19420f, bArrM19411a);
                } else {
                    c5082e = new C5082e(bArrM19411a);
                }
            } catch (Exception e) {
                return null;
            }
        } else {
            c5082e = null;
        }
        return c5082e;
    }

    /* renamed from: a */
    protected static boolean m19410a(ByteArrayInputStream byteArrayInputStream, C5094q c5094q, int i) {
        if (!f18559a && byteArrayInputStream == null) {
            throw new AssertionError();
        }
        if (!f18559a && c5094q == null) {
            throw new AssertionError();
        }
        if (!f18559a && i <= 0) {
            throw new AssertionError();
        }
        int iAvailable = byteArrayInputStream.available();
        int iAvailable2 = i;
        while (iAvailable2 > 0) {
            int i2 = byteArrayInputStream.read();
            if (!f18559a && -1 == i2) {
                throw new AssertionError();
            }
            iAvailable2--;
            if (i2 > 127) {
                switch (i2) {
                    case 142:
                        byte[] bArrM19411a = m19411a(byteArrayInputStream, 0);
                        if (bArrM19411a != null) {
                            c5094q.m19385c(bArrM19411a);
                        }
                        iAvailable2 = i - (iAvailable - byteArrayInputStream.available());
                        break;
                    case 174:
                    case 197:
                        if (!Resources.getSystem().getBoolean(R.bool.config_automatic_brightness_available)) {
                            break;
                        } else {
                            int iM19416c = m19416c(byteArrayInputStream);
                            byteArrayInputStream.mark(1);
                            int iAvailable3 = byteArrayInputStream.available();
                            int i3 = byteArrayInputStream.read();
                            if (i3 == 128) {
                                c5094q.m19388d(C5094q.f18552a);
                            } else if (i3 == 129) {
                                c5094q.m19388d(C5094q.f18553b);
                            } else if (i3 == 130) {
                                c5094q.m19388d(C5094q.f18554c);
                            } else {
                                byteArrayInputStream.reset();
                                c5094q.m19388d(m19411a(byteArrayInputStream, 0));
                            }
                            if (iAvailable3 - byteArrayInputStream.available() < iM19416c) {
                                if (byteArrayInputStream.read() == 152) {
                                    c5094q.m19395h(m19411a(byteArrayInputStream, 0));
                                }
                                int iAvailable4 = byteArrayInputStream.available();
                                if (iAvailable3 - iAvailable4 < iM19416c) {
                                    int i4 = iM19416c - (iAvailable3 - iAvailable4);
                                    byteArrayInputStream.read(new byte[i4], 0, i4);
                                }
                            }
                            iAvailable2 = i - (iAvailable - byteArrayInputStream.available());
                            break;
                        }
                    case 192:
                        byte[] bArrM19411a2 = m19411a(byteArrayInputStream, 1);
                        if (bArrM19411a2 != null) {
                            c5094q.m19384b(bArrM19411a2);
                        }
                        iAvailable2 = i - (iAvailable - byteArrayInputStream.available());
                        break;
                    default:
                        if (-1 != m19417c(byteArrayInputStream, iAvailable2)) {
                            iAvailable2 = 0;
                            break;
                        } else {
                            Log.e("PduParser", "Corrupt Part headers");
                            return false;
                        }
                }
            } else if (i2 >= 32 && i2 <= 127) {
                byte[] bArrM19411a3 = m19411a(byteArrayInputStream, 0);
                byte[] bArrM19411a4 = m19411a(byteArrayInputStream, 0);
                if (true == "Content-Transfer-Encoding".equalsIgnoreCase(new String(bArrM19411a3))) {
                    c5094q.m19391f(bArrM19411a4);
                }
                iAvailable2 = i - (iAvailable - byteArrayInputStream.available());
            } else {
                if (-1 == m19417c(byteArrayInputStream, iAvailable2)) {
                    Log.e("PduParser", "Corrupt Part headers");
                    return false;
                }
                iAvailable2 = 0;
            }
        }
        if (iAvailable2 == 0) {
            return true;
        }
        Log.e("PduParser", "Corrupt Part headers");
        return false;
    }

    /* renamed from: a */
    private static int m19404a(C5094q c5094q) {
        byte[] bArrM19394g;
        byte[] bArrM19386c;
        if (!f18559a && c5094q == null) {
            throw new AssertionError();
        }
        if (f18560e == null && f18561f == null) {
            return 1;
        }
        if (f18561f == null || (bArrM19386c = c5094q.m19386c()) == null || true != Arrays.equals(f18561f, bArrM19386c)) {
            return (f18560e == null || (bArrM19394g = c5094q.m19394g()) == null || true != Arrays.equals(f18560e, bArrM19394g)) ? 1 : 0;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static boolean m19409a(com.sec.google.android.p134a.p135a.C5093p r8) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.google.android.p134a.p135a.C5096s.m19409a(com.sec.google.android.a.a.p):boolean");
    }
}
