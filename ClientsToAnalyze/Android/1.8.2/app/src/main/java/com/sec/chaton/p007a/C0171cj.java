package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cj */
/* loaded from: classes.dex */
public final class C0171cj extends GeneratedMessageLite implements InterfaceC0173cl {

    /* renamed from: a */
    private static final C0171cj f621a = new C0171cj(true);

    /* renamed from: b */
    private int f622b;

    /* renamed from: c */
    private int f623c;

    /* renamed from: d */
    private Object f624d;

    /* renamed from: e */
    private byte f625e;

    /* renamed from: f */
    private int f626f;

    private C0171cj(C0172ck c0172ck) {
        super(c0172ck);
        this.f625e = (byte) -1;
        this.f626f = -1;
    }

    private C0171cj(boolean z) {
        this.f625e = (byte) -1;
        this.f626f = -1;
    }

    /* renamed from: a */
    public static C0171cj m1459a() {
        return f621a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0171cj getDefaultInstanceForType() {
        return f621a;
    }

    /* renamed from: c */
    public boolean m1466c() {
        return (this.f622b & 1) == 1;
    }

    /* renamed from: d */
    public int m1467d() {
        return this.f623c;
    }

    /* renamed from: e */
    public boolean m1468e() {
        return (this.f622b & 2) == 2;
    }

    /* renamed from: f */
    public String m1469f() {
        Object obj = this.f624d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f624d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m1463i() {
        Object obj = this.f624d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f624d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: j */
    private void m1464j() {
        this.f623c = 0;
        this.f624d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f625e;
        if (b != -1) {
            return b == 1;
        }
        this.f625e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f622b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f623c);
        }
        if ((this.f622b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1463i());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f626f;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f622b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f623c) : 0;
            if ((this.f622b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m1463i());
            }
            this.f626f = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0172ck newBuilder() {
        return C0172ck.m1474h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0172ck newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0172ck m1460a(C0171cj c0171cj) {
        return newBuilder().mergeFrom(c0171cj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0172ck toBuilder() {
        return m1460a(this);
    }

    static {
        f621a.m1464j();
    }
}
