package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.co */
/* loaded from: classes.dex */
public final class C0329co extends GeneratedMessageLite implements InterfaceC0335i {

    /* renamed from: a */
    private static final C0329co f933a = new C0329co(true);

    /* renamed from: b */
    private int f934b;

    /* renamed from: c */
    private Object f935c;

    /* renamed from: d */
    private LazyStringList f936d;

    /* renamed from: e */
    private long f937e;

    /* renamed from: f */
    private Object f938f;

    /* renamed from: g */
    private long f939g;

    /* renamed from: h */
    private EnumC0275ao f940h;

    /* renamed from: i */
    private EnumC0323ci f941i;

    /* renamed from: j */
    private byte f942j;

    /* renamed from: k */
    private int f943k;

    private C0329co(C0297bj c0297bj) {
        super(c0297bj);
        this.f942j = (byte) -1;
        this.f943k = -1;
    }

    private C0329co(boolean z) {
        this.f942j = (byte) -1;
        this.f943k = -1;
    }

    /* renamed from: a */
    public static C0329co m1807a() {
        return f933a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0329co getDefaultInstanceForType() {
        return f933a;
    }

    /* renamed from: c */
    public boolean m1817c() {
        return (this.f934b & 1) == 1;
    }

    /* renamed from: d */
    public String m1818d() {
        Object obj = this.f935c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f935c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m1812s() {
        Object obj = this.f935c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f935c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List m1819e() {
        return this.f936d;
    }

    /* renamed from: f */
    public int m1820f() {
        return this.f936d.size();
    }

    /* renamed from: a */
    public String m1815a(int i) {
        return (String) this.f936d.get(i);
    }

    /* renamed from: g */
    public boolean m1821g() {
        return (this.f934b & 2) == 2;
    }

    /* renamed from: h */
    public long m1822h() {
        return this.f937e;
    }

    /* renamed from: i */
    public boolean m1823i() {
        return (this.f934b & 4) == 4;
    }

    /* renamed from: j */
    public String m1824j() {
        Object obj = this.f938f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f938f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m1813t() {
        Object obj = this.f938f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f938f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1825k() {
        return (this.f934b & 8) == 8;
    }

    /* renamed from: l */
    public long m1826l() {
        return this.f939g;
    }

    /* renamed from: m */
    public boolean m1827m() {
        return (this.f934b & 16) == 16;
    }

    /* renamed from: n */
    public EnumC0275ao m1828n() {
        return this.f940h;
    }

    /* renamed from: o */
    public boolean m1829o() {
        return (this.f934b & 32) == 32;
    }

    /* renamed from: p */
    public EnumC0323ci m1830p() {
        return this.f941i;
    }

    /* renamed from: u */
    private void m1814u() {
        this.f935c = "";
        this.f936d = LazyStringArrayList.EMPTY;
        this.f937e = 0L;
        this.f938f = "";
        this.f939g = 0L;
        this.f940h = EnumC0275ao.TEXT;
        this.f941i = EnumC0323ci.SINGLE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f942j;
        if (b != -1) {
            return b == 1;
        }
        this.f942j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f934b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1812s());
        }
        for (int i = 0; i < this.f936d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f936d.getByteString(i));
        }
        if ((this.f934b & 2) == 2) {
            codedOutputStream.writeInt64(3, this.f937e);
        }
        if ((this.f934b & 4) == 4) {
            codedOutputStream.writeBytes(4, m1813t());
        }
        if ((this.f934b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f939g);
        }
        if ((this.f934b & 16) == 16) {
            codedOutputStream.writeEnum(6, this.f940h.getNumber());
        }
        if ((this.f934b & 32) == 32) {
            codedOutputStream.writeEnum(7, this.f941i.getNumber());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f943k;
        if (size == -1) {
            int iComputeBytesSize = (this.f934b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m1812s()) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f936d.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f936d.getByteString(i));
            }
            size = iComputeBytesSize + iComputeBytesSizeNoTag + (m1819e().size() * 1);
            if ((this.f934b & 2) == 2) {
                size += CodedOutputStream.computeInt64Size(3, this.f937e);
            }
            if ((this.f934b & 4) == 4) {
                size += CodedOutputStream.computeBytesSize(4, m1813t());
            }
            if ((this.f934b & 8) == 8) {
                size += CodedOutputStream.computeInt64Size(5, this.f939g);
            }
            if ((this.f934b & 16) == 16) {
                size += CodedOutputStream.computeEnumSize(6, this.f940h.getNumber());
            }
            if ((this.f934b & 32) == 32) {
                size += CodedOutputStream.computeEnumSize(7, this.f941i.getNumber());
            }
            this.f943k = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0297bj newBuilder() {
        return C0297bj.m1342h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0297bj newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0297bj m1805a(C0329co c0329co) {
        return newBuilder().mergeFrom(c0329co);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0297bj toBuilder() {
        return m1805a(this);
    }

    static {
        f933a.m1814u();
    }
}
