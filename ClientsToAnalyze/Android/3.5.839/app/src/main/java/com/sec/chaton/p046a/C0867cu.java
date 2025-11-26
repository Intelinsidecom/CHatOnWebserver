package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cu */
/* loaded from: classes.dex */
public final class C0867cu extends GeneratedMessageLite implements InterfaceC0869cw {

    /* renamed from: a */
    private static final C0867cu f2586a = new C0867cu(true);

    /* renamed from: b */
    private int f2587b;

    /* renamed from: c */
    private Object f2588c;

    /* renamed from: d */
    private Object f2589d;

    /* renamed from: e */
    private long f2590e;

    /* renamed from: f */
    private long f2591f;

    /* renamed from: g */
    private EnumC0908eh f2592g;

    /* renamed from: h */
    private EnumC0822bc f2593h;

    /* renamed from: i */
    private Object f2594i;

    /* renamed from: j */
    private byte f2595j;

    /* renamed from: k */
    private int f2596k;

    private C0867cu(C0868cv c0868cv) {
        super(c0868cv);
        this.f2595j = (byte) -1;
        this.f2596k = -1;
    }

    private C0867cu(boolean z) {
        this.f2595j = (byte) -1;
        this.f2596k = -1;
    }

    /* renamed from: a */
    public static C0867cu m4191a() {
        return f2586a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0867cu getDefaultInstanceForType() {
        return f2586a;
    }

    /* renamed from: c */
    public boolean m4203c() {
        return (this.f2587b & 1) == 1;
    }

    /* renamed from: d */
    public String m4204d() {
        Object obj = this.f2588c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2588c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m4198s() {
        Object obj = this.f2588c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2588c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m4205e() {
        return (this.f2587b & 2) == 2;
    }

    /* renamed from: f */
    public String m4206f() {
        Object obj = this.f2589d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2589d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m4199t() {
        Object obj = this.f2589d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2589d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m4207g() {
        return (this.f2587b & 4) == 4;
    }

    /* renamed from: h */
    public long m4208h() {
        return this.f2590e;
    }

    /* renamed from: i */
    public boolean m4209i() {
        return (this.f2587b & 8) == 8;
    }

    /* renamed from: j */
    public long m4210j() {
        return this.f2591f;
    }

    /* renamed from: k */
    public boolean m4211k() {
        return (this.f2587b & 16) == 16;
    }

    /* renamed from: l */
    public EnumC0908eh m4212l() {
        return this.f2592g;
    }

    /* renamed from: m */
    public boolean m4213m() {
        return (this.f2587b & 32) == 32;
    }

    /* renamed from: n */
    public EnumC0822bc m4214n() {
        return this.f2593h;
    }

    /* renamed from: o */
    public boolean m4215o() {
        return (this.f2587b & 64) == 64;
    }

    /* renamed from: p */
    public String m4216p() {
        Object obj = this.f2594i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2594i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m4200u() {
        Object obj = this.f2594i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2594i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: v */
    private void m4201v() {
        this.f2588c = "";
        this.f2589d = "";
        this.f2590e = 0L;
        this.f2591f = 0L;
        this.f2592g = EnumC0908eh.TEXT;
        this.f2593h = EnumC0822bc.SINGLE;
        this.f2594i = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2595j;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2595j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2587b & 1) == 1) {
            codedOutputStream.writeBytes(1, m4198s());
        }
        if ((this.f2587b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4199t());
        }
        if ((this.f2587b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f2590e);
        }
        if ((this.f2587b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f2591f);
        }
        if ((this.f2587b & 16) == 16) {
            codedOutputStream.writeEnum(5, this.f2592g.getNumber());
        }
        if ((this.f2587b & 32) == 32) {
            codedOutputStream.writeEnum(6, this.f2593h.getNumber());
        }
        if ((this.f2587b & 64) == 64) {
            codedOutputStream.writeBytes(7, m4200u());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2596k;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2587b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m4198s()) : 0;
            if ((this.f2587b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m4199t());
            }
            if ((this.f2587b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(3, this.f2590e);
            }
            if ((this.f2587b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(4, this.f2591f);
            }
            if ((this.f2587b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(5, this.f2592g.getNumber());
            }
            if ((this.f2587b & 32) == 32) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(6, this.f2593h.getNumber());
            }
            if ((this.f2587b & 64) == 64) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(7, m4200u());
            }
            this.f2596k = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0868cv newBuilder() {
        return C0868cv.m4221h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0868cv newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0868cv m4192a(C0867cu c0867cu) {
        return newBuilder().mergeFrom(c0867cu);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0868cv toBuilder() {
        return m4192a(this);
    }

    static {
        f2586a.m4201v();
    }
}
