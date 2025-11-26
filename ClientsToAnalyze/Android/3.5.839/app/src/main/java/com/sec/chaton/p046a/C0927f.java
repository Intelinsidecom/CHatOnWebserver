package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.f */
/* loaded from: classes.dex */
public final class C0927f extends GeneratedMessageLite implements InterfaceC0972h {

    /* renamed from: a */
    private static final C0927f f2900a = new C0927f(true);

    /* renamed from: b */
    private int f2901b;

    /* renamed from: c */
    private long f2902c;

    /* renamed from: d */
    private C0935fh f2903d;

    /* renamed from: e */
    private LazyStringList f2904e;

    /* renamed from: f */
    private Object f2905f;

    /* renamed from: g */
    private long f2906g;

    /* renamed from: h */
    private Object f2907h;

    /* renamed from: i */
    private Object f2908i;

    /* renamed from: j */
    private LazyStringList f2909j;

    /* renamed from: k */
    private long f2910k;

    /* renamed from: l */
    private long f2911l;

    /* renamed from: m */
    private byte f2912m;

    /* renamed from: n */
    private int f2913n;

    private C0927f(C0954g c0954g) {
        super(c0954g);
        this.f2912m = (byte) -1;
        this.f2913n = -1;
    }

    private C0927f(boolean z) {
        this.f2912m = (byte) -1;
        this.f2913n = -1;
    }

    /* renamed from: a */
    public static C0927f m5064a() {
        return f2900a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0927f getDefaultInstanceForType() {
        return f2900a;
    }

    /* renamed from: c */
    public boolean m5082c() {
        return (this.f2901b & 1) == 1;
    }

    /* renamed from: d */
    public long m5083d() {
        return this.f2902c;
    }

    /* renamed from: e */
    public boolean m5084e() {
        return (this.f2901b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m5085f() {
        return this.f2903d;
    }

    /* renamed from: g */
    public List<String> m5086g() {
        return this.f2904e;
    }

    /* renamed from: h */
    public int m5087h() {
        return this.f2904e.size();
    }

    /* renamed from: a */
    public String m5080a(int i) {
        return this.f2904e.get(i);
    }

    /* renamed from: i */
    public boolean m5088i() {
        return (this.f2901b & 4) == 4;
    }

    /* renamed from: j */
    public String m5089j() {
        Object obj = this.f2905f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2905f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m5077x() {
        Object obj = this.f2905f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2905f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m5090k() {
        return (this.f2901b & 8) == 8;
    }

    /* renamed from: l */
    public long m5091l() {
        return this.f2906g;
    }

    /* renamed from: m */
    public boolean m5092m() {
        return (this.f2901b & 16) == 16;
    }

    /* renamed from: n */
    public String m5093n() {
        Object obj = this.f2907h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2907h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m5078y() {
        Object obj = this.f2907h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2907h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m5094o() {
        return (this.f2901b & 32) == 32;
    }

    /* renamed from: p */
    public String m5095p() {
        Object obj = this.f2908i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2908i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m5079z() {
        Object obj = this.f2908i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2908i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public List<String> m5096q() {
        return this.f2909j;
    }

    /* renamed from: r */
    public boolean m5097r() {
        return (this.f2901b & 64) == 64;
    }

    /* renamed from: s */
    public long m5098s() {
        return this.f2910k;
    }

    /* renamed from: t */
    public boolean m5099t() {
        return (this.f2901b & 128) == 128;
    }

    /* renamed from: u */
    public long m5100u() {
        return this.f2911l;
    }

    /* renamed from: A */
    private void m5060A() {
        this.f2902c = 0L;
        this.f2903d = C0935fh.m5211a();
        this.f2904e = LazyStringArrayList.EMPTY;
        this.f2905f = "";
        this.f2906g = 0L;
        this.f2907h = "";
        this.f2908i = "";
        this.f2909j = LazyStringArrayList.EMPTY;
        this.f2910k = 0L;
        this.f2911l = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2912m;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2912m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2901b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2902c);
        }
        if ((this.f2901b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f2903d);
        }
        for (int i = 0; i < this.f2904e.size(); i++) {
            codedOutputStream.writeBytes(3, this.f2904e.getByteString(i));
        }
        if ((this.f2901b & 4) == 4) {
            codedOutputStream.writeBytes(4, m5077x());
        }
        if ((this.f2901b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f2906g);
        }
        if ((this.f2901b & 16) == 16) {
            codedOutputStream.writeBytes(6, m5078y());
        }
        if ((this.f2901b & 32) == 32) {
            codedOutputStream.writeBytes(7, m5079z());
        }
        for (int i2 = 0; i2 < this.f2909j.size(); i2++) {
            codedOutputStream.writeBytes(8, this.f2909j.getByteString(i2));
        }
        if ((this.f2901b & 64) == 64) {
            codedOutputStream.writeInt64(9, this.f2910k);
        }
        if ((this.f2901b & 128) == 128) {
            codedOutputStream.writeInt64(10, this.f2911l);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f2913n;
        if (size == -1) {
            int iComputeInt64Size = (this.f2901b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2902c) + 0 : 0;
            if ((this.f2901b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f2903d);
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f2904e.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2904e.getByteString(i));
            }
            int size2 = iComputeInt64Size + iComputeBytesSizeNoTag + (m5086g().size() * 1);
            if ((this.f2901b & 4) == 4) {
                size2 += CodedOutputStream.computeBytesSize(4, m5077x());
            }
            if ((this.f2901b & 8) == 8) {
                size2 += CodedOutputStream.computeInt64Size(5, this.f2906g);
            }
            if ((this.f2901b & 16) == 16) {
                size2 += CodedOutputStream.computeBytesSize(6, m5078y());
            }
            if ((this.f2901b & 32) == 32) {
                size2 += CodedOutputStream.computeBytesSize(7, m5079z());
            }
            int iComputeBytesSizeNoTag2 = 0;
            for (int i2 = 0; i2 < this.f2909j.size(); i2++) {
                iComputeBytesSizeNoTag2 += CodedOutputStream.computeBytesSizeNoTag(this.f2909j.getByteString(i2));
            }
            size = size2 + iComputeBytesSizeNoTag2 + (m5096q().size() * 1);
            if ((this.f2901b & 64) == 64) {
                size += CodedOutputStream.computeInt64Size(9, this.f2910k);
            }
            if ((this.f2901b & 128) == 128) {
                size += CodedOutputStream.computeInt64Size(10, this.f2911l);
            }
            this.f2913n = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0927f m5065a(byte[] bArr) {
        return ((C0954g) newBuilder().mergeFrom(bArr)).m5514k();
    }

    public static C0954g newBuilder() {
        return C0954g.m5513j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public C0954g newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0954g m5067a(C0927f c0927f) {
        return newBuilder().mergeFrom(c0927f);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0954g toBuilder() {
        return m5067a(this);
    }

    static {
        f2900a.m5060A();
    }
}
