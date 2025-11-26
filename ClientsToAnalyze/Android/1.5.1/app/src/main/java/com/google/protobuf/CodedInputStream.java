package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.sec.amsoma.AMSLibs;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CodedInputStream {

    /* renamed from: a */
    private final byte[] f221a;

    /* renamed from: b */
    private int f222b;

    /* renamed from: c */
    private int f223c;

    /* renamed from: d */
    private int f224d;

    /* renamed from: e */
    private final InputStream f225e;

    /* renamed from: f */
    private int f226f;

    /* renamed from: g */
    private int f227g;

    /* renamed from: h */
    private int f228h;

    /* renamed from: i */
    private int f229i;

    /* renamed from: j */
    private int f230j;

    /* renamed from: k */
    private int f231k;

    private CodedInputStream(InputStream inputStream) {
        this.f228h = Integer.MAX_VALUE;
        this.f230j = 64;
        this.f231k = 67108864;
        this.f221a = new byte[4096];
        this.f222b = 0;
        this.f224d = 0;
        this.f227g = 0;
        this.f225e = inputStream;
    }

    private CodedInputStream(byte[] bArr, int i, int i2) {
        this.f228h = Integer.MAX_VALUE;
        this.f230j = 64;
        this.f231k = 67108864;
        this.f221a = bArr;
        this.f222b = i + i2;
        this.f224d = i;
        this.f227g = -i;
        this.f225e = null;
    }

    /* renamed from: a */
    static int m270a(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw InvalidProtocolBufferException.m342a();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw InvalidProtocolBufferException.m342a();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.m344c();
    }

    /* renamed from: a */
    public static CodedInputStream m271a(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    /* renamed from: a */
    public static CodedInputStream m272a(byte[] bArr) {
        return m273a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static CodedInputStream m273a(byte[] bArr, int i, int i2) {
        return new CodedInputStream(bArr, i, i2);
    }

    /* renamed from: a */
    private boolean m274a(boolean z) throws InvalidProtocolBufferException {
        if (this.f224d < this.f222b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (this.f227g + this.f222b == this.f228h) {
            if (z) {
                throw InvalidProtocolBufferException.m342a();
            }
            return false;
        }
        this.f227g += this.f222b;
        this.f224d = 0;
        this.f222b = this.f225e == null ? -1 : this.f225e.read(this.f221a);
        if (this.f222b == 0 || this.f222b < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f222b + "\nThe InputStream implementation is buggy.");
        }
        if (this.f222b == -1) {
            this.f222b = 0;
            if (z) {
                throw InvalidProtocolBufferException.m342a();
            }
            return false;
        }
        m275n();
        int i = this.f227g + this.f222b + this.f223c;
        if (i > this.f231k || i < 0) {
            throw InvalidProtocolBufferException.m349h();
        }
        return true;
    }

    /* renamed from: n */
    private void m275n() {
        this.f222b += this.f223c;
        int i = this.f227g + this.f222b;
        if (i <= this.f228h) {
            this.f223c = 0;
        } else {
            this.f223c = i - this.f228h;
            this.f222b -= this.f223c;
        }
    }

    /* renamed from: a */
    public int m276a() throws InvalidProtocolBufferException {
        if (m294l()) {
            this.f226f = 0;
            return 0;
        }
        this.f226f = m290h();
        if (WireFormat.m353b(this.f226f) == 0) {
            throw InvalidProtocolBufferException.m345d();
        }
        return this.f226f;
    }

    /* renamed from: a */
    public void m277a(int i) throws InvalidProtocolBufferException {
        if (this.f226f != i) {
            throw InvalidProtocolBufferException.m346e();
        }
    }

    /* renamed from: a */
    public void m278a(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int iM290h = m290h();
        if (this.f229i >= this.f230j) {
            throw InvalidProtocolBufferException.m348g();
        }
        int iM281c = m281c(iM290h);
        this.f229i++;
        builder.mergeFrom(this, extensionRegistryLite);
        m277a(0);
        this.f229i--;
        m284d(iM281c);
    }

    /* renamed from: b */
    public void m279b() throws InvalidProtocolBufferException {
        int iM276a;
        do {
            iM276a = m276a();
            if (iM276a == 0) {
                return;
            }
        } while (m280b(iM276a));
    }

    /* renamed from: b */
    public boolean m280b(int i) throws InvalidProtocolBufferException {
        switch (WireFormat.m351a(i)) {
            case 0:
                m283d();
                return true;
            case 1:
                m293k();
                return true;
            case 2:
                m288f(m290h());
                return true;
            case 3:
                m279b();
                m277a(WireFormat.m352a(WireFormat.m353b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m292j();
                return true;
            default:
                throw InvalidProtocolBufferException.m347f();
        }
    }

    /* renamed from: c */
    public int m281c(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.m343b();
        }
        int i2 = this.f227g + this.f224d + i;
        int i3 = this.f228h;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.m342a();
        }
        this.f228h = i2;
        m275n();
        return i3;
    }

    /* renamed from: c */
    public long m282c() {
        return m291i();
    }

    /* renamed from: d */
    public int m283d() {
        return m290h();
    }

    /* renamed from: d */
    public void m284d(int i) {
        this.f228h = i;
        m275n();
    }

    /* renamed from: e */
    public boolean m285e() {
        return m290h() != 0;
    }

    /* renamed from: e */
    public byte[] m286e(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.m343b();
        }
        if (this.f227g + this.f224d + i > this.f228h) {
            m288f((this.f228h - this.f227g) - this.f224d);
            throw InvalidProtocolBufferException.m342a();
        }
        if (i <= this.f222b - this.f224d) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f221a, this.f224d, bArr, 0, i);
            this.f224d += i;
            return bArr;
        }
        if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i2 = this.f222b - this.f224d;
            System.arraycopy(this.f221a, this.f224d, bArr2, 0, i2);
            this.f224d = this.f222b;
            m274a(true);
            while (i - i2 > this.f222b) {
                System.arraycopy(this.f221a, 0, bArr2, i2, this.f222b);
                i2 += this.f222b;
                this.f224d = this.f222b;
                m274a(true);
            }
            System.arraycopy(this.f221a, 0, bArr2, i2, i - i2);
            this.f224d = i - i2;
            return bArr2;
        }
        int i3 = this.f224d;
        int i4 = this.f222b;
        this.f227g += this.f222b;
        this.f224d = 0;
        this.f222b = 0;
        int length = i - (i4 - i3);
        ArrayList<byte[]> arrayList = new ArrayList();
        while (length > 0) {
            byte[] bArr3 = new byte[Math.min(length, 4096)];
            int i5 = 0;
            while (i5 < bArr3.length) {
                int i6 = this.f225e == null ? -1 : this.f225e.read(bArr3, i5, bArr3.length - i5);
                if (i6 == -1) {
                    throw InvalidProtocolBufferException.m342a();
                }
                this.f227g += i6;
                i5 += i6;
            }
            length -= bArr3.length;
            arrayList.add(bArr3);
        }
        byte[] bArr4 = new byte[i];
        int length2 = i4 - i3;
        System.arraycopy(this.f221a, i3, bArr4, 0, length2);
        for (byte[] bArr5 : arrayList) {
            System.arraycopy(bArr5, 0, bArr4, length2, bArr5.length);
            length2 += bArr5.length;
        }
        return bArr4;
    }

    /* renamed from: f */
    public String m287f() throws InvalidProtocolBufferException {
        int iM290h = m290h();
        if (iM290h > this.f222b - this.f224d || iM290h <= 0) {
            return new String(m286e(iM290h), "UTF-8");
        }
        String str = new String(this.f221a, this.f224d, iM290h, "UTF-8");
        this.f224d = iM290h + this.f224d;
        return str;
    }

    /* renamed from: f */
    public void m288f(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.m343b();
        }
        if (this.f227g + this.f224d + i > this.f228h) {
            m288f((this.f228h - this.f227g) - this.f224d);
            throw InvalidProtocolBufferException.m342a();
        }
        if (i <= this.f222b - this.f224d) {
            this.f224d += i;
            return;
        }
        int i2 = this.f222b - this.f224d;
        this.f227g += i2;
        this.f224d = 0;
        this.f222b = 0;
        while (i2 < i) {
            int iSkip = this.f225e == null ? -1 : (int) this.f225e.skip(i - i2);
            if (iSkip <= 0) {
                throw InvalidProtocolBufferException.m342a();
            }
            i2 += iSkip;
            this.f227g = iSkip + this.f227g;
        }
    }

    /* renamed from: g */
    public int m289g() {
        return m290h();
    }

    /* renamed from: h */
    public int m290h() throws InvalidProtocolBufferException {
        byte bM295m = m295m();
        if (bM295m >= 0) {
            return bM295m;
        }
        int i = bM295m & 127;
        byte bM295m2 = m295m();
        if (bM295m2 >= 0) {
            return i | (bM295m2 << 7);
        }
        int i2 = i | ((bM295m2 & 127) << 7);
        byte bM295m3 = m295m();
        if (bM295m3 >= 0) {
            return i2 | (bM295m3 << AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_TRANSMIT_FULL);
        }
        int i3 = i2 | ((bM295m3 & 127) << 14);
        byte bM295m4 = m295m();
        if (bM295m4 >= 0) {
            return i3 | (bM295m4 << AMSLibs.ENUM_VIP_AMS_ERROR_DECODE_DATA);
        }
        int i4 = i3 | ((bM295m4 & 127) << 21);
        byte bM295m5 = m295m();
        int i5 = i4 | (bM295m5 << AMSLibs.ENUM_VIP_AMS_ERROR_OBJECT_START_SETTING);
        if (bM295m5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (m295m() >= 0) {
                return i5;
            }
        }
        throw InvalidProtocolBufferException.m344c();
    }

    /* renamed from: i */
    public long m291i() throws InvalidProtocolBufferException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & 127) << i;
            if ((m295m() & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.m344c();
    }

    /* renamed from: j */
    public int m292j() throws InvalidProtocolBufferException {
        return (m295m() & 255) | ((m295m() & 255) << 8) | ((m295m() & 255) << 16) | ((m295m() & 255) << 24);
    }

    /* renamed from: k */
    public long m293k() throws InvalidProtocolBufferException {
        return ((m295m() & 255) << 8) | (m295m() & 255) | ((m295m() & 255) << 16) | ((m295m() & 255) << 24) | ((m295m() & 255) << 32) | ((m295m() & 255) << 40) | ((m295m() & 255) << 48) | ((m295m() & 255) << 56);
    }

    /* renamed from: l */
    public boolean m294l() {
        return this.f224d == this.f222b && !m274a(false);
    }

    /* renamed from: m */
    public byte m295m() throws InvalidProtocolBufferException {
        if (this.f224d == this.f222b) {
            m274a(true);
        }
        byte[] bArr = this.f221a;
        int i = this.f224d;
        this.f224d = i + 1;
        return bArr[i];
    }
}
