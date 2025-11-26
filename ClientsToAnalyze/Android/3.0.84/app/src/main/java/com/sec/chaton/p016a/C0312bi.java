package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bi */
/* loaded from: classes.dex */
public final class C0312bi extends GeneratedMessageLite implements InterfaceC0314bk {

    /* renamed from: a */
    private static final C0312bi f1040a = new C0312bi(true);

    /* renamed from: b */
    private int f1041b;

    /* renamed from: c */
    private Object f1042c;

    /* renamed from: d */
    private Object f1043d;

    /* renamed from: e */
    private long f1044e;

    /* renamed from: f */
    private EnumC0354cx f1045f;

    /* renamed from: g */
    private byte f1046g;

    /* renamed from: h */
    private int f1047h;

    private C0312bi(C0313bj c0313bj) {
        super(c0313bj);
        this.f1046g = (byte) -1;
        this.f1047h = -1;
    }

    private C0312bi(boolean z) {
        this.f1046g = (byte) -1;
        this.f1047h = -1;
    }

    /* renamed from: a */
    public static C0312bi m1816a() {
        return f1040a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0312bi getDefaultInstanceForType() {
        return f1040a;
    }

    /* renamed from: c */
    public boolean m1825c() {
        return (this.f1041b & 1) == 1;
    }

    /* renamed from: d */
    public String m1826d() {
        Object obj = this.f1042c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1042c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m1821m() {
        Object obj = this.f1042c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1042c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1827e() {
        return (this.f1041b & 2) == 2;
    }

    /* renamed from: f */
    public String m1828f() {
        Object obj = this.f1043d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1043d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m1822n() {
        Object obj = this.f1043d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1043d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1829g() {
        return (this.f1041b & 4) == 4;
    }

    /* renamed from: h */
    public long m1830h() {
        return this.f1044e;
    }

    /* renamed from: i */
    public boolean m1831i() {
        return (this.f1041b & 8) == 8;
    }

    /* renamed from: j */
    public EnumC0354cx m1832j() {
        return this.f1045f;
    }

    /* renamed from: o */
    private void m1823o() {
        this.f1042c = "";
        this.f1043d = "";
        this.f1044e = 0L;
        this.f1045f = EnumC0354cx.TEXT;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1046g;
        if (b != -1) {
            return b == 1;
        }
        this.f1046g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1041b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1821m());
        }
        if ((this.f1041b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1822n());
        }
        if ((this.f1041b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f1044e);
        }
        if ((this.f1041b & 8) == 8) {
            codedOutputStream.writeEnum(4, this.f1045f.getNumber());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f1047h;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f1041b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m1821m()) : 0;
            if ((this.f1041b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m1822n());
            }
            if ((this.f1041b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(3, this.f1044e);
            }
            if ((this.f1041b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(4, this.f1045f.getNumber());
            }
            this.f1047h = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0313bj newBuilder() {
        return C0313bj.m1837h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0313bj newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0313bj m1817a(C0312bi c0312bi) {
        return newBuilder().mergeFrom(c0312bi);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0313bj toBuilder() {
        return m1817a(this);
    }

    static {
        f1040a.m1823o();
    }
}
