package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cu */
/* loaded from: classes.dex */
public final class C0351cu extends GeneratedMessageLite implements InterfaceC0353cw {

    /* renamed from: a */
    private static final C0351cu f1223a = new C0351cu(true);

    /* renamed from: b */
    private int f1224b;

    /* renamed from: c */
    private Object f1225c;

    /* renamed from: d */
    private Object f1226d;

    /* renamed from: e */
    private byte f1227e;

    /* renamed from: f */
    private int f1228f;

    private C0351cu(C0352cv c0352cv) {
        super(c0352cv);
        this.f1227e = (byte) -1;
        this.f1228f = -1;
    }

    private C0351cu(boolean z) {
        this.f1227e = (byte) -1;
        this.f1228f = -1;
    }

    /* renamed from: a */
    public static C0351cu m2326a() {
        return f1223a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0351cu getDefaultInstanceForType() {
        return f1223a;
    }

    /* renamed from: c */
    public boolean m2334c() {
        return (this.f1224b & 1) == 1;
    }

    /* renamed from: d */
    public String m2335d() {
        Object obj = this.f1225c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1225c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m2330i() {
        Object obj = this.f1225c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1225c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m2336e() {
        return (this.f1224b & 2) == 2;
    }

    /* renamed from: f */
    public String m2337f() {
        Object obj = this.f1226d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1226d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: j */
    private ByteString m2331j() {
        Object obj = this.f1226d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1226d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    private void m2332k() {
        this.f1225c = "";
        this.f1226d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1227e;
        if (b != -1) {
            return b == 1;
        }
        this.f1227e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1224b & 1) == 1) {
            codedOutputStream.writeBytes(1, m2330i());
        }
        if ((this.f1224b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2331j());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f1228f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f1224b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m2330i()) : 0;
            if ((this.f1224b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m2331j());
            }
            this.f1228f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0352cv newBuilder() {
        return C0352cv.m2342h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0352cv newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0352cv m2327a(C0351cu c0351cu) {
        return newBuilder().mergeFrom(c0351cu);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0352cv toBuilder() {
        return m2327a(this);
    }

    static {
        f1223a.m2332k();
    }
}
