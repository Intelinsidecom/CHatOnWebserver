package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.gc */
/* loaded from: classes.dex */
public final class C0957gc extends GeneratedMessageLite implements InterfaceC0959ge {

    /* renamed from: a */
    private static final C0957gc f3074a = new C0957gc(true);

    /* renamed from: b */
    private int f3075b;

    /* renamed from: c */
    private Object f3076c;

    /* renamed from: d */
    private int f3077d;

    /* renamed from: e */
    private byte f3078e;

    /* renamed from: f */
    private int f3079f;

    private C0957gc(C0958gd c0958gd) {
        super(c0958gd);
        this.f3078e = (byte) -1;
        this.f3079f = -1;
    }

    private C0957gc(boolean z) {
        this.f3078e = (byte) -1;
        this.f3079f = -1;
    }

    /* renamed from: a */
    public static C0957gc m5553a() {
        return f3074a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0957gc getDefaultInstanceForType() {
        return f3074a;
    }

    /* renamed from: c */
    public boolean m5560c() {
        return (this.f3075b & 1) == 1;
    }

    /* renamed from: d */
    public String m5561d() {
        Object obj = this.f3076c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3076c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m5557i() {
        Object obj = this.f3076c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3076c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m5562e() {
        return (this.f3075b & 2) == 2;
    }

    /* renamed from: f */
    public int m5563f() {
        return this.f3077d;
    }

    /* renamed from: j */
    private void m5558j() {
        this.f3076c = "";
        this.f3077d = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3078e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3078e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3075b & 1) == 1) {
            codedOutputStream.writeBytes(1, m5557i());
        }
        if ((this.f3075b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f3077d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f3079f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f3075b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m5557i()) : 0;
            if ((this.f3075b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(2, this.f3077d);
            }
            this.f3079f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0958gd newBuilder() {
        return C0958gd.m5568h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0958gd newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0958gd m5554a(C0957gc c0957gc) {
        return newBuilder().mergeFrom(c0957gc);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0958gd toBuilder() {
        return m5554a(this);
    }

    static {
        f3074a.m5558j();
    }
}
