package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bu */
/* loaded from: classes.dex */
public final class C0308bu extends GeneratedMessageLite implements InterfaceC0289bb {

    /* renamed from: a */
    private static final C0308bu f851a = new C0308bu(true);

    /* renamed from: b */
    private int f852b;

    /* renamed from: c */
    private Object f853c;

    /* renamed from: d */
    private int f854d;

    /* renamed from: e */
    private byte f855e;

    /* renamed from: f */
    private int f856f;

    private C0308bu(C0273am c0273am) {
        super(c0273am);
        this.f855e = (byte) -1;
        this.f856f = -1;
    }

    private C0308bu(boolean z) {
        this.f855e = (byte) -1;
        this.f856f = -1;
    }

    /* renamed from: a */
    public static C0308bu m1552a() {
        return f851a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0308bu getDefaultInstanceForType() {
        return f851a;
    }

    /* renamed from: c */
    public boolean m1558c() {
        return (this.f852b & 1) == 1;
    }

    /* renamed from: d */
    public String m1559d() {
        Object obj = this.f853c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f853c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m1555i() {
        Object obj = this.f853c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f853c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1560e() {
        return (this.f852b & 2) == 2;
    }

    /* renamed from: f */
    public int m1561f() {
        return this.f854d;
    }

    /* renamed from: j */
    private void m1556j() {
        this.f853c = "";
        this.f854d = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f855e;
        if (b != -1) {
            return b == 1;
        }
        this.f855e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f852b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1555i());
        }
        if ((this.f852b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f854d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f856f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f852b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m1555i()) : 0;
            if ((this.f852b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(2, this.f854d);
            }
            this.f856f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0273am newBuilder() {
        return C0273am.m1159h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0273am newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0273am m1551a(C0308bu c0308bu) {
        return newBuilder().mergeFrom(c0308bu);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0273am toBuilder() {
        return m1551a(this);
    }

    static {
        f851a.m1556j();
    }
}
