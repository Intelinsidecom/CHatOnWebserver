package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.gl */
/* loaded from: classes.dex */
public final class C0966gl extends GeneratedMessageLite implements InterfaceC0968gn {

    /* renamed from: a */
    private static final C0966gl f3107a = new C0966gl(true);

    /* renamed from: b */
    private int f3108b;

    /* renamed from: c */
    private Object f3109c;

    /* renamed from: d */
    private Object f3110d;

    /* renamed from: e */
    private long f3111e;

    /* renamed from: f */
    private long f3112f;

    /* renamed from: g */
    private LazyStringList f3113g;

    /* renamed from: h */
    private byte f3114h;

    /* renamed from: i */
    private int f3115i;

    private C0966gl(C0967gm c0967gm) {
        super(c0967gm);
        this.f3114h = (byte) -1;
        this.f3115i = -1;
    }

    private C0966gl(boolean z) {
        this.f3114h = (byte) -1;
        this.f3115i = -1;
    }

    /* renamed from: a */
    public static C0966gl m5647a() {
        return f3107a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0966gl getDefaultInstanceForType() {
        return f3107a;
    }

    /* renamed from: c */
    public boolean m5658c() {
        return (this.f3108b & 1) == 1;
    }

    /* renamed from: d */
    public String m5659d() {
        Object obj = this.f3109c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3109c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m5654n() {
        Object obj = this.f3109c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3109c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m5660e() {
        return (this.f3108b & 2) == 2;
    }

    /* renamed from: f */
    public String m5661f() {
        Object obj = this.f3110d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3110d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m5655o() {
        Object obj = this.f3110d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3110d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m5662g() {
        return (this.f3108b & 4) == 4;
    }

    /* renamed from: h */
    public long m5663h() {
        return this.f3111e;
    }

    /* renamed from: i */
    public boolean m5664i() {
        return (this.f3108b & 8) == 8;
    }

    /* renamed from: j */
    public long m5665j() {
        return this.f3112f;
    }

    /* renamed from: k */
    public List<String> m5666k() {
        return this.f3113g;
    }

    /* renamed from: p */
    private void m5656p() {
        this.f3109c = "";
        this.f3110d = "";
        this.f3111e = 0L;
        this.f3112f = 0L;
        this.f3113g = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3114h;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3114h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3108b & 1) == 1) {
            codedOutputStream.writeBytes(1, m5654n());
        }
        if ((this.f3108b & 2) == 2) {
            codedOutputStream.writeBytes(2, m5655o());
        }
        if ((this.f3108b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f3111e);
        }
        if ((this.f3108b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f3112f);
        }
        for (int i = 0; i < this.f3113g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f3113g.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f3115i;
        if (i == -1) {
            int iComputeBytesSize = (this.f3108b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m5654n()) + 0 : 0;
            if ((this.f3108b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m5655o());
            }
            if ((this.f3108b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(3, this.f3111e);
            }
            if ((this.f3108b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(4, this.f3112f);
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f3113g.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f3113g.getByteString(i2));
            }
            int size = iComputeBytesSize + iComputeBytesSizeNoTag + (m5666k().size() * 1);
            this.f3115i = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0966gl m5648a(byte[] bArr) {
        return ((C0967gm) newBuilder().mergeFrom(bArr)).m5673i();
    }

    public static C0967gm newBuilder() {
        return C0967gm.m5672h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0967gm newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0967gm m5649a(C0966gl c0966gl) {
        return newBuilder().mergeFrom(c0966gl);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0967gm toBuilder() {
        return m5649a(this);
    }

    static {
        f3107a.m5656p();
    }
}
