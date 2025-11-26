package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ad */
/* loaded from: classes.dex */
public final class C0796ad extends GeneratedMessageLite implements InterfaceC0798af {

    /* renamed from: a */
    private static final C0796ad f2194a = new C0796ad(true);

    /* renamed from: b */
    private int f2195b;

    /* renamed from: c */
    private long f2196c;

    /* renamed from: d */
    private Object f2197d;

    /* renamed from: e */
    private Object f2198e;

    /* renamed from: f */
    private List<C0799ag> f2199f;

    /* renamed from: g */
    private byte f2200g;

    /* renamed from: h */
    private int f2201h;

    private C0796ad(C0797ae c0797ae) {
        super(c0797ae);
        this.f2200g = (byte) -1;
        this.f2201h = -1;
    }

    private C0796ad(boolean z) {
        this.f2200g = (byte) -1;
        this.f2201h = -1;
    }

    /* renamed from: a */
    public static C0796ad m3196a() {
        return f2194a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0796ad getDefaultInstanceForType() {
        return f2194a;
    }

    /* renamed from: c */
    public boolean m3207c() {
        return (this.f2195b & 1) == 1;
    }

    /* renamed from: d */
    public long m3208d() {
        return this.f2196c;
    }

    /* renamed from: e */
    public boolean m3209e() {
        return (this.f2195b & 2) == 2;
    }

    /* renamed from: f */
    public String m3210f() {
        Object obj = this.f2197d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2197d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m3203k() {
        Object obj = this.f2197d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2197d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m3211g() {
        return (this.f2195b & 4) == 4;
    }

    /* renamed from: h */
    public String m3212h() {
        Object obj = this.f2198e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2198e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m3204l() {
        Object obj = this.f2198e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2198e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    private void m3205m() {
        this.f2196c = 0L;
        this.f2197d = "";
        this.f2198e = "";
        this.f2199f = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2200g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2200g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2195b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2196c);
        }
        if ((this.f2195b & 2) == 2) {
            codedOutputStream.writeBytes(2, m3203k());
        }
        if ((this.f2195b & 4) == 4) {
            codedOutputStream.writeBytes(3, m3204l());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2199f.size()) {
                codedOutputStream.writeMessage(4, this.f2199f.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int i2 = this.f2201h;
        if (i2 == -1) {
            int iComputeInt64Size = (this.f2195b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2196c) + 0 : 0;
            if ((this.f2195b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m3203k());
            }
            if ((this.f2195b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m3204l());
            }
            while (true) {
                i2 = iComputeInt64Size;
                if (i >= this.f2199f.size()) {
                    break;
                }
                iComputeInt64Size = CodedOutputStream.computeMessageSize(4, this.f2199f.get(i)) + i2;
                i++;
            }
            this.f2201h = i2;
        }
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0796ad m3197a(byte[] bArr) {
        return ((C0797ae) newBuilder().mergeFrom(bArr)).m3219i();
    }

    public static C0797ae newBuilder() {
        return C0797ae.m3218h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0797ae newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0797ae m3198a(C0796ad c0796ad) {
        return newBuilder().mergeFrom(c0796ad);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0797ae toBuilder() {
        return m3198a(this);
    }

    static {
        f2194a.m3205m();
    }
}
