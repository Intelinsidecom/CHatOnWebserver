package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cz */
/* loaded from: classes.dex */
public final class C0356cz extends GeneratedMessageLite implements InterfaceC0359db {

    /* renamed from: a */
    private static final C0356cz f1240a = new C0356cz(true);

    /* renamed from: b */
    private int f1241b;

    /* renamed from: c */
    private Object f1242c;

    /* renamed from: d */
    private Object f1243d;

    /* renamed from: e */
    private byte f1244e;

    /* renamed from: f */
    private int f1245f;

    private C0356cz(C0358da c0358da) {
        super(c0358da);
        this.f1244e = (byte) -1;
        this.f1245f = -1;
    }

    private C0356cz(boolean z) {
        this.f1244e = (byte) -1;
        this.f1245f = -1;
    }

    /* renamed from: a */
    public static C0356cz m2355a() {
        return f1240a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0356cz getDefaultInstanceForType() {
        return f1240a;
    }

    /* renamed from: c */
    public boolean m2363c() {
        return (this.f1241b & 1) == 1;
    }

    /* renamed from: d */
    public String m2364d() {
        Object obj = this.f1242c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1242c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m2359i() {
        Object obj = this.f1242c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1242c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m2365e() {
        return (this.f1241b & 2) == 2;
    }

    /* renamed from: f */
    public String m2366f() {
        Object obj = this.f1243d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1243d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: j */
    private ByteString m2360j() {
        Object obj = this.f1243d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1243d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    private void m2361k() {
        this.f1242c = "";
        this.f1243d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1244e;
        if (b != -1) {
            return b == 1;
        }
        this.f1244e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1241b & 1) == 1) {
            codedOutputStream.writeBytes(1, m2359i());
        }
        if ((this.f1241b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2360j());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f1245f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f1241b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m2359i()) : 0;
            if ((this.f1241b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m2360j());
            }
            this.f1245f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0358da newBuilder() {
        return C0358da.m2389h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0358da newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0358da m2356a(C0356cz c0356cz) {
        return newBuilder().mergeFrom(c0356cz);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0358da toBuilder() {
        return m2356a(this);
    }

    static {
        f1240a.m2361k();
    }
}
