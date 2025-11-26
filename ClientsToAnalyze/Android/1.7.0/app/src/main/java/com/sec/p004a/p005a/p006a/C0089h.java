package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.h */
/* loaded from: classes.dex */
public final class C0089h extends GeneratedMessageLite implements InterfaceC0097p {

    /* renamed from: a */
    private static final C0089h f125a = new C0089h(true);

    /* renamed from: b */
    private int f126b;

    /* renamed from: c */
    private int f127c;

    /* renamed from: d */
    private int f128d;

    /* renamed from: e */
    private Object f129e;

    /* renamed from: f */
    private Object f130f;

    /* renamed from: g */
    private Object f131g;

    /* renamed from: h */
    private byte f132h;

    /* renamed from: i */
    private int f133i;

    private C0089h(C0101t c0101t) {
        super(c0101t);
        this.f132h = (byte) -1;
        this.f133i = -1;
    }

    private C0089h(boolean z) {
        this.f132h = (byte) -1;
        this.f133i = -1;
    }

    /* renamed from: a */
    public static C0089h m347a() {
        return f125a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0089h getDefaultInstanceForType() {
        return f125a;
    }

    /* renamed from: c */
    public boolean m360c() {
        return (this.f126b & 1) == 1;
    }

    /* renamed from: d */
    public int m361d() {
        return this.f127c;
    }

    /* renamed from: e */
    public boolean m362e() {
        return (this.f126b & 2) == 2;
    }

    /* renamed from: f */
    public int m363f() {
        return this.f128d;
    }

    /* renamed from: g */
    public boolean m364g() {
        return (this.f126b & 4) == 4;
    }

    /* renamed from: h */
    public String m365h() {
        Object obj = this.f129e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f129e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m355o() {
        Object obj = this.f129e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f129e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m366i() {
        return (this.f126b & 8) == 8;
    }

    /* renamed from: j */
    public String m367j() {
        Object obj = this.f130f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f130f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m356p() {
        Object obj = this.f130f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f130f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m368k() {
        return (this.f126b & 16) == 16;
    }

    /* renamed from: l */
    public String m369l() {
        Object obj = this.f131g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f131g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m357q() {
        Object obj = this.f131g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f131g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: r */
    private void m358r() {
        this.f127c = 0;
        this.f128d = 0;
        this.f129e = "";
        this.f130f = "";
        this.f131g = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f132h;
        if (b != -1) {
            return b == 1;
        }
        this.f132h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f126b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f127c);
        }
        if ((this.f126b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f128d);
        }
        if ((this.f126b & 4) == 4) {
            codedOutputStream.writeBytes(3, m355o());
        }
        if ((this.f126b & 8) == 8) {
            codedOutputStream.writeBytes(4, m356p());
        }
        if ((this.f126b & 16) == 16) {
            codedOutputStream.writeBytes(5, m357q());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f133i;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f126b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f127c) : 0;
            if ((this.f126b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f128d);
            }
            if ((this.f126b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m355o());
            }
            if ((this.f126b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m356p());
            }
            if ((this.f126b & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(5, m357q());
            }
            this.f133i = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0089h m348a(byte[] bArr) {
        return ((C0101t) newBuilder().mergeFrom(bArr)).m488i();
    }

    public static C0101t newBuilder() {
        return C0101t.m487h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0101t newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0101t m349a(C0089h c0089h) {
        return newBuilder().mergeFrom(c0089h);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0101t toBuilder() {
        return m349a(this);
    }

    static {
        f125a.m358r();
    }
}
