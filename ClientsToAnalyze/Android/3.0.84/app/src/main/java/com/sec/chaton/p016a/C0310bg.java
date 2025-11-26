package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bg */
/* loaded from: classes.dex */
public final class C0310bg extends GeneratedMessageLite implements InterfaceC0315bl {

    /* renamed from: a */
    private static final C0310bg f1023a = new C0310bg(true);

    /* renamed from: b */
    private int f1024b;

    /* renamed from: c */
    private Object f1025c;

    /* renamed from: d */
    private List<C0312bi> f1026d;

    /* renamed from: e */
    private C0369dl f1027e;

    /* renamed from: f */
    private int f1028f;

    /* renamed from: g */
    private long f1029g;

    /* renamed from: h */
    private Object f1030h;

    /* renamed from: i */
    private byte f1031i;

    /* renamed from: j */
    private int f1032j;

    private C0310bg(C0311bh c0311bh) {
        super(c0311bh);
        this.f1031i = (byte) -1;
        this.f1032j = -1;
    }

    private C0310bg(boolean z) {
        this.f1031i = (byte) -1;
        this.f1032j = -1;
    }

    /* renamed from: a */
    public static C0310bg m1760a() {
        return f1023a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0310bg getDefaultInstanceForType() {
        return f1023a;
    }

    /* renamed from: c */
    public boolean m1774c() {
        return (this.f1024b & 1) == 1;
    }

    /* renamed from: d */
    public String m1775d() {
        Object obj = this.f1025c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1025c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m1769q() {
        Object obj = this.f1025c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1025c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List<C0312bi> m1776e() {
        return this.f1026d;
    }

    /* renamed from: f */
    public int m1777f() {
        return this.f1026d.size();
    }

    /* renamed from: a */
    public C0312bi m1772a(int i) {
        return this.f1026d.get(i);
    }

    /* renamed from: g */
    public boolean m1778g() {
        return (this.f1024b & 2) == 2;
    }

    /* renamed from: h */
    public C0369dl m1779h() {
        return this.f1027e;
    }

    /* renamed from: i */
    public boolean m1780i() {
        return (this.f1024b & 4) == 4;
    }

    /* renamed from: j */
    public int m1781j() {
        return this.f1028f;
    }

    /* renamed from: k */
    public boolean m1782k() {
        return (this.f1024b & 8) == 8;
    }

    /* renamed from: l */
    public long m1783l() {
        return this.f1029g;
    }

    /* renamed from: m */
    public boolean m1784m() {
        return (this.f1024b & 16) == 16;
    }

    /* renamed from: n */
    public String m1785n() {
        Object obj = this.f1030h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1030h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m1770r() {
        Object obj = this.f1030h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1030h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: s */
    private void m1771s() {
        this.f1025c = "";
        this.f1026d = Collections.emptyList();
        this.f1027e = C0369dl.m2485a();
        this.f1028f = 0;
        this.f1029g = 0L;
        this.f1030h = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1031i;
        if (b != -1) {
            return b == 1;
        }
        this.f1031i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1024b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1769q());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1026d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.f1026d.get(i2));
            i = i2 + 1;
        }
        if ((this.f1024b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f1027e);
        }
        if ((this.f1024b & 4) == 4) {
            codedOutputStream.writeInt32(4, this.f1028f);
        }
        if ((this.f1024b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f1029g);
        }
        if ((this.f1024b & 16) == 16) {
            codedOutputStream.writeBytes(6, m1770r());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeBytesSize = this.f1032j;
        if (iComputeBytesSize == -1) {
            int iComputeBytesSize2 = (this.f1024b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m1769q()) + 0 : 0;
            while (true) {
                iComputeBytesSize = iComputeBytesSize2;
                if (i >= this.f1026d.size()) {
                    break;
                }
                iComputeBytesSize2 = CodedOutputStream.computeMessageSize(2, this.f1026d.get(i)) + iComputeBytesSize;
                i++;
            }
            if ((this.f1024b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeMessageSize(3, this.f1027e);
            }
            if ((this.f1024b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(4, this.f1028f);
            }
            if ((this.f1024b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(5, this.f1029g);
            }
            if ((this.f1024b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m1770r());
            }
            this.f1032j = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0310bg m1761a(byte[] bArr) {
        return ((C0311bh) newBuilder().mergeFrom(bArr)).m1792n();
    }

    public static C0311bh newBuilder() {
        return C0311bh.m1791m();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0311bh newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0311bh m1762a(C0310bg c0310bg) {
        return newBuilder().mergeFrom(c0310bg);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0311bh toBuilder() {
        return m1762a(this);
    }

    static {
        f1023a.m1771s();
    }
}
