package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.u */
/* loaded from: classes.dex */
public final class C0194u extends GeneratedMessageLite implements InterfaceC0196w {

    /* renamed from: a */
    private static final C0194u f704a = new C0194u(true);

    /* renamed from: b */
    private int f705b;

    /* renamed from: c */
    private Object f706c;

    /* renamed from: d */
    private long f707d;

    /* renamed from: e */
    private byte f708e;

    /* renamed from: f */
    private int f709f;

    private C0194u(C0195v c0195v) {
        super(c0195v);
        this.f708e = (byte) -1;
        this.f709f = -1;
    }

    private C0194u(boolean z) {
        this.f708e = (byte) -1;
        this.f709f = -1;
    }

    /* renamed from: a */
    public static C0194u m1735a() {
        return f704a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0194u getDefaultInstanceForType() {
        return f704a;
    }

    /* renamed from: c */
    public boolean m1741c() {
        return (this.f705b & 1) == 1;
    }

    /* renamed from: d */
    public String m1742d() {
        Object obj = this.f706c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f706c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m1738i() {
        Object obj = this.f706c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f706c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1743e() {
        return (this.f705b & 2) == 2;
    }

    /* renamed from: f */
    public long m1744f() {
        return this.f707d;
    }

    /* renamed from: j */
    private void m1739j() {
        this.f706c = "";
        this.f707d = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f708e;
        if (b != -1) {
            return b == 1;
        }
        this.f708e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f705b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1738i());
        }
        if ((this.f705b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f707d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f709f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f705b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m1738i()) : 0;
            if ((this.f705b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(2, this.f707d);
            }
            this.f709f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0195v newBuilder() {
        return C0195v.m1749h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0195v newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0195v m1736a(C0194u c0194u) {
        return newBuilder().mergeFrom(c0194u);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0195v toBuilder() {
        return m1736a(this);
    }

    static {
        f704a.m1739j();
    }
}
