package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.du */
/* loaded from: classes.dex */
public final class C0378du extends GeneratedMessageLite implements InterfaceC0380dw {

    /* renamed from: a */
    private static final C0378du f1327a = new C0378du(true);

    /* renamed from: b */
    private int f1328b;

    /* renamed from: c */
    private long f1329c;

    /* renamed from: d */
    private EnumC0354cx f1330d;

    /* renamed from: e */
    private Object f1331e;

    /* renamed from: f */
    private byte f1332f;

    /* renamed from: g */
    private int f1333g;

    private C0378du(C0379dv c0379dv) {
        super(c0379dv);
        this.f1332f = (byte) -1;
        this.f1333g = -1;
    }

    private C0378du(boolean z) {
        this.f1332f = (byte) -1;
        this.f1333g = -1;
    }

    /* renamed from: a */
    public static C0378du m2630a() {
        return f1327a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0378du getDefaultInstanceForType() {
        return f1327a;
    }

    /* renamed from: c */
    public boolean m2636c() {
        return (this.f1328b & 1) == 1;
    }

    /* renamed from: d */
    public long m2637d() {
        return this.f1329c;
    }

    /* renamed from: e */
    public boolean m2638e() {
        return (this.f1328b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0354cx m2639f() {
        return this.f1330d;
    }

    /* renamed from: g */
    public boolean m2640g() {
        return (this.f1328b & 4) == 4;
    }

    /* renamed from: h */
    public String m2641h() {
        Object obj = this.f1331e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1331e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m2633k() {
        Object obj = this.f1331e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1331e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m2634l() {
        this.f1329c = 0L;
        this.f1330d = EnumC0354cx.TEXT;
        this.f1331e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1332f;
        if (b != -1) {
            return b == 1;
        }
        this.f1332f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1328b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1329c);
        }
        if ((this.f1328b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1330d.getNumber());
        }
        if ((this.f1328b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2633k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1333g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1328b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1329c) : 0;
            if ((this.f1328b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f1330d.getNumber());
            }
            if ((this.f1328b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m2633k());
            }
            this.f1333g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0379dv newBuilder() {
        return C0379dv.m2646h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0379dv newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0379dv m2631a(C0378du c0378du) {
        return newBuilder().mergeFrom(c0378du);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0379dv toBuilder() {
        return m2631a(this);
    }

    static {
        f1327a.m2634l();
    }
}
