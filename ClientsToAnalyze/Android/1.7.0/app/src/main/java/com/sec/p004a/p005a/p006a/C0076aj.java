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
/* renamed from: com.sec.a.a.a.aj */
/* loaded from: classes.dex */
public final class C0076aj extends GeneratedMessageLite implements InterfaceC0105x {

    /* renamed from: a */
    private static final C0076aj f89a = new C0076aj(true);

    /* renamed from: b */
    private int f90b;

    /* renamed from: c */
    private Object f91c;

    /* renamed from: d */
    private LazyStringList f92d;

    /* renamed from: e */
    private byte f93e;

    /* renamed from: f */
    private int f94f;

    private C0076aj(C0073ag c0073ag) {
        super(c0073ag);
        this.f93e = (byte) -1;
        this.f94f = -1;
    }

    private C0076aj(boolean z) {
        this.f93e = (byte) -1;
        this.f94f = -1;
    }

    /* renamed from: a */
    public static C0076aj m253a() {
        return f89a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0076aj getDefaultInstanceForType() {
        return f89a;
    }

    /* renamed from: c */
    public boolean m260c() {
        return (this.f90b & 1) == 1;
    }

    /* renamed from: d */
    public String m261d() {
        Object obj = this.f91c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f91c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: h */
    private ByteString m257h() {
        Object obj = this.f91c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f91c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List m262e() {
        return this.f92d;
    }

    /* renamed from: i */
    private void m258i() {
        this.f91c = "";
        this.f92d = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f93e;
        if (b != -1) {
            return b == 1;
        }
        this.f93e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f90b & 1) == 1) {
            codedOutputStream.writeBytes(1, m257h());
        }
        for (int i = 0; i < this.f92d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f92d.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f94f;
        if (i == -1) {
            int iComputeBytesSize = (this.f90b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m257h()) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f92d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f92d.getByteString(i2));
            }
            int size = iComputeBytesSize + iComputeBytesSizeNoTag + (m262e().size() * 1);
            this.f94f = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0076aj m254a(byte[] bArr) {
        return ((C0073ag) newBuilder().mergeFrom(bArr)).m201i();
    }

    public static C0073ag newBuilder() {
        return C0073ag.m200h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0073ag newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0073ag m252a(C0076aj c0076aj) {
        return newBuilder().mergeFrom(c0076aj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0073ag toBuilder() {
        return m252a(this);
    }

    static {
        f89a.m258i();
    }
}
