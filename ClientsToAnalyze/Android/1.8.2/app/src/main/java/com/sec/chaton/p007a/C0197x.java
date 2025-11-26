package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.x */
/* loaded from: classes.dex */
public final class C0197x extends GeneratedMessageLite implements InterfaceC0199z {

    /* renamed from: a */
    private static final C0197x f713a = new C0197x(true);

    /* renamed from: b */
    private int f714b;

    /* renamed from: c */
    private EnumC0108aa f715c;

    /* renamed from: d */
    private Object f716d;

    /* renamed from: e */
    private Object f717e;

    /* renamed from: f */
    private byte f718f;

    /* renamed from: g */
    private int f719g;

    private C0197x(C0198y c0198y) {
        super(c0198y);
        this.f718f = (byte) -1;
        this.f719g = -1;
    }

    private C0197x(boolean z) {
        this.f718f = (byte) -1;
        this.f719g = -1;
    }

    /* renamed from: a */
    public static C0197x m1761a() {
        return f713a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0197x getDefaultInstanceForType() {
        return f713a;
    }

    /* renamed from: c */
    public boolean m1769c() {
        return (this.f714b & 1) == 1;
    }

    /* renamed from: d */
    public EnumC0108aa m1770d() {
        return this.f715c;
    }

    /* renamed from: e */
    public boolean m1771e() {
        return (this.f714b & 2) == 2;
    }

    /* renamed from: f */
    public String m1772f() {
        Object obj = this.f716d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f716d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m1765k() {
        Object obj = this.f716d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f716d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1773g() {
        return (this.f714b & 4) == 4;
    }

    /* renamed from: h */
    public String m1774h() {
        Object obj = this.f717e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f717e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m1766l() {
        Object obj = this.f717e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f717e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    private void m1767m() {
        this.f715c = EnumC0108aa.ENTER;
        this.f716d = "";
        this.f717e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f718f;
        if (b != -1) {
            return b == 1;
        }
        this.f718f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f714b & 1) == 1) {
            codedOutputStream.writeEnum(1, this.f715c.getNumber());
        }
        if ((this.f714b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1765k());
        }
        if ((this.f714b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1766l());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeEnumSize = this.f719g;
        if (iComputeEnumSize == -1) {
            iComputeEnumSize = (this.f714b & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f715c.getNumber()) : 0;
            if ((this.f714b & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(2, m1765k());
            }
            if ((this.f714b & 4) == 4) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(3, m1766l());
            }
            this.f719g = iComputeEnumSize;
        }
        return iComputeEnumSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0198y newBuilder() {
        return C0198y.m1779h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0198y newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0198y m1762a(C0197x c0197x) {
        return newBuilder().mergeFrom(c0197x);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0198y toBuilder() {
        return m1762a(this);
    }

    static {
        f713a.m1767m();
    }
}
