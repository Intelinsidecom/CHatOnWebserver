package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dl */
/* loaded from: classes.dex */
public final class C0369dl extends GeneratedMessageLite implements InterfaceC0371dn {

    /* renamed from: a */
    private static final C0369dl f1278a = new C0369dl(true);

    /* renamed from: b */
    private int f1279b;

    /* renamed from: c */
    private int f1280c;

    /* renamed from: d */
    private Object f1281d;

    /* renamed from: e */
    private C0388ed f1282e;

    /* renamed from: f */
    private C0366di f1283f;

    /* renamed from: g */
    private byte f1284g;

    /* renamed from: h */
    private int f1285h;

    private C0369dl(C0370dm c0370dm) {
        super(c0370dm);
        this.f1284g = (byte) -1;
        this.f1285h = -1;
    }

    private C0369dl(boolean z) {
        this.f1284g = (byte) -1;
        this.f1285h = -1;
    }

    /* renamed from: a */
    public static C0369dl m2485a() {
        return f1278a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0369dl getDefaultInstanceForType() {
        return f1278a;
    }

    /* renamed from: c */
    public boolean m2493c() {
        return (this.f1279b & 1) == 1;
    }

    /* renamed from: d */
    public int m2494d() {
        return this.f1280c;
    }

    /* renamed from: e */
    public boolean m2495e() {
        return (this.f1279b & 2) == 2;
    }

    /* renamed from: f */
    public String m2496f() {
        Object obj = this.f1281d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1281d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m2490m() {
        Object obj = this.f1281d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1281d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m2497g() {
        return (this.f1279b & 4) == 4;
    }

    /* renamed from: h */
    public C0388ed m2498h() {
        return this.f1282e;
    }

    /* renamed from: i */
    public boolean m2499i() {
        return (this.f1279b & 8) == 8;
    }

    /* renamed from: j */
    public C0366di m2500j() {
        return this.f1283f;
    }

    /* renamed from: n */
    private void m2491n() {
        this.f1280c = 0;
        this.f1281d = "";
        this.f1282e = C0388ed.m2718a();
        this.f1283f = C0366di.m2462a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1284g;
        if (b != -1) {
            return b == 1;
        }
        this.f1284g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1279b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f1280c);
        }
        if ((this.f1279b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2490m());
        }
        if ((this.f1279b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f1282e);
        }
        if ((this.f1279b & 8) == 8) {
            codedOutputStream.writeMessage(4, this.f1283f);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1285h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1279b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f1280c) : 0;
            if ((this.f1279b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m2490m());
            }
            if ((this.f1279b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.f1282e);
            }
            if ((this.f1279b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.f1283f);
            }
            this.f1285h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0370dm newBuilder() {
        return C0370dm.m2505l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0370dm newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0370dm m2486a(C0369dl c0369dl) {
        return newBuilder().mergeFrom(c0369dl);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0370dm toBuilder() {
        return m2486a(this);
    }

    static {
        f1278a.m2491n();
    }
}
