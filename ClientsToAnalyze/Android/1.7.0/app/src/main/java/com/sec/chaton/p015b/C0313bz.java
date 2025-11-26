package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bz */
/* loaded from: classes.dex */
public final class C0313bz extends GeneratedMessageLite implements InterfaceC0281au {

    /* renamed from: a */
    private static final C0313bz f870a = new C0313bz(true);

    /* renamed from: b */
    private int f871b;

    /* renamed from: c */
    private int f872c;

    /* renamed from: d */
    private Object f873d;

    /* renamed from: e */
    private byte f874e;

    /* renamed from: f */
    private int f875f;

    private C0313bz(C0312by c0312by) {
        super(c0312by);
        this.f874e = (byte) -1;
        this.f875f = -1;
    }

    private C0313bz(boolean z) {
        this.f874e = (byte) -1;
        this.f875f = -1;
    }

    /* renamed from: a */
    public static C0313bz m1619a() {
        return f870a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0313bz getDefaultInstanceForType() {
        return f870a;
    }

    /* renamed from: c */
    public boolean m1625c() {
        return (this.f871b & 1) == 1;
    }

    /* renamed from: d */
    public int m1626d() {
        return this.f872c;
    }

    /* renamed from: e */
    public boolean m1627e() {
        return (this.f871b & 2) == 2;
    }

    /* renamed from: f */
    public String m1628f() {
        Object obj = this.f873d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f873d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m1622i() {
        Object obj = this.f873d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f873d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: j */
    private void m1623j() {
        this.f872c = 0;
        this.f873d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f874e;
        if (b != -1) {
            return b == 1;
        }
        this.f874e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f871b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f872c);
        }
        if ((this.f871b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1622i());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f875f;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f871b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f872c) : 0;
            if ((this.f871b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m1622i());
            }
            this.f875f = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0312by newBuilder() {
        return C0312by.m1607h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0312by newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0312by m1618a(C0313bz c0313bz) {
        return newBuilder().mergeFrom(c0313bz);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0312by toBuilder() {
        return m1618a(this);
    }

    static {
        f870a.m1623j();
    }
}
