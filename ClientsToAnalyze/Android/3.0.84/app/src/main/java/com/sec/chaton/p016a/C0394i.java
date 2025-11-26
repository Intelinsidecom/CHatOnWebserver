package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.i */
/* loaded from: classes.dex */
public final class C0394i extends GeneratedMessageLite implements InterfaceC0396k {

    /* renamed from: a */
    private static final C0394i f1396a = new C0394i(true);

    /* renamed from: b */
    private int f1397b;

    /* renamed from: c */
    private long f1398c;

    /* renamed from: d */
    private Object f1399d;

    /* renamed from: e */
    private List<C0283ag> f1400e;

    /* renamed from: f */
    private LazyStringList f1401f;

    /* renamed from: g */
    private long f1402g;

    /* renamed from: h */
    private Object f1403h;

    /* renamed from: i */
    private byte f1404i;

    /* renamed from: j */
    private int f1405j;

    private C0394i(C0395j c0395j) {
        super(c0395j);
        this.f1404i = (byte) -1;
        this.f1405j = -1;
    }

    private C0394i(boolean z) {
        this.f1404i = (byte) -1;
        this.f1405j = -1;
    }

    /* renamed from: a */
    public static C0394i m2819a() {
        return f1396a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0394i getDefaultInstanceForType() {
        return f1396a;
    }

    /* renamed from: c */
    public boolean m2833c() {
        return (this.f1397b & 1) == 1;
    }

    /* renamed from: d */
    public long m2834d() {
        return this.f1398c;
    }

    /* renamed from: e */
    public boolean m2835e() {
        return (this.f1397b & 2) == 2;
    }

    /* renamed from: f */
    public String m2836f() {
        Object obj = this.f1399d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1399d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m2828q() {
        Object obj = this.f1399d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1399d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public List<C0283ag> m2837g() {
        return this.f1400e;
    }

    /* renamed from: h */
    public int m2838h() {
        return this.f1400e.size();
    }

    /* renamed from: a */
    public C0283ag m2831a(int i) {
        return this.f1400e.get(i);
    }

    /* renamed from: i */
    public List<String> m2839i() {
        return this.f1401f;
    }

    /* renamed from: j */
    public int m2840j() {
        return this.f1401f.size();
    }

    /* renamed from: k */
    public boolean m2841k() {
        return (this.f1397b & 4) == 4;
    }

    /* renamed from: l */
    public long m2842l() {
        return this.f1402g;
    }

    /* renamed from: m */
    public boolean m2843m() {
        return (this.f1397b & 8) == 8;
    }

    /* renamed from: n */
    public String m2844n() {
        Object obj = this.f1403h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1403h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m2829r() {
        Object obj = this.f1403h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1403h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: s */
    private void m2830s() {
        this.f1398c = 0L;
        this.f1399d = "";
        this.f1400e = Collections.emptyList();
        this.f1401f = LazyStringArrayList.EMPTY;
        this.f1402g = 0L;
        this.f1403h = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1404i;
        if (b != -1) {
            return b == 1;
        }
        this.f1404i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1397b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1398c);
        }
        if ((this.f1397b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2828q());
        }
        for (int i = 0; i < this.f1400e.size(); i++) {
            codedOutputStream.writeMessage(3, this.f1400e.get(i));
        }
        for (int i2 = 0; i2 < this.f1401f.size(); i2++) {
            codedOutputStream.writeBytes(4, this.f1401f.getByteString(i2));
        }
        if ((this.f1397b & 4) == 4) {
            codedOutputStream.writeInt64(5, this.f1402g);
        }
        if ((this.f1397b & 8) == 8) {
            codedOutputStream.writeBytes(6, m2829r());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f1405j;
        if (size == -1) {
            int iComputeInt64Size = (this.f1397b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1398c) + 0 : 0;
            if ((this.f1397b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m2828q());
            }
            int iComputeMessageSize = iComputeInt64Size;
            for (int i = 0; i < this.f1400e.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f1400e.get(i));
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f1401f.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1401f.getByteString(i2));
            }
            size = iComputeBytesSizeNoTag + iComputeMessageSize + (m2839i().size() * 1);
            if ((this.f1397b & 4) == 4) {
                size += CodedOutputStream.computeInt64Size(5, this.f1402g);
            }
            if ((this.f1397b & 8) == 8) {
                size += CodedOutputStream.computeBytesSize(6, m2829r());
            }
            this.f1405j = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0394i m2820a(byte[] bArr) {
        return ((C0395j) newBuilder().mergeFrom(bArr)).m2851i();
    }

    public static C0395j newBuilder() {
        return C0395j.m2850h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0395j newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0395j m2821a(C0394i c0394i) {
        return newBuilder().mergeFrom(c0394i);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0395j toBuilder() {
        return m2821a(this);
    }

    static {
        f1396a.m2830s();
    }
}
