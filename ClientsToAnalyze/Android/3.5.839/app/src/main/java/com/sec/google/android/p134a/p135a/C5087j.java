package com.sec.google.android.p134a.p135a;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: PduComposer.java */
/* renamed from: com.sec.google.android.a.a.j */
/* loaded from: classes.dex */
public class C5087j {

    /* renamed from: c */
    static final /* synthetic */ boolean f18532c;

    /* renamed from: h */
    private static HashMap<String, Integer> f18533h;

    /* renamed from: a */
    protected ByteArrayOutputStream f18534a;

    /* renamed from: b */
    protected int f18535b;

    /* renamed from: d */
    private C5095r f18536d;

    /* renamed from: e */
    private C5089l f18537e;

    /* renamed from: f */
    private final ContentResolver f18538f;

    /* renamed from: g */
    private C5093p f18539g;

    static {
        f18532c = !C5087j.class.desiredAssertionStatus();
        f18533h = null;
        f18533h = new HashMap<>();
        for (int i = 0; i < C5092o.f18550a.length; i++) {
            f18533h.put(C5092o.f18550a[i], Integer.valueOf(i));
        }
    }

    public C5087j(Context context, C5095r c5095r) {
        this.f18534a = null;
        this.f18536d = null;
        this.f18535b = 0;
        this.f18537e = null;
        this.f18539g = null;
        this.f18536d = c5095r;
        this.f18538f = context.getContentResolver();
        this.f18539g = c5095r.m19402g();
        this.f18537e = new C5089l(this);
        this.f18534a = new ByteArrayOutputStream();
        this.f18535b = 0;
    }

    /* renamed from: a */
    public byte[] m19352a() {
        switch (this.f18536d.m19403h()) {
            case 128:
                if (m19343e() != 0) {
                    return null;
                }
                break;
            case 129:
            case 130:
            case 132:
            case 134:
            default:
                return null;
            case 131:
                if (m19340c() != 0) {
                    return null;
                }
                break;
            case 133:
                if (m19342d() != 0) {
                    return null;
                }
                break;
            case 135:
                if (m19338b() != 0) {
                    return null;
                }
                break;
        }
        return this.f18534a.toByteArray();
    }

    /* renamed from: a */
    protected void m19351a(byte[] bArr, int i, int i2) {
        this.f18534a.write(bArr, i, i2);
        this.f18535b += i2;
    }

    /* renamed from: a */
    protected void m19346a(int i) {
        this.f18534a.write(i);
        this.f18535b++;
    }

    /* renamed from: b */
    protected void m19353b(int i) {
        m19346a((i | 128) & 255);
    }

    /* renamed from: c */
    protected void m19357c(int i) {
        m19346a(i);
    }

    /* renamed from: d */
    protected void m19359d(int i) {
        m19346a(i);
    }

    /* renamed from: a */
    protected void m19347a(long j) {
        long j2 = j;
        int i = 0;
        while (j2 != 0 && i < 8) {
            j2 >>>= 8;
            i++;
        }
        m19359d(i);
        int i2 = (i - 1) * 8;
        for (int i3 = 0; i3 < i; i3++) {
            m19346a((int) ((j >>> i2) & 255));
            i2 -= 8;
        }
    }

    /* renamed from: a */
    protected void m19350a(byte[] bArr) {
        if ((bArr[0] & 255) > 127) {
            m19346a(127);
        }
        m19351a(bArr, 0, bArr.length);
        m19346a(0);
    }

    /* renamed from: a */
    protected void m19349a(String str) {
        m19350a(str.getBytes());
    }

    /* renamed from: a */
    protected void m19348a(C5082e c5082e) {
        if (!f18532c && c5082e == null) {
            throw new AssertionError();
        }
        int iM19304a = c5082e.m19304a();
        byte[] bArrM19307b = c5082e.m19307b();
        if (bArrM19307b != null) {
            this.f18537e.m19361a();
            C5091n c5091nM19364d = this.f18537e.m19364d();
            m19353b(iM19304a);
            m19350a(bArrM19307b);
            int iM19367a = c5091nM19364d.m19367a();
            this.f18537e.m19362b();
            m19360d(iM19367a);
            this.f18537e.m19363c();
        }
    }

    /* renamed from: b */
    protected void m19354b(long j) {
        int i = 0;
        long j2 = 127;
        while (i < 5 && j >= j2) {
            j2 = (j2 << 7) | 127;
            i++;
        }
        while (i > 0) {
            m19346a((int) ((((j >>> (i * 7)) & 127) | 128) & 255));
            i--;
        }
        m19346a((int) (j & 127));
    }

