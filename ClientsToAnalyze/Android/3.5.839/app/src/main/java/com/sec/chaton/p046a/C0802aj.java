package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aj */
/* loaded from: classes.dex */
public final class C0802aj extends GeneratedMessageLite implements InterfaceC0804al {

    /* renamed from: a */
    private static final C0802aj f2224a = new C0802aj(true);

    /* renamed from: b */
    private int f2225b;

    /* renamed from: c */
    private EnumC0813au f2226c;

    /* renamed from: d */
    private Object f2227d;

    /* renamed from: e */
    private Object f2228e;

    /* renamed from: f */
    private byte f2229f;

    /* renamed from: g */
    private int f2230g;

    private C0802aj(C0803ak c0803ak) {
        super(c0803ak);
        this.f2229f = (byte) -1;
        this.f2230g = -1;
    }

    private C0802aj(boolean z) {
        this.f2229f = (byte) -1;
        this.f2230g = -1;
    }

    /* renamed from: a */
    public static C0802aj m3277a() {
        return f2224a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0802aj getDefaultInstanceForType() {
        return f2224a;
    }

    /* renamed from: c */
    public boolean m3286c() {
        return (this.f2225b & 1) == 1;
    }

    /* renamed from: d */
    public EnumC0813au m3287d() {
        return this.f2226c;
    }

    /* renamed from: e */
    public boolean m3288e() {
        return (this.f2225b & 2) == 2;
    }

    /* renamed from: f */
    public String m3289f() {
        Object obj = this.f2227d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2227d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m3282k() {
        Object obj = this.f2227d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2227d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m3290g() {
        return (this.f2225b & 4) == 4;
    }

    /* renamed from: h */
    public String m3291h() {
        Object obj = this.f2228e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2228e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m3283l() {
        Object obj = this.f2228e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2228e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    private void m3284m() {
        this.f2226c = EnumC0813au.ENTER;
        this.f2227d = "";
        this.f2228e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2229f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2229f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2225b & 1) == 1) {
            codedOutputStream.writeEnum(1, this.f2226c.getNumber());
        }
        if ((this.f2225b & 2) == 2) {
            codedOutputStream.writeBytes(2, m3282k());
        }
        if ((this.f2225b & 4) == 4) {
            codedOutputStream.writeBytes(3, m3283l());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeEnumSize = this.f2230g;
        if (iComputeEnumSize == -1) {
            iComputeEnumSize = (this.f2225b & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f2226c.getNumber()) : 0;
            if ((this.f2225b & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(2, m3282k());
            }
            if ((this.f2225b & 4) == 4) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(3, m3283l());
            }
            this.f2230g = iComputeEnumSize;
        }
        return iComputeEnumSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0803ak newBuilder() {
        return C0803ak.m3296h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0803ak newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0803ak m3278a(C0802aj c0802aj) {
        return newBuilder().mergeFrom(c0802aj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0803ak toBuilder() {
        return m3278a(this);
    }

    static {
        f2224a.m3284m();
    }
}
