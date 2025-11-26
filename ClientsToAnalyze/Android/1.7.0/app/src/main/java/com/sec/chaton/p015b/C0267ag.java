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
/* renamed from: com.sec.chaton.b.ag */
/* loaded from: classes.dex */
public final class C0267ag extends GeneratedMessageLite implements InterfaceC0252a {

    /* renamed from: a */
    private static final C0267ag f674a = new C0267ag(true);

    /* renamed from: b */
    private int f675b;

    /* renamed from: c */
    private long f676c;

    /* renamed from: d */
    private EnumC0323ci f677d;

    /* renamed from: e */
    private Object f678e;

    /* renamed from: f */
    private Object f679f;

    /* renamed from: g */
    private Object f680g;

    /* renamed from: h */
    private LazyStringList f681h;

    /* renamed from: i */
    private byte f682i;

    /* renamed from: j */
    private int f683j;

    private C0267ag(C0300bm c0300bm) {
        super(c0300bm);
        this.f682i = (byte) -1;
        this.f683j = -1;
    }

    private C0267ag(boolean z) {
        this.f682i = (byte) -1;
        this.f683j = -1;
    }

    /* renamed from: a */
    public static C0267ag m1055a() {
        return f674a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0267ag getDefaultInstanceForType() {
        return f674a;
    }

    /* renamed from: c */
    public boolean m1068c() {
        return (this.f675b & 1) == 1;
    }

    /* renamed from: d */
    public long m1069d() {
        return this.f676c;
    }

    /* renamed from: e */
    public boolean m1070e() {
        return (this.f675b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0323ci m1071f() {
        return this.f677d;
    }

    /* renamed from: g */
    public boolean m1072g() {
        return (this.f675b & 4) == 4;
    }

    /* renamed from: h */
    public String m1073h() {
        Object obj = this.f678e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f678e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m1063p() {
        Object obj = this.f678e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f678e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m1074i() {
        return (this.f675b & 8) == 8;
    }

    /* renamed from: j */
    public String m1075j() {
        Object obj = this.f679f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f679f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m1064q() {
        Object obj = this.f679f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f679f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1076k() {
        return (this.f675b & 16) == 16;
    }

    /* renamed from: l */
    public String m1077l() {
        Object obj = this.f680g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f680g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m1065r() {
        Object obj = this.f680g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f680g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public List m1078m() {
        return this.f681h;
    }

    /* renamed from: s */
    private void m1066s() {
        this.f676c = 0L;
        this.f677d = EnumC0323ci.SINGLE;
        this.f678e = "";
        this.f679f = "";
        this.f680g = "";
        this.f681h = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f682i;
        if (b != -1) {
            return b == 1;
        }
        this.f682i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f675b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f676c);
        }
        if ((this.f675b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f677d.getNumber());
        }
        if ((this.f675b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1063p());
        }
        if ((this.f675b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1064q());
        }
        if ((this.f675b & 16) == 16) {
            codedOutputStream.writeBytes(5, m1065r());
        }
        for (int i = 0; i < this.f681h.size(); i++) {
            codedOutputStream.writeBytes(6, this.f681h.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f683j;
        if (i == -1) {
            int iComputeInt64Size = (this.f675b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f676c) + 0 : 0;
            if ((this.f675b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f677d.getNumber());
            }
            if ((this.f675b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1063p());
            }
            if ((this.f675b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1064q());
            }
            if ((this.f675b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m1065r());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f681h.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f681h.getByteString(i2));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m1078m().size() * 1);
            this.f683j = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0267ag m1056a(byte[] bArr) {
        return ((C0300bm) newBuilder().mergeFrom(bArr)).m1409n();
    }

    public static C0300bm newBuilder() {
        return C0300bm.m1408m();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0300bm newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0300bm m1057a(C0267ag c0267ag) {
        return newBuilder().mergeFrom(c0267ag);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0300bm toBuilder() {
        return m1057a(this);
    }

    static {
        f674a.m1066s();
    }
}
