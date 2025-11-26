package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.c */
/* loaded from: classes.dex */
public final class C0314c extends GeneratedMessageLite implements InterfaceC0279as {

    /* renamed from: a */
    private static final C0314c f876a = new C0314c(true);

    /* renamed from: b */
    private int f877b;

    /* renamed from: c */
    private long f878c;

    /* renamed from: d */
    private Object f879d;

    /* renamed from: e */
    private List f880e;

    /* renamed from: f */
    private LazyStringList f881f;

    /* renamed from: g */
    private long f882g;

    /* renamed from: h */
    private Object f883h;

    /* renamed from: i */
    private byte f884i;

    /* renamed from: j */
    private int f885j;

    private C0314c(C0303bp c0303bp) {
        super(c0303bp);
        this.f884i = (byte) -1;
        this.f885j = -1;
    }

    private C0314c(boolean z) {
        this.f884i = (byte) -1;
        this.f885j = -1;
    }

    /* renamed from: a */
    public static C0314c m1635a() {
        return f876a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0314c getDefaultInstanceForType() {
        return f876a;
    }

    /* renamed from: c */
    public boolean m1648c() {
        return (this.f877b & 1) == 1;
    }

    /* renamed from: d */
    public long m1649d() {
        return this.f878c;
    }

    /* renamed from: e */
    public boolean m1650e() {
        return (this.f877b & 2) == 2;
    }

    /* renamed from: f */
    public String m1651f() {
        Object obj = this.f879d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f879d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m1643q() {
        Object obj = this.f879d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f879d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public List m1652g() {
        return this.f880e;
    }

    /* renamed from: h */
    public int m1653h() {
        return this.f880e.size();
    }

    /* renamed from: a */
    public C0333g m1646a(int i) {
        return (C0333g) this.f880e.get(i);
    }

    /* renamed from: i */
    public List m1654i() {
        return this.f881f;
    }

    /* renamed from: j */
    public int m1655j() {
        return this.f881f.size();
    }

    /* renamed from: k */
    public boolean m1656k() {
        return (this.f877b & 4) == 4;
    }

    /* renamed from: l */
    public long m1657l() {
        return this.f882g;
    }

    /* renamed from: m */
    public boolean m1658m() {
        return (this.f877b & 8) == 8;
    }

    /* renamed from: n */
    public String m1659n() {
        Object obj = this.f883h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f883h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m1644r() {
        Object obj = this.f883h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f883h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: s */
    private void m1645s() {
        this.f878c = 0L;
        this.f879d = "";
        this.f880e = Collections.emptyList();
        this.f881f = LazyStringArrayList.EMPTY;
        this.f882g = 0L;
        this.f883h = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f884i;
        if (b != -1) {
            return b == 1;
        }
        this.f884i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f877b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f878c);
        }
        if ((this.f877b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1643q());
        }
        for (int i = 0; i < this.f880e.size(); i++) {
            codedOutputStream.writeMessage(3, (MessageLite) this.f880e.get(i));
        }
        for (int i2 = 0; i2 < this.f881f.size(); i2++) {
            codedOutputStream.writeBytes(4, this.f881f.getByteString(i2));
        }
        if ((this.f877b & 4) == 4) {
            codedOutputStream.writeInt64(5, this.f882g);
        }
        if ((this.f877b & 8) == 8) {
            codedOutputStream.writeBytes(6, m1644r());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f885j;
        if (size == -1) {
            int iComputeInt64Size = (this.f877b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f878c) + 0 : 0;
            if ((this.f877b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m1643q());
            }
            int iComputeMessageSize = iComputeInt64Size;
            for (int i = 0; i < this.f880e.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, (MessageLite) this.f880e.get(i));
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f881f.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f881f.getByteString(i2));
            }
            size = iComputeBytesSizeNoTag + iComputeMessageSize + (m1654i().size() * 1);
            if ((this.f877b & 4) == 4) {
                size += CodedOutputStream.computeInt64Size(5, this.f882g);
            }
            if ((this.f877b & 8) == 8) {
                size += CodedOutputStream.computeBytesSize(6, m1644r());
            }
            this.f885j = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0314c m1636a(byte[] bArr) {
        return ((C0303bp) newBuilder().mergeFrom(bArr)).m1449i();
    }

    public static C0303bp newBuilder() {
        return C0303bp.m1448h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0303bp newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0303bp m1634a(C0314c c0314c) {
        return newBuilder().mergeFrom(c0314c);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0303bp toBuilder() {
        return m1634a(this);
    }

    static {
        f876a.m1645s();
    }
}
