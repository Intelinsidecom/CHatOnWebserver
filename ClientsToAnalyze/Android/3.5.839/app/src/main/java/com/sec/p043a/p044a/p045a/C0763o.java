package com.sec.p043a.p044a.p045a;

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
public final class C0763o extends GeneratedMessageLite implements InterfaceC0765q {

    /* renamed from: a */
    private static final C0763o f1810a = new C0763o(true);

    /* renamed from: b */
    private int f1811b;

    /* renamed from: c */
    private Object f1812c;

    /* renamed from: d */
    private LazyStringList f1813d;

    /* renamed from: e */
    private byte f1814e;

    /* renamed from: f */
    private int f1815f;

    private C0763o(C0764p c0764p) {
        super(c0764p);
        this.f1814e = (byte) -1;
        this.f1815f = -1;
    }

    private C0763o(boolean z) {
        this.f1814e = (byte) -1;
        this.f1815f = -1;
    }

    /* renamed from: a */
    public static C0763o m2671a() {
        return f1810a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0763o getDefaultInstanceForType() {
        return f1810a;
    }

    /* renamed from: c */
    public boolean m2679c() {
        return (this.f1811b & 1) == 1;
    }

    /* renamed from: d */
    public String m2680d() {
        Object obj = this.f1812c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1812c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: h */
    private ByteString m2676h() {
        Object obj = this.f1812c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1812c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List<String> m2681e() {
        return this.f1813d;
    }

    /* renamed from: i */
    private void m2677i() {
        this.f1812c = "";
        this.f1813d = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1814e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1814e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1811b & 1) == 1) {
            codedOutputStream.writeBytes(1, m2676h());
        }
        for (int i = 0; i < this.f1813d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f1813d.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f1815f;
        if (i == -1) {
            int iComputeBytesSize = (this.f1811b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m2676h()) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f1813d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1813d.getByteString(i2));
            }
            int size = iComputeBytesSize + iComputeBytesSizeNoTag + (m2681e().size() * 1);
            this.f1815f = size;
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
    public static C0763o m2672a(byte[] bArr) {
        return ((C0764p) newBuilder().mergeFrom(bArr)).m2688i();
    }

    public static C0764p newBuilder() {
        return C0764p.m2687h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0764p newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0764p m2673a(C0763o c0763o) {
        return newBuilder().mergeFrom(c0763o);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0764p toBuilder() {
        return m2673a(this);
    }

    static {
        f1810a.m2677i();
    }
}
