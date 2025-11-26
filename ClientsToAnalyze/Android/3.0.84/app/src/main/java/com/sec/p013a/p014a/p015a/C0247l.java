package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.l */
/* loaded from: classes.dex */
public final class C0247l extends GeneratedMessageLite implements InterfaceC0249n {

    /* renamed from: a */
    private static final C0247l f565a = new C0247l(true);

    /* renamed from: b */
    private int f566b;

    /* renamed from: c */
    private int f567c;

    /* renamed from: d */
    private Object f568d;

    /* renamed from: e */
    private byte f569e;

    /* renamed from: f */
    private int f570f;

    private C0247l(C0248m c0248m) {
        super(c0248m);
        this.f569e = (byte) -1;
        this.f570f = -1;
    }

    private C0247l(boolean z) {
        this.f569e = (byte) -1;
        this.f570f = -1;
    }

    /* renamed from: a */
    public static C0247l m909a() {
        return f565a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0247l getDefaultInstanceForType() {
        return f565a;
    }

    /* renamed from: c */
    public boolean m917c() {
        return (this.f566b & 1) == 1;
    }

    /* renamed from: d */
    public int m918d() {
        return this.f567c;
    }

    /* renamed from: e */
    public boolean m919e() {
        return (this.f566b & 2) == 2;
    }

    /* renamed from: f */
    public String m920f() {
        Object obj = this.f568d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f568d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m914i() {
        Object obj = this.f568d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f568d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: j */
    private void m915j() {
        this.f567c = 0;
        this.f568d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f569e;
        if (b != -1) {
            return b == 1;
        }
        this.f569e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f566b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f567c);
        }
        if ((this.f566b & 2) == 2) {
            codedOutputStream.writeBytes(2, m914i());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f570f;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f566b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f567c) : 0;
            if ((this.f566b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m914i());
            }
            this.f570f = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0247l m910a(byte[] bArr) {
        return ((C0248m) newBuilder().mergeFrom(bArr)).m927i();
    }

    public static C0248m newBuilder() {
        return C0248m.m926h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0248m newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0248m m911a(C0247l c0247l) {
        return newBuilder().mergeFrom(c0247l);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0248m toBuilder() {
        return m911a(this);
    }

    static {
        f565a.m915j();
    }
}
