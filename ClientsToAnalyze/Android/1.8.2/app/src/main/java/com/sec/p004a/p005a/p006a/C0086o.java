package com.sec.p004a.p005a.p006a;

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
public final class C0086o extends GeneratedMessageLite implements InterfaceC0088q {

    /* renamed from: a */
    private static final C0086o f151a = new C0086o(true);

    /* renamed from: b */
    private int f152b;

    /* renamed from: c */
    private Object f153c;

    /* renamed from: d */
    private LazyStringList f154d;

    /* renamed from: e */
    private byte f155e;

    /* renamed from: f */
    private int f156f;

    private C0086o(C0087p c0087p) {
        super(c0087p);
        this.f155e = (byte) -1;
        this.f156f = -1;
    }

    private C0086o(boolean z) {
        this.f155e = (byte) -1;
        this.f156f = -1;
    }

    /* renamed from: a */
    public static C0086o m427a() {
        return f151a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0086o getDefaultInstanceForType() {
        return f151a;
    }

    /* renamed from: c */
    public boolean m435c() {
        return (this.f152b & 1) == 1;
    }

    /* renamed from: d */
    public String m436d() {
        Object obj = this.f153c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f153c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: h */
    private ByteString m432h() {
        Object obj = this.f153c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f153c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List m437e() {
        return this.f154d;
    }

    /* renamed from: i */
    private void m433i() {
        this.f153c = "";
        this.f154d = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f155e;
        if (b != -1) {
            return b == 1;
        }
        this.f155e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f152b & 1) == 1) {
            codedOutputStream.writeBytes(1, m432h());
        }
        for (int i = 0; i < this.f154d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f154d.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f156f;
        if (i == -1) {
            int iComputeBytesSize = (this.f152b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m432h()) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f154d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f154d.getByteString(i2));
            }
            int size = iComputeBytesSize + iComputeBytesSizeNoTag + (m437e().size() * 1);
            this.f156f = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0086o m428a(byte[] bArr) {
        return ((C0087p) newBuilder().mergeFrom(bArr)).m444i();
    }

    public static C0087p newBuilder() {
        return C0087p.m443h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0087p newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0087p m429a(C0086o c0086o) {
        return newBuilder().mergeFrom(c0086o);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0087p toBuilder() {
        return m429a(this);
    }

    static {
        f151a.m433i();
    }
}
