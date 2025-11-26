package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.am */
/* loaded from: classes.dex */
public final class C0233am extends GeneratedMessageLite implements InterfaceC0235ao {

    /* renamed from: a */
    private static final C0233am f515a = new C0233am(true);

    /* renamed from: b */
    private int f516b;

    /* renamed from: c */
    private int f517c;

    /* renamed from: d */
    private Object f518d;

    /* renamed from: e */
    private Object f519e;

    /* renamed from: f */
    private Object f520f;

    /* renamed from: g */
    private byte f521g;

    /* renamed from: h */
    private int f522h;

    private C0233am(C0234an c0234an) {
        super(c0234an);
        this.f521g = (byte) -1;
        this.f522h = -1;
    }

    private C0233am(boolean z) {
        this.f521g = (byte) -1;
        this.f522h = -1;
    }

    /* renamed from: a */
    public static C0233am m756a() {
        return f515a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0233am getDefaultInstanceForType() {
        return f515a;
    }

    /* renamed from: c */
    public boolean m768c() {
        return (this.f516b & 1) == 1;
    }

    /* renamed from: d */
    public int m769d() {
        return this.f517c;
    }

    /* renamed from: e */
    public boolean m770e() {
        return (this.f516b & 2) == 2;
    }

    /* renamed from: f */
    public String m771f() {
        Object obj = this.f518d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f518d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m763m() {
        Object obj = this.f518d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f518d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m772g() {
        return (this.f516b & 4) == 4;
    }

    /* renamed from: h */
    public String m773h() {
        Object obj = this.f519e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f519e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m764n() {
        Object obj = this.f519e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f519e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m774i() {
        return (this.f516b & 8) == 8;
    }

    /* renamed from: j */
    public String m775j() {
        Object obj = this.f520f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f520f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m765o() {
        Object obj = this.f520f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f520f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    private void m766p() {
        this.f517c = 0;
        this.f518d = "";
        this.f519e = "";
        this.f520f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f521g;
        if (b != -1) {
            return b == 1;
        }
        this.f521g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f516b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f517c);
        }
        if ((this.f516b & 2) == 2) {
            codedOutputStream.writeBytes(2, m763m());
        }
        if ((this.f516b & 4) == 4) {
            codedOutputStream.writeBytes(3, m764n());
        }
        if ((this.f516b & 8) == 8) {
            codedOutputStream.writeBytes(4, m765o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f522h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f516b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f517c) : 0;
            if ((this.f516b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m763m());
            }
            if ((this.f516b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m764n());
            }
            if ((this.f516b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m765o());
            }
            this.f522h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0233am m757a(byte[] bArr) {
        return ((C0234an) newBuilder().mergeFrom(bArr)).m782i();
    }

    public static C0234an newBuilder() {
        return C0234an.m781h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0234an newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0234an m758a(C0233am c0233am) {
        return newBuilder().mergeFrom(c0233am);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0234an toBuilder() {
        return m758a(this);
    }

    static {
        f515a.m766p();
    }
}
