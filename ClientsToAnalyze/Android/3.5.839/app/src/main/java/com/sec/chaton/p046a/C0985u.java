package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.u */
/* loaded from: classes.dex */
public final class C0985u extends GeneratedMessageLite implements InterfaceC0987w {

    /* renamed from: a */
    private static final C0985u f3219a = new C0985u(true);

    /* renamed from: b */
    private int f3220b;

    /* renamed from: c */
    private Object f3221c;

    /* renamed from: d */
    private List<C0988x> f3222d;

    /* renamed from: e */
    private C0935fh f3223e;

    /* renamed from: f */
    private Object f3224f;

    /* renamed from: g */
    private long f3225g;

    /* renamed from: h */
    private byte f3226h;

    /* renamed from: i */
    private int f3227i;

    private C0985u(C0986v c0986v) {
        super(c0986v);
        this.f3226h = (byte) -1;
        this.f3227i = -1;
    }

    private C0985u(boolean z) {
        this.f3226h = (byte) -1;
        this.f3227i = -1;
    }

    /* renamed from: a */
    public static C0985u m5962a() {
        return f3219a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0985u getDefaultInstanceForType() {
        return f3219a;
    }

    /* renamed from: c */
    public boolean m5973c() {
        return (this.f3220b & 1) == 1;
    }

    /* renamed from: d */
    public String m5974d() {
        Object obj = this.f3221c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3221c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m5969m() {
        Object obj = this.f3221c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3221c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m5975e() {
        return (this.f3220b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m5976f() {
        return this.f3223e;
    }

    /* renamed from: g */
    public boolean m5977g() {
        return (this.f3220b & 4) == 4;
    }

    /* renamed from: h */
    public String m5978h() {
        Object obj = this.f3224f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3224f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m5970n() {
        Object obj = this.f3224f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3224f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m5979i() {
        return (this.f3220b & 8) == 8;
    }

    /* renamed from: j */
    public long m5980j() {
        return this.f3225g;
    }

    /* renamed from: o */
    private void m5971o() {
        this.f3221c = "";
        this.f3222d = Collections.emptyList();
        this.f3223e = C0935fh.m5211a();
        this.f3224f = "";
        this.f3225g = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3226h;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3226h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3220b & 1) == 1) {
            codedOutputStream.writeBytes(1, m5969m());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3222d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.f3222d.get(i2));
            i = i2 + 1;
        }
        if ((this.f3220b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f3223e);
        }
        if ((this.f3220b & 4) == 4) {
            codedOutputStream.writeBytes(4, m5970n());
        }
        if ((this.f3220b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f3225g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeInt64Size = this.f3227i;
        if (iComputeInt64Size == -1) {
            int iComputeBytesSize = (this.f3220b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m5969m()) + 0 : 0;
            while (true) {
                iComputeInt64Size = iComputeBytesSize;
                if (i >= this.f3222d.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(2, this.f3222d.get(i)) + iComputeInt64Size;
                i++;
            }
            if ((this.f3220b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f3223e);
            }
            if ((this.f3220b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m5970n());
            }
            if ((this.f3220b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(5, this.f3225g);
            }
            this.f3227i = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0985u m5963a(byte[] bArr) {
        return ((C0986v) newBuilder().mergeFrom(bArr)).m5987m();
    }

    public static C0986v newBuilder() {
        return C0986v.m5986l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0986v newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0986v m5964a(C0985u c0985u) {
        return newBuilder().mergeFrom(c0985u);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0986v toBuilder() {
        return m5964a(this);
    }

    static {
        f3219a.m5971o();
    }
}
