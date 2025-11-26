package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ea */
/* loaded from: classes.dex */
public final class C0385ea extends GeneratedMessageLite implements InterfaceC0387ec {

    /* renamed from: a */
    private static final C0385ea f1349a = new C0385ea(true);

    /* renamed from: b */
    private int f1350b;

    /* renamed from: c */
    private Object f1351c;

    /* renamed from: d */
    private int f1352d;

    /* renamed from: e */
    private byte f1353e;

    /* renamed from: f */
    private int f1354f;

    private C0385ea(C0386eb c0386eb) {
        super(c0386eb);
        this.f1353e = (byte) -1;
        this.f1354f = -1;
    }

    private C0385ea(boolean z) {
        this.f1353e = (byte) -1;
        this.f1354f = -1;
    }

    /* renamed from: a */
    public static C0385ea m2690a() {
        return f1349a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0385ea getDefaultInstanceForType() {
        return f1349a;
    }

    /* renamed from: c */
    public boolean m2697c() {
        return (this.f1350b & 1) == 1;
    }

    /* renamed from: d */
    public String m2698d() {
        Object obj = this.f1351c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1351c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m2694i() {
        Object obj = this.f1351c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1351c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m2699e() {
        return (this.f1350b & 2) == 2;
    }

    /* renamed from: f */
    public int m2700f() {
        return this.f1352d;
    }

    /* renamed from: j */
    private void m2695j() {
        this.f1351c = "";
        this.f1352d = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1353e;
        if (b != -1) {
            return b == 1;
        }
        this.f1353e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1350b & 1) == 1) {
            codedOutputStream.writeBytes(1, m2694i());
        }
        if ((this.f1350b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f1352d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f1354f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f1350b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m2694i()) : 0;
            if ((this.f1350b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(2, this.f1352d);
            }
            this.f1354f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0386eb newBuilder() {
        return C0386eb.m2705h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0386eb newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0386eb m2691a(C0385ea c0385ea) {
        return newBuilder().mergeFrom(c0385ea);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0386eb toBuilder() {
        return m2691a(this);
    }

    static {
        f1349a.m2695j();
    }
}
