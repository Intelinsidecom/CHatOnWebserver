package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ap */
/* loaded from: classes.dex */
public final class C0123ap extends GeneratedMessageLite implements InterfaceC0125ar {

    /* renamed from: a */
    private static final C0123ap f423a = new C0123ap(true);

    /* renamed from: b */
    private int f424b;

    /* renamed from: c */
    private Object f425c;

    /* renamed from: d */
    private Object f426d;

    /* renamed from: e */
    private long f427e;

    /* renamed from: f */
    private EnumC0159by f428f;

    /* renamed from: g */
    private byte f429g;

    /* renamed from: h */
    private int f430h;

    private C0123ap(C0124aq c0124aq) {
        super(c0124aq);
        this.f429g = (byte) -1;
        this.f430h = -1;
    }

    private C0123ap(boolean z) {
        this.f429g = (byte) -1;
        this.f430h = -1;
    }

    /* renamed from: a */
    public static C0123ap m904a() {
        return f423a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0123ap getDefaultInstanceForType() {
        return f423a;
    }

    /* renamed from: c */
    public boolean m913c() {
        return (this.f424b & 1) == 1;
    }

    /* renamed from: d */
    public String m914d() {
        Object obj = this.f425c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f425c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m909m() {
        Object obj = this.f425c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f425c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m915e() {
        return (this.f424b & 2) == 2;
    }

    /* renamed from: f */
    public String m916f() {
        Object obj = this.f426d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f426d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m910n() {
        Object obj = this.f426d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f426d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m917g() {
        return (this.f424b & 4) == 4;
    }

    /* renamed from: h */
    public long m918h() {
        return this.f427e;
    }

    /* renamed from: i */
    public boolean m919i() {
        return (this.f424b & 8) == 8;
    }

    /* renamed from: j */
    public EnumC0159by m920j() {
        return this.f428f;
    }

    /* renamed from: o */
    private void m911o() {
        this.f425c = "";
        this.f426d = "";
        this.f427e = 0L;
        this.f428f = EnumC0159by.TEXT;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f429g;
        if (b != -1) {
            return b == 1;
        }
        this.f429g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f424b & 1) == 1) {
            codedOutputStream.writeBytes(1, m909m());
        }
        if ((this.f424b & 2) == 2) {
            codedOutputStream.writeBytes(2, m910n());
        }
        if ((this.f424b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f427e);
        }
        if ((this.f424b & 8) == 8) {
            codedOutputStream.writeEnum(4, this.f428f.getNumber());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f430h;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f424b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m909m()) : 0;
            if ((this.f424b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m910n());
            }
            if ((this.f424b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(3, this.f427e);
            }
            if ((this.f424b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(4, this.f428f.getNumber());
            }
            this.f430h = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0124aq newBuilder() {
        return C0124aq.m925h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0124aq newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0124aq m905a(C0123ap c0123ap) {
        return newBuilder().mergeFrom(c0123ap);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0124aq toBuilder() {
        return m905a(this);
    }

    static {
        f423a.m911o();
    }
}
