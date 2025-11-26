package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.do */
/* loaded from: classes.dex */
public final class C0372do extends GeneratedMessageLite implements InterfaceC0374dq {

    /* renamed from: a */
    private static final C0372do f1291a = new C0372do(true);

    /* renamed from: b */
    private int f1292b;

    /* renamed from: c */
    private long f1293c;

    /* renamed from: d */
    private Object f1294d;

    /* renamed from: e */
    private List<C0381dx> f1295e;

    /* renamed from: f */
    private C0385ea f1296f;

    /* renamed from: g */
    private byte f1297g;

    /* renamed from: h */
    private int f1298h;

    private C0372do(C0373dp c0373dp) {
        super(c0373dp);
        this.f1297g = (byte) -1;
        this.f1298h = -1;
    }

    private C0372do(boolean z) {
        this.f1297g = (byte) -1;
        this.f1298h = -1;
    }

    /* renamed from: a */
    public static C0372do m2525a() {
        return f1291a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0372do getDefaultInstanceForType() {
        return f1291a;
    }

    /* renamed from: c */
    public boolean m2535c() {
        return (this.f1292b & 1) == 1;
    }

    /* renamed from: d */
    public long m2536d() {
        return this.f1293c;
    }

    /* renamed from: e */
    public boolean m2537e() {
        return (this.f1292b & 2) == 2;
    }

    /* renamed from: f */
    public String m2538f() {
        Object obj = this.f1294d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1294d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m2532l() {
        Object obj = this.f1294d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1294d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public List<C0381dx> m2539g() {
        return this.f1295e;
    }

    /* renamed from: h */
    public boolean m2540h() {
        return (this.f1292b & 4) == 4;
    }

    /* renamed from: i */
    public C0385ea m2541i() {
        return this.f1296f;
    }

    /* renamed from: m */
    private void m2533m() {
        this.f1293c = 0L;
        this.f1294d = "";
        this.f1295e = Collections.emptyList();
        this.f1296f = C0385ea.m2690a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1297g;
        if (b != -1) {
            return b == 1;
        }
        this.f1297g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1292b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1293c);
        }
        if ((this.f1292b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2532l());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1295e.size()) {
                break;
            }
            codedOutputStream.writeMessage(3, this.f1295e.get(i2));
            i = i2 + 1;
        }
        if ((this.f1292b & 4) == 4) {
            codedOutputStream.writeMessage(4, this.f1296f);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f1298h;
        if (iComputeMessageSize == -1) {
            int iComputeInt64Size = (this.f1292b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1293c) + 0 : 0;
            if ((this.f1292b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m2532l());
            }
            while (true) {
                iComputeMessageSize = iComputeInt64Size;
                if (i >= this.f1295e.size()) {
                    break;
                }
                iComputeInt64Size = CodedOutputStream.computeMessageSize(3, this.f1295e.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f1292b & 4) == 4) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.f1296f);
            }
            this.f1298h = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0372do m2526a(byte[] bArr) {
        return ((C0373dp) newBuilder().mergeFrom(bArr)).m2548k();
    }

    public static C0373dp newBuilder() {
        return C0373dp.m2547j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0373dp newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0373dp m2527a(C0372do c0372do) {
        return newBuilder().mergeFrom(c0372do);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0373dp toBuilder() {
        return m2527a(this);
    }

    static {
        f1291a.m2533m();
    }
}
