package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bl */
/* loaded from: classes.dex */
public final class C0831bl extends GeneratedMessageLite implements InterfaceC0833bn {

    /* renamed from: a */
    private static final C0831bl f2402a = new C0831bl(true);

    /* renamed from: b */
    private int f2403b;

    /* renamed from: c */
    private Object f2404c;

    /* renamed from: d */
    private Object f2405d;

    /* renamed from: e */
    private long f2406e;

    /* renamed from: f */
    private EnumC0908eh f2407f;

    /* renamed from: g */
    private byte f2408g;

    /* renamed from: h */
    private int f2409h;

    private C0831bl(C0832bm c0832bm) {
        super(c0832bm);
        this.f2408g = (byte) -1;
        this.f2409h = -1;
    }

    private C0831bl(boolean z) {
        this.f2408g = (byte) -1;
        this.f2409h = -1;
    }

    /* renamed from: a */
    public static C0831bl m3692a() {
        return f2402a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0831bl getDefaultInstanceForType() {
        return f2402a;
    }

    /* renamed from: c */
    public boolean m3701c() {
        return (this.f2403b & 1) == 1;
    }

    /* renamed from: d */
    public String m3702d() {
        Object obj = this.f2404c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2404c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m3697m() {
        Object obj = this.f2404c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2404c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m3703e() {
        return (this.f2403b & 2) == 2;
    }

    /* renamed from: f */
    public String m3704f() {
        Object obj = this.f2405d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2405d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m3698n() {
        Object obj = this.f2405d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2405d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m3705g() {
        return (this.f2403b & 4) == 4;
    }

    /* renamed from: h */
    public long m3706h() {
        return this.f2406e;
    }

    /* renamed from: i */
    public boolean m3707i() {
        return (this.f2403b & 8) == 8;
    }

    /* renamed from: j */
    public EnumC0908eh m3708j() {
        return this.f2407f;
    }

    /* renamed from: o */
    private void m3699o() {
        this.f2404c = "";
        this.f2405d = "";
        this.f2406e = 0L;
        this.f2407f = EnumC0908eh.TEXT;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2408g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2408g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2403b & 1) == 1) {
            codedOutputStream.writeBytes(1, m3697m());
        }
        if ((this.f2403b & 2) == 2) {
            codedOutputStream.writeBytes(2, m3698n());
        }
        if ((this.f2403b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f2406e);
        }
        if ((this.f2403b & 8) == 8) {
            codedOutputStream.writeEnum(4, this.f2407f.getNumber());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2409h;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2403b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m3697m()) : 0;
            if ((this.f2403b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m3698n());
            }
            if ((this.f2403b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(3, this.f2406e);
            }
            if ((this.f2403b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(4, this.f2407f.getNumber());
            }
            this.f2409h = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0832bm newBuilder() {
        return C0832bm.m3713h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0832bm newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0832bm m3693a(C0831bl c0831bl) {
        return newBuilder().mergeFrom(c0831bl);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0832bm toBuilder() {
        return m3693a(this);
    }

    static {
        f2402a.m3699o();
    }
}
