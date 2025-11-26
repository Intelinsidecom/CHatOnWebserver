package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ag */
/* loaded from: classes.dex */
public final class C0283ag extends GeneratedMessageLite implements InterfaceC0285ai {

    /* renamed from: a */
    private static final C0283ag f897a = new C0283ag(true);

    /* renamed from: b */
    private int f898b;

    /* renamed from: c */
    private EnumC0294ar f899c;

    /* renamed from: d */
    private Object f900d;

    /* renamed from: e */
    private Object f901e;

    /* renamed from: f */
    private byte f902f;

    /* renamed from: g */
    private int f903g;

    private C0283ag(C0284ah c0284ah) {
        super(c0284ah);
        this.f902f = (byte) -1;
        this.f903g = -1;
    }

    private C0283ag(boolean z) {
        this.f902f = (byte) -1;
        this.f903g = -1;
    }

    /* renamed from: a */
    public static C0283ag m1450a() {
        return f897a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0283ag getDefaultInstanceForType() {
        return f897a;
    }

    /* renamed from: c */
    public boolean m1459c() {
        return (this.f898b & 1) == 1;
    }

    /* renamed from: d */
    public EnumC0294ar m1460d() {
        return this.f899c;
    }

    /* renamed from: e */
    public boolean m1461e() {
        return (this.f898b & 2) == 2;
    }

    /* renamed from: f */
    public String m1462f() {
        Object obj = this.f900d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f900d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m1455k() {
        Object obj = this.f900d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f900d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1463g() {
        return (this.f898b & 4) == 4;
    }

    /* renamed from: h */
    public String m1464h() {
        Object obj = this.f901e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f901e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m1456l() {
        Object obj = this.f901e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f901e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    private void m1457m() {
        this.f899c = EnumC0294ar.ENTER;
        this.f900d = "";
        this.f901e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f902f;
        if (b != -1) {
            return b == 1;
        }
        this.f902f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f898b & 1) == 1) {
            codedOutputStream.writeEnum(1, this.f899c.getNumber());
        }
        if ((this.f898b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1455k());
        }
        if ((this.f898b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1456l());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeEnumSize = this.f903g;
        if (iComputeEnumSize == -1) {
            iComputeEnumSize = (this.f898b & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f899c.getNumber()) : 0;
            if ((this.f898b & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(2, m1455k());
            }
            if ((this.f898b & 4) == 4) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(3, m1456l());
            }
            this.f903g = iComputeEnumSize;
        }
        return iComputeEnumSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0284ah newBuilder() {
        return C0284ah.m1469h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0284ah newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0284ah m1451a(C0283ag c0283ag) {
        return newBuilder().mergeFrom(c0283ag);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0284ah toBuilder() {
        return m1451a(this);
    }

    static {
        f897a.m1457m();
    }
}
