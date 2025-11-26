package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.o */
/* loaded from: classes.dex */
public final class C0250o extends GeneratedMessageLite implements InterfaceC0252q {

    /* renamed from: a */
    private static final C0250o f574a = new C0250o(true);

    /* renamed from: b */
    private int f575b;

    /* renamed from: c */
    private Object f576c;

    /* renamed from: d */
    private LazyStringList f577d;

    /* renamed from: e */
    private byte f578e;

    /* renamed from: f */
    private int f579f;

    private C0250o(C0251p c0251p) {
        super(c0251p);
        this.f578e = (byte) -1;
        this.f579f = -1;
    }

    private C0250o(boolean z) {
        this.f578e = (byte) -1;
        this.f579f = -1;
    }

    /* renamed from: a */
    public static C0250o m939a() {
        return f574a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0250o getDefaultInstanceForType() {
        return f574a;
    }

    /* renamed from: c */
    public boolean m947c() {
        return (this.f575b & 1) == 1;
    }

    /* renamed from: d */
    public String m948d() {
        Object obj = this.f576c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f576c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: h */
    private ByteString m944h() {
        Object obj = this.f576c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f576c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List<String> m949e() {
        return this.f577d;
    }

    /* renamed from: i */
    private void m945i() {
        this.f576c = "";
        this.f577d = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f578e;
        if (b != -1) {
            return b == 1;
        }
        this.f578e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f575b & 1) == 1) {
            codedOutputStream.writeBytes(1, m944h());
        }
        for (int i = 0; i < this.f577d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f577d.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f579f;
        if (i == -1) {
            int iComputeBytesSize = (this.f575b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m944h()) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f577d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f577d.getByteString(i2));
            }
            int size = iComputeBytesSize + iComputeBytesSizeNoTag + (m949e().size() * 1);
            this.f579f = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0250o m940a(byte[] bArr) {
        return ((C0251p) newBuilder().mergeFrom(bArr)).m956i();
    }

    public static C0251p newBuilder() {
        return C0251p.m955h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0251p newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0251p m941a(C0250o c0250o) {
        return newBuilder().mergeFrom(c0250o);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0251p toBuilder() {
        return m941a(this);
    }

    static {
        f574a.m945i();
    }
}
