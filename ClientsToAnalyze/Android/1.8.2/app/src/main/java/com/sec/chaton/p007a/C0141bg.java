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
/* renamed from: com.sec.chaton.a.bg */
/* loaded from: classes.dex */
public final class C0141bg extends GeneratedMessageLite implements InterfaceC0143bi {

    /* renamed from: a */
    private static final C0141bg f477a = new C0141bg(true);

    /* renamed from: b */
    private int f478b;

    /* renamed from: c */
    private long f479c;

    /* renamed from: d */
    private EnumC0116ai f480d;

    /* renamed from: e */
    private Object f481e;

    /* renamed from: f */
    private Object f482f;

    /* renamed from: g */
    private Object f483g;

    /* renamed from: h */
    private LazyStringList f484h;

    /* renamed from: i */
    private byte f485i;

    /* renamed from: j */
    private int f486j;

    private C0141bg(C0142bh c0142bh) {
        super(c0142bh);
        this.f485i = (byte) -1;
        this.f486j = -1;
    }

    private C0141bg(boolean z) {
        this.f485i = (byte) -1;
        this.f486j = -1;
    }

    /* renamed from: a */
    public static C0141bg m1046a() {
        return f477a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0141bg getDefaultInstanceForType() {
        return f477a;
    }

    /* renamed from: c */
    public boolean m1058c() {
        return (this.f478b & 1) == 1;
    }

    /* renamed from: d */
    public long m1059d() {
        return this.f479c;
    }

    /* renamed from: e */
    public boolean m1060e() {
        return (this.f478b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0116ai m1061f() {
        return this.f480d;
    }

    /* renamed from: g */
    public boolean m1062g() {
        return (this.f478b & 4) == 4;
    }

    /* renamed from: h */
    public String m1063h() {
        Object obj = this.f481e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f481e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m1053p() {
        Object obj = this.f481e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f481e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m1064i() {
        return (this.f478b & 8) == 8;
    }

    /* renamed from: j */
    public String m1065j() {
        Object obj = this.f482f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f482f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m1054q() {
        Object obj = this.f482f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f482f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1066k() {
        return (this.f478b & 16) == 16;
    }

    /* renamed from: l */
    public String m1067l() {
        Object obj = this.f483g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f483g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m1055r() {
        Object obj = this.f483g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f483g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public List m1068m() {
        return this.f484h;
    }

    /* renamed from: s */
    private void m1056s() {
        this.f479c = 0L;
        this.f480d = EnumC0116ai.SINGLE;
        this.f481e = "";
        this.f482f = "";
        this.f483g = "";
        this.f484h = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f485i;
        if (b != -1) {
            return b == 1;
        }
        this.f485i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f478b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f479c);
        }
        if ((this.f478b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f480d.getNumber());
        }
        if ((this.f478b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1053p());
        }
        if ((this.f478b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1054q());
        }
        if ((this.f478b & 16) == 16) {
            codedOutputStream.writeBytes(5, m1055r());
        }
        for (int i = 0; i < this.f484h.size(); i++) {
            codedOutputStream.writeBytes(6, this.f484h.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f486j;
        if (i == -1) {
            int iComputeInt64Size = (this.f478b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f479c) + 0 : 0;
            if ((this.f478b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f480d.getNumber());
            }
            if ((this.f478b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1053p());
            }
            if ((this.f478b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1054q());
            }
            if ((this.f478b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m1055r());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f484h.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f484h.getByteString(i2));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m1068m().size() * 1);
            this.f486j = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0141bg m1047a(byte[] bArr) {
        return ((C0142bh) newBuilder().mergeFrom(bArr)).m1075n();
    }

    public static C0142bh newBuilder() {
        return C0142bh.m1074m();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0142bh newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0142bh m1048a(C0141bg c0141bg) {
        return newBuilder().mergeFrom(c0141bg);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0142bh toBuilder() {
        return m1048a(this);
    }

    static {
        f477a.m1056s();
    }
}
