package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.g */
/* loaded from: classes.dex */
public final class C0333g extends GeneratedMessageLite implements InterfaceC0288ba {

    /* renamed from: a */
    private static final C0333g f969a = new C0333g(true);

    /* renamed from: b */
    private int f970b;

    /* renamed from: c */
    private EnumC0274an f971c;

    /* renamed from: d */
    private Object f972d;

    /* renamed from: e */
    private Object f973e;

    /* renamed from: f */
    private byte f974f;

    /* renamed from: g */
    private int f975g;

    private C0333g(C0284ax c0284ax) {
        super(c0284ax);
        this.f974f = (byte) -1;
        this.f975g = -1;
    }

    private C0333g(boolean z) {
        this.f974f = (byte) -1;
        this.f975g = -1;
    }

    /* renamed from: a */
    public static C0333g m1915a() {
        return f969a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0333g getDefaultInstanceForType() {
        return f969a;
    }

    /* renamed from: c */
    public boolean m1922c() {
        return (this.f970b & 1) == 1;
    }

    /* renamed from: d */
    public EnumC0274an m1923d() {
        return this.f971c;
    }

    /* renamed from: e */
    public boolean m1924e() {
        return (this.f970b & 2) == 2;
    }

    /* renamed from: f */
    public String m1925f() {
        Object obj = this.f972d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f972d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m1918k() {
        Object obj = this.f972d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f972d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1926g() {
        return (this.f970b & 4) == 4;
    }

    /* renamed from: h */
    public String m1927h() {
        Object obj = this.f973e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f973e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m1919l() {
        Object obj = this.f973e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f973e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    private void m1920m() {
        this.f971c = EnumC0274an.ENTER;
        this.f972d = "";
        this.f973e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f974f;
        if (b != -1) {
            return b == 1;
        }
        this.f974f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f970b & 1) == 1) {
            codedOutputStream.writeEnum(1, this.f971c.getNumber());
        }
        if ((this.f970b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1918k());
        }
        if ((this.f970b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1919l());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeEnumSize = this.f975g;
        if (iComputeEnumSize == -1) {
            iComputeEnumSize = (this.f970b & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f971c.getNumber()) : 0;
            if ((this.f970b & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(2, m1918k());
            }
            if ((this.f970b & 4) == 4) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(3, m1919l());
            }
            this.f975g = iComputeEnumSize;
        }
        return iComputeEnumSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0284ax newBuilder() {
        return C0284ax.m1264h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0284ax newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0284ax m1914a(C0333g c0333g) {
        return newBuilder().mergeFrom(c0333g);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0284ax toBuilder() {
        return m1914a(this);
    }

    static {
        f969a.m1920m();
    }
}
