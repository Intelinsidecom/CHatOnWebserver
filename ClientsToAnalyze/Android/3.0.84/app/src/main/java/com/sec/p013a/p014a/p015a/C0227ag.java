package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ag */
/* loaded from: classes.dex */
public final class C0227ag extends GeneratedMessageLite implements InterfaceC0229ai {

    /* renamed from: a */
    private static final C0227ag f485a = new C0227ag(true);

    /* renamed from: b */
    private int f486b;

    /* renamed from: c */
    private Object f487c;

    /* renamed from: d */
    private Object f488d;

    /* renamed from: e */
    private Object f489e;

    /* renamed from: f */
    private Object f490f;

    /* renamed from: g */
    private Object f491g;

    /* renamed from: h */
    private byte f492h;

    /* renamed from: i */
    private int f493i;

    private C0227ag(C0228ah c0228ah) {
        super(c0228ah);
        this.f492h = (byte) -1;
        this.f493i = -1;
    }

    private C0227ag(boolean z) {
        this.f492h = (byte) -1;
        this.f493i = -1;
    }

    /* renamed from: a */
    public static C0227ag m668a() {
        return f485a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0227ag getDefaultInstanceForType() {
        return f485a;
    }

    /* renamed from: c */
    public boolean m683c() {
        return (this.f486b & 1) == 1;
    }

    /* renamed from: d */
    public String m684d() {
        Object obj = this.f487c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f487c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m676o() {
        Object obj = this.f487c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f487c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m685e() {
        return (this.f486b & 2) == 2;
    }

    /* renamed from: f */
    public String m686f() {
        Object obj = this.f488d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f488d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m677p() {
        Object obj = this.f488d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f488d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m687g() {
        return (this.f486b & 4) == 4;
    }

    /* renamed from: h */
    public String m688h() {
        Object obj = this.f489e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f489e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m678q() {
        Object obj = this.f489e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f489e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m689i() {
        return (this.f486b & 8) == 8;
    }

    /* renamed from: j */
    public String m690j() {
        Object obj = this.f490f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f490f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m679r() {
        Object obj = this.f490f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f490f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m691k() {
        return (this.f486b & 16) == 16;
    }

    /* renamed from: l */
    public String m692l() {
        Object obj = this.f491g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f491g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m680s() {
        Object obj = this.f491g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f491g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    private void m681t() {
        this.f487c = "";
        this.f488d = "";
        this.f489e = "";
        this.f490f = "";
        this.f491g = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f492h;
        if (b != -1) {
            return b == 1;
        }
        this.f492h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f486b & 1) == 1) {
            codedOutputStream.writeBytes(2, m676o());
        }
        if ((this.f486b & 2) == 2) {
            codedOutputStream.writeBytes(3, m677p());
        }
        if ((this.f486b & 4) == 4) {
            codedOutputStream.writeBytes(4, m678q());
        }
        if ((this.f486b & 8) == 8) {
            codedOutputStream.writeBytes(5, m679r());
        }
        if ((this.f486b & 16) == 16) {
            codedOutputStream.writeBytes(6, m680s());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f493i;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f486b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(2, m676o()) : 0;
            if ((this.f486b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(3, m677p());
            }
            if ((this.f486b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(4, m678q());
            }
            if ((this.f486b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(5, m679r());
            }
            if ((this.f486b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m680s());
            }
            this.f493i = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0227ag m669a(byte[] bArr) {
        return ((C0228ah) newBuilder().mergeFrom(bArr)).m699i();
    }

    public static C0228ah newBuilder() {
        return C0228ah.m698h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0228ah newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0228ah m670a(C0227ag c0227ag) {
        return newBuilder().mergeFrom(c0227ag);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0228ah toBuilder() {
        return m670a(this);
    }

    static {
        f485a.m681t();
    }
}
