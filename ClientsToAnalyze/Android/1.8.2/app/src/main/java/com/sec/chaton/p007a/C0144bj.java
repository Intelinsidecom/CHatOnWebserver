package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bj */
/* loaded from: classes.dex */
public final class C0144bj extends GeneratedMessageLite implements InterfaceC0146bl {

    /* renamed from: a */
    private static final C0144bj f494a = new C0144bj(true);

    /* renamed from: b */
    private int f495b;

    /* renamed from: c */
    private Object f496c;

    /* renamed from: d */
    private LazyStringList f497d;

    /* renamed from: e */
    private long f498e;

    /* renamed from: f */
    private Object f499f;

    /* renamed from: g */
    private long f500g;

    /* renamed from: h */
    private EnumC0159by f501h;

    /* renamed from: i */
    private EnumC0116ai f502i;

    /* renamed from: j */
    private byte f503j;

    /* renamed from: k */
    private int f504k;

    private C0144bj(C0145bk c0145bk) {
        super(c0145bk);
        this.f503j = (byte) -1;
        this.f504k = -1;
    }

    private C0144bj(boolean z) {
        this.f503j = (byte) -1;
        this.f504k = -1;
    }

    /* renamed from: a */
    public static C0144bj m1099a() {
        return f494a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0144bj getDefaultInstanceForType() {
        return f494a;
    }

    /* renamed from: c */
    public boolean m1111c() {
        return (this.f495b & 1) == 1;
    }

    /* renamed from: d */
    public String m1112d() {
        Object obj = this.f496c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f496c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m1106s() {
        Object obj = this.f496c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f496c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List m1113e() {
        return this.f497d;
    }

    /* renamed from: f */
    public int m1114f() {
        return this.f497d.size();
    }

    /* renamed from: a */
    public String m1109a(int i) {
        return (String) this.f497d.get(i);
    }

    /* renamed from: g */
    public boolean m1115g() {
        return (this.f495b & 2) == 2;
    }

    /* renamed from: h */
    public long m1116h() {
        return this.f498e;
    }

    /* renamed from: i */
    public boolean m1117i() {
        return (this.f495b & 4) == 4;
    }

    /* renamed from: j */
    public String m1118j() {
        Object obj = this.f499f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f499f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m1107t() {
        Object obj = this.f499f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f499f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1119k() {
        return (this.f495b & 8) == 8;
    }

    /* renamed from: l */
    public long m1120l() {
        return this.f500g;
    }

    /* renamed from: m */
    public boolean m1121m() {
        return (this.f495b & 16) == 16;
    }

    /* renamed from: n */
    public EnumC0159by m1122n() {
        return this.f501h;
    }

    /* renamed from: o */
    public boolean m1123o() {
        return (this.f495b & 32) == 32;
    }

    /* renamed from: p */
    public EnumC0116ai m1124p() {
        return this.f502i;
    }

    /* renamed from: u */
    private void m1108u() {
        this.f496c = "";
        this.f497d = LazyStringArrayList.EMPTY;
        this.f498e = 0L;
        this.f499f = "";
        this.f500g = 0L;
        this.f501h = EnumC0159by.TEXT;
        this.f502i = EnumC0116ai.SINGLE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f503j;
        if (b != -1) {
            return b == 1;
        }
        this.f503j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f495b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1106s());
        }
        for (int i = 0; i < this.f497d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f497d.getByteString(i));
        }
        if ((this.f495b & 2) == 2) {
            codedOutputStream.writeInt64(3, this.f498e);
        }
        if ((this.f495b & 4) == 4) {
            codedOutputStream.writeBytes(4, m1107t());
        }
        if ((this.f495b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f500g);
        }
        if ((this.f495b & 16) == 16) {
            codedOutputStream.writeEnum(6, this.f501h.getNumber());
        }
        if ((this.f495b & 32) == 32) {
            codedOutputStream.writeEnum(7, this.f502i.getNumber());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f504k;
        if (size == -1) {
            int iComputeBytesSize = (this.f495b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m1106s()) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f497d.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f497d.getByteString(i));
            }
            size = iComputeBytesSize + iComputeBytesSizeNoTag + (m1113e().size() * 1);
            if ((this.f495b & 2) == 2) {
                size += CodedOutputStream.computeInt64Size(3, this.f498e);
            }
            if ((this.f495b & 4) == 4) {
                size += CodedOutputStream.computeBytesSize(4, m1107t());
            }
            if ((this.f495b & 8) == 8) {
                size += CodedOutputStream.computeInt64Size(5, this.f500g);
            }
            if ((this.f495b & 16) == 16) {
                size += CodedOutputStream.computeEnumSize(6, this.f501h.getNumber());
            }
            if ((this.f495b & 32) == 32) {
                size += CodedOutputStream.computeEnumSize(7, this.f502i.getNumber());
            }
            this.f504k = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0145bk newBuilder() {
        return C0145bk.m1129h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0145bk newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0145bk m1100a(C0144bj c0144bj) {
        return newBuilder().mergeFrom(c0144bj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0145bk toBuilder() {
        return m1100a(this);
    }

    static {
        f494a.m1108u();
    }
}
