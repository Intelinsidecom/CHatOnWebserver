package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.r */
/* loaded from: classes.dex */
public final class C0403r extends GeneratedMessageLite implements InterfaceC0405t {

    /* renamed from: a */
    private static final C0403r f1428a = new C0403r(true);

    /* renamed from: b */
    private int f1429b;

    /* renamed from: c */
    private Object f1430c;

    /* renamed from: d */
    private List<C0406u> f1431d;

    /* renamed from: e */
    private C0369dl f1432e;

    /* renamed from: f */
    private byte f1433f;

    /* renamed from: g */
    private int f1434g;

    private C0403r(C0404s c0404s) {
        super(c0404s);
        this.f1433f = (byte) -1;
        this.f1434g = -1;
    }

    private C0403r(boolean z) {
        this.f1433f = (byte) -1;
        this.f1434g = -1;
    }

    /* renamed from: a */
    public static C0403r m2927a() {
        return f1428a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0403r getDefaultInstanceForType() {
        return f1428a;
    }

    /* renamed from: c */
    public boolean m2936c() {
        return (this.f1429b & 1) == 1;
    }

    /* renamed from: d */
    public String m2937d() {
        Object obj = this.f1430c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1430c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m2933i() {
        Object obj = this.f1430c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1430c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m2938e() {
        return (this.f1429b & 2) == 2;
    }

    /* renamed from: f */
    public C0369dl m2939f() {
        return this.f1432e;
    }

    /* renamed from: j */
    private void m2934j() {
        this.f1430c = "";
        this.f1431d = Collections.emptyList();
        this.f1432e = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1433f;
        if (b != -1) {
            return b == 1;
        }
        this.f1433f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1429b & 1) == 1) {
            codedOutputStream.writeBytes(1, m2933i());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1431d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.f1431d.get(i2));
            i = i2 + 1;
        }
        if ((this.f1429b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f1432e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f1434g;
        if (iComputeMessageSize == -1) {
            int iComputeBytesSize = (this.f1429b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m2933i()) + 0 : 0;
            while (true) {
                iComputeMessageSize = iComputeBytesSize;
                if (i >= this.f1431d.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(2, this.f1431d.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f1429b & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f1432e);
            }
            this.f1434g = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0403r m2928a(byte[] bArr) {
        return ((C0404s) newBuilder().mergeFrom(bArr)).m2946m();
    }

    public static C0404s newBuilder() {
        return C0404s.m2945l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0404s newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0404s m2929a(C0403r c0403r) {
        return newBuilder().mergeFrom(c0403r);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0404s toBuilder() {
        return m2929a(this);
    }

    static {
        f1428a.m2934j();
    }
}
