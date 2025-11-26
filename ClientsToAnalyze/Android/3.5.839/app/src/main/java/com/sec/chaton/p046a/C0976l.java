package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.l */
/* loaded from: classes.dex */
public final class C0976l extends GeneratedMessageLite implements InterfaceC0978n {

    /* renamed from: a */
    private static final C0976l f3174a = new C0976l(true);

    /* renamed from: b */
    private int f3175b;

    /* renamed from: c */
    private long f3176c;

    /* renamed from: d */
    private Object f3177d;

    /* renamed from: e */
    private List<C0802aj> f3178e;

    /* renamed from: f */
    private LazyStringList f3179f;

    /* renamed from: g */
    private long f3180g;

    /* renamed from: h */
    private Object f3181h;

    /* renamed from: i */
    private long f3182i;

    /* renamed from: j */
    private C0960gf f3183j;

    /* renamed from: k */
    private byte f3184k;

    /* renamed from: l */
    private int f3185l;

    private C0976l(C0977m c0977m) {
        super(c0977m);
        this.f3184k = (byte) -1;
        this.f3185l = -1;
    }

    private C0976l(boolean z) {
        this.f3184k = (byte) -1;
        this.f3185l = -1;
    }

    /* renamed from: a */
    public static C0976l m5824a() {
        return f3174a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0976l getDefaultInstanceForType() {
        return f3174a;
    }

    /* renamed from: c */
    public boolean m5839c() {
        return (this.f3175b & 1) == 1;
    }

    /* renamed from: d */
    public long m5840d() {
        return this.f3176c;
    }

    /* renamed from: e */
    public boolean m5841e() {
        return (this.f3175b & 2) == 2;
    }

    /* renamed from: f */
    public String m5842f() {
        Object obj = this.f3177d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3177d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m5834u() {
        Object obj = this.f3177d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3177d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public List<C0802aj> m5843g() {
        return this.f3178e;
    }

    /* renamed from: h */
    public int m5844h() {
        return this.f3178e.size();
    }

    /* renamed from: a */
    public C0802aj m5837a(int i) {
        return this.f3178e.get(i);
    }

    /* renamed from: i */
    public List<String> m5845i() {
        return this.f3179f;
    }

    /* renamed from: j */
    public int m5846j() {
        return this.f3179f.size();
    }

    /* renamed from: k */
    public boolean m5847k() {
        return (this.f3175b & 4) == 4;
    }

    /* renamed from: l */
    public long m5848l() {
        return this.f3180g;
    }

    /* renamed from: m */
    public boolean m5849m() {
        return (this.f3175b & 8) == 8;
    }

    /* renamed from: n */
    public String m5850n() {
        Object obj = this.f3181h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3181h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m5835v() {
        Object obj = this.f3181h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3181h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m5851o() {
        return (this.f3175b & 16) == 16;
    }

    /* renamed from: p */
    public long m5852p() {
        return this.f3182i;
    }

    /* renamed from: q */
    public boolean m5853q() {
        return (this.f3175b & 32) == 32;
    }

    /* renamed from: r */
    public C0960gf m5854r() {
        return this.f3183j;
    }

    /* renamed from: w */
    private void m5836w() {
        this.f3176c = 0L;
        this.f3177d = "";
        this.f3178e = Collections.emptyList();
        this.f3179f = LazyStringArrayList.EMPTY;
        this.f3180g = 0L;
        this.f3181h = "";
        this.f3182i = 0L;
        this.f3183j = C0960gf.m5581a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3184k;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3184k = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3175b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f3176c);
        }
        if ((this.f3175b & 2) == 2) {
            codedOutputStream.writeBytes(2, m5834u());
        }
        for (int i = 0; i < this.f3178e.size(); i++) {
            codedOutputStream.writeMessage(3, this.f3178e.get(i));
        }
        for (int i2 = 0; i2 < this.f3179f.size(); i2++) {
            codedOutputStream.writeBytes(4, this.f3179f.getByteString(i2));
        }
        if ((this.f3175b & 4) == 4) {
            codedOutputStream.writeInt64(5, this.f3180g);
        }
        if ((this.f3175b & 8) == 8) {
            codedOutputStream.writeBytes(6, m5835v());
        }
        if ((this.f3175b & 16) == 16) {
            codedOutputStream.writeInt64(7, this.f3182i);
        }
        if ((this.f3175b & 32) == 32) {
            codedOutputStream.writeMessage(8, this.f3183j);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f3185l;
        if (size == -1) {
            int iComputeInt64Size = (this.f3175b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f3176c) + 0 : 0;
            if ((this.f3175b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m5834u());
            }
            int iComputeMessageSize = iComputeInt64Size;
            for (int i = 0; i < this.f3178e.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f3178e.get(i));
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f3179f.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f3179f.getByteString(i2));
            }
            size = iComputeBytesSizeNoTag + iComputeMessageSize + (m5845i().size() * 1);
            if ((this.f3175b & 4) == 4) {
                size += CodedOutputStream.computeInt64Size(5, this.f3180g);
            }
            if ((this.f3175b & 8) == 8) {
                size += CodedOutputStream.computeBytesSize(6, m5835v());
            }
            if ((this.f3175b & 16) == 16) {
                size += CodedOutputStream.computeInt64Size(7, this.f3182i);
            }
            if ((this.f3175b & 32) == 32) {
                size += CodedOutputStream.computeMessageSize(8, this.f3183j);
            }
            this.f3185l = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0976l m5825a(byte[] bArr) {
        return ((C0977m) newBuilder().mergeFrom(bArr)).m5861k();
    }

    public static C0977m newBuilder() {
        return C0977m.m5860j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C0977m newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0977m m5826a(C0976l c0976l) {
        return newBuilder().mergeFrom(c0976l);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0977m toBuilder() {
        return m5826a(this);
    }

    static {
        f3174a.m5836w();
    }
}