    /* renamed from: c */
    protected void m19358c(long j) {
        m19347a(j);
    }

    /* renamed from: d */
    protected void m19360d(long j) {
        if (j < 31) {
            m19359d((int) j);
        } else {
            m19346a(31);
            m19354b(j);
        }
    }

    /* renamed from: b */
    protected void m19356b(byte[] bArr) {
        m19346a(34);
        m19351a(bArr, 0, bArr.length);
        m19346a(0);
    }

    /* renamed from: b */
    protected void m19355b(String str) {
        m19356b(str.getBytes());
    }

    /* renamed from: b */
    private C5082e m19339b(C5082e c5082e) {
        try {
            int iM19341c = m19341c(c5082e.m19308c());
            C5082e c5082eM19302a = C5082e.m19302a(c5082e);
            if (1 == iM19341c) {
                c5082eM19302a.m19306b("/TYPE=PLMN".getBytes());
            } else if (3 == iM19341c) {
                c5082eM19302a.m19306b("/TYPE=IPV4".getBytes());
            } else if (4 == iM19341c) {
                c5082eM19302a.m19306b("/TYPE=IPV6".getBytes());
            }
            return c5082eM19302a;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /* renamed from: e */
    private int m19344e(int i) {
        switch (i) {
            case 129:
            case 130:
            case 151:
                C5082e[] c5082eArrM19377d = this.f18539g.m19377d(i);
                if (c5082eArrM19377d == null) {
                    break;
                } else {
                    for (C5082e c5082e : c5082eArrM19377d) {
                        C5082e c5082eM19339b = m19339b(c5082e);
                        if (c5082eM19339b == null) {
                            break;
                        } else {
                            m19357c(i);
                            m19348a(c5082eM19339b);
                        }
                    }
                    break;
                }
            case 133:
                long jM19378e = this.f18539g.m19378e(i);
                if (-1 == jM19378e) {
                    break;
                } else {
                    m19357c(i);
                    m19358c(jM19378e);
                    break;
                }
            case 134:
            case 143:
            case 144:
            case 145:
            case 149:
            case 155:
                int iM19368a = this.f18539g.m19368a(i);
                if (iM19368a == 0) {
                    break;
                } else {
                    m19357c(i);
                    m19357c(iM19368a);
                    break;
                }
            case 136:
                long jM19378e2 = this.f18539g.m19378e(i);
                if (-1 == jM19378e2) {
                    break;
                } else {
                    m19357c(i);
                    this.f18537e.m19361a();
                    C5091n c5091nM19364d = this.f18537e.m19364d();
                    m19346a(129);
                    m19347a(jM19378e2);
                    int iM19367a = c5091nM19364d.m19367a();
                    this.f18537e.m19362b();
                    m19360d(iM19367a);
                    this.f18537e.m19363c();
                    break;
                }
            case 137:
                m19357c(i);
                C5082e c5082eM19376c = this.f18539g.m19376c(i);
                if (c5082eM19376c == null || TextUtils.isEmpty(c5082eM19376c.m19308c()) || new String(c5082eM19376c.m19307b()).equals("insert-address-token")) {
                    m19346a(1);
                    m19346a(129);
                    break;
                } else {
                    this.f18537e.m19361a();
                    C5091n c5091nM19364d2 = this.f18537e.m19364d();
                    m19346a(128);
                    C5082e c5082eM19339b2 = m19339b(c5082eM19376c);
                    if (c5082eM19339b2 == null) {
                        break;
                    } else {
                        m19348a(c5082eM19339b2);
                        int iM19367a2 = c5091nM19364d2.m19367a();
                        this.f18537e.m19362b();
                        m19360d(iM19367a2);
                        this.f18537e.m19363c();
                        break;
                    }
                }
                break;
            case 138:
                byte[] bArrM19375b = this.f18539g.m19375b(i);
                if (bArrM19375b == null) {
                    break;
                } else {
                    m19357c(i);
                    if (Arrays.equals(bArrM19375b, "advertisement".getBytes())) {
                        m19357c(129);
                        break;
                    } else if (Arrays.equals(bArrM19375b, "auto".getBytes())) {
                        m19357c(131);
                        break;
                    } else if (Arrays.equals(bArrM19375b, "personal".getBytes())) {
                        m19357c(128);
                        break;
                    } else if (Arrays.equals(bArrM19375b, "informational".getBytes())) {
                        m19357c(130);
                        break;
                    } else {
                        m19350a(bArrM19375b);
                        break;
                    }
                }
            case 139:
            case 152:
                byte[] bArrM19375b2 = this.f18539g.m19375b(i);
                if (bArrM19375b2 == null) {
                    break;
                } else {
                    m19357c(i);
                    m19350a(bArrM19375b2);
                    break;
                }
            case 141:
                m19357c(i);
                int iM19368a2 = this.f18539g.m19368a(i);
                if (iM19368a2 == 0) {
                    m19353b(18);
                    break;
                } else {
                    m19353b(iM19368a2);
                    break;
                }
            case 150:
                C5082e c5082eM19376c2 = this.f18539g.m19376c(i);
                if (c5082eM19376c2 == null) {
                    break;
                } else {
                    m19357c(i);
                    m19348a(c5082eM19376c2);
                    break;
                }
        }
        return 0;
    }

    /* renamed from: b */
    private int m19338b() {
        if (this.f18534a == null) {
            this.f18534a = new ByteArrayOutputStream();
            this.f18535b = 0;
        }
        m19357c(140);
        m19357c(135);
        if (m19344e(141) != 0 || m19344e(139) != 0 || m19344e(151) != 0 || m19344e(137) != 0) {
            return 1;
        }
        m19344e(133);
        return m19344e(155) == 0 ? 0 : 1;
    }

    /* renamed from: c */
    private int m19340c() {
        if (this.f18534a == null) {
            this.f18534a = new ByteArrayOutputStream();
            this.f18535b = 0;
        }
        m19357c(140);
        m19357c(131);
        return (m19344e(152) == 0 && m19344e(141) == 0 && m19344e(149) == 0) ? 0 : 1;
    }

    /* renamed from: d */
    private int m19342d() {
        if (this.f18534a == null) {
            this.f18534a = new ByteArrayOutputStream();
            this.f18535b = 0;
        }
        m19357c(140);
        m19357c(133);
        if (m19344e(152) != 0 || m19344e(141) != 0) {
            return 1;
        }
        m19344e(145);
        return 0;
    }

    /* renamed from: e */
    private int m19343e() throws Throwable {
        if (this.f18534a == null) {
            this.f18534a = new ByteArrayOutputStream();
            this.f18535b = 0;
        }
        m19357c(140);
        m19357c(128);
        m19357c(152);
        byte[] bArrM19375b = this.f18539g.m19375b(152);
        if (bArrM19375b == null) {
            throw new IllegalArgumentException("Transaction-ID is null.");
        }
        m19350a(bArrM19375b);
        if (m19344e(141) != 0) {
            return 1;
        }
        m19344e(133);
        if (m19344e(137) != 0) {
            return 1;
        }
        boolean z = m19344e(151) != 1;
        if (m19344e(130) != 1) {
            z = true;
        }
        if (m19344e(129) != 1) {
            z = true;
        }
        if (!z) {
            return 1;
        }
        m19344e(150);
        m19344e(138);
        m19344e(136);
        m19344e(143);
        m19344e(134);
        m19344e(144);
        m19357c(132);
        m19345f();
        return 0;
    }

    /* renamed from: f */
    private int m19345f() throws Throwable {
        InputStream inputStreamOpenInputStream;
        Throwable th;
        int length;
        this.f18537e.m19361a();
        C5091n c5091nM19364d = this.f18537e.m19364d();
        Integer num = f18533h.get(new String(this.f18539g.m19375b(132)));
        if (num == null) {
            return 1;
        }
        m19353b(num.intValue());
        C5086i c5086iA = ((C5103z) this.f18536d).m19309a();
        if (c5086iA == null || c5086iA.m19333b() == 0) {
            m19354b(0L);
            this.f18537e.m19362b();
            this.f18537e.m19363c();
            return 0;
        }
        try {
            C5094q c5094qM19328a = c5086iA.m19328a(0);
            byte[] bArrM19386c = c5094qM19328a.m19386c();
            if (bArrM19386c != null) {
                m19357c(138);
                if (60 == bArrM19386c[0] && 62 == bArrM19386c[bArrM19386c.length - 1]) {
                    m19350a(bArrM19386c);
                } else {
                    m19349a("<" + new String(bArrM19386c) + ">");
                }
            }
            m19357c(137);
            m19350a(c5094qM19328a.m19394g());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        int iM19367a = c5091nM19364d.m19367a();
        this.f18537e.m19362b();
        m19360d(iM19367a);
        this.f18537e.m19363c();
        int iM19333b = c5086iA.m19333b();
        m19354b(iM19333b);
        for (int i = 0; i < iM19333b; i++) {
            C5094q c5094qM19328a2 = c5086iA.m19328a(i);
            this.f18537e.m19361a();
            C5091n c5091nM19364d2 = this.f18537e.m19364d();
            this.f18537e.m19361a();
            C5091n c5091nM19364d3 = this.f18537e.m19364d();
            byte[] bArrM19394g = c5094qM19328a2.m19394g();
            if (bArrM19394g == null) {
                return 1;
            }
            Integer num2 = f18533h.get(new String(bArrM19394g));
            if (num2 == null) {
                m19350a(bArrM19394g);
            } else {
                m19353b(num2.intValue());
            }
            byte[] bArrM19397i = c5094qM19328a2.m19397i();
            if (bArrM19397i == null && (bArrM19397i = c5094qM19328a2.m19398j()) == null && (bArrM19397i = c5094qM19328a2.m19390e()) == null) {
                return 1;
            }
            m19357c(133);
            m19350a(bArrM19397i);
            int iM19387d = c5094qM19328a2.m19387d();
            if (iM19387d != 0) {
                m19357c(129);
                m19353b(iM19387d);
            }
            int iM19367a2 = c5091nM19364d3.m19367a();
            this.f18537e.m19362b();
            m19360d(iM19367a2);
            this.f18537e.m19363c();
            byte[] bArrM19386c2 = c5094qM19328a2.m19386c();
            if (bArrM19386c2 != null) {
                m19357c(192);
                if (60 == bArrM19386c2[0] && 62 == bArrM19386c2[bArrM19386c2.length - 1]) {
                    m19356b(bArrM19386c2);
                } else {
                    m19355b("<" + new String(bArrM19386c2) + ">");
                }
            }
            byte[] bArrM19390e = c5094qM19328a2.m19390e();
            if (bArrM19390e != null) {
                m19357c(142);
                m19350a(bArrM19390e);
            }
            int iM19367a3 = c5091nM19364d2.m19367a();
            byte[] bArrM19382a = c5094qM19328a2.m19382a();
            if (bArrM19382a != null) {
                m19351a(bArrM19382a, 0, bArrM19382a.length);
                length = bArrM19382a.length;
            } else {
                InputStream inputStream = null;
                try {
                    byte[] bArr = new byte[1024];
                    inputStreamOpenInputStream = this.f18538f.openInputStream(c5094qM19328a2.m19383b());
                    length = 0;
                    while (true) {
                        try {
                            int i2 = inputStreamOpenInputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            this.f18534a.write(bArr, 0, i2);
                            this.f18535b += i2;
                            length += i2;
                        } catch (FileNotFoundException e2) {
                            inputStream = inputStreamOpenInputStream;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            return 1;
                        } catch (IOException e4) {
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    inputStreamOpenInputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            return 1;
                        } catch (RuntimeException e6) {
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    inputStreamOpenInputStream.close();
                                } catch (IOException e7) {
                                }
                            }
                            return 1;
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    inputStreamOpenInputStream.close();
                                } catch (IOException e8) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e9) {
                        }
                    }
                } catch (FileNotFoundException e10) {
                } catch (IOException e11) {
                    inputStreamOpenInputStream = null;
                } catch (RuntimeException e12) {
                    inputStreamOpenInputStream = null;
                } catch (Throwable th3) {
                    inputStreamOpenInputStream = null;
                    th = th3;
                }
            }
            if (length != c5091nM19364d2.m19367a() - iM19367a3) {
                throw new RuntimeException("BUG: Length sanity check failed");
            }
            this.f18537e.m19362b();
            m19354b(iM19367a3);
            m19354b(length);
            this.f18537e.m19363c();
        }
        return 0;
    }

    /* renamed from: c */
    protected static int m19341c(String str) {
        if (str == null) {
            return 5;
        }
        if (str.matches("[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}")) {
            return 3;
        }
        if (str.matches("\\+?[0-9|\\.|\\-]+")) {
            return 1;
        }
        if (str.matches("[a-zA-Z| ]*\\<{0,1}[a-zA-Z| ]+@{1}[a-zA-Z| ]+\\.{1}[a-zA-Z| ]+\\>{0,1}")) {
            return 2;
        }
        return str.matches("[a-fA-F]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}") ? 4 : 5;
    }
}
