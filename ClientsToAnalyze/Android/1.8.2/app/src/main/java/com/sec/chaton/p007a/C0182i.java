package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.i */
/* loaded from: classes.dex */
public final class C0182i extends GeneratedMessageLite implements InterfaceC0184k {

    /* renamed from: a */
    private static final C0182i f661a = new C0182i(true);

    /* renamed from: b */
    private int f662b;

    /* renamed from: c */
    private long f663c;

    /* renamed from: d */
    private Object f664d;

    /* renamed from: e */
    private List f665e;

    /* renamed from: f */
    private LazyStringList f666f;

    /* renamed from: g */
    private long f667g;

    /* renamed from: h */
    private Object f668h;

    /* renamed from: i */
    private byte f669i;

    /* renamed from: j */
    private int f670j;

    private C0182i(C0183j c0183j) {
        super(c0183j);
        this.f669i = (byte) -1;
        this.f670j = -1;
    }

    private C0182i(boolean z) {
        this.f669i = (byte) -1;
        this.f670j = -1;
    }

    /* renamed from: a */
    public static C0182i m1588a() {
        return f661a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0182i getDefaultInstanceForType() {
        return f661a;
    }

    /* renamed from: c */
    public boolean m1602c() {
        return (this.f662b & 1) == 1;
    }

    /* renamed from: d */
    public long m1603d() {
        return this.f663c;
    }

    /* renamed from: e */
    public boolean m1604e() {
        return (this.f662b & 2) == 2;
    }

    /* renamed from: f */
    public String m1605f() {
        Object obj = this.f664d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f664d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m1597q() {
        Object obj = this.f664d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f664d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public List m1606g() {
        return this.f665e;
    }

    /* renamed from: h */
    public int m1607h() {
        return this.f665e.size();
    }

    /* renamed from: a */
    public C0197x m1600a(int i) {
        return (C0197x) this.f665e.get(i);
    }

    /* renamed from: i */
    public List m1608i() {
        return this.f666f;
    }

    /* renamed from: j */
    public int m1609j() {
        return this.f666f.size();
    }

    /* renamed from: k */
    public boolean m1610k() {
        return (this.f662b & 4) == 4;
    }

    /* renamed from: l */
    public long m1611l() {
        return this.f667g;
    }

    /* renamed from: m */
    public boolean m1612m() {
        return (this.f662b & 8) == 8;
    }

    /* renamed from: n */
    public String m1613n() {
        Object obj = this.f668h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f668h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m1598r() {
        Object obj = this.f668h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f668h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: s */
    private void m1599s() {
        this.f663c = 0L;
        this.f664d = "";
        this.f665e = Collections.emptyList();
        this.f666f = LazyStringArrayList.EMPTY;
        this.f667g = 0L;
        this.f668h = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f669i;
        if (b != -1) {
            return b == 1;
        }
        this.f669i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f662b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f663c);
        }
        if ((this.f662b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1597q());
        }
        for (int i = 0; i < this.f665e.size(); i++) {
            codedOutputStream.writeMessage(3, (MessageLite) this.f665e.get(i));
        }
        for (int i2 = 0; i2 < this.f666f.size(); i2++) {
            codedOutputStream.writeBytes(4, this.f666f.getByteString(i2));
        }
        if ((this.f662b & 4) == 4) {
            codedOutputStream.writeInt64(5, this.f667g);
        }
        if ((this.f662b & 8) == 8) {
            codedOutputStream.writeBytes(6, m1598r());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f670j;
        if (size == -1) {
            int iComputeInt64Size = (this.f662b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f663c) + 0 : 0;
            if ((this.f662b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m1597q());
            }
            int iComputeMessageSize = iComputeInt64Size;
            for (int i = 0; i < this.f665e.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, (MessageLite) this.f665e.get(i));
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f666f.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f666f.getByteString(i2));
            }
            size = iComputeBytesSizeNoTag + iComputeMessageSize + (m1608i().size() * 1);
            if ((this.f662b & 4) == 4) {
                size += CodedOutputStream.computeInt64Size(5, this.f667g);
            }
            if ((this.f662b & 8) == 8) {
                size += CodedOutputStream.computeBytesSize(6, m1598r());
            }
            this.f670j = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0182i m1589a(byte[] bArr) {
        return ((C0183j) newBuilder().mergeFrom(bArr)).m1620i();
    }

    public static C0183j newBuilder() {
        return C0183j.m1619h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0183j newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0183j m1590a(C0182i c0182i) {
        return newBuilder().mergeFrom(c0182i);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0183j toBuilder() {
        return m1590a(this);
    }

    static {
        f661a.m1599s();
    }
}
